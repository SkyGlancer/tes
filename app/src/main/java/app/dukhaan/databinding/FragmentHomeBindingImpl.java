/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.widget.NestedScrollView
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.ViewDataBinding$IncludedLayouts
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.databinding.FragmentHomeBinding;
import app.dukhaan.databinding.ListHeaderOverviewBinding;
import app.dukhaan.databinding.ListHeaderPendingOrdersBinding;
import app.dukhaan.databinding.StoreInfoCardContainerBinding;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.orders.OrderFilterChipGroup;

public class FragmentHomeBindingImpl
extends FragmentHomeBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags = -1L;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView1;

    static {
        SparseIntArray sparseIntArray;
        IncludedLayouts includedLayouts;
        sIncludes = includedLayouts = new IncludedLayouts(13);
        includedLayouts.setIncludes(0, new String[]{"store_info_card_container"}, new int[]{2}, new int[]{2131558627});
        sIncludes.setIncludes(1, new String[]{"list_header_overview", "list_header_pending_orders"}, new int[]{3, 4}, new int[]{2131558545, 2131558546});
        sViewsWithIds = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362525, 5);
        sViewsWithIds.put(2131362361, 6);
        sViewsWithIds.put(2131362091, 7);
        sViewsWithIds.put(2131362417, 8);
        sViewsWithIds.put(2131362379, 9);
        sViewsWithIds.put(2131362415, 10);
        sViewsWithIds.put(2131362045, 11);
        sViewsWithIds.put(2131362405, 12);
    }

    public FragmentHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, FragmentHomeBindingImpl.mapBindings((DataBindingComponent)dataBindingComponent, (View)view, (int)13, (IncludedLayouts)sIncludes, (SparseIntArray)sViewsWithIds));
    }

    private FragmentHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] arrobject) {
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;
        super((Object)dataBindingComponent, view, 3, (EmptyDataCard)((Object)arrobject[11]), (FrameLayout)arrobject[7], (NestedScrollView)arrobject[6], (OrderFilterChipGroup)((Object)arrobject[9]), (ListHeaderPendingOrdersBinding)((Object)arrobject[4]), (ProgressBar)arrobject[12], (RecyclerView)arrobject[10], (RecyclerView)arrobject[8], (StoreInfoCardContainerBinding)((Object)arrobject[2]), (SwipeRefreshLayout)arrobject[5], (ListHeaderOverviewBinding)((Object)arrobject[3]));
        this.mboundView0 = constraintLayout = (ConstraintLayout)arrobject[0];
        constraintLayout.setTag(null);
        this.mboundView1 = linearLayout = (LinearLayout)arrobject[1];
        linearLayout.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean onChangePendingOrdersHeader(ListHeaderPendingOrdersBinding listHeaderPendingOrdersBinding, int n) {
        if (n == 0) {
            FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
            synchronized (fragmentHomeBindingImpl) {
                this.mDirtyFlags = 2L | this.mDirtyFlags;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean onChangeStoreInfoCardContainer(StoreInfoCardContainerBinding storeInfoCardContainerBinding, int n) {
        if (n == 0) {
            FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
            synchronized (fragmentHomeBindingImpl) {
                this.mDirtyFlags = 1L | this.mDirtyFlags;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean onChangeWeekHeader(ListHeaderOverviewBinding listHeaderOverviewBinding, int n) {
        if (n == 0) {
            FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
            synchronized (fragmentHomeBindingImpl) {
                this.mDirtyFlags = 4L | this.mDirtyFlags;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void executeBindings() {
        FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
        synchronized (fragmentHomeBindingImpl) {
            this.mDirtyFlags = 0L;
        }
        FragmentHomeBindingImpl.executeBindingsOn((ViewDataBinding)this.storeInfoCardContainer);
        FragmentHomeBindingImpl.executeBindingsOn((ViewDataBinding)this.weekHeader);
        FragmentHomeBindingImpl.executeBindingsOn((ViewDataBinding)this.pendingOrdersHeader);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean hasPendingBindings() {
        FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
        // MONITORENTER : fragmentHomeBindingImpl
        if (this.mDirtyFlags != 0L) {
            // MONITOREXIT : fragmentHomeBindingImpl
            return true;
        }
        // MONITOREXIT : fragmentHomeBindingImpl
        if (this.storeInfoCardContainer.hasPendingBindings()) {
            return true;
        }
        if (this.weekHeader.hasPendingBindings()) {
            return true;
        }
        if (!this.pendingOrdersHeader.hasPendingBindings()) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        FragmentHomeBindingImpl fragmentHomeBindingImpl = this;
        synchronized (fragmentHomeBindingImpl) {
            this.mDirtyFlags = 8L;
        }
        this.storeInfoCardContainer.invalidateAll();
        this.weekHeader.invalidateAll();
        this.pendingOrdersHeader.invalidateAll();
        this.requestRebind();
    }

    protected boolean onFieldChange(int n, Object object, int n2) {
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    return false;
                }
                return this.onChangeWeekHeader((ListHeaderOverviewBinding)((Object)object), n2);
            }
            return this.onChangePendingOrdersHeader((ListHeaderPendingOrdersBinding)((Object)object), n2);
        }
        return this.onChangeStoreInfoCardContainer((StoreInfoCardContainerBinding)((Object)object), n2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.storeInfoCardContainer.setLifecycleOwner(lifecycleOwner);
        this.weekHeader.setLifecycleOwner(lifecycleOwner);
        this.pendingOrdersHeader.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int n, Object object) {
        return true;
    }
}

