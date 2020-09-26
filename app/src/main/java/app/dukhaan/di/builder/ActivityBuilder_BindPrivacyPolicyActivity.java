/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindPrivacyPolicyActivity$PrivacyPolicyActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindPrivacyPolicyActivity$PrivacyPolicyActivitySubcomponent$Factory
 *  app.dukhaan.ui.privacy.PrivacyPolicyActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindPrivacyPolicyActivity;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindPrivacyPolicyActivity$PrivacyPolicyActivitySubcomponent;"})
public abstract class ActivityBuilder_BindPrivacyPolicyActivity {
    private ActivityBuilder_BindPrivacyPolicyActivity() {
    }

    @Binds
    @ClassKey(value=PrivacyPolicyActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

