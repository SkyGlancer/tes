package app.dukhaan.ui.ui.main;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.util.AppUpdateUtils;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.main.MainActivity> {
   private final Provider<AppUpdateManager> appUpdateManagerProvider;
   private final Provider<AppUpdateUtils> appUpdateUtilsProvider;
   private final Provider<Factory> viewModelFactoryProvider;

   public MainActivity_MembersInjector(Provider<Factory> var1, Provider<AppUpdateUtils> var2, Provider<AppUpdateManager> var3) {
      this.viewModelFactoryProvider = var1;
      this.appUpdateUtilsProvider = var2;
      this.appUpdateManagerProvider = var3;
   }

   public static MembersInjector<app.dukhaan.ui.main.MainActivity> create(Provider<Factory> var0, Provider<AppUpdateUtils> var1, Provider<AppUpdateManager> var2) {
      return new MainActivity_MembersInjector(var0, var1, var2);
   }

   public static void injectAppUpdateManager(app.dukhaan.ui.main.MainActivity var0, AppUpdateManager var1) {
      var0.appUpdateManager = var1;
   }

   public static void injectAppUpdateUtils(app.dukhaan.ui.main.MainActivity var0, AppUpdateUtils var1) {
      var0.appUpdateUtils = var1;
   }

   public void injectMembers(MainActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
      injectAppUpdateUtils(var1, (AppUpdateUtils)this.appUpdateUtilsProvider.get());
      injectAppUpdateManager(var1, (AppUpdateManager)this.appUpdateManagerProvider.get());
   }
}
