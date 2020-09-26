/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.verifymobile.VerifyMobileViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.verifymobile;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class VerifyMobileModule {
    @Provides
    VerifyMobileViewModel provideVerifyMobileViewModel(DataRepository dataRepository, ApiService apiService) {
        return new VerifyMobileViewModel(dataRepository, apiService);
    }

    @Provides
    ViewModelProvider.Factory verifyMobileViewModelProvider(VerifyMobileViewModel verifyMobileViewModel) {
        return new ViewModelProviderFactory((Object)verifyMobileViewModel);
    }
}

