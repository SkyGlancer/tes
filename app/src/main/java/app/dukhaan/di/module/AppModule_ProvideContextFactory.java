/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.di.module;

import android.app.Application;
import android.content.Context;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideContextFactory
implements Factory<Context> {
    private final Provider<Application> applicationProvider;
    private final AppModule module;

    public AppModule_ProvideContextFactory(AppModule appModule, Provider<Application> provider) {
        this.module = appModule;
        this.applicationProvider = provider;
    }

    public static AppModule_ProvideContextFactory create(AppModule appModule, Provider<Application> provider) {
        return new AppModule_ProvideContextFactory(appModule, provider);
    }

    public static Context provideContext(AppModule appModule, Application application) {
        return (Context)Preconditions.checkNotNull((Object)appModule.provideContext(application), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public Context get() {
        return AppModule_ProvideContextFactory.provideContext(this.module, (Application)this.applicationProvider.get());
    }
}

