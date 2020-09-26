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
 *  app.dukhaan.databinding.LayoutEmptyDataCardBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import app.dukhaan.databinding.LayoutEmptyDataCardBinding;

public class EmptyDataCard
extends FrameLayout {
    private LayoutEmptyDataCardBinding binding;
    private String label;

    public EmptyDataCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public EmptyDataCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public EmptyDataCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutEmptyDataCardBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void renderLabel() {
        this.binding.label.setText((CharSequence)this.label);
    }

    public void setData(String string2) {
        this.label = string2;
        this.renderLabel();
    }
}

