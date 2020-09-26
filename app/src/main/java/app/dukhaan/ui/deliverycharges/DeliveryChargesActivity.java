/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityDeliveryChargesBinding
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesNavigator
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.deliverycharges;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityDeliveryChargesBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.EditDeliveryChargeRequest;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesActivity$c_x-A5gI1tu5p4A8jEtH3Q64Mrw;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesActivity$qRk0IcHtmacDo8G5QCpnGH1GpG8;
import app.dukhaan.ui.deliverycharges.DeliveryChargesNavigator;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DeliveryChargesActivity
extends BaseActivity<ActivityDeliveryChargesBinding, DeliveryChargesViewModel>
implements DeliveryChargesNavigator {
    static boolean active;
    ActivityDeliveryChargesBinding binding;
    Business business;
    private String countryCurrency;
    private String currency = "";
    DeliveryChargesViewModel viewModel;

    private void editDeliveryCharges() {
        this.binding.saveChanges.setBusy(true);
        EditDeliveryChargeRequest editDeliveryChargeRequest = new EditDeliveryChargeRequest();
        editDeliveryChargeRequest.setDeliveryCost(Double.parseDouble((String)this.binding.priceDeliveryCharge.getText().toString().trim()));
        if (!TextUtils.isEmpty((CharSequence)this.binding.priceFreeDelivery.getText().toString())) {
            editDeliveryChargeRequest.setDeliveryCostLimit(Double.parseDouble((String)this.binding.priceFreeDelivery.getText().toString().trim()));
        }
        this.viewModel.updateDeliveryChargeDetails(this.business.realmGet$id(), editDeliveryChargeRequest);
    }

    private void renderForm() {
        Business business = this.viewModel.getDataManager().getBusiness();
        if (business != null) {
            if (business.realmGet$deliveryCost() > 0.0) {
                this.binding.priceDeliveryCharge.setText((CharSequence)String.valueOf((int)((int)business.realmGet$deliveryCost())));
            }
            if (business.realmGet$deliveryCostLimit() > 0.0) {
                this.binding.priceFreeDelivery.setText((CharSequence)String.valueOf((int)((int)business.realmGet$deliveryCostLimit())));
            }
        }
    }

    @Override
    public int getLayoutId() {
        return 2131558436;
    }

    @Override
    public Class<DeliveryChargesViewModel> getViewModel() {
        return DeliveryChargesViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$DeliveryChargesActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$DeliveryChargesActivity(View view) {
        this.editDeliveryCharges();
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.binding.saveChanges.setBusy(false);
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
            this.binding.saveChanges.setBusy(false);
        }
    }

    public void onBusinessUpdated(Business business) {
        this.binding.saveChanges.setBusy(false);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle bundle, DeliveryChargesViewModel deliveryChargesViewModel, ActivityDeliveryChargesBinding activityDeliveryChargesBinding) {
        this.viewModel = deliveryChargesViewModel;
        this.binding = activityDeliveryChargesBinding;
        deliveryChargesViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityDeliveryChargesBinding.toolbar);
        this.enableToolbarUpNavigation();
        this.business = deliveryChargesViewModel.getDataManager().getBusiness();
        activityDeliveryChargesBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$DeliveryChargesActivity$c_x-A5gI1tu5p4A8jEtH3Q64Mrw(this));
        if (AppPref.getInstance().getCurrency() != null) {
            String string2;
            this.countryCurrency = string2 = AppPref.getInstance().getCurrency();
            this.currency = AppUtils.getCurrencySymbol(string2);
        }
        if (!TextUtils.isEmpty((CharSequence)this.currency)) {
            Drawable drawable2 = AppUtils.getSymbol((Context)this, this.currency, activityDeliveryChargesBinding.priceDeliveryCharge.getTextSize(), ContextCompat.getColor((Context)this, (int)2131099722));
            activityDeliveryChargesBinding.priceDeliveryCharge.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null);
            activityDeliveryChargesBinding.priceFreeDelivery.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null);
        } else {
            Drawable drawable3 = AppUtils.getSymbol((Context)this, "\u20b9", activityDeliveryChargesBinding.priceDeliveryCharge.getTextSize(), ContextCompat.getColor((Context)this, (int)2131099722));
            activityDeliveryChargesBinding.priceDeliveryCharge.setCompoundDrawablesWithIntrinsicBounds(drawable3, null, null, null);
            activityDeliveryChargesBinding.priceFreeDelivery.setCompoundDrawablesWithIntrinsicBounds(drawable3, null, null, null);
        }
        activityDeliveryChargesBinding.saveChanges.setOnClickListener(new -$$Lambda$DeliveryChargesActivity$qRk0IcHtmacDo8G5QCpnGH1GpG8(this));
        activityDeliveryChargesBinding.priceDeliveryCharge.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                if (!DeliveryChargesActivity.this.validateDeliveryCharge()) {
                    DeliveryChargesActivity.this.binding.saveChanges.setEnabled(false);
                    return;
                }
                DeliveryChargesActivity.this.binding.saveChanges.setEnabled(true);
            }
        });
        activityDeliveryChargesBinding.priceFreeDelivery.addTextChangedListener(new /* invalid duplicate definition of identical inner class */);
        this.renderForm();
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    public void onStop() {
        super.onStop();
        active = false;
    }

    public boolean validateDeliveryCharge() {
        return !TextUtils.isEmpty((CharSequence)this.binding.priceDeliveryCharge.getText().toString().trim());
    }

    public boolean validateFreeDeliveryCharge() {
        return !TextUtils.isEmpty((CharSequence)this.binding.priceFreeDelivery.getText().toString().trim());
    }

}

