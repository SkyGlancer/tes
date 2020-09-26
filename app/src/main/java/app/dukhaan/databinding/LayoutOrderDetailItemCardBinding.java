/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.cardview.widget.CardView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;

public final class LayoutOrderDetailItemCardBinding
implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ShapeableImageView thumbnail;
    public final TextView tvOrderCount;
    public final TextView tvOrderName;
    public final TextView tvPrice;
    public final TextView tvTotalPrice;
    public final CardView variantColorBox;
    public final LinearLayout variantContainer;
    public final TextView variantLabel;

    private LayoutOrderDetailItemCardBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, CardView cardView, LinearLayout linearLayout, TextView textView5) {
        this.rootView = constraintLayout;
        this.thumbnail = shapeableImageView;
        this.tvOrderCount = textView;
        this.tvOrderName = textView2;
        this.tvPrice = textView3;
        this.tvTotalPrice = textView4;
        this.variantColorBox = cardView;
        this.variantContainer = linearLayout;
        this.variantLabel = textView5;
    }

    public static LayoutOrderDetailItemCardBinding bind(View view) {
        CardView cardView;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        int n = 2131362563;
        ShapeableImageView shapeableImageView = (ShapeableImageView)view.findViewById(n);
        if (shapeableImageView != null && (textView4 = (TextView)view.findViewById(n = 2131362607)) != null && (textView = (TextView)view.findViewById(n = 2131362608)) != null && (textView2 = (TextView)view.findViewById(n = 2131362616)) != null && (textView3 = (TextView)view.findViewById(n = 2131362623)) != null && (cardView = (CardView)view.findViewById(n = 2131362637)) != null && (linearLayout = (LinearLayout)view.findViewById(n = 2131362638)) != null && (textView5 = (TextView)view.findViewById(n = 2131362639)) != null) {
            LayoutOrderDetailItemCardBinding layoutOrderDetailItemCardBinding = new LayoutOrderDetailItemCardBinding((ConstraintLayout)view, shapeableImageView, textView4, textView, textView2, textView3, cardView, linearLayout, textView5);
            return layoutOrderDetailItemCardBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutOrderDetailItemCardBinding inflate(LayoutInflater layoutInflater) {
        return LayoutOrderDetailItemCardBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutOrderDetailItemCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558534, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutOrderDetailItemCardBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

