/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindCreateCategoryActivity$CreateCategoryActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindCreateCategoryActivity$CreateCategoryActivitySubcomponent$Factory
 *  app.dukhaan.ui.createcategory.CreateCategoryActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindCreateCategoryActivity;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindCreateCategoryActivity$CreateCategoryActivitySubcomponent;"})
public abstract class ActivityBuilder_BindCreateCategoryActivity {
    private ActivityBuilder_BindCreateCategoryActivity() {
    }

    @Binds
    @ClassKey(value=CreateCategoryActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

