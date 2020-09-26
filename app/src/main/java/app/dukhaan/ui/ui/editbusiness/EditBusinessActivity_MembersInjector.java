package app.dukhaan.ui.ui.editbusiness;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class EditBusinessActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.editbusiness.EditBusinessActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public EditBusinessActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.editbusiness.EditBusinessActivity> create(Provider<Factory> var0) {
      return new EditBusinessActivity_MembersInjector(var0);
   }

   public void injectMembers(EditBusinessActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
