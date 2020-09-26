/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.di.builder.ActivityBuilder_BindReportIssueActivity$ReportIssueActivitySubcomponent
 *  app.dukhaan.di.builder.ActivityBuilder_BindReportIssueActivity$ReportIssueActivitySubcomponent$Factory
 *  app.dukhaan.ui.reportissue.ReportIssueActivity
 *  dagger.Binds
 *  dagger.Module
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.multibindings.ClassKey
 *  dagger.multibindings.IntoMap
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.di.builder.ActivityBuilder_BindReportIssueActivity;
import app.dukhaan.ui.reportissue.ReportIssueActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents={"Lapp/dukhaan/di/builder/ActivityBuilder_BindReportIssueActivity$ReportIssueActivitySubcomponent;"})
public abstract class ActivityBuilder_BindReportIssueActivity {
    private ActivityBuilder_BindReportIssueActivity() {
    }

    @Binds
    @ClassKey(value=ReportIssueActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(Factory var1);
}

