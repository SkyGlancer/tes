/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindWAStoriesActivity$WAStoriesActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindWAStoriesActivity$WAStoriesActivitySubcomponent$Factory
 *  app.dukhaan.ui.wastories.WAStoriesActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindWAStoriesActivity;
import app.dukhaan.ui.wastories.WAStoriesActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindWAStoriesActivity$WAStoriesActivitySubcomponent;"})
public abstract class ActivityBuilder_BindWAStoriesActivity {
    private ActivityBuilder_BindWAStoriesActivity() {
    }

    @Binds
    @ClassKey(value=WAStoriesActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

