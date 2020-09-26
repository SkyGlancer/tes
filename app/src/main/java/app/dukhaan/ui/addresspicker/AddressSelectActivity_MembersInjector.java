/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.addresspicker;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddressSelectActivity_MembersInjector
implements MembersInjector<AddressSelectActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AddressSelectActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<AddressSelectActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new AddressSelectActivity_MembersInjector(provider);
    }

    public void injectMembers(AddressSelectActivity addressSelectActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(addressSelectActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

