package app.dukhaan.ui.ui.views.products;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import app.dukhaan.app.GlideApp;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.LayoutProductListItemBinding;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.PricingUtils;

public class ProductListItemCard extends FrameLayout implements IdialogItemClickListner {
   LayoutProductListItemBinding binding;
   IpopUpMenuItem ipopUpMenuItem;
   app.dukhaan.ui.views.products.ProductListItemCard.MenuItemClickedListener menuItemClickedListener;
   Product product;

   public ProductListItemCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public ProductListItemCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public ProductListItemCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      if (this.product != null) {
         this.binding.ivMenu.setOnClickListener(new _$$Lambda$ProductListItemCard$d_NvmbLqleHRPTDbWRflhW7leac(this));
         this.binding.tvListed.setTextColor(this.getStatusColor());
         ImageView var1 = this.binding.ivSwitch;
         Context var2 = this.getContext();
         int var3;
         if (this.product.isHidden()) {
            var3 = ic_switch_disabled;
         } else {
            var3 = ic_switch_enabled;
         }

         var1.setImageDrawable(ContextCompat.getDrawable(var2, var3));
         this.loadThumbnail();
         this.binding.shareProductLayout.setOnClickListener(new _$$Lambda$ProductListItemCard$UZo_Xkcx7UhUBlXzPeNrl70wL5Y(this));
      }
   }

   private int getStatusColor() {
      int var1;
      if (this.product.isHidden()) {
         var1 = ContextCompat.getColor(R.color.this.getContext(), order_status_rejected);
      } else {
         var1 = ContextCompat.getColor(R.color.this.getContext(), order_status_accepted);
      }

      return var1;
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutProductListItemBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void loadThumbnail() {
      if (this.product.getImage() != null) {
         float var1 = this.getResources().getDimension(thumbnail_min_corner_radius);
         this.binding.ivProduct.setShapeAppearanceModel(this.binding.ivProduct.getShapeAppearanceModel().toBuilder().setAllCorners(0, var1).build());
         if (!TextUtils.isEmpty(this.product.getImage())) {
            GlideApp.with(this).load(this.product.getImage()).into(this.binding.ivProduct);
         }

      }
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.applyStyle();
   }

   public void setData(Product var1) {
      this.product = var1;
      TextView var2 = this.binding.tvProductName;
      String var3;
      if (var1.getName() == null) {
         var3 = "";
      } else {
         var3 = var1.getName();
      }

      var2.setText(var3);
      Double var9;
      if (var1.getOriginalCost() == null) {
         var9 = var1.getBaseCost();
      } else {
         var9 = var1.getOriginalCost();
      }

      double var4;
      if (var1.getBaseCost() == null) {
         var4 = 0.0D;
      } else {
         var4 = var1.getBaseCost();
      }

      Double var6 = var4;
      TextView var7 = this.binding.tvPrice;
      Double var8;
      if (var6 > 0.0D) {
         var8 = var6;
      } else {
         var8 = var9;
      }

      var7.setText(PricingUtils.formatPriceWithCurrency(var8));
      this.binding.tvListed.setText(AppUtils.toProductStatus(this.getContext(), var1.isHidden()));
      if (var6 > 0.0D && var9 > var6) {
         this.binding.tvOriginalPrice.setText(PricingUtils.formatPriceWithCurrency(var9));
         this.binding.tvOriginalPrice.setPaintFlags(this.binding.tvOriginalPrice.getPaintFlags() | 16);
         this.binding.tvOriginalPrice.setVisibility(0);
      } else {
         this.binding.tvOriginalPrice.setVisibility(8);
      }

      this.binding.ivSwitch.setOnClickListener(new _$$Lambda$ProductListItemCard$QoWiGckUQMTI_yQ0qidOQtNdtVQ(this));
      this.applyStyle();
   }

   public void setMenuClickListener(app.dukhaan.ui.views.products.ProductListItemCard.MenuItemClickedListener var1) {
      this.menuItemClickedListener = var1;
   }

   public void yesMakeIt() {
      Toast.makeText(this.getContext(), "Deleted Success", 0).show();
   }
}
