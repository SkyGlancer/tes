/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class PopupCategoryMenuBinding
implements ViewBinding {
    public final TextView btnEditCategory;
    public final TextView btnShareCategory;
    public final TextView idBtnDeleteCategory;
    private final ConstraintLayout rootView;

    private PopupCategoryMenuBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnEditCategory = textView;
        this.btnShareCategory = textView2;
        this.idBtnDeleteCategory = textView3;
    }

    public static PopupCategoryMenuBinding bind(View view) {
        TextView textView;
        TextView textView2;
        int n = 2131361909;
        TextView textView3 = (TextView)view.findViewById(n);
        if (textView3 != null && (textView2 = (TextView)view.findViewById(n = 2131361912)) != null && (textView = (TextView)view.findViewById(n = 2131362140)) != null) {
            return new PopupCategoryMenuBinding((ConstraintLayout)view, textView3, textView2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static PopupCategoryMenuBinding inflate(LayoutInflater layoutInflater) {
        return PopupCategoryMenuBinding.inflate(layoutInflater, null, false);
    }

    public static PopupCategoryMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558600, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return PopupCategoryMenuBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

