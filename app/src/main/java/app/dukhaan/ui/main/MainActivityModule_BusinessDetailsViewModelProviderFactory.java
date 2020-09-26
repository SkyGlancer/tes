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
package app.dukhaan.ui.main;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.main.MainActivityModule;
import app.dukhaan.ui.main.MainActivityViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainActivityModule_BusinessDetailsViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final MainActivityModule module;
    private final Provider<MainActivityViewModel> viewModelProvider;

    public MainActivityModule_BusinessDetailsViewModelProviderFactory(MainActivityModule mainActivityModule, Provider<MainActivityViewModel> provider) {
        this.module = mainActivityModule;
        this.viewModelProvider = provider;
    }

    public static ViewModelProvider.Factory businessDetailsViewModelProvider(MainActivityModule mainActivityModule, MainActivityViewModel mainActivityViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)mainActivityModule.businessDetailsViewModelProvider(mainActivityViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public static MainActivityModule_BusinessDetailsViewModelProviderFactory create(MainActivityModule mainActivityModule, Provider<MainActivityViewModel> provider) {
        return new MainActivityModule_BusinessDetailsViewModelProviderFactory(mainActivityModule, provider);
    }

    public ViewModelProvider.Factory get() {
        return MainActivityModule_BusinessDetailsViewModelProviderFactory.businessDetailsViewModelProvider(this.module, (MainActivityViewModel)((Object)this.viewModelProvider.get()));
    }
}

