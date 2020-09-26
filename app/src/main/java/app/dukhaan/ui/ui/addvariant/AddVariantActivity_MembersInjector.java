package app.dukhaan.ui.ui.addvariant;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addvariant.AddVariantActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddVariantActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.addvariant.AddVariantActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public AddVariantActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.addvariant.AddVariantActivity> create(Provider<Factory> var0) {
      return new AddVariantActivity_MembersInjector(var0);
   }

   public void injectMembers(AddVariantActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
