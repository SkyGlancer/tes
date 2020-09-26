/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityVerifyMobileBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityVerifyMobileBinding;
import app.dukhaan.ui.views.PrimaryButton;

public class ActivityVerifyMobileBindingImpl
extends ActivityVerifyMobileBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362198, 2);
        sViewsWithIds.put(2131362076, 3);
        sViewsWithIds.put(2131362183, 4);
        sViewsWithIds.put(2131362175, 5);
        sViewsWithIds.put(2131362194, 6);
        sViewsWithIds.put(2131362190, 7);
        sViewsWithIds.put(2131362644, 8);
        sViewsWithIds.put(2131362167, 9);
    }

    public ActivityVerifyMobileBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityVerifyMobileBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)10, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityVerifyMobileBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (LinearLayout)arrobject[3], (PrimaryButton)((Object)arrobject[9]), (ImageView)arrobject[5], (ImageView)arrobject[4], (AppCompatEditText)arrobject[7], (TextView)arrobject[6], (TextView)arrobject[2], (Toolbar)arrobject[1], (View)arrobject[8]);
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
        ActivityVerifyMobileBindingImpl activityVerifyMobileBindingImpl = this;
        synchronized (activityVerifyMobileBindingImpl) {
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
        ActivityVerifyMobileBindingImpl activityVerifyMobileBindingImpl = this;
        synchronized (activityVerifyMobileBindingImpl) {
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
        ActivityVerifyMobileBindingImpl activityVerifyMobileBindingImpl = this;
        synchronized (activityVerifyMobileBindingImpl) {
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

