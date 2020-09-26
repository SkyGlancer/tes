/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.mobilenumber;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.mobilenumber.MobileNumberActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MobileNumberActivity_MembersInjector
implements MembersInjector<MobileNumberActivity> {
    private final Provider<ViewModelProvider.Factory> mViewModelFactoryAndViewModelFactoryProvider;

    public MobileNumberActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.mViewModelFactoryAndViewModelFactoryProvider = provider;
    }

    public static MembersInjector<MobileNumberActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new MobileNumberActivity_MembersInjector(provider);
    }

    public static void injectMViewModelFactory(MobileNumberActivity mobileNumberActivity, ViewModelProvider.Factory factory) {
        mobileNumberActivity.mViewModelFactory = factory;
    }

    public void injectMembers(MobileNumberActivity mobileNumberActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(mobileNumberActivity, (ViewModelProvider.Factory)this.mViewModelFactoryAndViewModelFactoryProvider.get());
        MobileNumberActivity_MembersInjector.injectMViewModelFactory(mobileNumberActivity, (ViewModelProvider.Factory)this.mViewModelFactoryAndViewModelFactoryProvider.get());
    }
}

