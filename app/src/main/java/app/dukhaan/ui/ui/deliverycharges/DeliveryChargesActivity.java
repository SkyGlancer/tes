package app.dukhaan.ui.ui.deliverycharges;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityDeliveryChargesBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.EditDeliveryChargeRequest;
import app.dukhaan.ui.deliverycharges.DeliveryChargesNavigator;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.ModalDialogs;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DeliveryChargesActivity extends BaseActivity<ActivityDeliveryChargesBinding, DeliveryChargesViewModel> implements DeliveryChargesNavigator {
   static boolean active;
   ActivityDeliveryChargesBinding binding;
   Business business;
   private String countryCurrency;
   private String currency = "";
   DeliveryChargesViewModel viewModel;

   public DeliveryChargesActivity() {
   }

   private void editDeliveryCharges() {
      this.binding.saveChanges.setBusy(true);
      EditDeliveryChargeRequest var1 = new EditDeliveryChargeRequest();
      var1.setDeliveryCost(Double.parseDouble(this.binding.priceDeliveryCharge.getText().toString().trim()));
      if (!TextUtils.isEmpty(this.binding.priceFreeDelivery.getText().toString())) {
         var1.setDeliveryCostLimit(Double.parseDouble(this.binding.priceFreeDelivery.getText().toString().trim()));
      }

      this.viewModel.updateDeliveryChargeDetails(this.business.realmGet$id(), var1);
   }

   private void renderForm() {
      Business var1 = this.viewModel.getDataManager().getBusiness();
      if (var1 != null) {
         if (var1.realmGet$deliveryCost() > 0.0D) {
            this.binding.priceDeliveryCharge.setText(String.valueOf((int)var1.realmGet$deliveryCost()));
         }

         if (var1.realmGet$deliveryCostLimit() > 0.0D) {
            this.binding.priceFreeDelivery.setText(String.valueOf((int)var1.realmGet$deliveryCostLimit()));
         }
      }

   }

   public int getLayoutId() {
      return activity_delivery_charges;
   }

   public Class<DeliveryChargesViewModel> getViewModel() {
      return DeliveryChargesViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      this.binding.saveChanges.setBusy(false);
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
         this.binding.saveChanges.setBusy(false);
      }

   }

   public void onBusinessUpdated(Business var1) {
      this.binding.saveChanges.setBusy(false);
      this.finish();
   }

   protected void onCreate(Bundle var1, DeliveryChargesViewModel var2, ActivityDeliveryChargesBinding var3) {
      this.viewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      this.business = var2.getDataManager().getBusiness();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$DeliveryChargesActivity$c_x_A5gI1tu5p4A8jEtH3Q64Mrw(this));
      if (AppPref.getInstance().getCurrency() != null) {
         String var4 = AppPref.getInstance().getCurrency();
         this.countryCurrency = var4;
         this.currency = AppUtils.getCurrencySymbol(var4);
      }

      Drawable var5;
      if (!TextUtils.isEmpty(this.currency)) {
         var5 = AppUtils.getSymbol(this, this.currency, var3.priceDeliveryCharge.getTextSize(), ContextCompat.getColor(R.color.this, colorInputValue));
         var3.priceDeliveryCharge.setCompoundDrawablesWithIntrinsicBounds(var5, (Drawable)null, (Drawable)null, (Drawable)null);
         var3.priceFreeDelivery.setCompoundDrawablesWithIntrinsicBounds(var5, (Drawable)null, (Drawable)null, (Drawable)null);
      } else {
         var5 = AppUtils.getSymbol(this, "₹", var3.priceDeliveryCharge.getTextSize(), ContextCompat.getColor(R.color.this, colorInputValue));
         var3.priceDeliveryCharge.setCompoundDrawablesWithIntrinsicBounds(var5, (Drawable)null, (Drawable)null, (Drawable)null);
         var3.priceFreeDelivery.setCompoundDrawablesWithIntrinsicBounds(var5, (Drawable)null, (Drawable)null, (Drawable)null);
      }

      var3.saveChanges.setOnClickListener(new _$$Lambda$DeliveryChargesActivity$qRk0IcHtmacDo8G5QCpnGH1GpG8(this));
      var3.priceDeliveryCharge.addTextChangedListener(new app.dukhaan.ui.deliverycharges.DeliveryChargesActivity.CustomTextWatcher(this));
      var3.priceFreeDelivery.addTextChangedListener(new app.dukhaan.ui.deliverycharges.DeliveryChargesActivity.CustomTextWatcher(this));
      this.renderForm();
   }

   public void onStart() {
      super.onStart();
      active = true;
   }

   public void onStop() {
      super.onStop();
      active = false;
   }

   public boolean validateDeliveryCharge() {
      return !TextUtils.isEmpty(this.binding.priceDeliveryCharge.getText().toString().trim());
   }

   public boolean validateFreeDeliveryCharge() {
      return !TextUtils.isEmpty(this.binding.priceFreeDelivery.getText().toString().trim());
   }
}
