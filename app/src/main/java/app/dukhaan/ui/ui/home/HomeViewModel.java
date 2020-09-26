package app.dukhaan.ui.ui.home;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStatPeriod;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.home.HomeNavigator;
import app.dukhaan.ui.views.model.StatsCardData;
import app.dukhaan.util.PricingUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeViewModel extends BaseViewModel<app.dukhaan.ui.home.HomeNavigator> {
   private MutableLiveData<List<StatsCardData>> mStatsData = new MutableLiveData();

   public HomeViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   private List<Order> filterPendingOrders(List<Order> var1, String var2) {
      ArrayList var3 = new ArrayList();
      Iterator var5 = var1.iterator();

      while(true) {
         while(var5.hasNext()) {
            Order var4 = (Order)var5.next();
            if (var2 == null && (var4.realmGet$status().equalsIgnoreCase("PENDING") || var4.realmGet$status().equalsIgnoreCase("ACCEPTED") || var4.realmGet$status().equalsIgnoreCase("SHIPPED"))) {
               var3.add(var4);
            } else if (var4.realmGet$status().equalsIgnoreCase(var2)) {
               var3.add(var4);
            }
         }

         return var3;
      }
   }

   private void renderStats(Context var1, String var2) {
      Business var3 = this.getDataManager().getBusiness();
      if (var3 != null) {
         ArrayList var4 = new ArrayList();
         BusinessStatPeriod var10 = this.getDataManager().getBusinessStats().getStatus(var2);
         int var5 = var3.realmGet$totalOrders();
         double var6 = var3.realmGet$totalRevenue();
         int var8 = var3.realmGet$storeViews();
         int var9 = var3.realmGet$productViews();
         if (var10 != null) {
            var5 = var10.realmGet$orders();
            var6 = var10.realmGet$revenue();
         }

         var4.add(new StatsCardData(var1.getString(R.string.orders), String.valueOf(var5)));
         var4.add(new StatsCardData(var1.getString(R.string.revenue), PricingUtils.formatPriceWithCurrency(var6)));
         var4.add(new StatsCardData(var1.getString(R.string.store_views), String.valueOf(var8)));
         var4.add(new StatsCardData(var1.getString(R.string.product_views), String.valueOf(var9)));
         this.mStatsData.postValue(var4);
      }

   }

   public void fetchOrders(int var1, boolean var2, boolean var3, String var4, int var5) {
      if (var2) {
         List var6;
         if (var4 == null) {
            var6 = this.getDataManager().getOrders();
         } else {
            var6 = this.getDataManager().getOrders(var4);
         }

         ((HomeNavigator)this.getNavigator()).onOrdersListFetched(this.filterPendingOrders(var6, var4), var4, false);
      }

      this.getCompositeDisposable().add(this.getApiService().getOrders(var1, var5, var4).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$HomeViewModel$Rq6ZSTfpNp4pKyzUR0R54lTvKIo(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$HomeViewModel$HhXCyGf27QMVPTWLyt1PCDlH68E(this)).subscribe(new _$$Lambda$HomeViewModel$n8m4lnUJAHmoTYhzNUzjOBbrftw(this, var5, var3, var4), new _$$Lambda$HomeViewModel$0mvNUOQBboa14RhHO_IwaYQgSFw(this)));
   }

   public void getBusinessStats(Context var1, String var2) {
      Business var3 = this.getDataManager().getBusiness();
      if (var3 != null) {
         this.getCompositeDisposable().add(this.getApiService().getBusinessStats(var3.realmGet$id()).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$HomeViewModel$_PdohNTaslWvi_jIey3JHZFNCWI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$HomeViewModel$ZLPLPbsi_8dCOowYhMaJdY6zyYk(this)).subscribe(new _$$Lambda$HomeViewModel$2cKi1pyzQ8Hd4Jyo28cUvkU9nFg(this, var1, var2), new _$$Lambda$HomeViewModel$Iyuin_opagc0rk0s6YR8JNBv0jg(this)));
      }
   }

   public LiveData<List<StatsCardData>> getStatsData() {
      return this.mStatsData;
   }

   public void renderEmptyStats(Context var1) {
      ArrayList var2 = new ArrayList();
      var2.add(new StatsCardData(var1.getString(R.string.orders), String.valueOf(0)));
      var2.add(new StatsCardData(var1.getString(R.string.revenue), var1.getString(R.string.price_format, new Object[]{0.0D})));
      var2.add(new StatsCardData(var1.getString(R.string.store_views), "0"));
      var2.add(new StatsCardData(var1.getString(R.string.product_views), "0"));
      this.mStatsData.postValue(var2);
   }

   public void updateOrderStatus(Order var1, UpdateOrderStatusRequest var2) {
      this.getCompositeDisposable().add(this.getApiService().updateOrderStatus(var1.realmGet$id(), var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$HomeViewModel$1Hr8Ol4HX5ZgwHjV1EYbx_ytKlY(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$HomeViewModel$8LRF72mlcitDfH84JE6ne49PdV8(this)).subscribe(new _$$Lambda$HomeViewModel$ryZ_477GaD8WGXEMQcNjA54KcVE(this, var1), _$$Lambda$HomeViewModel$hdKXzRjHdSnYrImh1ZZdnDOnAok.INSTANCE));
   }
}
