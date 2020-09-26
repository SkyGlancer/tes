/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
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
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.BottomSheetSelectLanguageBinding;

public class BottomSheetSelectLanguageBindingImpl
extends BottomSheetSelectLanguageBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362155, 1);
        sViewsWithIds.put(2131362141, 2);
        sViewsWithIds.put(2131362142, 3);
        sViewsWithIds.put(2131362143, 4);
        sViewsWithIds.put(2131362101, 5);
    }

    public BottomSheetSelectLanguageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, BottomSheetSelectLanguageBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)6, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private BottomSheetSelectLanguageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (Guideline)arrobject[5], (TextView)arrobject[2], (TextView)arrobject[3], (TextView)arrobject[4], (TextView)arrobject[1]);
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
        BottomSheetSelectLanguageBindingImpl bottomSheetSelectLanguageBindingImpl = this;
        synchronized (bottomSheetSelectLanguageBindingImpl) {
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
        BottomSheetSelectLanguageBindingImpl bottomSheetSelectLanguageBindingImpl = this;
        synchronized (bottomSheetSelectLanguageBindingImpl) {
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
        BottomSheetSelectLanguageBindingImpl bottomSheetSelectLanguageBindingImpl = this;
        synchronized (bottomSheetSelectLanguageBindingImpl) {
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

