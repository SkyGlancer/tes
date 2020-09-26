/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

public final class WaStoryItemLayoutBinding
implements ViewBinding {
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final LinearLayout waStoriesContainer;

    private WaStoryItemLayoutBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.imageView = imageView;
        this.waStoriesContainer = linearLayout2;
    }

    public static WaStoryItemLayoutBinding bind(View view) {
        ImageView imageView = (ImageView)view.findViewById(2131362143);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout)view;
            return new WaStoryItemLayoutBinding(linearLayout, imageView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362143)));
    }

    public static WaStoryItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return WaStoryItemLayoutBinding.inflate(layoutInflater, null, false);
    }

    public static WaStoryItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558620, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return WaStoryItemLayoutBinding.bind(view);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}

