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
package app.dukhaan.ui.onboarding;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnBoardingActivity_MembersInjector
implements MembersInjector<OnBoardingActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OnBoardingActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<OnBoardingActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new OnBoardingActivity_MembersInjector(provider);
    }

    public void injectMembers(OnBoardingActivity onBoardingActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(onBoardingActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

