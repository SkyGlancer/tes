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
package app.dukhaan.ui.editbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditBusinessActivity_MembersInjector
implements MembersInjector<EditBusinessActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public EditBusinessActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<EditBusinessActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new EditBusinessActivity_MembersInjector(provider);
    }

    public void injectMembers(EditBusinessActivity editBusinessActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(editBusinessActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

