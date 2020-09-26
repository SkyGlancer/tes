/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityDeliveryChargesBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityDeliveryChargesBinding;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.material.appbar.MaterialToolbar;

public class ActivityDeliveryChargesBindingImpl
extends ActivityDeliveryChargesBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362022, 2);
        sViewsWithIds.put(2131362400, 3);
        sViewsWithIds.put(2131362092, 4);
        sViewsWithIds.put(2131362401, 5);
        sViewsWithIds.put(2131362101, 6);
        sViewsWithIds.put(2131362438, 7);
    }

    public ActivityDeliveryChargesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityDeliveryChargesBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)8, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityDeliveryChargesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[2], (TextView)arrobject[4], (Guideline)arrobject[6], (AppCompatEditText)arrobject[3], (AppCompatEditText)arrobject[5], (PrimaryButton)((Object)arrobject[7]), (MaterialToolbar)arrobject[1]);
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
        ActivityDeliveryChargesBindingImpl activityDeliveryChargesBindingImpl = this;
        synchronized (activityDeliveryChargesBindingImpl) {
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
        ActivityDeliveryChargesBindingImpl activityDeliveryChargesBindingImpl = this;
        synchronized (activityDeliveryChargesBindingImpl) {
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
        ActivityDeliveryChargesBindingImpl activityDeliveryChargesBindingImpl = this;
        synchronized (activityDeliveryChargesBindingImpl) {
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

