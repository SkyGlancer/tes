/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import app.dukhaan.ui.views.PrimaryButton;

public final class ModalReferSuccessBinding
implements ViewBinding {
    public final PrimaryButton btnClose;
    public final TextView referDesc;
    public final TextView referTitle;
    private final LinearLayout rootView;

    private ModalReferSuccessBinding(LinearLayout linearLayout, PrimaryButton primaryButton, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnClose = primaryButton;
        this.referDesc = textView;
        this.referTitle = textView2;
    }

    public static ModalReferSuccessBinding bind(View view) {
        TextView textView;
        TextView textView2;
        int n = 2131361918;
        PrimaryButton primaryButton = (PrimaryButton)view.findViewById(n);
        if (primaryButton != null && (textView2 = (TextView)view.findViewById(n = 2131362419)) != null && (textView = (TextView)view.findViewById(n = 2131362420)) != null) {
            return new ModalReferSuccessBinding((LinearLayout)view, primaryButton, textView2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static ModalReferSuccessBinding inflate(LayoutInflater layoutInflater) {
        return ModalReferSuccessBinding.inflate(layoutInflater, null, false);
    }

    public static ModalReferSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558554, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ModalReferSuccessBinding.bind(view);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}

