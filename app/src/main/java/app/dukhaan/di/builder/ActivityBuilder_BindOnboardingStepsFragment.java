/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindOnboardingStepsFragment$OnboardingStepsFragmentSubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindOnboardingStepsFragment$OnboardingStepsFragmentSubcomponent$Factory
 *  app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindOnboardingStepsFragment;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindOnboardingStepsFragment$OnboardingStepsFragmentSubcomponent;"})
public abstract class ActivityBuilder_BindOnboardingStepsFragment {
    private ActivityBuilder_BindOnboardingStepsFragment() {
    }

    @Binds
    @ClassKey(value=OnboardingStepsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

