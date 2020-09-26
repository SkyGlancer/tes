/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.FragmentOnboardingStepsBinding;
import app.dukhaan.ui.views.steps.StepInstructionCard;
import app.dukhaan.ui.views.steps.StepNumber;

public class FragmentOnboardingStepsBindingImpl
extends FragmentOnboardingStepsBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362266, 1);
        sViewsWithIds.put(2131362516, 2);
        sViewsWithIds.put(2131362517, 3);
        sViewsWithIds.put(2131362518, 4);
        sViewsWithIds.put(2131362230, 5);
        sViewsWithIds.put(2131362231, 6);
        sViewsWithIds.put(2131362232, 7);
        sViewsWithIds.put(2131362273, 8);
        sViewsWithIds.put(2131362274, 9);
    }

    public FragmentOnboardingStepsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentOnboardingStepsBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)10, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentOnboardingStepsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (StepInstructionCard)((Object)arrobject[5]), (StepInstructionCard)((Object)arrobject[6]), (StepInstructionCard)((Object)arrobject[7]), (TextView)arrobject[1], (View)arrobject[8], (View)arrobject[9], (StepNumber)((Object)arrobject[2]), (StepNumber)((Object)arrobject[3]), (StepNumber)((Object)arrobject[4]));
        this.mboundView0 = constraintLayout = (ConstraintLayout)arrobject[0];
        constraintLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        FragmentOnboardingStepsBindingImpl fragmentOnboardingStepsBindingImpl = this;
        synchronized (fragmentOnboardingStepsBindingImpl) {
            this.mDirtyFlags = 0L;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        FragmentOnboardingStepsBindingImpl fragmentOnboardingStepsBindingImpl = this;
        synchronized (fragmentOnboardingStepsBindingImpl) {
            return this.mDirtyFlags != 0L;
            {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        FragmentOnboardingStepsBindingImpl fragmentOnboardingStepsBindingImpl = this;
        synchronized (fragmentOnboardingStepsBindingImpl) {
            this.mDirtyFlags = 1L;
        }
        this.requestRebind();
    }

    protected boolean onFieldChange(int n, Object object, int n2) {
        return false;
    }

    public boolean setVariable(int n, Object object) {
        return true;
    }
}

