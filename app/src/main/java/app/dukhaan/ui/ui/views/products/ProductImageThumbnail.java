package app.dukhaan.ui.ui.views.products;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.ProductImageThumbnailEditableBinding;

public class ProductImageThumbnail extends FrameLayout {
   private ProductImageThumbnailEditableBinding binding;

   public ProductImageThumbnail(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public ProductImageThumbnail(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public ProductImageThumbnail(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = ProductImageThumbnailEditableBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }
}
