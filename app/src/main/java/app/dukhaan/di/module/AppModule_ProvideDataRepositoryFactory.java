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

import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideDataRepositoryFactory
implements Factory<DataRepository> {
    private final Provider<AppPref> appPrefProvider;
    private final Provider<AppDatabase> databaseProvider;
    private final AppModule module;

    public AppModule_ProvideDataRepositoryFactory(AppModule appModule, Provider<AppDatabase> provider, Provider<AppPref> provider2) {
        this.module = appModule;
        this.databaseProvider = provider;
        this.appPrefProvider = provider2;
    }

    public static AppModule_ProvideDataRepositoryFactory create(AppModule appModule, Provider<AppDatabase> provider, Provider<AppPref> provider2) {
        return new AppModule_ProvideDataRepositoryFactory(appModule, provider, provider2);
    }

    public static DataRepository provideDataRepository(AppModule appModule, AppDatabase appDatabase, AppPref appPref) {
        return (DataRepository)Preconditions.checkNotNull((Object)appModule.provideDataRepository(appDatabase, appPref), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public DataRepository get() {
        return AppModule_ProvideDataRepositoryFactory.provideDataRepository(this.module, (AppDatabase)this.databaseProvider.get(), (AppPref)this.appPrefProvider.get());
    }
}

