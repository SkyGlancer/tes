/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
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
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class PopupCountryPickerBinding
implements ViewBinding {
    public final RecyclerView countriesRecyclerView;
    public final EditText countryCodePickerSearch;
    private final MaterialCardView rootView;

    private PopupCountryPickerBinding(MaterialCardView materialCardView, RecyclerView recyclerView, EditText editText) {
        this.rootView = materialCardView;
        this.countriesRecyclerView = recyclerView;
        this.countryCodePickerSearch = editText;
    }

    public static PopupCountryPickerBinding bind(View view) {
        EditText editText;
        int n = 2131361984;
        RecyclerView recyclerView = (RecyclerView)view.findViewById(n);
        if (recyclerView != null && (editText = (EditText)view.findViewById(n = 2131361985)) != null) {
            return new PopupCountryPickerBinding((MaterialCardView)view, recyclerView, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static PopupCountryPickerBinding inflate(LayoutInflater layoutInflater) {
        return PopupCountryPickerBinding.inflate(layoutInflater, null, false);
    }

    public static PopupCountryPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558602, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return PopupCountryPickerBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

