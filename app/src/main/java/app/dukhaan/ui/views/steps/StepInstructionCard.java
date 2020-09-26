/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  app.dukhaan.databinding.LayoutStepInstructionsBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.steps;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.dukhaan.databinding.LayoutStepInstructionsBinding;
import app.dukhaan.ui.views.steps.-$$Lambda$StepInstructionCard$0PVACDBrQwp-MIyUu0B-tiJDgQE;
import app.dukhaan.ui.views.steps.-$$Lambda$StepInstructionCard$ngfapG6LLarXJlHrJJOLlhbS4k0;
import app.dukhaan.util.AppUtils;

public class StepInstructionCard
extends FrameLayout {
    private LayoutStepInstructionsBinding binding;
    private StepInstructionCardListener listener;
    private int stepNumber;

    public StepInstructionCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public StepInstructionCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public StepInstructionCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutStepInstructionsBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    static /* synthetic */ void lambda$setListener$0(StepInstructionCardListener stepInstructionCardListener, View view) {
        stepInstructionCardListener.onButtonClicked();
    }

    static /* synthetic */ void lambda$setListener$1(StepInstructionCardListener stepInstructionCardListener, View view) {
        stepInstructionCardListener.onButtonClicked();
    }

    public void setData(int n, String string2, String string3, String string4, boolean bl, boolean bl2) {
        this.setData(n, string2, string3, string4, bl, bl2, false);
    }

    public void setData(int n, String string2, String string3, String string4, boolean bl, boolean bl2, boolean bl3) {
        this.stepNumber = n;
        this.binding.title.setText((CharSequence)string2);
        this.binding.instruction.setText((CharSequence)string3);
        if (bl) {
            this.binding.button.setText((CharSequence)string4);
            this.binding.button.setVisibility(0);
            this.binding.link.setVisibility(8);
            if (!bl2) {
                this.binding.container.setPadding(0, 0, 0, AppUtils.dpToPx(20));
            }
        } else {
            this.binding.link.setText((CharSequence)string4);
            this.binding.link.setVisibility(0);
            this.binding.button.setVisibility(8);
            if (!bl2) {
                this.binding.container.setPadding(0, 0, 0, AppUtils.dpToPx(12));
            }
        }
        if (bl3) {
            this.binding.title.setTextColor(this.getResources().getColor(2131099941));
            this.binding.instruction.setVisibility(8);
            this.binding.link.setVisibility(8);
            this.binding.button.setVisibility(8);
            this.binding.title.setPadding(0, AppUtils.dpToPx(9), 0, 0);
        }
        if (!(n != 1 && n != 2 || bl)) {
            this.binding.container.setPadding(this.binding.container.getPaddingLeft(), this.binding.container.getPaddingTop(), this.binding.container.getPaddingRight(), this.binding.container.getPaddingBottom() + AppUtils.dpToPx(3));
        }
    }

    public void setListener(StepInstructionCardListener stepInstructionCardListener) {
        this.listener = stepInstructionCardListener;
        this.binding.button.setOnClickListener((OnClickListener)new -$$Lambda$StepInstructionCard$0PVACDBrQwp-MIyUu0B-tiJDgQE(stepInstructionCardListener));
        this.binding.link.setOnClickListener((OnClickListener)new -$$Lambda$StepInstructionCard$ngfapG6LLarXJlHrJJOLlhbS4k0(stepInstructionCardListener));
    }

    public static interface StepInstructionCardListener {
        public void onButtonClicked();
    }

}

