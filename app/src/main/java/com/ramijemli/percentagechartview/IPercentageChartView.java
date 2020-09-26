/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.ramijemli.percentagechartview;

import android.content.Context;

public interface IPercentageChartView {
    public int getHeight();

    public Context getViewContext();

    public int getWidth();

    public boolean isInEditMode();

    public void onProgressUpdated(float var1);

    public void postInvalidate();

    public void postInvalidateOnAnimation();
}

