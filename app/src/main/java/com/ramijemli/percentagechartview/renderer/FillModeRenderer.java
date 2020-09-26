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
 *  android.text.TextPaint
 *  java.lang.Double
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
import android.text.TextPaint;
import com.ramijemli.percentagechartview.IPercentageChartView;
import com.ramijemli.percentagechartview.callback.AdaptiveColorProvider;
import com.ramijemli.percentagechartview.renderer.BaseModeRenderer;
import com.ramijemli.percentagechartview.renderer.OffsetEnabledMode;

public class FillModeRenderer
extends BaseModeRenderer
implements OffsetEnabledMode {
    private float mBgSweepAngle;
    private float mDirectionAngle;
    private float mRadius;

    public FillModeRenderer(IPercentageChartView iPercentageChartView) {
        super(iPercentageChartView);
        this.setup();
    }

    public FillModeRenderer(IPercentageChartView iPercentageChartView, TypedArray typedArray) {
        super(iPercentageChartView, typedArray);
        this.setup();
    }

    private void measureBackgroundBounds() {
        this.mBackgroundBounds.set(this.mCircleBounds.left + (float)this.mBackgroundOffset, this.mCircleBounds.top + (float)this.mBackgroundOffset, this.mCircleBounds.right - (float)this.mBackgroundOffset, this.mCircleBounds.bottom - (float)this.mBackgroundOffset);
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.mDrawBackground) {
            canvas.drawArc(this.mBackgroundBounds, this.mStartAngle, this.mBgSweepAngle, false, this.mBackgroundPaint);
        }
        canvas.drawArc(this.mCircleBounds, this.mStartAngle, this.mSweepAngle, false, this.mProgressPaint);
        this.drawText(canvas);
    }

    @Override
    public int getBackgroundOffset() {
        return this.mBackgroundOffset;
    }

    @Override
    public float getStartAngle() {
        return this.mDirectionAngle;
    }

    @Override
    public void measure(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n / 2;
        int n8 = n2 / 2;
        this.mRadius = (float)Math.min((int)n, (int)n2) / 2.0f;
        RectF rectF = this.mCircleBounds;
        float f = n7;
        float f2 = this.mRadius;
        float f3 = f - f2;
        float f4 = n8;
        rectF.set(f3, f4 - f2, f + f2, f4 + f2);
        this.measureBackgroundBounds();
        this.updateDrawingAngles();
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
            this.updateDrawingAngles();
        }
    }

    @Override
    public void setStartAngle(float f) {
        if (this.mDirectionAngle == f) {
            return;
        }
        this.mDirectionAngle = f;
        this.updateDrawingAngles();
    }

    @Override
    void setup() {
        super.setup();
        this.mDirectionAngle = this.mStartAngle;
    }

    @Override
    void setupGradientColors(RectF rectF) {
        if (this.mGradientType != -1) {
            if (this.mGradientType == 2) {
                return;
            }
            if (this.mGradientType != 1) {
                LinearGradient linearGradient = new LinearGradient(rectF.centerX(), rectF.top, rectF.centerX(), rectF.bottom, this.mGradientColors, this.mGradientDistributions, Shader.TileMode.CLAMP);
                this.mGradientShader = linearGradient;
                this.updateGradientAngle(this.mGradientAngle);
            } else {
                RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.bottom - rectF.centerY(), this.mGradientColors, this.mGradientDistributions, Shader.TileMode.MIRROR);
                this.mGradientShader = radialGradient;
            }
            this.mProgressPaint.setShader(this.mGradientShader);
        }
    }

    @Override
    void updateDrawingAngles() {
        float f;
        float f2 = this.mRadius;
        float f3 = this.mProgress;
        float f4 = this.mRadius;
        float f5 = f2 - f3 * (f4 * 2.0f) / 100.0f;
        double d = Math.pow((double)f4, (double)2.0);
        double d2 = Math.pow((double)f5, (double)2.0);
        if (f5 == 0.0f) {
            f = 180.0f;
        } else {
            double d3 = d2 + d - Math.pow((double)Math.sqrt((double)(d - d2)), (double)2.0);
            double d4 = f5 * 2.0f * this.mRadius;
            Double.isNaN((double)d4);
            f = 2.0f * (float)Math.toDegrees((double)Math.acos((double)(d3 / d4)));
        }
        this.mSweepAngle = f;
        this.mStartAngle = this.mDirectionAngle - this.mSweepAngle / 2.0f;
        int n = this.mBackgroundOffset;
        float f6 = 360.0f;
        if (n <= 0) {
            f6 = this.mSweepAngle - f6;
        }
        this.mBgSweepAngle = f6;
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

