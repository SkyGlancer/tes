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
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  org.greenrobot.eventbus.EventBus
 */
package app.dukhaan.ui.orderdetail;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.TrackOrderResponse;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.network.model.UpdateOrderStatusResponse;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$0ogE02PFU4MxUccHN5UZeiCC5Z8;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$1vox2e89K29dNCqp69UHEHXWDlQ;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$4jzhHW09godNcUmOKM5bnbCItUU;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$7x-6X_atZwopOZH6wA_ZEV__VAs;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$AMhn3N-ZMmrPv4sLBBUiNzCwRfk;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$PITKHbWlvi_skTqw4z-aZqqawcM;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$k2w7xHU9kcgxqIyDWdLaXQzYBKM;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailViewModel$kaFUL-ArNOesvrP-M3HK_hpW4CU;
import app.dukhaan.ui.orderdetail.OrderDetailNavigator;
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
import org.greenrobot.eventbus.EventBus;
import timber.log.Timber;

public class OrderDetailViewModel
extends BaseViewModel<OrderDetailNavigator> {
    public OrderDetailViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public void getOrderDetails(String string2) {
        this.getCompositeDisposable().add(this.getApiService().trackOrder(string2).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$OrderDetailViewModel$4jzhHW09godNcUmOKM5bnbCItUU(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$OrderDetailViewModel$k2w7xHU9kcgxqIyDWdLaXQzYBKM(this)).subscribe((Consumer)new -$$Lambda$OrderDetailViewModel$0ogE02PFU4MxUccHN5UZeiCC5Z8(this), (Consumer)new -$$Lambda$OrderDetailViewModel$PITKHbWlvi_skTqw4z-aZqqawcM(this)));
    }

    public /* synthetic */ void lambda$getOrderDetails$0$OrderDetailViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getOrderDetails$1$OrderDetailViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getOrderDetails$2$OrderDetailViewModel(TrackOrderResponse trackOrderResponse) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ORDERS VM:");
        stringBuilder.append(trackOrderResponse.toString());
        Timber.d(stringBuilder.toString(), new Object[0]);
        ((OrderDetailNavigator)this.getNavigator()).onOrderDetailsReceived(trackOrderResponse.getOrder());
    }

    public /* synthetic */ void lambda$getOrderDetails$3$OrderDetailViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((OrderDetailNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$updateOrderStatus$4$OrderDetailViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateOrderStatus$5$OrderDetailViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateOrderStatus$6$OrderDetailViewModel(UpdateOrderStatusResponse updateOrderStatusResponse) throws Exception {
        ((OrderDetailNavigator)this.getNavigator()).onOrderStatusUpdated();
        AppEvent appEvent = new AppEvent(AppEvent.REFRESH_STATS, null);
        EventBus.getDefault().post((Object)appEvent);
        AppEvent appEvent2 = new AppEvent(AppEvent.NEW_ORDER, null);
        EventBus.getDefault().post((Object)appEvent2);
    }

    public /* synthetic */ void lambda$updateOrderStatus$7$OrderDetailViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "orders error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((OrderDetailNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public void updateOrderStatus(int n, UpdateOrderStatusRequest updateOrderStatusRequest) {
        this.getCompositeDisposable().add(this.getApiService().updateOrderStatus(n, updateOrderStatusRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$OrderDetailViewModel$1vox2e89K29dNCqp69UHEHXWDlQ(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$OrderDetailViewModel$7x-6X_atZwopOZH6wA_ZEV__VAs(this)).subscribe((Consumer)new -$$Lambda$OrderDetailViewModel$AMhn3N-ZMmrPv4sLBBUiNzCwRfk(this), (Consumer)new -$$Lambda$OrderDetailViewModel$kaFUL-ArNOesvrP-M3HK_hpW4CU(this)));
    }
}

