/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.schedulers.Schedulers
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.ui.categories;

import android.text.TextUtils;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.DeleteCategoryResonse;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$Dy6YOLjjH_FyZ5v3EagtpyVZEgA;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$FkWa8-U6V99668yagWu_yY1XKKg;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$HP1YQNGqlSENFx-1O5py1UXOk5U;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$Hs610l_ZSCWK0wmnVeL7Ej2KDoI;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$SCAqOIf3qkGhYrKuBeVggNRwFzg;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$gMHF2Bm9r7JVwGUXOV2V1kAf1e8;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$xHSRv0X1MoPExufzIph9XX-zg0Y;
import app.dukhaan.ui.categories.-$$Lambda$CategoriesViewModel$yT_yeUAQQDGb7P_vrG8dpuZC7nM;
import app.dukhaan.ui.categories.CategoriesNavigator;
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
import java.util.ArrayList;
import java.util.List;

public class CategoriesViewModel
extends BaseViewModel<CategoriesNavigator> {
    public CategoriesViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void deleteCategory(int n, int n2) {
        this.getCompositeDisposable().add(this.getApiService().deleteCategory(n).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$CategoriesViewModel$FkWa8-U6V99668yagWu_yY1XKKg(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$CategoriesViewModel$xHSRv0X1MoPExufzIph9XX-zg0Y(this)).subscribe((Consumer)new -$$Lambda$CategoriesViewModel$Dy6YOLjjH_FyZ5v3EagtpyVZEgA(this, n2), (Consumer)new -$$Lambda$CategoriesViewModel$yT_yeUAQQDGb7P_vrG8dpuZC7nM(this)));
    }

    public void getCategoryList(int n, int n2) {
        List<Category> list = this.getDataManager().getCategories();
        ((CategoriesNavigator)this.getNavigator()).onCategoryListFetched(list, true);
        this.getCompositeDisposable().add(this.getApiService().getCategories(n, n2).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$CategoriesViewModel$Hs610l_ZSCWK0wmnVeL7Ej2KDoI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$CategoriesViewModel$HP1YQNGqlSENFx-1O5py1UXOk5U(this)).subscribe((Consumer)new -$$Lambda$CategoriesViewModel$SCAqOIf3qkGhYrKuBeVggNRwFzg(this, n2), (Consumer)new -$$Lambda$CategoriesViewModel$gMHF2Bm9r7JVwGUXOV2V1kAf1e8(this)));
    }

    public /* synthetic */ void lambda$deleteCategory$4$CategoriesViewModel(Disposable
                                                                                    disposable) throws Exception { (view) -> {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$deleteCategory$5$CategoriesViewModel() throws Exception { (view) -> {
        this.setIsLoading(false);
    }

    public /* synthetic */ void
        lambda$deleteCategory$6$CategoriesViewModel(int n, DeleteCategoryResonse deleteCategoryResonse)
        throws Exception { (view) -> {
        ((CategoriesNavigator)this.getNavigator()).onCategoryDelete(deleteCategoryResonse, n);
    }

    public /* synthetic */ void lambda$deleteCategory$7$CategoriesViewModel(Throwable throwable) throws Exception { (view) -> {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((CategoriesNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$getCategoryList$0$CategoriesViewModel(Disposable disposable) throws Exception { (view) -> {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getCategoryList$1$CategoriesViewModel() throws Exception { (view) -> {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getCategoryList$2$CategoriesViewMode
        l(int n, CategoryListResponse categoryListResponse) throws Exception { (view) -> {
        if (n == 1) {
            this.getDataManager().saveCategories((List<Category>)categoryListResponse.getResults(), true);
        }
        ((CategoriesNavigator)this.getNavigator()).onCategoryListFetched((List<Category>)categoryListResponse.getResults(), TextUtils.isEmpty((CharSequence)categoryListResponse.getNext()));
    }

    public /* synthetic */ void lambda$getCategoryList$3$CategoriesViewModel(Throwable throwable) throws Exception { (view) -> {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((CategoriesNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }
}

