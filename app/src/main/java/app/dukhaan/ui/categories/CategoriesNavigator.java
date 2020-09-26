/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Category
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.categories;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.DeleteCategoryResonse;
import java.util.List;

public interface CategoriesNavigator
extends BaseNavigator {
    public void onCategoryDelete(DeleteCategoryResonse var1, int var2);

    public void onCategoryListFetched(List<Category> var1, boolean var2);
}

