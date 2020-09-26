/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.views.products;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.app.GlideApp;
import app.dukhaan.databinding.AddProductCameraIconBinding;
import app.dukhaan.databinding.ProductImageThumbnailEditableBinding;
import app.dukhaan.ui.views.products.-$$Lambda$ProductImagesListAdapter$B_XkyoIE6hmahHkf6obrwrxDIe4;
import app.dukhaan.ui.views.products.-$$Lambda$ProductImagesListAdapter$uGyVSeambVU0jsOp8NloweOPGPM;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.List;

public class ProductImagesListAdapter
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int VIEW_CAMERA_ICON = 1;
    private int VIEW_PRODUCT_IMAGE = 2;
    private List<String> images;
    private boolean isAddImageDisabled;
    private ProductImagesListAdapterListener listener;

    public ProductImagesListAdapter(ProductImagesListAdapterListener productImagesListAdapterListener, List<String> list) {
        this.listener = productImagesListAdapterListener;
        this.images = list;
    }

    private void toggleAddImageClick(AddProductImageViewHolder addProductImageViewHolder, boolean bl) {
        addProductImageViewHolder.binding.addImage.setEnabled(bl);
        addProductImageViewHolder.binding.addImage.setFocusable(bl);
        ConstraintLayout constraintLayout = addProductImageViewHolder.binding.addImage;
        float f = 1.0f;
        float f2 = bl ? 1.0f : 0.4f;
        constraintLayout.setAlpha(f2);
        addProductImageViewHolder.binding.icon.setEnabled(true);
        addProductImageViewHolder.binding.icon.setFocusable(true);
        ImageView imageView = addProductImageViewHolder.binding.icon;
        if (!bl) {
            f = 0.4f;
        }
        imageView.setAlpha(f);
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
        return 1 + this.images.size();
    }

    public int getItemViewType(int n) {
        if (n == 0) {
            return this.VIEW_CAMERA_ICON;
        }
        return this.VIEW_PRODUCT_IMAGE;
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$ProductImagesListAdapter(View view) {
        this.listener.onProductImageAddClicked();
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$ProductImagesListAdapter(RecyclerView.ViewHolder viewHolder, View view) {
        int n = viewHolder.getAdapterPosition();
        List<String> list = this.images;
        int n2 = n - 1;
        String string2 = (String)list.get(n2);
        this.images.remove(n2);
        this.notifyItemRemoved(n);
        this.listener.onProductImageRemoved(n2, string2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        if (viewHolder.getItemViewType() == this.VIEW_CAMERA_ICON) {
            AddProductImageViewHolder addProductImageViewHolder = (AddProductImageViewHolder)viewHolder;
            this.toggleAddImageClick(addProductImageViewHolder, true ^ this.isAddImageDisabled);
            addProductImageViewHolder.binding.addImage.setOnClickListener((View.OnClickListener)new -$$Lambda$ProductImagesListAdapter$uGyVSeambVU0jsOp8NloweOPGPM(this));
            return;
        }
        ProductThumbnailItemViewHolder productThumbnailItemViewHolder = (ProductThumbnailItemViewHolder)viewHolder;
        productThumbnailItemViewHolder.bind(n);
        productThumbnailItemViewHolder.binding.remove.setOnClickListener((View.OnClickListener)new -$$Lambda$ProductImagesListAdapter$B_XkyoIE6hmahHkf6obrwrxDIe4(this, viewHolder));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        if (n == 1) {
            return new AddProductImageViewHolder((AddProductCameraIconBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558454, (ViewGroup)viewGroup, (boolean)false));
        }
        return new ProductThumbnailItemViewHolder((ProductImageThumbnailEditableBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558621, (ViewGroup)viewGroup, (boolean)false));
    }

    public void setData(List<String> list) {
        this.images = list;
        this.notifyDataSetChanged();
    }

    class AddProductImageViewHolder
    extends RecyclerView.ViewHolder {
        AddProductCameraIconBinding binding;

        public AddProductImageViewHolder(AddProductCameraIconBinding addProductCameraIconBinding) {
            super(addProductCameraIconBinding.getRoot());
            this.binding = addProductCameraIconBinding;
        }
    }

    class ProductThumbnailItemViewHolder
    extends RecyclerView.ViewHolder {
        ProductImageThumbnailEditableBinding binding;

        ProductThumbnailItemViewHolder(ProductImageThumbnailEditableBinding productImageThumbnailEditableBinding) {
            super(productImageThumbnailEditableBinding.getRoot());
            this.binding = productImageThumbnailEditableBinding;
        }

        void bind(int n) {
            String string2 = (String)ProductImagesListAdapter.this.images.get(n - 1);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                float f = this.binding.image.getContext().getResources().getDimension(2131165217);
                this.binding.image.setShapeAppearanceModel(this.binding.image.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
                GlideApp.with(this.binding.image.getContext()).load(string2).into((ImageView)this.binding.image);
            }
        }
    }

}

