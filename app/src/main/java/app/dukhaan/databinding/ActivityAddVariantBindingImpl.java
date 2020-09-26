/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityAddVariantBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityAddVariantBinding;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import com.google.android.material.appbar.MaterialToolbar;

public class ActivityAddVariantBindingImpl
extends ActivityAddVariantBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362571, 2);
        sViewsWithIds.put(2131361974, 3);
        sViewsWithIds.put(2131362476, 4);
        sViewsWithIds.put(2131362155, 5);
        sViewsWithIds.put(2131362477, 6);
        sViewsWithIds.put(2131362475, 7);
        sViewsWithIds.put(2131362478, 8);
        sViewsWithIds.put(2131361916, 9);
        sViewsWithIds.put(2131361956, 10);
        sViewsWithIds.put(2131362149, 11);
        sViewsWithIds.put(2131361957, 12);
        sViewsWithIds.put(2131361955, 13);
        sViewsWithIds.put(2131361958, 14);
        sViewsWithIds.put(2131361915, 15);
        sViewsWithIds.put(2131362163, 16);
    }

    public ActivityAddVariantBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityAddVariantBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)17, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityAddVariantBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[15], (TextView)arrobject[9], (LinearLayout)arrobject[13], (RelativeLayout)arrobject[10], (ImageView)arrobject[12], (LinearLayout)arrobject[14], (LinearLayout)arrobject[3], (PrimaryButtonShadowed)((Object)arrobject[16]), (TextView)arrobject[11], (TextView)arrobject[5], (LinearLayout)arrobject[7], (RelativeLayout)arrobject[4], (ImageView)arrobject[6], (LinearLayout)arrobject[8], (TextView)arrobject[2], (MaterialToolbar)arrobject[1]);
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
        ActivityAddVariantBindingImpl activityAddVariantBindingImpl = this;
        synchronized (activityAddVariantBindingImpl) {
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
        ActivityAddVariantBindingImpl activityAddVariantBindingImpl = this;
        synchronized (activityAddVariantBindingImpl) {
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
        ActivityAddVariantBindingImpl activityAddVariantBindingImpl = this;
        synchronized (activityAddVariantBindingImpl) {
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

