/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrdersListFragment$OrdersListFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrdersListFragment$OrdersListFragmentSubcomponent$Factory
 *  app.dukhaan.ui.orders_list.OrdersListFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindOrdersListFragment;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindOrdersListFragment$OrdersListFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindOrdersListFragment {
    private ActivityBuilder_BindOrdersListFragment() {
    }

    @Binds
    @ClassKey(value=OrdersListFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

