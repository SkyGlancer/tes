/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindKillswitchActivity$KillswitchActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindKillswitchActivity$KillswitchActivitySubcomponent$Factory
 *  app.dukhaan.ui.killswitch.KillswitchActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindKillswitchActivity;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindKillswitchActivity$KillswitchActivitySubcomponent;"})
public abstract class ActivityBuilder_BindKillswitchActivity {
    private ActivityBuilder_BindKillswitchActivity() {
    }

    @Binds
    @ClassKey(value=KillswitchActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

