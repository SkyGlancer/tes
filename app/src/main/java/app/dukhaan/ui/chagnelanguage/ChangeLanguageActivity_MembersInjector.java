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
package app.dukhaan.ui.chagnelanguage;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChangeLanguageActivity_MembersInjector
implements MembersInjector<ChangeLanguageActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ChangeLanguageActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<ChangeLanguageActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new ChangeLanguageActivity_MembersInjector(provider);
    }

    public void injectMembers(ChangeLanguageActivity changeLanguageActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(changeLanguageActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

