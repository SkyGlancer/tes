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
package app.dukhaan.ui.goldsuccess;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GoldSuccessActivity_MembersInjector
implements MembersInjector<GoldSuccessActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public GoldSuccessActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<GoldSuccessActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new GoldSuccessActivity_MembersInjector(provider);
    }

    public void injectMembers(GoldSuccessActivity goldSuccessActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(goldSuccessActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

