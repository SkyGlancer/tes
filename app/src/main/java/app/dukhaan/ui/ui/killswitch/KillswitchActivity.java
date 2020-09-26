package app.dukhaan.ui.ui.killswitch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.app.GlideApp;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityKillswitchBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.BottomSheetSelectLanguage.OnLanguageSelectListener;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import java.util.HashMap;
import timber.log.Timber;

public class KillswitchActivity extends BaseActivity<ActivityKillswitchBinding, AccountViewModel> implements OnLanguageSelectListener {
   private ActivityKillswitchBinding binding;
   private FirebaseRemoteConfig mFirebaseRemoteConfig;

   public KillswitchActivity() {
   }

   private void updateRemoteDetails(HashMap<String, String> var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("REMOTE CONFIG: ");
      var2.append(var1.toString());
      Timber.d(var2.toString(), new Object[0]);
      ImageView var3 = (ImageView)this.findViewById(id_banner_killswitch);
      TextView var6 = (TextView)this.findViewById(id_title_killswitch);
      TextView var4 = (TextView)this.findViewById(id_desc_killswitch);
      Button var5 = (Button)this.findViewById(id_btn_killswitch);
      Timber.d("REMOTE CONFIG : Banner => %s", new Object[]{Uri.parse((String)var1.get("banner"))});
      GlideApp.with(this).load((String)var1.get("banner")).into(var3);
      var6.setText((CharSequence)var1.get("title"));
      var4.setText((CharSequence)var1.get("desc"));
      var5.setText((CharSequence)var1.get("btnText"));
      var5.setOnClickListener(new _$$Lambda$KillswitchActivity$HCwp62DCH38obLpBKs1Sny27h70(this, var1));
   }

   public void checkForRemoteConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this, new _$$Lambda$KillswitchActivity$39R9rbTRi425_gg2rUa9pZzGw9k(this)).addOnFailureListener(_$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38.INSTANCE);
   }

   public FirebaseRemoteConfig getFirebaseRemoteConfig() {
      if (this.mFirebaseRemoteConfig == null) {
         this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
         FirebaseRemoteConfigSettings var1 = (new Builder()).setMinimumFetchIntervalInSeconds(5L).build();
         this.mFirebaseRemoteConfig.setConfigSettingsAsync(var1);
      }

      return this.mFirebaseRemoteConfig;
   }

   public int getLayoutId() {
      return activity_killswitch;
   }

   public Class<AccountViewModel> getViewModel() {
      return AccountViewModel.class;
   }

   protected void onCreate(Bundle var1, AccountViewModel var2, ActivityKillswitchBinding var3) {
      this.binding = var3;
      Window var8 = this.getWindow();
      LayoutParams var5 = var8.getAttributes();
      var5.flags &= -67108865;
      var8.setAttributes(var5);
      if (VERSION.SDK_INT >= 23) {
         var8.getDecorView().setSystemUiVisibility(9472);
      }

      ActivityKillswitchBinding var6 = (ActivityKillswitchBinding)DataBindingUtil.setContentView(this, activity_killswitch);

      try {
         this.checkForRemoteConfig();
      } catch (Exception var4) {
         HashMap var7 = new HashMap();
         var7.put("title", "Install New App");
         var7.put("desc", "We have migrated to a new address now. Don't worry. Your stores are perfectly safe. Simply login with the same number on the new app to recover your app.");
         var7.put("banner", "https://dukaan-api.1kg.me/static/images/store-def.jpg");
         var7.put("btnText", "Download Now");
         var7.put("btnLink", "https://mydukaan.io");
         this.updateRemoteDetails(var7);
      }

   }

   public void onLanguageSelected(String var1) {
      AppPref.getInstance().setLocale(var1);
      this.updateBaseContextLocale(this);
      this.startActivity(new Intent(this, VerifyMobileActivity.class));
   }
}
