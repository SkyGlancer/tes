/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.media.ExifInterface
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 */
package app.dukhaan.src.java.com.yalantis.ucrop.task;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class BitmapCropTask
extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private final Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContext;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final ExifInfo mExifInfo;
    private final String mImageInputPath;
    private final String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mContext = new WeakReference((Object)context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    private boolean crop() throws IOException {
        int n;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float f = this.mCropRect.width() / this.mCurrentScale;
            float f2 = this.mCropRect.height() / this.mCurrentScale;
            if (f > (float)this.mMaxResultImageSizeX || f2 > (float)this.mMaxResultImageSizeY) {
                Bitmap bitmap = this.mViewBitmap;
                Bitmap bitmap2 = this.mViewBitmap;
                float f3 = Math.min((float)((float)this.mMaxResultImageSizeX / f), (float)((float)this.mMaxResultImageSizeY / f2));
                Bitmap bitmap3 = Bitmap.createScaledBitmap((Bitmap)bitmap2, (int)Math.round((float)(f3 * (float)bitmap2.getWidth())), (int)Math.round((float)(f3 * (float)this.mViewBitmap.getHeight())), (boolean)false);
                if (bitmap != bitmap3) {
                    bitmap.recycle();
                }
                this.mViewBitmap = bitmap3;
                this.mCurrentScale /= f3;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.mCurrentAngle, (float)(this.mViewBitmap.getWidth() / 2), (float)(this.mViewBitmap.getHeight() / 2));
            Bitmap bitmap = this.mViewBitmap;
            Bitmap bitmap4 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)this.mViewBitmap.getHeight(), (Matrix)matrix, (boolean)true);
            Bitmap bitmap5 = this.mViewBitmap;
            if (bitmap5 != bitmap4) {
                bitmap5.recycle();
            }
            this.mViewBitmap = bitmap4;
        }
        this.cropOffsetX = Math.round((float)((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale));
        this.cropOffsetY = Math.round((float)((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale));
        this.mCroppedImageWidth = Math.round((float)(this.mCropRect.width() / this.mCurrentScale));
        this.mCroppedImageHeight = n = Math.round((float)(this.mCropRect.height() / this.mCurrentScale));
        boolean bl = this.shouldCrop(this.mCroppedImageWidth, n);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Should crop: ");
        stringBuilder.append(bl);
        Log.i((String)TAG, (String)stringBuilder.toString());
        if (bl) {
            ExifInterface exifInterface = new ExifInterface(this.mImageInputPath);
            this.saveImage(Bitmap.createBitmap((Bitmap)this.mViewBitmap, (int)this.cropOffsetX, (int)this.cropOffsetY, (int)this.mCroppedImageWidth, (int)this.mCroppedImageHeight));
            if (this.mCompressFormat.equals((Object)Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.copyExif(exifInterface, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
            }
            return true;
        }
        FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        return false;
    }

    private void saveImage(Bitmap bitmap) throws FileNotFoundException {
        Context context = (Context)this.mContext.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(Uri.fromFile((File)new File(this.mImageOutputPath)));
            bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStream);
            bitmap.recycle();
        }
        catch (Throwable throwable) {
            BitmapLoadUtils.close(outputStream);
            throw throwable;
        }
        BitmapLoadUtils.close((Closeable)outputStream);
    }

    private boolean shouldCrop(int n, int n2) {
        float f;
        float f2;
        int n3 = Math.round((float)((float)Math.max((int)n, (int)n2) / 1000.0f));
        boolean bl = true;
        int n4 = n3 + bl;
        if (!(this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0 || (f = Math.abs((float)(this.mCropRect.left - this.mCurrentImageRect.left))) > (f2 = (float)n4) || Math.abs((float)(this.mCropRect.top - this.mCurrentImageRect.top)) > f2 || Math.abs((float)(this.mCropRect.bottom - this.mCurrentImageRect.bottom)) > f2)) {
            if (Math.abs((float)(this.mCropRect.right - this.mCurrentImageRect.right)) > f2) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    protected /* varargs */ Throwable doInBackground(Void ... arrvoid) {
        Bitmap bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            this.crop();
            this.mViewBitmap = null;
            return null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
    }

    protected void onPostExecute(Throwable throwable) {
        BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback != null) {
            if (throwable == null) {
                Uri uri = Uri.fromFile((File)new File(this.mImageOutputPath));
                this.mCropCallback.onBitmapCropped(uri, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
                return;
            }
            bitmapCropCallback.onCropFailure(throwable);
        }
    }
}

