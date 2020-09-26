/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ProgressBar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.databinding.FragmentCategoriesBinding;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;

public class FragmentCategoriesBindingImpl
extends FragmentCategoriesBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362045, 1);
        sViewsWithIds.put(2131362525, 2);
        sViewsWithIds.put(2131362414, 3);
        sViewsWithIds.put(2131362405, 4);
        sViewsWithIds.put(2131361905, 5);
        sViewsWithIds.put(2131361906, 6);
    }

    public FragmentCategoriesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentCategoriesBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)7, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentCategoriesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (PrimaryButton)((Object)arrobject[5]), (PrimaryButtonShadowed)((Object)arrobject[6]), (ConstraintLayout)arrobject[0], (EmptyDataCard)((Object)arrobject[1]), (ProgressBar)arrobject[4], (RecyclerView)arrobject[3], (SwipeRefreshLayout)arrobject[2]);
        this.container.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        FragmentCategoriesBindingImpl fragmentCategoriesBindingImpl = this;
        synchronized (fragmentCategoriesBindingImpl) {
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
        FragmentCategoriesBindingImpl fragmentCategoriesBindingImpl = this;
        synchronized (fragmentCategoriesBindingImpl) {
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
        FragmentCategoriesBindingImpl fragmentCategoriesBindingImpl = this;
        synchronized (fragmentCategoriesBindingImpl) {
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

