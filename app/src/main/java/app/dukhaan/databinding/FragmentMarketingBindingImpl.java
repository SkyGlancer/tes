/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.FragmentMarketingBinding;
import app.dukhaan.ui.views.FullButtonShadowed;

public class FragmentMarketingBindingImpl
extends FragmentMarketingBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362228, 1);
        sViewsWithIds.put(2131362231, 2);
        sViewsWithIds.put(2131362232, 3);
        sViewsWithIds.put(2131362229, 4);
        sViewsWithIds.put(2131362233, 5);
        sViewsWithIds.put(2131362234, 6);
        sViewsWithIds.put(2131362045, 7);
        sViewsWithIds.put(2131362319, 8);
    }

    public FragmentMarketingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentMarketingBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)9, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentMarketingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[7], (LinearLayout)arrobject[1], (LinearLayout)arrobject[4], (LinearLayout)arrobject[2], (LinearLayout)arrobject[3], (LinearLayout)arrobject[5], (LinearLayout)arrobject[6], (FullButtonShadowed)((Object)arrobject[8]));
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
        FragmentMarketingBindingImpl fragmentMarketingBindingImpl = this;
        synchronized (fragmentMarketingBindingImpl) {
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
        FragmentMarketingBindingImpl fragmentMarketingBindingImpl = this;
        synchronized (fragmentMarketingBindingImpl) {
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
        FragmentMarketingBindingImpl fragmentMarketingBindingImpl = this;
        synchronized (fragmentMarketingBindingImpl) {
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

