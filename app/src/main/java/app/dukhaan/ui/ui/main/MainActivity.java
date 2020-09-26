package app.dukhaan.ui.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.databinding.ActivityMainBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.main.MainActivityNavigator;
import app.dukhaan.ui.main.MainActivityViewModel;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.util.AppUpdateUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.ModalDialogs;
import app.dukhaan.util.NotificationsUtils;
import app.dukhaan.util.AppUpdateUtils.AppUpdateUtilsListener;
import com.clevertap.android.sdk.CTPushNotificationListener;
import com.clevertap.android.sdk.CleverTapAPI;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainActivityNavigator, CTPushNotificationListener, AppUpdateUtilsListener, OnSuccessListener<AppUpdateInfo> {
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

   public MainActivity() {
   }

   private void alignToolbarTextCenter() {
      LayoutParams var1 = (LayoutParams)this.binding.toolTitle.getLayoutParams();
      var1.gravity = 1;
      this.binding.toolTitle.setLayoutParams(var1);
      this.binding.toolbarVideoIcon.setVisibility(8);
   }

   private void alignToolbarTextLeft() {
      LayoutParams var1 = (LayoutParams)this.binding.toolTitle.getLayoutParams();
      var1.gravity = 3;
      this.binding.toolTitle.setLayoutParams(var1);
      this.binding.toolbarVideoIcon.setVisibility(0);

      try {
         this.checkForRemoteVideoConfig();
      } catch (Exception var2) {
         Timber.e("Unable to get remote video link", new Object[0]);
         this.binding.toolbarVideoIcon.setOnClickListener(new _$$Lambda$MainActivity$oHU9X4VbiX9E6qtKXDvufMaWEu4(this));
      }

   }

   private void checkForAppUpdate() {
      this.appUpdateUtils.checkForAppUpdate(this, this);
      this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener(this);
   }

   private Fragment getCurrentBottomFragment() {
      Fragment var1 = this.getSupportFragmentManager().findFragmentById(nav_host_fragment);
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = (Fragment)var1.getChildFragmentManager().getFragments().get(0);
      }

      return var1;
   }

   private void handleIntent(Intent var1) {
      if (var1 != null) {
         if ("OPEN_ORDER_DETAILS".equals(var1.getAction())) {
            this.handleNewOrder(var1);
         }

      }
   }

   private void handleNewOrder(Intent var1) {
      String var2 = var1.getStringExtra("orderId");
      this.openOrderDetails(var1.getStringExtra("businessId"), var2);
      CleverTapUtils.trackUser(this, this.mViewModel.getDataManager().getBusiness());
   }

   private void init() {
      int var1 = this.getIntent().getIntExtra("bottomNavigationIndex", -1);
      AppBarConfiguration var2 = (new Builder(new int[]{navigation_home, navigation_orders, navigation_products, navigation_categories, navigation_account})).build();
      NavController var3 = Navigation.findNavController(this, nav_host_fragment);
      this.navController = var3;
      NavigationUI.setupActionBarWithNavController(this, var3, var2);
      NavigationUI.setupWithNavController(this.binding.navView, this.navController);
      this.initBottomNavigation();
      this.renderBusinessName();
      this.renderOrdersBadge();
      this.initFcm();
      this.hideActionBarTitle();
      this.handleIntent(this.getIntent());
      this.navigateToIndex(var1);
      this.initCleverTap();
   }

   private void initBottomNavigation() {
      this.binding.navView.setOnNavigationItemSelectedListener(new _$$Lambda$MainActivity$5BddtUaKxItpvAiupZIhyApD6Ic(this));
      this.navController.addOnDestinationChangedListener(new _$$Lambda$MainActivity$8YMg7eQo_y4GUN9lTujYjcyNH0w(this));
   }

   private void initCleverTap() {
      CleverTapAPI var1 = CleverTapAPI.getDefaultInstance(this.getApplicationContext());
      if (var1 != null) {
         var1.setCTPushNotificationListener(this);
      }

   }

   private void initFcm() {
      this.mViewModel.subscribeToFcmTopics();
   }

   private void navigateToIndex(int var1) {
      if (var1 == 2) {
         this.navController.navigate(navigation_products);
         this.binding.toolTitle.setText(this.getString(R.string.title_products));
         this.hideActionBarTitle();
         this.alignToolbarTextCenter();
      }

   }

   private void openOrderDetails(String var1, String var2) {
      if (var1 != null && var2 != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ORDERS MAIN:");
         var3.append(var2);
         Timber.d(var3.toString(), new Object[0]);
         Intent var4 = new Intent(this, OrderDetailsActivity.class);
         var4.putExtra("orderId", var2);
         this.startActivityForResult(var4, 1000);
      }

   }

   private void popupSnackbarForCompleteUpdate() {
      Snackbar var1 = Snackbar.make(this.findViewById(16908290), this.getString(R.string.app_update_downloaded), -2);
      var1.setAction(this.getString(R.string.restart), new _$$Lambda$MainActivity$s7QzSe_a0MSlUQg9_gP5UGpZD9g(this));
      var1.setActionTextColor(-256);
      var1.show();
   }

   private void renderBusinessName() {
      this.business = this.mViewModel.getDataManager().getBusiness();
      this.binding.toolTitle.setText(this.business.realmGet$name());
      this.alignToolbarTextLeft();
   }

   private void renderOrdersBadge() {
      BusinessStats var1 = this.mViewModel.getDataManager().getBusinessStats();
      long var2;
      if (var1 != null) {
         var2 = (long)var1.getPendingOrderCount();
      } else {
         var2 = 0L;
      }

      BadgeDrawable var4 = this.binding.navView.getOrCreateBadge(navigation_orders);
      var4.setVerticalOffset(8);
      var4.setBackgroundColor(ContextCompat.getColor(R.color.this, badge_background));
      if (var2 > 0L) {
         var4.setNumber((int)var2);
         var4.setVisible(true);
      } else {
         var4.setVisible(false);
      }

   }

   private void showFilterDropDown(View var1) {
      View var2 = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(popup_orders_sort, (ViewGroup)null);
      DisplayMetrics var3 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var3);
      PopupWindow var5 = new PopupWindow(var2, var3.widthPixels / 2, -2, false);
      var5.setTouchable(true);
      var5.setFocusable(true);
      var5.setOutsideTouchable(true);
      if (VERSION.SDK_INT >= 21) {
         var5.setElevation(15.0F);
      }

      var5.showAsDropDown(var1);
      RadioGroup var4 = (RadioGroup)var2.findViewById(radio_button);
      ((RadioButton)var4.getChildAt(Constants.DEFAULT_ORDER_STATUS_INDEX)).setChecked(true);
      var4.setOnCheckedChangeListener(new _$$Lambda$MainActivity$AKSbd7Ucl_XGTA8FMx7huwKYxnw(this, var5));
   }

   private void startUpdate(AppUpdateInfo var1, int var2) {
      (new Thread(new _$$Lambda$MainActivity$YDjVZ_l5rV8o__k60lDiigjwTZA(this, var1, var2, this))).start();
   }

   public void checkForRemoteVideoConfig() {
      this.getFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener(this, new _$$Lambda$MainActivity$Bz0poczlkGJ6YRjNU8kGnNHwvj4(this));
   }

   public FirebaseRemoteConfig getFirebaseRemoteConfig() {
      if (this.mFirebaseRemoteConfig == null) {
         this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
         FirebaseRemoteConfigSettings var1 = (new com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder()).setMinimumFetchIntervalInSeconds(5L).build();
         this.mFirebaseRemoteConfig.setConfigSettingsAsync(var1);
      }

      return this.mFirebaseRemoteConfig;
   }

   public int getLayoutId() {
      return activity_main;
   }

   public Class<MainActivityViewModel> getViewModel() {
      return MainActivityViewModel.class;
   }

   public void hideActionBarTitle() {
      ((ActionBar)Objects.requireNonNull(this.getSupportActionBar())).setTitle("");
   }

   public void navigateToOrdersTab() {
      this.hideActionBarTitle();
      this.navController.navigate(navigation_orders);
      this.binding.toolTitle.setText(this.getString(R.string.orders));
      this.alignToolbarTextCenter();
   }

   public void navigateToProductsTab() {
      this.hideActionBarTitle();
      this.navController.navigate(navigation_products);
      this.binding.toolTitle.setText(this.getString(R.string.title_products));
      this.alignToolbarTextCenter();
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 404) {
         if (var2 == -1) {
            Timber.e("Update flow completed!", new Object[0]);
         } else {
            Timber.e("Error in update flow!", new Object[0]);
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.REFRESH_STATS) {
         this.mViewModel.getBusinessStats();
      } else if (var1.type == AppEvent.NAVIGATE_TO_ORDERS) {
         this.navigateToOrdersTab();
      } else if (var1.type == AppEvent.PLAY_NEW_ORDER_SOUND) {
         NotificationsUtils.playNewOrderSound();
      } else if (var1.type == AppEvent.NAVIGATE_TO_PRODUCTS) {
         this.navigateToProductsTab();
      }

   }

   protected void onCreate(Bundle var1, MainActivityViewModel var2, ActivityMainBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.init();
      if (!AppPref.getInstance().isProductsAdded() && this.getIntent().getBooleanExtra("first_open", false)) {
         this.startActivityForResult(new Intent(this, EditProductActivity.class), 111);
      }

      AppEventsLogger.newLogger(this).logEvent("View_MainActivity");
   }

   public void onFlexibleUpdateAvailable() {
      Task var1 = this.appUpdateManager.getAppUpdateInfo();
      var1.addOnSuccessListener(new _$$Lambda$MainActivity$IvV_lCtjXTkwhdc9hXL3ypery8k(this, var1));
   }

   public void onImmediateUpdateAvailable() {
      Task var1 = this.appUpdateManager.getAppUpdateInfo();
      var1.addOnSuccessListener(new _$$Lambda$MainActivity$KqzuhpzhusklS1_G5tPHSB7jdog(this, var1));
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.handleIntent(var1);
   }

   public void onNotificationClickedPayloadReceived(HashMap<String, Object> var1) {
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if (var1.getItemId() == action_sort_orders) {
         this.showFilterDropDown(this.findViewById(action_sort_orders));
         return true;
      } else {
         return false;
      }
   }

   protected void onResume() {
      super.onResume();
      this.hideFullscreenLoader();
      this.checkForAppUpdate();
   }

   public void onSuccess(AppUpdateInfo var1) {
      if (var1.updateAvailability() == 3) {
         this.startUpdate(var1, 1);
      } else if (var1.installStatus() == 11) {
         this.popupSnackbarForCompleteUpdate();
      }

   }

   public void refreshBadgeCount() {
      this.renderOrdersBadge();
   }

   public void watchYoutubeVideo(String var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
   }
}
