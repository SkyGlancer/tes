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

public final class LayoutStatCardBinding
implements ViewBinding {
    public final TextView label;
    private final MaterialCardView rootView;
    public final TextView value;

    private LayoutStatCardBinding(MaterialCardView materialCardView, TextView textView, TextView textView2) {
        this.rootView = materialCardView;
        this.label = textView;
        this.value = textView2;
    }

    public static LayoutStatCardBinding bind(View view) {
        TextView textView;
        int n = 2131362256;
        TextView textView2 = (TextView)view.findViewById(n);
        if (textView2 != null && (textView = (TextView)view.findViewById(n = 2131362636)) != null) {
            return new LayoutStatCardBinding((MaterialCardView)view, textView2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutStatCardBinding inflate(LayoutInflater layoutInflater) {
        return LayoutStatCardBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutStatCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558540, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutStatCardBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

