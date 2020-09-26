/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Typeface
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.ClassCastException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.ramijemli.percentagechartview.IPercentageChartView;
import com.ramijemli.percentagechartview.R;
import com.ramijemli.percentagechartview.callback.AdaptiveColorProvider;
import com.ramijemli.percentagechartview.callback.OnProgressChangeListener;
import com.ramijemli.percentagechartview.callback.ProgressTextFormatter;
import com.ramijemli.percentagechartview.renderer.BaseModeRenderer;
import com.ramijemli.percentagechartview.renderer.FillModeRenderer;
import com.ramijemli.percentagechartview.renderer.OffsetEnabledMode;
import com.ramijemli.percentagechartview.renderer.OrientationBasedMode;
import com.ramijemli.percentagechartview.renderer.PieModeRenderer;
import com.ramijemli.percentagechartview.renderer.RingModeRenderer;

public class PercentageChartView
extends View
implements IPercentageChartView {
    private static final String STATE_BG_BAR_COLOR = "PercentageChartView.STATE_BG_BAR_COLOR";
    private static final String STATE_BG_BAR_THICKNESS = "PercentageChartView.STATE_BG_BAR_THICKNESS";
    private static final String STATE_BG_COLOR = "PercentageChartView.STATE_BG_COLOR";
    private static final String STATE_BG_OFFSET = "PercentageChartView.STATE_BG_OFFSET";
    private static final String STATE_DRAW_BG = "PercentageChartView.STATE_DRAW_BG";
    private static final String STATE_DRAW_BG_BAR = "PercentageChartView.STATE_DRAW_BG_BAR";
    private static final String STATE_DURATION = "PercentageChartView.STATE_DURATION";
    private static final String STATE_GRADIENT_ANGLE = "PercentageChartView.STATE_GRADIENT_ANGLE";
    private static final String STATE_GRADIENT_COLORS = "PercentageChartView.STATE_GRADIENT_COLORS";
    private static final String STATE_GRADIENT_POSITIONS = "PercentageChartView.STATE_GRADIENT_POSITIONS";
    private static final String STATE_GRADIENT_TYPE = "PercentageChartView.STATE_GRADIENT_TYPE";
    private static final String STATE_MODE = "PercentageChartView.STATE_MODE";
    private static final String STATE_ORIENTATION = "PercentageChartView.STATE_ORIENTATION";
    private static final String STATE_PG_BAR_STYLE = "PercentageChartView.STATE_PG_BAR_STYLE";
    private static final String STATE_PG_BAR_THICKNESS = "PercentageChartView.STATE_PG_BAR_THICKNESS";
    private static final String STATE_PG_COLOR = "PercentageChartView.STATE_PG_COLOR";
    private static final String STATE_PROGRESS = "PercentageChartView.STATE_PROGRESS";
    private static final String STATE_START_ANGLE = "PercentageChartView.STATE_START_ANGLE";
    private static final String STATE_SUPER_INSTANCE = "PercentageChartView.STATE_SUPER_INSTANCE";
    private static final String STATE_TXT_COLOR = "PercentageChartView.STATE_TXT_COLOR";
    private static final String STATE_TXT_SHA_COLOR = "PercentageChartView.STATE_TXT_SHD_COLOR";
    private static final String STATE_TXT_SHA_DIST_X = "PercentageChartView.STATE_TXT_SHA_DIST_X";
    private static final String STATE_TXT_SHA_DIST_Y = "PercentageChartView.STATE_TXT_SHA_DIST_Y";
    private static final String STATE_TXT_SHA_RADIUS = "PercentageChartView.STATE_TXT_SHA_RADIUS";
    private static final String STATE_TXT_SIZE = "PercentageChartView.STATE_TXT_SIZE";
    private int mode;
    private OnProgressChangeListener onProgressChangeListener;
    private BaseModeRenderer renderer;

    public PercentageChartView(Context context) {
        super(context);
        this.init(context, null);
    }

    public PercentageChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet);
    }

    public PercentageChartView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    public PercentageChartView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context, attributeSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PercentageChartView, 0, 0);
            try {
                int n;
                this.mode = n = typedArray.getInt(R.styleable.PercentageChartView_pcv_mode, 1);
                if (n != 0) {
                    if (n != 2) {
                        this.renderer = new PieModeRenderer(this, typedArray);
                    }
                    this.renderer = new FillModeRenderer(this, typedArray);
                }
                this.renderer = new RingModeRenderer(this, typedArray);
            }
            finally {
                typedArray.recycle();
            }
        } else {
            this.mode = 1;
            this.renderer = new PieModeRenderer(this);
        }
        this.setSaveEnabled(true);
    }

    public PercentageChartView animationDuration(int n) {
        if (n >= 50) {
            this.renderer.setAnimationDuration(n);
            return this;
        }
        throw new IllegalArgumentException("Duration must be equal or greater than 50.");
    }

    public PercentageChartView animationInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            this.renderer.setAnimationInterpolator(timeInterpolator);
            return this;
        }
        throw new IllegalArgumentException("Animation interpolator cannot be null");
    }

    public void apply() {
        this.postInvalidate();
    }

    public PercentageChartView backgroundBarColor(int n) {
        try {
            ((RingModeRenderer)this.renderer).setBackgroundBarColor(n);
            return this;
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException("Background bar color is not support by the used percentage chart mode.");
        }
    }

    public PercentageChartView backgroundBarThickness(float f) {
        if (!(f < 0.0f)) {
            try {
                ((RingModeRenderer)this.renderer).setBackgroundBarThickness(f);
                return this;
            }
            catch (ClassCastException classCastException) {
                throw new IllegalArgumentException("Background bar thickness is not support by the used percentage chart mode.");
            }
        }
        throw new IllegalArgumentException("Background bar thickness must be a positive value.");
    }

    public PercentageChartView backgroundColor(int n) {
        this.renderer.setBackgroundColor(n);
        return this;
    }

    public PercentageChartView backgroundOffset(int n) {
        if (n >= 0) {
            try {
                ((OffsetEnabledMode)((Object)this.renderer)).setBackgroundOffset(n);
                return this;
            }
            catch (ClassCastException classCastException) {
                throw new IllegalArgumentException("Background offset is not support by the used percentage chart mode.");
            }
        }
        throw new IllegalArgumentException("Background offset must be a positive value.");
    }

    public PercentageChartView drawBackgroundBarEnabled(boolean bl) {
        try {
            ((RingModeRenderer)this.renderer).setDrawBackgroundBarEnabled(bl);
            return this;
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException("Background bar's drawing state is not support by the used percentage chart mode.");
        }
    }

    public PercentageChartView drawBackgroundEnabled(boolean bl) {
        this.renderer.setDrawBackgroundEnabled(bl);
        return this;
    }

    public int getAnimationDuration() {
        return this.renderer.getAnimationDuration();
    }

    public TimeInterpolator getAnimationInterpolator() {
        return this.renderer.getAnimationInterpolator();
    }

    public int getBackgroundBarColor() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof RingModeRenderer)) {
            return -1;
        }
        return ((RingModeRenderer)baseModeRenderer).getBackgroundBarColor();
    }

    public float getBackgroundBarThickness() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof RingModeRenderer)) {
            return -1.0f;
        }
        return ((RingModeRenderer)baseModeRenderer).getBackgroundBarThickness();
    }

    public int getBackgroundColor() {
        return this.renderer.getBackgroundColor();
    }

    public float getBackgroundOffset() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof OffsetEnabledMode)) {
            return -1.0f;
        }
        return ((OffsetEnabledMode)((Object)baseModeRenderer)).getBackgroundOffset();
    }

    public int getGradientType() {
        return this.renderer.getGradientType();
    }

    public int getMode() {
        return this.mode;
    }

    public int getOrientation() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof OrientationBasedMode)) {
            return -1;
        }
        return ((OrientationBasedMode)((Object)baseModeRenderer)).getOrientation();
    }

    public float getProgress() {
        return this.renderer.getProgress();
    }

    public int getProgressBarStyle() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof RingModeRenderer)) {
            return -1;
        }
        return ((RingModeRenderer)baseModeRenderer).getProgressBarStyle();
    }

    public float getProgressBarThickness() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof RingModeRenderer)) {
            return -1.0f;
        }
        return ((RingModeRenderer)baseModeRenderer).getProgressBarThickness();
    }

    public int getProgressColor() {
        return this.renderer.getProgressColor();
    }

    public float getStartAngle() {
        return this.renderer.getStartAngle();
    }

    public int getTextColor() {
        return this.renderer.getTextColor();
    }

    public int getTextShadowColor() {
        return this.renderer.getTextShadowColor();
    }

    public float getTextShadowDistX() {
        return this.renderer.getTextShadowDistX();
    }

    public float getTextShadowDistY() {
        return this.renderer.getTextShadowDistY();
    }

    public float getTextShadowRadius() {
        return this.renderer.getTextShadowRadius();
    }

    public float getTextSize() {
        return this.renderer.getTextSize();
    }

    public int getTextStyle() {
        return this.renderer.getTextStyle();
    }

    public Typeface getTypeface() {
        return this.renderer.getTypeface();
    }

    @Override
    public Context getViewContext() {
        return this.getContext();
    }

    public PercentageChartView gradientColors(int n, int[] arrn, float[] arrf, float f) {
        if (n >= 0 && n <= 2) {
            if (arrn != null) {
                this.renderer.setGradientColors(n, arrn, arrf, f);
                return this;
            }
            throw new IllegalArgumentException("Gradient colors int array cannot be null.");
        }
        throw new IllegalArgumentException("Invalid value for progress gradient type.");
    }

    public boolean isDrawBackgroundBarEnabled() {
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (!(baseModeRenderer instanceof RingModeRenderer)) {
            return false;
        }
        return ((RingModeRenderer)baseModeRenderer).isDrawBackgroundBarEnabled();
    }

    public boolean isDrawBackgroundEnabled() {
        return this.renderer.isDrawBackgroundEnabled();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.renderer.destroy();
        this.renderer = null;
        if (this.onProgressChangeListener != null) {
            this.onProgressChangeListener = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.renderer.draw(canvas);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        int n3 = MeasureSpec.getSize((int)n);
        int n4 = MeasureSpec.getSize((int)n2);
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (baseModeRenderer != null) {
            baseModeRenderer.measure(n3, n4, this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        this.setMeasuredDimension(n3, n4);
    }

    @Override
    public void onProgressUpdated(float f) {
        OnProgressChangeListener onProgressChangeListener = this.onProgressChangeListener;
        if (onProgressChangeListener != null) {
            onProgressChangeListener.onProgressChanged(f);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            int n;
            Bundle bundle = (Bundle)parcelable;
            this.mode = n = bundle.getInt(STATE_MODE);
            if (n != 0) {
                this.renderer = n != 2 ? new PieModeRenderer(this) : new FillModeRenderer(this);
            } else {
                RingModeRenderer ringModeRenderer = new RingModeRenderer(this);
                this.renderer = ringModeRenderer;
                ringModeRenderer.setProgressBarThickness(bundle.getFloat(STATE_PG_BAR_THICKNESS));
                ((RingModeRenderer)this.renderer).setProgressBarStyle(bundle.getInt(STATE_PG_BAR_STYLE));
                ((RingModeRenderer)this.renderer).setDrawBackgroundBarEnabled(bundle.getBoolean(STATE_DRAW_BG_BAR));
                ((RingModeRenderer)this.renderer).setBackgroundBarColor(bundle.getInt(STATE_BG_BAR_COLOR));
                ((RingModeRenderer)this.renderer).setBackgroundBarThickness(bundle.getFloat(STATE_BG_BAR_THICKNESS));
            }
            BaseModeRenderer baseModeRenderer = this.renderer;
            if (baseModeRenderer instanceof OrientationBasedMode) {
                ((OrientationBasedMode)((Object)baseModeRenderer)).setOrientation(bundle.getInt(STATE_ORIENTATION));
            }
            this.renderer.setStartAngle(bundle.getFloat(STATE_START_ANGLE));
            this.renderer.setAnimationDuration(bundle.getInt(STATE_DURATION));
            this.renderer.setProgress(bundle.getFloat(STATE_PROGRESS), false);
            this.renderer.setProgressColor(bundle.getInt(STATE_PG_COLOR));
            this.renderer.setDrawBackgroundEnabled(bundle.getBoolean(STATE_DRAW_BG));
            this.renderer.setBackgroundColor(bundle.getInt(STATE_BG_COLOR));
            BaseModeRenderer baseModeRenderer2 = this.renderer;
            if (baseModeRenderer2 instanceof OffsetEnabledMode) {
                ((OffsetEnabledMode)((Object)baseModeRenderer2)).setBackgroundOffset(bundle.getInt(STATE_BG_OFFSET));
            }
            this.renderer.setTextColor(bundle.getInt(STATE_TXT_COLOR));
            this.renderer.setTextSize(bundle.getFloat(STATE_TXT_SIZE));
            this.renderer.setTextShadow(bundle.getInt(STATE_TXT_SHA_COLOR), bundle.getFloat(STATE_TXT_SHA_RADIUS), bundle.getFloat(STATE_TXT_SHA_DIST_X), bundle.getFloat(STATE_TXT_SHA_DIST_Y));
            if (bundle.getInt(STATE_GRADIENT_TYPE, -1) != -1) {
                this.renderer.setGradientColorsInternal(bundle.getInt(STATE_GRADIENT_TYPE), bundle.getIntArray(STATE_GRADIENT_COLORS), bundle.getFloatArray(STATE_GRADIENT_POSITIONS), bundle.getFloat(STATE_GRADIENT_ANGLE));
            }
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER_INSTANCE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SUPER_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_MODE, this.mode);
        BaseModeRenderer baseModeRenderer = this.renderer;
        if (baseModeRenderer instanceof OrientationBasedMode) {
            bundle.putInt(STATE_ORIENTATION, ((OrientationBasedMode)((Object)baseModeRenderer)).getOrientation());
        }
        bundle.putFloat(STATE_START_ANGLE, this.renderer.getStartAngle());
        bundle.putInt(STATE_DURATION, this.renderer.getAnimationDuration());
        bundle.putFloat(STATE_PROGRESS, this.renderer.getProgress());
        bundle.putInt(STATE_PG_COLOR, this.renderer.getProgressColor());
        bundle.putBoolean(STATE_DRAW_BG, this.renderer.isDrawBackgroundEnabled());
        bundle.putInt(STATE_BG_COLOR, this.renderer.getBackgroundColor());
        BaseModeRenderer baseModeRenderer2 = this.renderer;
        if (baseModeRenderer2 instanceof OffsetEnabledMode) {
            bundle.putInt(STATE_BG_OFFSET, ((OffsetEnabledMode)((Object)baseModeRenderer2)).getBackgroundOffset());
        }
        bundle.putInt(STATE_TXT_COLOR, this.renderer.getTextColor());
        bundle.putFloat(STATE_TXT_SIZE, this.renderer.getTextSize());
        bundle.putInt(STATE_TXT_SHA_COLOR, this.renderer.getTextShadowColor());
        bundle.putFloat(STATE_TXT_SHA_RADIUS, this.renderer.getTextShadowRadius());
        bundle.putFloat(STATE_TXT_SHA_DIST_X, this.renderer.getTextShadowDistX());
        bundle.putFloat(STATE_TXT_SHA_DIST_Y, this.renderer.getTextShadowDistY());
        BaseModeRenderer baseModeRenderer3 = this.renderer;
        if (baseModeRenderer3 instanceof RingModeRenderer) {
            bundle.putFloat(STATE_PG_BAR_THICKNESS, ((RingModeRenderer)baseModeRenderer3).getProgressBarThickness());
            bundle.putInt(STATE_PG_BAR_STYLE, ((RingModeRenderer)this.renderer).getProgressBarStyle());
            bundle.putBoolean(STATE_DRAW_BG_BAR, ((RingModeRenderer)this.renderer).isDrawBackgroundBarEnabled());
            bundle.putInt(STATE_BG_BAR_COLOR, ((RingModeRenderer)this.renderer).getBackgroundBarColor());
            bundle.putFloat(STATE_BG_BAR_THICKNESS, ((RingModeRenderer)this.renderer).getBackgroundBarThickness());
        }
        if (this.renderer.getGradientType() != -1) {
            bundle.putInt(STATE_GRADIENT_TYPE, this.renderer.getGradientType());
            bundle.putFloat(STATE_GRADIENT_ANGLE, this.renderer.getGradientAngle());
            bundle.putIntArray(STATE_GRADIENT_COLORS, this.renderer.getGradientColors());
            bundle.putFloatArray(STATE_GRADIENT_POSITIONS, this.renderer.getGradientDistributions());
        }
        return bundle;
    }

    public PercentageChartView orientation(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException("Orientation must be a ProgressOrientation constant.");
        }
        try {
            ((OrientationBasedMode)((Object)this.renderer)).setOrientation(n);
            return this;
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException("Orientation is not support by the used percentage chart mode.");
        }
    }

    public PercentageChartView progressBarStyle(int n) {
        if (n >= 0 && n <= 1) {
            try {
                ((RingModeRenderer)this.renderer).setProgressBarStyle(n);
                return this;
            }
            catch (ClassCastException classCastException) {
                throw new IllegalArgumentException("Progress bar style is not support by the used percentage chart mode.");
            }
        }
        throw new IllegalArgumentException("Progress bar style must be a valid TextStyle constant.");
    }

    public PercentageChartView progressBarThickness(float f) {
        if (!(f < 0.0f)) {
            try {
                ((RingModeRenderer)this.renderer).setProgressBarThickness(f);
                return this;
            }
            catch (ClassCastException classCastException) {
                throw new IllegalArgumentException("Progress bar thickness is not support by the used percentage chart mode.");
            }
        }
        throw new IllegalArgumentException("Progress bar thickness must be a positive value.");
    }

    public PercentageChartView progressColor(int n) {
        this.renderer.setProgressColor(n);
        return this;
    }

    public void setAdaptiveColorProvider(AdaptiveColorProvider adaptiveColorProvider) {
        this.renderer.setAdaptiveColorProvider(adaptiveColorProvider);
    }

    public void setAnimationDuration(int n) {
        this.animationDuration(n);
    }

    public void setAnimationInterpolator(TimeInterpolator timeInterpolator) {
        this.animationInterpolator(timeInterpolator);
    }

    public void setBackgroundBarColor(int n) {
        this.backgroundBarColor(n);
        this.postInvalidate();
    }

    public void setBackgroundBarThickness(float f) {
        this.backgroundBarThickness(f);
        this.postInvalidate();
    }

    public void setBackgroundColor(int n) {
        this.backgroundColor(n);
        this.postInvalidate();
    }

    public void setBackgroundOffset(int n) {
        this.backgroundOffset(n);
        this.postInvalidate();
    }

    public void setDrawBackgroundBarEnabled(boolean bl) {
        this.drawBackgroundBarEnabled(bl);
        this.postInvalidate();
    }

    public void setDrawBackgroundEnabled(boolean bl) {
        this.drawBackgroundEnabled(bl);
        this.postInvalidate();
    }

    public void setGradientColors(int n, int[] arrn, float[] arrf, float f) {
        this.gradientColors(n, arrn, arrf, f);
        this.postInvalidate();
    }

    public void setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.onProgressChangeListener = onProgressChangeListener;
    }

    public void setOrientation(int n) {
        this.orientation(n);
        this.postInvalidate();
    }

    public void setProgress(float f, boolean bl) {
        if (!(f < 0.0f) && !(f > 100.0f)) {
            this.renderer.setProgress(f, bl);
            return;
        }
        throw new IllegalArgumentException("Progress value must be positive and less or equal to 100.");
    }

    public void setProgressBarStyle(int n) {
        this.progressBarStyle(n);
        this.postInvalidate();
    }

    public void setProgressBarThickness(float f) {
        this.progressBarThickness(f);
        this.postInvalidate();
    }

    public void setProgressColor(int n) {
        this.progressColor(n);
        this.postInvalidate();
    }

    public void setStartAngle(float f) {
        this.startAngle(f);
        this.postInvalidate();
    }

    public void setTextColor(int n) {
        this.textColor(n);
        this.postInvalidate();
    }

    public void setTextFormatter(ProgressTextFormatter progressTextFormatter) {
        this.renderer.setTextFormatter(progressTextFormatter);
    }

    public void setTextShadow(int n, float f, float f2, float f3) {
        this.textShadow(n, f, f2, f3);
        this.postInvalidate();
    }

    public void setTextSize(float f) {
        this.textSize(f);
        this.postInvalidate();
    }

    public void setTextStyle(int n) {
        this.textStyle(n);
        this.postInvalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.typeface(typeface);
        this.postInvalidate();
    }

    public PercentageChartView startAngle(float f) {
        if (!(f < 0.0f) && !(f > 360.0f)) {
            this.renderer.setStartAngle(f);
            return this;
        }
        throw new IllegalArgumentException("Start angle value must be positive and less or equal to 360.");
    }

    public PercentageChartView textColor(int n) {
        this.renderer.setTextColor(n);
        return this;
    }

    public PercentageChartView textShadow(int n, float f, float f2, float f3) {
        this.renderer.setTextShadow(n, f, f2, f3);
        return this;
    }

    public PercentageChartView textSize(float f) {
        if (!(f <= 0.0f)) {
            this.renderer.setTextSize(f);
            return this;
        }
        throw new IllegalArgumentException("Text size must be a nonzero positive value.");
    }

    public PercentageChartView textStyle(int n) {
        if (n >= 0 && n <= 3) {
            this.renderer.setTextStyle(n);
            return this;
        }
        throw new IllegalArgumentException("Text style must be a valid TextStyle constant.");
    }

    public PercentageChartView typeface(Typeface typeface) {
        if (typeface != null) {
            this.renderer.setTypeface(typeface);
            return this;
        }
        throw new IllegalArgumentException("Text TypeFace cannot be null");
    }
}

