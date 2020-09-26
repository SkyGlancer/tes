package app.dukhaan.ui.ui.orderdetail;

import app.dukhaan.ui.orderdetail.OrderDetailModule;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrderDetailModule_OrdersDetailViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.orderdetail.OrderDetailModule module;
   private final Provider<app.dukhaan.ui.orderdetail.OrderDetailViewModel> viewModelProvider;

   public OrderDetailModule_OrdersDetailViewModelProviderFactory(app.dukhaan.ui.orderdetail.OrderDetailModule var1, Provider<app.dukhaan.ui.orderdetail.OrderDetailViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static OrderDetailModule_OrdersDetailViewModelProviderFactory create(app.dukhaan.ui.orderdetail.OrderDetailModule var0, Provider<app.dukhaan.ui.orderdetail.OrderDetailViewModel> var1) {
      return new OrderDetailModule_OrdersDetailViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory ordersDetailViewModelProvider(OrderDetailModule var0, app.dukhaan.ui.orderdetail.OrderDetailViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.ordersDetailViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return ordersDetailViewModelProvider(this.module, (OrderDetailViewModel)this.viewModelProvider.get());
   }
}
