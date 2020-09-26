/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.yalantis.ucrop.model;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public class CropParameters {
    private Bitmap.CompressFormat mCompressFormat;
    private int mCompressQuality;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;

    public CropParameters(int n, int n2, Bitmap.CompressFormat compressFormat, int n3, String string2, String string3, ExifInfo exifInfo) {
        this.mMaxResultImageSizeX = n;
        this.mMaxResultImageSizeY = n2;
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = n3;
        this.mImageInputPath = string2;
        this.mImageOutputPath = string3;
        this.mExifInfo = exifInfo;
    }

    public Bitmap.CompressFormat getCompressFormat() {
        return this.mCompressFormat;
    }

    public int getCompressQuality() {
        return this.mCompressQuality;
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

    public int getMaxResultImageSizeX() {
        return this.mMaxResultImageSizeX;
    }

    public int getMaxResultImageSizeY() {
        return this.mMaxResultImageSizeY;
    }
}

