package app.dukhaan.ui.ui.addresspicker;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import app.dukhaan.ui.addresspicker.AddressNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddressViewModel extends BaseViewModel<AddressNavigator> {
   private static final String BASE_URL_PLACES = "https://maps.googleapis.com/maps/api/place/autocomplete/json";
   private MutableLiveData<GooglePlacesResponse> googlePlacesResponseMutableLiveData = new MutableLiveData();

   public AddressViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public MutableLiveData<GooglePlacesResponse> getGooglePlacesResponseMutableLiveData() {
      return this.googlePlacesResponseMutableLiveData;
   }

   public void newGooglePlacesResponse(String var1, String var2, String var3, int var4, String var5, Context var6) {
      this.getCompositeDisposable().add(this.getApiService().getGooglePlacesResponse("https://maps.googleapis.com/maps/api/place/autocomplete/json", var1, var2, var3, var4, var5).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$AddressViewModel$Atlsw_wHXZhScK_Gei4zZ5ukR70(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$AddressViewModel$UrsHdWmAc8Ik0HsB_h45E1gK2T8(this)).doFinally(new _$$Lambda$AddressViewModel$97WasdyvQQ7n9cHSmimJ7sVRlH8(this)).subscribe(_$$Lambda$AddressViewModel$apAAf56pV7e9jhtYyHhewEymces.INSTANCE, _$$Lambda$AddressViewModel$AIF9DrSvjSJoyDZOy4qRavg0DcU.INSTANCE));
   }
}
