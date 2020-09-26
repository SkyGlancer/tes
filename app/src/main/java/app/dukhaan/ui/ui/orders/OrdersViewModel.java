package app.dukhaan.ui.ui.orders;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.orders.OrdersNavigator;

import java.util.List;

public class OrdersViewModel extends BaseViewModel<OrdersNavigator> {
   private MutableLiveData<List<Order>> mOrders = new MutableLiveData();

   public OrdersViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public MutableLiveData<List<Order>> getOrders() {
      return this.mOrders;
   }
}
