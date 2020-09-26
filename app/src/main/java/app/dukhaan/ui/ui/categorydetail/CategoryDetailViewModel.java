package app.dukhaan.ui.ui.categorydetail;

import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.categorydetail.CategoryDetailNaivigator;

public class CategoryDetailViewModel extends BaseViewModel<CategoryDetailNaivigator> {
   public CategoryDetailViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }
}
