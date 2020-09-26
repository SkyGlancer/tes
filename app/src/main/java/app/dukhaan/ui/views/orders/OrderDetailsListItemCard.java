/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.cardview.widget.CardView
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.databinding.LayoutOrderDetailItemCardBinding
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  io.realm.RealmList
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  timber.log.Timber
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.LayoutOrderDetailItemCardBinding;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.realm.RealmList;
import timber.log.Timber;

public class OrderDetailsListItemCard
extends FrameLayout {
    private LayoutOrderDetailItemCardBinding binding;
    private Product data;

    public OrderDetailsListItemCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public OrderDetailsListItemCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public OrderDetailsListItemCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        if (this.data == null) {
            return;
        }
        this.loadThumbnail();
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutOrderDetailItemCardBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void loadThumbnail() {
        float f = this.getResources().getDimension(2131165688);
        this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        if (!TextUtils.isEmpty((CharSequence)this.data.getImage())) {
            GlideApp.with((View)this).load(this.data.getImage()).into((ImageView)this.binding.thumbnail);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.applyStyle();
    }

    public void setData(Product product) {
        String string2;
        String[] arrstring = new String[]{};
        this.data = product;
        this.binding.tvOrderName.setText((CharSequence)product.getName());
        TextView textView = this.binding.tvPrice;
        Object[] arrobject = new Object[]{product.getBaseCost()};
        textView.setText((CharSequence)String.format((String)"x %s", (Object[])arrobject));
        this.binding.tvOrderCount.setText((CharSequence)String.valueOf((int)product.realmGet$orderedQty()));
        double d = product.realmGet$orderedQty();
        double d2 = product.getBaseCost();
        Double.isNaN((double)d);
        double d3 = d * d2;
        TextView textView2 = this.binding.tvTotalPrice;
        Context context = this.getContext();
        Object[] arrobject2 = new Object[]{d3};
        textView2.setText((CharSequence)context.getString(2131951909, arrobject2));
        if (product.realmGet$variants() != null && product.realmGet$variants().size() > 0) {
            arrstring = ((String)product.realmGet$variants().first()).split(",,");
        }
        int n = arrstring.length;
        String string3 = string2 = "";
        for (int i = 0; i < n; ++i) {
            String string4 = arrstring[i];
            if (string4.startsWith("1")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("Size : ");
                stringBuilder.append(string4.split("::")[1]);
                string2 = stringBuilder.toString();
            }
            if (!string4.startsWith("2")) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" | Colour : ");
            string2 = stringBuilder.toString();
            string3 = string4.split("::")[1];
        }
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.binding.variantLabel.setText((CharSequence)string2);
            this.binding.variantLabel.setVisibility(0);
        } else {
            this.binding.variantLabel.setVisibility(8);
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            try {
                this.binding.variantColorBox.setCardBackgroundColor(Color.parseColor((String)string3));
                this.binding.variantColorBox.setVisibility(0);
            }
            catch (Exception exception) {
                Timber.e((Throwable)exception);
            }
        } else {
            this.binding.variantColorBox.setVisibility(8);
        }
        this.applyStyle();
    }
}

