package app.dukhaan.ui.ui.orders_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentOrdersListBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.orders.OrdersNavigator;
import app.dukhaan.ui.orders_list.OrdersListFragment.1;
import app.dukhaan.ui.orders_list.OrdersListFragment.2;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import app.dukhaan.ui.views.orders.OrdersListAdapter;
import app.dukhaan.ui.views.orders.OrdersListAdapter.OrdersListAdapterListener;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OrdersListFragment extends BaseFragment<FragmentOrdersListBinding, OrdersListViewModel> implements OrdersNavigator, OrdersListAdapterListener {
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

   public OrdersListFragment() {
   }

   public static OrdersListFragment newInstance(boolean var0, String var1, boolean var2) {
      OrdersListFragment var3 = new OrdersListFragment();
      Bundle var4 = new Bundle();
      var4.putBoolean("full_details", var0);
      var4.putString("order_status", var1);
      var4.putBoolean("avoid_clear_cache", var2);
      var3.setArguments(var4);
      return var3;
   }

   public int getLayoutId() {
      return fragment_orders_list;
   }

   protected Class<OrdersListViewModel> getViewModel() {
      return OrdersListViewModel.class;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 1000 && var2 == -1) {
         if (var3 == null) {
            return;
         }

         if (var3.getBooleanExtra("refresh", false)) {
            this.pagination = 1;
            this.mViewModel.fetchOrders(this.business.realmGet$id(), true, false, this.orderStatus, this.pagination);
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
      SwipeRefreshHideEvent var2 = new SwipeRefreshHideEvent();
      EventBus.getDefault().post(var2);
      this.hideFullscreenProgress();
      ModalDialogs.showUnknownError(this.getActivity());
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.NEW_ORDER) {
         this.onNewOrderReceived();
      } else if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK) {
         this.mViewModel.fetchOrders(this.business.realmGet$id(), false, this.avoidClearDb, this.orderStatus, this.pagination);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (this.getArguments() != null) {
         this.enableFullDetails = this.getArguments().getBoolean("full_details");
         this.orderStatus = this.getArguments().getString(R.string."order_status");
         this.avoidClearDb = this.getArguments().getBoolean("avoid_clear_cache");
      }

   }

   protected void onCreateView(Bundle var1, OrdersListViewModel var2, FragmentOrdersListBinding var3, Context var4) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.orderArrayList = new ArrayList();
      this.business = var2.getDataManager().getBusiness();
      this.mAdapter = new OrdersListAdapter(this);
      this.mLayoutManager = new LinearLayoutManager(this.getActivity());
      var3.recyclerview.setLayoutManager(this.mLayoutManager);
      this.mAdapter.setShowFullDetails(this.enableFullDetails);
      var3.recyclerview.setAdapter(this.mAdapter);
      this.showFullscreenProgress();
      this.mViewModel.fetchOrders(this.business.realmGet$id(), false, this.avoidClearDb, this.orderStatus, this.pagination);
      var3.swipeRefresh1.setProgressBackgroundColorSchemeColor(this.getResources().getColor(R.color.colorPrimary));
      var3.swipeRefresh1.setColorSchemeResources(new int[]{colorWhite, colorWhite, colorWhite});
      var3.recyclerview.addOnScrollListener(new 1(this));
      var3.swipeRefresh1.setOnRefreshListener(new 2(this));
   }

   public void onDestroyView() {
      super.onDestroyView();
      this.binding = null;
   }

   public void onNewOrderReceived() {
      this.pagination = 1;
      this.mViewModel.fetchOrders(this.business.realmGet$id(), true, false, this.orderStatus, this.pagination);
   }

   public void onOrderDetailsClicked(Order var1) {
      Intent var2 = new Intent(this.getContext(), OrderDetailsActivity.class);
      var2.putExtra("data", var1);
      this.startActivityForResult(var2, 1000);
   }

   public void onOrdersListFetched(List<Order> var1, boolean var2) {
      FragmentOrdersListBinding var3 = this.binding;
      if (var3 != null) {
         var3.swipeRefresh1.setRefreshing(false);
         if (var1.size() > 0) {
            if (this.pagination == 1) {
               this.orderArrayList.clear();
            }

            this.orderArrayList.addAll(var1);
            if (var2) {
               this.loading = true;
               ++this.pagination;
            } else {
               this.loading = false;
            }

            this.binding.recyclerview.post(new _$$Lambda$OrdersListFragment$dqmZ5NxCim_SXLl9zY7zo2PYrZE(this));
         } else {
            String var4;
            if (Constants.DEFAULT_ORDER_STATUS_INDEX == 0) {
               var4 = this.getString(R.string.no_pending_orders, new Object[]{"PENDING".toLowerCase()});
            } else {
               var4 = this.getString(R.string.no_pending_orders, new Object[]{Constants.DEFAULT_ORDER_STATUS.toLowerCase()});
            }

            this.binding.recyclerview.setVisibility(8);
            this.binding.emptyData.setData(var4);
            this.binding.emptyData.setVisibility(0);
         }

         this.hideFullscreenProgress();
      }
   }

   public void sort(String var1) {
      this.pagination = 1;
      this.orderStatus = var1;
      this.hideFullscreenProgress();
      this.mViewModel.fetchOrders(this.business.realmGet$id(), true, this.avoidClearDb, var1, this.pagination);
   }
}
