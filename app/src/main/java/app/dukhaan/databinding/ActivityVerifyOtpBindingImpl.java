/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityVerifyOtpBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityVerifyOtpBinding;
import app.dukhaan.otpview.OtpTextView;
import app.dukhaan.ui.views.PrimaryButton;

public class ActivityVerifyOtpBindingImpl
extends ActivityVerifyOtpBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131361974, 2);
        sViewsWithIds.put(2131362155, 3);
        sViewsWithIds.put(2131362381, 4);
        sViewsWithIds.put(2131362618, 5);
        sViewsWithIds.put(2131362144, 6);
    }

    public ActivityVerifyOtpBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityVerifyOtpBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)7, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityVerifyOtpBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (ConstraintLayout)arrobject[2], (PrimaryButton)((Object)arrobject[6]), (TextView)arrobject[3], (OtpTextView)((Object)arrobject[4]), (Toolbar)arrobject[1], (TextView)arrobject[5]);
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
        ActivityVerifyOtpBindingImpl activityVerifyOtpBindingImpl = this;
        synchronized (activityVerifyOtpBindingImpl) {
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
        ActivityVerifyOtpBindingImpl activityVerifyOtpBindingImpl = this;
        synchronized (activityVerifyOtpBindingImpl) {
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
        ActivityVerifyOtpBindingImpl activityVerifyOtpBindingImpl = this;
        synchronized (activityVerifyOtpBindingImpl) {
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

