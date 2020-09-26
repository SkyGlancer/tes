/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  app.dukhaan.databinding.ActivityBusinessDetailsEditBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityBusinessDetailsEditBinding;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;

public class ActivityBusinessDetailsEditBindingImpl
extends ActivityBusinessDetailsEditBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362197, 2);
        sViewsWithIds.put(2131361911, 3);
        sViewsWithIds.put(2131362264, 4);
        sViewsWithIds.put(2131362176, 5);
        sViewsWithIds.put(2131362051, 6);
        sViewsWithIds.put(2131361922, 7);
        sViewsWithIds.put(2131362053, 8);
        sViewsWithIds.put(2131362178, 9);
        sViewsWithIds.put(2131362493, 10);
        sViewsWithIds.put(2131362180, 11);
        sViewsWithIds.put(2131362179, 12);
        sViewsWithIds.put(2131361921, 13);
    }

    public ActivityBusinessDetailsEditBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityBusinessDetailsEditBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)14, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityBusinessDetailsEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[3], (PrimaryButton)((Object)arrobject[13]), (AppCompatEditText)arrobject[7], (TextView)arrobject[6], (TextView)arrobject[8], (AppCompatEditText)arrobject[5], (TextView)arrobject[9], (TextView)arrobject[12], (TextView)arrobject[11], (ShapeableImageView)arrobject[2], (TextView)arrobject[4], (SpinnerImage)((Object)arrobject[10]), (MaterialToolbar)arrobject[1]);
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
        ActivityBusinessDetailsEditBindingImpl activityBusinessDetailsEditBindingImpl = this;
        synchronized (activityBusinessDetailsEditBindingImpl) {
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
        ActivityBusinessDetailsEditBindingImpl activityBusinessDetailsEditBindingImpl = this;
        synchronized (activityBusinessDetailsEditBindingImpl) {
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
        ActivityBusinessDetailsEditBindingImpl activityBusinessDetailsEditBindingImpl = this;
        synchronized (activityBusinessDetailsEditBindingImpl) {
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

