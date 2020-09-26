package app.dukhaan.ui.ui.createcategory;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CreateCategoryActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.createcategory.CreateCategoryActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public CreateCategoryActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.createcategory.CreateCategoryActivity> create(Provider<Factory> var0) {
      return new CreateCategoryActivity_MembersInjector(var0);
   }

   public void injectMembers(CreateCategoryActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
