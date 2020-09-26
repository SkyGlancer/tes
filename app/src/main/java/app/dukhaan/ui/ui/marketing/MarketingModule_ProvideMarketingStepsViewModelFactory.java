package app.dukhaan.ui.ui.marketing;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.marketing.MarketingModule;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MarketingModule_ProvideMarketingStepsViewModelFactory implements Factory<app.dukhaan.ui.marketing.MarketingViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.marketing.MarketingModule module;

   public MarketingModule_ProvideMarketingStepsViewModelFactory(app.dukhaan.ui.marketing.MarketingModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static MarketingModule_ProvideMarketingStepsViewModelFactory create(app.dukhaan.ui.marketing.MarketingModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new MarketingModule_ProvideMarketingStepsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.marketing.MarketingViewModel provideMarketingStepsViewModel(MarketingModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.marketing.MarketingViewModel)Preconditions.checkNotNull(var0.provideMarketingStepsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public MarketingViewModel get() {
      return provideMarketingStepsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
