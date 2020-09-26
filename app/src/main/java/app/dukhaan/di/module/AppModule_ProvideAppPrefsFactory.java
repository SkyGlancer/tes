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

import app.dukhaan.data.local.AppPref;
import app.dukhaan.di.module.AppModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideAppPrefsFactory
implements Factory<AppPref> {
    private final AppModule module;

    public AppModule_ProvideAppPrefsFactory(AppModule appModule) {
        this.module = appModule;
    }

    public static AppModule_ProvideAppPrefsFactory create(AppModule appModule) {
        return new AppModule_ProvideAppPrefsFactory(appModule);
    }

    public static AppPref provideAppPrefs(AppModule appModule) {
        return (AppPref)Preconditions.checkNotNull((Object)appModule.provideAppPrefs(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public AppPref get() {
        return AppModule_ProvideAppPrefsFactory.provideAppPrefs(this.module);
    }
}

