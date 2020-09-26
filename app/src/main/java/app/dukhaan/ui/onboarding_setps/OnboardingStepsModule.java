/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.onboarding_setps;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OnboardingStepsModule {
    @Provides
    ViewModelProvider.Factory onboardingStepsViewModelProvider(OnboardingStepsViewModel onboardingStepsViewModel) {
        return new ViewModelProviderFactory((Object)onboardingStepsViewModel);
    }

    @Provides
    OnboardingStepsViewModel provideOnboardingStepsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new OnboardingStepsViewModel(dataRepository, apiService);
    }
}

