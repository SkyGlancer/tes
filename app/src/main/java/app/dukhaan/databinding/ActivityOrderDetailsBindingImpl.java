/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.core.widget.NestedScrollView
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.recyclerview.widget.RecyclerView
 *  app.dukhaan.databinding.ActivityOrderDetailsBinding
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ActivityOrderDetailsBinding;
import com.google.android.material.appbar.MaterialToolbar;

public class ActivityOrderDetailsBindingImpl
extends ActivityOrderDetailsBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362572, 1);
        sViewsWithIds.put(2131362447, 2);
        sViewsWithIds.put(2131362609, 3);
        sViewsWithIds.put(2131362596, 4);
        sViewsWithIds.put(2131362621, 5);
        sViewsWithIds.put(2131362515, 6);
        sViewsWithIds.put(2131362038, 7);
        sViewsWithIds.put(2131362606, 8);
        sViewsWithIds.put(2131362360, 9);
        sViewsWithIds.put(2131362414, 10);
        sViewsWithIds.put(2131362040, 11);
        sViewsWithIds.put(2131362601, 12);
        sViewsWithIds.put(2131362602, 13);
        sViewsWithIds.put(2131362597, 14);
        sViewsWithIds.put(2131362598, 15);
        sViewsWithIds.put(2131362599, 16);
        sViewsWithIds.put(2131362600, 17);
        sViewsWithIds.put(2131362039, 18);
        sViewsWithIds.put(2131362595, 19);
        sViewsWithIds.put(2131362604, 20);
        sViewsWithIds.put(2131362605, 21);
        sViewsWithIds.put(2131362592, 22);
        sViewsWithIds.put(2131362593, 23);
        sViewsWithIds.put(2131362590, 24);
        sViewsWithIds.put(2131362588, 25);
        sViewsWithIds.put(2131362589, 26);
        sViewsWithIds.put(2131362614, 27);
        sViewsWithIds.put(2131362615, 28);
        sViewsWithIds.put(2131362619, 29);
        sViewsWithIds.put(2131362620, 30);
        sViewsWithIds.put(2131362612, 31);
        sViewsWithIds.put(2131362613, 32);
        sViewsWithIds.put(2131362101, 33);
        sViewsWithIds.put(2131362151, 34);
        sViewsWithIds.put(2131362102, 35);
        sViewsWithIds.put(2131361907, 36);
        sViewsWithIds.put(2131361901, 37);
        sViewsWithIds.put(2131361902, 38);
        sViewsWithIds.put(2131361913, 39);
        sViewsWithIds.put(2131361910, 40);
        sViewsWithIds.put(2131361908, 41);
        sViewsWithIds.put(2131362405, 42);
    }

    public ActivityOrderDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ActivityOrderDetailsBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)43, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ActivityOrderDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        RelativeLayout relativeLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[37], (TextView)arrobject[38], (TextView)arrobject[36], (TextView)arrobject[41], (TextView)arrobject[40], (TextView)arrobject[39], (View)arrobject[7], (View)arrobject[18], (View)arrobject[11], (Guideline)arrobject[33], (Guideline)arrobject[35], (ConstraintLayout)arrobject[34], (NestedScrollView)arrobject[9], (ProgressBar)arrobject[42], (RecyclerView)arrobject[10], (NestedScrollView)arrobject[2], (View)arrobject[6], (MaterialToolbar)arrobject[1], (TextView)arrobject[25], (TextView)arrobject[26], (TextView)arrobject[24], (TextView)arrobject[22], (TextView)arrobject[23], (TextView)arrobject[19], (TextView)arrobject[4], (TextView)arrobject[14], (TextView)arrobject[15], (TextView)arrobject[16], (TextView)arrobject[17], (TextView)arrobject[12], (TextView)arrobject[13], (TextView)arrobject[20], (TextView)arrobject[21], (TextView)arrobject[8], (TextView)arrobject[3], (TextView)arrobject[31], (TextView)arrobject[32], (TextView)arrobject[27], (TextView)arrobject[28], (TextView)arrobject[29], (TextView)arrobject[30], (TextView)arrobject[5]);
        this.mboundView0 = relativeLayout = (RelativeLayout)arrobject[0];
        relativeLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        ActivityOrderDetailsBindingImpl activityOrderDetailsBindingImpl = this;
        synchronized (activityOrderDetailsBindingImpl) {
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
        ActivityOrderDetailsBindingImpl activityOrderDetailsBindingImpl = this;
        synchronized (activityOrderDetailsBindingImpl) {
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
        ActivityOrderDetailsBindingImpl activityOrderDetailsBindingImpl = this;
        synchronized (activityOrderDetailsBindingImpl) {
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

