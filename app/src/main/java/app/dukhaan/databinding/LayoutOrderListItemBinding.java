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
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.Guideline
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public final class LayoutOrderListItemBinding
implements ViewBinding {
    public final ImageView arrow;
    public final ConstraintLayout body;
    public final TextView btnAccept;
    public final TextView btnCancelOrder;
    public final TextView btnDecline;
    public final TextView btnDeliverd;
    public final TextView btnNotDelivered;
    public final TextView btnShipOrder;
    public final MaterialCardView details;
    public final View divider;
    public final LinearLayout footer;
    public final Guideline guideline1;
    public final ConstraintLayout idFooterView;
    public final TextView itemCount;
    public final TextView lblDetails;
    public final TextView orderNumber;
    public final TextView price;
    private final MaterialCardView rootView;
    public final TextView status;
    public final View statusDot;
    public final ShapeableImageView thumbnail;
    public final TextView timestamp;

    private LayoutOrderListItemBinding(MaterialCardView materialCardView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, MaterialCardView materialCardView2, View view, LinearLayout linearLayout, Guideline guideline, ConstraintLayout constraintLayout2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2, ShapeableImageView shapeableImageView, TextView textView12) {
        this.rootView = materialCardView;
        this.arrow = imageView;
        this.body = constraintLayout;
        this.btnAccept = textView;
        this.btnCancelOrder = textView2;
        this.btnDecline = textView3;
        this.btnDeliverd = textView4;
        this.btnNotDelivered = textView5;
        this.btnShipOrder = textView6;
        this.details = materialCardView2;
        this.divider = view;
        this.footer = linearLayout;
        this.guideline1 = guideline;
        this.idFooterView = constraintLayout2;
        this.itemCount = textView7;
        this.lblDetails = textView8;
        this.orderNumber = textView9;
        this.price = textView10;
        this.status = textView11;
        this.statusDot = view2;
        this.thumbnail = shapeableImageView;
        this.timestamp = textView12;
    }

    public static LayoutOrderListItemBinding bind(View view) {
        View view2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        ConstraintLayout constraintLayout;
        Guideline guideline;
        TextView textView8;
        View view3;
        TextView textView9;
        MaterialCardView materialCardView;
        LinearLayout linearLayout;
        TextView textView10;
        ConstraintLayout constraintLayout2;
        TextView textView11;
        ShapeableImageView shapeableImageView;
        TextView textView12;
        int n = 2131361881;
        ImageView imageView = (ImageView)view.findViewById(n);
        if (imageView != null && (constraintLayout2 = (ConstraintLayout)view.findViewById(n = 2131361889)) != null && (textView = (TextView)view.findViewById(n = 2131361901)) != null && (textView10 = (TextView)view.findViewById(n = 2131361902)) != null && (textView5 = (TextView)view.findViewById(n = 2131361907)) != null && (textView3 = (TextView)view.findViewById(n = 2131361908)) != null && (textView8 = (TextView)view.findViewById(n = 2131361910)) != null && (textView7 = (TextView)view.findViewById(n = 2131361913)) != null && (materialCardView = (MaterialCardView)view.findViewById(n = 2131362031)) != null && (view2 = view.findViewById(n = 2131362038)) != null && (linearLayout = (LinearLayout)view.findViewById(n = 2131362078)) != null && (guideline = (Guideline)view.findViewById(n = 2131362102)) != null && (constraintLayout = (ConstraintLayout)view.findViewById(n = 2131362151)) != null && (textView12 = (TextView)view.findViewById(n = 2131362248)) != null && (textView11 = (TextView)view.findViewById(n = 2131362267)) != null && (textView9 = (TextView)view.findViewById(n = 2131362380)) != null && (textView6 = (TextView)view.findViewById(n = 2131362399)) != null && (textView2 = (TextView)view.findViewById(n = 2131362513)) != null && (view3 = view.findViewById(n = 2131362515)) != null && (shapeableImageView = (ShapeableImageView)view.findViewById(n = 2131362563)) != null && (textView4 = (TextView)view.findViewById(n = 2131362565)) != null) {
            LayoutOrderListItemBinding layoutOrderListItemBinding = new LayoutOrderListItemBinding((MaterialCardView)view, imageView, constraintLayout2, textView, textView10, textView5, textView3, textView8, textView7, materialCardView, view2, linearLayout, guideline, constraintLayout, textView12, textView11, textView9, textView6, textView2, view3, shapeableImageView, textView4);
            return layoutOrderListItemBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutOrderListItemBinding inflate(LayoutInflater layoutInflater) {
        return LayoutOrderListItemBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutOrderListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558537, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutOrderListItemBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

