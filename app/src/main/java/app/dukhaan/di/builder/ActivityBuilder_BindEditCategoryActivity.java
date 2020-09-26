/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditCategoryActivity$EditCategoryActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindEditCategoryActivity$EditCategoryActivitySubcomponent$Factory
 *  app.dukhaan.ui.editcategory.EditCategoryActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindEditCategoryActivity;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindEditCategoryActivity$EditCategoryActivitySubcomponent;"})
public abstract class ActivityBuilder_BindEditCategoryActivity {
    private ActivityBuilder_BindEditCategoryActivity() {
    }

    @Binds
    @ClassKey(value=EditCategoryActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

