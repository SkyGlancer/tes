/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.card.MaterialCardView
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public final class LayoutProductListItemBinding
implements ViewBinding {
    public final View dividerGrand;
    public final ImageView ivMenu;
    public final ShapeableImageView ivProduct;
    public final ImageView ivSwitch;
    private final MaterialCardView rootView;
    public final LinearLayout shareProductLayout;
    public final TextView tvListed;
    public final TextView tvOriginalPrice;
    public final TextView tvPrice;
    public final TextView tvProductName;

    private LayoutProductListItemBinding(MaterialCardView materialCardView, View view, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = materialCardView;
        this.dividerGrand = view;
        this.ivMenu = imageView;
        this.ivProduct = shapeableImageView;
        this.ivSwitch = imageView2;
        this.shareProductLayout = linearLayout;
        this.tvListed = textView;
        this.tvOriginalPrice = textView2;
        this.tvPrice = textView3;
        this.tvProductName = textView4;
    }

    public static LayoutProductListItemBinding bind(View view) {
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        TextView textView2;
        TextView textView3;
        ShapeableImageView shapeableImageView;
        TextView textView4;
        ImageView imageView2;
        int n = 2131362039;
        View view2 = view.findViewById(n);
        if (view2 != null && (imageView = (ImageView)view.findViewById(n = 2131362252)) != null && (shapeableImageView = (ShapeableImageView)view.findViewById(n = 2131362254)) != null && (imageView2 = (ImageView)view.findViewById(n = 2131362255)) != null && (linearLayout = (LinearLayout)view.findViewById(n = 2131362466)) != null && (textView2 = (TextView)view.findViewById(n = 2131362603)) != null && (textView = (TextView)view.findViewById(n = 2131362610)) != null && (textView3 = (TextView)view.findViewById(n = 2131362616)) != null && (textView4 = (TextView)view.findViewById(n = 2131362617)) != null) {
            LayoutProductListItemBinding layoutProductListItemBinding = new LayoutProductListItemBinding((MaterialCardView)view, view2, imageView, shapeableImageView, imageView2, linearLayout, textView2, textView, textView3, textView4);
            return layoutProductListItemBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutProductListItemBinding inflate(LayoutInflater layoutInflater) {
        return LayoutProductListItemBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutProductListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558539, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutProductListItemBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

