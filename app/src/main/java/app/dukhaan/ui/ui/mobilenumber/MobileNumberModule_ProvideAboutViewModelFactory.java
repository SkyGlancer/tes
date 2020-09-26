package app.dukhaan.ui.ui.mobilenumber;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.mobilenumber.MobileNumberModule;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MobileNumberModule_ProvideAboutViewModelFactory implements Factory<app.dukhaan.ui.mobilenumber.MobileNumberViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.mobilenumber.MobileNumberModule module;

   public MobileNumberModule_ProvideAboutViewModelFactory(app.dukhaan.ui.mobilenumber.MobileNumberModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static MobileNumberModule_ProvideAboutViewModelFactory create(app.dukhaan.ui.mobilenumber.MobileNumberModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new MobileNumberModule_ProvideAboutViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.mobilenumber.MobileNumberViewModel provideAboutViewModel(MobileNumberModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.mobilenumber.MobileNumberViewModel)Preconditions.checkNotNull(var0.provideAboutViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public MobileNumberViewModel get() {
      return provideAboutViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
