package app.dukhaan.ui.ui.categories;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentCategoriesBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.DeleteCategoryResonse;
import app.dukhaan.network.model.SwipeRefreshEvent;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.categories.CategoriesFragment.1;
import app.dukhaan.ui.categories.CategoriesNavigator;
import app.dukhaan.ui.categories.CategoriesViewModel;
import app.dukhaan.ui.categories.CategoryAdapter;
import app.dukhaan.ui.categories.CategoryAdapter.CategoryListItemClick;
import app.dukhaan.ui.categories.CategoryAdapter.CategoryMenuItemClickListener;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CategoriesFragment extends BaseFragment<FragmentCategoriesBinding, CategoriesViewModel> implements CategoriesNavigator, CategoryMenuItemClickListener, CategoryListItemClick, IdialogItemClickListner {
   private FragmentCategoriesBinding binding;
   private Business business;
   private CategoriesViewModel categoriesViewModel;
   private app.dukhaan.ui.categories.CategoryAdapter categoryAdapter;
   private ArrayList<Category> categoryArrayList = new ArrayList();
   private boolean loading = true;
   private LinearLayoutManager mLayoutManager;
   private int pagination = 1;
   private int pastVisibleItems;
   int position = 0;
   private int totalItemCount;
   private int visibleItemCount;

   public CategoriesFragment() {
   }

   public void categoryListItem(int var1) {
      Category var2 = (Category)this.categoryArrayList.get(var1);
      this.startActivityForResult((new Intent(this.getActivity(), CategoryDetailActivity.class)).putExtra("category", var2), 112);
   }

   public int getLayoutId() {
      return fragment_categories;
   }

   protected Class<CategoriesViewModel> getViewModel() {
      return CategoriesViewModel.class;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 222) {
         if (var2 == -1 && var3.getBooleanExtra("isCreated", false)) {
            this.refreshCategoryList();
         }
      } else if (var1 == 223) {
         if (var2 == -1 && var3.getBooleanExtra("isUpdated", false)) {
            var1 = var3.getIntExtra("position", 0);
            String var4 = var3.getStringExtra("updatedName");
            ((Category)this.categoryArrayList.get(var1)).realmSet$name(var4);
            this.categoryAdapter.notifyItemChanged(var1);
         }
      } else if (var1 == 112 && var2 == -1 && var3.getBooleanExtra("refresh", false)) {
         this.pagination = 1;
         this.refreshCategoryList();
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
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
         this.pagination = 1;
         this.categoriesViewModel.getCategoryList(this.business.realmGet$id(), this.pagination);
      }

   }

   public void onCategoryDelete(DeleteCategoryResonse var1, int var2) {
      this.hideFullscreenProgress();
      if (var1.getStatus().equals("success")) {
         this.categoryArrayList.remove(var2);
         this.categoryAdapter.notifyDataSetChanged();
      }

      if (this.categoryArrayList.size() > 0) {
         this.binding.recyclerview.setVisibility(0);
         this.binding.emptyData.setData(this.getString(R.string.no_category));
         this.binding.emptyData.setVisibility(8);
         this.binding.btnCreate.setVisibility(8);
      } else {
         this.binding.recyclerview.setVisibility(8);
         this.binding.emptyData.setData(this.getString(R.string.no_category));
         this.binding.emptyData.setVisibility(0);
         this.binding.btnCreate.setVisibility(0);
      }

   }

   public void onCategoryListFetched(List<Category> var1, boolean var2) {
      this.binding.swipeRefresh.setRefreshing(false);
      this.hideFullscreenProgress();
      if (var1 != null && var1.size() > 0) {
         if (this.pagination == 1) {
            this.categoryArrayList.clear();
         }

         if (var2) {
            this.loading = false;
         } else {
            ++this.pagination;
            this.loading = true;
         }

         this.categoryArrayList.addAll(var1);
      }

      if (this.categoryArrayList.size() > 0) {
         this.categoryAdapter.notifyDataSetChanged();
         this.binding.emptyData.setVisibility(8);
         this.binding.recyclerview.setVisibility(0);
         this.binding.btnCreateFixed.setVisibility(0);
         this.binding.btnCreate.setVisibility(8);
      } else {
         this.binding.recyclerview.setVisibility(8);
         this.binding.btnCreateFixed.setVisibility(8);
         this.binding.emptyData.setData(this.getString(R.string.no_category));
         this.binding.emptyData.setVisibility(0);
         this.binding.btnCreate.setVisibility(0);
      }

   }

   protected void onCreateView(Bundle var1, CategoriesViewModel var2, FragmentCategoriesBinding var3, Context var4) {
      this.binding = var3;
      this.categoriesViewModel = var2;
      this.mActivity.onFragmentAttached(this);
      this.setHasOptionsMenu(true);
      this.categoriesViewModel.setNavigator(this);
      this.categoryAdapter = new CategoryAdapter(this, this.categoryArrayList, this);
      this.mLayoutManager = new LinearLayoutManager(this.getActivity());
      var3.recyclerview.setLayoutManager(this.mLayoutManager);
      var3.recyclerview.setAdapter(this.categoryAdapter);
      this.showFullscreenProgress();
      Business var5 = var2.getDataManager().getBusiness();
      this.business = var5;
      this.categoriesViewModel.getCategoryList(var5.realmGet$id(), this.pagination);
      var3.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(R.color.colorPrimary));
      var3.swipeRefresh.setColorSchemeResources(new int[]{colorWhite, colorWhite, colorWhite});
      var3.recyclerview.addOnScrollListener(new 1(this));
      var3.btnCreate.setOnClickListener(new _$$Lambda$CategoriesFragment$Xfrli_UWhEDn5LCJtSCWgvojCdo(this));
      var3.btnCreateFixed.setOnClickListener(new _$$Lambda$CategoriesFragment$t9_V1pPfluiUhYgBj3EnNDSKeF4(this));
      var3.swipeRefresh.setOnRefreshListener(new _$$Lambda$CategoriesFragment$tqt9qihe7aXnD2Ujxe8_01uzvfA(this));
   }

   public void onDeleteCategoryClicked(int var1) {
      this.position = var1;
      ModalDialogs.showCustomDialog(this.getActivity(), DialogType.DELETE_CATEGORY, new _$$Lambda$2H4aB4aY_MtnFJPf9BQICBmCp5A(this));
   }

   public void onEditCategoryClicked(int var1) {
      Category var2 = (Category)this.categoryArrayList.get(var1);
      this.startActivityForResult((new Intent(this.getActivity(), EditCategoryActivity.class)).putExtra("categoryId", var2.realmGet$id()).putExtra("position", var1).putExtra("name", var2.realmGet$name()), 223);
   }

   public void onShareCategoryClicked(int var1) {
      Business var2 = this.categoriesViewModel.getDataManager().getBusiness();
      Category var3 = (Category)this.categoryArrayList.get(var1);
      if (var2 != null && var3 != null) {
         AppUtils.shareCategory(this.getContext(), var2.realmGet$id(), var3.realmGet$id(), var3.realmGet$name(), AppUtils.getCategoryLink(var2.realmGet$link(), var3.realmGet$id()), AppPref.getInstance().getMobile());
      }

   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onSwipeRefreshed(SwipeRefreshEvent var1) {
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

   public void yesMakeIt() {
      Category var1 = (Category)this.categoryArrayList.get(this.position);
      this.showFullscreenProgress();
      this.categoriesViewModel.deleteCategory(var1.realmGet$id(), this.position);
   }
}
