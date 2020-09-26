/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.PopupMenu
 *  androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
 *  androidx.core.content.ContextCompat
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.products;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import app.dukhaan.app.GlideApp;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.LayoutProductListItemBinding;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.products.-$$Lambda$ProductListItemCard$ECd8FPfDJzs49zCM4v2GIncS3mk;
import app.dukhaan.ui.views.products.-$$Lambda$ProductListItemCard$QoWiGckUQMTI_yQ0qidOQtNdtVQ;
import app.dukhaan.ui.views.products.-$$Lambda$ProductListItemCard$UZo-Xkcx7UhUBlXzPeNrl70wL5Y;
import app.dukhaan.ui.views.products.-$$Lambda$ProductListItemCard$d-NvmbLqleHRPTDbWRflhW7leac;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.IpopUpMenuItem;
import app.dukhaan.util.PricingUtils;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

public class ProductListItemCard
extends FrameLayout
implements IdialogItemClickListner {
    LayoutProductListItemBinding binding;
    IpopUpMenuItem ipopUpMenuItem;
    MenuItemClickedListener menuItemClickedListener;
    Product product;

    public ProductListItemCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public ProductListItemCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public ProductListItemCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        if (this.product == null) {
            return;
        }
        this.binding.ivMenu.setOnClickListener((OnClickListener)new -$$Lambda$ProductListItemCard$d-NvmbLqleHRPTDbWRflhW7leac(this));
        this.binding.tvListed.setTextColor(this.getStatusColor());
        ImageView imageView = this.binding.ivSwitch;
        Context context = this.getContext();
        int n = this.product.isHidden() ? 2131231277 : 2131231278;
        imageView.setImageDrawable(ContextCompat.getDrawable((Context)context, (int)n));
        this.loadThumbnail();
        this.binding.shareProductLayout.setOnClickListener((OnClickListener)new -$$Lambda$ProductListItemCard$UZo-Xkcx7UhUBlXzPeNrl70wL5Y(this));
    }

    private int getStatusColor() {
        if (this.product.isHidden()) {
            return ContextCompat.getColor((Context)this.getContext(), (int)2131099917);
        }
        return ContextCompat.getColor((Context)this.getContext(), (int)2131099914);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutProductListItemBinding.inflate((LayoutInflater)context.getSystemService("layout_inflater"), (ViewGroup)this, true);
    }

    private void loadThumbnail() {
        if (this.product.getImage() == null) {
            return;
        }
        float f = this.getResources().getDimension(2131165688);
        this.binding.ivProduct.setShapeAppearanceModel(this.binding.ivProduct.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        if (!TextUtils.isEmpty((CharSequence)this.product.getImage())) {
            GlideApp.with((View)this).load(this.product.getImage()).into((ImageView)this.binding.ivProduct);
        }
    }

    public /* synthetic */ void lambda$applyStyle$2$ProductListItemCard(View view) {
        PopupMenu popupMenu = new PopupMenu(this.getContext(), (View)this.binding.ivMenu);
        popupMenu.setGravity(8388613);
        popupMenu.getMenuInflater().inflate(2131623944, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new -$$Lambda$ProductListItemCard$ECd8FPfDJzs49zCM4v2GIncS3mk(this));
        popupMenu.show();
    }

    public /* synthetic */ void lambda$applyStyle$3$ProductListItemCard(View view) {
        this.menuItemClickedListener.onShareCategoryClicked();
    }

    public /* synthetic */ boolean lambda$null$1$ProductListItemCard(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return false;
            }
            case 2131362307: {
                this.menuItemClickedListener.onEditCategoryNameClicked();
                return true;
            }
            case 2131362306: 
        }
        this.menuItemClickedListener.onDeleteCategoryClicked();
        return true;
    }

    public /* synthetic */ void lambda$setData$0$ProductListItemCard(View view) {
        this.menuItemClickedListener.switchIconClicked();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.applyStyle();
    }

    public void setData(Product product) {
        this.product = product;
        TextView textView = this.binding.tvProductName;
        String string2 = product.getName() == null ? "" : product.getName();
        textView.setText((CharSequence)string2);
        Double d = product.getOriginalCost() == null ? product.getBaseCost() : product.getOriginalCost();
        double d2 = product.getBaseCost() == null ? 0.0 : product.getBaseCost();
        Double d3 = d2;
        TextView textView2 = this.binding.tvPrice;
        Double d4 = d3 > 0.0 ? d3 : d;
        textView2.setText((CharSequence)PricingUtils.formatPriceWithCurrency(d4));
        this.binding.tvListed.setText((CharSequence)AppUtils.toProductStatus(this.getContext(), product.isHidden()));
        if (d3 > 0.0 && d > d3) {
            this.binding.tvOriginalPrice.setText((CharSequence)PricingUtils.formatPriceWithCurrency(d));
            this.binding.tvOriginalPrice.setPaintFlags(16 | this.binding.tvOriginalPrice.getPaintFlags());
            this.binding.tvOriginalPrice.setVisibility(0);
        } else {
            this.binding.tvOriginalPrice.setVisibility(8);
        }
        this.binding.ivSwitch.setOnClickListener((OnClickListener)new -$$Lambda$ProductListItemCard$QoWiGckUQMTI_yQ0qidOQtNdtVQ(this));
        this.applyStyle();
    }

    public void setMenuClickListener(MenuItemClickedListener menuItemClickedListener) {
        this.menuItemClickedListener = menuItemClickedListener;
    }

    @Override
    public void yesMakeIt() {
        Toast.makeText((Context)this.getContext(), (CharSequence)"Deleted Success", (int)0).show();
    }

}

