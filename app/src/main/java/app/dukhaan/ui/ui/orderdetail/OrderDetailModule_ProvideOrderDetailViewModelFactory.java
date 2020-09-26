package app.dukhaan.ui.ui.orderdetail;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orderdetail.OrderDetailModule;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrderDetailModule_ProvideOrderDetailViewModelFactory implements Factory<app.dukhaan.ui.orderdetail.OrderDetailViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.orderdetail.OrderDetailModule module;

   public OrderDetailModule_ProvideOrderDetailViewModelFactory(app.dukhaan.ui.orderdetail.OrderDetailModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static OrderDetailModule_ProvideOrderDetailViewModelFactory create(app.dukhaan.ui.orderdetail.OrderDetailModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new OrderDetailModule_ProvideOrderDetailViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.orderdetail.OrderDetailViewModel provideOrderDetailViewModel(OrderDetailModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.orderdetail.OrderDetailViewModel)Preconditions.checkNotNull(var0.provideOrderDetailViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public OrderDetailViewModel get() {
      return provideOrderDetailViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
