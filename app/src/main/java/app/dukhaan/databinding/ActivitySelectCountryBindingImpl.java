/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.recyclerview.widget.RecyclerView
 *  app.dukhaan.databinding.ActivitySelectCountryBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ActivitySelectCountryBinding;

public class ActivitySelectCountryBindingImpl
extends ActivitySelectCountryBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362155, 2);
        sViewsWithIds.put(2131362153, 3);
        sViewsWithIds.put(2131361985, 4);
        sViewsWithIds.put(2131362150, 5);
        sViewsWithIds.put(2131361984, 6);
    }

    public ActivitySelectCountryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivitySelectCountryBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)7, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivitySelectCountryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (RecyclerView)arrobject[6], (EditText)arrobject[4], (TextView)arrobject[5], (TextView)arrobject[3], (TextView)arrobject[2], (Toolbar)arrobject[1]);
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
        ActivitySelectCountryBindingImpl activitySelectCountryBindingImpl = this;
        synchronized (activitySelectCountryBindingImpl) {
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
        ActivitySelectCountryBindingImpl activitySelectCountryBindingImpl = this;
        synchronized (activitySelectCountryBindingImpl) {
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
        ActivitySelectCountryBindingImpl activitySelectCountryBindingImpl = this;
        synchronized (activitySelectCountryBindingImpl) {
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

