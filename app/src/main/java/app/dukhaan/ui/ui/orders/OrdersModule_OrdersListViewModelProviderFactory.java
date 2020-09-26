package app.dukhaan.ui.ui.orders;

import app.dukhaan.ui.orders.OrdersModule;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrdersModule_OrdersListViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.orders.OrdersModule module;
   private final Provider<OrdersListViewModel> viewModelProvider;

   public OrdersModule_OrdersListViewModelProviderFactory(app.dukhaan.ui.orders.OrdersModule var1, Provider<OrdersListViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static OrdersModule_OrdersListViewModelProviderFactory create(app.dukhaan.ui.orders.OrdersModule var0, Provider<OrdersListViewModel> var1) {
      return new OrdersModule_OrdersListViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory ordersListViewModelProvider(OrdersModule var0, OrdersListViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.ordersListViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return ordersListViewModelProvider(this.module, (OrdersListViewModel)this.viewModelProvider.get());
   }
}
