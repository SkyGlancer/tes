/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.recyclerview.widget.RecyclerView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.BottomSheetPlacesSearchBinding;

public class BottomSheetPlacesSearchBindingImpl
extends BottomSheetPlacesSearchBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362152, 1);
        sViewsWithIds.put(2131362227, 2);
        sViewsWithIds.put(2131362148, 3);
        sViewsWithIds.put(2131362146, 4);
        sViewsWithIds.put(2131362414, 5);
    }

    public BottomSheetPlacesSearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, BottomSheetPlacesSearchBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)6, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private BottomSheetPlacesSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        RelativeLayout relativeLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[4], (ImageView)arrobject[3], (ConstraintLayout)arrobject[1], (EditText)arrobject[2], (RecyclerView)arrobject[5]);
        this.mboundView0 = relativeLayout = (RelativeLayout)arrobject[0];
        relativeLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        BottomSheetPlacesSearchBindingImpl bottomSheetPlacesSearchBindingImpl = this;
        synchronized (bottomSheetPlacesSearchBindingImpl) {
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
        BottomSheetPlacesSearchBindingImpl bottomSheetPlacesSearchBindingImpl = this;
        synchronized (bottomSheetPlacesSearchBindingImpl) {
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
        BottomSheetPlacesSearchBindingImpl bottomSheetPlacesSearchBindingImpl = this;
        synchronized (bottomSheetPlacesSearchBindingImpl) {
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

