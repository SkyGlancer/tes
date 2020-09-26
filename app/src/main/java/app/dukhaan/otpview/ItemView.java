/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.res.ResourcesCompat
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  timber.log.Timber
 */
package app.dukhaan.otpview;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import app.dukhaan.R;
import app.dukhaan.otpview.OtpUtils;
import timber.log.Timber;

public class ItemView
extends FrameLayout {
    public static final int ACTIVE = 1;
    private static final float DEFAULT_BAR_HEIGHT = 2.0f;
    private static final int DEFAULT_BAR_MARGIN = 2;
    private static final float DEFAULT_OTP_TEXT_SIZE = 24.0f;
    public static final int ERROR = -1;
    public static final int INACTIVE = 0;
    public static final int SUCCESS = 2;
    private int barActiveColor;
    private int barErrorColor;
    private int barInactiveColor;
    private int barSuccessColor;
    private int boxBackgroundColorActive;
    private int boxBackgroundColorError;
    private int boxBackgroundColorInactive;
    private int boxBackgroundColorSuccess;
    private Context context;
    private int defaultOTPDrawable;
    private boolean hideOTP = false;
    private int hideOTPDrawable;
    private TextView textView;
    private View view;

    public ItemView(Context context) {
        super(context);
        this.context = context;
        this.init(null);
    }

    public ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.init(attributeSet);
    }

    public ItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.context = context;
        this.init(attributeSet);
    }

    private void generateViews(TypedArray typedArray) {
        TextView textView;
        float f = OtpUtils.getPixels(this.context, 2.0f);
        float f2 = OtpUtils.getPixels(this.context, 24.0f);
        int n = typedArray.getColor(0, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099711, null));
        float f3 = typedArray.getDimension(4, f);
        float f4 = typedArray.getDimension(6, (float)OtpUtils.getPixels(this.context, 0));
        float f5 = typedArray.getDimension(7, 2.0f);
        float f6 = typedArray.getDimension(9, 2.0f);
        float f7 = typedArray.getDimension(8, 2.0f);
        float f8 = typedArray.getDimension(10, 2.0f);
        this.hideOTP = typedArray.getBoolean(18, false);
        this.hideOTPDrawable = typedArray.getResourceId(19, 2131230841);
        this.defaultOTPDrawable = ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099955, null);
        boolean bl = typedArray.getBoolean(2, false);
        Float f9 = Float.valueOf((float)typedArray.getDimension(27, f2));
        String string2 = typedArray.getString(28);
        int n2 = typedArray.getResourceId(22, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099955, null));
        this.boxBackgroundColorActive = typedArray.getResourceId(23, n2);
        this.boxBackgroundColorInactive = typedArray.getResourceId(25, n2);
        this.boxBackgroundColorSuccess = typedArray.getResourceId(26, n2);
        this.boxBackgroundColorError = typedArray.getResourceId(24, n2);
        this.barActiveColor = typedArray.getColor(1, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099711, null));
        this.barInactiveColor = typedArray.getColor(5, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099821, null));
        this.barErrorColor = typedArray.getColor(3, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099774, null));
        this.barSuccessColor = typedArray.getColor(11, ResourcesCompat.getColor((Resources)this.context.getResources(), (int)2131099711, null));
        this.setBackgroundResource(n2);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.textView = textView = new TextView(this.context);
        textView.setGravity(17);
        if (string2 != null) {
            try {
                Typeface typeface = Typeface.createFromAsset((AssetManager)this.context.getAssets(), (String)string2);
                Timber.e((String)"Tf: %s", (Object[])new Object[]{typeface});
                this.textView.setTypeface(typeface);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Typeface typeface = ResourcesCompat.getFont((Context)this.getContext(), (int)2131296259);
        this.textView.setTypeface(typeface);
        this.textView.setTextColor(n);
        this.textView.setTextSize(0, f9.floatValue());
        this.addView((View)this.textView, (ViewGroup.LayoutParams)layoutParams);
        if (bl) {
            View view;
            LayoutParams layoutParams2 = new LayoutParams(-1, (int)f3);
            layoutParams2.gravity = 80;
            if (f4 != 0.0f) {
                f6 = f5 = (f8 = f4);
            } else {
                f4 = f7;
            }
            layoutParams2.leftMargin = (int)f4;
            layoutParams2.rightMargin = (int)f6;
            layoutParams2.bottomMargin = (int)f5;
            layoutParams2.topMargin = (int)f8;
            this.view = view = new View(this.context);
            this.addView(view, (ViewGroup.LayoutParams)layoutParams2);
        }
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.OtpTextView);
        this.generateViews(typedArray);
        typedArray.recycle();
    }

    public void setText(String string2) {
        if (!this.hideOTP) {
            TextView textView = this.textView;
            if (textView != null) {
                textView.setText((CharSequence)string2);
                return;
            }
        } else {
            this.textView.setText((CharSequence)"");
            if (string2.equals((Object)"")) {
                this.textView.setBackgroundResource(this.defaultOTPDrawable);
                return;
            }
            this.textView.setBackgroundResource(this.hideOTPDrawable);
        }
    }

    public void setViewState(int n) {
        if (n != -1) {
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        return;
                    }
                    View view = this.view;
                    if (view != null) {
                        view.setBackgroundColor(this.barSuccessColor);
                    }
                    this.setBackgroundResource(this.boxBackgroundColorSuccess);
                    return;
                }
                View view = this.view;
                if (view != null) {
                    view.setBackgroundColor(this.barActiveColor);
                }
                this.setBackgroundResource(this.boxBackgroundColorActive);
                return;
            }
            View view = this.view;
            if (view != null) {
                view.setBackgroundColor(this.barInactiveColor);
            }
            this.setBackgroundResource(this.boxBackgroundColorInactive);
            return;
        }
        View view = this.view;
        if (view != null) {
            view.setBackgroundColor(this.barErrorColor);
        }
        this.setBackgroundResource(this.boxBackgroundColorError);
    }
}

