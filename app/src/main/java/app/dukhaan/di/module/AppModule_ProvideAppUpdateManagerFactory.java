/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.play.core.appupdate.AppUpdateManager
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.di.module;

import android.content.Context;
import app.dukhaan.di.module.AppModule;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideAppUpdateManagerFactory
implements Factory<AppUpdateManager> {
    private final Provider<Context> contextProvider;
    private final AppModule module;

    public AppModule_ProvideAppUpdateManagerFactory(AppModule appModule, Provider<Context> provider) {
        this.module = appModule;
        this.contextProvider = provider;
    }

    public static AppModule_ProvideAppUpdateManagerFactory create(AppModule appModule, Provider<Context> provider) {
        return new AppModule_ProvideAppUpdateManagerFactory(appModule, provider);
    }

    public static AppUpdateManager provideAppUpdateManager(AppModule appModule, Context context) {
        return (AppUpdateManager)Preconditions.checkNotNull((Object)appModule.provideAppUpdateManager(context), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppUpdateManager get() {
        return AppModule_ProvideAppUpdateManagerFactory.provideAppUpdateManager(this.module, (Context)this.contextProvider.get());
    }
}

