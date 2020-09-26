package app.dukhaan.ui.ui.deliverycharges;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.EditDeliveryChargeRequest;
import app.dukhaan.ui.deliverycharges.DeliveryChargesNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DeliveryChargesViewModel extends BaseViewModel<DeliveryChargesNavigator> {
   public DeliveryChargesViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void updateDeliveryChargeDetails(int var1, EditDeliveryChargeRequest var2) {
      this.getCompositeDisposable().add(this.getApiService().editDeliveryCharge(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$DeliveryChargesViewModel$_k6zg95hgIrvUdJuJkYlkEcZdQw(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$DeliveryChargesViewModel$2Yzks8xmPpf5a_1kS30wJGa0Y6E(this)).doFinally(new _$$Lambda$DeliveryChargesViewModel$ApMamRO1DstIbSlpznEQKjlvMDo(this)).subscribe(_$$Lambda$DeliveryChargesViewModel$ZWxcT3XHoKzUy5omrr9taBCr0C8.INSTANCE, new _$$Lambda$DeliveryChargesViewModel$4vmlLIxxwV4GzomC8flOReLTLog(this)));
   }
}
