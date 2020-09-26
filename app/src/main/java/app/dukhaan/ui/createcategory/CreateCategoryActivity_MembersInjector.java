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
package app.dukhaan.ui.createcategory;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CreateCategoryActivity_MembersInjector
implements MembersInjector<CreateCategoryActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CreateCategoryActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<CreateCategoryActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new CreateCategoryActivity_MembersInjector(provider);
    }

    public void injectMembers(CreateCategoryActivity createCategoryActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(createCategoryActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

