/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditProductActivity$EditProductActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditProductActivity$EditProductActivitySubcomponent$Factory
 *  app.dukhaan.ui.editproduct.EditProductActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindEditProductActivity;
import app.dukhaan.ui.editproduct.EditProductActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindEditProductActivity$EditProductActivitySubcomponent;"})
public abstract class ActivityBuilder_BindEditProductActivity {
    private ActivityBuilder_BindEditProductActivity() {
    }

    @Binds
    @ClassKey(value=EditProductActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

