/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindMobileNumberActivity$MobileNumberActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindMobileNumberActivity$MobileNumberActivitySubcomponent$Factory
 *  app.dukhaan.ui.mobilenumber.MobileNumberActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindMobileNumberActivity;
import app.dukhaan.ui.mobilenumber.MobileNumberActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindMobileNumberActivity$MobileNumberActivitySubcomponent;"})
public abstract class ActivityBuilder_BindMobileNumberActivity {
    private ActivityBuilder_BindMobileNumberActivity() {
    }

    @Binds
    @ClassKey(value=MobileNumberActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

