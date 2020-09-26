/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ArgbEvaluator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.text.TextPaint
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview.renderer;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
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
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ramijemli.percentagechartview.IPercentageChartView;
import com.ramijemli.percentagechartview.R;
import com.ramijemli.percentagechartview.callback.AdaptiveColorProvider;
import com.ramijemli.percentagechartview.renderer.-$$Lambda$RingModeRenderer$zxbsBfZTEC4qU_lpADrgkVnJWNg;
import com.ramijemli.percentagechartview.renderer.BaseModeRenderer;
import com.ramijemli.percentagechartview.renderer.OrientationBasedMode;

public class RingModeRenderer
extends BaseModeRenderer
implements OrientationBasedMode {
    public static final int CAP_ROUND = 0;
    public static final int CAP_SQUARE = 1;
    private static final float DEFAULT_BG_BAR_DP_WIDTH = 16.0f;
    private static final float DEFAULT_PROGRESS_BAR_DP_WIDTH = 16.0f;
    private int mBackgroundBarColor;
    private Paint mBackgroundBarPaint;
    private float mBackgroundBarThickness;
    private boolean mDrawBackgroundBar;
    private Paint.Cap mProgressBarStyle;
    private float mProgressBarThickness;
    private int mProvidedBgBarColor;
    private float tweakAngle;

    public RingModeRenderer(IPercentageChartView iPercentageChartView) {
        super(iPercentageChartView);
        this.init();
        this.setup();
    }

    public RingModeRenderer(IPercentageChartView iPercentageChartView, TypedArray typedArray) {
        super(iPercentageChartView, typedArray);
        this.init(typedArray);
        this.setup();
    }

    private void init() {
        this.mDrawBackgroundBar = true;
        this.mBackgroundBarThickness = (int)TypedValue.applyDimension((int)1, (float)16.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics());
        this.mBackgroundBarColor = -16777216;
        this.mProgressBarThickness = (int)TypedValue.applyDimension((int)1, (float)16.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics());
        this.mProgressBarStyle = Paint.Cap.ROUND;
    }

    private void init(TypedArray typedArray) {
        this.mDrawBackgroundBar = typedArray.getBoolean(R.styleable.PercentageChartView_pcv_drawBackgroundBar, true);
        this.mBackgroundBarThickness = typedArray.getDimensionPixelSize(R.styleable.PercentageChartView_pcv_backgroundBarThickness, (int)TypedValue.applyDimension((int)1, (float)16.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics()));
        this.mBackgroundBarColor = typedArray.getColor(R.styleable.PercentageChartView_pcv_backgroundBarColor, -16777216);
        this.mProgressBarThickness = typedArray.getDimensionPixelSize(R.styleable.PercentageChartView_pcv_progressBarThickness, (int)TypedValue.applyDimension((int)1, (float)16.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics()));
        Paint.Cap cap = typedArray.getInt(R.styleable.PercentageChartView_pcv_progressBarStyle, 0) == 0 ? Paint.Cap.ROUND : Paint.Cap.BUTT;
        this.mProgressBarStyle = cap;
    }

    @Override
    void cancelAnimations() {
        super.cancelAnimations();
        if (this.mBgBarColorAnimator != null && this.mBgBarColorAnimator.isRunning()) {
            this.mBgBarColorAnimator.cancel();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (this.mBgBarColorAnimator != null) {
            if (this.mBgBarColorAnimator.isRunning()) {
                this.mBgBarColorAnimator.cancel();
            }
            this.mBgBarColorAnimator.removeAllUpdateListeners();
        }
        this.mBgBarColorAnimator = null;
        this.mBackgroundBarPaint = null;
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.mDrawBackground) {
            canvas.drawArc(this.mBackgroundBounds, 0.0f, 360.0f, false, this.mBackgroundPaint);
        }
        if (this.mDrawBackgroundBar) {
            if (this.mBackgroundBarThickness <= this.mProgressBarThickness) {
                canvas.drawArc(this.mCircleBounds, this.mStartAngle + this.tweakAngle, -(360.0f - this.mSweepAngle + this.tweakAngle), false, this.mBackgroundBarPaint);
            } else {
                canvas.drawArc(this.mCircleBounds, 0.0f, 360.0f, false, this.mBackgroundBarPaint);
            }
        }
        if (this.mProgress != 0.0f) {
            canvas.drawArc(this.mCircleBounds, this.mStartAngle + this.tweakAngle, this.mSweepAngle, false, this.mProgressPaint);
        }
        this.drawText(canvas);
    }

    public int getBackgroundBarColor() {
        if (!this.mDrawBackgroundBar) {
            return -1;
        }
        return this.mBackgroundBarColor;
    }

    public float getBackgroundBarThickness() {
        return this.mBackgroundBarThickness;
    }

    @Override
    public int getOrientation() {
        return this.orientation;
    }

    public int getProgressBarStyle() {
        return this.mProgressBarStyle != Paint.Cap.ROUND;
    }

    public float getProgressBarThickness() {
        return this.mProgressBarThickness;
    }

    public boolean isDrawBackgroundBarEnabled() {
        return this.mDrawBackgroundBar;
    }

    public /* synthetic */ void lambda$setupColorAnimations$0$RingModeRenderer(ValueAnimator valueAnimator) {
        int n;
        this.mProvidedBgBarColor = n = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        this.mBackgroundBarPaint.setColor(n);
    }

    @Override
    public void measure(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = Math.min((int)n, (int)n2);
        float f = Math.max((float)this.mProgressBarThickness, (float)this.mBackgroundBarThickness);
        int n8 = n / 2;
        int n9 = n2 / 2;
        float f2 = ((float)n7 - f) / 2.0f;
        RectF rectF = this.mCircleBounds;
        float f3 = n8;
        float f4 = f3 - f2;
        float f5 = n9;
        rectF.set(f4, f5 - f2, f3 + f2, f5 + f2);
        float f6 = 1.0f + (f2 - this.mBackgroundBarThickness / 2.0f);
        this.mBackgroundBounds.set(f3 - f6, f5 - f6, f3 + f6, f5 + f6);
        this.setupGradientColors(this.mCircleBounds);
        this.updateText();
    }

    @Override
    public void setAdaptiveColorProvider(AdaptiveColorProvider adaptiveColorProvider) {
        if (adaptiveColorProvider == null) {
            this.mBgBarColorAnimator = null;
            this.mTextColorAnimator = null;
            this.mBackgroundColorAnimator = null;
            this.mProgressColorAnimator = null;
            this.mAdaptiveColorProvider = null;
            this.mTextPaint.setColor(this.mTextColor);
            this.mBackgroundBarPaint.setColor(this.mBackgroundBarColor);
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

    public void setBackgroundBarColor(int n) {
        if (this.mDrawBackgroundBar && (this.mAdaptiveColorProvider == null || this.mAdaptiveColorProvider.provideBackgroundBarColor(this.mProgress) == -1)) {
            if (this.mBackgroundBarColor == n) {
                return;
            }
            this.mBackgroundBarColor = n;
            this.mBackgroundBarPaint.setColor(n);
        }
    }

    public void setBackgroundBarThickness(float f) {
        if (this.mBackgroundBarThickness == f) {
            return;
        }
        this.mBackgroundBarThickness = f;
        this.mBackgroundBarPaint.setStrokeWidth(f);
        this.measure(this.mView.getWidth(), this.mView.getHeight(), 0, 0, 0, 0);
    }

    public void setDrawBackgroundBarEnabled(boolean bl) {
        if (this.mDrawBackgroundBar == bl) {
            return;
        }
        this.mDrawBackgroundBar = bl;
    }

    @Override
    public void setOrientation(int n) {
        if (this.orientation == n) {
            return;
        }
        this.orientation = n;
        this.updateDrawingAngles();
    }

    public void setProgressBarStyle(int n) {
        if (n >= 0 && n <= 1) {
            Paint.Cap cap = n == 0 ? Paint.Cap.ROUND : Paint.Cap.BUTT;
            this.mProgressBarStyle = cap;
            this.mProgressPaint.setStrokeCap(this.mProgressBarStyle);
            return;
        }
        throw new IllegalArgumentException("Text style must be a valid TextStyle constant.");
    }

    public void setProgressBarThickness(float f) {
        if (this.mProgressBarThickness == f) {
            return;
        }
        this.mProgressBarThickness = f;
        this.mProgressPaint.setStrokeWidth(f);
        this.measure(this.mView.getWidth(), this.mView.getHeight(), 0, 0, 0, 0);
    }

    @Override
    public void setStartAngle(float f) {
        if (this.mStartAngle == f) {
            return;
        }
        this.mStartAngle = f;
        if (this.mGradientType == 2) {
            this.updateGradientAngle(f);
        }
    }

    @Override
    void setup() {
        Paint paint;
        super.setup();
        this.mProvidedBgBarColor = -1;
        this.tweakAngle = 0.0f;
        this.updateDrawingAngles();
        this.mBackgroundBarPaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.mBackgroundBarPaint.setColor(this.mBackgroundBarColor);
        this.mBackgroundBarPaint.setStrokeWidth(this.mBackgroundBarThickness);
        this.mBackgroundBarPaint.setStrokeCap(this.mProgressBarStyle);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth(this.mProgressBarThickness);
        this.mProgressPaint.setStrokeCap(this.mProgressBarStyle);
    }

    @Override
    void setupColorAnimations() {
        super.setupColorAnimations();
        if (this.mBgBarColorAnimator == null) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Object[] arrobject = new Object[]{this.mBackgroundBarColor, this.mProvidedBgBarColor};
            this.mBgBarColorAnimator = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, (Object[])arrobject);
            this.mBgBarColorAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new -$$Lambda$RingModeRenderer$zxbsBfZTEC4qU_lpADrgkVnJWNg(this));
            this.mBgBarColorAnimator.setDuration((long)this.mAnimDuration);
        }
    }

    @Override
    void setupGradientColors(RectF rectF) {
        if (this.mGradientType == -1) {
            return;
        }
        double d = 2.0 * Math.pow((double)(rectF.bottom - rectF.centerY()), (double)2.0);
        this.tweakAngle = (float)Math.toDegrees((double)Math.acos((double)((d - Math.pow((double)(this.mProgressBarThickness / 2.0f), (double)2.0)) / d)));
        int n = this.mGradientType;
        if (n != 1) {
            if (n != 2) {
                LinearGradient linearGradient = new LinearGradient(rectF.centerX(), rectF.top, rectF.centerX(), rectF.bottom, this.mGradientColors, this.mGradientDistributions, Shader.TileMode.CLAMP);
                this.mGradientShader = linearGradient;
                this.updateGradientAngle(this.mStartAngle);
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
    void updateAnimations(float f) {
        int n;
        super.updateAnimations(f);
        if (this.mAdaptiveColorProvider == null) {
            return;
        }
        int n2 = this.mAdaptiveColorProvider.provideBackgroundBarColor(f);
        if (n2 != -1 && n2 != (n = this.mProvidedBgBarColor)) {
            if (n == -1) {
                n = this.mBackgroundBarColor;
            }
            this.mBgBarColorAnimator.setIntValues(new int[]{n, n2});
            this.mBgBarColorAnimator.start();
        }
    }

    @Override
    void updateDrawingAngles() {
        if (this.orientation != 1) {
            this.mSweepAngle = 360.0f * (this.mProgress / 100.0f);
            return;
        }
        this.mSweepAngle = -(360.0f * (this.mProgress / 100.0f));
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

    @Override
    void updateProvidedColors(float f) {
        super.updateProvidedColors(f);
        if (this.mAdaptiveColorProvider == null) {
            return;
        }
        int n = this.mAdaptiveColorProvider.provideBackgroundBarColor(f);
        if (n != -1 && n != this.mProvidedBgBarColor) {
            this.mProvidedBgBarColor = n;
            this.mBackgroundBarPaint.setColor(n);
        }
    }
}

