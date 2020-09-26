/*
 * Decompiled with CFR 0.0.
 */
package app.dukhaan.ui.onboarding_setps;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsNavigator;

public class OnboardingStepsViewModel
extends BaseViewModel<OnboardingStepsNavigator> {
    public OnboardingStepsViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }
}

