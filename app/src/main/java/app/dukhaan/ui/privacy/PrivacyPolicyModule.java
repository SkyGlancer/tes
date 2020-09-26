/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.privacy.PrivacyPolicyViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.privacy;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class PrivacyPolicyModule {
    @Provides
    ViewModelProvider.Factory privacyPolicyViewModelProvider(PrivacyPolicyViewModel privacyPolicyViewModel) {
        return new ViewModelProviderFactory((Object)privacyPolicyViewModel);
    }

    @Provides
    PrivacyPolicyViewModel providePrivacyPolicyViewModel(DataRepository dataRepository, ApiService apiService) {
        return new PrivacyPolicyViewModel(dataRepository, apiService);
    }
}

