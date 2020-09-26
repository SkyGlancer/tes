package app.dukhaan.ui.ui.mobilenumber;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.mobilenumber.MobileNumberActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MobileNumberActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.mobilenumber.MobileNumberActivity> {
   private final Provider<Factory> mViewModelFactoryAndViewModelFactoryProvider;

   public MobileNumberActivity_MembersInjector(Provider<Factory> var1) {
      this.mViewModelFactoryAndViewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.mobilenumber.MobileNumberActivity> create(Provider<Factory> var0) {
      return new MobileNumberActivity_MembersInjector(var0);
   }

   public static void injectMViewModelFactory(app.dukhaan.ui.mobilenumber.MobileNumberActivity var0, Factory var1) {
      var0.mViewModelFactory = var1;
   }

   public void injectMembers(MobileNumberActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.mViewModelFactoryAndViewModelFactoryProvider.get());
      injectMViewModelFactory(var1, (Factory)this.mViewModelFactoryAndViewModelFactoryProvider.get());
   }
}
