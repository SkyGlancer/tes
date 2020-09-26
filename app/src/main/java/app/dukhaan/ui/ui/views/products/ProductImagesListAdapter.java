package app.dukhaan.ui.ui.views.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import app.dukhaan.databinding.AddProductCameraIconBinding;
import app.dukhaan.databinding.ProductImageThumbnailEditableBinding;
import java.util.List;

public class ProductImagesListAdapter extends Adapter<ViewHolder> {
   private int VIEW_CAMERA_ICON = 1;
   private int VIEW_PRODUCT_IMAGE = 2;
   private List<String> images;
   private boolean isAddImageDisabled;
   private app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductImagesListAdapterListener listener;

   public ProductImagesListAdapter(app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductImagesListAdapterListener var1, List<String> var2) {
      this.listener = var1;
      this.images = var2;
   }

   private void toggleAddImageClick(app.dukhaan.ui.views.products.ProductImagesListAdapter.AddProductImageViewHolder var1, boolean var2) {
      var1.binding.addImage.setEnabled(var2);
      var1.binding.addImage.setFocusable(var2);
      ConstraintLayout var3 = var1.binding.addImage;
      float var4 = 1.0F;
      float var5;
      if (var2) {
         var5 = 1.0F;
      } else {
         var5 = 0.4F;
      }

      var3.setAlpha(var5);
      var1.binding.icon.setEnabled(true);
      var1.binding.icon.setFocusable(true);
      ImageView var6 = var1.binding.icon;
      if (var2) {
         var5 = var4;
      } else {
         var5 = 0.4F;
      }

      var6.setAlpha(var5);
   }

   public void disableAddImage() {
      this.isAddImageDisabled = true;
      this.notifyItemChanged(0);
   }

   public void enableAddImage() {
      this.isAddImageDisabled = false;
      this.notifyItemChanged(0);
   }

   public int getItemCount() {
      return this.images.size() + 1;
   }

   public int getItemViewType(int var1) {
      if (var1 == 0) {
         var1 = this.VIEW_CAMERA_ICON;
      } else {
         var1 = this.VIEW_PRODUCT_IMAGE;
      }

      return var1;
   }

   public void onBindViewHolder(ViewHolder var1, int var2) {
      if (var1.getItemViewType() == this.VIEW_CAMERA_ICON) {
         app.dukhaan.ui.views.products.ProductImagesListAdapter.AddProductImageViewHolder var4 = (app.dukhaan.ui.views.products.ProductImagesListAdapter.AddProductImageViewHolder)var1;
         this.toggleAddImageClick(var4, this.isAddImageDisabled ^ true);
         var4.binding.addImage.setOnClickListener(new _$$Lambda$ProductImagesListAdapter$uGyVSeambVU0jsOp8NloweOPGPM(this));
      } else {
         app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductThumbnailItemViewHolder var3 = (app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductThumbnailItemViewHolder)var1;
         var3.bind(var2);
         var3.binding.remove.setOnClickListener(new _$$Lambda$ProductImagesListAdapter$B_XkyoIE6hmahHkf6obrwrxDIe4(this, var1));
      }

   }

   public ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return (ViewHolder)(var2 == 1 ? new app.dukhaan.ui.views.products.ProductImagesListAdapter.AddProductImageViewHolder(this, (AddProductCameraIconBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), add_product_camera_icon, var1, false)) : new app.dukhaan.ui.views.products.ProductImagesListAdapter.ProductThumbnailItemViewHolder(this, (ProductImageThumbnailEditableBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), product_image_thumbnail_editable, var1, false)));
   }

   public void setData(List<String> var1) {
      this.images = var1;
      this.notifyDataSetChanged();
   }
}
