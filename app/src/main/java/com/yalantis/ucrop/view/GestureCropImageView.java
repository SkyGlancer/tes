/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  java.lang.Math
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;

public class GestureCropImageView
extends CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps = 5;
    private GestureDetector mGestureDetector;
    private boolean mIsRotateEnabled = true;
    private boolean mIsScaleEnabled = true;
    private float mMidPntX;
    private float mMidPntY;
    private RotationGestureDetector mRotateDetector;
    private ScaleGestureDetector mScaleDetector;

    public GestureCropImageView(Context context) {
        super(context);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

            public boolean onDoubleTap(MotionEvent motionEvent) {
                GestureCropImageView gestureCropImageView = GestureCropImageView.this;
                gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
                return super.onDoubleTap(motionEvent);
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                GestureCropImageView.this.postTranslate(-f, -f2);
                return true;
            }
        }, null, true);
        this.mScaleDetector = new ScaleGestureDetector(this.getContext(), (ScaleGestureDetector.OnScaleGestureListener)new ScaleGestureDetector.SimpleOnScaleGestureListener(){

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
                return true;
            }
        });
        this.mRotateDetector = new RotationGestureDetector(new RotateListener());
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    protected float getDoubleTapTargetScale() {
        return this.getCurrentScale() * (float)Math.pow((double)(this.getMaxScale() / this.getMinScale()), (double)(1.0f / (float)this.mDoubleTapScaleSteps));
    }

    @Override
    protected void init() {
        super.init();
        this.setupGestureListeners();
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((255 & motionEvent.getAction()) == 0) {
            this.cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((255 & motionEvent.getAction()) == 1) {
            this.setImageToWrapCropBounds();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int n) {
        this.mDoubleTapScaleSteps = n;
    }

    public void setRotateEnabled(boolean bl) {
        this.mIsRotateEnabled = bl;
    }

    public void setScaleEnabled(boolean bl) {
        this.mIsScaleEnabled = bl;
    }

    private class RotateListener
    extends RotationGestureDetector.SimpleOnRotationGestureListener {
        private RotateListener() {
        }

        @Override
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.postRotate(rotationGestureDetector.getAngle(), GestureCropImageView.this.mMidPntX, GestureCropImageView.this.mMidPntY);
            return true;
        }
    }

}

