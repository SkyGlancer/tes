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
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 */
package app.dukhaan.ui.addbusiness;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.AddBusinessRequest;
import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessViewModel$84iSwaJbTXR4RX8PJCZUAapCmR4;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessViewModel$9O-Gw_cF1lVZ6dv6OivKaMJd164;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessViewModel$W4v-GTk8mz57Z9e8HUYlL4l1PWU;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessViewModel$hbG6Svbpyznf2Xo2a11SiE7qFZQ;
import app.dukhaan.ui.addbusiness.-$$Lambda$AddBusinessViewModel$ln-HNt3bfA4btrfPJO-FwGYoB44;
import app.dukhaan.ui.addbusiness.AddBusinessNavigator;
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

public class AddBusinessViewModel
extends BaseViewModel<AddBusinessNavigator> {
    public AddBusinessViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void addBusiness(AddBusinessRequest addBusinessRequest) {
        this.getCompositeDisposable().add(this.getApiService().addBusiness(addBusinessRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$AddBusinessViewModel$ln-HNt3bfA4btrfPJO-FwGYoB44(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$AddBusinessViewModel$W4v-GTk8mz57Z9e8HUYlL4l1PWU(this)).doFinally((Action)new -$$Lambda$AddBusinessViewModel$84iSwaJbTXR4RX8PJCZUAapCmR4(this)).subscribe((Consumer)new -$$Lambda$AddBusinessViewModel$9O-Gw_cF1lVZ6dv6OivKaMJd164(this), (Consumer)new -$$Lambda$AddBusinessViewModel$hbG6Svbpyznf2Xo2a11SiE7qFZQ(this)));
    }

    public /* synthetic */ void lambda$addBusiness$0$AddBusinessViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$addBusiness$1$AddBusinessViewModel(AddBusinessResponse addBusinessResponse) throws Exception {
        if (addBusinessResponse.business != null) {
            this.getDataManager().saveBusiness(addBusinessResponse.business);
            this.getDataManager().saveAuthToken(addBusinessResponse.token);
        }
    }

    public /* synthetic */ void lambda$addBusiness$2$AddBusinessViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$addBusiness$3$AddBusinessViewModel(AddBusinessResponse addBusinessResponse) throws Exception {
        ((AddBusinessNavigator)this.getNavigator()).launchTutorial();
    }

    public /* synthetic */ void lambda$addBusiness$4$AddBusinessViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((AddBusinessNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }
}

