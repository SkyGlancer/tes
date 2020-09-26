package app.dukhaan.ui.ui.addbusiness;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.AddBusinessRequest;
import app.dukhaan.ui.addbusiness.AddBusinessNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddBusinessViewModel extends BaseViewModel<AddBusinessNavigator> {
   public AddBusinessViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void addBusiness(AddBusinessRequest var1) {
      this.getCompositeDisposable().add(this.getApiService().addBusiness(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$AddBusinessViewModel$ln_HNt3bfA4btrfPJO_FwGYoB44(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$AddBusinessViewModel$W4v_GTk8mz57Z9e8HUYlL4l1PWU(this)).doFinally(new _$$Lambda$AddBusinessViewModel$84iSwaJbTXR4RX8PJCZUAapCmR4(this)).subscribe(new _$$Lambda$AddBusinessViewModel$9O_Gw_cF1lVZ6dv6OivKaMJd164(this), new _$$Lambda$AddBusinessViewModel$hbG6Svbpyznf2Xo2a11SiE7qFZQ(this)));
   }
}
