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
package app.dukhaan.ui.addvariant;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.addvariant.AddVariantModule;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddVariantModule_AddVariantsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final AddVariantModule module;
    private final Provider<AddVariantViewModel> viewModelProvider;

    public AddVariantModule_AddVariantsViewModelProviderFactory(AddVariantModule addVariantModule, Provider<AddVariantViewModel> provider) {
        this.module = addVariantModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory addVariantsViewModelProvider(AddVariantModule addVariantModule, AddVariantViewModel addVariantViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)addVariantModule.addVariantsViewModelProvider(addVariantViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static AddVariantModule_AddVariantsViewModelProviderFactory create(AddVariantModule addVariantModule, Provider<AddVariantViewModel> provider) {
        return new AddVariantModule_AddVariantsViewModelProviderFactory(addVariantModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return AddVariantModule_AddVariantsViewModelProviderFactory.addVariantsViewModelProvider(this.module, (AddVariantViewModel)((Object)this.viewModelProvider.get()));
    }
}

