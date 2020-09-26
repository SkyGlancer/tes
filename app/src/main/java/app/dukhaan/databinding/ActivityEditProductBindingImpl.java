/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.Space
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.recyclerview.widget.RecyclerView
 *  app.dukhaan.databinding.ActivityEditProductBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ActivityEditProductBinding;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import com.google.android.material.appbar.MaterialToolbar;

public class ActivityEditProductBindingImpl
extends ActivityEditProductBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362571, 2);
        sViewsWithIds.put(2131362414, 3);
        sViewsWithIds.put(2131362268, 4);
        sViewsWithIds.put(2131362054, 5);
        sViewsWithIds.put(2131362643, 6);
        sViewsWithIds.put(2131362492, 7);
        sViewsWithIds.put(2131362057, 8);
        sViewsWithIds.put(2131362287, 9);
        sViewsWithIds.put(2131362056, 10);
        sViewsWithIds.put(2131362285, 11);
        sViewsWithIds.put(2131362059, 12);
        sViewsWithIds.put(2131362288, 13);
        sViewsWithIds.put(2131362058, 14);
        sViewsWithIds.put(2131361982, 15);
        sViewsWithIds.put(2131362289, 16);
        sViewsWithIds.put(2131362060, 17);
        sViewsWithIds.put(2131362645, 18);
        sViewsWithIds.put(2131362630, 19);
        sViewsWithIds.put(2131362402, 20);
        sViewsWithIds.put(2131362494, 21);
        sViewsWithIds.put(2131362101, 22);
        sViewsWithIds.put(2131362055, 23);
        sViewsWithIds.put(2131361917, 24);
        sViewsWithIds.put(2131362265, 25);
        sViewsWithIds.put(2131362286, 26);
        sViewsWithIds.put(2131362250, 27);
        sViewsWithIds.put(2131362050, 28);
        sViewsWithIds.put(2131362021, 29);
        sViewsWithIds.put(2131361871, 30);
    }

    public ActivityEditProductBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityEditProductBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)31, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityEditProductBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        super((Object)dataBindingComponent, view, 0, (PrimaryButton)((Object)arrobject[30]), (TextView)arrobject[24], (TextView)arrobject[15], (Space)arrobject[29], (TextView)arrobject[28], (AppCompatEditText)arrobject[5], (AppCompatEditText)arrobject[23], (AppCompatEditText)arrobject[10], (AppCompatEditText)arrobject[8], (AppCompatEditText)arrobject[14], (AppCompatEditText)arrobject[12], (AppCompatEditText)arrobject[17], (Guideline)arrobject[22], (ImageView)arrobject[27], (TextView)arrobject[25], (TextView)arrobject[4], (RelativeLayout)arrobject[11], (LinearLayout)arrobject[26], (RelativeLayout)arrobject[9], (RelativeLayout)arrobject[13], (RelativeLayout)arrobject[16], (TextView)arrobject[20], (RecyclerView)arrobject[3], (SpinnerImage)((Object)arrobject[7]), (SpinnerImage)((Object)arrobject[21]), (TextView)arrobject[2], (MaterialToolbar)arrobject[1], (TextView)arrobject[19], (View)arrobject[6], (View)arrobject[18]);
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
        ActivityEditProductBindingImpl activityEditProductBindingImpl = this;
        synchronized (activityEditProductBindingImpl) {
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
        ActivityEditProductBindingImpl activityEditProductBindingImpl = this;
        synchronized (activityEditProductBindingImpl) {
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
        ActivityEditProductBindingImpl activityEditProductBindingImpl = this;
        synchronized (activityEditProductBindingImpl) {
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

