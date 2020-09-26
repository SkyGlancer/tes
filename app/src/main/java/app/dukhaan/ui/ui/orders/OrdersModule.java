package app.dukhaan.ui.ui.orders;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OrdersModule {
   public OrdersModule() {
   }

   @Provides
   Factory ordersListViewModelProvider(OrdersListViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   OrdersListViewModel provideOrdersListViewModel(DataRepository var1, ApiService var2) {
      return new OrdersListViewModel(var1, var2);
   }
}
