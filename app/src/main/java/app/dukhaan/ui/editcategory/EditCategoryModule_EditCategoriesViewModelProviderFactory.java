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
package app.dukhaan.ui.editcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditCategoryModule_EditCategoriesViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final EditCategoryModule module;
    private final Provider<EditCategoriesViewModel> viewModelProvider;

    public EditCategoryModule_EditCategoriesViewModelProviderFactory(EditCategoryModule editCategoryModule, Provider<EditCategoriesViewModel> provider) {
        this.module = editCategoryModule;
        this.viewModelProvider = provider;
    }

    public static EditCategoryModule_EditCategoriesViewModelProviderFactory create(EditCategoryModule editCategoryModule, Provider<EditCategoriesViewModel> provider) {
        return new EditCategoryModule_EditCategoriesViewModelProviderFactory(editCategoryModule, provider);
    }

    public static ViewModelProvider.Factory editCategoriesViewModelProvider(EditCategoryModule editCategoryModule, EditCategoriesViewModel editCategoriesViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)editCategoryModule.editCategoriesViewModelProvider(editCategoriesViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return EditCategoryModule_EditCategoriesViewModelProviderFactory.editCategoriesViewModelProvider(this.module, (EditCategoriesViewModel)((Object)this.viewModelProvider.get()));
    }
}

