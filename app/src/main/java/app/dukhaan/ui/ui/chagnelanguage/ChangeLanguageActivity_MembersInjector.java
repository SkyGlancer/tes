package app.dukhaan.ui.ui.chagnelanguage;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChangeLanguageActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public ChangeLanguageActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity> create(Provider<Factory> var0) {
      return new ChangeLanguageActivity_MembersInjector(var0);
   }

   public void injectMembers(ChangeLanguageActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
