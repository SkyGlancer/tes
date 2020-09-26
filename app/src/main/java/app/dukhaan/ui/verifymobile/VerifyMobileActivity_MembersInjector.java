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
package app.dukhaan.ui.verifymobile;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VerifyMobileActivity_MembersInjector
implements MembersInjector<VerifyMobileActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public VerifyMobileActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<VerifyMobileActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new VerifyMobileActivity_MembersInjector(provider);
    }

    public void injectMembers(VerifyMobileActivity verifyMobileActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(verifyMobileActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

