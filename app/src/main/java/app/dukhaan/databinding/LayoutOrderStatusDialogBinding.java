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

public final class LayoutOrderStatusDialogBinding
implements ViewBinding {
    private final MaterialCardView rootView;
    public final ImageView thumbStatus;
    public final TextView tvClose;
    public final TextView tvContent;
    public final TextView tvYes;

    private LayoutOrderStatusDialogBinding(MaterialCardView materialCardView, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = materialCardView;
        this.thumbStatus = imageView;
        this.tvClose = textView;
        this.tvContent = textView2;
        this.tvYes = textView3;
    }

    public static LayoutOrderStatusDialogBinding bind(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        int n = 2131362562;
        ImageView imageView = (ImageView)view.findViewById(n);
        if (imageView != null && (textView3 = (TextView)view.findViewById(n = 2131362591)) != null && (textView = (TextView)view.findViewById(n = 2131362594)) != null && (textView2 = (TextView)view.findViewById(n = 2131362624)) != null) {
            LayoutOrderStatusDialogBinding layoutOrderStatusDialogBinding = new LayoutOrderStatusDialogBinding((MaterialCardView)view, imageView, textView3, textView, textView2);
            return layoutOrderStatusDialogBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutOrderStatusDialogBinding inflate(LayoutInflater layoutInflater) {
        return LayoutOrderStatusDialogBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutOrderStatusDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558538, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutOrderStatusDialogBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

