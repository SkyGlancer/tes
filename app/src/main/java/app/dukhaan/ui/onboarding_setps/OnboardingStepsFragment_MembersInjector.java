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
package app.dukhaan.ui.onboarding_setps;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingStepsFragment_MembersInjector
implements MembersInjector<OnboardingStepsFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OnboardingStepsFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<OnboardingStepsFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new OnboardingStepsFragment_MembersInjector(provider);
    }

    public void injectMembers(OnboardingStepsFragment onboardingStepsFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(onboardingStepsFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

