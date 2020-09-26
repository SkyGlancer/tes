package app.dukhaan.ui.ui.products;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.ui.products.ProductsNavigator;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ProductsViewModel extends BaseViewModel<app.dukhaan.ui.products.ProductsNavigator> {
   public ProductsViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void deleteProduct(int var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().deleteProduct(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$ProductsViewModel$H_qiUoRiQf6e8EDCyFtku7H1aAY(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$ProductsViewModel$Gz3gcCdJ2aADaUGPoWbYRL1qGi4(this)).subscribe(new _$$Lambda$ProductsViewModel$W8vtJFgvjaQF06l3951syYW4y7Q(this, var2), new _$$Lambda$ProductsViewModel$2jForLBxq0Ip6zj_Uip_OfUu8nw(this)));
   }

   public void fetchProducts(int var1, int var2, boolean var3) {
      List var4 = this.getDataManager().getProducts();
      ((ProductsNavigator)this.getNavigator()).showProducts(var4, true);
      CompositeDisposable var5 = this.getCompositeDisposable();
      Single var6;
      if (var3) {
         var6 = this.getApiService().getAllProducts(var1, var2);
      } else {
         var6 = this.getApiService().categoryProducts(var1, var2);
      }

      var5.add(var6.subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$ProductsViewModel$RkVKPrjRreCHxFRNzrlPRLThbDk(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$ProductsViewModel$Pqcj_cQVE7sp4iTs1CbDaRheirs(this)).subscribe(new _$$Lambda$ProductsViewModel$ESca5_2koqQ0_zLrHDas0qNTzX8(this, var2), new _$$Lambda$ProductsViewModel$A_WBPpz__eWjFJyAZdA5OiQxGYw(this)));
   }

   public void searchProduct(int var1, String var2) {
      this.getCompositeDisposable().add(this.getApiService().search(var2, var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$ProductsViewModel$MdCJyDUs4JLCVjNSRdhIQg8cmU4(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$ProductsViewModel$GqVeApmXO_OYUvFjFedhJwkUQMo(this)).subscribe(new _$$Lambda$ProductsViewModel$1vXlRAtAkV4IoD9BCVgKaVZ1wm8(this), new _$$Lambda$ProductsViewModel$x_MEjt0Spw8ITsU6TNrs8QY6Vak(this)));
   }

   public void updateProduct(EditProductRequest var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().editProduct(var2, var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$ProductsViewModel$SrRCs3gQ7PD_HZyg8VEVQKBbGtI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$ProductsViewModel$Dy1ZI8BbcP7rT59UZdPLBQt33JY(this)).subscribe(new _$$Lambda$ProductsViewModel$ZNTbBPdTyxtOdQw04H9unDPQNiA(this, var1), new _$$Lambda$ProductsViewModel$JbX86_ahyt_E0UoJ_LMjIoZjhbM(this)));
   }
}
