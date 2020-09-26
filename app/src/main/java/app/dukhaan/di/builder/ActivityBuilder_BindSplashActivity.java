/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindSplashActivity$SplashActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindSplashActivity$SplashActivitySubcomponent$Factory
 *  app.dukhaan.ui.splash.SplashActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindSplashActivity;
import app.dukhaan.ui.splash.SplashActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindSplashActivity$SplashActivitySubcomponent;"})
public abstract class ActivityBuilder_BindSplashActivity {
    private ActivityBuilder_BindSplashActivity() {
    }

    @Binds
    @ClassKey(value=SplashActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

