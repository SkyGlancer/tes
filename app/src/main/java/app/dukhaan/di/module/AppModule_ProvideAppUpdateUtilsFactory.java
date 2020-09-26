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

import app.dukhaan.di.module.AppModule;
import app.dukhaan.util.AppUpdateUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideAppUpdateUtilsFactory
implements Factory<AppUpdateUtils> {
    private final AppModule module;

    public AppModule_ProvideAppUpdateUtilsFactory(AppModule appModule) {
        this.module = appModule;
    }

    public static AppModule_ProvideAppUpdateUtilsFactory create(AppModule appModule) {
        return new AppModule_ProvideAppUpdateUtilsFactory(appModule);
    }

    public static AppUpdateUtils provideAppUpdateUtils(AppModule appModule) {
        return (AppUpdateUtils)Preconditions.checkNotNull((Object)appModule.provideAppUpdateUtils(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppUpdateUtils get() {
        return AppModule_ProvideAppUpdateUtilsFactory.provideAppUpdateUtils(this.module);
    }
}

