package app.dukhaan.ui.ui.editcategory;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.EditCategoryRequest;
import app.dukhaan.ui.editcategory.EditCategoriesNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EditCategoriesViewModel extends BaseViewModel<EditCategoriesNavigator> {
   public EditCategoriesViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void updateCategory(EditCategoryRequest var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().editCategory(var2, var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditCategoriesViewModel$DzV4FuYI1pGauZ1fMCLoqrcRgYM(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditCategoriesViewModel$xoNqm5AcaOcYa_BOXh5VfrQ_uvM(this)).subscribe(new _$$Lambda$EditCategoriesViewModel$3Igv2Ibd4h2g8t_H3NCrWpou_Rs(this), new _$$Lambda$EditCategoriesViewModel$lh7KuzMEtaJj63_mXjBNkVQCBAg(this)));
   }
}
