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
package app.dukhaan.ui.verifyotp;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.verifyotp.VerifyOtpModule;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyOtpModule_VerifyOtpViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final VerifyOtpModule module;
    private final Provider<VerifyOtpViewModel> viewModelProvider;

    public VerifyOtpModule_VerifyOtpViewModelProviderFactory(VerifyOtpModule verifyOtpModule, Provider<VerifyOtpViewModel> provider) {
        this.module = verifyOtpModule;
        this.viewModelProvider = provider;
    }

    public static VerifyOtpModule_VerifyOtpViewModelProviderFactory create(VerifyOtpModule verifyOtpModule, Provider<VerifyOtpViewModel> provider) {
        return new VerifyOtpModule_VerifyOtpViewModelProviderFactory(verifyOtpModule, provider);
    }

    public static ViewModelProvider.Factory verifyOtpViewModelProvider(VerifyOtpModule verifyOtpModule, VerifyOtpViewModel verifyOtpViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)verifyOtpModule.verifyOtpViewModelProvider(verifyOtpViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return VerifyOtpModule_VerifyOtpViewModelProviderFactory.verifyOtpViewModelProvider(this.module, (VerifyOtpViewModel)((Object)this.viewModelProvider.get()));
    }
}

