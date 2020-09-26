/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ComposeShader
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.jaredrummler.android.colorpicker.AlphaPatternDrawable;
import com.jaredrummler.android.colorpicker.DrawingUtils;
import com.jaredrummler.android.colorpicker.R;

public class ColorPickerView
extends View {
    private static final int ALPHA_PANEL_HEIGH_DP = 20;
    private static final int BORDER_WIDTH_PX = 1;
    private static final int CIRCLE_TRACKER_RADIUS_DP = 5;
    private static final int DEFAULT_BORDER_COLOR = -9539986;
    private static final int DEFAULT_SLIDER_COLOR = -4342339;
    private static final int HUE_PANEL_WDITH_DP = 30;
    private static final int PANEL_SPACING_DP = 10;
    private static final int SLIDER_TRACKER_OFFSET_DP = 2;
    private static final int SLIDER_TRACKER_SIZE_DP = 4;
    private int alpha = 255;
    private Paint alphaPaint;
    private int alphaPanelHeightPx;
    private AlphaPatternDrawable alphaPatternDrawable;
    private Rect alphaRect;
    private Shader alphaShader;
    private String alphaSliderText = null;
    private Paint alphaTextPaint;
    private int borderColor = -9539986;
    private Paint borderPaint;
    private int circleTrackerRadiusPx;
    private Rect drawingRect;
    private float hue = 360.0f;
    private Paint hueAlphaTrackerPaint;
    private BitmapCache hueBackgroundCache;
    private int huePanelWidthPx;
    private Rect hueRect;
    private int mRequiredPadding;
    private OnColorChangedListener onColorChangedListener;
    private int panelSpacingPx;
    private float sat = 0.0f;
    private Shader satShader;
    private BitmapCache satValBackgroundCache;
    private Paint satValPaint;
    private Rect satValRect;
    private Paint satValTrackerPaint;
    private boolean showAlphaPanel = false;
    private int sliderTrackerColor = -4342339;
    private int sliderTrackerOffsetPx;
    private int sliderTrackerSizePx;
    private Point startTouchPoint = null;
    private float val = 0.0f;
    private Shader valShader;

    public ColorPickerView(Context context) {
        this(context, null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    private Point alphaToPoint(int n) {
        Rect rect = this.alphaRect;
        float f = rect.width();
        Point point = new Point();
        point.x = (int)(f - f * (float)n / 255.0f + (float)rect.left);
        point.y = rect.top;
        return point;
    }

    private void applyThemeColors(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
        if (this.borderColor == -9539986) {
            this.borderColor = typedArray.getColor(0, -9539986);
        }
        if (this.sliderTrackerColor == -4342339) {
            this.sliderTrackerColor = typedArray.getColor(0, -4342339);
        }
        typedArray.recycle();
    }

    private void drawAlphaPanel(Canvas canvas) {
        Rect rect;
        if (this.showAlphaPanel && (rect = this.alphaRect) != null) {
            if (this.alphaPatternDrawable == null) {
                return;
            }
            this.borderPaint.setColor(this.borderColor);
            canvas.drawRect((float)(rect.left - 1), (float)(rect.top - 1), (float)(1 + rect.right), (float)(1 + rect.bottom), this.borderPaint);
            this.alphaPatternDrawable.draw(canvas);
            float[] arrf = new float[]{this.hue, this.sat, this.val};
            int n = Color.HSVToColor((float[])arrf);
            int n2 = Color.HSVToColor((int)0, (float[])arrf);
            LinearGradient linearGradient = new LinearGradient((float)rect.left, (float)rect.top, (float)rect.right, (float)rect.top, n, n2, Shader.TileMode.CLAMP);
            this.alphaShader = linearGradient;
            this.alphaPaint.setShader((Shader)linearGradient);
            canvas.drawRect(rect, this.alphaPaint);
            String string2 = this.alphaSliderText;
            if (string2 != null && !string2.equals((Object)"")) {
                canvas.drawText(this.alphaSliderText, (float)rect.centerX(), (float)(rect.centerY() + DrawingUtils.dpToPx(this.getContext(), 4.0f)), this.alphaTextPaint);
            }
            Point point = this.alphaToPoint(this.alpha);
            RectF rectF = new RectF();
            rectF.left = point.x - this.sliderTrackerSizePx / 2;
            rectF.right = point.x + this.sliderTrackerSizePx / 2;
            rectF.top = rect.top - this.sliderTrackerOffsetPx;
            rectF.bottom = rect.bottom + this.sliderTrackerOffsetPx;
            canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.hueAlphaTrackerPaint);
        }
    }

    private void drawHuePanel(Canvas canvas) {
        Rect rect = this.hueRect;
        this.borderPaint.setColor(this.borderColor);
        canvas.drawRect((float)(rect.left - 1), (float)(rect.top - 1), (float)(1 + rect.right), (float)(1 + rect.bottom), this.borderPaint);
        if (this.hueBackgroundCache == null) {
            BitmapCache bitmapCache;
            this.hueBackgroundCache = bitmapCache = new BitmapCache();
            bitmapCache.bitmap = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            this.hueBackgroundCache.canvas = new Canvas(this.hueBackgroundCache.bitmap);
            int n = (int)(0.5f + (float)rect.height());
            int[] arrn = new int[n];
            int n2 = 0;
            float f = 360.0f;
            for (int i = 0; i < n; ++i) {
                arrn[i] = Color.HSVToColor((float[])new float[]{f, 1.0f, 1.0f});
                f -= 360.0f / (float)n;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            while (n2 < n) {
                paint.setColor(arrn[n2]);
                Canvas canvas2 = this.hueBackgroundCache.canvas;
                float f2 = n2;
                canvas2.drawLine(0.0f, f2, (float)this.hueBackgroundCache.bitmap.getWidth(), f2, paint);
                ++n2;
            }
        }
        canvas.drawBitmap(this.hueBackgroundCache.bitmap, null, rect, null);
        Point point = this.hueToPoint(this.hue);
        RectF rectF = new RectF();
        rectF.left = rect.left - this.sliderTrackerOffsetPx;
        rectF.right = rect.right + this.sliderTrackerOffsetPx;
        rectF.top = point.y - this.sliderTrackerSizePx / 2;
        rectF.bottom = point.y + this.sliderTrackerSizePx / 2;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.hueAlphaTrackerPaint);
    }

    private void drawSatValPanel(Canvas canvas) {
        BitmapCache bitmapCache;
        Rect rect = this.satValRect;
        this.borderPaint.setColor(this.borderColor);
        canvas.drawRect((float)this.drawingRect.left, (float)this.drawingRect.top, (float)(1 + rect.right), (float)(1 + rect.bottom), this.borderPaint);
        if (this.valShader == null) {
            LinearGradient linearGradient = new LinearGradient((float)rect.left, (float)rect.top, (float)rect.left, (float)rect.bottom, -1, -16777216, Shader.TileMode.CLAMP);
            this.valShader = linearGradient;
        }
        if ((bitmapCache = this.satValBackgroundCache) == null || bitmapCache.value != this.hue) {
            if (this.satValBackgroundCache == null) {
                this.satValBackgroundCache = new BitmapCache();
            }
            if (this.satValBackgroundCache.bitmap == null) {
                this.satValBackgroundCache.bitmap = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            }
            if (this.satValBackgroundCache.canvas == null) {
                this.satValBackgroundCache.canvas = new Canvas(this.satValBackgroundCache.bitmap);
            }
            float[] arrf = new float[]{this.hue, 1.0f, 1.0f};
            int n = Color.HSVToColor((float[])arrf);
            LinearGradient linearGradient = new LinearGradient((float)rect.left, (float)rect.top, (float)rect.right, (float)rect.top, -1, n, Shader.TileMode.CLAMP);
            this.satShader = linearGradient;
            ComposeShader composeShader = new ComposeShader(this.valShader, this.satShader, PorterDuff.Mode.MULTIPLY);
            this.satValPaint.setShader((Shader)composeShader);
            this.satValBackgroundCache.canvas.drawRect(0.0f, 0.0f, (float)this.satValBackgroundCache.bitmap.getWidth(), (float)this.satValBackgroundCache.bitmap.getHeight(), this.satValPaint);
            this.satValBackgroundCache.value = this.hue;
        }
        canvas.drawBitmap(this.satValBackgroundCache.bitmap, null, rect, null);
        Point point = this.satValToPoint(this.sat, this.val);
        this.satValTrackerPaint.setColor(-16777216);
        canvas.drawCircle((float)point.x, (float)point.y, (float)(this.circleTrackerRadiusPx - DrawingUtils.dpToPx(this.getContext(), 1.0f)), this.satValTrackerPaint);
        this.satValTrackerPaint.setColor(-2236963);
        canvas.drawCircle((float)point.x, (float)point.y, (float)this.circleTrackerRadiusPx, this.satValTrackerPaint);
    }

    private int getPreferredHeight() {
        int n = DrawingUtils.dpToPx(this.getContext(), 200.0f);
        if (this.showAlphaPanel) {
            n += this.panelSpacingPx + this.alphaPanelHeightPx;
        }
        return n;
    }

    private int getPreferredWidth() {
        return DrawingUtils.dpToPx(this.getContext(), 200.0f) + this.huePanelWidthPx + this.panelSpacingPx;
    }

    private Point hueToPoint(float f) {
        Rect rect = this.hueRect;
        float f2 = rect.height();
        Point point = new Point();
        point.y = (int)(f2 - f * f2 / 360.0f + (float)rect.top);
        point.x = rect.left;
        return point;
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPickerView);
        this.showAlphaPanel = typedArray.getBoolean(R.styleable.ColorPickerView_cpv_alphaChannelVisible, false);
        this.alphaSliderText = typedArray.getString(R.styleable.ColorPickerView_cpv_alphaChannelText);
        this.sliderTrackerColor = typedArray.getColor(R.styleable.ColorPickerView_cpv_sliderColor, -4342339);
        this.borderColor = typedArray.getColor(R.styleable.ColorPickerView_cpv_borderColor, -9539986);
        typedArray.recycle();
        this.applyThemeColors(context);
        this.huePanelWidthPx = DrawingUtils.dpToPx(this.getContext(), 30.0f);
        this.alphaPanelHeightPx = DrawingUtils.dpToPx(this.getContext(), 20.0f);
        this.panelSpacingPx = DrawingUtils.dpToPx(this.getContext(), 10.0f);
        this.circleTrackerRadiusPx = DrawingUtils.dpToPx(this.getContext(), 5.0f);
        this.sliderTrackerSizePx = DrawingUtils.dpToPx(this.getContext(), 4.0f);
        this.sliderTrackerOffsetPx = DrawingUtils.dpToPx(this.getContext(), 2.0f);
        this.mRequiredPadding = this.getResources().getDimensionPixelSize(R.dimen.cpv_required_padding);
        this.initPaintTools();
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    private void initPaintTools() {
        this.satValPaint = new Paint();
        this.satValTrackerPaint = new Paint();
        this.hueAlphaTrackerPaint = new Paint();
        this.alphaPaint = new Paint();
        this.alphaTextPaint = new Paint();
        this.borderPaint = new Paint();
        this.satValTrackerPaint.setStyle(Paint.Style.STROKE);
        this.satValTrackerPaint.setStrokeWidth((float)DrawingUtils.dpToPx(this.getContext(), 2.0f));
        this.satValTrackerPaint.setAntiAlias(true);
        this.hueAlphaTrackerPaint.setColor(this.sliderTrackerColor);
        this.hueAlphaTrackerPaint.setStyle(Paint.Style.STROKE);
        this.hueAlphaTrackerPaint.setStrokeWidth((float)DrawingUtils.dpToPx(this.getContext(), 2.0f));
        this.hueAlphaTrackerPaint.setAntiAlias(true);
        this.alphaTextPaint.setColor(-14935012);
        this.alphaTextPaint.setTextSize((float)DrawingUtils.dpToPx(this.getContext(), 14.0f));
        this.alphaTextPaint.setAntiAlias(true);
        this.alphaTextPaint.setTextAlign(Paint.Align.CENTER);
        this.alphaTextPaint.setFakeBoldText(true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean moveTrackersIfNeeded(MotionEvent motionEvent) {
        Point point = this.startTouchPoint;
        if (point == null) {
            return false;
        }
        int n = point.x;
        int n2 = this.startTouchPoint.y;
        if (this.hueRect.contains(n, n2)) {
            this.hue = this.pointToHue(motionEvent.getY());
            do {
                return true;
                break;
            } while (true);
        }
        if (this.satValRect.contains(n, n2)) {
            float[] arrf = this.pointToSatVal(motionEvent.getX(), motionEvent.getY());
            this.sat = arrf[0];
            this.val = arrf[1];
            return true;
        }
        Rect rect = this.alphaRect;
        if (rect == null || !rect.contains(n, n2)) return false;
        this.alpha = this.pointToAlpha((int)motionEvent.getX());
        return true;
    }

    private int pointToAlpha(int n) {
        Rect rect = this.alphaRect;
        int n2 = rect.width();
        int n3 = n < rect.left ? 0 : (n > rect.right ? n2 : n - rect.left);
        return 255 - n3 * 255 / n2;
    }

    private float pointToHue(float f) {
        Rect rect = this.hueRect;
        float f2 = rect.height();
        float f3 = f < (float)rect.top ? 0.0f : (f > (float)rect.bottom ? f2 : f - (float)rect.top);
        return 360.0f - f3 * 360.0f / f2;
    }

    private float[] pointToSatVal(float f, float f2) {
        Rect rect = this.satValRect;
        float[] arrf = new float[2];
        float f3 = rect.width();
        float f4 = rect.height();
        float f5 = f < (float)rect.left ? 0.0f : (f > (float)rect.right ? f3 : f - (float)rect.left);
        float f6 = f2 < (float)rect.top ? 0.0f : (f2 > (float)rect.bottom ? f4 : f2 - (float)rect.top);
        arrf[0] = f5 * (1.0f / f3);
        arrf[1] = 1.0f - f6 * (1.0f / f4);
        return arrf;
    }

    private Point satValToPoint(float f, float f2) {
        Rect rect = this.satValRect;
        float f3 = rect.height();
        float f4 = rect.width();
        Point point = new Point();
        point.x = (int)(f * f4 + (float)rect.left);
        point.y = (int)(f3 * (1.0f - f2) + (float)rect.top);
        return point;
    }

    private void setUpAlphaRect() {
        AlphaPatternDrawable alphaPatternDrawable;
        if (!this.showAlphaPanel) {
            return;
        }
        Rect rect = this.drawingRect;
        int n = 1 + rect.left;
        int n2 = 1 + (rect.bottom - this.alphaPanelHeightPx);
        int n3 = -1 + rect.bottom;
        this.alphaRect = new Rect(n, n2, -1 + rect.right, n3);
        this.alphaPatternDrawable = alphaPatternDrawable = new AlphaPatternDrawable(DrawingUtils.dpToPx(this.getContext(), 4.0f));
        alphaPatternDrawable.setBounds(Math.round((float)this.alphaRect.left), Math.round((float)this.alphaRect.top), Math.round((float)this.alphaRect.right), Math.round((float)this.alphaRect.bottom));
    }

    private void setUpHueRect() {
        Rect rect = this.drawingRect;
        int n = 1 + (rect.right - this.huePanelWidthPx);
        int n2 = 1 + rect.top;
        int n3 = -1 + rect.bottom;
        int n4 = this.showAlphaPanel ? this.panelSpacingPx + this.alphaPanelHeightPx : 0;
        int n5 = n3 - n4;
        this.hueRect = new Rect(n, n2, -1 + rect.right, n5);
    }

    private void setUpSatValRect() {
        Rect rect = this.drawingRect;
        int n = 1 + rect.left;
        int n2 = 1 + rect.top;
        int n3 = -1 + rect.bottom;
        int n4 = -1 + rect.right;
        int n5 = this.panelSpacingPx;
        int n6 = n4 - n5 - this.huePanelWidthPx;
        if (this.showAlphaPanel) {
            n3 -= n5 + this.alphaPanelHeightPx;
        }
        this.satValRect = new Rect(n, n2, n6, n3);
    }

    public String getAlphaSliderText() {
        return this.alphaSliderText;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public int getColor() {
        int n = this.alpha;
        float[] arrf = new float[]{this.hue, this.sat, this.val};
        return Color.HSVToColor((int)n, (float[])arrf);
    }

    public int getPaddingBottom() {
        return Math.max((int)super.getPaddingBottom(), (int)this.mRequiredPadding);
    }

    public int getPaddingLeft() {
        return Math.max((int)super.getPaddingLeft(), (int)this.mRequiredPadding);
    }

    public int getPaddingRight() {
        return Math.max((int)super.getPaddingRight(), (int)this.mRequiredPadding);
    }

    public int getPaddingTop() {
        return Math.max((int)super.getPaddingTop(), (int)this.mRequiredPadding);
    }

    public int getSliderTrackerColor() {
        return this.sliderTrackerColor;
    }

    protected void onDraw(Canvas canvas) {
        if (this.drawingRect.width() > 0) {
            if (this.drawingRect.height() <= 0) {
                return;
            }
            this.drawSatValPanel(canvas);
            this.drawHuePanel(canvas);
            this.drawAlphaPanel(canvas);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        block15 : {
            int n5;
            block14 : {
                int n6;
                int n7;
                block16 : {
                    block12 : {
                        int n8;
                        block13 : {
                            n7 = MeasureSpec.getMode((int)n);
                            n6 = MeasureSpec.getMode((int)n2);
                            n3 = MeasureSpec.getSize((int)n) - this.getPaddingLeft() - this.getPaddingRight();
                            n4 = MeasureSpec.getSize((int)n2) - this.getPaddingBottom() - this.getPaddingTop();
                            if (n7 == 1073741824 || n6 == 1073741824) break block12;
                            int n9 = this.panelSpacingPx;
                            int n10 = n4 + n9;
                            int n11 = this.huePanelWidthPx;
                            n5 = n10 + n11;
                            n8 = n3 - n9 - n11;
                            if (this.showAlphaPanel) {
                                int n12 = this.alphaPanelHeightPx;
                                n5 -= n9 + n12;
                                n8 += n9 + n12;
                            }
                            boolean bl = true;
                            boolean bl2 = n5 <= n3;
                            if (n8 > n4) {
                                bl = false;
                            }
                            if (bl2 && bl) break block13;
                            if (!bl && bl2) break block14;
                            if (bl2 || !bl) break block15;
                        }
                        n4 = n8;
                        break block15;
                    }
                    if (n7 != 1073741824 || n6 == 1073741824) break block16;
                    int n13 = this.panelSpacingPx;
                    int n14 = n3 - n13 - this.huePanelWidthPx;
                    if (this.showAlphaPanel) {
                        n14 += n13 + this.alphaPanelHeightPx;
                    }
                    if (n14 <= n4) {
                        n4 = n14;
                    }
                    break block15;
                }
                if (n6 != 1073741824 || n7 == 1073741824) break block15;
                int n15 = this.panelSpacingPx;
                n5 = n4 + n15 + this.huePanelWidthPx;
                if (this.showAlphaPanel) {
                    n5 -= n15 + this.alphaPanelHeightPx;
                }
                if (n5 > n3) break block15;
            }
            n3 = n5;
        }
        this.setMeasuredDimension(n3 + this.getPaddingLeft() + this.getPaddingRight(), n4 + this.getPaddingTop() + this.getPaddingBottom());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.alpha = bundle.getInt("alpha");
            this.hue = bundle.getFloat("hue");
            this.sat = bundle.getFloat("sat");
            this.val = bundle.getFloat("val");
            this.showAlphaPanel = bundle.getBoolean("show_alpha");
            this.alphaSliderText = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("alpha", this.alpha);
        bundle.putFloat("hue", this.hue);
        bundle.putFloat("sat", this.sat);
        bundle.putFloat("val", this.val);
        bundle.putBoolean("show_alpha", this.showAlphaPanel);
        bundle.putString("alpha_text", this.alphaSliderText);
        return bundle;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        Rect rect;
        super.onSizeChanged(n, n2, n3, n4);
        this.drawingRect = rect = new Rect();
        rect.left = this.getPaddingLeft();
        this.drawingRect.right = n - this.getPaddingRight();
        this.drawingRect.top = this.getPaddingTop();
        this.drawingRect.bottom = n2 - this.getPaddingBottom();
        this.valShader = null;
        this.satShader = null;
        this.alphaShader = null;
        this.satValBackgroundCache = null;
        this.hueBackgroundCache = null;
        this.setUpSatValRect();
        this.setUpHueRect();
        this.setUpAlphaRect();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl;
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                bl = n != 2 ? false : this.moveTrackersIfNeeded(motionEvent);
            } else {
                this.startTouchPoint = null;
                bl = this.moveTrackersIfNeeded(motionEvent);
            }
        } else {
            this.startTouchPoint = new Point((int)motionEvent.getX(), (int)motionEvent.getY());
            bl = this.moveTrackersIfNeeded(motionEvent);
        }
        if (bl) {
            OnColorChangedListener onColorChangedListener = this.onColorChangedListener;
            if (onColorChangedListener != null) {
                int n2 = this.alpha;
                float[] arrf = new float[]{this.hue, this.sat, this.val};
                onColorChangedListener.onColorChanged(Color.HSVToColor((int)n2, (float[])arrf));
            }
            this.invalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlphaSliderText(int n) {
        this.setAlphaSliderText(this.getContext().getString(n));
    }

    public void setAlphaSliderText(String string2) {
        this.alphaSliderText = string2;
        this.invalidate();
    }

    public void setAlphaSliderVisible(boolean bl) {
        if (this.showAlphaPanel != bl) {
            this.showAlphaPanel = bl;
            this.valShader = null;
            this.satShader = null;
            this.alphaShader = null;
            this.hueBackgroundCache = null;
            this.satValBackgroundCache = null;
            this.requestLayout();
        }
    }

    public void setBorderColor(int n) {
        this.borderColor = n;
        this.invalidate();
    }

    public void setColor(int n) {
        this.setColor(n, false);
    }

    public void setColor(int n, boolean bl) {
        OnColorChangedListener onColorChangedListener;
        float f;
        float f2;
        float f3;
        int n2 = Color.alpha((int)n);
        int n3 = Color.red((int)n);
        int n4 = Color.blue((int)n);
        int n5 = Color.green((int)n);
        float[] arrf = new float[3];
        Color.RGBToHSV((int)n3, (int)n5, (int)n4, (float[])arrf);
        this.alpha = n2;
        this.hue = f2 = arrf[0];
        this.sat = f = arrf[1];
        this.val = f3 = arrf[2];
        if (bl && (onColorChangedListener = this.onColorChangedListener) != null) {
            onColorChangedListener.onColorChanged(Color.HSVToColor((int)n2, (float[])new float[]{f2, f, f3}));
        }
        this.invalidate();
    }

    public void setOnColorChangedListener(OnColorChangedListener onColorChangedListener) {
        this.onColorChangedListener = onColorChangedListener;
    }

    public void setSliderTrackerColor(int n) {
        this.sliderTrackerColor = n;
        this.hueAlphaTrackerPaint.setColor(n);
        this.invalidate();
    }

    private class BitmapCache {
        public Bitmap bitmap;
        public Canvas canvas;
        public float value;

        private BitmapCache() {
        }
    }

    public static interface OnColorChangedListener {
        public void onColorChanged(int var1);
    }

}

