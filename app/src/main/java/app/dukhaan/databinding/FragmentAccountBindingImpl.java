/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.FragmentAccountBinding;
import com.google.android.material.imageview.ShapeableImageView;

public class FragmentAccountBindingImpl
extends FragmentAccountBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362181, 1);
        sViewsWithIds.put(2131362197, 2);
        sViewsWithIds.put(2131362156, 3);
        sViewsWithIds.put(2131362196, 4);
        sViewsWithIds.put(2131362200, 5);
        sViewsWithIds.put(2131362162, 6);
        sViewsWithIds.put(2131362467, 7);
        sViewsWithIds.put(2131362129, 8);
        sViewsWithIds.put(2131362128, 9);
        sViewsWithIds.put(2131362161, 10);
        sViewsWithIds.put(2131362170, 11);
        sViewsWithIds.put(2131362171, 12);
        sViewsWithIds.put(2131362168, 13);
        sViewsWithIds.put(2131362169, 14);
        sViewsWithIds.put(2131362165, 15);
        sViewsWithIds.put(2131362011, 16);
        sViewsWithIds.put(2131362012, 17);
        sViewsWithIds.put(2131362010, 18);
    }

    public FragmentAccountBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentAccountBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)19, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[18], (LinearLayout)arrobject[16], (TextView)arrobject[17], (ImageView)arrobject[9], (TextView)arrobject[8], (TextView)arrobject[3], (TextView)arrobject[10], (TextView)arrobject[6], (TextView)arrobject[15], (TextView)arrobject[13], (TextView)arrobject[14], (TextView)arrobject[11], (TextView)arrobject[12], (ConstraintLayout)arrobject[1], (TextView)arrobject[4], (ShapeableImageView)arrobject[2], (View)arrobject[5], (LinearLayout)arrobject[7]);
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
        FragmentAccountBindingImpl fragmentAccountBindingImpl = this;
        synchronized (fragmentAccountBindingImpl) {
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
        FragmentAccountBindingImpl fragmentAccountBindingImpl = this;
        synchronized (fragmentAccountBindingImpl) {
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
        FragmentAccountBindingImpl fragmentAccountBindingImpl = this;
        synchronized (fragmentAccountBindingImpl) {
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

