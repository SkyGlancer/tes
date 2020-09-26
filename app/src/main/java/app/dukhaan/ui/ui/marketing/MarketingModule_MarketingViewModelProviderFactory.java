package app.dukhaan.ui.ui.marketing;

import app.dukhaan.ui.marketing.MarketingModule;
import app.dukhaan.ui.marketing.MarketingViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MarketingModule_MarketingViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.marketing.MarketingModule module;
   private final Provider<app.dukhaan.ui.marketing.MarketingViewModel> viewModelProvider;

   public MarketingModule_MarketingViewModelProviderFactory(app.dukhaan.ui.marketing.MarketingModule var1, Provider<app.dukhaan.ui.marketing.MarketingViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static MarketingModule_MarketingViewModelProviderFactory create(app.dukhaan.ui.marketing.MarketingModule var0, Provider<app.dukhaan.ui.marketing.MarketingViewModel> var1) {
      return new MarketingModule_MarketingViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory marketingViewModelProvider(MarketingModule var0, app.dukhaan.ui.marketing.MarketingViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.marketingViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return marketingViewModelProvider(this.module, (MarketingViewModel)this.viewModelProvider.get());
   }
}
