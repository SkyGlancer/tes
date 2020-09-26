/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;

public final class ContentBaseBinding
implements ViewBinding {
    public final FrameLayout activityContentHolder;
    private final FrameLayout rootView;

    private ContentBaseBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.activityContentHolder = frameLayout2;
    }

    public static ContentBaseBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout)view;
            return new ContentBaseBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    public static ContentBaseBinding inflate(LayoutInflater layoutInflater) {
        return ContentBaseBinding.inflate(layoutInflater, null, false);
    }

    public static ContentBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558468, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ContentBaseBinding.bind(view);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}

