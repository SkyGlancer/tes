/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindCategoryDetailActivity$CategoryDetailActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindCategoryDetailActivity$CategoryDetailActivitySubcomponent$Factory
 *  app.dukhaan.ui.categorydetail.CategoryDetailActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindCategoryDetailActivity;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindCategoryDetailActivity$CategoryDetailActivitySubcomponent;"})
public abstract class ActivityBuilder_BindCategoryDetailActivity {
    private ActivityBuilder_BindCategoryDetailActivity() {
    }

    @Binds
    @ClassKey(value=CategoryDetailActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

