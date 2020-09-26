/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivitySplashBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivitySplashBinding;

public class ActivitySplashBindingImpl
extends ActivitySplashBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362297, 1);
        sViewsWithIds.put(2131362496, 2);
        sViewsWithIds.put(2131362495, 3);
    }

    public ActivitySplashBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivitySplashBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)4, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivitySplashBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (ImageView)arrobject[1], (LinearLayout)arrobject[3], (LinearLayout)arrobject[2]);
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
        ActivitySplashBindingImpl activitySplashBindingImpl = this;
        synchronized (activitySplashBindingImpl) {
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
        ActivitySplashBindingImpl activitySplashBindingImpl = this;
        synchronized (activitySplashBindingImpl) {
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
        ActivitySplashBindingImpl activitySplashBindingImpl = this;
        synchronized (activitySplashBindingImpl) {
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

