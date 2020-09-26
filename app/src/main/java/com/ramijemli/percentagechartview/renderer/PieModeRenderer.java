/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.text.TextPaint
 *  java.lang.Math
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview.renderer;

import android.animation.ValueAnimator;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import com.ramijemli.percentagechartview.IPercentageChartView;
import com.ramijemli.percentagechartview.callback.AdaptiveColorProvider;
import com.ramijemli.percentagechartview.renderer.BaseModeRenderer;
import com.ramijemli.percentagechartview.renderer.OffsetEnabledMode;
import com.ramijemli.percentagechartview.renderer.OrientationBasedMode;

public class PieModeRenderer
extends BaseModeRenderer
implements OrientationBasedMode,
OffsetEnabledMode {
    private float mBgStartAngle;
    private float mBgSweepAngle;

    public PieModeRenderer(IPercentageChartView iPercentageChartView) {
        super(iPercentageChartView);
        this.setup();
    }

    public PieModeRenderer(IPercentageChartView iPercentageChartView, TypedArray typedArray) {
        super(iPercentageChartView, typedArray);
        this.setup();
    }

    private void measureBackgroundBounds() {
        this.mBackgroundBounds.set(this.mCircleBounds.left + (float)this.mBackgroundOffset, this.mCircleBounds.top + (float)this.mBackgroundOffset, this.mCircleBounds.right - (float)this.mBackgroundOffset, this.mCircleBounds.bottom - (float)this.mBackgroundOffset);
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.mGradientType == 2 && this.mView.isInEditMode()) {
            canvas.save();
            canvas.rotate(this.mStartAngle, this.mCircleBounds.centerX(), this.mCircleBounds.centerY());
        }
        canvas.drawArc(this.mCircleBounds, this.mStartAngle, this.mSweepAngle, true, this.mProgressPaint);
        if (this.mDrawBackground) {
            canvas.drawArc(this.mBackgroundBounds, this.mBgStartAngle, this.mBgSweepAngle, true, this.mBackgroundPaint);
        }
        if (this.mGradientType == 2 && this.mView.isInEditMode()) {
            canvas.restore();
        }
        this.drawText(canvas);
    }

    @Override
    public int getBackgroundOffset() {
        return this.mBackgroundOffset;
    }

    @Override
    public int getOrientation() {
        return this.orientation;
    }

    @Override
    public void measure(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.5f * (float)n;
        float f2 = 0.5f * (float)n2;
        float f3 = 0.5f * (float)Math.min((int)n, (int)n2);
        this.mCircleBounds.set(f - f3, f2 - f3, f + f3, f2 + f3);
        this.measureBackgroundBounds();
        this.setupGradientColors(this.mCircleBounds);
        this.updateText();
    }

    @Override
    public void setAdaptiveColorProvider(AdaptiveColorProvider adaptiveColorProvider) {
        if (adaptiveColorProvider == null) {
            this.mTextColorAnimator = null;
            this.mBackgroundColorAnimator = null;
            this.mProgressColorAnimator = null;
            this.mAdaptiveColorProvider = null;
            this.mTextPaint.setColor(this.mTextColor);
            this.mBackgroundPaint.setColor(this.mBackgroundColor);
            this.mProgressPaint.setColor(this.mProgressColor);
            this.mView.postInvalidate();
            return;
        }
        this.mAdaptiveColorProvider = adaptiveColorProvider;
        this.setupColorAnimations();
        this.updateProvidedColors(this.mProgress);
        this.mView.postInvalidate();
    }

    @Override
    public void setBackgroundOffset(int n) {
        if (this.mDrawBackground) {
            if (this.mBackgroundOffset == n) {
                return;
            }
            this.mBackgroundOffset = n;
            this.measureBackgroundBounds();
        }
    }

    @Override
    public void setOrientation(int n) {
        if (this.orientation == n) {
            return;
        }
        this.orientation = n;
        this.updateDrawingAngles();
    }

    @Override
    public void setStartAngle(float f) {
        if (this.mStartAngle == f) {
            return;
        }
        this.mStartAngle = f;
        this.updateDrawingAngles();
        if (this.mGradientType == 2) {
            this.updateGradientAngle(f);
        }
    }

    @Override
    void setup() {
        super.setup();
        this.updateDrawingAngles();
    }

    @Override
    void setupGradientColors(RectF rectF) {
        if (this.mGradientType == -1 && rectF.height() == 0.0f) {
            return;
        }
        int n = this.mGradientType;
        if (n != 1) {
            if (n != 2) {
                LinearGradient linearGradient = new LinearGradient(rectF.centerX(), rectF.top, rectF.centerX(), rectF.bottom, this.mGradientColors, this.mGradientDistributions, Shader.TileMode.CLAMP);
                this.mGradientShader = linearGradient;
                this.updateGradientAngle(this.mGradientAngle);
            } else {
                this.mGradientShader = new SweepGradient(rectF.centerX(), rectF.centerY(), this.mGradientColors, this.mGradientDistributions);
                if (!this.mView.isInEditMode()) {
                    this.updateGradientAngle(this.mStartAngle);
                }
            }
        } else {
            RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.bottom - rectF.centerY(), this.mGradientColors, this.mGradientDistributions, Shader.TileMode.MIRROR);
            this.mGradientShader = radialGradient;
        }
        this.mProgressPaint.setShader(this.mGradientShader);
    }

    @Override
    void updateDrawingAngles() {
        if (this.orientation != 1) {
            this.mSweepAngle = 360.0f * (this.mProgress / 100.0f);
            this.mBgStartAngle = this.mStartAngle + this.mSweepAngle;
            this.mBgSweepAngle = 360.0f - this.mSweepAngle;
            return;
        }
        this.mSweepAngle = -(360.0f * (this.mProgress / 100.0f));
        this.mBgStartAngle = this.mStartAngle;
        this.mBgSweepAngle = 360.0f + this.mSweepAngle;
    }

    @Override
    void updateGradientAngle(float f) {
        if (this.mGradientType != -1) {
            if (this.mGradientType == 1) {
                return;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(f, this.mCircleBounds.centerX(), this.mCircleBounds.centerY());
            this.mGradientShader.setLocalMatrix(matrix);
        }
    }
}

