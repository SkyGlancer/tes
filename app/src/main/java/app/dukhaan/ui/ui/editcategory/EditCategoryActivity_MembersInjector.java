package app.dukhaan.ui.ui.editcategory;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditCategoryActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.editcategory.EditCategoryActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public EditCategoryActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.editcategory.EditCategoryActivity> create(Provider<Factory> var0) {
      return new EditCategoryActivity_MembersInjector(var0);
   }

   public void injectMembers(EditCategoryActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
