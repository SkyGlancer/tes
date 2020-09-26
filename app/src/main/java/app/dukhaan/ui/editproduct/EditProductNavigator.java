/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Variant
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.editproduct;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.data.model.Variant;
import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductResponse;
import java.util.List;

public interface EditProductNavigator
extends BaseNavigator {
    public void onCategoryListFetched(CategoryListResponse var1);

    public void onProductDelete(DeleteProductResponse var1);

    public void onProductImageUploadedToCloud(UploadImage var1, String var2, int var3, int var4);

    public void onProductUpdateResponse(EditProductResponse var1);

    public void productAdded(AddProductResponse var1);

    public void variantsFound(List<Variant> var1);
}

