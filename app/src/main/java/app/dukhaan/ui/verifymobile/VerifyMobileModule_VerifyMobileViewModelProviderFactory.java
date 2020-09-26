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
package app.dukhaan.ui.verifymobile;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.verifymobile.VerifyMobileModule;
import app.dukhaan.ui.verifymobile.VerifyMobileViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyMobileModule_VerifyMobileViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final VerifyMobileModule module;
    private final Provider<VerifyMobileViewModel> viewModelProvider;

    public VerifyMobileModule_VerifyMobileViewModelProviderFactory(VerifyMobileModule verifyMobileModule, Provider<VerifyMobileViewModel> provider) {
        this.module = verifyMobileModule;
        this.viewModelProvider = provider;
    }

    public static VerifyMobileModule_VerifyMobileViewModelProviderFactory create(VerifyMobileModule verifyMobileModule, Provider<VerifyMobileViewModel> provider) {
        return new VerifyMobileModule_VerifyMobileViewModelProviderFactory(verifyMobileModule, provider);
    }

    public static ViewModelProvider.Factory verifyMobileViewModelProvider(VerifyMobileModule verifyMobileModule, VerifyMobileViewModel verifyMobileViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)verifyMobileModule.verifyMobileViewModelProvider(verifyMobileViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return VerifyMobileModule_VerifyMobileViewModelProviderFactory.verifyMobileViewModelProvider(this.module, (VerifyMobileViewModel)((Object)this.viewModelProvider.get()));
    }
}

