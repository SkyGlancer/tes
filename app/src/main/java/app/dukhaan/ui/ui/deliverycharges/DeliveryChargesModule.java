package app.dukhaan.ui.ui.deliverycharges;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class DeliveryChargesModule {
   public DeliveryChargesModule() {
   }

   @Provides
   Factory deliveryChargesViewModelProvider(DeliveryChargesViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   DeliveryChargesViewModel provideDeliveryChargesViewModel(DataRepository var1, ApiService var2) {
      return new DeliveryChargesViewModel(var1, var2);
   }
}
