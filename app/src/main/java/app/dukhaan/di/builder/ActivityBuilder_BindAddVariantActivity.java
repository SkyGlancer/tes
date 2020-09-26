/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindAddVariantActivity$AddVariantActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindAddVariantActivity$AddVariantActivitySubcomponent$Factory
 *  app.dukhaan.ui.addvariant.AddVariantActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindAddVariantActivity;
import app.dukhaan.ui.addvariant.AddVariantActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindAddVariantActivity$AddVariantActivitySubcomponent;"})
public abstract class ActivityBuilder_BindAddVariantActivity {
    private ActivityBuilder_BindAddVariantActivity() {
    }

    @Binds
    @ClassKey(value=AddVariantActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

