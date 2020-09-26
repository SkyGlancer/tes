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
package app.dukhaan.ui.editbusiness;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editbusiness.EditBusinessModule;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory
implements Factory<EditBusinessViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final EditBusinessModule module;

    public EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory(EditBusinessModule editBusinessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = editBusinessModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory create(EditBusinessModule editBusinessModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory(editBusinessModule, provider, provider2);
    }

    public static EditBusinessViewModel provideBusinessEditDetailsViewModel(EditBusinessModule editBusinessModule, DataRepository dataRepository, ApiService apiService) {
        return (EditBusinessViewModel)((Object)Preconditions.checkNotNull((Object)((Object)editBusinessModule.provideBusinessEditDetailsViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public EditBusinessViewModel get() {
        return EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory.provideBusinessEditDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

