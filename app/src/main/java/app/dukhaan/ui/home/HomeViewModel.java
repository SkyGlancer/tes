/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
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
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.List
 *  org.greenrobot.eventbus.EventBus
 */
package app.dukhaan.ui.home;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStatPeriod;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.BusinessStatsResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.network.model.UpdateOrderStatusResponse;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$0mvNUOQBboa14RhHO-IwaYQgSFw;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$1Hr8Ol4HX5ZgwHjV1EYbx-ytKlY;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$2cKi1pyzQ8Hd4Jyo28cUvkU9nFg;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$8LRF72mlcitDfH84JE6ne49PdV8;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$HhXCyGf27QMVPTWLyt1PCDlH68E;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$Iyuin-opagc0rk0s6YR8JNBv0jg;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$Rq6ZSTfpNp4pKyzUR0R54lTvKIo;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$ZLPLPbsi_8dCOowYhMaJdY6zyYk;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$_PdohNTaslWvi-jIey3JHZFNCWI;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$hdKXzRjHdSnYrImh1ZZdnDOnAok;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$n8m4lnUJAHmoTYhzNUzjOBbrftw;
import app.dukhaan.ui.home.-$$Lambda$HomeViewModel$ryZ_477GaD8WGXEMQcNjA54KcVE;
import app.dukhaan.ui.home.HomeNavigator;
import app.dukhaan.ui.views.model.StatsCardData;
import app.dukhaan.util.PricingUtils;
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
import org.greenrobot.eventbus.EventBus;
import timber.log.Timber;

public class HomeViewModel
extends BaseViewModel<HomeNavigator> {
    private MutableLiveData<List<StatsCardData>> mStatsData = new MutableLiveData();

    public HomeViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    private List<Order> filterPendingOrders(List<Order> list, String string2) {
        ArrayList arrayList = new ArrayList();
        for (Order order : list) {
            if (string2 == null && (order.realmGet$status().equalsIgnoreCase("PENDING") || order.realmGet$status().equalsIgnoreCase("ACCEPTED") || order.realmGet$status().equalsIgnoreCase("SHIPPED"))) {
                arrayList.add((Object)order);
                continue;
            }
            if (!order.realmGet$status().equalsIgnoreCase(string2)) continue;
            arrayList.add((Object)order);
        }
        return arrayList;
    }

    static /* synthetic */ void lambda$updateOrderStatus$11(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            throwable instanceof NoConnectivityException;
        }
    }

    private void renderStats(Context context, String string2) {
        Business business = this.getDataManager().getBusiness();
        if (business != null) {
            ArrayList arrayList = new ArrayList();
            BusinessStatPeriod businessStatPeriod = this.getDataManager().getBusinessStats().getStatus(string2);
            int n = business.realmGet$totalOrders();
            double d = business.realmGet$totalRevenue();
            int n2 = business.realmGet$storeViews();
            int n3 = business.realmGet$productViews();
            if (businessStatPeriod != null) {
                n = businessStatPeriod.realmGet$orders();
                d = businessStatPeriod.realmGet$revenue();
            }
            arrayList.add((Object)new StatsCardData(context.getString(2131951894), String.valueOf((int)n)));
            arrayList.add((Object)new StatsCardData(context.getString(2131951924), PricingUtils.formatPriceWithCurrency(d)));
            arrayList.add((Object)new StatsCardData(context.getString(2131951961), String.valueOf((int)n2)));
            arrayList.add((Object)new StatsCardData(context.getString(2131951915), String.valueOf((int)n3)));
            this.mStatsData.postValue((Object)arrayList);
        }
    }

    public void fetchOrders(int n, boolean bl, boolean bl2, String string2, int n2) {
        if (bl) {
            List<Order> list = string2 == null ? this.getDataManager().getOrders() : this.getDataManager().getOrders(string2);
            ((HomeNavigator)this.getNavigator()).onOrdersListFetched(this.filterPendingOrders(list, string2), string2, false);
        }
        this.getCompositeDisposable().add(this.getApiService().getOrders(n, n2, string2).subscribeOn(Schedulers.io())
                .doOnSubscribe((Consumer)new -$$Lambda$HomeViewModel$Rq6ZSTfpNp4pKyzUR0R54lTvKIo(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$HomeViewModel$HhXCyGf27QMVPTWLyt1PCDlH68E(this)).subscribe((Consumer)new -$$Lambda$HomeViewModel$n8m4lnUJAHmoTYhzNUzjOBbrftw(this, n2, bl2, string2), (Consumer)new -$$Lambda$HomeViewModel$0mvNUOQBboa14RhHO-IwaYQgSFw(this)));
    }

    public void getBusinessStats(Context context, String string2) {
        Business business = this.getDataManager().getBusiness();
        if (business == null) {
            return;
        }
        this.getCompositeDisposable().add(this.getApiService().getBusinessStats(business.realmGet$id()).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$HomeViewModel$_PdohNTaslWvi-jIey3JHZFNCWI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$HomeViewModel$ZLPLPbsi_8dCOowYhMaJdY6zyYk(this)).subscribe((Consumer)new -$$Lambda$HomeViewModel$2cKi1pyzQ8Hd4Jyo28cUvkU9nFg(this, context, string2), (Consumer)new -$$Lambda$HomeViewModel$Iyuin-opagc0rk0s6YR8JNBv0jg(this)));
    }

    public LiveData<List<StatsCardData>> getStatsData() {
        return this.mStatsData;
    }

    public /* synthetic */ void lambda$fetchOrders$4$HomeViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$fetchOrders$5$HomeViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$fetchOrders$6$HomeViewModel(int n, boolean bl, String string2, OrdersListResponse ordersListResponse) throws Exception {
        if (ordersListResponse.getResults() != null) {
            if (n == 1) {
                this.getDataManager().saveOrders((List<Order>)ordersListResponse.getResults(), bl);
            }
            boolean bl2 = true ^ TextUtils.isEmpty((CharSequence)ordersListResponse.next);
            if (n > 1) {
                ((HomeNavigator)this.getNavigator()).onOrdersListFetched(this.filterPendingOrders((List<Order>)ordersListResponse.getResults(), string2), string2, bl2);
                return;
            }
            HomeNavigator homeNavigator = (HomeNavigator)this.getNavigator();
            List<Order> list = string2 == null ? this.filterPendingOrders(this.getDataManager().getOrders(), null) : this.filterPendingOrders(this.getDataManager().getOrders(string2), string2);
            homeNavigator.onOrdersListFetched(list, string2, bl2);
        }
    }

    public /* synthetic */ void lambda$fetchOrders$7$HomeViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "orders fetch error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((HomeNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$getBusinessStats$0$HomeViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getBusinessStats$1$HomeViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getBusinessStats$2$HomeViewModel(Context context, String string2, BusinessStatsResponse businessStatsResponse) throws Exception {
        if (businessStatsResponse != null) {
            this.getDataManager().saveBusinessStats(businessStatsResponse.stats);
            this.renderStats(context, string2);
        }
    }

    public /* synthetic */ void lambda$getBusinessStats$3$HomeViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "stats error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((HomeNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$updateOrderStatus$10$HomeViewModel(Order order, UpdateOrderStatusResponse updateOrderStatusResponse) throws Exception {
        order.realmSet$status(updateOrderStatusResponse.data.orderStatus.status);
        ((HomeNavigator)this.getNavigator()).onOrderStatusUpdated(order);
        AppEvent appEvent = new AppEvent(AppEvent.REFRESH_STATS, null);
        EventBus.getDefault().post((Object)appEvent);
    }

    public /* synthetic */ void lambda$updateOrderStatus$8$HomeViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateOrderStatus$9$HomeViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public void renderEmptyStats(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new StatsCardData(context.getString(2131951894), String.valueOf((int)0)));
        String string2 = context.getString(2131951924);
        Object[] arrobject = new Object[]{0.0};
        arrayList.add((Object)new StatsCardData(string2, context.getString(2131951909, arrobject)));
        arrayList.add((Object)new StatsCardData(context.getString(2131951961), "0"));
        arrayList.add((Object)new StatsCardData(context.getString(2131951915), "0"));
        this.mStatsData.postValue((Object)arrayList);
    }

    public void updateOrderStatus(Order order, UpdateOrderStatusRequest updateOrderStatusRequest) {
        this.getCompositeDisposable().add(this.getApiService().updateOrderStatus(order.realmGet$id(), updateOrderStatusRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$HomeViewModel$1Hr8Ol4HX5ZgwHjV1EYbx-ytKlY(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$HomeViewModel$8LRF72mlcitDfH84JE6ne49PdV8(this)).subscribe((Consumer)new -$$Lambda$HomeViewModel$ryZ_477GaD8WGXEMQcNjA54KcVE(this, order), (Consumer)-$$Lambda$HomeViewModel$hdKXzRjHdSnYrImh1ZZdnDOnAok.INSTANCE));
    }
}

