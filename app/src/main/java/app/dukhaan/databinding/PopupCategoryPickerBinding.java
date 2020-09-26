/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
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
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class PopupCategoryPickerBinding
implements ViewBinding {
    public final TextView idAddNewCategory;
    public final RecyclerView recyclerviewCategory;
    private final MaterialCardView rootView;
    public final View view;

    private PopupCategoryPickerBinding(MaterialCardView materialCardView, TextView textView, RecyclerView recyclerView, View view) {
        this.rootView = materialCardView;
        this.idAddNewCategory = textView;
        this.recyclerviewCategory = recyclerView;
        this.view = view;
    }

    public static PopupCategoryPickerBinding bind(View view) {
        View view2;
        RecyclerView recyclerView;
        int n = 2131362138;
        TextView textView = (TextView)view.findViewById(n);
        if (textView != null && (recyclerView = (RecyclerView)view.findViewById(n = 2131362416)) != null && (view2 = view.findViewById(n = 2131362642)) != null) {
            return new PopupCategoryPickerBinding((MaterialCardView)view, textView, recyclerView, view2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static PopupCategoryPickerBinding inflate(LayoutInflater layoutInflater) {
        return PopupCategoryPickerBinding.inflate(layoutInflater, null, false);
    }

    public static PopupCategoryPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558601, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return PopupCategoryPickerBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

