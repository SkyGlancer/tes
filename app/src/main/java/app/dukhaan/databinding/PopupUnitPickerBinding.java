/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class PopupUnitPickerBinding
implements ViewBinding {
    public final RecyclerView recyclerview;
    private final MaterialCardView rootView;

    private PopupUnitPickerBinding(MaterialCardView materialCardView, RecyclerView recyclerView) {
        this.rootView = materialCardView;
        this.recyclerview = recyclerView;
    }

    public static PopupUnitPickerBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView)view.findViewById(2131362414);
        if (recyclerView != null) {
            return new PopupUnitPickerBinding((MaterialCardView)view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362414)));
    }

    public static PopupUnitPickerBinding inflate(LayoutInflater layoutInflater) {
        return PopupUnitPickerBinding.inflate(layoutInflater, null, false);
    }

    public static PopupUnitPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558604, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return PopupUnitPickerBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

