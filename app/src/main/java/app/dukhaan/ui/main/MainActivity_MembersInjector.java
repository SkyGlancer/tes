/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  com.google.android.play.core.appupdate.AppUpdateManager
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.main;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.util.AppUpdateUtils;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector
implements MembersInjector<MainActivity> {
    private final Provider<AppUpdateManager> appUpdateManagerProvider;
    private final Provider<AppUpdateUtils> appUpdateUtilsProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MainActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<AppUpdateUtils> provider2, Provider<AppUpdateManager> provider3) {
        this.viewModelFactoryProvider = provider;
        this.appUpdateUtilsProvider = provider2;
        this.appUpdateManagerProvider = provider3;
    }

    public static MembersInjector<MainActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<AppUpdateUtils> provider2, Provider<AppUpdateManager> provider3) {
        return new MainActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectAppUpdateManager(MainActivity mainActivity, AppUpdateManager appUpdateManager) {
        mainActivity.appUpdateManager = appUpdateManager;
    }

    public static void injectAppUpdateUtils(MainActivity mainActivity, AppUpdateUtils appUpdateUtils) {
        mainActivity.appUpdateUtils = appUpdateUtils;
    }

    public void injectMembers(MainActivity mainActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(mainActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
        MainActivity_MembersInjector.injectAppUpdateUtils(mainActivity, (AppUpdateUtils)this.appUpdateUtilsProvider.get());
        MainActivity_MembersInjector.injectAppUpdateManager(mainActivity, (AppUpdateManager)this.appUpdateManagerProvider.get());
    }
}

