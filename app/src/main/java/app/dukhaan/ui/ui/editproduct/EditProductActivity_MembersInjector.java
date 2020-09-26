package app.dukhaan.ui.ui.editproduct;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editproduct.EditProductActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditProductActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.editproduct.EditProductActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public EditProductActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.editproduct.EditProductActivity> create(Provider<Factory> var0) {
      return new EditProductActivity_MembersInjector(var0);
   }

   public void injectMembers(EditProductActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
