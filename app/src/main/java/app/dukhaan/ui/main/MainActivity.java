/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.TextView
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBar$LayoutParams
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.navigation.NavController
 *  androidx.navigation.NavController$OnDestinationChangedListener
 *  androidx.navigation.NavDestination
 *  androidx.navigation.Navigation
 *  androidx.navigation.ui.AppBarConfiguration
 *  androidx.navigation.ui.AppBarConfiguration$Builder
 *  androidx.navigation.ui.NavigationUI
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.BusinessStats
 *  app.dukhaan.databinding.ActivityMainBinding
 *  app.dukhaan.ui.main.-$
 *  app.dukhaan.ui.main.-$$Lambda
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity$5BddtUaKxItpvAiupZIhyApD6Ic
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity$8YMg7eQo_y4GUN9lTujYjcyNH0w
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity$Bz0poczlkGJ6YRjNU8kGnNHwvj4
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity$IvV-lCtjXTkwhdc9hXL3ypery8k
 *  app.dukhaan.ui.main.-$$Lambda$MainActivity$KqzuhpzhusklS1_G5tPHSB7jdog
 *  app.dukhaan.ui.main.MainActivityNavigator
 *  app.dukhaan.ui.main.MainActivityViewModel
 *  com.clevertap.android.sdk.CTPushNotificationListener
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.facebook.appevents.AppEventsLogger
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.badge.BadgeDrawable
 *  com.google.android.material.bottomnavigation.BottomNavigationView
 *  com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener
 *  com.google.android.material.snackbar.Snackbar
 *  com.google.android.play.core.appupdate.AppUpdateInfo
 *  com.google.android.play.core.appupdate.AppUpdateManager
 *  com.google.android.play.core.tasks.OnSuccessListener
 *  com.google.android.play.core.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Objects
 *  javax.inject.Inject
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 *  timber.log.Timber
 */
package app.dukhaan.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.databinding.ActivityMainBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.main.-$;
import app.dukhaan.ui.main.-$$Lambda$MainActivity$AKSbd7Ucl_XGTA8FMx7huwKYxnw;
import app.dukhaan.ui.main.-$$Lambda$MainActivity$XeDGLwDpGGA2tgTpGmRcJJDdncE;
import app.dukhaan.ui.main.-$$Lambda$MainActivity$YDjVZ_l5rV8o-_k60lDiigjwTZA;
import app.dukhaan.ui.main.-$$Lambda$MainActivity$oHU9X4VbiX9E6qtKXDvufMaWEu4;
import app.dukhaan.ui.main.-$$Lambda$MainActivity$s7QzSe-a0MSlUQg9-gP5UGpZD9g;
import app.dukhaan.ui.main.MainActivityNavigator;
import app.dukhaan.ui.main.MainActivityViewModel;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.orders.OrdersFragment;
import app.dukhaan.util.AppUpdateUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import app.dukhaan.util.NotificationsUtils;
import com.clevertap.android.sdk.CTPushNotificationListener;
import com.clevertap.android.sdk.CleverTapAPI;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

public class MainActivity
extends BaseActivity<ActivityMainBinding, MainActivityViewModel>
implements MainActivityNavigator,
CTPushNotificationListener,
AppUpdateUtils.AppUpdateUtilsListener,
OnSuccessListener<AppUpdateInfo> {
    private static final int REQUEST_CODE_APP_UPDATE = 404;
    @Inject
    AppUpdateManager appUpdateManager;
    @Inject
    AppUpdateUtils appUpdateUtils;
    private ActivityMainBinding binding;
    private Business business;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private MainActivityViewModel mViewModel;
    private NavController navController;

    private void alignToolbarTextCenter() {
        ActionBar.LayoutParams layoutParams = (ActionBar.LayoutParams)this.binding.toolTitle.getLayoutParams();
        layoutParams.gravity = 1;
        this.binding.toolTitle.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.binding.toolbarVideoIcon.setVisibility(8);
    }

    private void alignToolbarTextLeft() {
        ActionBar.LayoutParams layoutParams = (ActionBar.LayoutParams)this.binding.toolTitle.getLayoutParams();
        layoutParams.gravity = 3;
        this.binding.toolTitle.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.binding.toolbarVideoIcon.setVisibility(0);
        try {
            this.checkForRemoteVideoConfig();
            return;
        }
        catch (Exception exception) {
            Timber.e((String)"Unable to get remote video link", (Object[])new Object[0]);
            this.binding.toolbarVideoIcon.setOnClickListener((View.OnClickListener)new -$$Lambda$MainActivity$oHU9X4VbiX9E6qtKXDvufMaWEu4(this));
            return;
        }
    }

    private void checkForAppUpdate() {
        this.appUpdateUtils.checkForAppUpdate((Activity)this, this);
        this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener((OnSuccessListener)this);
    }

    private Fragment getCurrentBottomFragment() {
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(2131362350);
        if (fragment == null) {
            return null;
        }
        return (Fragment)fragment.getChildFragmentManager().getFragments().get(0);
    }

    private void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        if ("OPEN_ORDER_DETAILS".equals((Object)intent.getAction())) {
            this.handleNewOrder(intent);
        }
    }

    private void handleNewOrder(Intent intent) {
        String string2 = intent.getStringExtra("orderId");
        this.openOrderDetails(intent.getStringExtra("businessId"), string2);
        CleverTapUtils.trackUser((Context)this, this.mViewModel.getDataManager().getBusiness());
    }

    private void init() {
        NavController navController;
        int n = this.getIntent().getIntExtra("bottomNavigationIndex", -1);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(new int[]{2131362356, 2131362357, 2131362359, 2131362354, 2131362353}).build();
        this.navController = navController = Navigation.findNavController((Activity)this, (int)2131362350);
        NavigationUI.setupActionBarWithNavController((AppCompatActivity)this, (NavController)navController, (AppBarConfiguration)appBarConfiguration);
        NavigationUI.setupWithNavController((BottomNavigationView)this.binding.navView, (NavController)this.navController);
        this.initBottomNavigation();
        this.renderBusinessName();
        this.renderOrdersBadge();
        this.initFcm();
        this.hideActionBarTitle();
        this.handleIntent(this.getIntent());
        this.navigateToIndex(n);
        this.initCleverTap();
    }

    private void initBottomNavigation() {
        this.binding.navView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener)new -$.Lambda.MainActivity.5BddtUaKxItpvAiupZIhyApD6Ic(this));
        this.navController.addOnDestinationChangedListener((NavController.OnDestinationChangedListener)new -$.Lambda.MainActivity.8YMg7eQo_y4GUN9lTujYjcyNH0w(this));
    }

    private void initCleverTap() {
        CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance((Context)this.getApplicationContext());
        if (cleverTapAPI != null) {
            cleverTapAPI.setCTPushNotificationListener((CTPushNotificationListener)this);
        }
    }

    private void initFcm() {
        this.mViewModel.subscribeToFcmTopics();
    }

    private void navigateToIndex(int n) {
        if (n == 2) {
            this.navController.navigate(2131362359);
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951999));
            this.hideActionBarTitle();
            this.alignToolbarTextCenter();
        }
    }

    private void openOrderDetails(String string2, String string3) {
        if (string2 != null) {
            if (string3 == null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ORDERS MAIN:");
            stringBuilder.append(string3);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            Intent intent = new Intent((Context)this, OrderDetailsActivity.class);
            intent.putExtra("orderId", string3);
            this.startActivityForResult(intent, 1000);
        }
    }

    private void popupSnackbarForCompleteUpdate() {
        Snackbar snackbar = Snackbar.make((View)this.findViewById(16908290), (CharSequence)this.getString(2131951658), (int)-2);
        snackbar.setAction((CharSequence)this.getString(2131951923), (View.OnClickListener)new -$$Lambda$MainActivity$s7QzSe-a0MSlUQg9-gP5UGpZD9g(this));
        snackbar.setActionTextColor(-256);
        snackbar.show();
    }

    private void renderBusinessName() {
        this.business = this.mViewModel.getDataManager().getBusiness();
        this.binding.toolTitle.setText((CharSequence)this.business.realmGet$name());
        this.alignToolbarTextLeft();
    }

    private void renderOrdersBadge() {
        BusinessStats businessStats = this.mViewModel.getDataManager().getBusinessStats();
        long l = businessStats != null ? (long)businessStats.getPendingOrderCount() : 0L;
        BadgeDrawable badgeDrawable = this.binding.navView.getOrCreateBadge(2131362357);
        badgeDrawable.setVerticalOffset(8);
        badgeDrawable.setBackgroundColor(ContextCompat.getColor((Context)this, (int)2131099678));
        if (l > 0L) {
            badgeDrawable.setNumber((int)l);
            badgeDrawable.setVisible(true);
            return;
        }
        badgeDrawable.setVisible(false);
    }

    private void showFilterDropDown(View view) {
        View view2 = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(2131558603, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        PopupWindow popupWindow = new PopupWindow(view2, displayMetrics.widthPixels / 2, -2, false);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            popupWindow.setElevation(15.0f);
        }
        popupWindow.showAsDropDown(view);
        RadioGroup radioGroup = (RadioGroup)view2.findViewById(2131362410);
        ((RadioButton)radioGroup.getChildAt(Constants.DEFAULT_ORDER_STATUS_INDEX)).setChecked(true);
        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)new -$$Lambda$MainActivity$AKSbd7Ucl_XGTA8FMx7huwKYxnw(this, popupWindow));
    }

    private void startUpdate(AppUpdateInfo appUpdateInfo, int n) {
        new Thread((Runnable)new -$$Lambda$MainActivity$YDjVZ_l5rV8o-_k60lDiigjwTZA(this, appUpdateInfo, n, (Activity)this)).start();
    }

    public void checkForRemoteVideoConfig() {
        this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity)this, (OnCompleteListener)new -$.Lambda.MainActivity.Bz0poczlkGJ6YRjNU8kGnNHwvj4(this));
    }

    public FirebaseRemoteConfig getFirebaseRemoteConfig() {
        if (this.mFirebaseRemoteConfig == null) {
            this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(5L).build();
            this.mFirebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings);
        }
        return this.mFirebaseRemoteConfig;
    }

    @Override
    public int getLayoutId() {
        return 2131558441;
    }

    @Override
    public Class<MainActivityViewModel> getViewModel() {
        return MainActivityViewModel.class;
    }

    public void hideActionBarTitle() {
        ((ActionBar)Objects.requireNonNull((Object)this.getSupportActionBar())).setTitle((CharSequence)"");
    }

    public /* synthetic */ void lambda$alignToolbarTextLeft$5$MainActivity(View view) {
        this.watchYoutubeVideo("https://youtu.be/emJ4x3EoQhE");
    }

    public /* synthetic */ void lambda$checkForRemoteVideoConfig$4$MainActivity(Task task) {
        String string2;
        if (task.isSuccessful() && !TextUtils.isEmpty((CharSequence)(string2 = this.getFirebaseRemoteConfig().getString("home_video_link")))) {
            this.binding.toolbarVideoIcon.setOnClickListener((View.OnClickListener)new -$$Lambda$MainActivity$XeDGLwDpGGA2tgTpGmRcJJDdncE(this, string2));
        }
    }

    public /* synthetic */ boolean lambda$initBottomNavigation$0$MainActivity(MenuItem menuItem) {
        NavigationUI.onNavDestinationSelected((MenuItem)menuItem, (NavController)Navigation.findNavController((Activity)this, (int)2131362350));
        this.alignToolbarTextCenter();
        if (menuItem.getItemId() == 2131362356) {
            this.renderBusinessName();
        } else if (menuItem.getItemId() == 2131362357) {
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951894));
        } else if (menuItem.getItemId() == 2131362353) {
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951991));
        } else if (menuItem.getItemId() == 2131362359) {
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951999));
        } else if (menuItem.getItemId() == 2131362354) {
            this.binding.toolTitle.setText((CharSequence)this.getString(2131951992));
        }
        this.renderOrdersBadge();
        if (menuItem.getItemId() != 2131362357) {
            Constants.DEFAULT_ORDER_STATUS = null;
            Constants.DEFAULT_ORDER_STATUS_INDEX = 0;
        }
        this.hideActionBarTitle();
        return true;
    }

    public /* synthetic */ void lambda$initBottomNavigation$1$MainActivity(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.hideActionBarTitle();
        if (navDestination.getId() == 2131362356) {
            this.renderBusinessName();
        }
    }

    public /* synthetic */ void lambda$null$3$MainActivity(String string2, View view) {
        this.watchYoutubeVideo(string2);
    }

    public /* synthetic */ void lambda$onFlexibleUpdateAvailable$7$MainActivity(com.google.android.play.core.tasks.Task task, AppUpdateInfo appUpdateInfo) {
        this.startUpdate((AppUpdateInfo)task.getResult(), 0);
    }

    public /* synthetic */ void lambda$onImmediateUpdateAvailable$6$MainActivity(com.google.android.play.core.tasks.Task task, AppUpdateInfo appUpdateInfo) {
        this.startUpdate((AppUpdateInfo)task.getResult(), 1);
    }

    public /* synthetic */ void lambda$popupSnackbarForCompleteUpdate$9$MainActivity(View view) {
        this.appUpdateManager.completeUpdate();
    }

    public /* synthetic */ void lambda$showFilterDropDown$2$MainActivity(PopupWindow popupWindow, RadioGroup radioGroup, int n) {
        Fragment fragment;
        String string2;
        block10 : {
            fragment = this.getCurrentBottomFragment();
            switch (n) {
                default: {
                    break;
                }
                case 2131361806: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 4;
                    string2 = "SHIPPED";
                    break block10;
                }
                case 2131361803: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 1;
                    string2 = "PENDING";
                    break block10;
                }
                case 2131361800: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 6;
                    string2 = "DELIVERED";
                    break block10;
                }
                case 2131361799: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 3;
                    string2 = "DECLINED";
                    break block10;
                }
                case 2131361798: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 5;
                    string2 = "CANCELLED";
                    break block10;
                }
                case 2131361794: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 0;
                    break;
                }
                case 2131361793: {
                    Constants.DEFAULT_ORDER_STATUS_INDEX = 2;
                    string2 = "ACCEPTED";
                    break block10;
                }
            }
            string2 = null;
        }
        popupWindow.dismiss();
        if (fragment instanceof OrdersFragment) {
            Constants.DEFAULT_ORDER_STATUS = string2;
            ((OrdersFragment)fragment).sort(string2);
        }
    }

    public /* synthetic */ void lambda$startUpdate$8$MainActivity(AppUpdateInfo appUpdateInfo, int n, Activity activity) {
        try {
            this.appUpdateManager.startUpdateFlowForResult(appUpdateInfo, n, activity, 404);
            return;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            sendIntentException.printStackTrace();
            return;
        }
    }

    @Override
    public void navigateToOrdersTab() {
        this.hideActionBarTitle();
        this.navController.navigate(2131362357);
        this.binding.toolTitle.setText((CharSequence)this.getString(2131951894));
        this.alignToolbarTextCenter();
    }

    public void navigateToProductsTab() {
        this.hideActionBarTitle();
        this.navController.navigate(2131362359);
        this.binding.toolTitle.setText((CharSequence)this.getString(2131951999));
        this.alignToolbarTextCenter();
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 404) {
            if (n2 == -1) {
                Timber.e((String)"Update flow completed!", (Object[])new Object[0]);
                return;
            }
            Timber.e((String)"Error in update flow!", (Object[])new Object[0]);
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.REFRESH_STATS) {
            this.mViewModel.getBusinessStats();
            return;
        }
        if (appEvent.type == AppEvent.NAVIGATE_TO_ORDERS) {
            this.navigateToOrdersTab();
            return;
        }
        if (appEvent.type == AppEvent.PLAY_NEW_ORDER_SOUND) {
            NotificationsUtils.playNewOrderSound();
            return;
        }
        if (appEvent.type == AppEvent.NAVIGATE_TO_PRODUCTS) {
            this.navigateToProductsTab();
        }
    }

    @Override
    protected void onCreate(Bundle bundle, MainActivityViewModel mainActivityViewModel, ActivityMainBinding activityMainBinding) {
        this.binding = activityMainBinding;
        this.mViewModel = mainActivityViewModel;
        mainActivityViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityMainBinding.toolbar);
        this.init();
        if (!AppPref.getInstance().isProductsAdded() && this.getIntent().getBooleanExtra("first_open", false)) {
            this.startActivityForResult(new Intent((Context)this, EditProductActivity.class), 111);
        }
        AppEventsLogger.newLogger((Context)this).logEvent("View_MainActivity");
    }

    @Override
    public void onFlexibleUpdateAvailable() {
        com.google.android.play.core.tasks.Task task = this.appUpdateManager.getAppUpdateInfo();
        task.addOnSuccessListener((OnSuccessListener)new -$.Lambda.MainActivity.IvV-lCtjXTkwhdc9hXL3ypery8k(this, task));
    }

    @Override
    public void onImmediateUpdateAvailable() {
        com.google.android.play.core.tasks.Task task = this.appUpdateManager.getAppUpdateInfo();
        task.addOnSuccessListener((OnSuccessListener)new -$.Lambda.MainActivity.KqzuhpzhusklS1_G5tPHSB7jdog(this, task));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.handleIntent(intent);
    }

    public void onNotificationClickedPayloadReceived(HashMap<String, Object> hashMap) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131361865) {
            this.showFilterDropDown(this.findViewById(2131361865));
            return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.hideFullscreenLoader();
        this.checkForAppUpdate();
    }

    public void onSuccess(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            this.startUpdate(appUpdateInfo, 1);
            return;
        }
        if (appUpdateInfo.installStatus() == 11) {
            this.popupSnackbarForCompleteUpdate();
        }
    }

    public void refreshBadgeCount() {
        this.renderOrdersBadge();
    }

    public void watchYoutubeVideo(String string2) {
        this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string2)));
    }
}

