package app.dukhaan.ui.ui.addbusiness;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityAddBusinessBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.AddBusinessRequest;
import app.dukhaan.ui.addbusiness.AddBusinessActivity.1;
import app.dukhaan.ui.addbusiness.AddBusinessActivity.2;
import app.dukhaan.ui.addbusiness.AddBusinessActivity.3;
import app.dukhaan.ui.addbusiness.AddBusinessActivity.4;
import app.dukhaan.ui.addbusiness.AddBusinessNavigator;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.selectcountry.CountriesAdapter.OnCountrySelectedListener;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.CountData;
import app.dukhaan.util.ModalDialogs;
import io.branch.referral.util.BranchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AddBusinessActivity extends BaseActivity<ActivityAddBusinessBinding, AddBusinessViewModel> implements OnCountrySelectedListener, TextWatcher, OnClickListener, AddBusinessNavigator {
   private ActivityAddBusinessBinding binding;
   private List<Country> countries;
   private CountriesAdapter countriesAdapter;
   private double lat;
   private double lng;
   private AddBusinessViewModel mViewModel;
   private PopupWindow popUp;
   private List<Country> searchResults;
   private Country selectedCountry;

   public AddBusinessActivity() {
   }

   public static void hideKeyboard(Activity var0) {
      InputMethodManager var1 = (InputMethodManager)var0.getSystemService("input_method");
      View var2 = var0.getCurrentFocus();
      View var3 = var2;
      if (var2 == null) {
         var3 = new View(var0);
      }

      var1.hideSoftInputFromWindow(var3.getWindowToken(), 0);
   }

   private void search(String var1) {
      this.searchResults.clear();
      Iterator var2 = this.countries.iterator();

      while(var2.hasNext()) {
         Country var3 = (Country)var2.next();
         if (var3.getName().toLowerCase(Locale.ENGLISH).contains(var1.toLowerCase())) {
            this.searchResults.add(var3);
         }
      }

      this.sortCountries(this.searchResults);
      this.countriesAdapter.notifyDataSetChanged();
   }

   private void setDefaultCountry() {
      Country[] var1 = CountData.COUNTRIES;
      int var2 = var1.length;
      int var3 = 0;

      Country var4;
      while(true) {
         if (var3 >= var2) {
            var4 = null;
            break;
         }

         var4 = var1[var3];
         if (var4.getCode().equalsIgnoreCase("IN")) {
            break;
         }

         ++var3;
      }

      if (var4 != null) {
         this.selectedCountry = var4;
         this.binding.idInputCountryName.setText(var4.getName());
      }

   }

   private void showCountyPicker(View var1) {
      DisplayMetrics var5 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var5);
      int var2 = var5.heightPixels;
      int var3 = var5.widthPixels;
      var1 = LayoutInflater.from(this).inflate(popup_country_picker, (ViewGroup)null, false);
      PopupWindow var4 = new PopupWindow(var1, var3, var2 / 2, false);
      this.popUp = var4;
      var4.setTouchable(true);
      this.popUp.setFocusable(true);
      this.popUp.setOutsideTouchable(true);
      if (VERSION.SDK_INT >= 21) {
         this.popUp.setElevation(5.0F);
      }

      this.popUp.showAsDropDown(this.binding.idInputCountryName);
      RecyclerView var7 = (RecyclerView)var1.findViewById(countries_recycler_view);
      EditText var6 = (EditText)var1.findViewById(country_code_picker_search);
      var7.setAdapter(this.countriesAdapter);
      var6.addTextChangedListener(new 2(this));
      var6.setOnEditorActionListener(new 3(this, var6));
      this.popUp.setOnDismissListener(new 4(this));
   }

   private void sortCountries(List<Country> var1) {
      Collections.sort(var1, _$$Lambda$AddBusinessActivity$qK1Y7CIPEOEw3xq3Eyk4pG6Pf_I.INSTANCE);
   }

   private void validateForm() {
      if (!TextUtils.isEmpty(this.binding.idInputBusinessName.getText())) {
         if (this.selectedCountry != null) {
            if (!TextUtils.isEmpty(this.binding.idInputAddress.getText())) {
               this.binding.idBtnFinish.setEnabled(true);
            }
         }
      }
   }

   public void afterTextChanged(Editable var1) {
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public int getLayoutId() {
      return activity_add_business;
   }

   public Class<AddBusinessViewModel> getViewModel() {
      return AddBusinessViewModel.class;
   }

   public void launchTutorial() {
      Business var1 = this.mViewModel.getDataManager().getBusiness();
      CleverTapUtils.trackBusinessCreated(this, var1);
      (new BranchEvent("Business Created")).addCustomDataProperty("phone", var1.realmGet$mobile()).addCustomDataProperty("name", var1.realmGet$name()).addCustomDataProperty("link", var1.realmGet$link()).setCustomerEventAlias("business_created").logEvent(this);
      Intent var2 = new Intent(this, SyncContactsActivity.class);
      var2.setFlags(268468224);
      this.startActivity(var2);
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      this.binding.idInputAddress.setClickable(true);
      if (var1 == 225 && var2 == -1) {
         String var4 = var3.getStringExtra("userAddress");
         this.lat = var3.getDoubleExtra("lat", 0.0D);
         this.lng = var3.getDoubleExtra("lng", 0.0D);
         this.binding.idInputAddress.setText(var4);
         this.binding.idInputAddress.setCompoundDrawables((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
         this.validateForm();
      }

   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      int var2 = var1.type;
      var2 = AppEvent.INTERNET_CONNECTION_CHECK;
   }

   public void onClick(View var1) {
      if (var1.getId() == id_btn_finish) {
         AddBusinessRequest var2 = new AddBusinessRequest();
         var2.address = this.binding.idInputAddress.getText().toString();
         var2.name = this.binding.idInputBusinessName.getText().toString();
         var2.country = this.selectedCountry.getName();
         var2.imageUrl = "https://dukaan-api.1kg.me/static/images/store-def.jpg";
         var2.latitude = this.lat;
         var2.longitude = this.lng;
         this.mViewModel.addBusiness(var2);
      }

   }

   public void onCountrySelected(Country var1) {
      this.selectedCountry = var1;
      this.popUp.dismiss();
      this.binding.idInputCountryName.setText(var1.getName());
      this.validateForm();
   }

   protected void onCreate(Bundle var1, AddBusinessViewModel var2, ActivityAddBusinessBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.changeStatusBarColor();
      this.setSupportActionBar(var3.toolbar);
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         this.getSupportActionBar().setTitle("");
         this.getSupportActionBar().setHomeAsUpIndicator(ic_back_arrow_black);
      }

      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$AddBusinessActivity$q9JGGVu1SfbIhmRNhJDlUjPjHaI(this));
      this.countries = new ArrayList(Arrays.asList(CountData.COUNTRIES));
      ArrayList var4 = new ArrayList();
      this.searchResults = var4;
      var4.addAll(this.countries);
      this.countriesAdapter = new CountriesAdapter(this, this.searchResults, new _$$Lambda$gtIQk3HYrC_apDaeAB7M8BjHs5U(this));
      var3.idInputCountryName.setOnClickListener(new 1(this, var3));
      var3.idInputAddress.setOnClickListener(new _$$Lambda$AddBusinessActivity$lZSFMLMnKn7HpNmQ2L1Kbfoujfw(this, var3));
      var3.idInputWhatsappNumber.addTextChangedListener(this);
      var3.idInputBusinessName.addTextChangedListener(this);
      var3.idBtnFinish.setOnClickListener(this);
      LiveData var5 = this.mViewModel.getLoading();
      PrimaryButton var6 = var3.idBtnFinish;
      var6.getClass();
      var5.observe(this, new _$$Lambda$KHtUc_LthR3_ruJY9LhEVbNuE9k(var6));
      this.setDefaultCountry();
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      this.validateForm();
   }
}
