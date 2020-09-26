/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindBusinessDetailsActivity$AddBusinessActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindBusinessDetailsActivity$AddBusinessActivitySubcomponent$Factory
 *  app.dukhaan.ui.addbusiness.AddBusinessActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindBusinessDetailsActivity;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindBusinessDetailsActivity$AddBusinessActivitySubcomponent;"})
public abstract class ActivityBuilder_BindBusinessDetailsActivity {
    private ActivityBuilder_BindBusinessDetailsActivity() {
    }

    @Binds
    @ClassKey(value=AddBusinessActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

