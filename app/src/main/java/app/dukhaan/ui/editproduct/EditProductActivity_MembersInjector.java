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
package app.dukhaan.ui.editproduct;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editproduct.EditProductActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditProductActivity_MembersInjector
implements MembersInjector<EditProductActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public EditProductActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<EditProductActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new EditProductActivity_MembersInjector(provider);
    }

    public void injectMembers(EditProductActivity editProductActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(editProductActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

