/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  app.dukhaan.databinding.BtnPrimaryBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import app.dukhaan.R;
import app.dukhaan.databinding.BtnPrimaryBinding;

public class PrimaryButton
extends FrameLayout {
    private BtnPrimaryBinding binding;
    private boolean enabled;
    private OnClickListener listener;
    private String text;

    public PrimaryButton(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public PrimaryButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public PrimaryButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        this.binding.label.setEnabled(this.enabled);
        if (this.enabled) {
            this.binding.label.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)2131099695));
            this.binding.label.setBackgroundResource(2131230824);
            return;
        }
        this.binding.label.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)2131099694));
        this.binding.label.setBackgroundResource(2131230823);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = BtnPrimaryBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PrimaryButton, 0, 0);
        this.enabled = typedArray.getBoolean(0, true);
        this.text = typedArray.getString(1);
        this.binding.label.setEnabled(this.enabled);
        this.binding.label.setText((CharSequence)this.text);
        this.applyStyle();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnClickListener onClickListener;
        if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 23 || keyEvent.getKeyCode() == 66) && (onClickListener = this.listener) != null) {
            onClickListener.onClick((View)this);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.listener != null && this.binding.label.isEnabled()) {
            this.listener.onClick((View)this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setBusy(boolean bl) {
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
        this.applyStyle();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    public void setText(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.binding.label.setText((CharSequence)string2);
        }
    }
}

