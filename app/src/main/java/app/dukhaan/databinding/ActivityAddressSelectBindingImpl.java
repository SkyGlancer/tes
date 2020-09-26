/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityAddressSelectBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityAddressSelectBinding;
import app.dukhaan.ui.views.PrimaryButton;

public class ActivityAddressSelectBindingImpl
extends ActivityAddressSelectBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362405, 1);
        sViewsWithIds.put(2131362185, 2);
        sViewsWithIds.put(2131362160, 3);
        sViewsWithIds.put(2131362101, 4);
        sViewsWithIds.put(2131362158, 5);
        sViewsWithIds.put(2131361903, 6);
        sViewsWithIds.put(2131362157, 7);
        sViewsWithIds.put(2131362187, 8);
        sViewsWithIds.put(2131362145, 9);
    }

    public ActivityAddressSelectBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityAddressSelectBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)10, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityAddressSelectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[6], (Guideline)arrobject[4], (TextView)arrobject[7], (TextView)arrobject[5], (ImageView)arrobject[3], (PrimaryButton)((Object)arrobject[9]), (ImageView)arrobject[2], (AppCompatEditText)arrobject[8], (ProgressBar)arrobject[1]);
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
        ActivityAddressSelectBindingImpl activityAddressSelectBindingImpl = this;
        synchronized (activityAddressSelectBindingImpl) {
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
        ActivityAddressSelectBindingImpl activityAddressSelectBindingImpl = this;
        synchronized (activityAddressSelectBindingImpl) {
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
        ActivityAddressSelectBindingImpl activityAddressSelectBindingImpl = this;
        synchronized (activityAddressSelectBindingImpl) {
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

