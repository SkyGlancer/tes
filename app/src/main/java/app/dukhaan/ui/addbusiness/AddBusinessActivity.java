/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityAddBusinessBinding
 *  app.dukhaan.ui.addbusiness.-$
 *  app.dukhaan.ui.addbusiness.-$$Lambda
 *  app.dukhaan.ui.addbusiness.-$$Lambda$KHtUc-LthR3-ruJY9LhEVbNuE9k
 *  app.dukhaan.ui.addbusiness.-$$Lambda$gtIQk3HYrC_apDaeAB7M8BjHs5U
 *  app.dukhaan.ui.addbusiness.AddBusinessNavigator
 *  app.dukhaan.ui.addbusiness.AddBusinessViewModel
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  io.branch.referral.util.BranchEvent
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Locale
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.addbusiness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityAddBusinessBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.AddBusinessRequest;
import app.dukhaan.ui.addbusiness.-$;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessActivity$lZSFMLMnKn7HpNmQ2L1Kbfoujfw;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessActivity$q9JGGVu1SfbIhmRNhJDlUjPjHaI;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessActivity$qK1Y7CIPEOEw3xq3Eyk4pG6Pf_I;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.addbusiness.AddBusinessNavigator;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.CountData;
import app.dukhaan.util.ModalDialogs;
import io.branch.referral.util.BranchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AddBusinessActivity
extends BaseActivity<ActivityAddBusinessBinding, AddBusinessViewModel>
implements CountriesAdapter.OnCountrySelectedListener,
TextWatcher,
View.OnClickListener,
AddBusinessNavigator {
    private ActivityAddBusinessBinding binding;
    private List<Country> countries;
    private CountriesAdapter countriesAdapter;
    private double lat;
    private double lng;
    private AddBusinessViewModel mViewModel;
    private PopupWindow popUp;
    private List<Country> searchResults;
    private Country selectedCountry;

    static /* synthetic */ void access$000(AddBusinessActivity addBusinessActivity, View view) {
        addBusinessActivity.showCountyPicker(view);
    }

    static /* synthetic */ void access$100(AddBusinessActivity addBusinessActivity, String string2) {
        addBusinessActivity.search(string2);
    }

    static /* synthetic */ ActivityAddBusinessBinding access$200(AddBusinessActivity addBusinessActivity) {
        return addBusinessActivity.binding;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View((Context)activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    static /* synthetic */ int lambda$sortCountries$2(Country country, Country country2) {
        return country.getName().trim().compareToIgnoreCase(country2.getName().trim());
    }

    private void search(String string2) {
        this.searchResults.clear();
        for (Country country : this.countries) {
            if (!country.getName().toLowerCase(Locale.ENGLISH).contains((CharSequence)string2.toLowerCase())) continue;
            this.searchResults.add((Object)country);
        }
        this.sortCountries(this.searchResults);
        this.countriesAdapter.notifyDataSetChanged();
    }

    private void setDefaultCountry() {
        Country country2;
        block3 : {
            for (Country country2 : CountData.COUNTRIES) {
                if (!country2.getCode().equalsIgnoreCase("IN")) {
                    continue;
                }
                break block3;
            }
            country2 = null;
        }
        if (country2 != null) {
            this.selectedCountry = country2;
            this.binding.idInputCountryName.setText((CharSequence)country2.getName());
        }
    }

    private void showCountyPicker(View view) {
        PopupWindow popupWindow;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n = displayMetrics.heightPixels;
        int n2 = displayMetrics.widthPixels;
        View view2 = LayoutInflater.from((Context)this).inflate(2131558602, null, false);
        this.popUp = popupWindow = new PopupWindow(view2, n2, n / 2, false);
        popupWindow.setTouchable(true);
        this.popUp.setFocusable(true);
        this.popUp.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.popUp.setElevation(5.0f);
        }
        this.popUp.showAsDropDown((View)this.binding.idInputCountryName);
        RecyclerView recyclerView = (RecyclerView)view2.findViewById(2131361984);
        EditText editText = (EditText)view2.findViewById(2131361985);
        recyclerView.setAdapter((RecyclerView.Adapter)this.countriesAdapter);
        editText.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ AddBusinessActivity this$0;
            {
                this.this$0 = addBusinessActivity;
            }

            public void afterTextChanged(Editable editable) {
                AddBusinessActivity.access$100(this.this$0, editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener(this, editText){
            final /* synthetic */ AddBusinessActivity this$0;
            final /* synthetic */ EditText val$inputCountry;
            {
                this.this$0 = addBusinessActivity;
                this.val$inputCountry = editText;
            }

            public boolean onEditorAction(TextView textView, int n, android.view.KeyEvent keyEvent) {
                InputMethodManager inputMethodManager = (InputMethodManager)this.val$inputCountry.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.val$inputCountry.getWindowToken(), 0);
                }
                return true;
            }
        });
        this.popUp.setOnDismissListener(new PopupWindow.OnDismissListener(this){
            final /* synthetic */ AddBusinessActivity this$0;
            {
                this.this$0 = addBusinessActivity;
            }

            public void onDismiss() {
                AddBusinessActivity.access$200((AddBusinessActivity)this.this$0).idSpinnerImage.rotate();
            }
        });
    }

    private void sortCountries(List<Country> list) {
        Collections.sort(list, (Comparator)-$$Lambda$AddBusinessActivity$qK1Y7CIPEOEw3xq3Eyk4pG6Pf_I.INSTANCE);
    }

    private void validateForm() {
        if (TextUtils.isEmpty((CharSequence)this.binding.idInputBusinessName.getText())) {
            return;
        }
        if (this.selectedCountry == null) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)this.binding.idInputAddress.getText())) {
            return;
        }
        this.binding.idBtnFinish.setEnabled(true);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    @Override
    public int getLayoutId() {
        return 2131558428;
    }

    @Override
    public Class<AddBusinessViewModel> getViewModel() {
        return AddBusinessViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$AddBusinessActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$AddBusinessActivity(ActivityAddBusinessBinding activityAddBusinessBinding, View view) {
        activityAddBusinessBinding.idInputAddress.setClickable(false);
        this.startActivityForResult(new Intent((Context)this, AddressSelectActivity.class), 225);
    }

    public void launchTutorial() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        CleverTapUtils.trackBusinessCreated((Context)this, business);
        new BranchEvent("Business Created").addCustomDataProperty("phone", business.realmGet$mobile()).addCustomDataProperty("name", business.realmGet$name()).addCustomDataProperty("link", business.realmGet$link()).setCustomerEventAlias("business_created").logEvent((Context)this);
        Intent intent = new Intent((Context)this, SyncContactsActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.binding.idInputAddress.setClickable(true);
        if (n == 225 && n2 == -1) {
            String string2 = intent.getStringExtra("userAddress");
            this.lat = intent.getDoubleExtra("lat", 0.0);
            this.lng = intent.getDoubleExtra("lng", 0.0);
            this.binding.idInputAddress.setText((CharSequence)string2);
            this.binding.idInputAddress.setCompoundDrawables(null, null, null, null);
            this.validateForm();
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
    }

    public void onClick(View view) {
        if (view.getId() != 2131362163) {
            return;
        }
        AddBusinessRequest addBusinessRequest = new AddBusinessRequest();
        addBusinessRequest.address = this.binding.idInputAddress.getText().toString();
        addBusinessRequest.name = this.binding.idInputBusinessName.getText().toString();
        addBusinessRequest.country = this.selectedCountry.getName();
        addBusinessRequest.imageUrl = "https://dukaan-api.1kg.me/static/images/store-def.jpg";
        addBusinessRequest.latitude = this.lat;
        addBusinessRequest.longitude = this.lng;
        this.mViewModel.addBusiness(addBusinessRequest);
    }

    @Override
    public void onCountrySelected(Country country) {
        this.selectedCountry = country;
        this.popUp.dismiss();
        this.binding.idInputCountryName.setText((CharSequence)country.getName());
        this.validateForm();
    }

    @Override
    protected void onCreate(Bundle bundle, AddBusinessViewModel addBusinessViewModel, ActivityAddBusinessBinding activityAddBusinessBinding) {
        ArrayList arrayList;
        this.binding = activityAddBusinessBinding;
        this.mViewModel = addBusinessViewModel;
        addBusinessViewModel.setNavigator((Object)this);
        this.changeStatusBarColor();
        this.setSupportActionBar(activityAddBusinessBinding.toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setTitle((CharSequence)"");
            this.getSupportActionBar().setHomeAsUpIndicator(2131231220);
        }
        activityAddBusinessBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$AddBusinessActivity$q9JGGVu1SfbIhmRNhJDlUjPjHaI(this));
        this.countries = new ArrayList((Collection)Arrays.asList((Object[])CountData.COUNTRIES));
        this.searchResults = arrayList = new ArrayList();
        arrayList.addAll(this.countries);
        this.countriesAdapter = new CountriesAdapter((Context)this, this.searchResults, (CountriesAdapter.OnCountrySelectedListener)new -$.Lambda.gtIQk3HYrC_apDaeAB7M8BjHs5U(this));
        activityAddBusinessBinding.idInputCountryName.setOnClickListener(new View.OnClickListener(this, activityAddBusinessBinding){
            final /* synthetic */ AddBusinessActivity this$0;
            final /* synthetic */ ActivityAddBusinessBinding val$binding;
            {
                this.this$0 = addBusinessActivity;
                this.val$binding = activityAddBusinessBinding;
            }

            public void onClick(View view) {
                AddBusinessActivity.hideKeyboard((Activity)this.this$0);
                AddBusinessActivity.access$000(this.this$0, view);
                this.val$binding.idSpinnerImage.rotate();
            }
        });
        activityAddBusinessBinding.idInputAddress.setOnClickListener((View.OnClickListener)new -$$Lambda$AddBusinessActivity$lZSFMLMnKn7HpNmQ2L1Kbfoujfw(this, activityAddBusinessBinding));
        activityAddBusinessBinding.idInputWhatsappNumber.addTextChangedListener((TextWatcher)this);
        activityAddBusinessBinding.idInputBusinessName.addTextChangedListener((TextWatcher)this);
        activityAddBusinessBinding.idBtnFinish.setOnClickListener(this);
        LiveData liveData = this.mViewModel.getLoading();
        PrimaryButton primaryButton = activityAddBusinessBinding.idBtnFinish;
        primaryButton.getClass();
        liveData.observe((LifecycleOwner)this, (Observer)new -$.Lambda.KHtUc-LthR3-ruJY9LhEVbNuE9k(primaryButton));
        this.setDefaultCountry();
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        this.validateForm();
    }
}

