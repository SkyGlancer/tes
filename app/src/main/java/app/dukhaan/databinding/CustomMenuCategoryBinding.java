/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;

public final class CustomMenuCategoryBinding
implements ViewBinding {
    private final ImageView rootView;

    private CustomMenuCategoryBinding(ImageView imageView) {
        this.rootView = imageView;
    }

    public static CustomMenuCategoryBinding bind(View view) {
        if (view != null) {
            return new CustomMenuCategoryBinding((ImageView)view);
        }
        throw new NullPointerException("rootView");
    }

    public static CustomMenuCategoryBinding inflate(LayoutInflater layoutInflater) {
        return CustomMenuCategoryBinding.inflate(layoutInflater, null, false);
    }

    public static CustomMenuCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558478, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return CustomMenuCategoryBinding.bind(view);
    }

    public ImageView getRoot() {
        return this.rootView;
    }
}

