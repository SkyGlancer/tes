/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.privacy;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.privacy.PrivacyPolicyModule;
import app.dukhaan.ui.privacy.PrivacyPolicyViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final PrivacyPolicyModule module;
    private final Provider<PrivacyPolicyViewModel> viewModelProvider;

    public PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory(PrivacyPolicyModule privacyPolicyModule, Provider<PrivacyPolicyViewModel> provider) {
        this.module = privacyPolicyModule;
        this.viewModelProvider = provider;
    }

    public static PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory create(PrivacyPolicyModule privacyPolicyModule, Provider<PrivacyPolicyViewModel> provider) {
        return new PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory(privacyPolicyModule, provider);
    }

    public static ViewModelProvider.Factory privacyPolicyViewModelProvider(PrivacyPolicyModule privacyPolicyModule, PrivacyPolicyViewModel privacyPolicyViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)privacyPolicyModule.privacyPolicyViewModelProvider(privacyPolicyViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return PrivacyPolicyModule_PrivacyPolicyViewModelProviderFactory.privacyPolicyViewModelProvider(this.module, (PrivacyPolicyViewModel)((Object)this.viewModelProvider.get()));
    }
}

