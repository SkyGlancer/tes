package app.dukhaan.ui.ui.deliverycharges;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.deliverycharges.DeliveryChargesModule;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory implements Factory<app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.deliverycharges.DeliveryChargesModule module;

   public DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory(app.dukhaan.ui.deliverycharges.DeliveryChargesModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory create(app.dukhaan.ui.deliverycharges.DeliveryChargesModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new DeliveryChargesModule_ProvideDeliveryChargesViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel provideDeliveryChargesViewModel(DeliveryChargesModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel)Preconditions.checkNotNull(var0.provideDeliveryChargesViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public DeliveryChargesViewModel get() {
      return provideDeliveryChargesViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
