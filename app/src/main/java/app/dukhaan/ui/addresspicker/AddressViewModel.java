/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.MutableLiveData
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.schedulers.Schedulers
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package app.dukhaan.ui.addresspicker;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressViewModel$97WasdyvQQ7n9cHSmimJ7sVRlH8;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressViewModel$AIF9DrSvjSJoyDZOy4qRavg0DcU;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressViewModel$Atlsw-wHXZhScK_Gei4zZ5ukR70;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressViewModel$UrsHdWmAc8Ik0HsB_h45E1gK2T8;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressViewModel$apAAf56pV7e9jhtYyHhewEymces;
import app.dukhaan.ui.addresspicker.AddressNavigator;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class AddressViewModel
extends BaseViewModel<AddressNavigator> {
    private static final String BASE_URL_PLACES = "https://maps.googleapis.com/maps/api/place/autocomplete/json";
    private MutableLiveData<GooglePlacesResponse> googlePlacesResponseMutableLiveData = new MutableLiveData();

    public AddressViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$newGooglePlacesResponse$3(GooglePlacesResponse googlePlacesResponse) throws Exception {
        googlePlacesResponse.getStatus();
    }

    static /* synthetic */ void lambda$newGooglePlacesResponse$4(Throwable throwable) throws Exception {
    }

    public MutableLiveData<GooglePlacesResponse> getGooglePlacesResponseMutableLiveData() {
        return this.googlePlacesResponseMutableLiveData;
    }

    public /* synthetic */ void lambda$newGooglePlacesResponse$0$AddressViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$newGooglePlacesResponse$1$AddressViewModel(GooglePlacesResponse googlePlacesResponse) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MAPS API : ");
        stringBuilder.append(googlePlacesResponse.toString());
        Timber.d(stringBuilder.toString(), new Object[0]);
        this.googlePlacesResponseMutableLiveData.postValue((Object)googlePlacesResponse);
    }

    public /* synthetic */ void lambda$newGooglePlacesResponse$2$AddressViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public void newGooglePlacesResponse(String string2, String string3, String string4, int n, String string5, Context context) {
        this.getCompositeDisposable().add(this.getApiService().getGooglePlacesResponse(BASE_URL_PLACES, string2, string3, string4, n, string5).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$AddressViewModel$Atlsw-wHXZhScK_Gei4zZ5ukR70(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$AddressViewModel$UrsHdWmAc8Ik0HsB_h45E1gK2T8(this)).doFinally((Action)new -$$Lambda$AddressViewModel$97WasdyvQQ7n9cHSmimJ7sVRlH8(this)).subscribe((Consumer)-$$Lambda$AddressViewModel$apAAf56pV7e9jhtYyHhewEymces.INSTANCE, (Consumer)-$$Lambda$AddressViewModel$AIF9DrSvjSJoyDZOy4qRavg0DcU.INSTANCE));
    }
}

