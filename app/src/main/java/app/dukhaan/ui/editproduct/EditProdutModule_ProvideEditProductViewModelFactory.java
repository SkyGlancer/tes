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
package app.dukhaan.ui.editproduct;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.editproduct.EditProdutModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditProdutModule_ProvideEditProductViewModelFactory
implements Factory<EditProductViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final EditProdutModule module;

    public EditProdutModule_ProvideEditProductViewModelFactory(EditProdutModule editProdutModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = editProdutModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static EditProdutModule_ProvideEditProductViewModelFactory create(EditProdutModule editProdutModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new EditProdutModule_ProvideEditProductViewModelFactory(editProdutModule, provider, provider2);
    }

    public static EditProductViewModel provideEditProductViewModel(EditProdutModule editProdutModule, DataRepository dataRepository, ApiService apiService) {
        return (EditProductViewModel)((Object)Preconditions.checkNotNull((Object)((Object)editProdutModule.provideEditProductViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public EditProductViewModel get() {
        return EditProdutModule_ProvideEditProductViewModelFactory.provideEditProductViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

