/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindSyncContactsActivity$SyncContactsActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindSyncContactsActivity$SyncContactsActivitySubcomponent$Factory
 *  app.dukhaan.ui.sync_contacts.SyncContactsActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindSyncContactsActivity;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindSyncContactsActivity$SyncContactsActivitySubcomponent;"})
public abstract class ActivityBuilder_BindSyncContactsActivity {
    private ActivityBuilder_BindSyncContactsActivity() {
    }

    @Binds
    @ClassKey(value=SyncContactsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

