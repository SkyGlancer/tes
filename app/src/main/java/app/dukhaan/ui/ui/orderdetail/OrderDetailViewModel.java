package app.dukhaan.ui.ui.orderdetail;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.orderdetail.OrderDetailNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class OrderDetailViewModel extends BaseViewModel<OrderDetailNavigator> {
   public OrderDetailViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void getOrderDetails(String var1) {
      this.getCompositeDisposable().add(this.getApiService().trackOrder(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$OrderDetailViewModel$4jzhHW09godNcUmOKM5bnbCItUU(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$OrderDetailViewModel$k2w7xHU9kcgxqIyDWdLaXQzYBKM(this)).subscribe(new _$$Lambda$OrderDetailViewModel$0ogE02PFU4MxUccHN5UZeiCC5Z8(this), new _$$Lambda$OrderDetailViewModel$PITKHbWlvi_skTqw4z_aZqqawcM(this)));
   }

   public void updateOrderStatus(int var1, UpdateOrderStatusRequest var2) {
      this.getCompositeDisposable().add(this.getApiService().updateOrderStatus(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$OrderDetailViewModel$1vox2e89K29dNCqp69UHEHXWDlQ(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$OrderDetailViewModel$7x_6X_atZwopOZH6wA_ZEV__VAs(this)).subscribe(new _$$Lambda$OrderDetailViewModel$AMhn3N_ZMmrPv4sLBBUiNzCwRfk(this), new _$$Lambda$OrderDetailViewModel$kaFUL_ArNOesvrP_M3HK_hpW4CU(this)));
   }
}
