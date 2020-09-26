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

public final class LayoutCategoryBinding
implements ViewBinding {
    public final ImageView idBtnMenu;
    public final TextView idLblCategoryTitle;
    public final TextView idLblQty;
    private final MaterialCardView rootView;

    private LayoutCategoryBinding(MaterialCardView materialCardView, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = materialCardView;
        this.idBtnMenu = imageView;
        this.idLblCategoryTitle = textView;
        this.idLblQty = textView2;
    }

    public static LayoutCategoryBinding bind(View view) {
        TextView textView;
        TextView textView2;
        int n = 2131362166;
        ImageView imageView = (ImageView)view.findViewById(n);
        if (imageView != null && (textView2 = (TextView)view.findViewById(n = 2131362193)) != null && (textView = (TextView)view.findViewById(n = 2131362195)) != null) {
            return new LayoutCategoryBinding((MaterialCardView)view, imageView, textView2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutCategoryBinding inflate(LayoutInflater layoutInflater) {
        return LayoutCategoryBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558530, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutCategoryBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

