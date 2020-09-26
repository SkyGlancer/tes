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

import app.dukhaan.data.local.AppDatabaseHelper;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideAppDatabaseHelperFactory
implements Factory<AppDatabaseHelper> {
    private final Provider<AppDatabaseHelper> appDatabaseHelperProvider;
    private final AppModule module;

    public AppModule_ProvideAppDatabaseHelperFactory(AppModule appModule, Provider<AppDatabaseHelper> provider) {
        this.module = appModule;
        this.appDatabaseHelperProvider = provider;
    }

    public static AppModule_ProvideAppDatabaseHelperFactory create(AppModule appModule, Provider<AppDatabaseHelper> provider) {
        return new AppModule_ProvideAppDatabaseHelperFactory(appModule, provider);
    }

    public static AppDatabaseHelper provideAppDatabaseHelper(AppModule appModule, AppDatabaseHelper appDatabaseHelper) {
        return (AppDatabaseHelper)Preconditions.checkNotNull((Object)appModule.provideAppDatabaseHelper(appDatabaseHelper), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppDatabaseHelper get() {
        return AppModule_ProvideAppDatabaseHelperFactory.provideAppDatabaseHelper(this.module, (AppDatabaseHelper)this.appDatabaseHelperProvider.get());
    }
}

