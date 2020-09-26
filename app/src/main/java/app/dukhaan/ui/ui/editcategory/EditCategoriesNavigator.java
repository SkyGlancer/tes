package app.dukhaan.ui.ui.editcategory;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.CreateCategoryResonse;

public interface EditCategoriesNavigator extends BaseNavigator {
   void onCategoryUpdateResponse(CreateCategoryResonse var1);
}
