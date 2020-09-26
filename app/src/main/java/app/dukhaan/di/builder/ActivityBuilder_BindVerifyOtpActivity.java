/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindVerifyOtpActivity$VerifyOtpActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindVerifyOtpActivity$VerifyOtpActivitySubcomponent$Factory
 *  app.dukhaan.ui.verifyotp.VerifyOtpActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindVerifyOtpActivity;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindVerifyOtpActivity$VerifyOtpActivitySubcomponent;"})
public abstract class ActivityBuilder_BindVerifyOtpActivity {
    private ActivityBuilder_BindVerifyOtpActivity() {
    }

    @Binds
    @ClassKey(value=VerifyOtpActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

