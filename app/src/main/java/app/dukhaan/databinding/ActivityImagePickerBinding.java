/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class ActivityImagePickerBinding
implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityImagePickerBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public static ActivityImagePickerBinding bind(View view) {
        if (view != null) {
            return new ActivityImagePickerBinding((ConstraintLayout)view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityImagePickerBinding inflate(LayoutInflater layoutInflater) {
        return ActivityImagePickerBinding.inflate(layoutInflater, null, false);
    }

    public static ActivityImagePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558439, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ActivityImagePickerBinding.bind(view);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

