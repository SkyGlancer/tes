package app.dukhaan.ui.ui.privacy;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PrivacyPolicyActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.privacy.PrivacyPolicyActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public PrivacyPolicyActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.privacy.PrivacyPolicyActivity> create(Provider<Factory> var0) {
      return new PrivacyPolicyActivity_MembersInjector(var0);
   }

   public void injectMembers(PrivacyPolicyActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
