/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  app.dukhaan.databinding.LayoutOrderFilterChipGroupBinding
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutOrderFilterChipGroupBinding;
import app.dukhaan.ui.views.orders.OrderFilterChip;

public class OrderFilterChipGroup
extends FrameLayout
implements View.OnClickListener {
    private LayoutOrderFilterChipGroupBinding binding;
    private OrderFilterChipGroupListener listener;

    public OrderFilterChipGroup(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public OrderFilterChipGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public OrderFilterChipGroup(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        LayoutOrderFilterChipGroupBinding layoutOrderFilterChipGroupBinding;
        this.binding = layoutOrderFilterChipGroupBinding = LayoutOrderFilterChipGroupBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
        layoutOrderFilterChipGroupBinding.filterAll.setData(this.getResources().getString(2131951787));
        this.binding.filterAll.setEnabled(true);
        this.binding.filterAccepted.setData(this.getResources().getString(2131951786));
        this.binding.filterPending.setData(this.getResources().getString(2131951788));
        this.binding.filterAll.setOnClickListener(this);
        this.binding.filterPending.setOnClickListener(this);
        this.binding.filterAccepted.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.listener != null) {
            switch (view.getId()) {
                default: {
                    return;
                }
                case 2131362073: {
                    this.listener.onOrderFilterSelected("PENDING");
                    this.binding.filterAll.setEnabled(false);
                    this.binding.filterPending.setEnabled(true);
                    this.binding.filterAccepted.setEnabled(false);
                    return;
                }
                case 2131362072: {
                    this.listener.onOrderFilterSelected(null);
                    this.binding.filterAll.setEnabled(true);
                    this.binding.filterPending.setEnabled(false);
                    this.binding.filterAccepted.setEnabled(false);
                    return;
                }
                case 2131362071: 
            }
            this.listener.onOrderFilterSelected("ACCEPTED");
            this.binding.filterAll.setEnabled(false);
            this.binding.filterPending.setEnabled(false);
            this.binding.filterAccepted.setEnabled(true);
        }
    }

    public void setListener(OrderFilterChipGroupListener orderFilterChipGroupListener) {
        this.listener = orderFilterChipGroupListener;
    }

    public static interface OrderFilterChipGroupListener {
        public void onOrderFilterSelected(String var1);
    }

}

