/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ArgbEvaluator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.DynamicLayout
 *  android.text.DynamicLayout$Builder
 *  android.text.Editable
 *  android.text.Editable$Factory
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.TextPaint
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.InflateException
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.AnticipateOvershootInterpolator
 *  android.view.animation.BounceInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.view.animation.OvershootInterpolator
 *  androidx.interpolator.view.animation.FastOutLinearInInterpolator
 *  androidx.interpolator.view.animation.FastOutSlowInInterpolator
 *  androidx.interpolator.view.animation.LinearOutSlowInInterpolator
 *  com.ramijemli.percentagechartview.renderer.-$
 *  com.ramijemli.percentagechartview.renderer.-$$Lambda
 *  com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer
 *  com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer$QG_rVIJ8uDyaFnaXfzA17XdamNA
 *  com.ramijemli.percentagechartview.renderer.FillModeRenderer
 *  com.ramijemli.percentagechartview.renderer.PieModeRenderer
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview.renderer;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.ramijemli.percentagechartview.IPercentageChartView;
import com.ramijemli.percentagechartview.R;
import com.ramijemli.percentagechartview.callback.AdaptiveColorProvider;
import com.ramijemli.percentagechartview.callback.ProgressTextFormatter;
import com.ramijemli.percentagechartview.renderer.-$;
import com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer$3iW0AAGI2W_hwL6eA55SyLhb1N0;
import com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer$3nnPlAUoXwwgNXluZp0m-EuBQIU;
import com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer$HP7Bld75AuZHhx4S1dguxZOrN78;
import com.ramijemli.percentagechartview.renderer.-$$Lambda$BaseModeRenderer$wm1tRmHpe71Xydd_yz85tXaQyMk;
import com.ramijemli.percentagechartview.renderer.FillModeRenderer;
import com.ramijemli.percentagechartview.renderer.PieModeRenderer;

public abstract class BaseModeRenderer {
    public static final int ACCELERATE = 1;
    public static final int ACCELERATE_DECELERATE = 3;
    public static final int ANTICIPATE = 4;
    public static final int ANTICIPATE_OVERSHOOT = 6;
    public static final int BOUNCE = 7;
    public static final int DECELERATE = 2;
    private static final int DEFAULT_ANIMATION_DURATION = 400;
    private static final int DEFAULT_ANIMATION_INTERPOLATOR = 0;
    static final float DEFAULT_MAX = 100.0f;
    private static final int DEFAULT_START_ANGLE = 0;
    private static final float DEFAULT_TEXT_SP_SIZE = 12.0f;
    public static final int FAST_OUT_LINEAR_IN = 8;
    public static final int FAST_OUT_SLOW_IN = 9;
    public static final int GRADIENT_LINEAR = 0;
    public static final int GRADIENT_RADIAL = 1;
    public static final int GRADIENT_SWEEP = 2;
    public static final int INVALID_GRADIENT = -1;
    public static final int INVALID_ORIENTATION = -1;
    public static final int LINEAR = 0;
    public static final int LINEAR_OUT_SLOW_IN = 10;
    public static final int MODE_FILL = 2;
    public static final int MODE_PIE = 1;
    public static final int MODE_RING = 0;
    public static final int ORIENTATION_CLOCKWISE = 0;
    public static final int ORIENTATION_COUNTERCLOCKWISE = 1;
    public static final int OVERSHOOT = 5;
    private ProgressTextFormatter defaultTextFormatter;
    AdaptiveColorProvider mAdaptiveColorProvider;
    int mAnimDuration;
    private Interpolator mAnimInterpolator;
    RectF mBackgroundBounds;
    int mBackgroundColor;
    ValueAnimator mBackgroundColorAnimator;
    int mBackgroundOffset;
    Paint mBackgroundPaint;
    ValueAnimator mBgBarColorAnimator;
    RectF mCircleBounds;
    boolean mDrawBackground;
    float mGradientAngle;
    int[] mGradientColors;
    float[] mGradientDistributions;
    Shader mGradientShader;
    int mGradientType;
    float mProgress;
    private ValueAnimator mProgressAnimator;
    int mProgressColor;
    ValueAnimator mProgressColorAnimator;
    Paint mProgressPaint;
    private int mProvidedBackgroundColor;
    private int mProvidedProgressColor;
    private int mProvidedTextColor;
    private ProgressTextFormatter mProvidedTextFormatter;
    float mStartAngle;
    float mSweepAngle;
    int mTextColor;
    ValueAnimator mTextColorAnimator;
    private Editable mTextEditor;
    private DynamicLayout mTextLayout;
    TextPaint mTextPaint;
    private int mTextProgress;
    private int mTextShadowColor;
    private float mTextShadowDistX;
    private float mTextShadowDistY;
    private float mTextShadowRadius;
    private float mTextSize;
    private int mTextStyle;
    private Typeface mTypeface;
    IPercentageChartView mView;
    int orientation;

    BaseModeRenderer(IPercentageChartView iPercentageChartView) {
        this.mView = iPercentageChartView;
        this.orientation = 0;
        this.mStartAngle = 0.0f;
        this.mDrawBackground = this instanceof PieModeRenderer;
        this.mBackgroundColor = -16777216;
        this.mTextProgress = 0;
        this.mProgress = (float)false;
        this.mProgressColor = -65536;
        this.mGradientType = -1;
        this.mGradientAngle = (int)0.0f;
        this.mAnimDuration = 400;
        this.mAnimInterpolator = new LinearInterpolator();
        this.mTextColor = -1;
        this.mTextSize = TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics());
        this.mTextStyle = 0;
        this.mTextShadowColor = 0;
        this.mTextShadowRadius = 0.0f;
        this.mTextShadowDistX = 0.0f;
        this.mTextShadowDistY = 0.0f;
        this.mBackgroundOffset = 0;
    }

    BaseModeRenderer(IPercentageChartView iPercentageChartView, TypedArray typedArray) {
        float f;
        float f2;
        int n;
        int n2;
        this.mView = iPercentageChartView;
        this.orientation = typedArray.getInt(R.styleable.PercentageChartView_pcv_orientation, 0);
        this.mStartAngle = f2 = (float)typedArray.getInt(R.styleable.PercentageChartView_pcv_startAngle, 0);
        if (f2 < 0.0f || f2 > 360.0f) {
            this.mStartAngle = 0.0f;
        }
        int n3 = R.styleable.PercentageChartView_pcv_drawBackground;
        boolean bl = this instanceof PieModeRenderer || this instanceof FillModeRenderer;
        this.mDrawBackground = typedArray.getBoolean(n3, bl);
        this.mBackgroundColor = typedArray.getColor(R.styleable.PercentageChartView_pcv_backgroundColor, -16777216);
        this.mProgress = f = typedArray.getFloat(R.styleable.PercentageChartView_pcv_progress, 0.0f);
        if (f < 0.0f) {
            this.mProgress = 0.0f;
        } else if (f > 100.0f) {
            this.mProgress = 100.0f;
        }
        this.mTextProgress = (int)this.mProgress;
        this.mProgressColor = typedArray.getColor(R.styleable.PercentageChartView_pcv_progressColor, this.getThemeAccentColor());
        this.initGradientColors(typedArray);
        this.mAnimDuration = typedArray.getInt(R.styleable.PercentageChartView_pcv_animDuration, 400);
        switch (typedArray.getInt(R.styleable.PercentageChartView_pcv_animInterpolator, 0)) {
            default: {
                this.mAnimInterpolator = new LinearInterpolator();
                break;
            }
            case 10: {
                this.mAnimInterpolator = new LinearOutSlowInInterpolator();
                break;
            }
            case 9: {
                this.mAnimInterpolator = new FastOutSlowInInterpolator();
                break;
            }
            case 8: {
                this.mAnimInterpolator = new FastOutLinearInInterpolator();
                break;
            }
            case 7: {
                this.mAnimInterpolator = new BounceInterpolator();
                break;
            }
            case 6: {
                this.mAnimInterpolator = new AnticipateOvershootInterpolator();
                break;
            }
            case 5: {
                this.mAnimInterpolator = new OvershootInterpolator();
                break;
            }
            case 4: {
                this.mAnimInterpolator = new AnticipateInterpolator();
                break;
            }
            case 3: {
                this.mAnimInterpolator = new AccelerateDecelerateInterpolator();
                break;
            }
            case 2: {
                this.mAnimInterpolator = new DecelerateInterpolator();
                break;
            }
            case 1: {
                this.mAnimInterpolator = new AccelerateInterpolator();
            }
        }
        this.mTextColor = typedArray.getColor(R.styleable.PercentageChartView_pcv_textColor, -1);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.PercentageChartView_pcv_textSize, (int)TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)this.mView.getViewContext().getResources().getDisplayMetrics()));
        String string2 = typedArray.getString(R.styleable.PercentageChartView_pcv_typeface);
        if (string2 != null && !string2.isEmpty()) {
            this.mTypeface = Typeface.createFromAsset((AssetManager)this.mView.getViewContext().getResources().getAssets(), (String)string2);
        }
        this.mTextStyle = n2 = typedArray.getInt(R.styleable.PercentageChartView_pcv_textStyle, 0);
        if (n2 > 0) {
            Typeface typeface = this.mTypeface;
            Typeface typeface2 = typeface == null ? Typeface.defaultFromStyle((int)n2) : Typeface.create((Typeface)typeface, (int)n2);
            this.mTypeface = typeface2;
        }
        this.mTextShadowColor = n = typedArray.getColor(R.styleable.PercentageChartView_pcv_textShadowColor, 0);
        if (n != 0) {
            this.mTextShadowRadius = typedArray.getFloat(R.styleable.PercentageChartView_pcv_textShadowRadius, 0.0f);
            this.mTextShadowDistX = typedArray.getFloat(R.styleable.PercentageChartView_pcv_textShadowDistX, 0.0f);
            this.mTextShadowDistY = typedArray.getFloat(R.styleable.PercentageChartView_pcv_textShadowDistY, 0.0f);
        }
        this.mBackgroundOffset = typedArray.getDimensionPixelSize(R.styleable.PercentageChartView_pcv_backgroundOffset, 0);
    }

    private int getThemeAccentColor() {
        int n = Build.VERSION.SDK_INT >= 21 ? 16843829 : this.mView.getViewContext().getResources().getIdentifier("colorAccent", "attr", this.mView.getViewContext().getPackageName());
        TypedValue typedValue = new TypedValue();
        this.mView.getViewContext().getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.data;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initGradientColors(TypedArray typedArray) {
        int n;
        String string2;
        this.mGradientType = n = typedArray.getInt(R.styleable.PercentageChartView_pcv_gradientType, -1);
        if (n == -1) {
            return;
        }
        this.mGradientAngle = typedArray.getInt(R.styleable.PercentageChartView_pcv_gradientAngle, (int)this.mStartAngle);
        String string3 = typedArray.getString(R.styleable.PercentageChartView_pcv_gradientColors);
        int n2 = 0;
        if (string3 != null) {
            String[] arrstring = string3.split(",");
            this.mGradientColors = new int[arrstring.length];
            try {
                for (int i = 0; i < arrstring.length; ++i) {
                    this.mGradientColors[i] = Color.parseColor((String)arrstring[i].trim());
                }
            }
            catch (Exception exception) {
                throw new InflateException("pcv_gradientColors attribute contains invalid hex color values.");
            }
        }
        if ((string2 = typedArray.getString(R.styleable.PercentageChartView_pcv_gradientDistributions)) == null) return;
        {
            String[] arrstring = string2.split(",");
            this.mGradientDistributions = new float[arrstring.length];
            try {
                while (n2 < arrstring.length) {
                    this.mGradientDistributions[n2] = Float.parseFloat((String)arrstring[n2].trim());
                    ++n2;
                }
                return;
            }
            catch (Exception exception) {
                throw new InflateException("pcv_gradientDistributions attribute contains invalid values.");
            }
        }
    }

    static /* synthetic */ CharSequence lambda$setup$0(float f) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((int)f);
        stringBuilder.append("%");
        return stringBuilder.toString();
    }

    public void attach(IPercentageChartView iPercentageChartView) {
        this.mView = iPercentageChartView;
        this.setup();
    }

    void cancelAnimations() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        if (this.mProgressAnimator.isRunning()) {
            this.mProgressAnimator.cancel();
        }
        if ((valueAnimator3 = this.mProgressColorAnimator) != null && valueAnimator3.isRunning()) {
            this.mProgressColorAnimator.cancel();
        }
        if ((valueAnimator2 = this.mBackgroundColorAnimator) != null && valueAnimator2.isRunning()) {
            this.mBackgroundColorAnimator.cancel();
        }
        if ((valueAnimator = this.mTextColorAnimator) != null && valueAnimator.isRunning()) {
            this.mTextColorAnimator.cancel();
        }
    }

    public void destroy() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        ValueAnimator valueAnimator4 = this.mProgressAnimator;
        if (valueAnimator4 != null) {
            if (valueAnimator4.isRunning()) {
                this.mProgressAnimator.cancel();
            }
            this.mProgressAnimator.removeAllUpdateListeners();
        }
        if ((valueAnimator2 = this.mProgressColorAnimator) != null) {
            if (valueAnimator2.isRunning()) {
                this.mProgressColorAnimator.cancel();
            }
            this.mProgressColorAnimator.removeAllUpdateListeners();
        }
        if ((valueAnimator = this.mBackgroundColorAnimator) != null) {
            if (valueAnimator.isRunning()) {
                this.mBackgroundColorAnimator.cancel();
            }
            this.mBackgroundColorAnimator.removeAllUpdateListeners();
        }
        if ((valueAnimator3 = this.mTextColorAnimator) != null) {
            if (valueAnimator3.isRunning()) {
                this.mTextColorAnimator.cancel();
            }
            this.mTextColorAnimator.removeAllUpdateListeners();
        }
        this.mTextColorAnimator = null;
        this.mBackgroundColorAnimator = null;
        this.mProgressColorAnimator = null;
        this.mProgressAnimator = null;
        this.mBackgroundBounds = null;
        this.mCircleBounds = null;
        this.mTextPaint = null;
        this.mProgressPaint = null;
        this.mBackgroundPaint = null;
        this.mGradientShader = null;
        this.mAdaptiveColorProvider = null;
        this.mProvidedTextFormatter = null;
        this.defaultTextFormatter = null;
    }

    public abstract void draw(Canvas var1);

    void drawText(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mCircleBounds.centerX(), this.mCircleBounds.centerY() - (float)(this.mTextLayout.getHeight() >> 1));
        this.mTextLayout.draw(canvas);
        canvas.restore();
    }

    public int getAnimationDuration() {
        return this.mAnimDuration;
    }

    public TimeInterpolator getAnimationInterpolator() {
        return this.mProgressAnimator.getInterpolator();
    }

    public int getBackgroundColor() {
        if (!this.mDrawBackground) {
            return -1;
        }
        return this.mBackgroundColor;
    }

    public float getGradientAngle() {
        return this.mGradientAngle;
    }

    public int[] getGradientColors() {
        return this.mGradientColors;
    }

    public float[] getGradientDistributions() {
        return this.mGradientDistributions;
    }

    public int getGradientType() {
        return this.mGradientType;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public int getProgressColor() {
        return this.mProgressColor;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextShadowColor() {
        return this.mTextShadowColor;
    }

    public float getTextShadowDistX() {
        return this.mTextShadowDistX;
    }

    public float getTextShadowDistY() {
        return this.mTextShadowDistY;
    }

    public float getTextShadowRadius() {
        return this.mTextShadowRadius;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public int getTextStyle() {
        return this.mTextStyle;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public boolean isDrawBackgroundEnabled() {
        return this.mDrawBackground;
    }

    public /* synthetic */ void lambda$setup$1$BaseModeRenderer(ValueAnimator valueAnimator) {
        float f;
        this.mProgress = f = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        if (f > 0.0f && f <= 100.0f) {
            this.mTextProgress = (int)f;
        } else if (this.mProgress > 100.0f) {
            this.mTextProgress = 100;
            this.mProgress = 100;
        } else {
            this.mTextProgress = 0;
            this.mProgress = (float)false;
        }
        this.updateDrawingAngles();
        this.updateText();
        this.mView.onProgressUpdated(this.mProgress);
        this.mView.postInvalidateOnAnimation();
    }

    public /* synthetic */ void lambda$setupColorAnimations$2$BaseModeRenderer(ValueAnimator valueAnimator) {
        int n;
        this.mProvidedProgressColor = n = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        this.mProgressPaint.setColor(n);
    }

    public /* synthetic */ void lambda$setupColorAnimations$3$BaseModeRenderer(ValueAnimator valueAnimator) {
        int n;
        this.mProvidedBackgroundColor = n = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        this.mBackgroundPaint.setColor(n);
    }

    public /* synthetic */ void lambda$setupColorAnimations$4$BaseModeRenderer(ValueAnimator valueAnimator) {
        int n;
        this.mProvidedTextColor = n = ((Integer)valueAnimator.getAnimatedValue()).intValue();
        this.mTextPaint.setColor(n);
    }

    public abstract void measure(int var1, int var2, int var3, int var4, int var5, int var6);

    public abstract void setAdaptiveColorProvider(AdaptiveColorProvider var1);

    public void setAnimationDuration(int n) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        if (this.mAnimDuration == n) {
            return;
        }
        this.mAnimDuration = n;
        this.mProgressAnimator.setDuration((long)n);
        ValueAnimator valueAnimator4 = this.mProgressColorAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration((long)this.mAnimDuration);
        }
        if ((valueAnimator3 = this.mBackgroundColorAnimator) != null) {
            valueAnimator3.setDuration((long)this.mAnimDuration);
        }
        if ((valueAnimator2 = this.mTextColorAnimator) != null) {
            valueAnimator2.setDuration((long)this.mAnimDuration);
        }
        if ((valueAnimator = this.mBgBarColorAnimator) != null) {
            valueAnimator.setDuration((long)this.mAnimDuration);
        }
    }

    public void setAnimationInterpolator(TimeInterpolator timeInterpolator) {
        this.mProgressAnimator.setInterpolator(timeInterpolator);
    }

    public void setBackgroundColor(int n) {
        AdaptiveColorProvider adaptiveColorProvider = this.mAdaptiveColorProvider;
        if (adaptiveColorProvider != null && adaptiveColorProvider.provideBackgroundColor(this.mProgress) != -1 || this.mBackgroundColor == n) {
            return;
        }
        this.mBackgroundColor = n;
        if (!this.mDrawBackground) {
            return;
        }
        this.mBackgroundPaint.setColor(n);
    }

    public void setDrawBackgroundEnabled(boolean bl) {
        if (this.mDrawBackground == bl) {
            return;
        }
        this.mDrawBackground = bl;
    }

    public void setGradientColors(int n, int[] arrn, float[] arrf, float f) {
        this.mGradientType = n;
        this.mGradientColors = arrn;
        this.mGradientDistributions = arrf;
        this.setupGradientColors(this.mCircleBounds);
        if (this.mGradientType == 0 && this.mGradientAngle != f) {
            this.mGradientAngle = f;
            this.updateGradientAngle(f);
        }
    }

    public void setGradientColorsInternal(int n, int[] arrn, float[] arrf, float f) {
        this.mGradientType = n;
        this.mGradientColors = arrn;
        this.mGradientDistributions = arrf;
        if (n == 0 && this.mGradientAngle != f) {
            this.mGradientAngle = f;
        }
    }

    public void setProgress(float f, boolean bl) {
        if (this.mProgress == f) {
            return;
        }
        this.cancelAnimations();
        if (!bl) {
            this.mProgress = f;
            this.mTextProgress = (int)f;
            this.updateProvidedColors(f);
            this.updateDrawingAngles();
            this.updateText();
            this.mView.onProgressUpdated(this.mProgress);
            this.mView.postInvalidate();
            return;
        }
        this.updateAnimations(f);
    }

    public void setProgressColor(int n) {
        AdaptiveColorProvider adaptiveColorProvider = this.mAdaptiveColorProvider;
        if (adaptiveColorProvider != null && adaptiveColorProvider.provideProgressColor(this.mProgress) != -1 || this.mProgressColor == n) {
            return;
        }
        this.mProgressColor = n;
        this.mProgressPaint.setColor(n);
    }

    public abstract void setStartAngle(float var1);

    public void setTextColor(int n) {
        AdaptiveColorProvider adaptiveColorProvider = this.mAdaptiveColorProvider;
        if (adaptiveColorProvider != null && adaptiveColorProvider.provideTextColor(this.mProgress) != -1 || this.mTextColor == n) {
            return;
        }
        this.mTextColor = n;
        this.mTextPaint.setColor(n);
    }

    public void setTextFormatter(ProgressTextFormatter progressTextFormatter) {
        this.mProvidedTextFormatter = progressTextFormatter;
        this.updateText();
        this.mView.postInvalidate();
    }

    public void setTextShadow(int n, float f, float f2, float f3) {
        if (this.mTextShadowColor == n && this.mTextShadowRadius == f && this.mTextShadowDistX == f2 && this.mTextShadowDistY == f3) {
            return;
        }
        this.mTextShadowColor = n;
        this.mTextShadowRadius = f;
        this.mTextShadowDistX = f2;
        this.mTextShadowDistY = f3;
        this.mTextPaint.setShadowLayer(f, f2, f3, n);
        this.updateText();
    }

    public void setTextSize(float f) {
        if (this.mTextSize == f) {
            return;
        }
        this.mTextSize = f;
        this.mTextPaint.setTextSize(f);
        this.updateText();
    }

    public void setTextStyle(int n) {
        if (this.mTextStyle == n) {
            return;
        }
        this.mTextStyle = n;
        Typeface typeface = this.mTypeface;
        Typeface typeface2 = typeface == null ? Typeface.defaultFromStyle((int)n) : Typeface.create((Typeface)typeface, (int)n);
        this.mTypeface = typeface2;
        this.mTextPaint.setTypeface(typeface2);
        this.updateText();
    }

    public void setTypeface(Typeface typeface) {
        Typeface typeface2 = this.mTypeface;
        if (typeface2 != null && typeface2.equals((Object)typeface)) {
            return;
        }
        int n = this.mTextStyle;
        if (n > 0) {
            typeface = Typeface.create((Typeface)typeface, (int)n);
        }
        this.mTypeface = typeface;
        this.mTextPaint.setTypeface(typeface);
        this.updateText();
    }

    void setup() {
        int n;
        Paint paint;
        ValueAnimator valueAnimator;
        DynamicLayout dynamicLayout;
        Paint paint2;
        TextPaint textPaint;
        this.mCircleBounds = new RectF();
        this.mBackgroundBounds = new RectF();
        this.mProvidedTextColor = -1;
        this.mProvidedBackgroundColor = -1;
        this.mProvidedProgressColor = -1;
        this.mBackgroundPaint = paint = new Paint(1);
        paint.setColor(this.mBackgroundColor);
        this.mProgressPaint = paint2 = new Paint(1);
        paint2.setColor(this.mProgressColor);
        this.mTextPaint = textPaint = new TextPaint(1);
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            this.mTextPaint.setTypeface(typeface);
        }
        if ((n = this.mTextShadowColor) != 0) {
            this.mTextPaint.setShadowLayer(this.mTextShadowRadius, this.mTextShadowDistX, this.mTextShadowDistY, n);
        }
        this.defaultTextFormatter = -$.Lambda.BaseModeRenderer.QG_rVIJ8uDyaFnaXfzA17XdamNA.INSTANCE;
        this.mTextEditor = Editable.Factory.getInstance().newEditable(this.defaultTextFormatter.provideFormattedText(this.mTextProgress));
        this.mTextLayout = Build.VERSION.SDK_INT >= 28 ? DynamicLayout.Builder.obtain((CharSequence)this.mTextEditor, (TextPaint)this.mTextPaint, (int)Integer.MAX_VALUE).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 0.0f).setJustificationMode(0).setBreakStrategy(0).setIncludePad(false).build() : (dynamicLayout = new DynamicLayout((CharSequence)this.mTextEditor, this.mTextPaint, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false));
        float[] arrf = new float[]{0.0f, this.mProgress};
        this.mProgressAnimator = valueAnimator = ValueAnimator.ofFloat((float[])arrf);
        valueAnimator.setDuration((long)this.mAnimDuration);
        this.mProgressAnimator.setInterpolator((TimeInterpolator)this.mAnimInterpolator);
        this.mProgressAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new -$$Lambda$BaseModeRenderer$3iW0AAGI2W_hwL6eA55SyLhb1N0(this));
    }

    void setupColorAnimations() {
        if (this.mProgressColorAnimator == null) {
            ValueAnimator valueAnimator;
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Object[] arrobject = new Object[]{this.mProgressColor, this.mProvidedProgressColor};
            this.mProgressColorAnimator = valueAnimator = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, (Object[])arrobject);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new -$$Lambda$BaseModeRenderer$wm1tRmHpe71Xydd_yz85tXaQyMk(this));
            this.mProgressColorAnimator.setDuration((long)this.mAnimDuration);
        }
        if (this.mBackgroundColorAnimator == null) {
            ValueAnimator valueAnimator;
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Object[] arrobject = new Object[]{this.mBackgroundColor, this.mProvidedBackgroundColor};
            this.mBackgroundColorAnimator = valueAnimator = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, (Object[])arrobject);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new -$$Lambda$BaseModeRenderer$3nnPlAUoXwwgNXluZp0m-EuBQIU(this));
            this.mBackgroundColorAnimator.setDuration((long)this.mAnimDuration);
        }
        if (this.mTextColorAnimator == null) {
            ValueAnimator valueAnimator;
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Object[] arrobject = new Object[]{this.mTextColor, this.mProvidedTextColor};
            this.mTextColorAnimator = valueAnimator = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, (Object[])arrobject);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new -$$Lambda$BaseModeRenderer$HP7Bld75AuZHhx4S1dguxZOrN78(this));
            this.mTextColorAnimator.setDuration((long)this.mAnimDuration);
        }
    }

    abstract void setupGradientColors(RectF var1);

    void updateAnimations(float f) {
        int n;
        int n2;
        ValueAnimator valueAnimator = this.mProgressAnimator;
        float[] arrf = new float[]{this.mProgress, f};
        valueAnimator.setFloatValues(arrf);
        this.mProgressAnimator.start();
        AdaptiveColorProvider adaptiveColorProvider = this.mAdaptiveColorProvider;
        if (adaptiveColorProvider == null) {
            return;
        }
        int n3 = adaptiveColorProvider.provideProgressColor(f);
        if (n3 != -1 && n3 != this.mProvidedProgressColor && this.mGradientType == -1) {
            this.mProvidedProgressColor = n3;
            this.mProgressPaint.setColor(n3);
        }
        if ((n2 = this.mAdaptiveColorProvider.provideBackgroundColor(f)) != -1 && n2 != this.mProvidedBackgroundColor) {
            this.mProvidedBackgroundColor = n2;
            this.mBackgroundPaint.setColor(n2);
        }
        if ((n = this.mAdaptiveColorProvider.provideTextColor(f)) != -1 && n != this.mProvidedTextColor) {
            this.mProvidedTextColor = n;
            this.mTextPaint.setColor(n);
        }
    }

    abstract void updateDrawingAngles();

    abstract void updateGradientAngle(float var1);

    void updateProvidedColors(float f) {
        int n;
        int n2;
        AdaptiveColorProvider adaptiveColorProvider = this.mAdaptiveColorProvider;
        if (adaptiveColorProvider == null) {
            return;
        }
        int n3 = adaptiveColorProvider.provideProgressColor(f);
        if (n3 != -1 && n3 != this.mProvidedProgressColor && this.mGradientType == -1) {
            this.mProvidedProgressColor = n3;
            this.mProgressPaint.setColor(n3);
        }
        if ((n2 = this.mAdaptiveColorProvider.provideBackgroundColor(f)) != -1 && n2 != this.mProvidedBackgroundColor) {
            this.mProvidedBackgroundColor = n2;
            this.mBackgroundPaint.setColor(n2);
        }
        if ((n = this.mAdaptiveColorProvider.provideTextColor(f)) != -1 && n != this.mProvidedTextColor) {
            this.mProvidedTextColor = n;
            this.mTextPaint.setColor(n);
        }
    }

    void updateText() {
        if (this.mTextEditor != null) {
            ProgressTextFormatter progressTextFormatter = this.mProvidedTextFormatter;
            CharSequence charSequence = progressTextFormatter != null ? progressTextFormatter.provideFormattedText(this.mTextProgress) : this.defaultTextFormatter.provideFormattedText(this.mTextProgress);
            this.mTextEditor.clear();
            this.mTextEditor.append(charSequence);
        }
    }
}

