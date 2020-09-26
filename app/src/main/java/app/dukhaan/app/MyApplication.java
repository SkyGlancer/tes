/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Service
 *  android.content.Context
 *  androidx.fragment.app.Fragment
 *  androidx.multidex.MultiDexApplication
 *  com.clevertap.android.sdk.ActivityLifecycleCallback
 *  dagger.android.AndroidInjector
 *  dagger.android.DispatchingAndroidInjector
 *  dagger.android.HasActivityInjector
 *  dagger.android.HasServiceInjector
 *  dagger.android.support.HasSupportFragmentInjector
 *  io.branch.referral.Branch
 *  io.realm.Realm
 *  io.realm.RealmConfiguration
 *  io.realm.RealmConfiguration$Builder
 *  io.realm.RealmMigration
 *  java.lang.String
 *  javax.inject.Inject
 */
package app.dukhaan.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.multidex.MultiDexApplication;
import app.dukhaan.data.local.DatabaseMigrations;
import app.dukhaan.di.component.AppComponent;
import app.dukhaan.di.component.DaggerAppComponent;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.NotificationsUtils;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.branch.referral.Branch;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import javax.inject.Inject;

public class MyApplication
extends MultiDexApplication
implements HasActivityInjector,
HasServiceInjector,
HasSupportFragmentInjector {
    private static MyApplication mInstance;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    private void checkAppUpdateChanges() {
        AppUtils.isInstallFromUpdate((Context)this);
    }

    private void enableDebug() {
    }

    public static MyApplication getInstance() {
        return mInstance;
    }

    private void initRealm() {
        Realm.init((Context)this);
        Realm.setDefaultConfiguration((RealmConfiguration)new RealmConfiguration.Builder().name(MyApplication.getInstance().getString(2131951918)).schemaVersion(7L).migration((RealmMigration)new DatabaseMigrations()).build());
    }

    private void plantTimber() {
    }

    public DispatchingAndroidInjector<Activity> activityInjector() {
        return this.activityDispatchingAndroidInjector;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
        ActivityLifecycleCallback.register((Application)this);
        super.onCreate();
        Branch.enableLogging();
        Branch.getAutoInstance((Context)this);
        DaggerAppComponent.builder().application((Application)this).build().inject(this);
        mInstance = this;
        this.plantTimber();
        this.initRealm();
        this.checkAppUpdateChanges();
        NotificationsUtils.init((Context)this);
        this.enableDebug();
    }

    public AndroidInjector<Service> serviceInjector() {
        return this.dispatchingServiceInjector;
    }

    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.mFragmentInjector;
    }
}

