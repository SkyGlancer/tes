/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindCatalogueFragment$CatalogueFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindCatalogueFragment$CatalogueFragmentSubcomponent$Factory
 *  app.dukhaan.ui.catalogue.CatalogueFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindCatalogueFragment;
import app.dukhaan.ui.catalogue.CatalogueFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindCatalogueFragment$CatalogueFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindCatalogueFragment {
    private ActivityBuilder_BindCatalogueFragment() {
    }

    @Binds
    @ClassKey(value=CatalogueFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

