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
 *  java.util.List
 */
package app.dukhaan.ui.products;

import android.text.TextUtils;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Product;
import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.network.model.SearchProductsResponse;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$1vXlRAtAkV4IoD9BCVgKaVZ1wm8;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$2jForLBxq0Ip6zj_Uip_OfUu8nw;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$A_WBPpz_-eWjFJyAZdA5OiQxGYw;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$Dy1ZI8BbcP7rT59UZdPLBQt33JY;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$ESca5-2koqQ0_zLrHDas0qNTzX8;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$GqVeApmXO-OYUvFjFedhJwkUQMo;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$Gz3gcCdJ2aADaUGPoWbYRL1qGi4;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$H_qiUoRiQf6e8EDCyFtku7H1aAY;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$JbX86_ahyt_E0UoJ_LMjIoZjhbM;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$MdCJyDUs4JLCVjNSRdhIQg8cmU4;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$Pqcj-cQVE7sp4iTs1CbDaRheirs;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$RkVKPrjRreCHxFRNzrlPRLThbDk;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$SrRCs3gQ7PD_HZyg8VEVQKBbGtI;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$W8vtJFgvjaQF06l3951syYW4y7Q;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$ZNTbBPdTyxtOdQw04H9unDPQNiA;
import app.dukhaan.ui.products.-$$Lambda$ProductsViewModel$x_MEjt0Spw8ITsU6TNrs8QY6Vak;
import app.dukhaan.ui.products.ProductsNavigator;
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

public class ProductsViewModel
extends BaseViewModel<ProductsNavigator> {
    public ProductsViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void deleteProduct(int n, int n2) {
        this.getCompositeDisposable().add(this.getApiService().deleteProduct(n).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$ProductsViewModel$H_qiUoRiQf6e8EDCyFtku7H1aAY(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$ProductsViewModel$Gz3gcCdJ2aADaUGPoWbYRL1qGi4(this)).subscribe((Consumer)new -$$Lambda$ProductsViewModel$W8vtJFgvjaQF06l3951syYW4y7Q(this, n2), (Consumer)new -$$Lambda$ProductsViewModel$2jForLBxq0Ip6zj_Uip_OfUu8nw(this)));
    }

    public void fetchProducts(int n, int n2, boolean bl) {
        List<Product> list = this.getDataManager().getProducts();
        ((ProductsNavigator)this.getNavigator()).showProducts(list, true);
        CompositeDisposable compositeDisposable = this.getCompositeDisposable();
        Single<ProductResponse> single = bl ? this.getApiService().getAllProducts(n, n2) : this.getApiService().categoryProducts(n, n2);
        compositeDisposable.add(single.subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$ProductsViewModel$RkVKPrjRreCHxFRNzrlPRLThbDk(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$ProductsViewModel$Pqcj-cQVE7sp4iTs1CbDaRheirs(this)).subscribe((Consumer)new -$$Lambda$ProductsViewModel$ESca5-2koqQ0_zLrHDas0qNTzX8(this, n2), (Consumer)new -$$Lambda$ProductsViewModel$A_WBPpz_-eWjFJyAZdA5OiQxGYw(this)));
    }

    public /* synthetic */ void lambda$deleteProduct$4$ProductsViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$deleteProduct$5$ProductsViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$deleteProduct$6$ProductsViewModel(int n, DeleteProductResponse deleteProductResponse) throws Exception {
        ((ProductsNavigator)this.getNavigator()).onProductDelete(deleteProductResponse, n);
    }

    public /* synthetic */ void lambda$deleteProduct$7$ProductsViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((ProductsNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$fetchProducts$0$ProductsViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$fetchProducts$1$ProductsViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$fetchProducts$2$ProductsViewModel(int n, ProductResponse productResponse) throws Exception {
        if (n == 1) {
            this.getDataManager().saveProducts(productResponse.getProducts(), true);
        }
        ((ProductsNavigator)this.getNavigator()).showProducts(productResponse.getProducts(), TextUtils.isEmpty((CharSequence)productResponse.getNext()));
    }

    public /* synthetic */ void lambda$fetchProducts$3$ProductsViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((ProductsNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$searchProduct$10$ProductsViewModel(SearchProductsResponse searchProductsResponse) throws Exception {
        ((ProductsNavigator)this.getNavigator()).searchProducts(searchProductsResponse.getProductData().getProducts());
    }

    public /* synthetic */ void lambda$searchProduct$11$ProductsViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((ProductsNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$searchProduct$8$ProductsViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$searchProduct$9$ProductsViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateProduct$12$ProductsViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateProduct$13$ProductsViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateProduct$14$ProductsViewModel(EditProductRequest editProductRequest, EditProductResponse editProductResponse) throws Exception {
        ((ProductsNavigator)this.getNavigator()).onProductUpdateResponse(editProductResponse, editProductRequest.isHidden);
    }

    public /* synthetic */ void lambda$updateProduct$15$ProductsViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((ProductsNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void searchProduct(int n, String string2) {
        this.getCompositeDisposable().add(this.getApiService().search(string2, n).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$ProductsViewModel$MdCJyDUs4JLCVjNSRdhIQg8cmU4(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$ProductsViewModel$GqVeApmXO-OYUvFjFedhJwkUQMo(this)).subscribe((Consumer)new -$$Lambda$ProductsViewModel$1vXlRAtAkV4IoD9BCVgKaVZ1wm8(this), (Consumer)new -$$Lambda$ProductsViewModel$x_MEjt0Spw8ITsU6TNrs8QY6Vak(this)));
    }

    public void updateProduct(EditProductRequest editProductRequest, int n) {
        this.getCompositeDisposable().add(this.getApiService().editProduct(n, editProductRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$ProductsViewModel$SrRCs3gQ7PD_HZyg8VEVQKBbGtI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$ProductsViewModel$Dy1ZI8BbcP7rT59UZdPLBQt33JY(this)).subscribe((Consumer)new -$$Lambda$ProductsViewModel$ZNTbBPdTyxtOdQw04H9unDPQNiA(this, editProductRequest), (Consumer)new -$$Lambda$ProductsViewModel$JbX86_ahyt_E0UoJ_LMjIoZjhbM(this)));
    }
}

