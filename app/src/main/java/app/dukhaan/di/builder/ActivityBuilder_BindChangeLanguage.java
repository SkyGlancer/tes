/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindChangeLanguage$ChangeLanguageActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindChangeLanguage$ChangeLanguageActivitySubcomponent$Factory
 *  app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindChangeLanguage;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindChangeLanguage$ChangeLanguageActivitySubcomponent;"})
public abstract class ActivityBuilder_BindChangeLanguage {
    private ActivityBuilder_BindChangeLanguage() {
    }

    @Binds
    @ClassKey(value=ChangeLanguageActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

