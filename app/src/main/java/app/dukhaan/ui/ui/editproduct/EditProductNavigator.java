package app.dukhaan.ui.ui.editproduct;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.data.model.Variant;
import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductResponse;
import java.util.List;

public interface EditProductNavigator extends BaseNavigator {
   void onCategoryListFetched(CategoryListResponse var1);

   void onProductDelete(DeleteProductResponse var1);

   void onProductImageUploadedToCloud(UploadImage var1, String var2, int var3, int var4);

   void onProductUpdateResponse(EditProductResponse var1);

   void productAdded(AddProductResponse var1);

   void variantsFound(List<Variant> var1);
}
