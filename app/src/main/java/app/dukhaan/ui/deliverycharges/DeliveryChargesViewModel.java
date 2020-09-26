/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
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
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 */
package app.dukhaan.ui.deliverycharges;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.EditDeliveryChargeRequest;
import app.dukhaan.network.model.EditDeliveryChargeResponse;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesViewModel$2Yzks8xmPpf5a-1kS30wJGa0Y6E;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesViewModel$4vmlLIxxwV4GzomC8flOReLTLog;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesViewModel$ApMamRO1DstIbSlpznEQKjlvMDo;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesViewModel$ZWxcT3XHoKzUy5omrr9taBCr0C8;
import app.dukhaan.ui.deliverycharges.-$$Lambda$DeliveryChargesViewModel$_k6zg95hgIrvUdJuJkYlkEcZdQw;
import app.dukhaan.ui.deliverycharges.DeliveryChargesNavigator;
import app.dukhaan.util.RetrofitUtils;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.UnknownHostException;
import timber.log.Timber;

public class DeliveryChargesViewModel
extends BaseViewModel<DeliveryChargesNavigator> {
    public DeliveryChargesViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$updateDeliveryChargeDetails$3(EditDeliveryChargeResponse editDeliveryChargeResponse) throws Exception {
    }

    public /* synthetic */ void lambda$updateDeliveryChargeDetails$0$DeliveryChargesViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateDeliveryChargeDetails$1$DeliveryChargesViewModel(EditDeliveryChargeResponse editDeliveryChargeResponse) throws Exception {
        Timber.e("onResponse: %s", editDeliveryChargeResponse);
        if (editDeliveryChargeResponse.business != null) {
            this.getDataManager().saveBusiness(editDeliveryChargeResponse.business);
            ((DeliveryChargesNavigator)this.getNavigator()).onBusinessUpdated(editDeliveryChargeResponse.business);
        }
    }

    public /* synthetic */ void lambda$updateDeliveryChargeDetails$2$DeliveryChargesViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateDeliveryChargeDetails$4$DeliveryChargesViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((DeliveryChargesNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void updateDeliveryChargeDetails(int n, EditDeliveryChargeRequest editDeliveryChargeRequest) {
        this.getCompositeDisposable().add(this.getApiService().editDeliveryCharge(n, editDeliveryChargeRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$DeliveryChargesViewModel$_k6zg95hgIrvUdJuJkYlkEcZdQw(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$DeliveryChargesViewModel$2Yzks8xmPpf5a-1kS30wJGa0Y6E(this)).doFinally((Action)new -$$Lambda$DeliveryChargesViewModel$ApMamRO1DstIbSlpznEQKjlvMDo(this)).subscribe((Consumer)-$$Lambda$DeliveryChargesViewModel$ZWxcT3XHoKzUy5omrr9taBCr0C8.INSTANCE, (Consumer)new -$$Lambda$DeliveryChargesViewModel$4vmlLIxxwV4GzomC8flOReLTLog(this)));
    }
}

