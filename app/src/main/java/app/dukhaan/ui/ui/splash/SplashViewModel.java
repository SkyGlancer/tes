package app.dukhaan.ui.ui.splash;

import android.content.Context;
import android.text.TextUtils;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.splash.SplashNavigator;
import app.dukhaan.util.AppUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashViewModel extends BaseViewModel<app.dukhaan.ui.splash.SplashNavigator> {
   public SplashViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   private void checkOrdersAndLaunchHome(int var1) {
      if (this.getDataManager().getOrders() != null) {
         ((app.dukhaan.ui.splash.SplashNavigator)this.getNavigator()).launchHome();
         this.fetchOrders(var1, false);
      } else {
         this.fetchOrders(var1, true);
      }

   }

   private void getAllProducts(int var1) {
      this.getCompositeDisposable().add(this.getApiService().getAllProducts(var1, 1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$SplashViewModel$cCFAZRo9M_g_gTbRRuEGUjJAfkU(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$SplashViewModel$2VO1Sz0rKGR0JNdOrJJScfXJyxs(this)).subscribe(new _$$Lambda$SplashViewModel$HJ3mq_FbjSAn1ANy2aJve5lVLgA(this, var1), new _$$Lambda$SplashViewModel$ITkjH2hFHe_C1o5StrZHpxwWHgI(this)));
   }

   public void checkSession(Context var1) {
      Business var2 = this.getDataManager().getBusiness();
      if (var2 == null) {
         ((app.dukhaan.ui.splash.SplashNavigator)this.getNavigator()).launchAddBusiness();
      } else {
         this.fetchBusiness();
         if (AppUtils.isInstallFromUpdate(var1) && this.getDataManager().getProductsCount() > 0L) {
            AppPref.getInstance().setProductsAdded(true);
            AppPref.getInstance().setSharedOnWhatsapp(true);
         }

         if (!AppPref.getInstance().isProductsAdded()) {
            this.getAllProducts(var2.realmGet$id());
         } else {
            this.checkOrdersAndLaunchHome(var2.realmGet$id());
         }

      }
   }

   public void fetchBusiness() {
      this.getCompositeDisposable().add(this.getApiService().getBusinesses().subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$SplashViewModel$KiEsl8oGBV3tLVqO8x4kTR_dXfg(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$SplashViewModel$4wMmoWfmWsXPm_hiXM5GOARNJl8(this)).subscribe(new _$$Lambda$SplashViewModel$G_NjKO0Rgl2JYW23oKWGtYf5ogU(this), new _$$Lambda$SplashViewModel$wMp4Eg9_3teZA8LN2pEv_BrrP1E(this)));
   }

   public void fetchOrders(int var1, boolean var2) {
      this.getCompositeDisposable().add(this.getApiService().getOrders(var1, 1, (String)null).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$SplashViewModel$ghpQhsnwyI06_hoqneLOUJESC1g(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$SplashViewModel$5k6GDZBJS9t_FXvvL4TTiJ7Ce_c(this)).doOnSuccess(new _$$Lambda$SplashViewModel$410xnSBvFl6EqDnsiMwi_Fdp4mw(this)).subscribe(new _$$Lambda$SplashViewModel$A147F_F8ri9HzhvuyccrYm5IgjY(this, var2), new _$$Lambda$SplashViewModel$c9h8BI7HOBTcZ05Od9pH_YCWQYQ(this)));
   }

   public void verifyAuthToken() {
      String var1 = this.getDataManager().getAuthToken();
      if (TextUtils.isEmpty(var1)) {
         ((app.dukhaan.ui.splash.SplashNavigator)this.getNavigator()).launchSignIn();
      } else {
         if (var1.contains("Token")) {
            this.getCompositeDisposable().add(this.getApiService().refreshToken().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new _$$Lambda$SplashViewModel$wtVVDShscFRXxTTeikAMXE5mfCk(this)).subscribe(new _$$Lambda$SplashViewModel$lZByKbF5xdzyCW7opSu_wD4TH_I(this), new _$$Lambda$SplashViewModel$I_JWEnpoK1FNQh5PleSjfcwjNtM(this)));
         } else {
            ((SplashNavigator)this.getNavigator()).launchCheckSession();
         }

      }
   }
}
