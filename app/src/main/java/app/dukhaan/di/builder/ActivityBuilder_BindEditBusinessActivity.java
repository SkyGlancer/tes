/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditBusinessActivity$EditBusinessActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditBusinessActivity$EditBusinessActivitySubcomponent$Factory
 *  app.dukhaan.ui.editbusiness.EditBusinessActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindEditBusinessActivity;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindEditBusinessActivity$EditBusinessActivitySubcomponent;"})
public abstract class ActivityBuilder_BindEditBusinessActivity {
    private ActivityBuilder_BindEditBusinessActivity() {
    }

    @Binds
    @ClassKey(value=EditBusinessActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

