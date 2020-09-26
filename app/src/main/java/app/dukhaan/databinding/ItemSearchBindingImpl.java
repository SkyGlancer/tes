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
import app.dukhaan.databinding.ItemSearchBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;

public class ItemSearchBindingImpl
extends ItemSearchBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;

    static {
        SparseIntArray sparseIntArray;
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362251, 1);
        sViewsWithIds.put(2131362604, 2);
        sViewsWithIds.put(2131362611, 3);
    }

    public ItemSearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ItemSearchBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)4, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private ItemSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        super((Object)dataBindingComponent, view, 0, (ConstraintLayout)arrobject[0], (ImageView)arrobject[1], (TextView)arrobject[2], (TextView)arrobject[3]);
        this.constItemSearchPlaces.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        ItemSearchBindingImpl itemSearchBindingImpl = this;
        synchronized (itemSearchBindingImpl) {
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
        ItemSearchBindingImpl itemSearchBindingImpl = this;
        synchronized (itemSearchBindingImpl) {
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
        ItemSearchBindingImpl itemSearchBindingImpl = this;
        synchronized (itemSearchBindingImpl) {
            this.mDirtyFlags = 2L;
        }
        this.requestRebind();
    }

    protected boolean onFieldChange(int n, Object object, int n2) {
        return false;
    }

    @Override
    public void setPrediction(Prediction prediction) {
        this.mPrediction = prediction;
    }

    public boolean setVariable(int n, Object object) {
        if (1 == n) {
            this.setPrediction((Prediction)object);
            return true;
        }
        return false;
    }
}

