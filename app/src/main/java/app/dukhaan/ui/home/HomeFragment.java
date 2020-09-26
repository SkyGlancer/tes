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
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.widget.NestedScrollView
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.home.-$
 *  app.dukhaan.ui.home.-$$Lambda
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment$CQedGPDSXBqfwt-DD-3799ODyHA
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment$J8rvUqsEBJWnpTq9fU-RiW8z-SI
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment$YIGGfDmF8-Cz1ZOaFxL6MAvTOcs
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment$qqthmcSVV7goPIA-QxA5i4jvGDk
 *  app.dukhaan.ui.home.-$$Lambda$HomeFragment$zwGwgimGUwIDc80e3FQQZPRbrUw
 *  app.dukhaan.ui.home.HomeFragment$1
 *  app.dukhaan.ui.home.HomeNavigator
 *  app.dukhaan.ui.home.HomeViewModel
 *  app.dukhaan.ui.views.orders.PendingOrdersListAdapter
 *  app.dukhaan.ui.views.stats.DashboardStatsAdapter
 *  app.dukhaan.util.GridSpacingItemDecoration
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentHomeBinding;
import app.dukhaan.databinding.ListHeaderOverviewBinding;
import app.dukhaan.databinding.ListHeaderPendingOrdersBinding;
import app.dukhaan.databinding.StoreInfoCardContainerBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.home.-$;
import app.dukhaan.ui.home.-$$Lambda$HomeFragment$6IQFEkojGNGvMpGvO1Ugm5ZPGt8;
import app.dukhaan.ui.home.-$$Lambda$HomeFragment$E8ReSqQCe_3lgxC9Pjtitgiy4Ik;
import app.dukhaan.ui.home.HomeFragment;
import app.dukhaan.ui.home.HomeNavigator;
import app.dukhaan.ui.home.HomeViewModel;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.StoreInfoCard;
import app.dukhaan.ui.views.orders.OrderFilterChipGroup;
import app.dukhaan.ui.views.orders.PendingOrdersListAdapter;
import app.dukhaan.ui.views.stats.DashboardStatsAdapter;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DialogDismissListener;
import app.dukhaan.util.GridSpacingItemDecoration;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HomeFragment
extends BaseFragment<FragmentHomeBinding, HomeViewModel>
implements HomeNavigator,
IpopUpMenuItem,
PendingOrdersListAdapter.PendingOrdersListAdapterListener {
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
        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();
        if (this.getChildFragmentManager().findFragmentByTag("steps") != null) {
            fragmentTransaction.remove(this.getChildFragmentManager().findFragmentByTag("steps"));
            fragmentTransaction.commitAllowingStateLoss();
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
            return;
        }
        this.showOnboardingSteps();
        this.hideDefaultHome();
    }

    private void initLoadMore() {
        FragmentHomeBinding fragmentHomeBinding = this.binding;
        if (fragmentHomeBinding == null) {
            return;
        }
        fragmentHomeBinding.nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)new -$.Lambda.HomeFragment.J8rvUqsEBJWnpTq9fU-RiW8z-SI(this));
    }

    static /* synthetic */ void lambda$null$2() {
    }

    static /* synthetic */ void lambda$onCreateView$0(View view) {
        AppEvent appEvent = new AppEvent(AppEvent.NAVIGATE_TO_ORDERS, null);
        EventBus.getDefault().post((Object)appEvent);
    }

    public static /* synthetic */ void lambda$qqthmcSVV7goPIA-QxA5i4jvGDk(HomeFragment homeFragment) {
        homeFragment.refresh();
    }

    private void loadBusinessStats() {
        FragmentHomeBinding fragmentHomeBinding;
        if (Constants.STATS_FILTER_LABEL == null) {
            Constants.STATS_FILTER_LABEL = this.getString(2131951825);
            Constants.STATS_FILTER = "lifetime";
        }
        if ((fragmentHomeBinding = this.binding) == null) {
            return;
        }
        fragmentHomeBinding.weekHeader.title.setText((CharSequence)Constants.STATS_FILTER_LABEL);
        this.viewModel.getBusinessStats(this.getContext(), Constants.STATS_FILTER);
    }

    private void refresh() {
        this.renderStoreInfoCard();
        this.pagination = 1;
        this.loading = false;
        this.viewModel.fetchOrders(this.business.realmGet$id(), false, true, this.filterOrderStatus, this.pagination);
        this.loadBusinessStats();
    }

    private void renderStoreInfoCard() {
        FragmentHomeBinding fragmentHomeBinding;
        Business business = this.viewModel.getDataManager().getBusiness();
        if (business != null && (fragmentHomeBinding = this.binding) != null) {
            StoreInfoCard storeInfoCard = fragmentHomeBinding.storeInfoCardContainer.storeInfoCard;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://mydukaan.io/");
            stringBuilder.append(business.realmGet$link());
            storeInfoCard.setData(stringBuilder.toString());
            this.binding.storeInfoCardContainer.storeInfoCard.setListener((StoreInfoCard.StoreInfoCardListener)new 1(this, business));
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
        this.viewModel.getStatsData().observe(this.getViewLifecycleOwner(), (Observer)new -$.Lambda.HomeFragment.zwGwgimGUwIDc80e3FQQZPRbrUw(this));
        this.viewModel.fetchOrders(this.business.realmGet$id(), false, true, null, this.pagination);
        this.binding.weekHeader.weekDropDown.setOnClickListener((View.OnClickListener)new -$$Lambda$HomeFragment$E8ReSqQCe_3lgxC9Pjtitgiy4Ik(this));
    }

    private void showOnboardingSteps() {
        OnboardingStepsFragment onboardingStepsFragment = OnboardingStepsFragment.newInstance();
        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(2131362091, (Fragment)onboardingStepsFragment, "steps");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void showOrderFilters() {
        this.binding.orderFilters.setListener((OrderFilterChipGroup.OrderFilterChipGroupListener)new -$.Lambda.HomeFragment.CQedGPDSXBqfwt-DD-3799ODyHA(this));
        this.binding.orderFilters.setVisibility(0);
    }

    private void toggleEmptyData() {
        if (this.mAdapter.getItemCount() == 0) {
            this.binding.emptyData.setVisibility(0);
            this.binding.recyclerviewPendingOrders.setVisibility(8);
            return;
        }
        this.binding.emptyData.setVisibility(8);
        this.binding.recyclerviewPendingOrders.setVisibility(0);
    }

    private void trackAcceptEvent(Order order, String string2) {
        if (string2.equalsIgnoreCase("ACCEPTED")) {
            Business business = this.viewModel.getDataManager().getBusiness();
            CleverTapUtils.trackNewOrder((Context)this.getActivity(), business, order);
        }
    }

    public int getLayoutId() {
        return 2131558498;
    }

    public Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    public /* synthetic */ void lambda$initLoadMore$4$HomeFragment(NestedScrollView nestedScrollView, int n, int n2, int n3, int n4) {
        if (n2 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && !this.loading) {
            this.loading = true;
            if (this.orderArrayList.size() > 0) {
                this.showFullscreenProgress();
            }
            this.viewModel.fetchOrders(this.business.realmGet$id(), false, false, this.filterOrderStatus, this.pagination);
        }
    }

    public /* synthetic */ void lambda$showDefaultHome$1$HomeFragment(List list) {
        this.statsAdapter.setData(list);
    }

    public /* synthetic */ void lambda$showDefaultHome$3$HomeFragment(View view) {
        AppUtils.popUpMenu(this.getContext(), (View)this.binding.weekHeader.weekDropDown, 2131623946, this, (DialogDismissListener)-$.Lambda.HomeFragment.YIGGfDmF8-Cz1ZOaFxL6MAvTOcs.INSTANCE);
    }

    public /* synthetic */ void lambda$showOrderFilters$5$HomeFragment(String string2) {
        this.pagination = 1;
        this.loading = false;
        this.showFullscreenProgress();
        this.filterOrderStatus = string2;
        this.viewModel.fetchOrders(this.business.realmGet$id(), false, true, string2, this.pagination);
    }

    @Override
    public void menuItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                break;
            }
            case 2131362314: {
                Constants.STATS_FILTER = "yesterday";
                break;
            }
            case 2131362313: {
                Constants.STATS_FILTER = "today";
                break;
            }
            case 2131362310: {
                Constants.STATS_FILTER = "lifetime";
                break;
            }
            case 2131362309: {
                Constants.STATS_FILTER = "weekly";
                break;
            }
            case 2131362308: {
                Constants.STATS_FILTER = "monthly";
            }
        }
        Constants.STATS_FILTER_LABEL = menuItem.getTitle().toString();
        this.loadBusinessStats();
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.hideFullscreenProgress();
        ModalDialogs.showUnknownError((Activity)this.getActivity());
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.NEW_ORDER) {
            this.refresh();
            return;
        }
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
            this.refresh();
        }
    }

    protected void onCreateView(Bundle bundle, HomeViewModel homeViewModel, FragmentHomeBinding fragmentHomeBinding, Context context) {
        PendingOrdersListAdapter pendingOrdersListAdapter;
        this.binding = fragmentHomeBinding;
        this.viewModel = homeViewModel;
        homeViewModel.setNavigator((Object)this);
        this.setHasOptionsMenu(true);
        this.business = homeViewModel.getDataManager().getBusiness();
        this.orderArrayList = new ArrayList();
        this.mAdapter = pendingOrdersListAdapter = new PendingOrdersListAdapter((PendingOrdersListAdapter.PendingOrdersListAdapterListener)this);
        pendingOrdersListAdapter.setShowFullDetails(false);
        this.mLayoutManager = new LinearLayoutManager((Context)this.getActivity());
        fragmentHomeBinding.recyclerviewPendingOrders.setLayoutManager((RecyclerView.LayoutManager)this.mLayoutManager);
        fragmentHomeBinding.recyclerviewPendingOrders.setAdapter((RecyclerView.Adapter)this.mAdapter);
        fragmentHomeBinding.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(2131099728));
        fragmentHomeBinding.swipeRefresh.setColorSchemeResources(new int[]{2131099737, 2131099737, 2131099737});
        this.statsAdapter = new DashboardStatsAdapter();
        fragmentHomeBinding.recyclerviewStats.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.getContext(), 2));
        fragmentHomeBinding.recyclerviewStats.addItemDecoration((RecyclerView.ItemDecoration)new GridSpacingItemDecoration(2, AppUtils.dpToPx(8), false));
        fragmentHomeBinding.recyclerviewStats.setAdapter((RecyclerView.Adapter)this.statsAdapter);
        fragmentHomeBinding.pendingOrdersHeader.viewAll.setOnClickListener((View.OnClickListener)-$$Lambda$HomeFragment$6IQFEkojGNGvMpGvO1Ugm5ZPGt8.INSTANCE);
        fragmentHomeBinding.swipeRefresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)new -$.Lambda.HomeFragment.qqthmcSVV7goPIA-QxA5i4jvGDk(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override
    public void onOrderDetailsClicked(Order order) {
        Intent intent = new Intent(this.getContext(), OrderDetailsActivity.class);
        intent.putExtra("data", (Parcelable)order);
        this.startActivityForResult(intent, 1000);
    }

    public void onOrderStatusUpdated(Order order) {
        this.refresh();
        this.toggleEmptyData();
    }

    public void onOrdersListFetched(List<Order> list, String string2, boolean bl) {
        FragmentHomeBinding fragmentHomeBinding = this.binding;
        if (fragmentHomeBinding == null) {
            return;
        }
        fragmentHomeBinding.swipeRefresh.setRefreshing(false);
        if (this.binding == null) {
            return;
        }
        if (list.size() > 0) {
            if (this.pagination == 1) {
                this.orderArrayList.clear();
            }
            this.orderArrayList.addAll(list);
            this.mAdapter.setData(this.orderArrayList);
            this.binding.recyclerviewPendingOrders.setVisibility(0);
            this.binding.emptyData.setVisibility(8);
            if (bl) {
                this.loading = false;
                this.pagination = 1 + this.pagination;
            } else {
                this.loading = true;
            }
        } else if (this.pagination == 1) {
            String string3 = this.getString(2131951878);
            this.binding.emptyData.setData(string3);
            this.binding.emptyData.setVisibility(0);
            this.binding.recyclerviewPendingOrders.setVisibility(8);
        }
        this.hideFullscreenProgress();
    }

    public void onResume() {
        super.onResume();
        this.loadBusinessStats();
        this.init();
    }

    @Override
    public void onUpdateOrderStatus(Order order, String string2) {
        this.showFullscreenProgress();
        UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
        updateOrderStatusRequest.orderStatus = string2;
        this.viewModel.updateOrderStatus(order, updateOrderStatusRequest);
        this.trackAcceptEvent(order, string2);
    }
}

