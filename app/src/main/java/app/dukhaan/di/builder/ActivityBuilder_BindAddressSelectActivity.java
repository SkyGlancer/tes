/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindAddressSelectActivity$AddressSelectActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindAddressSelectActivity$AddressSelectActivitySubcomponent$Factory
 *  app.dukhaan.ui.addresspicker.AddressSelectActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindAddressSelectActivity;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindAddressSelectActivity$AddressSelectActivitySubcomponent;"})
public abstract class ActivityBuilder_BindAddressSelectActivity {
    private ActivityBuilder_BindAddressSelectActivity() {
    }

    @Binds
    @ClassKey(value=AddressSelectActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

