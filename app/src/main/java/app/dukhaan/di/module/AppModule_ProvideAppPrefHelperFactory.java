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
package app.dukhaan.di.module;

import app.dukhaan.data.local.AppPrefHelper;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideAppPrefHelperFactory
implements Factory<AppPrefHelper> {
    private final Provider<AppPrefHelper> appPrefHelperProvider;
    private final AppModule module;

    public AppModule_ProvideAppPrefHelperFactory(AppModule appModule, Provider<AppPrefHelper> provider) {
        this.module = appModule;
        this.appPrefHelperProvider = provider;
    }

    public static AppModule_ProvideAppPrefHelperFactory create(AppModule appModule, Provider<AppPrefHelper> provider) {
        return new AppModule_ProvideAppPrefHelperFactory(appModule, provider);
    }

    public static AppPrefHelper provideAppPrefHelper(AppModule appModule, AppPrefHelper appPrefHelper) {
        return (AppPrefHelper)Preconditions.checkNotNull((Object)appModule.provideAppPrefHelper(appPrefHelper), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppPrefHelper get() {
        return AppModule_ProvideAppPrefHelperFactory.provideAppPrefHelper(this.module, (AppPrefHelper)this.appPrefHelperProvider.get());
    }
}

