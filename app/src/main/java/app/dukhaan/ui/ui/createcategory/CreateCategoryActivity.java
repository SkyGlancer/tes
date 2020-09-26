package app.dukhaan.ui.ui.createcategory;

import android.content.Intent;
import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityCreateCategoryBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.createcategory.CreateCategoriesNavigator;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryActivity.1;
import app.dukhaan.ui.createcategory.CreateCategoryActivity.2;
import app.dukhaan.util.ModalDialogs;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CreateCategoryActivity extends BaseActivity<ActivityCreateCategoryBinding, CreateCategoriesViewModel> implements CreateCategoriesNavigator {
   private ActivityCreateCategoryBinding binding;
   private Business business;
   private CreateCategoriesViewModel viewModel;

   public CreateCategoryActivity() {
   }

   public int getLayoutId() {
      return activity_create_category;
   }

   public Class<CreateCategoriesViewModel> getViewModel() {
      return CreateCategoriesViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      this.binding.btnCreate.setBusy(false);
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      int var2 = var1.type;
      var2 = AppEvent.INTERNET_CONNECTION_CHECK;
   }

   protected void onCreate(Bundle var1, CreateCategoriesViewModel var2, ActivityCreateCategoryBinding var3) {
      this.binding = var3;
      this.viewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$CreateCategoryActivity$UzUJWQX_vMnQClcG507gs9MHzBo(this));
      this.business = var2.getDataManager().getBusiness();
      var3.idEtCategoryName.addTextChangedListener(new 1(this, var3));
      var3.btnCreate.setOnClickListener(new 2(this, var3, var2));
   }

   public void onCreateCategorySuccess(CreateCategoryResonse var1) {
      if (var1.getCategory() != null) {
         this.viewModel.getDataManager().saveCategory(var1.getCategory());
      }

      this.binding.btnCreate.setBusy(false);
      Intent var2 = new Intent();
      var2.putExtra("isCreated", true);
      this.setResult(-1, var2);
      this.finish();
   }
}
