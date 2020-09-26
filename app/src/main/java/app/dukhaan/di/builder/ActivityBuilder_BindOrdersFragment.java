/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrdersFragment$OrdersFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrdersFragment$OrdersFragmentSubcomponent$Factory
 *  app.dukhaan.ui.orders.OrdersFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindOrdersFragment;
import app.dukhaan.ui.orders.OrdersFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindOrdersFragment$OrdersFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindOrdersFragment {
    private ActivityBuilder_BindOrdersFragment() {
    }

    @Binds
    @ClassKey(value=OrdersFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

