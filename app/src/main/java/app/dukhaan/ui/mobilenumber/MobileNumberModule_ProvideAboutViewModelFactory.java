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
package app.dukhaan.ui.mobilenumber;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.mobilenumber.MobileNumberModule;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MobileNumberModule_ProvideAboutViewModelFactory
implements Factory<MobileNumberViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final MobileNumberModule module;

    public MobileNumberModule_ProvideAboutViewModelFactory(MobileNumberModule mobileNumberModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = mobileNumberModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static MobileNumberModule_ProvideAboutViewModelFactory create(MobileNumberModule mobileNumberModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new MobileNumberModule_ProvideAboutViewModelFactory(mobileNumberModule, provider, provider2);
    }

    public static MobileNumberViewModel provideAboutViewModel(MobileNumberModule mobileNumberModule, DataRepository dataRepository, ApiService apiService) {
        return (MobileNumberViewModel)((Object)Preconditions.checkNotNull((Object)((Object)mobileNumberModule.provideAboutViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public MobileNumberViewModel get() {
        return MobileNumberModule_ProvideAboutViewModelFactory.provideAboutViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

