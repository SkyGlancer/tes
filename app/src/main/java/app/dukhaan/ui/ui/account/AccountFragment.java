package app.dukhaan.ui.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import app.dukhaan.app.GlideApp;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentAccountBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.network.model.SwipeRefreshEvent;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.network.model.AwardStatsResponse.AwardData;
import app.dukhaan.ui.account.AccountFragment.1;
import app.dukhaan.ui.account.AccountFragment.2;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.account.AccountViewNavigator;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.AppUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import com.ramijemli.percentagechartview.PercentageChartView;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.SharingHelper.SHARE_WITH;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ShareSheetStyle;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

public class AccountFragment extends BaseFragment<FragmentAccountBinding, AccountViewModel> implements AccountViewNavigator {
   private FragmentAccountBinding binding;
   private Business business;
   private FirebaseRemoteConfig mFirebaseRemoteConfig;
   private AccountViewModel mViewModel;

   public AccountFragment() {
   }

   private void init() {
      ImageView var1 = this.binding.icToggleChat;
      Context var2 = this.getContext();
      int var3;
      if (this.business.realmGet$isWhatsAppChatEnabled()) {
         var3 = ic_switch_enabled;
      } else {
         var3 = ic_switch_disabled;
      }

      var1.setImageDrawable(ContextCompat.getDrawable(var2, var3));
   }

   private void openDailer() {
      AppUtils.dialNumber(this.getContext(), this.binding.customerSupportNumber.getText().toString().replace("-", ""));
   }

   private void toggleWhatsAppChat() {
      ImageView var1 = this.binding.icToggleChat;
      Context var2 = this.getContext();
      int var3;
      if (!this.business.realmGet$isWhatsAppChatEnabled()) {
         var3 = ic_switch_enabled;
      } else {
         var3 = ic_switch_disabled;
      }

      var1.setImageDrawable(ContextCompat.getDrawable(var2, var3));
      EditBusinessRequest var4 = new EditBusinessRequest();
      var4.isWhatsAppChatSupportEnabled = this.business.realmGet$isWhatsAppChatEnabled() ^ true;
      this.mViewModel.updateBusinessDetails(this.business.realmGet$id(), var4);
   }

   public void checkForRemoteConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this.getActivity(), new _$$Lambda$AccountFragment$fKyCZYZP4SH40es4fEjw_xZ0adU(this));
   }

   public void generateBranchLink(int var1) {
      BranchUniversalObject var2 = (new BranchUniversalObject()).setCanonicalIdentifier(String.valueOf(var1));
      LinkProperties var3 = (new LinkProperties()).setChannel("Facebook").setFeature("Sharing");
      ShareSheetStyle var4 = (new ShareSheetStyle(this.requireContext(), "Get it now", "Download this amazing app and take your business online in 30 seconds!")).addPreferredSharingOption(SHARE_WITH.WHATS_APP).addPreferredSharingOption(SHARE_WITH.FACEBOOK).addPreferredSharingOption(SHARE_WITH.MESSAGE).addPreferredSharingOption(SHARE_WITH.INSTAGRAM).setAsFullWidthStyle(true).setSharingTitle("Share With");
      var2.showShareSheet(this.requireActivity(), var3, var4, new 2(this));
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
      return fragment_account;
   }

   protected Class<AccountViewModel> getViewModel() {
      return AccountViewModel.class;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 224 && var2 == -1) {
         if (var3 == null) {
            return;
         }

         if (var3.getBooleanExtra("isUpdated", false)) {
            this.refreshAccount();
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      int var2 = var1.type;
      var2 = AppEvent.INTERNET_CONNECTION_CHECK;
   }

   protected void onCreateView(Bundle var1, AccountViewModel var2, FragmentAccountBinding var3, Context var4) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.mActivity.onFragmentAttached(this);
      this.business = this.mViewModel.getDataManager().getBusiness();
      this.init();
      float var5 = this.getResources().getDimension(dp_8);
      var3.idProfilePic.setShapeAppearanceModel(var3.idProfilePic.getShapeAppearanceModel().toBuilder().setAllCorners(0, var5).build());
      GlideApp.with(this).load(this.business.realmGet$thumbnail()).placeholder(rectangle).into(var3.idProfilePic);
      var3.idAccountName.setText(this.business.realmGet$name());
      var3.icToggleChat.setOnClickListener(new _$$Lambda$AccountFragment$t_A4VzbEPPgSqn6SLu29KE_JdMo(this));
      var3.idBtnChangeLanguage.setOnClickListener(new _$$Lambda$AccountFragment$5pkIWLz0JOsxPL_HgGF6LwjBQIQ(this));
      var3.idBtnPrivacy.setOnClickListener(new _$$Lambda$AccountFragment$_2CySiurYU3d_JnbNuQJvw7rg2A(this));
      var3.idBtnDelivery.setOnClickListener(new _$$Lambda$AccountFragment$_Sm_q_TNZZnGMlfR4I_Yc1uABZo(this));
      var3.idBtnRateUs.setOnClickListener(new _$$Lambda$AccountFragment$Xh5vdEFophJTrpfseAYJwcxW5rU(this));
      var3.idBtnLogout.setOnClickListener(new _$$Lambda$AccountFragment$wfLSKf2vcnQv7JOZ71T63Ov6Iac(this));
      var3.idLinkEditBusinessDetails.setOnClickListener(new _$$Lambda$AccountFragment$XebklL_af3OG1nBncaPJLALJAz4(this));
      var3.idBtnShareApp.setOnClickListener(new _$$Lambda$AccountFragment$JBoKC4z3KSvpbHmWRJ_88_BXFs8(this));
      var3.customerSupportNumberContainer.setOnClickListener(new _$$Lambda$AccountFragment$jsvTWWBbNJB7MWB7mNXwdN9IeG4(this));
      var3.idBtnRefer.setOnClickListener(new _$$Lambda$AccountFragment$_kxj0TbjaSbBXQ5rWgu90Rp2UvM(this, var2));
      this.checkForRemoteConfig();
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onSwipeRefreshed(SwipeRefreshEvent var1) {
      if (this.isVisible()) {
         SwipeRefreshHideEvent var2 = new SwipeRefreshHideEvent();
         EventBus.getDefault().post(var2);
      }

   }

   public void onWhatsAppChatSupportError(boolean var1) {
      ImageView var2 = this.binding.icToggleChat;
      Context var3 = this.getContext();
      int var4;
      if (var1) {
         var4 = ic_switch_enabled;
      } else {
         var4 = ic_switch_disabled;
      }

      var2.setImageDrawable(ContextCompat.getDrawable(var3, var4));
   }

   public void onWhatsAppChatSupportUpdated(boolean var1) {
      this.business = this.mViewModel.getDataManager().getBusiness();
      ImageView var2 = this.binding.icToggleChat;
      Context var3 = this.getContext();
      int var4;
      if (var1) {
         var4 = ic_switch_enabled;
      } else {
         var4 = ic_switch_disabled;
      }

      var2.setImageDrawable(ContextCompat.getDrawable(var3, var4));
      Context var5 = this.getContext();
      if (var1) {
         var4 = msg_whatsapp_chat_enabled;
      } else {
         var4 = msg_whatsapp_chat_disabled;
      }

      Toast.makeText(var5, this.getString(R.string.var4), 1).show();
   }

   public void openReferDialog(List<AwardData> var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("AWARDS : ");
      var2.append(var1);
      Timber.d(var2.toString(), new Object[0]);
      if (((AwardData)var1.get(0)).unlocked) {
         this.openReferSuccessDialog();
      } else {
         String var11 = ((AwardData)var1.get(0)).name;
         String var3 = ((AwardData)var1.get(0)).description;
         int var4 = ((AwardData)var1.get(0)).referralRequired;
         int var5 = ((AwardData)var1.get(0)).progress;
         AlertDialog.Builder var6 = new AlertDialog.Builder(this.getContext());
         ViewGroup var9 = (ViewGroup)this.requireView().findViewById(16908290);
         var6.setView(LayoutInflater.from(this.getContext()).inflate(modal_refer, var9, false));
         AlertDialog var7 = var6.create();
         var7.show();
         PercentageChartView var10 = (PercentageChartView)var7.findViewById(refer_chart);
         TextView var8 = (TextView)var7.findViewById(refer_title);
         TextView var12 = (TextView)var7.findViewById(refer_desc);
         PrimaryButton var13 = (PrimaryButton)var7.findViewById(btn_invite);
         if (var8 != null && var12 != null && var13 != null && var10 != null) {
            var10.setTextFormatter(new 1(this, var5, var4));
            var10.setProgress((float)(var5 * 100 / var4), false);
            var8.setText(Html.fromHtml(var11));
            var12.setText(Html.fromHtml(var3));
            var13.setOnClickListener(new _$$Lambda$AccountFragment$UB_ARyMJ_uqdOxXcHldfB_NWULU(this));
         }

      }
   }

   public void openReferSuccessDialog() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this.getContext());
      ViewGroup var2 = (ViewGroup)this.requireView().findViewById(16908290);
      var1.setView(LayoutInflater.from(this.getContext()).inflate(modal_refer_success, var2, false));
      AlertDialog var4 = var1.create();
      var4.show();
      PrimaryButton var3 = (PrimaryButton)var4.findViewById(btn_close);
      if (var3 != null) {
         var3.setOnClickListener(new _$$Lambda$AccountFragment$xXYi3mHarWVQam9e6BNvG6OUKzY(var4));
      }

   }

   public void refreshAccount() {
      this.business = this.mViewModel.getDataManager().getBusiness();
      GlideApp.with(this).load(this.business.realmGet$thumbnail()).placeholder(rectangle).into(this.binding.idProfilePic);
      this.binding.idAccountName.setText(this.business.realmGet$name());
   }
}
