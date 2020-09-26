/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.messaging.FirebaseMessaging
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
package app.dukhaan.ui.main;

import app.dukhaan.app.Constants;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.BusinessStatsResponse;
import app.dukhaan.ui.main.-$$Lambda$MainActivityViewModel$6AOIdUaq0SlxpHKaJdUnLHdZGQo;
import app.dukhaan.ui.main.-$$Lambda$MainActivityViewModel$H5096Hvzo3Mma8dHG2OmZ2swDwc;
import app.dukhaan.ui.main.-$$Lambda$MainActivityViewModel$HxIkeh332tQEcW9LB90TkDRcqF4;
import app.dukhaan.ui.main.-$$Lambda$MainActivityViewModel$uAaLVum6CKTxvl3nBbk1cVJWNiw;
import app.dukhaan.ui.main.-$$Lambda$MainActivityViewModel$xv35ldJ6asiPNLOA1Qb6MCKTegs;
import app.dukhaan.ui.main.MainActivityNavigator;
import app.dukhaan.util.RetrofitUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
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

public class MainActivityViewModel
extends BaseViewModel<MainActivityNavigator> {
    public MainActivityViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$subscribeToFcmTopics$0(String string2, Task task) {
        if (task.isSuccessful()) {
            Timber.e("Successfully subscribed to fcm topic %s", string2);
            return;
        }
        Timber.e("Failed to subscribe to %s topic", string2);
    }

    public void getBusinessStats() {
        Business business = this.getDataManager().getBusiness();
        if (business == null) {
            return;
        }
        this.getCompositeDisposable().add(this.getApiService().getBusinessStats(business.realmGet$id()).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$MainActivityViewModel$6AOIdUaq0SlxpHKaJdUnLHdZGQo(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$MainActivityViewModel$uAaLVum6CKTxvl3nBbk1cVJWNiw(this)).subscribe((Consumer)new -$$Lambda$MainActivityViewModel$xv35ldJ6asiPNLOA1Qb6MCKTegs(this), (Consumer)new -$$Lambda$MainActivityViewModel$HxIkeh332tQEcW9LB90TkDRcqF4(this)));
    }

    public /* synthetic */ void lambda$getBusinessStats$1$MainActivityViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getBusinessStats$2$MainActivityViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getBusinessStats$3$MainActivityViewModel(BusinessStatsResponse businessStatsResponse) throws Exception {
        if (businessStatsResponse != null) {
            this.getDataManager().saveBusinessStats(businessStatsResponse.stats);
            ((MainActivityNavigator)this.getNavigator()).refreshBadgeCount();
        }
    }

    public /* synthetic */ void lambda$getBusinessStats$4$MainActivityViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "stats error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((MainActivityNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void subscribeToFcmTopics() {
        Business business = this.getDataManager().getBusiness();
        if (business == null) {
            return;
        }
        String string2 = Constants.FCM_TOPIC_BUSINESS;
        Object[] arrobject = new Object[]{business.realmGet$id()};
        String string3 = String.format((String)string2, (Object[])arrobject);
        FirebaseMessaging.getInstance().subscribeToTopic(string3).addOnCompleteListener((OnCompleteListener)new -$$Lambda$MainActivityViewModel$H5096Hvzo3Mma8dHG2OmZ2swDwc(string3));
    }
}

