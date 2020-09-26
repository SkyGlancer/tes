/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.TextView
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class VariantInputTypeBinding
implements ViewBinding {
    public final TextView btnDelete;
    public final EditText editText;
    private final LinearLayout rootView;

    private VariantInputTypeBinding(LinearLayout linearLayout, TextView textView, EditText editText) {
        this.rootView = linearLayout;
        this.btnDelete = textView;
        this.editText = editText;
    }

    public static VariantInputTypeBinding bind(View view) {
        EditText editText;
        int n = 2131361919;
        TextView textView = (TextView)view.findViewById(n);
        if (textView != null && (editText = (EditText)view.findViewById(n = 2131362043)) != null) {
            return new VariantInputTypeBinding((LinearLayout)view, textView, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static VariantInputTypeBinding inflate(LayoutInflater layoutInflater) {
        return VariantInputTypeBinding.inflate(layoutInflater, null, false);
    }

    public static VariantInputTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558655, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return VariantInputTypeBinding.bind(view);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}

