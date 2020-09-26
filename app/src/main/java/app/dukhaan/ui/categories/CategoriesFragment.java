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
 *  android.view.View
 *  android.view.View$OnClickListener
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
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.ui.categories.-$
 *  app.dukhaan.ui.categories.-$$Lambda
 *  app.dukhaan.ui.categories.-$$Lambda$2H4aB4aY_MtnFJPf9BQICBmCp5A
 *  app.dukhaan.ui.categories.-$$Lambda$CategoriesFragment
 *  app.dukhaan.ui.categories.-$$Lambda$CategoriesFragment$tqt9qihe7aXnD2Ujxe8-01uzvfA
 *  app.dukhaan.ui.categories.CategoriesFragment$1
 *  app.dukhaan.ui.categories.CategoriesNavigator
 *  app.dukhaan.ui.categories.CategoriesViewModel
 *  app.dukhaan.ui.categories.CategoryAdapter
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.categories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentCategoriesBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.DeleteCategoryResonse;
import app.dukhaan.network.model.SwipeRefreshEvent;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.categories.-$;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesFragment$Xfrli-UWhEDn5LCJtSCWgvojCdo;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesFragment$t9_V1pPfluiUhYgBj3EnNDSKeF4;
import app.dukhaan.ui.categories.CategoriesFragment;
import app.dukhaan.ui.categories.CategoriesNavigator;
import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryAdapter;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CategoriesFragment
extends BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>
implements CategoriesNavigator,
CategoryAdapter.CategoryMenuItemClickListener,
CategoryAdapter.CategoryListItemClick,
IdialogItemClickListner {
    private FragmentCategoriesBinding binding;
    private Business business;
    private CategoriesViewModel categoriesViewModel;
    private CategoryAdapter categoryAdapter;
    private ArrayList<Category> categoryArrayList = new ArrayList();
    private boolean loading = true;
    private LinearLayoutManager mLayoutManager;
    private int pagination = 1;
    private int pastVisibleItems;
    int position = 0;
    private int totalItemCount;
    private int visibleItemCount;

    static /* synthetic */ int access$000(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.visibleItemCount;
    }

    static /* synthetic */ int access$002(CategoriesFragment categoriesFragment, int n) { (view) -> {
        categoriesFragment.visibleItemCount = n;
        return n;
    }

    static /* synthetic */ LinearLayoutManager access$100(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.mLayoutManager;
    }

    static /* synthetic */ int access$200(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.totalItemCount;
    }

    static /* synthetic */ int access$202(CategoriesFragment categoriesFragment, int n) { (view) -> {
        categoriesFragment.totalItemCount = n;
        return n;
    }

    static /* synthetic */ int access$300(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.pastVisibleItems;
    }

    static /* synthetic */ int access$302(CategoriesFragment categoriesFragment, int n) { (view) -> {
        categoriesFragment.pastVisibleItems = n;
        return n;
    }

    static /* synthetic */ boolean access$400(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.loading;
    }

    static /* synthetic */ boolean access$402(CategoriesFragment categoriesFragment, boolean bl) { (view) -> {
        categoriesFragment.loading = bl;
        return bl;
    }

    static /* synthetic */ Business access$500(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.business;
    }

    static /* synthetic */ int access$600(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.pagination;
    }

    static /* synthetic */ CategoriesViewModel access$700(CategoriesFragment categoriesFragment) { (view) -> {
        return categoriesFragment.categoriesViewModel;
    }

    @Override
    public void categoryListItem(int n) {
        Category category = (Category)this.categoryArrayList.get(n);
        this.startActivityForResult(new Intent((Context)this.getActivity(), CategoryDetailActivity.class).putExtra("category", (Parcelable)category), 112);
    }

    public int getLayoutId() {
        return 2131558497;
    }

    protected Class<CategoriesViewModel> getViewModel() {
        return CategoriesViewModel.class;
    }

    public /* synthetic */ void lambda$onCreateView$0$CategoriesFragment(View view) { (view) -> {
        this.startActivityForResult(new Intent((Context)this.getActivity(), CreateCategoryActivity.class), 222);
    }

    public /* synthetic */ void lambda$onCreateView$1$CategoriesFragment(View view) { (view) -> {
        this.startActivityForResult(new Intent((Context)this.getActivity(), CreateCategoryActivity.class), 222);
    }

    public /* synthetic */ void lambda$onCreateView$2$CategoriesFragment() { (view) -> {
        this.loading = true;
        this.pagination = 1;
        this.categoriesViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        if (n == 222) {
            if (n2 == -1 && intent.getBooleanExtra("isCreated", false)) {
                this.refreshCategoryList();
                return;
            }
        } else if (n == 223) {
            if (n2 == -1 && intent.getBooleanExtra("isUpdated", false)) {
                int n3 = intent.getIntExtra("position", 0);
                String string2 = intent.getStringExtra("updatedName");
                ((Category)this.categoryArrayList.get(n3)).realmSet$name(string2);
                this.categoryAdapter.notifyItemChanged(n3);
                return;
            }
        } else if (n == 112 && n2 == -1 && intent.getBooleanExtra("refresh", false)) {
            this.pagination = 1;
            this.refreshCategoryList();
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
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
            this.pagination = 1;
            this.categoriesViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
        }
    }

    public void onCategoryDelete(DeleteCategoryResonse deleteCategoryResonse, int n) {
        this.hideFullscreenProgress();
        if (deleteCategoryResonse.getStatus().equals((Object)"success")) {
            this.categoryArrayList.remove(n);
            this.categoryAdapter.notifyDataSetChanged();
        }
        if (this.categoryArrayList.size() > 0) {
            this.binding.recyclerview.setVisibility(0);
            this.binding.emptyData.setData(this.getString(2131951877));
            this.binding.emptyData.setVisibility(8);
            this.binding.btnCreate.setVisibility(8);
            return;
        }
        this.binding.recyclerview.setVisibility(8);
        this.binding.emptyData.setData(this.getString(2131951877));
        this.binding.emptyData.setVisibility(0);
        this.binding.btnCreate.setVisibility(0);
    }

    public void onCategoryListFetched(List<Category> list, boolean bl) {
        this.binding.swipeRefresh.setRefreshing(false);
        this.hideFullscreenProgress();
        if (list != null && list.size() > 0) {
            if (this.pagination == 1) {
                this.categoryArrayList.clear();
            }
            if (bl) {
                this.loading = false;
            } else {
                this.pagination = 1 + this.pagination;
                this.loading = true;
            }
            this.categoryArrayList.addAll(list);
        }
        if (this.categoryArrayList.size() > 0) {
            this.categoryAdapter.notifyDataSetChanged();
            this.binding.emptyData.setVisibility(8);
            this.binding.recyclerview.setVisibility(0);
            this.binding.btnCreateFixed.setVisibility(0);
            this.binding.btnCreate.setVisibility(8);
            return;
        }
        this.binding.recyclerview.setVisibility(8);
        this.binding.btnCreateFixed.setVisibility(8);
        this.binding.emptyData.setData(this.getString(2131951877));
        this.binding.emptyData.setVisibility(0);
        this.binding.btnCreate.setVisibility(0);
    }

    protected void onCreateView(Bundle bundle, CategoriesViewModel categoriesViewModel, FragmentCategoriesBinding fragmentCategoriesBinding, Context context) {
        Business business;
        this.binding = fragmentCategoriesBinding;
        this.categoriesViewModel = categoriesViewModel;
        this.mActivity.onFragmentAttached(this);
        this.setHasOptionsMenu(true);
        this.categoriesViewModel.setNavigator((Object)this);
        this.categoryAdapter = new CategoryAdapter((CategoryAdapter.CategoryMenuItemClickListener)this, this.categoryArrayList, (CategoryAdapter.CategoryListItemClick)this);
        this.mLayoutManager = new LinearLayoutManager((Context)this.getActivity());
        fragmentCategoriesBinding.recyclerview.setLayoutManager((RecyclerView.LayoutManager)this.mLayoutManager);
        fragmentCategoriesBinding.recyclerview.setAdapter((RecyclerView.Adapter)this.categoryAdapter);
        this.showFullscreenProgress();
        this.business = business = categoriesViewModel.getDataManager().getBusiness();
        this.categoriesViewModel.getCategoryList(business.realmGet$id(), this.pagination);
        fragmentCategoriesBinding.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(2131099728));
        fragmentCategoriesBinding.swipeRefresh.setColorSchemeResources(new int[]{2131099737, 2131099737, 2131099737});
        fragmentCategoriesBinding.recyclerview.addOnScrollListener((RecyclerView.OnScrollListener)new 1(this));
        fragmentCategoriesBinding.btnCreate.setOnClickListener(new -$$Lambda$CategoriesFragment$Xfrli-UWhEDn5LCJtSCWgvojCdo(this));
        fragmentCategoriesBinding.btnCreateFixed.setOnClickListener(new -$$Lambda$CategoriesFragment$t9_V1pPfluiUhYgBj3EnNDSKeF4(this));
        fragmentCategoriesBinding.swipeRefresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)new -$.Lambda.CategoriesFragment.tqt9qihe7aXnD2Ujxe8-01uzvfA(this));
    }

    @Override
    public void onDeleteCategoryClicked(int n) {
        this.position = n;
        ModalDialogs.showCustomDialog((Context)this.getActivity(), DialogType.DELETE_CATEGORY, (IdialogItemClickListner)new -$.Lambda.2H4aB4aY_MtnFJPf9BQICBmCp5A(this));
    }

    @Override
    public void onEditCategoryClicked(int n) {
        Category category = (Category)this.categoryArrayList.get(n);
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditCategoryActivity.class).putExtra("categoryId", category.realmGet$id()).putExtra("position", n).putExtra("name", category.realmGet$name()), 223);
    }

    @Override
    public void onShareCategoryClicked(int n) {
        Business business = this.categoriesViewModel.getDataManager().getBusiness();
        Category category = (Category)this.categoryArrayList.get(n);
        if (business != null && category != null) {
            AppUtils.shareCategory(this.getContext(), business.realmGet$id(), category.realmGet$id(), category.realmGet$name(), AppUtils.getCategoryLink(business.realmGet$link(), category.realmGet$id()), AppPref.getInstance().getMobile());
        }
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onSwipeRefreshed(SwipeRefreshEvent swipeRefreshEvent) {
        if (this.isVisible()) {
            this.loading = true;
            this.pagination = 1;
            this.showFullscreenProgress();
            this.categoriesViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
        }
    }

    public void refreshCategoryList() {
        this.showFullscreenProgress();
        this.categoriesViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
    }

    @Override
    public void yesMakeIt() {
        Category category = (Category)this.categoryArrayList.get(this.position);
        this.showFullscreenProgress();
        this.categoriesViewModel.deleteCategory(category.realmGet$id(), this.position);
    }
}

