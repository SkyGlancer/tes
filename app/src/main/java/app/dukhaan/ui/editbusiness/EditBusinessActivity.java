/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
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
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  android.widget.Toast
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityBusinessDetailsEditBinding
 *  app.dukhaan.ui.editbusiness.-$
 *  app.dukhaan.ui.editbusiness.-$$Lambda
 *  app.dukhaan.ui.editbusiness.-$$Lambda$b4ZKQkHElZ-f1UkpcnmvBqDbNXg
 *  app.dukhaan.ui.editbusiness.EditBusinessActivity$6
 *  app.dukhaan.ui.editbusiness.EditBusinessActivity$7
 *  app.dukhaan.ui.editbusiness.EditBusinessActivity$8
 *  app.dukhaan.ui.editbusiness.EditBusinessNavigator
 *  app.dukhaan.ui.editbusiness.EditBusinessViewModel
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.FutureTarget
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  com.karumi.dexter.Dexter
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Locale
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.editbusiness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Country;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.databinding.ActivityBusinessDetailsEditBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import app.dukhaan.ui.editbusiness.-$;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$1IvXlX7nr-hLCwbbi-BII9z86IY;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$6U3lxYdzMotnkNBEfZEE0smf4AY;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$DsnL9t33NMQ5T-rJsJ4QuWzogBY;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$Kq0OZAPlGzZSjIkAO5LtMopQyYw;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$aHVYuWF3-6EYvRU21LlP7Hdc2AY;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$jseTFu9u80RdWcWwjv1EdudwUos;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessActivity$lAuXI4x_XYUzf6Xwj-rRlm9Cf0Q;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import app.dukhaan.ui.editbusiness.EditBusinessNavigator;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import app.dukhaan.ui.imagepicker.ImagePickerActivity;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.SpinnerImage;
import app.dukhaan.util.CountData;
import app.dukhaan.util.ModalDialogs;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import okhttp3.MultipartBody;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditBusinessActivity
extends BaseActivity<ActivityBusinessDetailsEditBinding, EditBusinessViewModel>
implements CountriesAdapter.OnCountrySelectedListener,
EditBusinessNavigator {
    static final /* synthetic */ boolean $assertionsDisabled;
    static boolean active;
    private ActivityBusinessDetailsEditBinding binding;
    private Business business;
    private List<Country> countries;
    private CountriesAdapter countriesAdapter;
    MultipartBody.Part filePart;
    Uri fileUri;
    private boolean isProfileChanged = false;
    boolean isStoreUrlChanged = false;
    private double lat;
    private double lng;
    private PopupWindow popUp;
    private List<Country> searchResults;
    private Country selectedCountry;
    private EditBusinessViewModel viewModel;

    static /* synthetic */ void access$000(EditBusinessActivity editBusinessActivity) {
        editBusinessActivity.hideStoreUrlTakenError();
    }

    static /* synthetic */ String access$100(EditBusinessActivity editBusinessActivity) {
        return editBusinessActivity.getStoreBaseUrl();
    }

    static /* synthetic */ void access$200(EditBusinessActivity editBusinessActivity) {
        editBusinessActivity.hideBusinessNameError();
    }

    static /* synthetic */ void access$300(EditBusinessActivity editBusinessActivity, String string2) {
        editBusinessActivity.search(string2);
    }

    static /* synthetic */ ActivityBusinessDetailsEditBinding access$400(EditBusinessActivity editBusinessActivity) {
        return editBusinessActivity.binding;
    }

    static /* synthetic */ void access$500(EditBusinessActivity editBusinessActivity) {
        editBusinessActivity.showImagePickerOptions();
    }

    static /* synthetic */ void access$600(EditBusinessActivity editBusinessActivity) {
        editBusinessActivity.launchCameraIntent();
    }

    static /* synthetic */ void access$700(EditBusinessActivity editBusinessActivity) {
        editBusinessActivity.launchGalleryIntent();
    }

    static /* synthetic */ EditBusinessViewModel access$800(EditBusinessActivity editBusinessActivity) {
        return editBusinessActivity.viewModel;
    }

    private String getStoreBaseUrl() {
        return "https://mydukaan.io/".replace((CharSequence)"https://", (CharSequence)"");
    }

    private void hideBusinessNameError() {
        this.binding.idEtBusinessName.setBackgroundDrawable(this.getResources().getDrawable(2131230951));
        this.binding.errorBusinessName.setVisibility(8);
    }

    private void hideStoreUrlTakenError() {
        this.binding.businessLink.setBackgroundDrawable(this.getResources().getDrawable(2131230951));
        this.binding.errorStoreTaken.setVisibility(8);
    }

    static /* synthetic */ int lambda$sortCountries$6(Country country, Country country2) {
        return country.getName().trim().compareToIgnoreCase(country2.getName().trim());
    }

    private void launchCameraIntent() {
        Intent intent = new Intent((Context)this, ImagePickerActivity.class);
        intent.putExtra("image_picker_option", 0);
        intent.putExtra("lock_aspect_ratio", true);
        intent.putExtra("aspect_ratio_x", 1);
        intent.putExtra("aspect_ratio_Y", 1);
        intent.putExtra("set_bitmap_max_width_height", true);
        intent.putExtra("max_width", 800);
        intent.putExtra("max_height", 800);
        this.startActivityForResult(intent, 100);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent((Context)this, ImagePickerActivity.class);
        intent.putExtra("image_picker_option", 1);
        intent.putExtra("lock_aspect_ratio", true);
        intent.putExtra("aspect_ratio_x", 1);
        intent.putExtra("aspect_ratio_Y", 1);
        this.startActivityForResult(intent, 100);
    }

    private void loadProfile(String string2) {
        GlideApp.with((FragmentActivity)this).load(string2).into((ImageView)this.binding.idProfilePic);
    }

    private void onProductImageClick() {
        Dexter.withActivity((Activity)this).withPermissions("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE").withListener((MultiplePermissionsListener)new 6(this)).check();
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

    private void setProfileImage() {
        this.loadProfile(this.fileUri.toString());
        this.showFullscreenLoader();
        Glide.with((FragmentActivity)this).asBitmap().load(this.fileUri).apply(new RequestOptions().override(800)).listener((RequestListener)new 8(this)).submit();
    }

    private void showCountyPicker(View view) {
        PopupWindow popupWindow;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n = displayMetrics.heightPixels;
        int n2 = displayMetrics.widthPixels;
        View view2 = LayoutInflater.from((Context)this).inflate(2131558602, null, false);
        this.popUp = popupWindow = new PopupWindow(view2, n2, -20 + n / 2, false);
        popupWindow.setTouchable(true);
        this.popUp.setFocusable(true);
        this.popUp.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.popUp.setElevation(8.0f);
        }
        this.popUp.showAsDropDown((View)this.binding.idEtCountryName);
        RecyclerView recyclerView = (RecyclerView)view2.findViewById(2131361984);
        EditText editText = (EditText)view2.findViewById(2131361985);
        recyclerView.setAdapter((RecyclerView.Adapter)this.countriesAdapter);
        editText.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ EditBusinessActivity this$0;
            {
                this.this$0 = editBusinessActivity;
            }

            public void afterTextChanged(Editable editable) {
                EditBusinessActivity.access$300(this.this$0, editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener(this, editText){
            final /* synthetic */ EditBusinessActivity this$0;
            final /* synthetic */ EditText val$inputCountry;
            {
                this.this$0 = editBusinessActivity;
                this.val$inputCountry = editText;
            }

            public boolean onEditorAction(TextView textView, int n, android.view.KeyEvent keyEvent) {
                android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager)this.val$inputCountry.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.val$inputCountry.getWindowToken(), 0);
                }
                return true;
            }
        });
        this.popUp.setOnDismissListener(new PopupWindow.OnDismissListener(this){
            final /* synthetic */ EditBusinessActivity this$0;
            {
                this.this$0 = editBusinessActivity;
            }

            public void onDismiss() {
                EditBusinessActivity.access$400((EditBusinessActivity)this.this$0).spinnerImg.rotate();
            }
        });
    }

    private void showEmptyBusinessNameError() {
        this.binding.errorBusinessName.setText((CharSequence)this.getString(2131951768));
        this.binding.idEtBusinessName.setBackgroundDrawable(this.getResources().getDrawable(2131230952));
        this.binding.errorBusinessName.setVisibility(0);
    }

    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions((Context)this, new 7(this));
    }

    private void showStoreUrlTakenError(boolean bl) {
        if (bl) {
            this.binding.errorStoreTaken.setText((CharSequence)this.getString(2131951769));
        } else {
            this.binding.errorStoreTaken.setText((CharSequence)this.getString(2131951778));
        }
        this.binding.businessLink.setBackgroundDrawable(this.getResources().getDrawable(2131230952));
        this.binding.errorStoreTaken.setVisibility(0);
    }

    private void sortCountries(List<Country> list) {
        Collections.sort(list, (Comparator)-$$Lambda$EditBusinessActivity$lAuXI4x_XYUzf6Xwj-rRlm9Cf0Q.INSTANCE);
    }

    private void updateBusinessDetails(String string2, boolean bl) {
        EditBusinessRequest editBusinessRequest = new EditBusinessRequest();
        String string3 = this.binding.businessLink.getText().toString().replace((CharSequence)this.getStoreBaseUrl(), (CharSequence)"");
        if (TextUtils.isEmpty((CharSequence)this.binding.idEtBusinessName.getText())) {
            this.showEmptyBusinessNameError();
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string3)) {
            this.showStoreUrlTakenError(true);
            return;
        }
        if (!this.business.realmGet$link().equals((Object)string3)) {
            editBusinessRequest.link = string3;
            this.isStoreUrlChanged = true;
        }
        editBusinessRequest.name = this.binding.idEtBusinessName.getText().toString();
        editBusinessRequest.address = this.binding.idEtInputAddress.getText().toString();
        editBusinessRequest.country = this.binding.idEtCountryName.getText().toString();
        editBusinessRequest.imageUrl = string2;
        editBusinessRequest.latitude = this.lat;
        editBusinessRequest.longitude = this.lng;
        this.showFullscreenLoader();
        this.viewModel.updateBusinessDetails(this.business.realmGet$id(), editBusinessRequest, bl);
    }

    private void validateForm() {
        if (TextUtils.isEmpty((CharSequence)this.binding.idEtBusinessName.getText())) {
            return;
        }
        if (this.selectedCountry == null) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)this.binding.idEtInputAddress.getText())) {
            return;
        }
        this.binding.btnSave.setEnabled(true);
    }

    @Override
    public int getLayoutId() {
        return 2131558432;
    }

    @Override
    public Class<EditBusinessViewModel> getViewModel() {
        return EditBusinessViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$EditBusinessActivity(View view) {
        if (this.isProfileChanged) {
            Intent intent = new Intent();
            intent.putExtra("isUpdated", true);
            this.setResult(-1, intent);
            this.finish();
            return;
        }
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$EditBusinessActivity(ActivityBusinessDetailsEditBinding activityBusinessDetailsEditBinding, View view) {
        this.showCountyPicker(view);
        activityBusinessDetailsEditBinding.spinnerImg.rotate();
    }

    public /* synthetic */ void lambda$onCreate$2$EditBusinessActivity(View view) {
        this.onProductImageClick();
    }

    public /* synthetic */ void lambda$onCreate$3$EditBusinessActivity(View view) {
        this.updateBusinessDetails(this.business.realmGet$thumbnail(), false);
    }

    public /* synthetic */ void lambda$onCreate$4$EditBusinessActivity(View view) {
        this.onProductImageClick();
    }

    public /* synthetic */ void lambda$onCreate$5$EditBusinessActivity(ActivityBusinessDetailsEditBinding activityBusinessDetailsEditBinding, View view) {
        activityBusinessDetailsEditBinding.idEtInputAddress.setClickable(false);
        this.startActivityForResult(new Intent((Context)this, AddressSelectActivity.class), 225);
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 100) {
            if (n2 == -1) {
                this.fileUri = (Uri)intent.getParcelableExtra("path");
                this.setProfileImage();
                return;
            }
        } else if (n == 225) {
            this.binding.idEtInputAddress.setClickable(true);
            if (n2 == -1) {
                if (intent == null) {
                    return;
                }
                String string2 = intent.getStringExtra("userAddress");
                this.lat = intent.getDoubleExtra("lat", 0.0);
                this.lng = intent.getDoubleExtra("lng", 0.0);
                this.binding.idEtInputAddress.setText((CharSequence)string2);
            }
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        if (errorResponse.detail != null && errorResponse.detail.errorCode == 100) {
            this.showStoreUrlTakenError(false);
        } else {
            ModalDialogs.showUnknownError((Activity)this);
        }
        this.hideFullscreenLoader();
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
            this.hideFullscreenLoader();
        }
    }

    @Override
    public void onCountrySelected(Country country) {
        this.selectedCountry = country;
        this.popUp.dismiss();
        this.binding.idEtCountryName.setText((CharSequence)country.getName());
    }

    @Override
    protected void onCreate(Bundle bundle, EditBusinessViewModel editBusinessViewModel, ActivityBusinessDetailsEditBinding activityBusinessDetailsEditBinding) {
        ArrayList arrayList;
        this.viewModel = editBusinessViewModel;
        this.binding = activityBusinessDetailsEditBinding;
        editBusinessViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityBusinessDetailsEditBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityBusinessDetailsEditBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$EditBusinessActivity$Kq0OZAPlGzZSjIkAO5LtMopQyYw(this));
        ImagePickerActivity.clearCache((Context)this);
        this.business = editBusinessViewModel.getDataManager().getBusiness();
        float f = this.getResources().getDimension(2131165394);
        activityBusinessDetailsEditBinding.idProfilePic.setShapeAppearanceModel(activityBusinessDetailsEditBinding.idProfilePic.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        GlideApp.with((FragmentActivity)this).load(this.business.realmGet$thumbnail()).placeholder(2131231329).into((ImageView)activityBusinessDetailsEditBinding.idProfilePic);
        if (this.business.realmGet$thumbnail().equals((Object)"https://dukaan-api.1kg.me/static/images/store-def.jpg")) {
            activityBusinessDetailsEditBinding.btnRemoveProfilePic.setVisibility(4);
            activityBusinessDetailsEditBinding.lblUpdateImage.setVisibility(0);
        } else {
            activityBusinessDetailsEditBinding.btnRemoveProfilePic.setVisibility(0);
            activityBusinessDetailsEditBinding.lblUpdateImage.setVisibility(4);
        }
        this.countries = new ArrayList((Collection)Arrays.asList((Object[])CountData.COUNTRIES));
        this.searchResults = arrayList = new ArrayList();
        arrayList.addAll(this.countries);
        this.countriesAdapter = new CountriesAdapter((Context)this, this.searchResults, (CountriesAdapter.OnCountrySelectedListener)new -$.Lambda.b4ZKQkHElZ-f1UkpcnmvBqDbNXg(this));
        activityBusinessDetailsEditBinding.idEtCountryName.setOnClickListener((View.OnClickListener)new -$$Lambda$EditBusinessActivity$aHVYuWF3-6EYvRU21LlP7Hdc2AY(this, activityBusinessDetailsEditBinding));
        if (this.business != null) {
            activityBusinessDetailsEditBinding.idEtBusinessName.setText((CharSequence)this.business.realmGet$name());
            AppCompatEditText appCompatEditText = activityBusinessDetailsEditBinding.businessLink;
            Object[] arrobject = new Object[]{this.getStoreBaseUrl(), this.business.realmGet$link()};
            appCompatEditText.setText((CharSequence)String.format((String)"%s%s", (Object[])arrobject));
            activityBusinessDetailsEditBinding.idEtCountryName.setText((CharSequence)this.business.realmGet$country());
            activityBusinessDetailsEditBinding.idEtInputAddress.setText((CharSequence)this.business.realmGet$address());
            this.lat = this.business.realmGet$latitude();
            this.lng = this.business.realmGet$longitude();
        }
        if (!TextUtils.isEmpty((CharSequence)AppPref.getInstance().getMobile())) {
            activityBusinessDetailsEditBinding.idEtInputMobile.setText((CharSequence)AppPref.getInstance().getMobile());
        }
        activityBusinessDetailsEditBinding.idProfilePic.setOnClickListener((View.OnClickListener)new -$$Lambda$EditBusinessActivity$6U3lxYdzMotnkNBEfZEE0smf4AY(this));
        activityBusinessDetailsEditBinding.btnSave.setOnClickListener(new -$$Lambda$EditBusinessActivity$jseTFu9u80RdWcWwjv1EdudwUos(this));
        activityBusinessDetailsEditBinding.btnRemoveProfilePic.setOnClickListener((View.OnClickListener)new -$$Lambda$EditBusinessActivity$DsnL9t33NMQ5T-rJsJ4QuWzogBY(this));
        activityBusinessDetailsEditBinding.idEtInputAddress.setOnClickListener((View.OnClickListener)new -$$Lambda$EditBusinessActivity$1IvXlX7nr-hLCwbbi-BII9z86IY(this, activityBusinessDetailsEditBinding));
        activityBusinessDetailsEditBinding.businessLink.addTextChangedListener(new TextWatcher(this, activityBusinessDetailsEditBinding){
            final /* synthetic */ EditBusinessActivity this$0;
            final /* synthetic */ ActivityBusinessDetailsEditBinding val$binding;
            {
                this.this$0 = editBusinessActivity;
                this.val$binding = activityBusinessDetailsEditBinding;
            }

            public void afterTextChanged(Editable editable) {
                if (!editable.toString().startsWith(EditBusinessActivity.access$100(this.this$0))) {
                    this.val$binding.businessLink.setText((CharSequence)EditBusinessActivity.access$100(this.this$0));
                    android.text.Selection.setSelection((android.text.Spannable)this.val$binding.businessLink.getText(), (int)this.val$binding.businessLink.getText().length());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                EditBusinessActivity.access$000(this.this$0);
            }
        });
        activityBusinessDetailsEditBinding.idEtBusinessName.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ EditBusinessActivity this$0;
            {
                this.this$0 = editBusinessActivity;
            }

            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty((CharSequence)editable.toString())) {
                    EditBusinessActivity.access$200(this.this$0);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
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

    public void updatedBusinessDetails(boolean bl) {
        this.hideFullscreenLoader();
        if (bl) {
            this.isProfileChanged = bl;
            this.business = this.viewModel.getDataManager().getBusiness();
            GlideApp.with((FragmentActivity)this).load(this.business.realmGet$thumbnail()).into((ImageView)this.binding.idProfilePic);
            if (this.business.realmGet$thumbnail().equals((Object)"https://dukaan-api.1kg.me/static/images/store-def.jpg")) {
                this.binding.btnRemoveProfilePic.setVisibility(4);
                this.binding.lblUpdateImage.setVisibility(0);
                return;
            }
            this.binding.btnRemoveProfilePic.setVisibility(0);
            this.binding.lblUpdateImage.setVisibility(4);
            return;
        }
        if (this.isStoreUrlChanged) {
            Toast.makeText((Context)this.getApplicationContext(), (int)2131951835, (int)1).show();
        }
        Intent intent = new Intent();
        intent.putExtra("isUpdated", true);
        this.setResult(-1, intent);
        this.finish();
    }

    public void uploadedImage(UploadImage uploadImage) {
        if (uploadImage.getStatus().equals((Object)"success")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://dukaan-api.1kg.me");
            stringBuilder.append(uploadImage.getData().getChildData().file);
            this.updateBusinessDetails(stringBuilder.toString(), true);
        }
    }
}

