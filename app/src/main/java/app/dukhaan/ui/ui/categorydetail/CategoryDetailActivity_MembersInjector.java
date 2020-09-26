package app.dukhaan.ui.ui.categorydetail;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CategoryDetailActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.categorydetail.CategoryDetailActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public CategoryDetailActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.categorydetail.CategoryDetailActivity> create(Provider<Factory> var0) {
      return new CategoryDetailActivity_MembersInjector(var0);
   }

   public void injectMembers(CategoryDetailActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
