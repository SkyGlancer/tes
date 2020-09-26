/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityGoldSuccessBinding
 *  com.airbnb.lottie.LottieAnimationView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityGoldSuccessBinding;
import app.dukhaan.ui.views.GoldButtonWhite;
import com.airbnb.lottie.LottieAnimationView;

public class ActivityGoldSuccessBindingImpl
extends ActivityGoldSuccessBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362074, 1);
        sViewsWithIds.put(2131362218, 2);
        sViewsWithIds.put(2131362476, 3);
        sViewsWithIds.put(2131361977, 4);
        sViewsWithIds.put(2131361894, 5);
    }

    public ActivityGoldSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityGoldSuccessBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)6, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityGoldSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (GoldButtonWhite)((Object)arrobject[5]), (TextView)arrobject[4], (ImageView)arrobject[1], (LottieAnimationView)arrobject[2], (TextView)arrobject[3]);
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
        ActivityGoldSuccessBindingImpl activityGoldSuccessBindingImpl = this;
        synchronized (activityGoldSuccessBindingImpl) {
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
        ActivityGoldSuccessBindingImpl activityGoldSuccessBindingImpl = this;
        synchronized (activityGoldSuccessBindingImpl) {
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
        ActivityGoldSuccessBindingImpl activityGoldSuccessBindingImpl = this;
        synchronized (activityGoldSuccessBindingImpl) {
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

