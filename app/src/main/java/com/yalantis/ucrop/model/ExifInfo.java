/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.yalantis.ucrop.model;

public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int n, int n2, int n3) {
        this.mExifOrientation = n;
        this.mExifDegrees = n2;
        this.mExifTranslation = n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            ExifInfo exifInfo = (ExifInfo)object;
            if (this.mExifOrientation != exifInfo.mExifOrientation) {
                return false;
            }
            if (this.mExifDegrees != exifInfo.mExifDegrees) {
                return false;
            }
            return this.mExifTranslation == exifInfo.mExifTranslation;
        }
        return false;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return 31 * (31 * this.mExifOrientation + this.mExifDegrees) + this.mExifTranslation;
    }

    public void setExifDegrees(int n) {
        this.mExifDegrees = n;
    }

    public void setExifOrientation(int n) {
        this.mExifOrientation = n;
    }

    public void setExifTranslation(int n) {
        this.mExifTranslation = n;
    }
}

