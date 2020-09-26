package app.dukhaan.ui.ui.categories;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.categories.CategoriesFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CategoriesFragment_MembersInjector implements MembersInjector<app.dukhaan.ui.categories.CategoriesFragment> {
   private final Provider<Factory> viewModelFactoryProvider;

   public CategoriesFragment_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.categories.CategoriesFragment> create(Provider<Factory> var0) {
      return new CategoriesFragment_MembersInjector(var0);
   }

   public void injectMembers(CategoriesFragment var1) {
      BaseFragment_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
