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
package app.dukhaan.ui.deliverycharges;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.deliverycharges.DeliveryChargesModule;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory
implements Factory<DeliveryChargesViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final DeliveryChargesModule module;

    public DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory(DeliveryChargesModule deliveryChargesModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = deliveryChargesModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory create(DeliveryChargesModule deliveryChargesModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory(deliveryChargesModule, provider, provider2);
    }

    public static DeliveryChargesViewModel provideDeliveryChargesViewModel(DeliveryChargesModule deliveryChargesModule, DataRepository dataRepository, ApiService apiService) {
        return (DeliveryChargesViewModel)((Object)Preconditions.checkNotNull((Object)((Object)deliveryChargesModule.provideDeliveryChargesViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public DeliveryChargesViewModel get() {
        return DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory.provideDeliveryChargesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

