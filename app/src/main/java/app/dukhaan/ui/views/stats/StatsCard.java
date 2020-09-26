/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  app.dukhaan.databinding.LayoutStatCardBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.stats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import app.dukhaan.databinding.LayoutStatCardBinding;
import app.dukhaan.ui.views.model.StatsCardData;

public class StatsCard
extends FrameLayout {
    private LayoutStatCardBinding binding;

    public StatsCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public StatsCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public StatsCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutStatCardBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    public void setData(StatsCardData statsCardData) {
        this.binding.label.setText((CharSequence)statsCardData.label);
        this.binding.value.setText((CharSequence)statsCardData.value);
    }
}

