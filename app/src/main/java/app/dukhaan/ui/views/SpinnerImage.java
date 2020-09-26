/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  androidx.core.content.ContextCompat
 *  app.dukhaan.databinding.SpinnerViewBinding
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import app.dukhaan.databinding.SpinnerViewBinding;

public class SpinnerImage
extends FrameLayout {
    private SpinnerViewBinding binding;
    private Context mContext;
    int rotationAngle = 0;

    public SpinnerImage(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public SpinnerImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public SpinnerImage(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    static /* synthetic */ SpinnerViewBinding access$100(SpinnerImage spinnerImage) {
        return spinnerImage.binding;
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.mContext = context;
        this.binding = SpinnerViewBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    public void rotate() {
        int n;
        ImageView imageView = this.binding.imgSpinner;
        float[] arrf = new float[2];
        int n2 = this.rotationAngle;
        arrf[0] = n2;
        arrf[1] = n2 + 180;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)imageView, (String)"rotation", (float[])arrf);
        objectAnimator.setDuration(300L);
        objectAnimator.start();
        this.rotationAngle = n = 180 + this.rotationAngle;
        this.rotationAngle = n % 360;
        objectAnimator.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator2) {
                Log.e((String)"TAG", (String)"onAnimationCancel: ");
            }

            public void onAnimationEnd(Animator animator2) {
                if (SpinnerImage.this.rotationAngle == 0) {
                    SpinnerImage.access$100((SpinnerImage)SpinnerImage.this).imgSpinner.setColorFilter(ContextCompat.getColor((Context)SpinnerImage.this.mContext, (int)2131099706), PorterDuff.Mode.SRC_IN);
                    return;
                }
                SpinnerImage.access$100((SpinnerImage)SpinnerImage.this).imgSpinner.setColorFilter(ContextCompat.getColor((Context)SpinnerImage.this.mContext, (int)2131099707), PorterDuff.Mode.SRC_IN);
            }

            public void onAnimationRepeat(Animator animator2) {
                Log.e((String)"TAG", (String)"onAnimationRepeat: ");
            }

            public void onAnimationStart(Animator animator2) {
            }
        });
    }

}

