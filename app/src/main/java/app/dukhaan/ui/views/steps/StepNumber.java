/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  app.dukhaan.databinding.LayoutStepNumberBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.steps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.dukhaan.databinding.LayoutStepNumberBinding;

public class StepNumber
extends FrameLayout {
    private LayoutStepNumberBinding binding;
    private boolean isCompleted;
    private boolean isDisabled;
    private int stepNumber;

    public StepNumber(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public StepNumber(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public StepNumber(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        this.binding.number.setText((CharSequence)String.valueOf((int)this.stepNumber));
        if (this.isCompleted) {
            this.binding.container.setBackground(this.getResources().getDrawable(2131230855));
            this.binding.number.setVisibility(8);
            this.binding.check.setVisibility(0);
            return;
        }
        this.binding.container.setBackground(this.getResources().getDrawable(2131230856));
        this.binding.number.setVisibility(0);
        this.binding.check.setVisibility(8);
        if (this.isDisabled) {
            this.binding.container.setBackground(this.getResources().getDrawable(2131230854));
            this.binding.number.setTextColor(this.getResources().getColor(2131099821));
        }
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutStepNumberBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    public void setData(int n, boolean bl, boolean bl2) {
        this.stepNumber = n;
        this.isCompleted = bl;
        this.isDisabled = bl2;
        this.applyStyle();
    }
}

