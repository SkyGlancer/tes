package app.dukhaan.ui.ui.orders_list;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.orders.OrdersNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class OrdersListViewModel extends BaseViewModel<OrdersNavigator> {
   private MutableLiveData<List<Order>> mOrders = new MutableLiveData();

   public OrdersListViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void fetchOrders(int var1, boolean var2, boolean var3, String var4, int var5) {
      if (!var2) {
         List var6;
         if (var4 == null) {
            var6 = this.getDataManager().getOrders();
         } else {
            var6 = this.getDataManager().getOrders(var4);
         }

         ((OrdersNavigator)this.getNavigator()).onOrdersListFetched(var6, false);
      }

      this.getCompositeDisposable().add(this.getApiService().getOrders(var1, var5, var4).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$OrdersListViewModel$H53nvhKTOMJyt5ZPXooD2Lsg6_g(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$OrdersListViewModel$nb8XEVwzZDS8Znxh6R1oV_C_CdE(this)).subscribe(new _$$Lambda$OrdersListViewModel$hkXWgh13nkf1HTPtVc0VghSq7_4(this, var5, var3, var4), new _$$Lambda$OrdersListViewModel$1zJhi4X4YCL4QmTlFibxr_Qlfnc(this)));
   }

   public MutableLiveData<List<Order>> getOrders() {
      return this.mOrders;
   }
}
