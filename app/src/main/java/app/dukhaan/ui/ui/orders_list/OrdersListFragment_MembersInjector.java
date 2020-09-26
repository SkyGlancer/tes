package app.dukhaan.ui.ui.orders_list;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrdersListFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.orders_list.OrdersListFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public OrdersListFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.orders_list.OrdersListFragment> create(Provider<Factory> var0) {
      return new OrdersListFragment_MembersInjector(var0);
   }

   public void injectMembers(OrdersListFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
