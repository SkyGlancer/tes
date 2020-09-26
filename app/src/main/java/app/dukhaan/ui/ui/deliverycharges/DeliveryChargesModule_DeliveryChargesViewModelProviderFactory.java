package app.dukhaan.ui.ui.deliverycharges;

import app.dukhaan.ui.deliverycharges.DeliveryChargesModule;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DeliveryChargesModule_DeliveryChargesViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.deliverycharges.DeliveryChargesModule module;
   private final Provider<app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel> viewModelProvider;

   public DeliveryChargesModule_DeliveryChargesViewModelProviderFactory(app.dukhaan.ui.deliverycharges.DeliveryChargesModule var1, Provider<app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static DeliveryChargesModule_DeliveryChargesViewModelProviderFactory create(app.dukhaan.ui.deliverycharges.DeliveryChargesModule var0, Provider<app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel> var1) {
      return new DeliveryChargesModule_DeliveryChargesViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory deliveryChargesViewModelProvider(DeliveryChargesModule var0, app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.deliveryChargesViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return deliveryChargesViewModelProvider(this.module, (DeliveryChargesViewModel)this.viewModelProvider.get());
   }
}
