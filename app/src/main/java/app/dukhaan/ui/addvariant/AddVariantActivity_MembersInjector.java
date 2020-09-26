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
package app.dukhaan.ui.addvariant;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addvariant.AddVariantActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddVariantActivity_MembersInjector
implements MembersInjector<AddVariantActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AddVariantActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<AddVariantActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new AddVariantActivity_MembersInjector(provider);
    }

    public void injectMembers(AddVariantActivity addVariantActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(addVariantActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

