/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivitySyncContactsBinding
 *  com.airbnb.lottie.LottieAnimationView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivitySyncContactsBinding;
import app.dukhaan.ui.views.PrimaryButtonWhite;
import com.airbnb.lottie.LottieAnimationView;

public class ActivitySyncContactsBindingImpl
extends ActivitySyncContactsBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362127, 1);
        sViewsWithIds.put(2131362290, 2);
        sViewsWithIds.put(2131362568, 3);
        sViewsWithIds.put(2131362025, 4);
        sViewsWithIds.put(2131361904, 5);
    }

    public ActivitySyncContactsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivitySyncContactsBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)6, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivitySyncContactsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (PrimaryButtonWhite)((Object)arrobject[5]), (TextView)arrobject[4], (ImageView)arrobject[1], (LottieAnimationView)arrobject[2], (TextView)arrobject[3]);
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
        ActivitySyncContactsBindingImpl activitySyncContactsBindingImpl = this;
        synchronized (activitySyncContactsBindingImpl) {
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
        ActivitySyncContactsBindingImpl activitySyncContactsBindingImpl = this;
        synchronized (activitySyncContactsBindingImpl) {
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
        ActivitySyncContactsBindingImpl activitySyncContactsBindingImpl = this;
        synchronized (activitySyncContactsBindingImpl) {
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

