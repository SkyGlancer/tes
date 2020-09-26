/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.util.AttributeSet
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView
extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect = new RectF();
    private long mImageToWrapCropBoundsAnimDuration = 500L;
    private int mMaxResultImageSizeX = 0;
    private int mMaxResultImageSizeY = 0;
    private float mMaxScale;
    private float mMaxScaleMultiplier = 10.0f;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix = new Matrix();
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable = null;

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        float[] arrf = Arrays.copyOf((float[])this.mCurrentImageCorners, (int)this.mCurrentImageCorners.length);
        float[] arrf2 = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(arrf);
        this.mTempMatrix.mapPoints(arrf2);
        RectF rectF = RectUtils.trapToRect(arrf);
        RectF rectF2 = RectUtils.trapToRect(arrf2);
        float f = rectF.left - rectF2.left;
        float f2 = rectF.top - rectF2.top;
        float f3 = rectF.right - rectF2.right;
        float f4 = rectF.bottom - rectF2.bottom;
        float[] arrf3 = new float[4];
        if (!(f > 0.0f)) {
            f = 0.0f;
        }
        arrf3[0] = f;
        if (!(f2 > 0.0f)) {
            f2 = 0.0f;
        }
        arrf3[1] = f2;
        if (!(f3 < 0.0f)) {
            f3 = 0.0f;
        }
        arrf3[2] = f3;
        if (!(f4 < 0.0f)) {
            f4 = 0.0f;
        }
        arrf3[3] = f4;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(this.getCurrentAngle());
        this.mTempMatrix.mapPoints(arrf3);
        return arrf3;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        this.calculateImageScaleBounds(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
    }

    private void calculateImageScaleBounds(float f, float f2) {
        float f3;
        this.mMinScale = f3 = Math.min((float)Math.min((float)(this.mCropRect.width() / f), (float)(this.mCropRect.width() / f2)), (float)Math.min((float)(this.mCropRect.height() / f2), (float)(this.mCropRect.height() / f)));
        this.mMaxScale = f3 * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f, float f2) {
        float f3 = this.mCropRect.width();
        float f4 = this.mCropRect.height();
        float f5 = Math.max((float)(this.mCropRect.width() / f), (float)(this.mCropRect.height() / f2));
        float f6 = (f3 - f * f5) / 2.0f + this.mCropRect.left;
        float f7 = (f4 - f2 * f5) / 2.0f + this.mCropRect.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(f5, f5);
        this.mCurrentImageMatrix.postTranslate(f6, f7);
        this.setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        this.removeCallbacks(this.mWrapCropBoundsRunnable);
        this.removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int n, BitmapCropCallback bitmapCropCallback) {
        this.cancelAllAnimations();
        this.setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), this.getCurrentScale(), this.getCurrentAngle());
        CropParameters cropParameters = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, n, this.getImageInputPath(), this.getImageOutputPath(), this.getExifInfo());
        BitmapCropTask bitmapCropTask = new BitmapCropTask(this.getContext(), this.getViewBitmap(), imageState, cropParameters, bitmapCropCallback);
        bitmapCropTask.execute((Object[])new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    protected boolean isImageWrapCropBounds() {
        return this.isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    protected boolean isImageWrapCropBounds(float[] arrf) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        float[] arrf2 = Arrays.copyOf((float[])arrf, (int)arrf.length);
        this.mTempMatrix.mapPoints(arrf2);
        float[] arrf3 = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(arrf3);
        return RectUtils.trapToRect(arrf2).contains(RectUtils.trapToRect(arrf3));
    }

    @Override
    protected void onImageLaidOut() {
        int n;
        super.onImageLaidOut();
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        float f = drawable2.getIntrinsicWidth();
        float f2 = drawable2.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = f / f2;
        }
        if ((n = (int)((float)this.mThisWidth / this.mTargetAspectRatio)) > this.mThisHeight) {
            int n2 = (int)((float)this.mThisHeight * this.mTargetAspectRatio);
            int n3 = (this.mThisWidth - n2) / 2;
            this.mCropRect.set((float)n3, 0.0f, (float)(n2 + n3), (float)this.mThisHeight);
        } else {
            int n4 = (this.mThisHeight - n) / 2;
            this.mCropRect.set(0.0f, (float)n4, (float)this.mThisWidth, (float)(n + n4));
        }
        this.calculateImageScaleBounds(f, f2);
        this.setupInitialImagePosition(f, f2);
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        if (this.mTransformImageListener != null) {
            this.mTransformImageListener.onScale(this.getCurrentScale());
            this.mTransformImageListener.onRotate(this.getCurrentAngle());
        }
    }

    public void postRotate(float f) {
        this.postRotate(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    @Override
    public void postScale(float f, float f2, float f3) {
        if (f > 1.0f && f * this.getCurrentScale() <= this.getMaxScale()) {
            super.postScale(f, f2, f3);
            return;
        }
        if (f < 1.0f && f * this.getCurrentScale() >= this.getMinScale()) {
            super.postScale(f, f2, f3);
        }
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        float f = Math.abs((float)typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float f2 = Math.abs((float)typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (f != 0.0f && f2 != 0.0f) {
            this.mTargetAspectRatio = f / f2;
            return;
        }
        this.mTargetAspectRatio = 0.0f;
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - (float)this.getPaddingLeft(), rectF.top - (float)this.getPaddingTop(), rectF.right - (float)this.getPaddingRight(), rectF.bottom - (float)this.getPaddingBottom());
        this.calculateImageScaleBounds();
        this.setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        this.setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean bl) {
        if (this.mBitmapLaidOut && !this.isImageWrapCropBounds()) {
            float f;
            float f2;
            float f3;
            float f4 = this.mCurrentImageCenter[0];
            float f5 = this.mCurrentImageCenter[1];
            float f6 = this.getCurrentScale();
            float f7 = this.mCropRect.centerX() - f4;
            float f8 = this.mCropRect.centerY() - f5;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(f7, f8);
            float[] arrf = Arrays.copyOf((float[])this.mCurrentImageCorners, (int)this.mCurrentImageCorners.length);
            this.mTempMatrix.mapPoints(arrf);
            boolean bl2 = this.isImageWrapCropBounds(arrf);
            if (bl2) {
                float[] arrf2 = this.calculateImageIndents();
                float f9 = -(arrf2[0] + arrf2[2]);
                f2 = -(arrf2[1] + arrf2[3]);
                f = f9;
                f3 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(this.getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                float[] arrf3 = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
                float f10 = f6 * Math.max((float)(rectF.width() / arrf3[0]), (float)(rectF.height() / arrf3[1])) - f6;
                f = f7;
                f3 = f10;
                f2 = f8;
            }
            if (bl) {
                Runnable runnable;
                this.mWrapCropBoundsRunnable = runnable = new Runnable(this, this.mImageToWrapCropBoundsAnimDuration, f4, f5, f, f2, f6, f3, bl2){
                    private final float mCenterDiffX;
                    private final float mCenterDiffY;
                    private final WeakReference<CropImageView> mCropImageView;
                    private final float mDeltaScale;
                    private final long mDurationMs;
                    private final float mOldScale;
                    private final float mOldX;
                    private final float mOldY;
                    private final long mStartTime;
                    private final boolean mWillBeImageInBoundsAfterTranslate;
                    {
                        this.mCropImageView = new WeakReference((Object)cropImageView);
                        this.mDurationMs = l;
                        this.mStartTime = System.currentTimeMillis();
                        this.mOldX = f;
                        this.mOldY = f2;
                        this.mCenterDiffX = f3;
                        this.mCenterDiffY = f4;
                        this.mOldScale = f5;
                        this.mDeltaScale = f6;
                        this.mWillBeImageInBoundsAfterTranslate = bl;
                    }

                    public void run() {
                        CropImageView cropImageView = (CropImageView)((Object)this.mCropImageView.get());
                        if (cropImageView == null) {
                            return;
                        }
                        long l = System.currentTimeMillis();
                        float f = Math.min((long)this.mDurationMs, (long)(l - this.mStartTime));
                        float f2 = CubicEasing.easeOut(f, 0.0f, this.mCenterDiffX, this.mDurationMs);
                        float f3 = CubicEasing.easeOut(f, 0.0f, this.mCenterDiffY, this.mDurationMs);
                        float f4 = CubicEasing.easeInOut(f, 0.0f, this.mDeltaScale, this.mDurationMs);
                        if (f < (float)this.mDurationMs) {
                            cropImageView.postTranslate(f2 - (cropImageView.mCurrentImageCenter[0] - this.mOldX), f3 - (cropImageView.mCurrentImageCenter[1] - this.mOldY));
                            if (!this.mWillBeImageInBoundsAfterTranslate) {
                                cropImageView.zoomInImage(f4 + this.mOldScale, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                            }
                            if (!cropImageView.isImageWrapCropBounds()) {
                                cropImageView.post((Runnable)this);
                            }
                        }
                    }
                };
                this.post(runnable);
                return;
            }
            this.postTranslate(f, f2);
            if (!bl2) {
                this.zoomInImage(f6 + f3, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long l) {
        if (l > 0L) {
            this.mImageToWrapCropBoundsAnimDuration = l;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int n) {
        this.mMaxResultImageSizeX = n;
    }

    public void setMaxResultImageSizeY(int n) {
        this.mMaxResultImageSizeY = n;
    }

    public void setMaxScaleMultiplier(float f) {
        this.mMaxScaleMultiplier = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            this.mTargetAspectRatio = f;
            return;
        }
        this.mTargetAspectRatio = f == 0.0f ? (float)drawable2.getIntrinsicWidth() / (float)drawable2.getIntrinsicHeight() : f;
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    protected void zoomImageToPosition(float f, float f2, float f3, long l) {
        Runnable runnable;
        if (f > this.getMaxScale()) {
            f = this.getMaxScale();
        }
        float f4 = this.getCurrentScale();
        float f5 = f - f4;
        this.mZoomImageToPositionRunnable = runnable = new Runnable(this, l, f4, f5, f2, f3){
            private final WeakReference<CropImageView> mCropImageView;
            private final float mDeltaScale;
            private final float mDestX;
            private final float mDestY;
            private final long mDurationMs;
            private final float mOldScale;
            private final long mStartTime;
            {
                this.mCropImageView = new WeakReference((Object)cropImageView);
                this.mStartTime = System.currentTimeMillis();
                this.mDurationMs = l;
                this.mOldScale = f;
                this.mDeltaScale = f2;
                this.mDestX = f3;
                this.mDestY = f4;
            }

            public void run() {
                CropImageView cropImageView = (CropImageView)((Object)this.mCropImageView.get());
                if (cropImageView == null) {
                    return;
                }
                long l = System.currentTimeMillis();
                float f = Math.min((long)this.mDurationMs, (long)(l - this.mStartTime));
                float f2 = CubicEasing.easeInOut(f, 0.0f, this.mDeltaScale, this.mDurationMs);
                if (f < (float)this.mDurationMs) {
                    cropImageView.zoomInImage(f2 + this.mOldScale, this.mDestX, this.mDestY);
                    cropImageView.post((Runnable)this);
                    return;
                }
                cropImageView.setImageToWrapCropBounds();
            }
        };
        this.post(runnable);
    }

    public void zoomInImage(float f) {
        this.zoomInImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f, float f2, float f3) {
        if (f <= this.getMaxScale()) {
            this.postScale(f / this.getCurrentScale(), f2, f3);
        }
    }

    public void zoomOutImage(float f) {
        this.zoomOutImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f, float f2, float f3) {
        if (f >= this.getMinScale()) {
            this.postScale(f / this.getCurrentScale(), f2, f3);
        }
    }

}

