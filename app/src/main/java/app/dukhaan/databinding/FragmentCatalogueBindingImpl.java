/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  com.google.android.material.tabs.TabLayout
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.FragmentCatalogueBinding;
import com.google.android.material.tabs.TabLayout;

public class FragmentCatalogueBindingImpl
extends FragmentCatalogueBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362435, 1);
        sViewsWithIds.put(2131362039, 2);
    }

    public FragmentCatalogueBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentCatalogueBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)3, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentCatalogueBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (FrameLayout)arrobject[2], (TabLayout)arrobject[1]);
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
        FragmentCatalogueBindingImpl fragmentCatalogueBindingImpl = this;
        synchronized (fragmentCatalogueBindingImpl) {
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
        FragmentCatalogueBindingImpl fragmentCatalogueBindingImpl = this;
        synchronized (fragmentCatalogueBindingImpl) {
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
        FragmentCatalogueBindingImpl fragmentCatalogueBindingImpl = this;
        synchronized (fragmentCatalogueBindingImpl) {
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

