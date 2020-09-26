package app.dukhaan.ui.ui.products;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductResponse;
import java.util.List;

public interface ProductsNavigator extends BaseNavigator {
   void onProductDelete(DeleteProductResponse var1, int var2);

   void onProductUpdateResponse(EditProductResponse var1, boolean var2);

   void searchProducts(List<Product> var1);

   void showProducts(List<Product> var1, boolean var2);
}
