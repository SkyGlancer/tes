package app.dukhaan.ui.ui.categories;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categories.CategoriesNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class CategoriesViewModel extends BaseViewModel<app.dukhaan.ui.categories.CategoriesNavigator> {
   public CategoriesViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void deleteCategory(int var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().deleteCategory(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$CategoriesViewModel$FkWa8_U6V99668yagWu_yY1XKKg(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$CategoriesViewModel$xHSRv0X1MoPExufzIph9XX_zg0Y(this)).subscribe(new _$$Lambda$CategoriesViewModel$Dy6YOLjjH_FyZ5v3EagtpyVZEgA(this, var2), new _$$Lambda$CategoriesViewModel$yT_yeUAQQDGb7P_vrG8dpuZC7nM(this)));
   }

   public void getCategoryList(int var1, int var2) {
      List var3 = this.getDataManager().getCategories();
      ((CategoriesNavigator)this.getNavigator()).onCategoryListFetched(var3, true);
      this.getCompositeDisposable().add(this.getApiService().getCategories(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$CategoriesViewModel$Hs610l_ZSCWK0wmnVeL7Ej2KDoI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$CategoriesViewModel$HP1YQNGqlSENFx_1O5py1UXOk5U(this)).subscribe(new _$$Lambda$CategoriesViewModel$SCAqOIf3qkGhYrKuBeVggNRwFzg(this, var2), new _$$Lambda$CategoriesViewModel$gMHF2Bm9r7JVwGUXOV2V1kAf1e8(this)));
   }
}
