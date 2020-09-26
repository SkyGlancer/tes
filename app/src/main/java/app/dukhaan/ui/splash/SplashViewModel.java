/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
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
package app.dukhaan.ui.splash;

import android.content.Context;
import android.text.TextUtils;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Product;
import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.BusinessListResponse;
import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$2VO1Sz0rKGR0JNdOrJJScfXJyxs;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$410xnSBvFl6EqDnsiMwi_Fdp4mw;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$4wMmoWfmWsXPm-hiXM5GOARNJl8;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$5k6GDZBJS9t-FXvvL4TTiJ7Ce-c;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$A147F_F8ri9HzhvuyccrYm5IgjY;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$G-NjKO0Rgl2JYW23oKWGtYf5ogU;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$HJ3mq-FbjSAn1ANy2aJve5lVLgA;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$ITkjH2hFHe_C1o5StrZHpxwWHgI;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$I_JWEnpoK1FNQh5PleSjfcwjNtM;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$KiEsl8oGBV3tLVqO8x4kTR_dXfg;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$c9h8BI7HOBTcZ05Od9pH_YCWQYQ;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$cCFAZRo9M-g_gTbRRuEGUjJAfkU;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$ghpQhsnwyI06-hoqneLOUJESC1g;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$lZByKbF5xdzyCW7opSu-wD4TH_I;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$wMp4Eg9-3teZA8LN2pEv-BrrP1E;
import app.dukhaan.ui.splash.-$$Lambda$SplashViewModel$wtVVDShscFRXxTTeikAMXE5mfCk;
import app.dukhaan.ui.splash.SplashNavigator;
import app.dukhaan.util.AppUtils;
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

public class SplashViewModel
extends BaseViewModel<SplashNavigator> {
    public SplashViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    private void checkOrdersAndLaunchHome(int n) {
        if (this.getDataManager().getOrders() != null) {
            ((SplashNavigator)this.getNavigator()).launchHome();
            this.fetchOrders(n, false);
            return;
        }
        this.fetchOrders(n, true);
    }

    private void getAllProducts(int n) {
        this.getCompositeDisposable().add(this.getApiService().getAllProducts(n, 1)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe((Consumer)new -$$Lambda$SplashViewModel$cCFAZRo9M-g_gTbRRuEGUjJAfkU(this))
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally((Action)new -$$Lambda$SplashViewModel$2VO1Sz0rKGR0JNdOrJJScfXJyxs(this))
                .subscribe((Consumer)new -$$Lambda$SplashViewModel$HJ3mq-FbjSAn1ANy2aJve5lVLgA(this, n),
                        (Consumer)new -$$Lambda$SplashViewModel$ITkjH2hFHe_C1o5StrZHpxwWHgI(this)));
    }

    public void checkSession(Context context) {
        Business business = this.getDataManager().getBusiness();
        if (business == null) {
            ((SplashNavigator)this.getNavigator()).launchAddBusiness();
            return;
        }
        this.fetchBusiness();
        if (AppUtils.isInstallFromUpdate(context) && this.getDataManager().getProductsCount() > 0L) {
            AppPref.getInstance().setProductsAdded(true);
            AppPref.getInstance().setSharedOnWhatsapp(true);
        }
        if (!AppPref.getInstance().isProductsAdded()) {
            this.getAllProducts(business.realmGet$id());
            return;
        }
        this.checkOrdersAndLaunchHome(business.realmGet$id());
    }

    public void fetchBusiness() {
        this.getCompositeDisposable().add(this.getApiService().getBusinesses().subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$SplashViewModel$KiEsl8oGBV3tLVqO8x4kTR_dXfg(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$SplashViewModel$4wMmoWfmWsXPm-hiXM5GOARNJl8(this)).subscribe((Consumer)new -$$Lambda$SplashViewModel$G-NjKO0Rgl2JYW23oKWGtYf5ogU(this), (Consumer)new -$$Lambda$SplashViewModel$wMp4Eg9-3teZA8LN2pEv-BrrP1E(this)));
    }

    public void fetchOrders(int n, boolean bl) {
        this.getCompositeDisposable().add(this.getApiService().getOrders(n, 1, null).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$SplashViewModel$ghpQhsnwyI06-hoqneLOUJESC1g(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$SplashViewModel$5k6GDZBJS9t-FXvvL4TTiJ7Ce-c(this)).doOnSuccess((Consumer)new -$$Lambda$SplashViewModel$410xnSBvFl6EqDnsiMwi_Fdp4mw(this)).subscribe((Consumer)new -$$Lambda$SplashViewModel$A147F_F8ri9HzhvuyccrYm5IgjY(this, bl), (Consumer)new -$$Lambda$SplashViewModel$c9h8BI7HOBTcZ05Od9pH_YCWQYQ(this)));
    }

    public /* synthetic */ void lambda$fetchBusiness$10$SplashViewModel(BusinessListResponse businessListResponse) throws Exception {
        if (businessListResponse.businesses != null && businessListResponse.businesses.size() > 0) {
            this.getDataManager().saveBusiness((Business)((Object)businessListResponse.businesses.get(0)));
            this.getDataManager().saveAuthToken(businessListResponse.token);
        }
    }

    public /* synthetic */ void lambda$fetchBusiness$11$SplashViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((SplashNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$fetchBusiness$8$SplashViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$fetchBusiness$9$SplashViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$fetchOrders$3$SplashViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$fetchOrders$4$SplashViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$fetchOrders$5$SplashViewModel(OrdersListResponse ordersListResponse) throws Exception {
        if (ordersListResponse.getResults() != null) {
            this.getDataManager().saveOrders((List<Order>)ordersListResponse.getResults(), true);
        }
    }

    public /* synthetic */ void lambda$fetchOrders$6$SplashViewModel(boolean bl, OrdersListResponse ordersListResponse) throws Exception {
        if (bl) {
            ((SplashNavigator)this.getNavigator()).launchHome();
        }
    }

    public /* synthetic */ void lambda$fetchOrders$7$SplashViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((SplashNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$getAllProducts$12$SplashViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getAllProducts$13$SplashViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getAllProducts$14$SplashViewModel(int n, ProductResponse productResponse) throws Exception {
        if (productResponse.getProducts() != null) {
            DataRepository dataRepository = this.getDataManager();
            List<Product> list = productResponse.getProducts();
            boolean bl = true;
            dataRepository.saveProducts(list, bl);
            AppPref appPref = AppPref.getInstance();
            if (productResponse.getProducts().size() <= 0) {
                bl = false;
            }
            appPref.setProductsAdded(bl);
        }
        this.checkOrdersAndLaunchHome(n);
    }

    public /* synthetic */ void lambda$getAllProducts$15$SplashViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((SplashNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$verifyAuthToken$0$SplashViewModel(LoginResponse loginResponse) throws Exception {
        this.getDataManager().saveAuthToken(loginResponse.getToken());
    }

    public /* synthetic */ void lambda$verifyAuthToken$1$SplashViewModel(LoginResponse loginResponse) throws Exception {
        ((SplashNavigator)this.getNavigator()).launchCheckSession();
    }

    public /* synthetic */ void lambda$verifyAuthToken$2$SplashViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((SplashNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void verifyAuthToken() {
        String string2 = this.getDataManager().getAuthToken();
        if (TextUtils.isEmpty((CharSequence)string2)) {
            ((SplashNavigator)this.getNavigator()).launchSignIn();
            return;
        }
        if (string2.contains((CharSequence)"Token")) {
            this.getCompositeDisposable().add(this.getApiService().refreshToken().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$SplashViewModel$wtVVDShscFRXxTTeikAMXE5mfCk(this)).subscribe((Consumer)new -$$Lambda$SplashViewModel$lZByKbF5xdzyCW7opSu-wD4TH_I(this), (Consumer)new -$$Lambda$SplashViewModel$I_JWEnpoK1FNQh5PleSjfcwjNtM(this)));
            return;
        }
        ((SplashNavigator)this.getNavigator()).launchCheckSession();
    }
}

