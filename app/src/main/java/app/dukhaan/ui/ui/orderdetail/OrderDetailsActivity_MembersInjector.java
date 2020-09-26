package app.dukhaan.ui.ui.orderdetail;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrderDetailsActivity_MembersInjector implements MembersInjector<app.dukhaan.ui.orderdetail.OrderDetailsActivity> {
   private final Provider<Factory> viewModelFactoryProvider;

   public OrderDetailsActivity_MembersInjector(Provider<Factory> var1) {
      this.viewModelFactoryProvider = var1;
   }

   public static MembersInjector<app.dukhaan.ui.orderdetail.OrderDetailsActivity> create(Provider<Factory> var0) {
      return new OrderDetailsActivity_MembersInjector(var0);
   }

   public void injectMembers(OrderDetailsActivity var1) {
      BaseActivity_MembersInjector.injectViewModelFactory(var1, (Factory)this.viewModelFactoryProvider.get());
   }
}
