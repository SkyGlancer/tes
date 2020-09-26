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
package app.dukhaan.ui.addbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.addbusiness.AddBusinessModule;
import app.dukhaan.ui.addbusiness.AddBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddBusinessModule_BusinessDetailsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final AddBusinessModule module;
    private final Provider<AddBusinessViewModel> viewModelProvider;

    public AddBusinessModule_BusinessDetailsViewModelProviderFactory(AddBusinessModule addBusinessModule, Provider<AddBusinessViewModel> provider) {
        this.module = addBusinessModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory businessDetailsViewModelProvider(AddBusinessModule addBusinessModule, AddBusinessViewModel addBusinessViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)addBusinessModule.businessDetailsViewModelProvider(addBusinessViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static AddBusinessModule_BusinessDetailsViewModelProviderFactory create(AddBusinessModule addBusinessModule, Provider<AddBusinessViewModel> provider) {
        return new AddBusinessModule_BusinessDetailsViewModelProviderFactory(addBusinessModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return AddBusinessModule_BusinessDetailsViewModelProviderFactory.businessDetailsViewModelProvider(this.module, (AddBusinessViewModel)((Object)this.viewModelProvider.get()));
    }
}

