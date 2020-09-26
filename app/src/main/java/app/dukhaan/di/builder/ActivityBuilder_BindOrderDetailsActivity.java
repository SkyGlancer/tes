/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrderDetailsActivity$OrderDetailsActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindOrderDetailsActivity$OrderDetailsActivitySubcomponent$Factory
 *  app.dukhaan.ui.orderdetail.OrderDetailsActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindOrderDetailsActivity;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindOrderDetailsActivity$OrderDetailsActivitySubcomponent;"})
public abstract class ActivityBuilder_BindOrderDetailsActivity {
    private ActivityBuilder_BindOrderDetailsActivity() {
    }

    @Binds
    @ClassKey(value=OrderDetailsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

