/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindVerifyMobileActivity$VerifyMobileActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindVerifyMobileActivity$VerifyMobileActivitySubcomponent$Factory
 *  app.dukhaan.ui.verifymobile.VerifyMobileActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindVerifyMobileActivity;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindVerifyMobileActivity$VerifyMobileActivitySubcomponent;"})
public abstract class ActivityBuilder_BindVerifyMobileActivity {
    private ActivityBuilder_BindVerifyMobileActivity() {
    }

    @Binds
    @ClassKey(value=VerifyMobileActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

