/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.NetworkItemBinding;

public class NetworkItemBindingImpl
extends NetworkItemBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362052, 1);
        sViewsWithIds.put(2131362405, 2);
    }

    public NetworkItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, NetworkItemBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)3, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private NetworkItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        LinearLayout linearLayout;
        super((Object)dataBindingComponent, view, 0, (TextView)arrobject[1], (ProgressBar)arrobject[2]);
        this.mboundView0 = linearLayout = (LinearLayout)arrobject[0];
        linearLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        NetworkItemBindingImpl networkItemBindingImpl = this;
        synchronized (networkItemBindingImpl) {
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
        NetworkItemBindingImpl networkItemBindingImpl = this;
        synchronized (networkItemBindingImpl) {
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
        NetworkItemBindingImpl networkItemBindingImpl = this;
        synchronized (networkItemBindingImpl) {
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

