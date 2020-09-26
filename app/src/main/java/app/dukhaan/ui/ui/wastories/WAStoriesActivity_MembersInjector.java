package app.dukhaan.ui.ui.wastories;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.wastories.WAStoriesActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class WAStoriesActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.wastories.WAStoriesActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public WAStoriesActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.wastories.WAStoriesActivity> create(Provider<Factory> var0) {
      return new WAStoriesActivity_MembersInjector(var0);
   }

   public void injectMembers(WAStoriesActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
