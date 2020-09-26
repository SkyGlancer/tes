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
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.LayoutOrderFilterChipBinding;

public class LayoutOrderFilterChipBindingImpl
extends LayoutOrderFilterChipBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    public LayoutOrderFilterChipBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, LayoutOrderFilterChipBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)1, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private LayoutOrderFilterChipBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[0]);
        this.label.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        LayoutOrderFilterChipBindingImpl layoutOrderFilterChipBindingImpl = this;
        synchronized (layoutOrderFilterChipBindingImpl) {
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
        LayoutOrderFilterChipBindingImpl layoutOrderFilterChipBindingImpl = this;
        synchronized (layoutOrderFilterChipBindingImpl) {
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
        LayoutOrderFilterChipBindingImpl layoutOrderFilterChipBindingImpl = this;
        synchronized (layoutOrderFilterChipBindingImpl) {
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

