/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.verifyotp.VerifyOtpViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.verifyotp;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class VerifyOtpModule {
    @Provides
    VerifyOtpViewModel provideVerifyOtpViewModel(DataRepository dataRepository, ApiService apiService) {
        return new VerifyOtpViewModel(dataRepository, apiService);
    }

    @Provides
    ViewModelProvider.Factory verifyOtpViewModelProvider(VerifyOtpViewModel verifyOtpViewModel) {
        return new ViewModelProviderFactory((Object)verifyOtpViewModel);
    }
}

