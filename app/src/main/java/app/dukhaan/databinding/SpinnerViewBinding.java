/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
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
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class SpinnerViewBinding
implements ViewBinding {
    public final ImageView imgSpinner;
    private final ConstraintLayout rootView;

    private SpinnerViewBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.imgSpinner = imageView;
    }

    public static SpinnerViewBinding bind(View view) {
        ImageView imageView = (ImageView)view.findViewById(2131362211);
        if (imageView != null) {
            return new SpinnerViewBinding((ConstraintLayout)view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362211)));
    }

    public static SpinnerViewBinding inflate(LayoutInflater layoutInflater) {
        return SpinnerViewBinding.inflate(layoutInflater, null, false);
    }

    public static SpinnerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558626, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return SpinnerViewBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

