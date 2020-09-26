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
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 */
package app.dukhaan.ui.editbusiness;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$Ailh-DSvsvrYN9jN77-Sn1LapwA;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$C4dH5jKbwYnSLy87oa8JsRGu0Ls;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$JtecTW2DU1S4dOrTBC-MYnMXGyk;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$Ss8X6gv2HuaCjV1Q02ZhLLqqkA4;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$YtIRauJrmRyXSMdmIGqJYblC_TU;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$cCawfo4Oo8fd_3ObM8lhvmMwCZM;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$n_383EisRgQqTrG9l2sKcG7jYIA;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$pYbnianKWjwOyDA1eiT_CnBVEDE;
import app.dukhaan.ui.editbusiness.-$$Lambda$EditBusinessViewModel$w2pANb-r9ZP1pqRYFsjrVXYClow;
import app.dukhaan.ui.editbusiness.EditBusinessNavigator;
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
import okhttp3.MultipartBody;
import timber.log.Timber;

public class EditBusinessViewModel
extends BaseViewModel<EditBusinessNavigator> {
    public EditBusinessViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$updateBusinessDetails$7(AddBusinessResponse addBusinessResponse) throws Exception {
    }

    public /* synthetic */ void lambda$updateBusinessDetails$4$EditBusinessViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateBusinessDetails$5$EditBusinessViewModel(boolean bl, AddBusinessResponse addBusinessResponse) throws Exception {
        if (addBusinessResponse.business != null) {
            this.getDataManager().saveBusiness(addBusinessResponse.business);
            ((EditBusinessNavigator)this.getNavigator()).updatedBusinessDetails(bl);
        }
    }

    public /* synthetic */ void lambda$updateBusinessDetails$6$EditBusinessViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateBusinessDetails$8$EditBusinessViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditBusinessNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$uploadImage$0$EditBusinessViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$uploadImage$1$EditBusinessViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$uploadImage$2$EditBusinessViewModel(UploadImage uploadImage) throws Exception {
        ((EditBusinessNavigator)this.getNavigator()).uploadedImage(uploadImage);
    }

    public /* synthetic */ void lambda$uploadImage$3$EditBusinessViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error! ", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditBusinessNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void updateBusinessDetails(int n, EditBusinessRequest editBusinessRequest, boolean bl) {
        this.getCompositeDisposable().add(this.getApiService().updateBusiness(n, editBusinessRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditBusinessViewModel$cCawfo4Oo8fd_3ObM8lhvmMwCZM(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$EditBusinessViewModel$Ss8X6gv2HuaCjV1Q02ZhLLqqkA4(this, bl)).doFinally((Action)new -$$Lambda$EditBusinessViewModel$w2pANb-r9ZP1pqRYFsjrVXYClow(this)).subscribe((Consumer)-$$Lambda$EditBusinessViewModel$YtIRauJrmRyXSMdmIGqJYblC_TU.INSTANCE, (Consumer)new -$$Lambda$EditBusinessViewModel$pYbnianKWjwOyDA1eiT_CnBVEDE(this)));
    }

    public void uploadImage(MultipartBody.Part part) {
        this.getCompositeDisposable().add(this.getApiService().uploadImage(part).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditBusinessViewModel$JtecTW2DU1S4dOrTBC-MYnMXGyk(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditBusinessViewModel$Ailh-DSvsvrYN9jN77-Sn1LapwA(this)).subscribe((Consumer)new -$$Lambda$EditBusinessViewModel$C4dH5jKbwYnSLy87oa8JsRGu0Ls(this), (Consumer)new -$$Lambda$EditBusinessViewModel$n_383EisRgQqTrG9l2sKcG7jYIA(this)));
    }
}

