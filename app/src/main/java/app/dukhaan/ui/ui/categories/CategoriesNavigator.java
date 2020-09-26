package app.dukhaan.ui.ui.categories;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.DeleteCategoryResonse;
import java.util.List;

public interface CategoriesNavigator extends BaseNavigator {
   void onCategoryDelete(DeleteCategoryResonse var1, int var2);

   void onCategoryListFetched(List<Category> var1, boolean var2);
}
