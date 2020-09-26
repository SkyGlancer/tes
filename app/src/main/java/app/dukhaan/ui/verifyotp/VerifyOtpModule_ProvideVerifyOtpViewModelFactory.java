/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.verifyotp;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.verifyotp.VerifyOtpModule;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VerifyOtpModule_ProvideVerifyOtpViewModelFactory
implements Factory<VerifyOtpViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final VerifyOtpModule module;

    public VerifyOtpModule_ProvideVerifyOtpViewModelFactory(VerifyOtpModule verifyOtpModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = verifyOtpModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static VerifyOtpModule_ProvideVerifyOtpViewModelFactory create(VerifyOtpModule verifyOtpModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new VerifyOtpModule_ProvideVerifyOtpViewModelFactory(verifyOtpModule, provider, provider2);
    }

    public static VerifyOtpViewModel provideVerifyOtpViewModel(VerifyOtpModule verifyOtpModule, DataRepository dataRepository, ApiService apiService) {
        return (VerifyOtpViewModel)((Object)Preconditions.checkNotNull((Object)((Object)verifyOtpModule.provideVerifyOtpViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public VerifyOtpViewModel get() {
        return VerifyOtpModule_ProvideVerifyOtpViewModelFactory.provideVerifyOtpViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

