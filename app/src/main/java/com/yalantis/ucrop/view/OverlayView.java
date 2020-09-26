/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Math
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;

public class OverlayView
extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath = new Path();
    private Paint mCropFrameCornersPaint = new Paint(1);
    private Paint mCropFramePaint = new Paint(1);
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint = new Paint(1);
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
    private int mCropRectMinSize = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
    private final RectF mCropViewRect = new RectF();
    private int mCurrentTouchCornerIndex = -1;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint = new Paint(1);
    private int mFreestyleCropMode = 0;
    private float[] mGridPoints = null;
    private float mPreviousTouchX = -1.0f;
    private float mPreviousTouchY = -1.0f;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect = new RectF();
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private int getCurrentTouchIndex(float f, float f2) {
        double d = this.mTouchPointThreshold;
        int n = -1;
        for (int i = 0; i < 8; i += 2) {
            double d2 = Math.sqrt((double)(Math.pow((double)(f - this.mCropGridCorners[i]), (double)2.0) + Math.pow((double)(f2 - this.mCropGridCorners[i + 1]), (double)2.0)));
            if (!(d2 < d)) continue;
            n = i / 2;
            d = d2;
        }
        if (this.mFreestyleCropMode == 1 && n < 0 && this.mCropViewRect.contains(f, f2)) {
            return 4;
        }
        return n;
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int n = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int n2 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, this.getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float)n);
        this.mCropFramePaint.setColor(n2);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float)(n * 3));
        this.mCropFrameCornersPaint.setColor(n2);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int n = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int n2 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, this.getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float)n);
        this.mCropGridPaint.setColor(n2);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        int n = this.mCurrentTouchCornerIndex;
        int n2 = 1;
        if (n != 0) {
            if (n != n2) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                            if (this.mTempRect.left > (float)this.getLeft() && this.mTempRect.top > (float)this.getTop() && this.mTempRect.right < (float)this.getRight() && this.mTempRect.bottom < (float)this.getBottom()) {
                                this.mCropViewRect.set(this.mTempRect);
                                this.updateGridPoints();
                                this.postInvalidate();
                            }
                            return;
                        }
                    } else {
                        this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                    }
                } else {
                    this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                }
            } else {
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
            }
        } else {
            this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
        }
        boolean bl = this.mTempRect.height() >= (float)this.mCropRectMinSize;
        if (!(this.mTempRect.width() >= (float)this.mCropRectMinSize)) {
            n2 = 0;
        }
        RectF rectF = this.mCropViewRect;
        float f3 = n2 != 0 ? this.mTempRect.left : rectF.left;
        RectF rectF2 = bl ? this.mTempRect : this.mCropViewRect;
        float f4 = rectF2.top;
        RectF rectF3 = n2 != 0 ? this.mTempRect : this.mCropViewRect;
        float f5 = rectF3.right;
        RectF rectF4 = bl ? this.mTempRect : this.mCropViewRect;
        rectF.set(f3, f4, f5, rectF4.bottom);
        if (bl || n2 != 0) {
            this.updateGridPoints();
            this.postInvalidate();
        }
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min((float)this.mCropViewRect.width(), (float)this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    protected void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            float[] arrf;
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[4 * this.mCropGridRowCount + 4 * this.mCropGridColumnCount];
                int n = 0;
                int n2 = 0;
                do {
                    int n3 = this.mCropGridRowCount;
                    if (n >= n3) break;
                    float[] arrf2 = this.mGridPoints;
                    int n4 = n2 + 1;
                    arrf2[n2] = this.mCropViewRect.left;
                    float[] arrf3 = this.mGridPoints;
                    int n5 = n4 + 1;
                    float f = this.mCropViewRect.height();
                    float f2 = 1.0f + (float)n;
                    arrf3[n4] = f * (f2 / (float)(1 + this.mCropGridRowCount)) + this.mCropViewRect.top;
                    float[] arrf4 = this.mGridPoints;
                    int n6 = n5 + 1;
                    arrf4[n5] = this.mCropViewRect.right;
                    float[] arrf5 = this.mGridPoints;
                    int n7 = n6 + 1;
                    arrf5[n6] = this.mCropViewRect.height() * (f2 / (float)(1 + this.mCropGridRowCount)) + this.mCropViewRect.top;
                    ++n;
                    n2 = n7;
                } while (true);
                for (int i = 0; i < this.mCropGridColumnCount; ++i) {
                    float[] arrf6 = this.mGridPoints;
                    int n8 = n2 + 1;
                    float f = this.mCropViewRect.width();
                    float f3 = 1.0f + (float)i;
                    arrf6[n2] = f * (f3 / (float)(1 + this.mCropGridColumnCount)) + this.mCropViewRect.left;
                    float[] arrf7 = this.mGridPoints;
                    int n9 = n8 + 1;
                    arrf7[n8] = this.mCropViewRect.top;
                    float[] arrf8 = this.mGridPoints;
                    int n10 = n9 + 1;
                    arrf8[n9] = this.mCropViewRect.width() * (f3 / (float)(1 + this.mCropGridColumnCount)) + this.mCropViewRect.left;
                    float[] arrf9 = this.mGridPoints;
                    n2 = n10 + 1;
                    arrf9[n10] = this.mCropViewRect.bottom;
                }
            }
            if ((arrf = this.mGridPoints) != null) {
                canvas.drawLines(arrf, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF = this.mTempRect;
            int n = this.mCropRectCornerTouchAreaLineLength;
            rectF.inset((float)n, (float)(-n));
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF2 = this.mTempRect;
            int n11 = this.mCropRectCornerTouchAreaLineLength;
            rectF2.inset((float)(-n11), (float)n11);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    protected void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min((float)this.mCropViewRect.width(), (float)this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    protected void init() {
        if (Build.VERSION.SDK_INT < 18) {
            this.setLayerType(1, null);
        }
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawDimmedLayer(canvas);
        this.drawCropGrid(canvas);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (bl) {
            int n5 = this.getPaddingLeft();
            int n6 = this.getPaddingTop();
            int n7 = this.getWidth() - this.getPaddingRight();
            int n8 = this.getHeight() - this.getPaddingBottom();
            this.mThisWidth = n7 - n5;
            this.mThisHeight = n8 - n6;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                this.setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCropViewRect.isEmpty()) {
            if (this.mFreestyleCropMode == 0) {
                return false;
            }
            float f = motionEvent.getX();
            float f2 = motionEvent.getY();
            if ((255 & motionEvent.getAction()) == 0) {
                int n;
                this.mCurrentTouchCornerIndex = n = this.getCurrentTouchIndex(f, f2);
                boolean bl = false;
                if (n != -1) {
                    bl = true;
                }
                if (!bl) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                    return bl;
                }
                if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = f;
                    this.mPreviousTouchY = f2;
                }
                return bl;
            }
            if ((255 & motionEvent.getAction()) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float f3 = Math.min((float)Math.max((float)f, (float)this.getPaddingLeft()), (float)(this.getWidth() - this.getPaddingRight()));
                float f4 = Math.min((float)Math.max((float)f2, (float)this.getPaddingTop()), (float)(this.getHeight() - this.getPaddingBottom()));
                this.updateCropViewRect(f3, f4);
                this.mPreviousTouchX = f3;
                this.mPreviousTouchY = f4;
                return true;
            }
            if ((255 & motionEvent.getAction()) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
            }
        }
        return false;
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        int n;
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = n = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, this.getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(n);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        this.initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        this.initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean bl) {
        this.mCircleDimmedLayer = bl;
    }

    public void setCropFrameColor(int n) {
        this.mCropFramePaint.setColor(n);
    }

    public void setCropFrameStrokeWidth(int n) {
        this.mCropFramePaint.setStrokeWidth((float)n);
    }

    public void setCropGridColor(int n) {
        this.mCropGridPaint.setColor(n);
    }

    public void setCropGridColumnCount(int n) {
        this.mCropGridColumnCount = n;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int n) {
        this.mCropGridRowCount = n;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int n) {
        this.mCropGridPaint.setStrokeWidth((float)n);
    }

    public void setDimmedColor(int n) {
        this.mDimmedColor = n;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean bl) {
        this.mFreestyleCropMode = bl ? 1 : 0;
    }

    public void setFreestyleCropMode(int n) {
        this.mFreestyleCropMode = n;
        this.postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean bl) {
        this.mShowCropFrame = bl;
    }

    public void setShowCropGrid(boolean bl) {
        this.mShowCropGrid = bl;
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            this.setupCropBounds();
            this.postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int n = this.mThisWidth;
        float f = n;
        float f2 = this.mTargetAspectRatio;
        int n2 = (int)(f / f2);
        int n3 = this.mThisHeight;
        if (n2 > n3) {
            int n4 = (int)(f2 * (float)n3);
            int n5 = (n - n4) / 2;
            this.mCropViewRect.set((float)(n5 + this.getPaddingLeft()), (float)this.getPaddingTop(), (float)(n5 + (n4 + this.getPaddingLeft())), (float)(this.getPaddingTop() + this.mThisHeight));
        } else {
            int n6 = (n3 - n2) / 2;
            this.mCropViewRect.set((float)this.getPaddingLeft(), (float)(n6 + this.getPaddingTop()), (float)(this.getPaddingLeft() + this.mThisWidth), (float)(n6 + (n2 + this.getPaddingTop())));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        this.updateGridPoints();
    }
}

