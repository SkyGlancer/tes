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
package app.dukhaan.ui.privacy;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PrivacyPolicyActivity_MembersInjector
implements MembersInjector<PrivacyPolicyActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public PrivacyPolicyActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<PrivacyPolicyActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new PrivacyPolicyActivity_MembersInjector(provider);
    }

    public void injectMembers(PrivacyPolicyActivity privacyPolicyActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(privacyPolicyActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

