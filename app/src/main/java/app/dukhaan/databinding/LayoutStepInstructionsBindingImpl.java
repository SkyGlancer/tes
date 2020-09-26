/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.LayoutStepInstructionsBinding;

public class LayoutStepInstructionsBindingImpl
extends LayoutStepInstructionsBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362568, 1);
        sViewsWithIds.put(2131362229, 2);
        sViewsWithIds.put(2131362278, 3);
        sViewsWithIds.put(2131361923, 4);
    }

    public LayoutStepInstructionsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, LayoutStepInstructionsBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)5, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private LayoutStepInstructionsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[4], (ConstraintLayout)arrobject[0], (TextView)arrobject[2], (TextView)arrobject[3], (TextView)arrobject[1]);
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
        LayoutStepInstructionsBindingImpl layoutStepInstructionsBindingImpl = this;
        synchronized (layoutStepInstructionsBindingImpl) {
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
        LayoutStepInstructionsBindingImpl layoutStepInstructionsBindingImpl = this;
        synchronized (layoutStepInstructionsBindingImpl) {
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
        LayoutStepInstructionsBindingImpl layoutStepInstructionsBindingImpl = this;
        synchronized (layoutStepInstructionsBindingImpl) {
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

