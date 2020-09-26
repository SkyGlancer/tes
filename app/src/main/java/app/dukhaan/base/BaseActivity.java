/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.Window
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentManager
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStoreOwner
 *  app.dukhaan.base.-$
 *  app.dukhaan.base.-$$Lambda
 *  app.dukhaan.base.-$$Lambda$BaseActivity
 *  app.dukhaan.base.-$$Lambda$BaseActivity$QYC8qzw_XpXwFxvK9v-HUbNaWwg
 *  app.dukhaan.base.-$$Lambda$BaseActivity$azFD-SYPb-FCcQZAFyxASdWPv7w
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.messaging.FirebaseMessaging
 *  dagger.android.AndroidInjection
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  javax.inject.Inject
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  timber.log.Timber
 */
package app.dukhaan.base;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import app.dukhaan.app.Constants;
import app.dukhaan.base.-$;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityEvent;
import app.dukhaan.network.interceptor.UnauthorizedEvent;
import app.dukhaan.ui.account.AccountFragment;
import app.dukhaan.ui.categories.CategoriesFragment;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.ui.splash.SplashActivity;
import app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.FullscreenProgressDialog;
import app.dukhaan.util.ToastFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import dagger.android.AndroidInjection;
import java.util.Locale;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import timber.log.Timber;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
extends AppCompatActivity
implements BaseFragment.Callback {
    protected AccountFragment accountFragment;
    protected CategoriesFragment categoriesFragment;
    private NoNetworkFullscreenDialog dialog;
    private T mViewDataBinding;
    private V mViewModel;
    protected ProductsFragment productsListFragment;
    private FullscreenProgressDialog progressDialog;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    static /* synthetic */ void lambda$handleNoInternetConnection$1() {
        AppEvent appEvent = new AppEvent(AppEvent.INTERNET_CONNECTION_CHECK, null);
        EventBus.getDefault().post((Object)appEvent);
    }

    static /* synthetic */ void lambda$unsubscribeFromFcm$0(String string2, Task task) {
        if (task.isSuccessful()) {
            Timber.e((String)"Successfully unsubscribed from fcm topic %s", (Object[])new Object[]{string2});
            return;
        }
        Timber.e((String)"Failed to unsubscribe from %s topic", (Object[])new Object[]{string2});
    }

    private void unsubscribeFromFcm() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        if (business == null) {
            return;
        }
        String string2 = Constants.FCM_TOPIC_BUSINESS;
        Object[] arrobject = new Object[]{business.realmGet$id()};
        String string3 = String.format((String)string2, (Object[])arrobject);
        FirebaseMessaging.getInstance().unsubscribeFromTopic(string3).addOnCompleteListener((OnCompleteListener)new -$.Lambda.BaseActivity.QYC8qzw_XpXwFxvK9v-HUbNaWwg(string3));
    }

    private Context updateResourcesLocale(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    private Context updateResourcesLocaleLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(this.updateBaseContextLocale(context));
    }

    public void changeStatusBarColor() {
        this.changeStatusBarColor(-1);
    }

    public void changeStatusBarColor(int n) {
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(n);
        }
    }

    public void enableToolbarUpNavigation() {
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);
            this.getSupportActionBar().setTitle((CharSequence)"");
            this.getSupportActionBar().setHomeAsUpIndicator(2131231221);
        }
    }

    public abstract int getLayoutId();

    public abstract Class<V> getViewModel();

    protected void handleNoInternetConnection() {
        NoNetworkFullscreenDialog noNetworkFullscreenDialog;
        NoNetworkFullscreenDialog noNetworkFullscreenDialog2 = this.dialog;
        if (noNetworkFullscreenDialog2 != null && noNetworkFullscreenDialog2.isAdded()) {
            this.dialog.dismiss();
        }
        this.dialog = noNetworkFullscreenDialog = new NoNetworkFullscreenDialog();
        noNetworkFullscreenDialog.setCancelable(false);
        if (!this.dialog.isAdded()) {
            this.dialog.display(this.getSupportFragmentManager());
            this.hideFullscreenLoader();
        }
        this.dialog.setTryAgainListener(-$.Lambda.BaseActivity.azFD-SYPb-FCcQZAFyxASdWPv7w.INSTANCE);
    }

    protected void handleUnauthorizedEvent(ErrorResponse errorResponse) {
        this.logout();
    }

    public void hideActionBar() {
        if (this.getSupportActionBar() != null && this.getSupportActionBar().isShowing()) {
            this.getSupportActionBar().hide();
        }
    }

    public void hideFullscreenLoader() {
        FullscreenProgressDialog fullscreenProgressDialog = this.progressDialog;
        if (fullscreenProgressDialog != null && fullscreenProgressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    public void logout() {
        this.unsubscribeFromFcm();
        this.mViewModel.getDataManager().logout();
        Intent intent = new Intent((Context)this, SplashActivity.class);
        this.finishAffinity();
        this.startActivity(intent);
    }

    public void navigateToOrdersTab() {
    }

    protected void onCreate(Bundle bundle) {
        this.performDependencyInjection();
        super.onCreate(bundle);
        this.dialog = new NoNetworkFullscreenDialog();
        this.mViewDataBinding = DataBindingUtil.setContentView((Activity)this, (int)this.getLayoutId());
        this.mViewModel = (BaseViewModel)new ViewModelProvider((ViewModelStoreOwner)this, this.viewModelFactory).get(this.getViewModel());
        this.progressDialog = new FullscreenProgressDialog((Context)this);
        this.onCreate(bundle, this.mViewModel, this.mViewDataBinding);
    }

    protected abstract void onCreate(Bundle var1, V var2, T var3);

    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered((Object)this)) {
            EventBus.getDefault().unregister((Object)this);
        }
    }

    @Override
    public void onFragmentAttached(Object object) {
        if (object instanceof CategoriesFragment) {
            this.categoriesFragment = (CategoriesFragment)object;
            return;
        }
        if (object instanceof ProductsFragment) {
            this.productsListFragment = (ProductsFragment)object;
            return;
        }
        if (object instanceof AccountFragment) {
            this.accountFragment = (AccountFragment)((Object)object);
        }
    }

    @Override
    public void onFragmentDetached(String string2) {
    }

    @Subscribe
    public final void onNoConnectivityEvent(NoConnectivityEvent noConnectivityEvent) {
        this.handleNoInternetConnection();
    }

    protected void onResume() {
        super.onResume();
        NotificationManager notificationManager = (NotificationManager)this.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered((Object)this)) {
            EventBus.getDefault().register((Object)this);
        }
    }

    @Subscribe
    public final void onUnauthorizedEvent(UnauthorizedEvent unauthorizedEvent) {
        this.handleUnauthorizedEvent(unauthorizedEvent.getError());
    }

    public void performDependencyInjection() {
        AndroidInjection.inject((Activity)this);
    }

    public void showActionBar() {
        if (this.getSupportActionBar() != null && !this.getSupportActionBar().isShowing()) {
            this.getSupportActionBar().show();
        }
    }

    public void showFullscreenLoader() {
        FullscreenProgressDialog fullscreenProgressDialog = this.progressDialog;
        if (fullscreenProgressDialog != null) {
            fullscreenProgressDialog.show();
        }
    }

    public void showToast(String string2) {
        ToastFactory.createToast((Context)this, string2).show();
    }

    public Context updateBaseContextLocale(Context context) {
        String string2 = AppPref.getInstance().getLocale();
        String string3 = AppUtils.getDeviceLocale(context);
        if (TextUtils.isEmpty((CharSequence)string3)) {
            string3 = "en";
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = string3;
        }
        Locale locale = new Locale(string2);
        Locale.setDefault((Locale)locale);
        if (Build.VERSION.SDK_INT >= 24) {
            return this.updateResourcesLocale(context, locale);
        }
        return this.updateResourcesLocaleLegacy(context, locale);
    }
}

