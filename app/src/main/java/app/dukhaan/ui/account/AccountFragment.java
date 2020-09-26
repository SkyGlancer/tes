/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.ui.account.-$
 *  app.dukhaan.ui.account.-$$Lambda
 *  app.dukhaan.ui.account.-$$Lambda$AccountFragment
 *  app.dukhaan.ui.account.-$$Lambda$AccountFragment$fKyCZYZP4SH40es4fEjw_xZ0adU
 *  app.dukhaan.ui.account.AccountFragment$1
 *  app.dukhaan.ui.account.AccountFragment$2
 *  app.dukhaan.ui.account.AccountViewModel
 *  app.dukhaan.ui.account.AccountViewNavigator
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  com.ramijemli.percentagechartview.PercentageChartView
 *  io.branch.indexing.BranchUniversalObject
 *  io.branch.referral.Branch
 *  io.branch.referral.Branch$BranchLinkShareListener
 *  io.branch.referral.SharingHelper
 *  io.branch.referral.SharingHelper$SHARE_WITH
 *  io.branch.referral.util.LinkProperties
 *  io.branch.referral.util.ShareSheetStyle
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Objects
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 *  timber.log.Timber
 */
package app.dukhaan.ui.account;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentAccountBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.AwardStatsResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.network.model.SwipeRefreshEvent;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.account.-$;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$-kxj0TbjaSbBXQ5rWgu90Rp2UvM;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$5pkIWLz0JOsxPL-HgGF6LwjBQIQ;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$JBoKC4z3KSvpbHmWRJ-88-BXFs8;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$UB_ARyMJ-uqdOxXcHldfB_NWULU;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$XebklL_af3OG1nBncaPJLALJAz4;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$Xh5vdEFophJTrpfseAYJwcxW5rU;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$_2CySiurYU3d-JnbNuQJvw7rg2A;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$_Sm-q-TNZZnGMlfR4I-Yc1uABZo;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$jsvTWWBbNJB7MWB7mNXwdN9IeG4;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$t_A4VzbEPPgSqn6SLu29KE_JdMo;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$wfLSKf2vcnQv7JOZ71T63Ov6Iac;
import app.dukhaan.ui.account.-$$Lambda$AccountFragment$xXYi3mHarWVQam9e6BNvG6OUKzY;
import app.dukhaan.ui.account.AccountFragment;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.account.AccountViewNavigator;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.AppUtils;
import com.bumptech.glide.request.target.ViewTarget;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.ramijemli.percentagechartview.PercentageChartView;
import com.ramijemli.percentagechartview.callback.ProgressTextFormatter;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.SharingHelper;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ShareSheetStyle;
import java.util.List;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

public class AccountFragment
extends BaseFragment<FragmentAccountBinding, AccountViewModel>
implements AccountViewNavigator {
    private FragmentAccountBinding binding;
    private Business business;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private AccountViewModel mViewModel;

    private void init() {
        ImageView imageView = this.binding.icToggleChat;
        Context context = this.getContext();
        int n = this.business.realmGet$isWhatsAppChatEnabled() ? 2131231278 : 2131231277;
        imageView.setImageDrawable(ContextCompat.getDrawable((Context)context, (int)n));
    }

    static /* synthetic */ void lambda$openReferSuccessDialog$12(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
    }

    private void openDailer() {
        AppUtils.dialNumber(this.getContext(), this.binding.customerSupportNumber.getText().toString().replace((CharSequence)"-", (CharSequence)""));
    }

    private void toggleWhatsAppChat() {
        ImageView imageView = this.binding.icToggleChat;
        Context context = this.getContext();
        int n = !this.business.realmGet$isWhatsAppChatEnabled() ? 2131231278 : 2131231277;
        imageView.setImageDrawable(ContextCompat.getDrawable((Context)context, (int)n));
        EditBusinessRequest editBusinessRequest = new EditBusinessRequest();
        editBusinessRequest.isWhatsAppChatSupportEnabled = true ^ this.business.realmGet$isWhatsAppChatEnabled();
        this.mViewModel.updateBusinessDetails(this.business.realmGet$id(), editBusinessRequest);
    }

    public void checkForRemoteConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this.getActivity(), (OnCompleteListener)new -$.Lambda.AccountFragment.fKyCZYZP4SH40es4fEjw_xZ0adU(this));
    }

    public void generateBranchLink(int n) {
        BranchUniversalObject branchUniversalObject = new BranchUniversalObject().setCanonicalIdentifier(String.valueOf((int)n));
        LinkProperties linkProperties = new LinkProperties().setChannel("Facebook").setFeature("Sharing");
        ShareSheetStyle shareSheetStyle = new ShareSheetStyle(this.requireContext(), "Get it now", "Download this amazing app and take your business online in 30 seconds!").addPreferredSharingOption(SharingHelper.SHARE_WITH.WHATS_APP).addPreferredSharingOption(SharingHelper.SHARE_WITH.FACEBOOK).addPreferredSharingOption(SharingHelper.SHARE_WITH.MESSAGE).addPreferredSharingOption(SharingHelper.SHARE_WITH.INSTAGRAM).setAsFullWidthStyle(true).setSharingTitle("Share With");
        branchUniversalObject.showShareSheet((Activity)this.requireActivity(), linkProperties, shareSheetStyle, (Branch.BranchLinkShareListener)new 2(this));
    }

    public FirebaseRemoteConfig getFirebaseRemoteConfig() {
        if (this.mFirebaseRemoteConfig == null) {
            this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(5L).build();
            this.mFirebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings);
        }
        return this.mFirebaseRemoteConfig;
    }

    public int getLayoutId() {
        return 2131558496;
    }

    protected Class<AccountViewModel> getViewModel() {
        return AccountViewModel.class;
    }

    public /* synthetic */ void lambda$checkForRemoteConfig$10$AccountFragment(Task task) {
        if (task.isSuccessful()) {
            String string2 = this.getFirebaseRemoteConfig().getString("customer_contact");
            Boolean bl = this.getFirebaseRemoteConfig().getBoolean("referral_enabled");
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                this.binding.customerSupportNumber.setText((CharSequence)string2);
            }
            if (bl.booleanValue()) {
                this.binding.idBtnRefer.setVisibility(0);
            }
        }
    }

    public /* synthetic */ void lambda$onCreateView$0$AccountFragment(View view) {
        this.toggleWhatsAppChat();
    }

    public /* synthetic */ void lambda$onCreateView$1$AccountFragment(View view) {
        this.startActivity(new Intent((Context)this.getActivity(), ChangeLanguageActivity.class));
    }

    public /* synthetic */ void lambda$onCreateView$2$AccountFragment(View view) {
        this.startActivity(new Intent((Context)this.getActivity(), PrivacyPolicyActivity.class));
    }

    public /* synthetic */ void lambda$onCreateView$3$AccountFragment(View view) {
        this.startActivity(new Intent((Context)this.getActivity(), DeliveryChargesActivity.class));
    }

    public /* synthetic */ void lambda$onCreateView$4$AccountFragment(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("market://details?id=");
        stringBuilder.append(this.getActivity().getPackageName());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)stringBuilder.toString()));
        try {
            this.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            Toast.makeText((Context)this.getActivity(), (CharSequence)" unable to find market app", (int)1).show();
            return;
        }
    }

    public /* synthetic */ void lambda$onCreateView$5$AccountFragment(View view) {
        if (this.getActivity() instanceof BaseActivity) {
            ((BaseActivity)this.getActivity()).logout();
        }
    }

    public /* synthetic */ void lambda$onCreateView$6$AccountFragment(View view) {
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditBusinessActivity.class), 224);
    }

    public /* synthetic */ void lambda$onCreateView$7$AccountFragment(View view) {
        AppUtils.shareApp(this.getContext(), AppUtils.getStoreLink(this.business.realmGet$link()));
    }

    public /* synthetic */ void lambda$onCreateView$8$AccountFragment(View view) {
        this.openDailer();
    }

    public /* synthetic */ void lambda$onCreateView$9$AccountFragment(AccountViewModel accountViewModel, View view) {
        try {
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)this.getContext()))).pushEvent("Refer Menu Click");
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        accountViewModel.getAwardsStats();
    }

    public /* synthetic */ void lambda$openReferDialog$11$AccountFragment(View view) {
        try {
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)this.getContext()))).pushEvent("Refer Button Click");
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
        }
        this.generateBranchLink(this.business.realmGet$accountId());
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        if (n == 224 && n2 == -1) {
            if (intent == null) {
                return;
            }
            if (intent.getBooleanExtra("isUpdated", false)) {
                this.refreshAccount();
            }
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
    }

    protected void onCreateView(Bundle bundle, AccountViewModel accountViewModel, FragmentAccountBinding fragmentAccountBinding, Context context) {
        this.binding = fragmentAccountBinding;
        this.mViewModel = accountViewModel;
        accountViewModel.setNavigator((Object)this);
        this.mActivity.onFragmentAttached((Object)this);
        this.business = this.mViewModel.getDataManager().getBusiness();
        this.init();
        float f = this.getResources().getDimension(2131165448);
        fragmentAccountBinding.idProfilePic.setShapeAppearanceModel(fragmentAccountBinding.idProfilePic.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        GlideApp.with((Fragment)this).load(this.business.realmGet$thumbnail()).placeholder(2131231329).into((ImageView)fragmentAccountBinding.idProfilePic);
        fragmentAccountBinding.idAccountName.setText((CharSequence)this.business.realmGet$name());
        fragmentAccountBinding.icToggleChat.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$t_A4VzbEPPgSqn6SLu29KE_JdMo(this));
        fragmentAccountBinding.idBtnChangeLanguage.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$5pkIWLz0JOsxPL-HgGF6LwjBQIQ(this));
        fragmentAccountBinding.idBtnPrivacy.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$_2CySiurYU3d-JnbNuQJvw7rg2A(this));
        fragmentAccountBinding.idBtnDelivery.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$_Sm-q-TNZZnGMlfR4I-Yc1uABZo(this));
        fragmentAccountBinding.idBtnRateUs.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$Xh5vdEFophJTrpfseAYJwcxW5rU(this));
        fragmentAccountBinding.idBtnLogout.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$wfLSKf2vcnQv7JOZ71T63Ov6Iac(this));
        fragmentAccountBinding.idLinkEditBusinessDetails.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$XebklL_af3OG1nBncaPJLALJAz4(this));
        fragmentAccountBinding.idBtnShareApp.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$JBoKC4z3KSvpbHmWRJ-88-BXFs8(this));
        fragmentAccountBinding.customerSupportNumberContainer.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$jsvTWWBbNJB7MWB7mNXwdN9IeG4(this));
        fragmentAccountBinding.idBtnRefer.setOnClickListener((View.OnClickListener)new -$$Lambda$AccountFragment$-kxj0TbjaSbBXQ5rWgu90Rp2UvM(this, accountViewModel));
        this.checkForRemoteConfig();
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onSwipeRefreshed(SwipeRefreshEvent swipeRefreshEvent) {
        if (this.isVisible()) {
            SwipeRefreshHideEvent swipeRefreshHideEvent = new SwipeRefreshHideEvent();
            EventBus.getDefault().post((Object)swipeRefreshHideEvent);
        }
    }

    public void onWhatsAppChatSupportError(boolean bl) {
        ImageView imageView = this.binding.icToggleChat;
        Context context = this.getContext();
        int n = bl ? 2131231278 : 2131231277;
        imageView.setImageDrawable(ContextCompat.getDrawable((Context)context, (int)n));
    }

    public void onWhatsAppChatSupportUpdated(boolean bl) {
        this.business = this.mViewModel.getDataManager().getBusiness();
        ImageView imageView = this.binding.icToggleChat;
        Context context = this.getContext();
        int n = bl ? 2131231278 : 2131231277;
        imageView.setImageDrawable(ContextCompat.getDrawable((Context)context, (int)n));
        Context context2 = this.getContext();
        int n2 = bl ? 2131951837 : 2131951836;
        Toast.makeText((Context)context2, (CharSequence)this.getString(n2), (int)1).show();
    }

    public void openReferDialog(List<AwardStatsResponse.AwardData> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AWARDS : ");
        stringBuilder.append(list);
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (((AwardStatsResponse.AwardData)list.get((int)0)).unlocked.booleanValue()) {
            this.openReferSuccessDialog();
            return;
        }
        String string2 = ((AwardStatsResponse.AwardData)list.get((int)0)).name;
        String string3 = ((AwardStatsResponse.AwardData)list.get((int)0)).description;
        int n = ((AwardStatsResponse.AwardData)list.get((int)0)).referralRequired;
        int n2 = ((AwardStatsResponse.AwardData)list.get((int)0)).progress;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        ViewGroup viewGroup = (ViewGroup)this.requireView().findViewById(16908290);
        builder.setView(LayoutInflater.from((Context)this.getContext()).inflate(2131558553, viewGroup, false));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        PercentageChartView percentageChartView = (PercentageChartView)alertDialog.findViewById(2131362418);
        TextView textView = (TextView)alertDialog.findViewById(2131362420);
        TextView textView2 = (TextView)alertDialog.findViewById(2131362419);
        PrimaryButton primaryButton = (PrimaryButton)alertDialog.findViewById(2131361920);
        if (textView != null && textView2 != null && primaryButton != null) {
            if (percentageChartView == null) {
                return;
            }
            percentageChartView.setTextFormatter((ProgressTextFormatter)new 1(this, n2, n));
            percentageChartView.setProgress((float)(n2 * 100 / n), false);
            textView.setText((CharSequence)Html.fromHtml((String)string2));
            textView2.setText((CharSequence)Html.fromHtml((String)string3));
            primaryButton.setOnClickListener(new -$$Lambda$AccountFragment$UB_ARyMJ-uqdOxXcHldfB_NWULU(this));
        }
    }

    public void openReferSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        ViewGroup viewGroup = (ViewGroup)this.requireView().findViewById(16908290);
        builder.setView(LayoutInflater.from((Context)this.getContext()).inflate(2131558554, viewGroup, false));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        PrimaryButton primaryButton = (PrimaryButton)alertDialog.findViewById(2131361918);
        if (primaryButton != null) {
            primaryButton.setOnClickListener(new -$$Lambda$AccountFragment$xXYi3mHarWVQam9e6BNvG6OUKzY(alertDialog));
        }
    }

    public void refreshAccount() {
        this.business = this.mViewModel.getDataManager().getBusiness();
        GlideApp.with((Fragment)this).load(this.business.realmGet$thumbnail()).placeholder(2131231329).into((ImageView)this.binding.idProfilePic);
        this.binding.idAccountName.setText((CharSequence)this.business.realmGet$name());
    }
}

