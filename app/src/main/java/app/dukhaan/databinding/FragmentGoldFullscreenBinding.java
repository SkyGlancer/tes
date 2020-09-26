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
 *  android.widget.RelativeLayout
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class FragmentGoldFullscreenBinding
implements ViewBinding {
    public final LinearLayout btnGetGold;
    public final ImageView closeButton;
    public final LinearLayout marketingTile;
    public final TextView overlayPayBtn;
    private final RelativeLayout rootView;
    public final TextView subtitle;
    public final ImageView tileIcon;
    public final TextView tileText;
    public final TextView title;

    private FragmentGoldFullscreenBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.btnGetGold = linearLayout;
        this.closeButton = imageView;
        this.marketingTile = linearLayout2;
        this.overlayPayBtn = textView;
        this.subtitle = textView2;
        this.tileIcon = imageView2;
        this.tileText = textView3;
        this.title = textView4;
    }

    public static FragmentGoldFullscreenBinding bind(View view) {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        LinearLayout linearLayout;
        int n = 2131361905;
        LinearLayout linearLayout2 = (LinearLayout)view.findViewById(n);
        if (linearLayout2 != null && (imageView = (ImageView)view.findViewById(n = 2131361936)) != null && (linearLayout = (LinearLayout)view.findViewById(n = 2131362230)) != null && (textView2 = (TextView)view.findViewById(n = 2131362312)) != null && (textView3 = (TextView)view.findViewById(n = 2131362432)) != null && (imageView2 = (ImageView)view.findViewById(n = 2131362470)) != null && (textView = (TextView)view.findViewById(n = 2131362471)) != null && (textView4 = (TextView)view.findViewById(n = 2131362476)) != null) {
            FragmentGoldFullscreenBinding fragmentGoldFullscreenBinding = new FragmentGoldFullscreenBinding((RelativeLayout)view, linearLayout2, imageView, linearLayout, textView2, textView3, imageView2, textView, textView4);
            return fragmentGoldFullscreenBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static FragmentGoldFullscreenBinding inflate(LayoutInflater layoutInflater) {
        return FragmentGoldFullscreenBinding.inflate(layoutInflater, null, false);
    }

    public static FragmentGoldFullscreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558484, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return FragmentGoldFullscreenBinding.bind(view);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}

