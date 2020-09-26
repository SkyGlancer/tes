package app.dukhaan.ui.ui.goldsuccess;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.goldsuccess.GoldSuccessActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GoldSuccessActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.goldsuccess.GoldSuccessActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public GoldSuccessActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.goldsuccess.GoldSuccessActivity> create(Provider<Factory> var0) {
      return new GoldSuccessActivity_MembersInjector(var0);
   }

   public void injectMembers(GoldSuccessActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
