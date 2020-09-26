/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.di.module;

import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideAppDatabaseFactory
implements Factory<AppDatabase> {
    private final AppModule module;

    public AppModule_ProvideAppDatabaseFactory(AppModule appModule) {
        this.module = appModule;
    }

    public static AppModule_ProvideAppDatabaseFactory create(AppModule appModule) {
        return new AppModule_ProvideAppDatabaseFactory(appModule);
    }

    public static AppDatabase provideAppDatabase(AppModule appModule) {
        return (AppDatabase)Preconditions.checkNotNull((Object)appModule.provideAppDatabase(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppDatabase get() {
        return AppModule_ProvideAppDatabaseFactory.provideAppDatabase(this.module);
    }
}

