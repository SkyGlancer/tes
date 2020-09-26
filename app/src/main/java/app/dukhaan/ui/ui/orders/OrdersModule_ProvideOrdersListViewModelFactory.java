package app.dukhaan.ui.ui.orders;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orders.OrdersModule;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrdersModule_ProvideOrdersListViewModelFactory implements Factory<OrdersListViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.orders.OrdersModule module;

   public OrdersModule_ProvideOrdersListViewModelFactory(app.dukhaan.ui.orders.OrdersModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static OrdersModule_ProvideOrdersListViewModelFactory create(app.dukhaan.ui.orders.OrdersModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new OrdersModule_ProvideOrdersListViewModelFactory(var0, var1, var2);
   }

   public static OrdersListViewModel provideOrdersListViewModel(OrdersModule var0, DataRepository var1, ApiService var2) {
      return (OrdersListViewModel)Preconditions.checkNotNull(var0.provideOrdersListViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public OrdersListViewModel get() {
      return provideOrdersListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
