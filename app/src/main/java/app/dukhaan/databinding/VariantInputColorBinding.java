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

public final class VariantInputColorBinding
implements ViewBinding {
    public final TextView btnDelete;
    public final TextView colorBox;
    public final EditText editText;
    private final LinearLayout rootView;

    private VariantInputColorBinding(LinearLayout linearLayout, TextView textView, TextView textView2, EditText editText) {
        this.rootView = linearLayout;
        this.btnDelete = textView;
        this.colorBox = textView2;
        this.editText = editText;
    }

    public static VariantInputColorBinding bind(View view) {
        EditText editText;
        TextView textView;
        int n = 2131361919;
        TextView textView2 = (TextView)view.findViewById(n);
        if (textView2 != null && (textView = (TextView)view.findViewById(n = 2131361959)) != null && (editText = (EditText)view.findViewById(n = 2131362043)) != null) {
            return new VariantInputColorBinding((LinearLayout)view, textView2, textView, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static VariantInputColorBinding inflate(LayoutInflater layoutInflater) {
        return VariantInputColorBinding.inflate(layoutInflater, null, false);
    }

    public static VariantInputColorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558653, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return VariantInputColorBinding.bind(view);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}

