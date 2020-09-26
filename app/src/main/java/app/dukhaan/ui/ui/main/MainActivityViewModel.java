package app.dukhaan.ui.ui.main;

import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.ApiService;
import com.google.firebase.messaging.FirebaseMessaging;

import app.dukhaan.ui.main.MainActivityNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends BaseViewModel<MainActivityNavigator> {
   public MainActivityViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void getBusinessStats() {
      Business var1 = this.getDataManager().getBusiness();
      if (var1 != null) {
         this.getCompositeDisposable().add(this.getApiService().getBusinessStats(var1.realmGet$id()).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$MainActivityViewModel$6AOIdUaq0SlxpHKaJdUnLHdZGQo(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$MainActivityViewModel$uAaLVum6CKTxvl3nBbk1cVJWNiw(this)).subscribe(new _$$Lambda$MainActivityViewModel$xv35ldJ6asiPNLOA1Qb6MCKTegs(this), new _$$Lambda$MainActivityViewModel$HxIkeh332tQEcW9LB90TkDRcqF4(this)));
      }
   }

   public void subscribeToFcmTopics() {
      Business var1 = this.getDataManager().getBusiness();
      if (var1 != null) {
         String var2 = String.format(Constants.FCM_TOPIC_BUSINESS, var1.realmGet$id());
         FirebaseMessaging.getInstance().subscribeToTopic(var2).addOnCompleteListener(new _$$Lambda$MainActivityViewModel$H5096Hvzo3Mma8dHG2OmZ2swDwc(var2));
      }
   }
}
