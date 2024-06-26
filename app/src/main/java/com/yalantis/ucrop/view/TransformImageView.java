/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.yalantis.ucrop.view.TransformImageView$1
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;

public class TransformImageView
extends ImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final String TAG = "TransformImageView";
    protected boolean mBitmapDecoded = false;
    protected boolean mBitmapLaidOut = false;
    protected final float[] mCurrentImageCenter = new float[2];
    protected final float[] mCurrentImageCorners = new float[8];
    protected Matrix mCurrentImageMatrix = new Matrix();
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues = new float[9];
    private int mMaxBitmapSize = 0;
    protected int mThisHeight;
    protected int mThisWidth;
    protected TransformImageListener mTransformImageListener;

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    static /* synthetic */ String access$002(TransformImageView transformImageView, String string2) {
        transformImageView.mImageInputPath = string2;
        return string2;
    }

    static /* synthetic */ String access$102(TransformImageView transformImageView, String string2) {
        transformImageView.mImageOutputPath = string2;
        return string2;
    }

    static /* synthetic */ ExifInfo access$202(TransformImageView transformImageView, ExifInfo exifInfo) {
        transformImageView.mExifInfo = exifInfo;
        return exifInfo;
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public float getCurrentAngle() {
        return this.getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return this.getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public float getMatrixAngle(Matrix matrix) {
        return (float)(-(57.29577951308232 * Math.atan2((double)this.getMatrixValue(matrix, 1), (double)this.getMatrixValue(matrix, 0))));
    }

    public float getMatrixScale(Matrix matrix) {
        return (float)Math.sqrt((double)(Math.pow((double)this.getMatrixValue(matrix, 0), (double)2.0) + Math.pow((double)this.getMatrixValue(matrix, 3), (double)2.0)));
    }

    protected float getMatrixValue(Matrix matrix, int n) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[n];
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize <= 0) {
            this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize(this.getContext());
        }
        return this.mMaxBitmapSize;
    }

    public Bitmap getViewBitmap() {
        if (this.getDrawable() != null && this.getDrawable() instanceof FastBitmapDrawable) {
            return ((FastBitmapDrawable)this.getDrawable()).getBitmap();
        }
        return null;
    }

    protected void init() {
        this.setScaleType(ScaleType.MATRIX);
    }

    protected void onImageLaidOut() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        float f = drawable2.getIntrinsicWidth();
        float f2 = drawable2.getIntrinsicHeight();
        Object[] arrobject = new Object[]{(int)f, (int)f2};
        Log.d((String)TAG, (String)String.format((String)"Image size: [%d:%d]", (Object[])arrobject));
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        this.mInitialImageCorners = RectUtils.getCornersFromRect(rectF);
        this.mInitialImageCenter = RectUtils.getCenterFromRect(rectF);
        this.mBitmapLaidOut = true;
        TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.onLoadComplete();
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (bl || this.mBitmapDecoded && !this.mBitmapLaidOut) {
            int n5 = this.getPaddingLeft();
            int n6 = this.getPaddingTop();
            int n7 = this.getWidth() - this.getPaddingRight();
            int n8 = this.getHeight() - this.getPaddingBottom();
            this.mThisWidth = n7 - n5;
            this.mThisHeight = n8 - n6;
            this.onImageLaidOut();
        }
    }

    public void postRotate(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f, f2, f3);
            this.setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onRotate(this.getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    public void postScale(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postScale(f, f, f2, f3);
            this.setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onScale(this.getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postTranslate(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.mCurrentImageMatrix.postTranslate(f, f2);
            this.setImageMatrix(this.mCurrentImageMatrix);
        }
    }

    protected void printMatrix(String string2, Matrix matrix) {
        float f = this.getMatrixValue(matrix, 2);
        float f2 = this.getMatrixValue(matrix, 5);
        float f3 = this.getMatrixScale(matrix);
        float f4 = this.getMatrixAngle(matrix);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": matrix: { x: ");
        stringBuilder.append(f);
        stringBuilder.append(", y: ");
        stringBuilder.append(f2);
        stringBuilder.append(", scale: ");
        stringBuilder.append(f3);
        stringBuilder.append(", angle: ");
        stringBuilder.append(f4);
        stringBuilder.append(" }");
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.setImageDrawable((Drawable)new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        this.updateCurrentImagePoints();
    }

    public void setImageUri(Uri uri, Uri uri2) throws Exception {
        int n = this.getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground(this.getContext(), uri, uri2, n, n, (BitmapLoadCallback)new 1(this));
    }

    public void setMaxBitmapSize(int n) {
        this.mMaxBitmapSize = n;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(scaleType);
            return;
        }
        Log.w((String)TAG, (String)"Invalid ScaleType. Only ScaleType.MATRIX can be used");
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

    public static interface TransformImageListener {
        public void onLoadComplete();

        public void onLoadFailure(Exception var1);

        public void onRotate(float var1);

        public void onScale(float var1);
    }

}

