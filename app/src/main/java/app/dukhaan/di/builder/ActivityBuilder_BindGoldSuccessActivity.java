/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindGoldSuccessActivity$GoldSuccessActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindGoldSuccessActivity$GoldSuccessActivitySubcomponent$Factory
 *  app.dukhaan.ui.goldsuccess.GoldSuccessActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindGoldSuccessActivity;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindGoldSuccessActivity$GoldSuccessActivitySubcomponent;"})
public abstract class ActivityBuilder_BindGoldSuccessActivity {
    private ActivityBuilder_BindGoldSuccessActivity() {
    }

    @Binds
    @ClassKey(value=GoldSuccessActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

