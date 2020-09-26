/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.mobilenumber.MobileNumberViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.mobilenumber;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MobileNumberModule {
    @Provides
    ViewModelProvider.Factory mobileNumberViewModelProvider(MobileNumberViewModel mobileNumberViewModel) {
        return new ViewModelProviderFactory((Object)mobileNumberViewModel);
    }

    @Provides
    MobileNumberViewModel provideAboutViewModel(DataRepository dataRepository, ApiService apiService) {
        return new MobileNumberViewModel(dataRepository, apiService);
    }
}

