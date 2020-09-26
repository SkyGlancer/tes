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
package app.dukhaan.ui.addresspicker;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addresspicker.AddressPickerModule;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddressPickerModule_ProvideAddressViewModelFactory
implements Factory<AddressViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final AddressPickerModule module;

    public AddressPickerModule_ProvideAddressViewModelFactory(AddressPickerModule addressPickerModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = addressPickerModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static AddressPickerModule_ProvideAddressViewModelFactory create(AddressPickerModule addressPickerModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new AddressPickerModule_ProvideAddressViewModelFactory(addressPickerModule, provider, provider2);
    }

    public static AddressViewModel provideAddressViewModel(AddressPickerModule addressPickerModule, DataRepository dataRepository, ApiService apiService) {
        return (AddressViewModel)((Object)Preconditions.checkNotNull((Object)((Object)addressPickerModule.provideAddressViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public AddressViewModel get() {
        return AddressPickerModule_ProvideAddressViewModelFactory.provideAddressViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

