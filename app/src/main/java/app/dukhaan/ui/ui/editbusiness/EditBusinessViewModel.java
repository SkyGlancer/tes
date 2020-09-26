package app.dukhaan.ui.ui.editbusiness;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.editbusiness.EditBusinessNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody.Part;

public class EditBusinessViewModel extends BaseViewModel<EditBusinessNavigator> {
   public EditBusinessViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void updateBusinessDetails(int var1, EditBusinessRequest var2, boolean var3) {
      this.getCompositeDisposable().add(this.getApiService().updateBusiness(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditBusinessViewModel$cCawfo4Oo8fd_3ObM8lhvmMwCZM(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$EditBusinessViewModel$Ss8X6gv2HuaCjV1Q02ZhLLqqkA4(this, var3)).doFinally(new _$$Lambda$EditBusinessViewModel$w2pANb_r9ZP1pqRYFsjrVXYClow(this)).subscribe(_$$Lambda$EditBusinessViewModel$YtIRauJrmRyXSMdmIGqJYblC_TU.INSTANCE, new _$$Lambda$EditBusinessViewModel$pYbnianKWjwOyDA1eiT_CnBVEDE(this)));
   }

   public void uploadImage(Part var1) {
      this.getCompositeDisposable().add(this.getApiService().uploadImage(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditBusinessViewModel$JtecTW2DU1S4dOrTBC_MYnMXGyk(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditBusinessViewModel$Ailh_DSvsvrYN9jN77_Sn1LapwA(this)).subscribe(new _$$Lambda$EditBusinessViewModel$C4dH5jKbwYnSLy87oa8JsRGu0Ls(this), new _$$Lambda$EditBusinessViewModel$n_383EisRgQqTrG9l2sKcG7jYIA(this)));
   }
}
