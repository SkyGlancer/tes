package app.dukhaan.ui.ui.orderdetail;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OrderDetailModule {
   public OrderDetailModule() {
   }

   @Provides
   Factory ordersDetailViewModelProvider(OrderDetailViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   OrderDetailViewModel provideOrderDetailViewModel(DataRepository var1, ApiService var2) {
      return new OrderDetailViewModel(var1, var2);
   }
}
