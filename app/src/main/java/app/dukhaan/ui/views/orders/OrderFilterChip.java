/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
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
 *  androidx.core.content.res.ResourcesCompat
 *  app.dukhaan.databinding.LayoutOrderFilterChipBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import app.dukhaan.databinding.LayoutOrderFilterChipBinding;

public class OrderFilterChip
extends FrameLayout {
    private LayoutOrderFilterChipBinding binding;
    private boolean isSelected;
    private String label;
    private OnClickListener listener;

    public OrderFilterChip(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public OrderFilterChip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public OrderFilterChip(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        Typeface typeface;
        if (this.isSelected) {
            typeface = ResourcesCompat.getFont((Context)this.getContext(), (int)2131296259);
            this.binding.label.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)2131099728));
            this.binding.label.setBackgroundResource(2131230832);
        } else {
            typeface = ResourcesCompat.getFont((Context)this.getContext(), (int)2131296260);
            this.binding.label.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)2131099913));
            this.binding.label.setBackgroundResource(2131230831);
        }
        this.binding.label.setTypeface(typeface);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutOrderFilterChipBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void renderLabel() {
        this.binding.label.setText((CharSequence)this.label);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnClickListener onClickListener;
        if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 23 || keyEvent.getKeyCode() == 66) && (onClickListener = this.listener) != null) {
            onClickListener.onClick((View)this);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnClickListener onClickListener;
        if (motionEvent.getAction() == 1 && (onClickListener = this.listener) != null) {
            onClickListener.onClick((View)this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setData(String string2) {
        this.label = string2;
        this.renderLabel();
        this.applyStyle();
    }

    public void setEnabled(boolean bl) {
        this.isSelected = bl;
        this.applyStyle();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }
}

