package app.dukhaan.ui.ui.verifyotp;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.LoginRequest;
import app.dukhaan.ui.verifyotp.VerifyOtpNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VerifyOtpViewModel extends BaseViewModel<VerifyOtpNavigator> {
   public VerifyOtpViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   private void getAllProducts(int var1) {
      this.getCompositeDisposable().add(this.getApiService().getAllProducts(var1, 1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$VerifyOtpViewModel$4hU9Up4D_LgHDkzDMAZmlN5L_rU(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$VerifyOtpViewModel$II_H6Kv7Y_zB8GJBwX58RksCO2c(this)).subscribe(new _$$Lambda$VerifyOtpViewModel$_xc3F67tic__Qvjbwy5kF_x8wsU(this), new _$$Lambda$VerifyOtpViewModel$fDuHOr6pdppKmNVJ9WF1pyzg7WQ(this)));
   }

   public void login(LoginRequest var1) {
      this.getCompositeDisposable().add(this.getApiService().login(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$VerifyOtpViewModel$AMur7leJviGk7NGH6jeKv6XelNA(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$VerifyOtpViewModel$ahajA7Oji8rp4VGWVv_edhha4_I(this, var1)).subscribe(new _$$Lambda$VerifyOtpViewModel$kMbk9DNIStsvfNnpjfbMjuv_Kn4(this), new _$$Lambda$VerifyOtpViewModel$VkAj5JKAAqXi9d5h6jljtfSIZLs(this)));
   }
}
