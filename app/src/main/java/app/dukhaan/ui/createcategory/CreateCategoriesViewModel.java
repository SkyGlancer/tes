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
package app.dukhaan.ui.createcategory;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.CreateCategoryRequest;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.createcategory.-$$Lambda$CreateCategoriesViewModel$1dvL29eFxLb66L2eHLeKDwSBVjI;
import app.dukhaan.ui.createcategory.-$$Lambda$CreateCategoriesViewModel$K6wOUrFJ82ddj7vwyrMT6IichmQ;
import app.dukhaan.ui.createcategory.-$$Lambda$CreateCategoriesViewModel$i9zlc3HZRtZCYtHLw_YwXoIJEDw;
import app.dukhaan.ui.createcategory.-$$Lambda$CreateCategoriesViewModel$taC-PiHuBZtonY_II40hKuHzi8E;
import app.dukhaan.ui.createcategory.CreateCategoriesNavigator;
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

public class CreateCategoriesViewModel
extends BaseViewModel<CreateCategoriesNavigator> {
    public CreateCategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        this.getCompositeDisposable().add(this.getApiService().createCategory(createCategoryRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$CreateCategoriesViewModel$taC-PiHuBZtonY_II40hKuHzi8E(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$CreateCategoriesViewModel$i9zlc3HZRtZCYtHLw_YwXoIJEDw(this)).subscribe((Consumer)new -$$Lambda$CreateCategoriesViewModel$K6wOUrFJ82ddj7vwyrMT6IichmQ(this), (Consumer)new -$$Lambda$CreateCategoriesViewModel$1dvL29eFxLb66L2eHLeKDwSBVjI(this)));
    }

    public /* synthetic */ void lambda$createCategory$0$CreateCategoriesViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$createCategory$1$CreateCategoriesViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$createCategory$2$CreateCategoriesViewModel(CreateCategoryResonse createCategoryResonse) throws Exception {
        ((CreateCategoriesNavigator)this.getNavigator()).onCreateCategorySuccess(createCategoryResonse);
    }

    public /* synthetic */ void lambda$createCategory$3$CreateCategoriesViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((CreateCategoriesNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }
}

