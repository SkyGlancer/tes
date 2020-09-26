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
package app.dukhaan.ui.goldsuccess;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.goldsuccess.GoldSuccessModule;
import app.dukhaan.ui.goldsuccess.GoldSuccessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoldSuccessModule_GoldSuccessViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final GoldSuccessModule module;
    private final Provider<GoldSuccessViewModel> viewModelProvider;

    public GoldSuccessModule_GoldSuccessViewModelProviderFactory(GoldSuccessModule goldSuccessModule, Provider<GoldSuccessViewModel> provider) {
        this.module = goldSuccessModule;
        this.viewModelProvider = provider;
    }

    public static GoldSuccessModule_GoldSuccessViewModelProviderFactory create(GoldSuccessModule goldSuccessModule, Provider<GoldSuccessViewModel> provider) {
        return new GoldSuccessModule_GoldSuccessViewModelProviderFactory(goldSuccessModule, provider);
    }

    public static ViewModelProvider.Factory goldSuccessViewModelProvider(GoldSuccessModule goldSuccessModule, GoldSuccessViewModel goldSuccessViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)goldSuccessModule.goldSuccessViewModelProvider(goldSuccessViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return GoldSuccessModule_GoldSuccessViewModelProviderFactory.goldSuccessViewModelProvider(this.module, (GoldSuccessViewModel)((Object)this.viewModelProvider.get()));
    }
}

