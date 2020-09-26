/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.products;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductResponse;
import java.util.List;

public interface ProductsNavigator
extends BaseNavigator {
    public void onProductDelete(DeleteProductResponse var1, int var2);

    public void onProductUpdateResponse(EditProductResponse var1, boolean var2);

    public void searchProducts(List<Product> var1);

    public void showProducts(List<Product> var1, boolean var2);
}

