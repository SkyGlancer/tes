/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.databinding.ActivityVerifyMobileBinding
 *  app.dukhaan.ui.verifymobile.VerifyMobileNavigator
 *  app.dukhaan.ui.verifymobile.VerifyMobileViewModel
 *  com.clevertap.android.sdk.CleverTapAPI
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 *  timber.log.Timber
 */
package app.dukhaan.ui.verifymobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityVerifyMobileBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.selectcountry.SelectCountryActivity;
import app.dukhaan.ui.verifymobile.-$$Lambda$VerifyMobileActivity$0oHOv0MdF1E4CytxDZYpVxr-rkI;
import app.dukhaan.ui.verifymobile.-$$Lambda$VerifyMobileActivity$9VF_XCFcQx_eKZSAzxxMdqBqFnI;
import app.dukhaan.ui.verifymobile.-$$Lambda$VerifyMobileActivity$pBEUuOOt7CuCNgW0o9ClKwxjIrY;
import app.dukhaan.ui.verifymobile.-$$Lambda$VerifyMobileActivity$zAaB6i0PlGoyVSHXHRVZlSX406I;
import app.dukhaan.ui.verifymobile.-$$Lambda$VerifyMobileActivity$zTu74DE-MqHiNPvQKZ2-7WbokDM;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import app.dukhaan.ui.verifymobile.VerifyMobileNavigator;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.CountData;
import com.clevertap.android.sdk.CleverTapAPI;
import java.util.Objects;
import timber.log.Timber;

public class VerifyMobileActivity
extends BaseActivity<ActivityVerifyMobileBinding, VerifyMobileViewModel>
implements VerifyMobileNavigator {
    private ActivityVerifyMobileBinding binding;
    private VerifyMobileViewModel mViewModel;
    private Country selectedCountry;

    static /* synthetic */ ActivityVerifyMobileBinding access$000(VerifyMobileActivity verifyMobileActivity) {
        return verifyMobileActivity.binding;
    }

    private void init() {
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setTitle((CharSequence)"");
            this.getSupportActionBar().setHomeAsUpIndicator(2131231220);
        }
        this.binding.idInputMobile.setOnTouchListener((View.OnTouchListener)new -$$Lambda$VerifyMobileActivity$zTu74DE-MqHiNPvQKZ2-7WbokDM(this));
        AppPref.getInstance().setCurrency("INR");
        this.binding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$VerifyMobileActivity$9VF_XCFcQx_eKZSAzxxMdqBqFnI(this));
        this.binding.idInputMobile.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ VerifyMobileActivity this$0;
            {
                this.this$0 = verifyMobileActivity;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                if (charSequence.length() >= 10) {
                    VerifyMobileActivity.access$000((VerifyMobileActivity)this.this$0).idBtnNext.setEnabled(true);
                    return;
                }
                VerifyMobileActivity.access$000((VerifyMobileActivity)this.this$0).idBtnNext.setEnabled(false);
            }
        });
        this.binding.idBtnNext.setOnClickListener(new -$$Lambda$VerifyMobileActivity$0oHOv0MdF1E4CytxDZYpVxr-rkI(this));
        this.binding.flagContainer.setOnClickListener((View.OnClickListener)new -$$Lambda$VerifyMobileActivity$pBEUuOOt7CuCNgW0o9ClKwxjIrY(this));
        this.binding.idImgCountryFlag.setOnClickListener((View.OnClickListener)new -$$Lambda$VerifyMobileActivity$zAaB6i0PlGoyVSHXHRVZlSX406I(this));
        this.setSelectedCountry("IN");
    }

    private void launchCountryPicker() {
        Intent intent = new Intent((Context)this, SelectCountryActivity.class);
        intent.putExtra("country", (Parcelable)this.selectedCountry);
        this.startActivityForResult(intent, 1);
    }

    private void setSelectedCountry(String string2) {
        Country country2;
        block3 : {
            for (Country country2 : CountData.COUNTRIES) {
                if (!country2.getCode().equalsIgnoreCase(string2)) {
                    continue;
                }
                break block3;
            }
            country2 = null;
        }
        if (country2 != null) {
            this.selectedCountry = country2;
        }
    }

    @Override
    public int getLayoutId() {
        return 2131558450;
    }

    @Override
    public Class<VerifyMobileViewModel> getViewModel() {
        return VerifyMobileViewModel.class;
    }

    public /* synthetic */ boolean lambda$init$0$VerifyMobileActivity(View view, MotionEvent motionEvent) {
        if (this.binding.idInputMobile.isFocusable()) {
            this.binding.viewMobile.setBackgroundColor(ContextCompat.getColor((Context)this, (int)2131099710));
        } else {
            this.binding.viewMobile.setBackgroundColor(ContextCompat.getColor((Context)this, (int)2131099821));
        }
        return false;
    }

    public /* synthetic */ void lambda$init$1$VerifyMobileActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$init$2$VerifyMobileActivity(View view) {
        try {
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)this))).pushEvent("OTP Requested");
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        String string2 = this.binding.idInputMobile.getText().toString();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            Toast.makeText((Context)this, (CharSequence)this.getString(2131951765), (int)0).show();
            return;
        }
        this.startActivity(new Intent((Context)this, VerifyOtpActivity.class).putExtra("countryCode", this.binding.idLblCountryCode.getText().toString()).putExtra("mobile", string2));
    }

    public /* synthetic */ void lambda$init$3$VerifyMobileActivity(View view) {
        this.launchCountryPicker();
    }

    public /* synthetic */ void lambda$init$4$VerifyMobileActivity(View view) {
        this.launchCountryPicker();
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 1 && n2 == -1) {
            String string2 = intent.getStringExtra("dialCode");
            String string3 = intent.getStringExtra("countryCode");
            int n3 = intent.getIntExtra("flag", 0);
            String string4 = intent.getStringExtra("currency");
            if (string4 != null) {
                AppPref.getInstance().setCurrency(string4);
            }
            this.binding.idLblCountryCode.setText((CharSequence)string2);
            this.binding.idImgCountryFlag.setImageResource(n3);
            this.setSelectedCountry(string3);
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    @Override
    protected void onCreate(Bundle bundle, VerifyMobileViewModel verifyMobileViewModel, ActivityVerifyMobileBinding activityVerifyMobileBinding) {
        this.mViewModel = verifyMobileViewModel;
        this.binding = activityVerifyMobileBinding;
        verifyMobileViewModel.setNavigator((Object)this);
        this.changeStatusBarColor();
        this.setSupportActionBar(activityVerifyMobileBinding.toolbar);
        this.init();
    }
}

