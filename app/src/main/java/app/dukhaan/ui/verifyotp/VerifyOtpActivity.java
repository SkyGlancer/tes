/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Bundle
 *  android.os.CountDownTimer
 *  android.text.Spannable
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentManager
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityVerifyOtpBinding
 *  app.dukhaan.ui.verifyotp.-$
 *  app.dukhaan.ui.verifyotp.-$$Lambda
 *  app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity
 *  app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity$BB8V6bJlipDVVbk25gMLgDKIGTQ
 *  app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity$IpBuJElaI3nzOvWQbV46RkwwjYs
 *  app.dukhaan.ui.verifyotp.VerifyOtpActivity$1
 *  app.dukhaan.ui.verifyotp.VerifyOtpActivity$3
 *  app.dukhaan.ui.verifyotp.VerifyOtpActivity$4
 *  app.dukhaan.ui.verifyotp.VerifyOtpNavigator
 *  app.dukhaan.ui.verifyotp.VerifyOtpViewModel
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.material.snackbar.Snackbar
 *  com.google.firebase.FirebaseNetworkException
 *  com.google.firebase.auth.AuthCredential
 *  com.google.firebase.auth.AuthResult
 *  com.google.firebase.auth.FirebaseAuth
 *  com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
 *  com.google.firebase.auth.FirebaseUser
 *  com.google.firebase.auth.PhoneAuthCredential
 *  com.google.firebase.auth.PhoneAuthProvider
 *  com.google.firebase.auth.PhoneAuthProvider$ForceResendingToken
 *  com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks
 *  com.google.firebase.crashlytics.FirebaseCrashlytics
 *  io.branch.referral.util.BranchEvent
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 *  timber.log.Timber
 */
package app.dukhaan.ui.verifyotp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityVerifyOtpBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.otpview.OTPListener;
import app.dukhaan.otpview.OtpTextView;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.verifyotp.-$;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity$AgSc6vEbuIS9bhIoEaw_9n7pX1g;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity$Ah-eMfsSlQhGKlJ3USDPLbysvvM;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpActivity$aStiiLP-Mu_GkL2Kw1zKo_tjLKY;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import app.dukhaan.ui.verifyotp.VerifyOtpNavigator;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.branch.referral.util.BranchEvent;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

public class VerifyOtpActivity
extends BaseActivity<ActivityVerifyOtpBinding, VerifyOtpViewModel>
implements OTPListener,
VerifyOtpNavigator {
    public static final String TAG = VerifyOtpActivity.class.getSimpleName();
    private ActivityVerifyOtpBinding binding;
    private CountDownTimer countDownTimer;
    private String countryCode;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private VerifyOtpViewModel mViewModel;
    private String mobileNumber;
    private StringBuilder sb;
    private String verificationId;

    static /* synthetic */ ActivityVerifyOtpBinding access$000(VerifyOtpActivity verifyOtpActivity) {
        return verifyOtpActivity.binding;
    }

    static /* synthetic */ void access$100(VerifyOtpActivity verifyOtpActivity, TextView textView, String string2, String string3, int n) {
        verifyOtpActivity.setTextColor(textView, string2, string3, n);
    }

    static /* synthetic */ void access$200(VerifyOtpActivity verifyOtpActivity, PhoneAuthCredential phoneAuthCredential) {
        verifyOtpActivity.signInWithPhoneAuthCredential(phoneAuthCredential);
    }

    static /* synthetic */ String access$302(VerifyOtpActivity verifyOtpActivity, String string2) {
        verifyOtpActivity.verificationId = string2;
        return string2;
    }

    static /* synthetic */ PhoneAuthProvider.ForceResendingToken access$402(VerifyOtpActivity verifyOtpActivity, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        verifyOtpActivity.mResendToken = forceResendingToken;
        return forceResendingToken;
    }

    static /* synthetic */ String access$500(VerifyOtpActivity verifyOtpActivity) {
        return verifyOtpActivity.countryCode;
    }

    static /* synthetic */ String access$600(VerifyOtpActivity verifyOtpActivity) {
        return verifyOtpActivity.mobileNumber;
    }

    static /* synthetic */ VerifyOtpViewModel access$700(VerifyOtpActivity verifyOtpActivity) {
        return verifyOtpActivity.mViewModel;
    }

    private void initFirebaseAuth() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mCallbacks = new 3(this);
    }

    private void initTimer() {
        CountDownTimer countDownTimer;
        this.countDownTimer = countDownTimer = new CountDownTimer(this, Constants.OTP_RESEND_TIMER_VALUE, 1000L){
            final /* synthetic */ VerifyOtpActivity this$0;
            {
                this.this$0 = verifyOtpActivity;
                super(l, l2);
            }

            public void onFinish() {
                VerifyOtpActivity.access$000((VerifyOtpActivity)this.this$0).tvResend.setClickable(true);
                VerifyOtpActivity.access$000((VerifyOtpActivity)this.this$0).tvResend.setTextColor(ContextCompat.getColor((Context)this.this$0, (int)2131099728));
                VerifyOtpActivity.access$000((VerifyOtpActivity)this.this$0).tvResend.setText((CharSequence)this.this$0.getResources().getString(2131952003));
            }

            public void onTick(long l) {
                VerifyOtpActivity.access$000((VerifyOtpActivity)this.this$0).tvResend.setClickable(false);
                String string2 = this.this$0.getResources().getString(2131951922);
                Object[] arrobject = new Object[]{l / 1000L};
                String string3 = String.format((String)string2, (Object[])arrobject);
                VerifyOtpActivity.access$000((VerifyOtpActivity)this.this$0).tvResend.setTextColor(ContextCompat.getColor((Context)this.this$0, (int)2131099711));
                VerifyOtpActivity verifyOtpActivity = this.this$0;
                VerifyOtpActivity.access$100(verifyOtpActivity, VerifyOtpActivity.access$000((VerifyOtpActivity)verifyOtpActivity).tvResend, string3, string3.substring(0, 14), 2131099932);
            }
        };
        countDownTimer.start();
    }

    private void initUI() {
        StringBuilder stringBuilder;
        this.binding.otpTextView.setOtpListener(this);
        this.setSupportActionBar(this.binding.toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setTitle((CharSequence)"");
            this.getSupportActionBar().setHomeAsUpIndicator(2131231220);
        }
        this.binding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$VerifyOtpActivity$aStiiLP-Mu_GkL2Kw1zKo_tjLKY(this));
        this.mobileNumber = this.getIntent().getStringExtra("mobile");
        this.countryCode = this.getIntent().getStringExtra("countryCode");
        Resources resources = this.getResources();
        Object[] arrobject = new Object[]{this.countryCode, this.mobileNumber};
        String string2 = resources.getString(2131951822, arrobject);
        this.binding.idTitle.setText((CharSequence)string2);
        this.binding.otpTextView.requestFocusOTP();
        this.sb = stringBuilder = new StringBuilder(this.countryCode);
        stringBuilder.append(this.mobileNumber);
        this.binding.idBtnNext.setEnabled(false);
        this.binding.tvResend.setOnClickListener((View.OnClickListener)new -$$Lambda$VerifyOtpActivity$AgSc6vEbuIS9bhIoEaw_9n7pX1g(this));
        this.binding.idBtnNext.setOnClickListener(new -$$Lambda$VerifyOtpActivity$Ah-eMfsSlQhGKlJ3USDPLbysvvM(this));
        this.mViewModel.getLoading().observe((LifecycleOwner)this, (Observer)new -$.Lambda.VerifyOtpActivity.IpBuJElaI3nzOvWQbV46RkwwjYs(this));
        this.initTimer();
        if (this.isNetworkAvailable()) {
            this.startPhoneNumberVerification(this.sb.toString());
            return;
        }
        ModalDialogs.showNoInternetDialog(this.getSupportFragmentManager(), new 1(this));
    }

    private boolean isNetworkAvailable() {
        NetworkInfo networkInfo = ((ConnectivityManager)this.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    private void resendVerificationCode(String string2, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(string2, 60L, TimeUnit.SECONDS, (Activity)this, this.mCallbacks, forceResendingToken);
        this.showSnackBar(this.getString(2131951833));
    }

    private void setTextColor(TextView textView, String string2, String string3, int n) {
        textView.setText((CharSequence)string2, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable)textView.getText();
        int n2 = string2.indexOf(string3);
        spannable.setSpan((Object)new ForegroundColorSpan(ContextCompat.getColor((Context)this, (int)n)), n2, n2 + string3.length(), 33);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        this.mAuth.signInWithCredential((AuthCredential)phoneAuthCredential).addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.VerifyOtpActivity.BB8V6bJlipDVVbk25gMLgDKIGTQ(this));
    }

    private void startPhoneNumberVerification(String string2) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(string2, 60L, TimeUnit.SECONDS, (Activity)this, this.mCallbacks);
    }

    @Override
    public int getLayoutId() {
        return 2131558451;
    }

    @Override
    public Class<VerifyOtpViewModel> getViewModel() {
        return VerifyOtpViewModel.class;
    }

    public /* synthetic */ void lambda$initUI$0$VerifyOtpActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$initUI$1$VerifyOtpActivity(View view) {
        if (this.mResendToken != null) {
            this.countDownTimer.start();
            this.resendVerificationCode(this.sb.toString(), this.mResendToken);
        }
    }

    public /* synthetic */ void lambda$initUI$2$VerifyOtpActivity(View view) {
        this.verifyOtpManually(this.verificationId);
    }

    public /* synthetic */ void lambda$initUI$3$VerifyOtpActivity(Boolean bl) {
        if (bl.booleanValue()) {
            this.showFullscreenLoader();
            return;
        }
        this.hideFullscreenLoader();
    }

    public /* synthetic */ void lambda$signInWithPhoneAuthCredential$4$VerifyOtpActivity(Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            ((AuthResult)task.getResult()).getUser().getIdToken(false).addOnCompleteListener((OnCompleteListener)new 4(this));
            return;
        }
        Timber.tag((String)TAG).w((Throwable)task.getException(), "signInWithCredential:failure", new Object[0]);
        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
            this.showSnackBar(this.getString(2131951803));
        } else if (task.getException() instanceof FirebaseNetworkException) {
            this.showSnackBar(this.getString(2131951725));
        } else {
            this.showSnackBar(this.getString(2131952011));
        }
        this.mViewModel.setIsLoading(false);
    }

    public void launchAddBusiness() {
        new BranchEvent("OTP Verified").addCustomDataProperty("phone", this.mobileNumber).setCustomerEventAlias("otp_verified").logEvent((Context)this);
        CleverTapUtils.trackLogin((Context)this, this.mobileNumber);
        Intent intent = new Intent((Context)this, AddBusinessActivity.class);
        intent.putExtra("countryCode", this.countryCode);
        intent.putExtra("mobile", this.mobileNumber);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    public void launchHome() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        new BranchEvent("OTP Verified").addCustomDataProperty("phone", this.mobileNumber).setCustomerEventAlias("otp_verified").logEvent((Context)this);
        CleverTapUtils.trackUser((Context)this, business);
        CleverTapUtils.trackLogin((Context)this, this.mobileNumber);
        Intent intent = new Intent((Context)this, MainActivity.class);
        intent.putExtra("first_open", true);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
        this.hideFullscreenLoader();
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && !TextUtils.isEmpty((CharSequence)this.sb)) {
            this.startPhoneNumberVerification(this.sb.toString());
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.onRestoreInstanceState(bundle);
        }
        this.binding = (ActivityVerifyOtpBinding)DataBindingUtil.setContentView((Activity)this, (int)2131558451);
        this.changeStatusBarColor();
        this.initFirebaseAuth();
        this.initUI();
    }

    @Override
    protected void onCreate(Bundle bundle, VerifyOtpViewModel verifyOtpViewModel, ActivityVerifyOtpBinding activityVerifyOtpBinding) {
        this.mViewModel = verifyOtpViewModel;
        this.binding = activityVerifyOtpBinding;
        verifyOtpViewModel.setNavigator((Object)this);
    }

    @Override
    public void onInteractionListener() {
        PrimaryButton primaryButton = this.binding.idBtnNext;
        boolean bl = !TextUtils.isEmpty((CharSequence)this.binding.otpTextView.getOTP()) && this.binding.otpTextView.getOTP().length() == 6;
        primaryButton.setEnabled(bl);
    }

    @Override
    public void onOTPComplete(String string2) {
        if (this.verificationId != null) {
            this.binding.idBtnNext.setEnabled(true);
        }
    }

    public void showSnackBar(String string2) {
        Snackbar.make((View)this.findViewById(16908290), (CharSequence)string2, (int)0).show();
    }

    public void verifyOtpManually(String string2) {
        if (TextUtils.isEmpty((CharSequence)this.binding.otpTextView.getOTP())) {
            this.showSnackBar(this.getString(2131951831));
            return;
        }
        if (string2 == null) {
            return;
        }
        this.mViewModel.setIsLoading(true);
        try {
            this.signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential((String)string2, (String)this.binding.otpTextView.getOTP()));
            return;
        }
        catch (Exception exception) {
            ModalDialogs.showUnknownError((Activity)this);
            FirebaseCrashlytics.getInstance().recordException((Throwable)exception);
            return;
        }
    }
}

