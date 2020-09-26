/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  app.dukhaan.app.MyApplication
 *  dagger.BindsInstance
 *  dagger.Component
 *  dagger.Component$Builder
 *  java.lang.Object
 *  javax.inject.Singleton
 */
package app.dukhaan.di.component;

import android.app.Application;
import app.dukhaan.app.MyApplication;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={"Ldagger/android/AndroidInjectionModule;", "Lapp/dukhaan/di/module/AppModule;", "Lapp/dukhaan/di/builder/ActivityBuilder;"})
@Singleton
public interface AppComponent {
    public void inject(MyApplication var1);

    @Component.Builder
    public static interface Builder {
        @BindsInstance
        public Builder application(Application var1);

        public AppComponent build();
    }

}

