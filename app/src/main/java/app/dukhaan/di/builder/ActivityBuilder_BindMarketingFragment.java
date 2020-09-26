/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindMarketingFragment$MarketingFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindMarketingFragment$MarketingFragmentSubcomponent$Factory
 *  app.dukhaan.ui.marketing.MarketingFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindMarketingFragment;
import app.dukhaan.ui.marketing.MarketingFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindMarketingFragment$MarketingFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindMarketingFragment {
    private ActivityBuilder_BindMarketingFragment() {
    }

    @Binds
    @ClassKey(value=MarketingFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

