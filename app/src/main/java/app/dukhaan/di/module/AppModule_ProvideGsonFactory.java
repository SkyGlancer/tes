/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.di.module;

import app.dukhaan.di.module.AppModule;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideGsonFactory
implements Factory<Gson> {
    private final AppModule module;

    public AppModule_ProvideGsonFactory(AppModule appModule) {
        this.module = appModule;
    }

    public static AppModule_ProvideGsonFactory create(AppModule appModule) {
        return new AppModule_ProvideGsonFactory(appModule);
    }

    public static Gson provideGson(AppModule appModule) {
        return (Gson)Preconditions.checkNotNull((Object)appModule.provideGson(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public Gson get() {
        return AppModule_ProvideGsonFactory.provideGson(this.module);
    }
}

