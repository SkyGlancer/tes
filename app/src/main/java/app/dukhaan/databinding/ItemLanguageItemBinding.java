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
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class ItemLanguageItemBinding
implements ViewBinding {
    public final ImageView idImgCheck;
    public final ConstraintLayout idItem;
    public final TextView idTitle;
    private final ConstraintLayout rootView;

    private ItemLanguageItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.idImgCheck = imageView;
        this.idItem = constraintLayout2;
        this.idTitle = textView;
    }

    public static ItemLanguageItemBinding bind(View view) {
        int n = 2131362182;
        ImageView imageView = (ImageView)view.findViewById(n);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout)view;
            TextView textView = (TextView)view.findViewById(2131362198);
            if (textView != null) {
                return new ItemLanguageItemBinding(constraintLayout, imageView, constraintLayout, textView);
            }
            n = 2131362198;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static ItemLanguageItemBinding inflate(LayoutInflater layoutInflater) {
        return ItemLanguageItemBinding.inflate(layoutInflater, null, false);
    }

    public static ItemLanguageItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558524, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ItemLanguageItemBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

