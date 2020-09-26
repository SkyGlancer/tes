/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class LayoutStoreInfoCardBinding
implements ViewBinding {
    public final View copy;
    public final TextView link;
    private final MaterialCardView rootView;

    private LayoutStoreInfoCardBinding(MaterialCardView materialCardView, View view, TextView textView) {
        this.rootView = materialCardView;
        this.copy = view;
        this.link = textView;
    }

    public static LayoutStoreInfoCardBinding bind(View view) {
        TextView textView;
        int n = 2131361981;
        View view2 = view.findViewById(n);
        if (view2 != null && (textView = (TextView)view.findViewById(n = 2131362278)) != null) {
            return new LayoutStoreInfoCardBinding((MaterialCardView)view, view2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutStoreInfoCardBinding inflate(LayoutInflater layoutInflater) {
        return LayoutStoreInfoCardBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutStoreInfoCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558543, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutStoreInfoCardBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

