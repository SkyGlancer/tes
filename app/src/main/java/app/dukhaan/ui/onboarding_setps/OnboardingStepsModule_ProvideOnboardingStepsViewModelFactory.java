/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.onboarding_setps;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsModule;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory
implements Factory<OnboardingStepsViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final OnboardingStepsModule module;

    public OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory(OnboardingStepsModule onboardingStepsModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = onboardingStepsModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory create(OnboardingStepsModule onboardingStepsModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory(onboardingStepsModule, provider, provider2);
    }

    public static OnboardingStepsViewModel provideOnboardingStepsViewModel(OnboardingStepsModule onboardingStepsModule, DataRepository dataRepository, ApiService apiService) {
        return (OnboardingStepsViewModel)((Object)Preconditions.checkNotNull((Object)((Object)onboardingStepsModule.provideOnboardingStepsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public OnboardingStepsViewModel get() {
        return OnboardingStepsModule_ProvideOnboardingStepsViewModelFactory.provideOnboardingStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

