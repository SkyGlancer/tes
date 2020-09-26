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
package app.dukhaan.ui.editproduct;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.editproduct.EditProdutModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditProdutModule_EditProductViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final EditProdutModule module;
    private final Provider<EditProductViewModel> viewModelProvider;

    public EditProdutModule_EditProductViewModelProviderFactory(EditProdutModule editProdutModule, Provider<EditProductViewModel> provider) {
        this.module = editProdutModule;
        this.viewModelProvider = provider;
    }

    public static EditProdutModule_EditProductViewModelProviderFactory create(EditProdutModule editProdutModule, Provider<EditProductViewModel> provider) {
        return new EditProdutModule_EditProductViewModelProviderFactory(editProdutModule, provider);
    }

    public static ViewModelProvider.Factory editProductViewModelProvider(EditProdutModule editProdutModule, EditProductViewModel editProductViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)editProdutModule.editProductViewModelProvider(editProductViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return EditProdutModule_EditProductViewModelProviderFactory.editProductViewModelProvider(this.module, (EditProductViewModel)((Object)this.viewModelProvider.get()));
    }
}

