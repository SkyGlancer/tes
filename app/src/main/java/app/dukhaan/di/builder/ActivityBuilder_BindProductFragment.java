/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindProductFragment$ProductsFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindProductFragment$ProductsFragmentSubcomponent$Factory
 *  app.dukhaan.ui.products.ProductsFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindProductFragment;
import app.dukhaan.ui.products.ProductsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindProductFragment$ProductsFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindProductFragment {
    private ActivityBuilder_BindProductFragment() {
    }

    @Binds
    @ClassKey(value=ProductsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

