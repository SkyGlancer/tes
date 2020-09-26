package app.dukhaan.ui.ui.killswitch;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class KillswitchActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.killswitch.KillswitchActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public KillswitchActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.killswitch.KillswitchActivity> create(Provider<Factory> var0) {
      return new KillswitchActivity_MembersInjector(var0);
   }

   public void injectMembers(KillswitchActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
