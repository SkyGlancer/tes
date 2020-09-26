package app.dukhaan.ui.ui.verifyotp;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityVerifyOtpBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.otpview.OTPListener;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity.1;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity.2;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity.3;
import app.dukhaan.ui.verifyotp.VerifyOtpNavigator;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.branch.referral.util.BranchEvent;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class VerifyOtpActivity extends BaseActivity<ActivityVerifyOtpBinding, VerifyOtpViewModel> implements OTPListener, VerifyOtpNavigator {
   public static final String TAG = VerifyOtpActivity.class.getSimpleName();
   private ActivityVerifyOtpBinding binding;
   private CountDownTimer countDownTimer;
   private String countryCode;
   private FirebaseAuth mAuth;
   private OnVerificationStateChangedCallbacks mCallbacks;
   private ForceResendingToken mResendToken;
   private VerifyOtpViewModel mViewModel;
   private String mobileNumber;
   private StringBuilder sb;
   private String verificationId;

   public VerifyOtpActivity() {
   }

   private void initFirebaseAuth() {
      this.mAuth = FirebaseAuth.getInstance();
      this.mCallbacks = new 3(this);
   }

   private void initTimer() {
      2 var1 = new 2(this, (long)Constants.OTP_RESEND_TIMER_VALUE, 1000L);
      this.countDownTimer = var1;
      var1.start();
   }

   private void initUI() {
      this.binding.otpTextView.setOtpListener(this);
      this.setSupportActionBar(this.binding.toolbar);
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         this.getSupportActionBar().setTitle("");
         this.getSupportActionBar().setHomeAsUpIndicator(ic_back_arrow_black);
      }

      this.binding.toolbar.setNavigationOnClickListener(new _$$Lambda$VerifyOtpActivity$aStiiLP_Mu_GkL2Kw1zKo_tjLKY(this));
      this.mobileNumber = this.getIntent().getStringExtra("mobile");
      this.countryCode = this.getIntent().getStringExtra("countryCode");
      String var1 = this.getResources().getString(R.string.lbl_very_otp_title, new Object[]{this.countryCode, this.mobileNumber});
      this.binding.idTitle.setText(var1);
      this.binding.otpTextView.requestFocusOTP();
      StringBuilder var2 = new StringBuilder(this.countryCode);
      this.sb = var2;
      var2.append(this.mobileNumber);
      this.binding.idBtnNext.setEnabled(false);
      this.binding.tvResend.setOnClickListener(new _$$Lambda$VerifyOtpActivity$AgSc6vEbuIS9bhIoEaw_9n7pX1g(this));
      this.binding.idBtnNext.setOnClickListener(new _$$Lambda$VerifyOtpActivity$Ah_eMfsSlQhGKlJ3USDPLbysvvM(this));
      this.mViewModel.getLoading().observe(this, new _$$Lambda$VerifyOtpActivity$IpBuJElaI3nzOvWQbV46RkwwjYs(this));
      this.initTimer();
      if (this.isNetworkAvailable()) {
         this.startPhoneNumberVerification(this.sb.toString());
      } else {
         ModalDialogs.showNoInternetDialog(this.getSupportFragmentManager(), new 1(this));
      }

   }

   private boolean isNetworkAvailable() {
      NetworkInfo var1 = ((ConnectivityManager)this.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var2;
      if (var1 != null && var1.isConnectedOrConnecting()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void resendVerificationCode(String var1, ForceResendingToken var2) {
      PhoneAuthProvider.getInstance().verifyPhoneNumber(var1, 60L, TimeUnit.SECONDS, this, this.mCallbacks, var2);
      this.showSnackBar(this.getString(R.string.msg_otp_resent));
   }

   private void setTextColor(TextView var1, String var2, String var3, int var4) {
      var1.setText(var2, BufferType.SPANNABLE);
      Spannable var6 = (Spannable)var1.getText();
      int var5 = var2.indexOf(var3);
      var6.setSpan(new ForegroundColorSpan(ContextCompat.getColor(R.color.this, var4)), var5, var3.length() + var5, 33);
   }

   private void signInWithPhoneAuthCredential(PhoneAuthCredential var1) {
      this.mAuth.signInWithCredential(var1).addOnCompleteListener(this, new _$$Lambda$VerifyOtpActivity$BB8V6bJlipDVVbk25gMLgDKIGTQ(this));
   }

   private void startPhoneNumberVerification(String var1) {
      PhoneAuthProvider.getInstance().verifyPhoneNumber(var1, 60L, TimeUnit.SECONDS, this, this.mCallbacks);
   }

   public int getLayoutId() {
      return activity_verify_otp;
   }

   public Class<VerifyOtpViewModel> getViewModel() {
      return VerifyOtpViewModel.class;
   }

   public void launchAddBusiness() {
      (new BranchEvent("OTP Verified")).addCustomDataProperty("phone", this.mobileNumber).setCustomerEventAlias("otp_verified").logEvent(this);
      CleverTapUtils.trackLogin(this, this.mobileNumber);
      Intent var1 = new Intent(this, AddBusinessActivity.class);
      var1.putExtra("countryCode", this.countryCode);
      var1.putExtra("mobile", this.mobileNumber);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   public void launchHome() {
      Business var1 = this.mViewModel.getDataManager().getBusiness();
      (new BranchEvent("OTP Verified")).addCustomDataProperty("phone", this.mobileNumber).setCustomerEventAlias("otp_verified").logEvent(this);
      CleverTapUtils.trackUser(this, var1);
      CleverTapUtils.trackLogin(this, this.mobileNumber);
      Intent var2 = new Intent(this, MainActivity.class);
      var2.putExtra("first_open", true);
      var2.setFlags(268468224);
      this.startActivity(var2);
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
      this.hideFullscreenLoader();
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && !TextUtils.isEmpty(this.sb)) {
         this.startPhoneNumberVerification(this.sb.toString());
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.onRestoreInstanceState(var1);
      }

      this.binding = (ActivityVerifyOtpBinding)DataBindingUtil.setContentView(this, activity_verify_otp);
      this.changeStatusBarColor();
      this.initFirebaseAuth();
      this.initUI();
   }

   protected void onCreate(Bundle var1, VerifyOtpViewModel var2, ActivityVerifyOtpBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
   }

   public void onInteractionListener() {
      PrimaryButton var1 = this.binding.idBtnNext;
      boolean var2;
      if (!TextUtils.isEmpty(this.binding.otpTextView.getOTP()) && this.binding.otpTextView.getOTP().length() == 6) {
         var2 = true;
      } else {
         var2 = false;
      }

      var1.setEnabled(var2);
   }

   public void onOTPComplete(String var1) {
      if (this.verificationId != null) {
         this.binding.idBtnNext.setEnabled(true);
      }

   }

   public void showSnackBar(String var1) {
      Snackbar.make(this.findViewById(16908290), var1, 0).show();
   }

   public void verifyOtpManually(String var1) {
      if (TextUtils.isEmpty(this.binding.otpTextView.getOTP())) {
         this.showSnackBar(this.getString(R.string.msg_enter_otp));
      } else if (var1 != null) {
         this.mViewModel.setIsLoading(true);

         try {
            this.signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential(var1, this.binding.otpTextView.getOTP()));
         } catch (Exception var2) {
            ModalDialogs.showUnknownError(this);
            FirebaseCrashlytics.getInstance().recordException(var2);
         }

      }
   }
}
