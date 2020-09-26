/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.orders.OrdersNavigator
 *  app.dukhaan.ui.orders_list.OrdersListFragment$1
 *  app.dukhaan.ui.orders_list.OrdersListFragment$2
 *  app.dukhaan.ui.orders_list.OrdersListViewModel
 *  app.dukhaan.ui.views.orders.OrdersListAdapter
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.orders_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentOrdersListBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.orders.OrdersNavigator;
import app.dukhaan.ui.orders_list.-$$Lambda$OrdersListFragment$dqmZ5NxCim-SXLl9zY7zo2PYrZE;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.orders.OrdersListAdapter;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OrdersListFragment
extends BaseFragment<FragmentOrdersListBinding, OrdersListViewModel>
implements OrdersNavigator,
OrdersListAdapter.OrdersListAdapterListener {
    private static final String ORG_AVOID_CLEAR_CACHE = "avoid_clear_cache";
    private static final String ORG_FULL_DETAILS = "full_details";
    private static final String ORG_ORDER_STATUS = "order_status";
    private boolean avoidClearDb = false;
    private FragmentOrdersListBinding binding;
    private Business business;
    private boolean enableFullDetails;
    private boolean loading = true;
    private OrdersListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private OrdersListViewModel mViewModel;
    private ArrayList<Order> orderArrayList;
    private String orderStatus;
    private int pagination = 1;
    private int pastVisibleItems;
    private int totalItemCount;
    private int visibleItemCount;

    static /* synthetic */ int access$000(OrdersListFragment ordersListFragment) {
        return ordersListFragment.visibleItemCount;
    }

    static /* synthetic */ int access$002(OrdersListFragment ordersListFragment, int n) {
        ordersListFragment.visibleItemCount = n;
        return n;
    }

    static /* synthetic */ LinearLayoutManager access$100(OrdersListFragment ordersListFragment) {
        return ordersListFragment.mLayoutManager;
    }

    static /* synthetic */ int access$200(OrdersListFragment ordersListFragment) {
        return ordersListFragment.totalItemCount;
    }

    static /* synthetic */ int access$202(OrdersListFragment ordersListFragment, int n) {
        ordersListFragment.totalItemCount = n;
        return n;
    }

    static /* synthetic */ int access$300(OrdersListFragment ordersListFragment) {
        return ordersListFragment.pastVisibleItems;
    }

    static /* synthetic */ int access$302(OrdersListFragment ordersListFragment, int n) {
        ordersListFragment.pastVisibleItems = n;
        return n;
    }

    static /* synthetic */ boolean access$400(OrdersListFragment ordersListFragment) {
        return ordersListFragment.loading;
    }

    static /* synthetic */ boolean access$402(OrdersListFragment ordersListFragment, boolean bl) {
        ordersListFragment.loading = bl;
        return bl;
    }

    static /* synthetic */ Business access$500(OrdersListFragment ordersListFragment) {
        return ordersListFragment.business;
    }

    static /* synthetic */ boolean access$600(OrdersListFragment ordersListFragment) {
        return ordersListFragment.avoidClearDb;
    }

    static /* synthetic */ String access$700(OrdersListFragment ordersListFragment) {
        return ordersListFragment.orderStatus;
    }

    static /* synthetic */ int access$800(OrdersListFragment ordersListFragment) {
        return ordersListFragment.pagination;
    }

    static /* synthetic */ int access$802(OrdersListFragment ordersListFragment, int n) {
        ordersListFragment.pagination = n;
        return n;
    }

    static /* synthetic */ OrdersListViewModel access$900(OrdersListFragment ordersListFragment) {
        return ordersListFragment.mViewModel;
    }

    public static OrdersListFragment newInstance(boolean bl, String string2, boolean bl2) {
        OrdersListFragment ordersListFragment = new OrdersListFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ORG_FULL_DETAILS, bl);
        bundle.putString(ORG_ORDER_STATUS, string2);
        bundle.putBoolean(ORG_AVOID_CLEAR_CACHE, bl2);
        ordersListFragment.setArguments(bundle);
        return ordersListFragment;
    }

    public int getLayoutId() {
        return 2131558501;
    }

    protected Class<OrdersListViewModel> getViewModel() {
        return OrdersListViewModel.class;
    }

    public /* synthetic */ void lambda$onOrdersListFetched$0$OrdersListFragment() {
        FragmentOrdersListBinding fragmentOrdersListBinding;
        this.mAdapter.setData(this.orderArrayList);
        FragmentOrdersListBinding fragmentOrdersListBinding2 = this.binding;
        if (fragmentOrdersListBinding2 != null && fragmentOrdersListBinding2.recyclerview != null) {
            this.binding.recyclerview.setVisibility(0);
        }
        if ((fragmentOrdersListBinding = this.binding) != null && fragmentOrdersListBinding.emptyData != null) {
            this.binding.emptyData.setVisibility(8);
        }
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        if (n == 1000 && n2 == -1) {
            if (intent == null) {
                return;
            }
            if (intent.getBooleanExtra("refresh", false)) {
                this.pagination = 1;
                this.mViewModel.fetchOrders(this.business.realmGet$id(), true, false, this.orderStatus, this.pagination);
            }
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        SwipeRefreshHideEvent swipeRefreshHideEvent = new SwipeRefreshHideEvent();
        EventBus.getDefault().post((Object)swipeRefreshHideEvent);
        this.hideFullscreenProgress();
        ModalDialogs.showUnknownError((Activity)this.getActivity());
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.NEW_ORDER) {
            this.onNewOrderReceived();
            return;
        }
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK) {
            this.mViewModel.fetchOrders(this.business.realmGet$id(), false, this.avoidClearDb, this.orderStatus, this.pagination);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.getArguments() != null) {
            this.enableFullDetails = this.getArguments().getBoolean(ORG_FULL_DETAILS);
            this.orderStatus = this.getArguments().getString(ORG_ORDER_STATUS);
            this.avoidClearDb = this.getArguments().getBoolean(ORG_AVOID_CLEAR_CACHE);
        }
    }

    protected void onCreateView(Bundle bundle, OrdersListViewModel ordersListViewModel, FragmentOrdersListBinding fragmentOrdersListBinding, Context context) {
        this.binding = fragmentOrdersListBinding;
        this.mViewModel = ordersListViewModel;
        ordersListViewModel.setNavigator((Object)this);
        this.orderArrayList = new ArrayList();
        this.business = ordersListViewModel.getDataManager().getBusiness();
        this.mAdapter = new OrdersListAdapter((OrdersListAdapter.OrdersListAdapterListener)this);
        this.mLayoutManager = new LinearLayoutManager((Context)this.getActivity());
        fragmentOrdersListBinding.recyclerview.setLayoutManager((RecyclerView.LayoutManager)this.mLayoutManager);
        this.mAdapter.setShowFullDetails(this.enableFullDetails);
        fragmentOrdersListBinding.recyclerview.setAdapter((RecyclerView.Adapter)this.mAdapter);
        this.showFullscreenProgress();
        this.mViewModel.fetchOrders(this.business.realmGet$id(), false, this.avoidClearDb, this.orderStatus, this.pagination);
        fragmentOrdersListBinding.swipeRefresh1.setProgressBackgroundColorSchemeColor(this.getResources().getColor(2131099728));
        fragmentOrdersListBinding.swipeRefresh1.setColorSchemeResources(new int[]{2131099737, 2131099737, 2131099737});
        fragmentOrdersListBinding.recyclerview.addOnScrollListener((RecyclerView.OnScrollListener)new 1(this));
        fragmentOrdersListBinding.swipeRefresh1.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)new 2(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void onNewOrderReceived() {
        this.pagination = 1;
        this.mViewModel.fetchOrders(this.business.realmGet$id(), true, false, this.orderStatus, this.pagination);
    }

    @Override
    public void onOrderDetailsClicked(Order order) {
        Intent intent = new Intent(this.getContext(), OrderDetailsActivity.class);
        intent.putExtra("data", (Parcelable)order);
        this.startActivityForResult(intent, 1000);
    }

    public void onOrdersListFetched(List<Order> list, boolean bl) {
        FragmentOrdersListBinding fragmentOrdersListBinding = this.binding;
        if (fragmentOrdersListBinding == null) {
            return;
        }
        fragmentOrdersListBinding.swipeRefresh1.setRefreshing(false);
        if (list.size() > 0) {
            if (this.pagination == 1) {
                this.orderArrayList.clear();
            }
            this.orderArrayList.addAll(list);
            if (bl) {
                this.loading = true;
                this.pagination = 1 + this.pagination;
            } else {
                this.loading = false;
            }
            this.binding.recyclerview.post((Runnable)new -$$Lambda$OrdersListFragment$dqmZ5NxCim-SXLl9zY7zo2PYrZE(this));
        } else {
            String string2;
            if (Constants.DEFAULT_ORDER_STATUS_INDEX == 0) {
                Object[] arrobject = new Object[]{"PENDING".toLowerCase()};
                string2 = this.getString(2131951879, arrobject);
            } else {
                Object[] arrobject = new Object[]{Constants.DEFAULT_ORDER_STATUS.toLowerCase()};
                string2 = this.getString(2131951879, arrobject);
            }
            this.binding.recyclerview.setVisibility(8);
            this.binding.emptyData.setData(string2);
            this.binding.emptyData.setVisibility(0);
        }
        this.hideFullscreenProgress();
    }

    public void sort(String string2) {
        this.pagination = 1;
        this.orderStatus = string2;
        this.hideFullscreenProgress();
        this.mViewModel.fetchOrders(this.business.realmGet$id(), true, this.avoidClearDb, string2, this.pagination);
    }
}

