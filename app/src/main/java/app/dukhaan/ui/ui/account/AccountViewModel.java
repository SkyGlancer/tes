package app.dukhaan.ui.ui.account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.account.AccountViewNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountViewModel extends BaseViewModel<AccountViewNavigator> {
   private MutableLiveData<String> mText;

   public AccountViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void getAwardsStats() {
      this.getCompositeDisposable().add(this.getApiService().getAwardsStats().subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$AccountViewModel$Dui5zkPVR0vvLZfOAtwOkA_5QrI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$AccountViewModel$76prCvfyGkElzJDcrjvPupB6RWU(this)).subscribe(new _$$Lambda$AccountViewModel$_bdonqXVw3cH91B_g3cmX0EWrn8(this), new _$$Lambda$AccountViewModel$yXJAZ0K81IV2m58PfCjhCWYilBI(this)));
   }

   public LiveData<String> getText() {
      return this.mText;
   }

   public void updateBusinessDetails(int var1, EditBusinessRequest var2) {
      this.getCompositeDisposable().add(this.getApiService().updateBusiness(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$AccountViewModel$Ap5m86aqF0w_UcAiw8pxypOY_m4(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$AccountViewModel$oKz7rhAAvuUuPEU8YGbjYll6lzQ(this)).doFinally(new _$$Lambda$AccountViewModel$T0E2jJ1Fq09Qfj_2n0nhkxg7dT8(this)).subscribe(_$$Lambda$AccountViewModel$P09kYm5BDjML7N4lz2KMfo6WhnA.INSTANCE, new _$$Lambda$AccountViewModel$MztDlvPP58m_bjDWkU2inTMUO74(this, var2)));
   }
}
