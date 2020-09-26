/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindMainActivity$MainActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindMainActivity$MainActivitySubcomponent$Factory
 *  app.dukhaan.ui.main.MainActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindMainActivity;
import app.dukhaan.ui.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindMainActivity$MainActivitySubcomponent;"})
public abstract class ActivityBuilder_BindMainActivity {
    private ActivityBuilder_BindMainActivity() {
    }

    @Binds
    @ClassKey(value=MainActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

