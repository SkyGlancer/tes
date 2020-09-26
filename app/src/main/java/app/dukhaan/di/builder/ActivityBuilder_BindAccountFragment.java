/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindAccountFragment$AccountFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindAccountFragment$AccountFragmentSubcomponent$Factory
 *  app.dukhaan.ui.account.AccountFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindAccountFragment;
import app.dukhaan.ui.account.AccountFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindAccountFragment$AccountFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindAccountFragment {
    private ActivityBuilder_BindAccountFragment() {
    }

    @Binds
    @ClassKey(value=AccountFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

