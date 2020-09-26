/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindOnBoardingActivity$OnBoardingActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindOnBoardingActivity$OnBoardingActivitySubcomponent$Factory
 *  app.dukhaan.ui.onboarding.OnBoardingActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindOnBoardingActivity;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindOnBoardingActivity$OnBoardingActivitySubcomponent;"})
public abstract class ActivityBuilder_BindOnBoardingActivity {
    private ActivityBuilder_BindOnBoardingActivity() {
    }

    @Binds
    @ClassKey(value=OnBoardingActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

