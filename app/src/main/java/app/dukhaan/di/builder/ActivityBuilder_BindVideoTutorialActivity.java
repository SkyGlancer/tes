/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindVideoTutorialActivity$VideoTutorialsActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindVideoTutorialActivity$VideoTutorialsActivitySubcomponent$Factory
 *  app.dukhaan.ui.videotutorials.VideoTutorialsActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindVideoTutorialActivity;
import app.dukhaan.ui.videotutorials.VideoTutorialsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindVideoTutorialActivity$VideoTutorialsActivitySubcomponent;"})
public abstract class ActivityBuilder_BindVideoTutorialActivity {
    private ActivityBuilder_BindVideoTutorialActivity() {
    }

    @Binds
    @ClassKey(value=VideoTutorialsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

