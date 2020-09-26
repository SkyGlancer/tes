/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.editcategory;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.CreateCategoryResonse;

public interface EditCategoriesNavigator
extends BaseNavigator {
    public void onCategoryUpdateResponse(CreateCategoryResonse var1);
}

