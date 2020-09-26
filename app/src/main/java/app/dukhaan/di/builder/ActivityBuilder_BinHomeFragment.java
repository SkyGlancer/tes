/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BinHomeFragment$HomeFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BinHomeFragment$HomeFragmentSubcomponent$Factory
 *  app.dukhaan.ui.home.HomeFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BinHomeFragment;
import app.dukhaan.ui.home.HomeFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BinHomeFragment$HomeFragmentSubcomponent;"})
public abstract class ActivityBuilder_BinHomeFragment {
    private ActivityBuilder_BinHomeFragment() {
    }

    @Binds
    @ClassKey(value=HomeFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

