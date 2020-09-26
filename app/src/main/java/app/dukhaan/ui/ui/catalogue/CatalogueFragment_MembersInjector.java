package app.dukhaan.ui.ui.catalogue;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.catalogue.CatalogueFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CatalogueFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.catalogue.CatalogueFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public CatalogueFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.catalogue.CatalogueFragment> create(Provider<Factory> var0) {
      return new CatalogueFragment_MembersInjector(var0);
   }

   public void injectMembers(CatalogueFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
