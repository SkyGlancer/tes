/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindCategoryFragment$CategoriesFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindCategoryFragment$CategoriesFragmentSubcomponent$Factory
 *  app.dukhaan.ui.categories.CategoriesFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindCategoryFragment;
import app.dukhaan.ui.categories.CategoriesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindCategoryFragment$CategoriesFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindCategoryFragment {
    private ActivityBuilder_BindCategoryFragment() {
    }

    @Binds
    @ClassKey(value=CategoriesFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

