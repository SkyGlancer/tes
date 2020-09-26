package app.dukhaan.ui.ui.marketing;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.marketing.MarketingFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MarketingFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.marketing.MarketingFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public MarketingFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.marketing.MarketingFragment> create(Provider<Factory> var0) {
      return new MarketingFragment_MembersInjector(var0);
   }

   public void injectMembers(MarketingFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
