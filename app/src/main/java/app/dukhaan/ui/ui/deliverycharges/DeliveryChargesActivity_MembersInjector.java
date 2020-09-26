package app.dukhaan.ui.ui.deliverycharges;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DeliveryChargesActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.deliverycharges.DeliveryChargesActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public DeliveryChargesActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.deliverycharges.DeliveryChargesActivity> create(Provider<Factory> var0) {
      return new DeliveryChargesActivity_MembersInjector(var0);
   }

   public void injectMembers(DeliveryChargesActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
