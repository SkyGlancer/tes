/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  com.google.android.material.card.MaterialCardView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.LayoutEmptyDataCardBinding;
import com.google.android.material.card.MaterialCardView;

public class LayoutEmptyDataCardBindingImpl
extends LayoutEmptyDataCardBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final MaterialCardView mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362256, 1);
    }

    public LayoutEmptyDataCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, LayoutEmptyDataCardBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)2, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private LayoutEmptyDataCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        MaterialCardView materialCardView;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[1]);
        this.mboundView0 = materialCardView = (MaterialCardView)arrobject[0];
        materialCardView.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        LayoutEmptyDataCardBindingImpl layoutEmptyDataCardBindingImpl = this;
        synchronized (layoutEmptyDataCardBindingImpl) {
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
        LayoutEmptyDataCardBindingImpl layoutEmptyDataCardBindingImpl = this;
        synchronized (layoutEmptyDataCardBindingImpl) {
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
        LayoutEmptyDataCardBindingImpl layoutEmptyDataCardBindingImpl = this;
        synchronized (layoutEmptyDataCardBindingImpl) {
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

