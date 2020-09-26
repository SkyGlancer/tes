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
package app.dukhaan.ui.editcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditCategoryActivity_MembersInjector
implements MembersInjector<EditCategoryActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public EditCategoryActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<EditCategoryActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new EditCategoryActivity_MembersInjector(provider);
    }

    public void injectMembers(EditCategoryActivity editCategoryActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(editCategoryActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

