/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.addresspicker;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.addresspicker.AddressPickerModule;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddressPickerModule_AddressViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final AddressPickerModule module;
    private final Provider<AddressViewModel> viewModelProvider;

    public AddressPickerModule_AddressViewModelProviderFactory(AddressPickerModule addressPickerModule, Provider<AddressViewModel> provider) {
        this.module = addressPickerModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory addressViewModelProvider(AddressPickerModule addressPickerModule, AddressViewModel addressViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)addressPickerModule.addressViewModelProvider(addressViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static AddressPickerModule_AddressViewModelProviderFactory create(AddressPickerModule addressPickerModule, Provider<AddressViewModel> provider) {
        return new AddressPickerModule_AddressViewModelProviderFactory(addressPickerModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return AddressPickerModule_AddressViewModelProviderFactory.addressViewModelProvider(this.module, (AddressViewModel)((Object)this.viewModelProvider.get()));
    }
}

