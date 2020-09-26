/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
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
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;

public final class ActivityBaseBinding
implements ViewBinding {
    public final CoordinatorLayout coordinatorLayout;
    public final ProgressBar progressBar;
    private final CoordinatorLayout rootView;

    private ActivityBaseBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, ProgressBar progressBar) {
        this.rootView = coordinatorLayout;
        this.coordinatorLayout = coordinatorLayout2;
        this.progressBar = progressBar;
    }

    public static ActivityBaseBinding bind(View view) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)view;
        ProgressBar progressBar = (ProgressBar)view.findViewById(2131362405);
        if (progressBar != null) {
            return new ActivityBaseBinding(coordinatorLayout, coordinatorLayout, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362405)));
    }

    public static ActivityBaseBinding inflate(LayoutInflater layoutInflater) {
        return ActivityBaseBinding.inflate(layoutInflater, null, false);
    }

    public static ActivityBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558431, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ActivityBaseBinding.bind(view);
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}

