package app.dukhaan.ui.ui.views.orders;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.app.GlideApp;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.LayoutOrderDetailItemCardBinding;
import timber.log.Timber;

public class OrderDetailsListItemCard extends FrameLayout {
   private LayoutOrderDetailItemCardBinding binding;
   private Product data;

   public OrderDetailsListItemCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public OrderDetailsListItemCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public OrderDetailsListItemCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      if (this.data != null) {
         this.loadThumbnail();
      }
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutOrderDetailItemCardBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void loadThumbnail() {
      float var1 = this.getResources().getDimension(thumbnail_min_corner_radius);
      this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, var1).build());
      if (!TextUtils.isEmpty(this.data.getImage())) {
         GlideApp.with(this).load(this.data.getImage()).into(this.binding.thumbnail);
      }

   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.applyStyle();
   }

   public void setData(Product var1) {
      String[] var2 = new String[0];
      this.data = var1;
      this.binding.tvOrderName.setText(var1.getName());
      this.binding.tvPrice.setText(String.format("x %s", var1.getBaseCost()));
      this.binding.tvOrderCount.setText(String.valueOf(var1.realmGet$orderedQty()));
      double var3 = (double)var1.realmGet$orderedQty();
      double var5 = var1.getBaseCost();
      Double.isNaN(var3);
      this.binding.tvTotalPrice.setText(this.getContext().getString(R.string.price_format, new Object[]{var3 * var5}));
      String[] var7 = var2;
      if (var1.realmGet$variants() != null) {
         var7 = var2;
         if (var1.realmGet$variants().size() > 0) {
            var7 = ((String)var1.realmGet$variants().first()).split(",,");
         }
      }

      int var8 = var7.length;
      String var15 = "";
      String var9 = "";

      for(int var10 = 0; var10 < var8; ++var10) {
         String var11 = var7[var10];
         String var13 = var15;
         if (var11.startsWith("1")) {
            StringBuilder var14 = new StringBuilder();
            var14.append(var15);
            var14.append("Size : ");
            var14.append(var11.split("::")[1]);
            var13 = var14.toString();
         }

         var15 = var13;
         if (var11.startsWith("2")) {
            StringBuilder var16 = new StringBuilder();
            var16.append(var13);
            var16.append(" | Colour : ");
            var15 = var16.toString();
            var9 = var11.split("::")[1];
         }
      }

      if (!TextUtils.isEmpty(var15)) {
         this.binding.variantLabel.setText(var15);
         this.binding.variantLabel.setVisibility(0);
      } else {
         this.binding.variantLabel.setVisibility(8);
      }

      if (!TextUtils.isEmpty(var9)) {
         try {
            this.binding.variantColorBox.setCardBackgroundColor(Color.parseColor(var9));
            this.binding.variantColorBox.setVisibility(0);
         } catch (Exception var12) {
            Timber.e(var12);
         }
      } else {
         this.binding.variantColorBox.setVisibility(8);
      }

      this.applyStyle();
   }
}
