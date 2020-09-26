package app.dukhaan.ui.ui.home;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.home.HomeFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class HomeFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.home.HomeFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public HomeFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.home.HomeFragment> create(Provider<Factory> var0) {
      return new HomeFragment_MembersInjector(var0);
   }

   public void injectMembers(HomeFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
