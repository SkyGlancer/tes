/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.ui.views.products.ProductListItemCard
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ProductListItemBinding;
import app.dukhaan.ui.views.products.ProductListItemCard;

public class ProductListItemBindingImpl
extends ProductListItemBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    public ProductListItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ProductListItemBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)1, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ProductListItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (ProductListItemCard)arrobject[0]);
        this.product.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        ProductListItemBindingImpl productListItemBindingImpl = this;
        synchronized (productListItemBindingImpl) {
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
        ProductListItemBindingImpl productListItemBindingImpl = this;
        synchronized (productListItemBindingImpl) {
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
        ProductListItemBindingImpl productListItemBindingImpl = this;
        synchronized (productListItemBindingImpl) {
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

