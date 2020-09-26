/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.card.MaterialCardView
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
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class LayoutCustomDialogBinding
implements ViewBinding {
    public final ImageView ivNotDelivered;
    private final MaterialCardView rootView;
    public final TextView tvClose;
    public final TextView tvContent;
    public final TextView tvYes;

    private LayoutCustomDialogBinding(MaterialCardView materialCardView, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = materialCardView;
        this.ivNotDelivered = imageView;
        this.tvClose = textView;
        this.tvContent = textView2;
        this.tvYes = textView3;
    }

    public static LayoutCustomDialogBinding bind(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        int n = 2131362253;
        ImageView imageView = (ImageView)view.findViewById(n);
        if (imageView != null && (textView3 = (TextView)view.findViewById(n = 2131362591)) != null && (textView = (TextView)view.findViewById(n = 2131362594)) != null && (textView2 = (TextView)view.findViewById(n = 2131362624)) != null) {
            LayoutCustomDialogBinding layoutCustomDialogBinding = new LayoutCustomDialogBinding((MaterialCardView)view, imageView, textView3, textView, textView2);
            return layoutCustomDialogBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutCustomDialogBinding inflate(LayoutInflater layoutInflater) {
        return LayoutCustomDialogBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutCustomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558532, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutCustomDialogBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

