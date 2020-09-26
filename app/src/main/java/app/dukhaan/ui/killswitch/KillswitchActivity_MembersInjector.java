/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.killswitch;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class KillswitchActivity_MembersInjector
implements MembersInjector<KillswitchActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public KillswitchActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<KillswitchActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new KillswitchActivity_MembersInjector(provider);
    }

    public void injectMembers(KillswitchActivity killswitchActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(killswitchActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

