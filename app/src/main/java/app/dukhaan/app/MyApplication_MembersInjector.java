/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Service
 *  androidx.fragment.app.Fragment
 *  dagger.MembersInjector
 *  dagger.android.DispatchingAndroidInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.app;

import android.app.Activity;
import android.app.Service;
import androidx.fragment.app.Fragment;
import app.dukhaan.app.MyApplication;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class MyApplication_MembersInjector
implements MembersInjector<MyApplication> {
    private final Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider;
    private final Provider<DispatchingAndroidInjector<Service>> dispatchingServiceInjectorProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> mFragmentInjectorProvider;

    public MyApplication_MembersInjector(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<DispatchingAndroidInjector<Service>> provider2, Provider<DispatchingAndroidInjector<Fragment>> provider3) {
        this.activityDispatchingAndroidInjectorProvider = provider;
        this.dispatchingServiceInjectorProvider = provider2;
        this.mFragmentInjectorProvider = provider3;
    }

    public static MembersInjector<MyApplication> create(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<DispatchingAndroidInjector<Service>> provider2, Provider<DispatchingAndroidInjector<Fragment>> provider3) {
        return new MyApplication_MembersInjector(provider, provider2, provider3);
    }

    public static void injectActivityDispatchingAndroidInjector(MyApplication myApplication, DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        myApplication.activityDispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    public static void injectDispatchingServiceInjector(MyApplication myApplication, DispatchingAndroidInjector<Service> dispatchingAndroidInjector) {
        myApplication.dispatchingServiceInjector = dispatchingAndroidInjector;
    }

    public static void injectMFragmentInjector(MyApplication myApplication, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        myApplication.mFragmentInjector = dispatchingAndroidInjector;
    }

    public void injectMembers(MyApplication myApplication) {
        MyApplication_MembersInjector.injectActivityDispatchingAndroidInjector(myApplication, (DispatchingAndroidInjector<Activity>)((DispatchingAndroidInjector)this.activityDispatchingAndroidInjectorProvider.get()));
        MyApplication_MembersInjector.injectDispatchingServiceInjector(myApplication, (DispatchingAndroidInjector<Service>)((DispatchingAndroidInjector)this.dispatchingServiceInjectorProvider.get()));
        MyApplication_MembersInjector.injectMFragmentInjector(myApplication, (DispatchingAndroidInjector<Fragment>)((DispatchingAndroidInjector)this.mFragmentInjectorProvider.get()));
    }
}

