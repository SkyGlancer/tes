/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindDeliveryChargesActivity$DeliveryChargesActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindDeliveryChargesActivity$DeliveryChargesActivitySubcomponent$Factory
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindDeliveryChargesActivity;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindDeliveryChargesActivity$DeliveryChargesActivitySubcomponent;"})
public abstract class ActivityBuilder_BindDeliveryChargesActivity {
    private ActivityBuilder_BindDeliveryChargesActivity() {
    }

    @Binds
    @ClassKey(value=DeliveryChargesActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

