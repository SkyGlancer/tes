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
package app.dukhaan.ui.editbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.editbusiness.EditBusinessModule;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditBusinessModule_BusinessEditDetailsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final EditBusinessModule module;
    private final Provider<EditBusinessViewModel> viewModelProvider;

    public EditBusinessModule_BusinessEditDetailsViewModelProviderFactory(EditBusinessModule editBusinessModule, Provider<EditBusinessViewModel> provider) {
        this.module = editBusinessModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory businessEditDetailsViewModelProvider(EditBusinessModule editBusinessModule, EditBusinessViewModel editBusinessViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)editBusinessModule.businessEditDetailsViewModelProvider(editBusinessViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static EditBusinessModule_BusinessEditDetailsViewModelProviderFactory create(EditBusinessModule editBusinessModule, Provider<EditBusinessViewModel> provider) {
        return new EditBusinessModule_BusinessEditDetailsViewModelProviderFactory(editBusinessModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return EditBusinessModule_BusinessEditDetailsViewModelProviderFactory.businessEditDetailsViewModelProvider(this.module, (EditBusinessViewModel)((Object)this.viewModelProvider.get()));
    }
}

