package app.dukhaan.ui.ui.verifymobile;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VerifyMobileActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.verifymobile.VerifyMobileActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public VerifyMobileActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.verifymobile.VerifyMobileActivity> create(Provider<Factory> var0) {
      return new VerifyMobileActivity_MembersInjector(var0);
   }

   public void injectMembers(VerifyMobileActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
