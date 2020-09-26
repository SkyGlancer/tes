package app.dukhaan.ui.ui.orders;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.orders.OrdersFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrdersFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.orders.OrdersFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public OrdersFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.orders.OrdersFragment> create(Provider<Factory> var0) {
      return new OrdersFragment_MembersInjector(var0);
   }

   public void injectMembers(OrdersFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
