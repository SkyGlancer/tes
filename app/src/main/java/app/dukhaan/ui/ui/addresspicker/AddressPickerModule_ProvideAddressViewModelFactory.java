package app.dukhaan.ui.ui.addresspicker;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.addresspicker.AddressPickerModule;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddressPickerModule_ProvideAddressViewModelFactory implements Factory<app.dukhaan.ui.addresspicker.AddressViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.addresspicker.AddressPickerModule module;

   public AddressPickerModule_ProvideAddressViewModelFactory(app.dukhaan.ui.addresspicker.AddressPickerModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static AddressPickerModule_ProvideAddressViewModelFactory create(app.dukhaan.ui.addresspicker.AddressPickerModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new AddressPickerModule_ProvideAddressViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.addresspicker.AddressViewModel provideAddressViewModel(AddressPickerModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.addresspicker.AddressViewModel)Preconditions.checkNotNull(var0.provideAddressViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public AddressViewModel get() {
      return provideAddressViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
