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
 *  androidx.constraintlayout.widget.Guideline
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
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

public final class InternetConnectonLayoutBinding
implements ViewBinding {
    public final TextView cancel;
    public final Guideline guideline;
    private final ConstraintLayout rootView;

    private InternetConnectonLayoutBinding(ConstraintLayout constraintLayout, TextView textView, Guideline guideline) {
        this.rootView = constraintLayout;
        this.cancel = textView;
        this.guideline = guideline;
    }

    public static InternetConnectonLayoutBinding bind(View view) {
        Guideline guideline;
        int n = 2131361925;
        TextView textView = (TextView)view.findViewById(n);
        if (textView != null && (guideline = (Guideline)view.findViewById(n = 2131362101)) != null) {
            return new InternetConnectonLayoutBinding((ConstraintLayout)view, textView, guideline);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static InternetConnectonLayoutBinding inflate(LayoutInflater layoutInflater) {
        return InternetConnectonLayoutBinding.inflate(layoutInflater, null, false);
    }

    public static InternetConnectonLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558522, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return InternetConnectonLayoutBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

