/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityMobileNumberBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityMobileNumberBinding;

public class ActivityMobileNumberBindingImpl
extends ActivityMobileNumberBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    public ActivityMobileNumberBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityMobileNumberBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)1, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityMobileNumberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0);
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
        ActivityMobileNumberBindingImpl activityMobileNumberBindingImpl = this;
        synchronized (activityMobileNumberBindingImpl) {
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
        ActivityMobileNumberBindingImpl activityMobileNumberBindingImpl = this;
        synchronized (activityMobileNumberBindingImpl) {
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
        ActivityMobileNumberBindingImpl activityMobileNumberBindingImpl = this;
        synchronized (activityMobileNumberBindingImpl) {
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

