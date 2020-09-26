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
package app.dukhaan.ui.deliverycharges;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DeliveryChargesActivity_MembersInjector
implements MembersInjector<DeliveryChargesActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public DeliveryChargesActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<DeliveryChargesActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new DeliveryChargesActivity_MembersInjector(provider);
    }

    public void injectMembers(DeliveryChargesActivity deliveryChargesActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(deliveryChargesActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

