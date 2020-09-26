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
package app.dukhaan.ui.editcategory;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.network.model.EditCategoryRequest;
import app.dukhaan.ui.editcategory.-$$Lambda$EditCategoriesViewModel$3Igv2Ibd4h2g8t-H3NCrWpou-Rs;
import app.dukhaan.ui.editcategory.-$$Lambda$EditCategoriesViewModel$DzV4FuYI1pGauZ1fMCLoqrcRgYM;
import app.dukhaan.ui.editcategory.-$$Lambda$EditCategoriesViewModel$lh7KuzMEtaJj63_mXjBNkVQCBAg;
import app.dukhaan.ui.editcategory.-$$Lambda$EditCategoriesViewModel$xoNqm5AcaOcYa_BOXh5VfrQ_uvM;
import app.dukhaan.ui.editcategory.EditCategoriesNavigator;
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

public class EditCategoriesViewModel
extends BaseViewModel<EditCategoriesNavigator> {
    public EditCategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public /* synthetic */ void lambda$updateCategory$0$EditCategoriesViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateCategory$1$EditCategoriesViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateCategory$2$EditCategoriesViewModel(CreateCategoryResonse createCategoryResonse) throws Exception {
        ((EditCategoriesNavigator)this.getNavigator()).onCategoryUpdateResponse(createCategoryResonse);
    }

    public /* synthetic */ void lambda$updateCategory$3$EditCategoriesViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditCategoriesNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void updateCategory(EditCategoryRequest editCategoryRequest, int n) {
        this.getCompositeDisposable().add(this.getApiService().editCategory(n, editCategoryRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditCategoriesViewModel$DzV4FuYI1pGauZ1fMCLoqrcRgYM(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditCategoriesViewModel$xoNqm5AcaOcYa_BOXh5VfrQ_uvM(this)).subscribe((Consumer)new -$$Lambda$EditCategoriesViewModel$3Igv2Ibd4h2g8t-H3NCrWpou-Rs(this), (Consumer)new -$$Lambda$EditCategoriesViewModel$lh7KuzMEtaJj63_mXjBNkVQCBAg(this)));
    }
}

