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
package app.dukhaan.ui.addbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddBusinessActivity_MembersInjector
implements MembersInjector<AddBusinessActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AddBusinessActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<AddBusinessActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new AddBusinessActivity_MembersInjector(provider);
    }

    public void injectMembers(AddBusinessActivity addBusinessActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(addBusinessActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

