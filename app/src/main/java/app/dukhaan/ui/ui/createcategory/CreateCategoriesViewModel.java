package app.dukhaan.ui.ui.createcategory;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.CreateCategoryRequest;
import app.dukhaan.ui.createcategory.CreateCategoriesNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CreateCategoriesViewModel extends BaseViewModel<CreateCategoriesNavigator> {
   public CreateCategoriesViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void createCategory(CreateCategoryRequest var1) {
      this.getCompositeDisposable().add(this.getApiService().createCategory(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$CreateCategoriesViewModel$taC_PiHuBZtonY_II40hKuHzi8E(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$CreateCategoriesViewModel$i9zlc3HZRtZCYtHLw_YwXoIJEDw(this)).subscribe(new _$$Lambda$CreateCategoriesViewModel$K6wOUrFJ82ddj7vwyrMT6IichmQ(this), new _$$Lambda$CreateCategoriesViewModel$1dvL29eFxLb66L2eHLeKDwSBVjI(this)));
   }
}
