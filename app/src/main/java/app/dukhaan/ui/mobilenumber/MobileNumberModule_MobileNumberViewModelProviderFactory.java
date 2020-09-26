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
package app.dukhaan.ui.mobilenumber;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.mobilenumber.MobileNumberModule;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MobileNumberModule_MobileNumberViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final MobileNumberModule module;
    private final Provider<MobileNumberViewModel> viewModelProvider;

    public MobileNumberModule_MobileNumberViewModelProviderFactory(MobileNumberModule mobileNumberModule, Provider<MobileNumberViewModel> provider) {
        this.module = mobileNumberModule;
        this.viewModelProvider = provider;
    }

    public static MobileNumberModule_MobileNumberViewModelProviderFactory create(MobileNumberModule mobileNumberModule, Provider<MobileNumberViewModel> provider) {
        return new MobileNumberModule_MobileNumberViewModelProviderFactory(mobileNumberModule, provider);
    }

    public static ViewModelProvider.Factory mobileNumberViewModelProvider(MobileNumberModule mobileNumberModule, MobileNumberViewModel mobileNumberViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)mobileNumberModule.mobileNumberViewModelProvider(mobileNumberViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return MobileNumberModule_MobileNumberViewModelProviderFactory.mobileNumberViewModelProvider(this.module, (MobileNumberViewModel)((Object)this.viewModelProvider.get()));
    }
}

