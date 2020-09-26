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
package app.dukhaan.ui.categorydetail;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CategoryDetailActivity_MembersInjector
implements MembersInjector<CategoryDetailActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CategoryDetailActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<CategoryDetailActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new CategoryDetailActivity_MembersInjector(provider);
    }

    public void injectMembers(CategoryDetailActivity categoryDetailActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(categoryDetailActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

