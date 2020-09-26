/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class ItemProgressBinding
implements ViewBinding {
    public final LinearLayout loadmoreErrorlayout;
    public final TextView loadmoreErrortxt;
    public final ProgressBar loadmoreProgress;
    public final ImageButton loadmoreRetry;
    private final FrameLayout rootView;

    private ItemProgressBinding(FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, ProgressBar progressBar, ImageButton imageButton) {
        this.rootView = frameLayout;
        this.loadmoreErrorlayout = linearLayout;
        this.loadmoreErrortxt = textView;
        this.loadmoreProgress = progressBar;
        this.loadmoreRetry = imageButton;
    }

    public static ItemProgressBinding bind(View view) {
        ProgressBar progressBar;
        ImageButton imageButton;
        TextView textView;
        int n = 2131362293;
        LinearLayout linearLayout = (LinearLayout)view.findViewById(n);
        if (linearLayout != null && (textView = (TextView)view.findViewById(n = 2131362294)) != null && (progressBar = (ProgressBar)view.findViewById(n = 2131362295)) != null && (imageButton = (ImageButton)view.findViewById(n = 2131362296)) != null) {
            ItemProgressBinding itemProgressBinding = new ItemProgressBinding((FrameLayout)view, linearLayout, textView, progressBar, imageButton);
            return itemProgressBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static ItemProgressBinding inflate(LayoutInflater layoutInflater) {
        return ItemProgressBinding.inflate(layoutInflater, null, false);
    }

    public static ItemProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558528, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ItemProgressBinding.bind(view);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}

