package app.dukhaan.ui.ui.addresspicker;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddressSelectActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.addresspicker.AddressSelectActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public AddressSelectActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.addresspicker.AddressSelectActivity> create(Provider<Factory> var0) {
      return new AddressSelectActivity_MembersInjector(var0);
   }

   public void injectMembers(AddressSelectActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
