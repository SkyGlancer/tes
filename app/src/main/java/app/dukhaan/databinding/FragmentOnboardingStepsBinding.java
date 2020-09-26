/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.ui.views.steps.StepInstructionCard;
import app.dukhaan.ui.views.steps.StepNumber;

public abstract class FragmentOnboardingStepsBinding
extends ViewDataBinding {
    public final StepInstructionCard instruction1;
    public final StepInstructionCard instruction2;
    public final StepInstructionCard instruction3;
    public final TextView lblCompletion;
    public final View line1;
    public final View line2;
    public final StepNumber step1;
    public final StepNumber step2;
    public final StepNumber step3;

    protected FragmentOnboardingStepsBinding(Object object, View view, int n, StepInstructionCard stepInstructionCard, StepInstructionCard stepInstructionCard2, StepInstructionCard stepInstructionCard3, TextView textView, View view2, View view3, StepNumber stepNumber, StepNumber stepNumber2, StepNumber stepNumber3) {
        super(object, view, n);
        this.instruction1 = stepInstructionCard;
        this.instruction2 = stepInstructionCard2;
        this.instruction3 = stepInstructionCard3;
        this.lblCompletion = textView;
        this.line1 = view2;
        this.line2 = view3;
        this.step1 = stepNumber;
        this.step2 = stepNumber2;
        this.step3 = stepNumber3;
    }

    public static FragmentOnboardingStepsBinding bind(View view) {
        return FragmentOnboardingStepsBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingStepsBinding bind(View view, Object object) {
        return (FragmentOnboardingStepsBinding)FragmentOnboardingStepsBinding.bind((Object)object, (View)view, (int)2131558499);
    }

    public static FragmentOnboardingStepsBinding inflate(LayoutInflater layoutInflater) {
        return FragmentOnboardingStepsBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static FragmentOnboardingStepsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return FragmentOnboardingStepsBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingStepsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (FragmentOnboardingStepsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558499, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static FragmentOnboardingStepsBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (FragmentOnboardingStepsBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558499, null, (boolean)false, (Object)object);
    }
}

