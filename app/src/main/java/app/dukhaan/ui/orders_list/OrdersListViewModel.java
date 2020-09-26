/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  androidx.lifecycle.MutableLiveData
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
package app.dukhaan.ui.orders_list;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.ui.orders.OrdersNavigator;
import app.dukhaan.ui.orders_list.-$$Lambda$OrdersListViewModel$1zJhi4X4YCL4QmTlFibxr_Qlfnc;
import app.dukhaan.ui.orders_list.-$$Lambda$OrdersListViewModel$H53nvhKTOMJyt5ZPXooD2Lsg6_g;
import app.dukhaan.ui.orders_list.-$$Lambda$OrdersListViewModel$hkXWgh13nkf1HTPtVc0VghSq7-4;
import app.dukhaan.ui.orders_list.-$$Lambda$OrdersListViewModel$nb8XEVwzZDS8Znxh6R1oV-C_CdE;
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
import timber.log.Timber;

public class OrdersListViewModel
extends BaseViewModel<OrdersNavigator> {
    private MutableLiveData<List<Order>> mOrders = new MutableLiveData();

    public OrdersListViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void fetchOrders(int n, boolean bl, boolean bl2, String string2, int n2) {
        if (!bl) {
            List<Order> list = string2 == null ? this.getDataManager().getOrders() : this.getDataManager().getOrders(string2);
            ((OrdersNavigator)this.getNavigator()).onOrdersListFetched(list, false);
        }
        this.getCompositeDisposable().add(this.getApiService().getOrders(n, n2, string2).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$OrdersListViewModel$H53nvhKTOMJyt5ZPXooD2Lsg6_g(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$OrdersListViewModel$nb8XEVwzZDS8Znxh6R1oV-C_CdE(this)).subscribe((Consumer)new -$$Lambda$OrdersListViewModel$hkXWgh13nkf1HTPtVc0VghSq7-4(this, n2, bl2, string2), (Consumer)new -$$Lambda$OrdersListViewModel$1zJhi4X4YCL4QmTlFibxr_Qlfnc(this)));
    }

    public MutableLiveData<List<Order>> getOrders() {
        return this.mOrders;
    }

    public /* synthetic */ void lambda$fetchOrders$0$OrdersListViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$fetchOrders$1$OrdersListViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$fetchOrders$2$OrdersListViewModel(int n, boolean bl, String string2, OrdersListResponse ordersListResponse) throws Exception {
        if (ordersListResponse.getResults() != null) {
            if (n == 1) {
                this.getDataManager().saveOrders((List<Order>)ordersListResponse.getResults(), bl ^ true);
            }
            boolean bl2 = true ^ TextUtils.isEmpty((CharSequence)ordersListResponse.next);
            if (n > 1) {
                ((OrdersNavigator)this.getNavigator()).onOrdersListFetched((List<Order>)ordersListResponse.getResults(), bl2);
                return;
            }
            OrdersNavigator ordersNavigator = (OrdersNavigator)this.getNavigator();
            List<Order> list = string2 == null ? this.getDataManager().getOrders() : this.getDataManager().getOrders(string2);
            ordersNavigator.onOrdersListFetched(list, bl2);
        }
    }

    public /* synthetic */ void lambda$fetchOrders$3$OrdersListViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "orders fetch error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((OrdersNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }
}

