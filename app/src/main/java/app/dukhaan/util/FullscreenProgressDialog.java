/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.dukhaan.util.AppUtils;

public class FullscreenProgressDialog
extends Dialog {
    private ImageView iv;

    public FullscreenProgressDialog(Context context) {
        ImageView imageView;
        super(context, 2132017394);
        WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();
        layoutParams.gravity = 17;
        this.getWindow().setAttributes(layoutParams);
        this.setTitle(null);
        this.setCancelable(false);
        this.setOnCancelListener(null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(AppUtils.dpToPx(60), AppUtils.dpToPx(60));
        this.iv = imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iv.setImageResource(2131231286);
        linearLayout.addView((View)this.iv, (ViewGroup.LayoutParams)layoutParams3);
        this.addContentView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
        ImageView imageView2 = this.iv;
        PropertyValuesHolder[] arrpropertyValuesHolder = new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat((String)"scaleX", (float[])new float[]{1.4f}), PropertyValuesHolder.ofFloat((String)"scaleY", (float[])new float[]{1.4f})};
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder((Object)imageView2, (PropertyValuesHolder[])arrpropertyValuesHolder);
        objectAnimator.setDuration(550L);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(2);
        objectAnimator.start();
    }
}

