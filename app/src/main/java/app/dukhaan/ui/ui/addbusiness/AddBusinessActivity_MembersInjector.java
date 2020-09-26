package app.dukhaan.ui.ui.addbusiness;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddBusinessActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.addbusiness.AddBusinessActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public AddBusinessActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.addbusiness.AddBusinessActivity> create(Provider<Factory> var0) {
      return new AddBusinessActivity_MembersInjector(var0);
   }

   public void injectMembers(AddBusinessActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
