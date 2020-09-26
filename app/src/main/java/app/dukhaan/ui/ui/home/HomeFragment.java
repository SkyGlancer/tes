package app.dukhaan.ui.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentHomeBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.home.HomeFragment.1;
import app.dukhaan.ui.home.HomeNavigator;
import app.dukhaan.ui.home.HomeViewModel;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.views.StoreInfoCard;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter.PendingOrdersListAdapterListener;
import app.dukhaan.ui.views.stats.DashboardStatsAdapter;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.GridSpacingItemDecoration;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> implements HomeNavigator, IpopUpMenuItem, PendingOrdersListAdapterListener {
   private FragmentHomeBinding binding;
   private Business business;
   private String filterOrderStatus = null;
   private boolean loading = false;
   private PendingOrdersListAdapter mAdapter;
   private LinearLayoutManager mLayoutManager;
   private ArrayList<Order> orderArrayList;
   private int pagination = 1;
   private DashboardStatsAdapter statsAdapter;
   private HomeViewModel viewModel;

   public HomeFragment() {
   }

   private void hideDefaultHome() {
      this.hideOrderFilters();
      this.binding.weekHeader.container.setVisibility(8);
      this.binding.recyclerviewStats.setVisibility(8);
      this.binding.pendingOrdersHeader.container.setVisibility(8);
      this.binding.recyclerviewPendingOrders.setVisibility(8);
      this.binding.emptyData.setVisibility(8);
      this.binding.swipeRefresh.setEnabled(false);
   }

   private void hideOnboardingSteps() {
      FragmentTransaction var1 = this.getChildFragmentManager().beginTransaction();
      if (this.getChildFragmentManager().findFragmentByTag("steps") != null) {
         var1.remove(this.getChildFragmentManager().findFragmentByTag("steps"));
         var1.commitAllowingStateLoss();
      }

   }

   private void hideOrderFilters() {
      this.binding.orderFilters.setVisibility(8);
   }

   private void init() {
      this.renderStoreInfoCard();
      if (AppPref.getInstance().isProductsAdded() && AppPref.getInstance().isSharedOnWhatsapp()) {
         this.showDefaultHome();
         this.hideOnboardingSteps();
      } else {
         this.showOnboardingSteps();
         this.hideDefaultHome();
      }

   }

   private void initLoadMore() {
      FragmentHomeBinding var1 = this.binding;
      if (var1 != null) {
         var1.nestedScrollView.setOnScrollChangeListener(new _$$Lambda$HomeFragment$J8rvUqsEBJWnpTq9fU_RiW8z_SI(this));
      }
   }

   private void loadBusinessStats() {
      if (Constants.STATS_FILTER_LABEL == null) {
         Constants.STATS_FILTER_LABEL = this.getString(R.string.life_time);
         Constants.STATS_FILTER = "lifetime";
      }

      FragmentHomeBinding var1 = this.binding;
      if (var1 != null) {
         var1.weekHeader.title.setText(Constants.STATS_FILTER_LABEL);
         this.viewModel.getBusinessStats(this.getContext(), Constants.STATS_FILTER);
      }
   }

   private void refresh() {
      this.renderStoreInfoCard();
      this.pagination = 1;
      this.loading = false;
      this.viewModel.fetchOrders(this.business.realmGet$id(), false, true, this.filterOrderStatus, this.pagination);
      this.loadBusinessStats();
   }

   private void renderStoreInfoCard() {
      Business var1 = this.viewModel.getDataManager().getBusiness();
      if (var1 != null) {
         FragmentHomeBinding var2 = this.binding;
         if (var2 != null) {
            StoreInfoCard var3 = var2.storeInfoCardContainer.storeInfoCard;
            StringBuilder var4 = new StringBuilder();
            var4.append("https://mydukaan.io/");
            var4.append(var1.realmGet$link());
            var3.setData(var4.toString());
            this.binding.storeInfoCardContainer.storeInfoCard.setListener(new 1(this, var1));
         }
      }

   }

   private void showDefaultHome() {
      this.initLoadMore();
      this.showOrderFilters();
      this.showOrderFilters();
      this.binding.weekHeader.container.setVisibility(0);
      this.binding.recyclerviewStats.setVisibility(0);
      this.binding.pendingOrdersHeader.container.setVisibility(0);
      this.binding.recyclerviewPendingOrders.setVisibility(0);
      this.binding.emptyData.setVisibility(0);
      this.binding.swipeRefresh.setEnabled(true);
      this.viewModel.renderEmptyStats(this.getContext());
      this.viewModel.getStatsData().observe(this.getViewLifecycleOwner(), new _$$Lambda$HomeFragment$zwGwgimGUwIDc80e3FQQZPRbrUw(this));
      this.viewModel.fetchOrders(this.business.realmGet$id(), false, true, (String)null, this.pagination);
      this.binding.weekHeader.weekDropDown.setOnClickListener(new _$$Lambda$HomeFragment$E8ReSqQCe_3lgxC9Pjtitgiy4Ik(this));
   }

   private void showOnboardingSteps() {
      OnboardingStepsFragment var1 = OnboardingStepsFragment.newInstance();
      FragmentTransaction var2 = this.getChildFragmentManager().beginTransaction();
      var2.replace(frame, var1, "steps");
      var2.addToBackStack((String)null);
      var2.commit();
   }

   private void showOrderFilters() {
      this.binding.orderFilters.setListener(new _$$Lambda$HomeFragment$CQedGPDSXBqfwt_DD_3799ODyHA(this));
      this.binding.orderFilters.setVisibility(0);
   }

   private void toggleEmptyData() {
      if (this.mAdapter.getItemCount() == 0) {
         this.binding.emptyData.setVisibility(0);
         this.binding.recyclerviewPendingOrders.setVisibility(8);
      } else {
         this.binding.emptyData.setVisibility(8);
         this.binding.recyclerviewPendingOrders.setVisibility(0);
      }

   }

   private void trackAcceptEvent(Order var1, String var2) {
      if (var2.equalsIgnoreCase("ACCEPTED")) {
         Business var3 = this.viewModel.getDataManager().getBusiness();
         CleverTapUtils.trackNewOrder(this.getActivity(), var3, var1);
      }

   }

   public int getLayoutId() {
      return fragment_home;
   }

   public Class<HomeViewModel> getViewModel() {
      return HomeViewModel.class;
   }

   public void menuItem(MenuItem var1) {
      switch(var1.getItemId()) {
      case menu_last_month:
         Constants.STATS_FILTER = "monthly";
         break;
      case menu_last_week:
         Constants.STATS_FILTER = "weekly";
         break;
      case menu_life_time:
         Constants.STATS_FILTER = "lifetime";
      case menu_loader:
      case menu_share:
      default:
         break;
      case menu_today:
         Constants.STATS_FILTER = "today";
         break;
      case menu_yesterday:
         Constants.STATS_FILTER = "yesterday";
      }

      Constants.STATS_FILTER_LABEL = var1.getTitle().toString();
      this.loadBusinessStats();
   }

   public void onApiError(ErrorResponse var1) {
      this.hideFullscreenProgress();
      ModalDialogs.showUnknownError(this.getActivity());
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.NEW_ORDER) {
         this.refresh();
      } else if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
         this.refresh();
      }

   }

   protected void onCreateView(Bundle var1, HomeViewModel var2, FragmentHomeBinding var3, Context var4) {
      this.binding = var3;
      this.viewModel = var2;
      var2.setNavigator(this);
      this.setHasOptionsMenu(true);
      this.business = var2.getDataManager().getBusiness();
      this.orderArrayList = new ArrayList();
      PendingOrdersListAdapter var5 = new PendingOrdersListAdapter(this);
      this.mAdapter = var5;
      var5.setShowFullDetails(false);
      this.mLayoutManager = new LinearLayoutManager(this.getActivity());
      var3.recyclerviewPendingOrders.setLayoutManager(this.mLayoutManager);
      var3.recyclerviewPendingOrders.setAdapter(this.mAdapter);
      var3.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(R.color.colorPrimary));
      var3.swipeRefresh.setColorSchemeResources(new int[]{colorWhite, colorWhite, colorWhite});
      this.statsAdapter = new DashboardStatsAdapter();
      var3.recyclerviewStats.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
      var3.recyclerviewStats.addItemDecoration(new GridSpacingItemDecoration(2, AppUtils.dpToPx(8), false));
      var3.recyclerviewStats.setAdapter(this.statsAdapter);
      var3.pendingOrdersHeader.viewAll.setOnClickListener(_$$Lambda$HomeFragment$6IQFEkojGNGvMpGvO1Ugm5ZPGt8.INSTANCE);
      var3.swipeRefresh.setOnRefreshListener(new _$$Lambda$HomeFragment$qqthmcSVV7goPIA_QxA5i4jvGDk(this));
   }

   public void onDestroyView() {
      super.onDestroyView();
      this.binding = null;
   }

   public void onOrderDetailsClicked(Order var1) {
      Intent var2 = new Intent(this.getContext(), OrderDetailsActivity.class);
      var2.putExtra("data", var1);
      this.startActivityForResult(var2, 1000);
   }

   public void onOrderStatusUpdated(Order var1) {
      this.refresh();
      this.toggleEmptyData();
   }

   public void onOrdersListFetched(List<Order> var1, String var2, boolean var3) {
      FragmentHomeBinding var5 = this.binding;
      if (var5 != null) {
         var5.swipeRefresh.setRefreshing(false);
         if (this.binding != null) {
            if (var1.size() > 0) {
               if (this.pagination == 1) {
                  this.orderArrayList.clear();
               }

               this.orderArrayList.addAll(var1);
               this.mAdapter.setData(this.orderArrayList);
               this.binding.recyclerviewPendingOrders.setVisibility(0);
               this.binding.emptyData.setVisibility(8);
               if (var3) {
                  this.loading = false;
                  ++this.pagination;
               } else {
                  this.loading = true;
               }
            } else if (this.pagination == 1) {
               String var4 = this.getString(R.string.no_pending_active_orders);
               this.binding.emptyData.setData(var4);
               this.binding.emptyData.setVisibility(0);
               this.binding.recyclerviewPendingOrders.setVisibility(8);
            }

            this.hideFullscreenProgress();
         }
      }
   }

   public void onResume() {
      super.onResume();
      this.loadBusinessStats();
      this.init();
   }

   public void onUpdateOrderStatus(Order var1, String var2) {
      this.showFullscreenProgress();
      UpdateOrderStatusRequest var3 = new UpdateOrderStatusRequest();
      var3.orderStatus = var2;
      this.viewModel.updateOrderStatus(var1, var3);
      this.trackAcceptEvent(var1, var2);
   }
}
