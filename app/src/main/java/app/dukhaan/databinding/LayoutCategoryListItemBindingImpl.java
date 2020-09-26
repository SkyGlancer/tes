/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.LayoutCategoryListItemBinding;
import app.dukhaan.ui.views.categories.CategoryListItemCard;

public class LayoutCategoryListItemBindingImpl
extends LayoutCategoryListItemBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    public LayoutCategoryListItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, LayoutCategoryListItemBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)1, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private LayoutCategoryListItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (CategoryListItemCard)((Object)arrobject[0]));
        this.category.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        LayoutCategoryListItemBindingImpl layoutCategoryListItemBindingImpl = this;
        synchronized (layoutCategoryListItemBindingImpl) {
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
        LayoutCategoryListItemBindingImpl layoutCategoryListItemBindingImpl = this;
        synchronized (layoutCategoryListItemBindingImpl) {
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
        LayoutCategoryListItemBindingImpl layoutCategoryListItemBindingImpl = this;
        synchronized (layoutCategoryListItemBindingImpl) {
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

