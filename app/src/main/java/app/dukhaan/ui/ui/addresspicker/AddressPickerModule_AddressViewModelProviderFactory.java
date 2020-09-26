package app.dukhaan.ui.ui.addresspicker;

import app.dukhaan.ui.addresspicker.AddressPickerModule;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddressPickerModule_AddressViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.addresspicker.AddressPickerModule module;
   private final Provider<app.dukhaan.ui.addresspicker.AddressViewModel> viewModelProvider;

   public AddressPickerModule_AddressViewModelProviderFactory(app.dukhaan.ui.addresspicker.AddressPickerModule var1, Provider<app.dukhaan.ui.addresspicker.AddressViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static androidx.lifecycle.ViewModelProvider.Factory addressViewModelProvider(app.dukhaan.ui.addresspicker.AddressPickerModule var0, app.dukhaan.ui.addresspicker.AddressViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.addressViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public static AddressPickerModule_AddressViewModelProviderFactory create(AddressPickerModule var0, Provider<app.dukhaan.ui.addresspicker.AddressViewModel> var1) {
      return new AddressPickerModule_AddressViewModelProviderFactory(var0, var1);
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return addressViewModelProvider(this.module, (AddressViewModel)this.viewModelProvider.get());
   }
}
