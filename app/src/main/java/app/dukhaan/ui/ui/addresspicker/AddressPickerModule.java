package app.dukhaan.ui.ui.addresspicker;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class AddressPickerModule {
   public AddressPickerModule() {
   }

   @Provides
   Factory addressViewModelProvider(app.dukhaan.ui.addresspicker.AddressViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   app.dukhaan.ui.addresspicker.AddressViewModel provideAddressViewModel(DataRepository var1, ApiService var2) {
      return new AddressViewModel(var1, var2);
   }
}
