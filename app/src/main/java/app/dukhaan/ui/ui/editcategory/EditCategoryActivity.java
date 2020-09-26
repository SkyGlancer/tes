package app.dukhaan.ui.ui.editcategory;

import android.content.Intent;
import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityEditCategoryBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.editcategory.EditCategoriesNavigator;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryActivity.1;
import app.dukhaan.ui.editcategory.EditCategoryActivity.2;
import app.dukhaan.util.ModalDialogs;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditCategoryActivity extends BaseActivity<ActivityEditCategoryBinding, EditCategoriesViewModel> implements EditCategoriesNavigator {
   static boolean active;
   private ActivityEditCategoryBinding binding;
   private Business business;
   private int categoryId;
   private String categoryName;
   private int position;
   private EditCategoriesViewModel viewModel;

   public EditCategoryActivity() {
   }

   public int getLayoutId() {
      return activity_edit_category;
   }

   public Class<EditCategoriesViewModel> getViewModel() {
      return EditCategoriesViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      this.binding.btnUpdate.setBusy(false);
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
         this.binding.btnUpdate.setBusy(false);
      }

   }

   public void onCategoryUpdateResponse(CreateCategoryResonse var1) {
      this.binding.btnUpdate.setBusy(false);
      Intent var2 = new Intent();
      var2.putExtra("isUpdated", true);
      var2.putExtra("updatedName", this.binding.idEtCategoryName.getText().toString());
      var2.putExtra("position", this.position);
      this.setResult(-1, var2);
      this.finish();
   }

   protected void onCreate(Bundle var1, EditCategoriesViewModel var2, ActivityEditCategoryBinding var3) {
      this.binding = var3;
      this.viewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      this.categoryId = this.getIntent().getIntExtra("categoryId", 0);
      this.categoryName = this.getIntent().getStringExtra("name");
      this.position = this.getIntent().getIntExtra("position", 0);
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$EditCategoryActivity$vQu_DbK6z8UOs6340dLjE3tuHOo(this));
      var3.idEtCategoryName.setText(this.categoryName);
      this.business = var2.getDataManager().getBusiness();
      var3.idEtCategoryName.addTextChangedListener(new 1(this, var3));
      var3.btnUpdate.setOnClickListener(new 2(this, var3, var2));
   }

   public void onStart() {
      super.onStart();
      active = true;
   }

   public void onStop() {
      super.onStop();
      active = false;
   }
}
