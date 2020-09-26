package app.dukhaan.ui.ui.categorydetail;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityCategoryDetailBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.categorydetail.CategoryDetailNaivigator;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.util.ModalDialogs;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CategoryDetailActivity extends BaseActivity<ActivityCategoryDetailBinding, CategoryDetailViewModel> implements CategoryDetailNaivigator {
   public static int PRODUCT_COUNT;
   static boolean active;
   ActivityCategoryDetailBinding binding;
   int businessId = 0;
   Category category;
   String categoryName = "";
   CategoryDetailViewModel viewModel;

   public CategoryDetailActivity() {
   }

   private void loadProductFragment() {
      Category var1 = this.category;
      if (var1 != null) {
         ProductsFragment var3 = ProductsFragment.newInstance(false, this.businessId, var1);
         FragmentTransaction var2 = this.getSupportFragmentManager().beginTransaction();
         var2.replace(product_container, var3);
         var2.commit();
      }
   }

   public int getLayoutId() {
      return activity_category_detail;
   }

   public Class<CategoryDetailViewModel> getViewModel() {
      return CategoryDetailViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
         this.loadProductFragment();
      }

   }

   public void onBackPressed() {
      Intent var1 = new Intent();
      var1.putExtra("refresh", true);
      this.setResult(-1, var1);
      this.finish();
      super.onBackPressed();
   }

   protected void onCreate(Bundle var1, CategoryDetailViewModel var2, ActivityCategoryDetailBinding var3) {
      this.binding = var3;
      this.viewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      Category var4 = (Category)this.getIntent().getParcelableExtra("category");
      this.category = var4;
      if (var4 != null) {
         this.businessId = var4.realmGet$id();
         this.categoryName = this.category.realmGet$name();
         PRODUCT_COUNT = this.category.realmGet$productCount();
      }

      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$CategoryDetailActivity$mZkJjaEZGBn3qNpi5BT2cD_9fXM(this));
      this.loadProductFragment();
   }

   protected void onResume() {
      super.onResume();
      this.refreshProductCount();
   }

   public void onStart() {
      super.onStart();
      active = true;
   }

   public void onStop() {
      super.onStop();
      active = false;
   }

   public void refreshProductCount() {
      if (PRODUCT_COUNT > 0) {
         this.binding.toolTitle.setText(this.getString(R.string.category_count, new Object[]{this.categoryName, String.valueOf(PRODUCT_COUNT)}));
      } else {
         this.binding.toolTitle.setText(this.categoryName);
      }

   }
}
