/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.card.MaterialCardView
 *  com.google.android.material.imageview.ShapeableImageView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public final class LayoutVideoTutorialListItemBinding
implements ViewBinding {
    public final RelativeLayout rlThumbnail;
    private final MaterialCardView rootView;
    public final ShapeableImageView thumbnail;
    public final TextView tvTitle;

    private LayoutVideoTutorialListItemBinding(MaterialCardView materialCardView, RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, TextView textView) {
        this.rootView = materialCardView;
        this.rlThumbnail = relativeLayout;
        this.thumbnail = shapeableImageView;
        this.tvTitle = textView;
    }

    public static LayoutVideoTutorialListItemBinding bind(View view) {
        TextView textView;
        ShapeableImageView shapeableImageView;
        int n = 2131362431;
        RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(n);
        if (relativeLayout != null && (shapeableImageView = (ShapeableImageView)view.findViewById(n = 2131362563)) != null && (textView = (TextView)view.findViewById(n = 2131362622)) != null) {
            return new LayoutVideoTutorialListItemBinding((MaterialCardView)view, relativeLayout, shapeableImageView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static LayoutVideoTutorialListItemBinding inflate(LayoutInflater layoutInflater) {
        return LayoutVideoTutorialListItemBinding.inflate(layoutInflater, null, false);
    }

    public static LayoutVideoTutorialListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558544, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return LayoutVideoTutorialListItemBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

