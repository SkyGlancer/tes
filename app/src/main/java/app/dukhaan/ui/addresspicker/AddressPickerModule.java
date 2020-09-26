/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.addresspicker.AddressViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.addresspicker;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddressPickerModule {
    @Provides
    ViewModelProvider.Factory addressViewModelProvider(AddressViewModel addressViewModel) {
        return new ViewModelProviderFactory((Object)addressViewModel);
    }

    @Provides
    AddressViewModel provideAddressViewModel(DataRepository dataRepository, ApiService apiService) {
        return new AddressViewModel(dataRepository, apiService);
    }
}

