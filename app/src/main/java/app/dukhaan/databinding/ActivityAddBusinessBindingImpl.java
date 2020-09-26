/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityAddBusinessBinding
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityAddBusinessBinding;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;

public class ActivityAddBusinessBindingImpl
extends ActivityAddBusinessBinding {
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
        sViewsWithIds.put(2131362188, 4);
        sViewsWithIds.put(2131362189, 5);
        sViewsWithIds.put(2131362154, 6);
        sViewsWithIds.put(2131362186, 7);
        sViewsWithIds.put(2131362191, 8);
        sViewsWithIds.put(2131362163, 9);
    }

    public ActivityAddBusinessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityAddBusinessBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)10, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityAddBusinessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (ConstraintLayout)arrobject[2], (PrimaryButton)((Object)arrobject[9]), (TextView)arrobject[7], (AppCompatEditText)arrobject[4], (TextView)arrobject[5], (AppCompatEditText)arrobject[8], (SpinnerImage)((Object)arrobject[6]), (TextView)arrobject[3], (Toolbar)arrobject[1]);
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
        ActivityAddBusinessBindingImpl activityAddBusinessBindingImpl = this;
        synchronized (activityAddBusinessBindingImpl) {
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
        ActivityAddBusinessBindingImpl activityAddBusinessBindingImpl = this;
        synchronized (activityAddBusinessBindingImpl) {
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
        ActivityAddBusinessBindingImpl activityAddBusinessBindingImpl = this;
        synchronized (activityAddBusinessBindingImpl) {
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

