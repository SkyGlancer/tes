/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.LayoutOrderFilterChipGroupBinding;
import app.dukhaan.ui.views.orders.OrderFilterChip;

public class LayoutOrderFilterChipGroupBindingImpl
extends LayoutOrderFilterChipGroupBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362072, 1);
        sViewsWithIds.put(2131362073, 2);
        sViewsWithIds.put(2131362071, 3);
    }

    public LayoutOrderFilterChipGroupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, LayoutOrderFilterChipGroupBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)4, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private LayoutOrderFilterChipGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        LinearLayout linearLayout;
        super((Object)dataBindingComponent, view, 0, (OrderFilterChip)((Object)arrobject[3]), (OrderFilterChip)((Object)arrobject[1]), (OrderFilterChip)((Object)arrobject[2]));
        this.mboundView0 = linearLayout = (LinearLayout)arrobject[0];
        linearLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        LayoutOrderFilterChipGroupBindingImpl layoutOrderFilterChipGroupBindingImpl = this;
        synchronized (layoutOrderFilterChipGroupBindingImpl) {
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
        LayoutOrderFilterChipGroupBindingImpl layoutOrderFilterChipGroupBindingImpl = this;
        synchronized (layoutOrderFilterChipGroupBindingImpl) {
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
        LayoutOrderFilterChipGroupBindingImpl layoutOrderFilterChipGroupBindingImpl = this;
        synchronized (layoutOrderFilterChipGroupBindingImpl) {
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

