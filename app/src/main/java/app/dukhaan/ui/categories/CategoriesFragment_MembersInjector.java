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
package app.dukhaan.ui.categories;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.categories.CategoriesFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CategoriesFragment_MembersInjector
implements MembersInjector<CategoriesFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CategoriesFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<CategoriesFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new CategoriesFragment_MembersInjector(provider);
    }

    public void injectMembers(CategoriesFragment categoriesFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(categoriesFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

