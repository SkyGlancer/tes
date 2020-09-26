/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.deliverycharges;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class DeliveryChargesModule {
    @Provides
    ViewModelProvider.Factory deliveryChargesViewModelProvider(DeliveryChargesViewModel deliveryChargesViewModel) {
        return new ViewModelProviderFactory((Object)deliveryChargesViewModel);
    }

    @Provides
    DeliveryChargesViewModel provideDeliveryChargesViewModel(DataRepository dataRepository, ApiService apiService) {
        return new DeliveryChargesViewModel(dataRepository, apiService);
    }
}

