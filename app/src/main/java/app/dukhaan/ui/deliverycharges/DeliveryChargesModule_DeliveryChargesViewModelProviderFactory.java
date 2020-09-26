/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.deliverycharges;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.deliverycharges.DeliveryChargesModule;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DeliveryChargesModule_DeliveryChargesViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final DeliveryChargesModule module;
    private final Provider<DeliveryChargesViewModel> viewModelProvider;

    public DeliveryChargesModule_DeliveryChargesViewModelProviderFactory(DeliveryChargesModule deliveryChargesModule, Provider<DeliveryChargesViewModel> provider) {
        this.module = deliveryChargesModule;
        this.viewModelProvider = provider;
    }

    public static DeliveryChargesModule_DeliveryChargesViewModelProviderFactory create(DeliveryChargesModule deliveryChargesModule, Provider<DeliveryChargesViewModel> provider) {
        return new DeliveryChargesModule_DeliveryChargesViewModelProviderFactory(deliveryChargesModule, provider);
    }

    public static ViewModelProvider.Factory deliveryChargesViewModelProvider(DeliveryChargesModule deliveryChargesModule, DeliveryChargesViewModel deliveryChargesViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)deliveryChargesModule.deliveryChargesViewModelProvider(deliveryChargesViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return DeliveryChargesModule_DeliveryChargesViewModelProviderFactory.deliveryChargesViewModelProvider(this.module, (DeliveryChargesViewModel)((Object)this.viewModelProvider.get()));
    }
}

