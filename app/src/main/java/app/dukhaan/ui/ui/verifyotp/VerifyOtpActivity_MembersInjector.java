package app.dukhaan.ui.ui.verifyotp;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VerifyOtpActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.verifyotp.VerifyOtpActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public VerifyOtpActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.verifyotp.VerifyOtpActivity> create(Provider<Factory> var0) {
      return new VerifyOtpActivity_MembersInjector(var0);
   }

   public void injectMembers(VerifyOtpActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
