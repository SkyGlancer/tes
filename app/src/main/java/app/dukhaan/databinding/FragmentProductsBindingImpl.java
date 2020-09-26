/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageButton
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  androidx.appcompat.widget.AppCompatEditText
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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.databinding.FragmentProductsBinding;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;

public class FragmentProductsBindingImpl
extends FragmentProductsBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362520, 1);
        sViewsWithIds.put(2131362449, 2);
        sViewsWithIds.put(2131361953, 3);
        sViewsWithIds.put(2131362045, 4);
        sViewsWithIds.put(2131362525, 5);
        sViewsWithIds.put(2131362414, 6);
        sViewsWithIds.put(2131362405, 7);
        sViewsWithIds.put(2131362508, 8);
        sViewsWithIds.put(2131362509, 9);
    }

    public FragmentProductsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentProductsBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)10, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentProductsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (ImageButton)arrobject[3], (ConstraintLayout)arrobject[0], (EmptyDataCard)((Object)arrobject[4]), (ProgressBar)arrobject[7], (RecyclerView)arrobject[6], (AppCompatEditText)arrobject[2], (PrimaryButton)((Object)arrobject[8]), (PrimaryButtonShadowed)((Object)arrobject[9]), (RelativeLayout)arrobject[1], (SwipeRefreshLayout)arrobject[5]);
        this.content.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        FragmentProductsBindingImpl fragmentProductsBindingImpl = this;
        synchronized (fragmentProductsBindingImpl) {
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
        FragmentProductsBindingImpl fragmentProductsBindingImpl = this;
        synchronized (fragmentProductsBindingImpl) {
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
        FragmentProductsBindingImpl fragmentProductsBindingImpl = this;
        synchronized (fragmentProductsBindingImpl) {
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

