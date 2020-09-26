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
 *  java.util.List
 */
package app.dukhaan.ui.verifyotp;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Product;
import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.LoginRequest;
import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$4hU9Up4D-LgHDkzDMAZmlN5L_rU;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$AMur7leJviGk7NGH6jeKv6XelNA;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$II-H6Kv7Y_zB8GJBwX58RksCO2c;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$VkAj5JKAAqXi9d5h6jljtfSIZLs;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$_xc3F67tic--Qvjbwy5kF-x8wsU;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$ahajA7Oji8rp4VGWVv-edhha4-I;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$fDuHOr6pdppKmNVJ9WF1pyzg7WQ;
import app.dukhaan.ui.verifyotp.-$$Lambda$VerifyOtpViewModel$kMbk9DNIStsvfNnpjfbMjuv-Kn4;
import app.dukhaan.ui.verifyotp.VerifyOtpNavigator;
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

public class VerifyOtpViewModel
extends BaseViewModel<VerifyOtpNavigator> {
    public VerifyOtpViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    private void getAllProducts(int n) {
        this.getCompositeDisposable().add(this.getApiService().getAllProducts(n, 1).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$VerifyOtpViewModel$4hU9Up4D-LgHDkzDMAZmlN5L_rU(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$VerifyOtpViewModel$II-H6Kv7Y_zB8GJBwX58RksCO2c(this)).subscribe((Consumer)new -$$Lambda$VerifyOtpViewModel$_xc3F67tic--Qvjbwy5kF-x8wsU(this), (Consumer)new -$$Lambda$VerifyOtpViewModel$fDuHOr6pdppKmNVJ9WF1pyzg7WQ(this)));
    }

    public /* synthetic */ void lambda$getAllProducts$4$VerifyOtpViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getAllProducts$5$VerifyOtpViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getAllProducts$6$VerifyOtpViewModel(ProductResponse productResponse) throws Exception {
        if (productResponse.getProducts() != null) {
            DataRepository dataRepository = this.getDataManager();
            List<Product> list = productResponse.getProducts();
            boolean bl = true;
            dataRepository.saveProducts(list, bl);
            AppPref appPref = AppPref.getInstance();
            boolean bl2 = productResponse.getProducts().size() > 0;
            appPref.setProductsAdded(bl2);
            AppPref appPref2 = AppPref.getInstance();
            if (productResponse.getProducts().size() <= 0) {
                bl = false;
            }
            appPref2.setSharedOnWhatsapp(bl);
        }
        ((VerifyOtpNavigator)this.getNavigator()).launchHome();
    }

    public /* synthetic */ void lambda$getAllProducts$7$VerifyOtpViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((VerifyOtpNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$login$0$VerifyOtpViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$login$1$VerifyOtpViewModel(LoginRequest loginRequest, LoginResponse loginResponse) throws Exception {
        this.getDataManager().saveAuthToken(loginResponse.getToken());
        AppPref.getInstance().saveMobile(loginRequest.phone);
        if (loginResponse.getBusiness() != null) {
            this.getDataManager().saveBusiness(loginResponse.getBusiness());
        }
    }

    public /* synthetic */ void lambda$login$2$VerifyOtpViewModel(LoginResponse loginResponse) throws Exception {
        if (this.getDataManager().getBusiness() == null) {
            ((VerifyOtpNavigator)this.getNavigator()).launchAddBusiness();
            return;
        }
        if (loginResponse.getBusiness() != null) {
            this.getAllProducts(loginResponse.getBusiness().realmGet$id());
            return;
        }
        ((VerifyOtpNavigator)this.getNavigator()).launchHome();
    }

    public /* synthetic */ void lambda$login$3$VerifyOtpViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((VerifyOtpNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void login(LoginRequest loginRequest) {
        this.getCompositeDisposable().add(this.getApiService().login(loginRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$VerifyOtpViewModel$AMur7leJviGk7NGH6jeKv6XelNA(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)new -$$Lambda$VerifyOtpViewModel$ahajA7Oji8rp4VGWVv-edhha4-I(this, loginRequest)).subscribe((Consumer)new -$$Lambda$VerifyOtpViewModel$kMbk9DNIStsvfNnpjfbMjuv-Kn4(this), (Consumer)new -$$Lambda$VerifyOtpViewModel$VkAj5JKAAqXi9d5h6jljtfSIZLs(this)));
    }
}

