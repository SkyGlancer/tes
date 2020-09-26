/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
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
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  java.util.List
 */
package app.dukhaan.ui.account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.network.model.AwardStatsResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$-bdonqXVw3cH91B-g3cmX0EWrn8;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$76prCvfyGkElzJDcrjvPupB6RWU;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$Ap5m86aqF0w_UcAiw8pxypOY-m4;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$Dui5zkPVR0vvLZfOAtwOkA_5QrI;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$MztDlvPP58m_bjDWkU2inTMUO74;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$P09kYm5BDjML7N4lz2KMfo6WhnA;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$T0E2jJ1Fq09Qfj_2n0nhkxg7dT8;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$oKz7rhAAvuUuPEU8YGbjYll6lzQ;
import app.dukhaan.ui.account.-$$Lambda$AccountViewModel$yXJAZ0K81IV2m58PfCjhCWYilBI;
import app.dukhaan.ui.account.AccountViewNavigator;
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
import java.util.List;
import timber.log.Timber;

public class AccountViewModel
extends BaseViewModel<AccountViewNavigator> {
    private MutableLiveData<String> mText;

    public AccountViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$updateBusinessDetails$3(AddBusinessResponse addBusinessResponse) throws Exception {
    }

    public void getAwardsStats() {
        this.getCompositeDisposable().add(this.getApiService().getAwardsStats().subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$AccountViewModel$Dui5zkPVR0vvLZfOAtwOkA_5QrI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$AccountViewModel$76prCvfyGkElzJDcrjvPupB6RWU(this)).subscribe((Consumer)new -$$Lambda$AccountViewModel$-bdonqXVw3cH91B-g3cmX0EWrn8(this), (Consumer)new -$$Lambda$AccountViewModel$yXJAZ0K81IV2m58PfCjhCWYilBI(this)));
    }

    public LiveData<String> getText() {
        return this.mText;
    }

    public /* synthetic */ void lambda$getAwardsStats$5$AccountViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getAwardsStats$6$AccountViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getAwardsStats$7$AccountViewModel(AwardStatsResponse awardStatsResponse) throws Exception {
        ((AccountViewNavigator)this.getNavigator()).openReferDialog(awardStatsResponse.awardData);
    }

    public /* synthetic */ void lambda$getAwardsStats$8$AccountViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((AccountViewNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$updateBusinessDetails$0$AccountViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateBusinessDetails$1$AccountViewModel(AddBusinessResponse addBusinessResponse) throws Exception {
        if (addBusinessResponse.business != null) {
            this.getDataManager().saveBusiness(addBusinessResponse.business);
            ((AccountViewNavigator)this.getNavigator()).onWhatsAppChatSupportUpdated(addBusinessResponse.business.realmGet$isWhatsAppChatEnabled());
        }
    }

    public /* synthetic */ void lambda$updateBusinessDetails$2$AccountViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateBusinessDetails$4$AccountViewModel(EditBusinessRequest editBusinessRequest, Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        ((AccountViewNavigator)this.getNavigator()).onWhatsAppChatSupportError(true ^ editBusinessRequest.isWhatsAppChatSupportEnabled);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((AccountViewNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void updateBusinessDetails(int n, EditBusinessRequest editBusinessRequest) {
        this.getCompositeDisposable().add(this.getApiService().updateBusiness(n, editBusinessRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$AccountViewModel$Ap5m86aqF0w_UcAiw8pxypOY-m4(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$AccountViewModel$oKz7rhAAvuUuPEU8YGbjYll6lzQ(this)).doFinally((Action)new -$$Lambda$AccountViewModel$T0E2jJ1Fq09Qfj_2n0nhkxg7dT8(this)).subscribe((Consumer)-$$Lambda$AccountViewModel$P09kYm5BDjML7N4lz2KMfo6WhnA.INSTANCE, (Consumer)new -$$Lambda$AccountViewModel$MztDlvPP58m_bjDWkU2inTMUO74(this, editBusinessRequest)));
    }
}

