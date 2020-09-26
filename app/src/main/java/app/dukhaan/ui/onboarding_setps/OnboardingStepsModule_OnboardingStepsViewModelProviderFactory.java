/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.onboarding_setps;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsModule;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OnboardingStepsModule_OnboardingStepsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final OnboardingStepsModule module;
    private final Provider<OnboardingStepsViewModel> viewModelProvider;

    public OnboardingStepsModule_OnboardingStepsViewModelProviderFactory(OnboardingStepsModule onboardingStepsModule, Provider<OnboardingStepsViewModel> provider) {
        this.module = onboardingStepsModule;
        this.viewModelProvider = provider;
    }

    public static OnboardingStepsModule_OnboardingStepsViewModelProviderFactory create(OnboardingStepsModule onboardingStepsModule, Provider<OnboardingStepsViewModel> provider) {
        return new OnboardingStepsModule_OnboardingStepsViewModelProviderFactory(onboardingStepsModule, provider);
    }

    public static ViewModelProvider.Factory onboardingStepsViewModelProvider(OnboardingStepsModule onboardingStepsModule, OnboardingStepsViewModel onboardingStepsViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)onboardingStepsModule.onboardingStepsViewModelProvider(onboardingStepsViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return OnboardingStepsModule_OnboardingStepsViewModelProviderFactory.onboardingStepsViewModelProvider(this.module, (OnboardingStepsViewModel)((Object)this.viewModelProvider.get()));
    }
}

