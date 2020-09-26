/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.core.content.ContextCompat
 *  app.dukhaan.databinding.LayoutOrderStatusDialogBinding
 *  com.google.android.material.card.MaterialCardView
 *  java.lang.CharSequence
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package app.dukhaan.ui.views.orderstatusdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import app.dukhaan.databinding.LayoutOrderStatusDialogBinding;
import app.dukhaan.ui.views.orderstatusdialog.-$$Lambda$OrderStatusDialog$gHR6hLJvRB6oTPvgsGZn1nYaQnA;
import app.dukhaan.ui.views.orderstatusdialog.-$$Lambda$OrderStatusDialog$zuWVygNfsfVWOi-nETJtRMBbMSI;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;

public class OrderStatusDialog
extends Dialog {
    AlertDialog alertDialog;
    private LayoutOrderStatusDialogBinding binding;
    private IOrderStatusItemClickListener iOrderStatusItemClickListener;

    public OrderStatusDialog(Context context) {
        super(context);
        this.initUI(context);
    }

    private void initUI(Context context) {
        AlertDialog alertDialog;
        this.binding = LayoutOrderStatusDialogBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView((View)this.binding.getRoot());
        this.alertDialog = alertDialog = builder.create();
        ((Window)Objects.requireNonNull((Object)alertDialog.getWindow())).setBackgroundDrawableResource(17170445);
        this.alertDialog.show();
    }

    private void setStatus(OrderStatusDialogType orderStatusDialogType) {
        int n = 1.$SwitchMap$app$dukhaan$ui$views$orderstatusdialog$OrderStatusDialogType[orderStatusDialogType.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return;
                        }
                        this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951667));
                        this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952024));
                        this.binding.tvYes.setBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230947));
                        this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230939));
                        return;
                    }
                    this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951891));
                    this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952028));
                    this.binding.tvYes.setBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230948));
                    this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230937));
                    return;
                }
                this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951940));
                this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952030));
                this.binding.tvYes.setBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230949));
                this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131231338));
                return;
            }
            this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951890));
            this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952026));
            this.binding.tvYes.setBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230947));
            this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230939));
            return;
        }
        this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951646));
        this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952023));
        this.binding.tvYes.setBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230946));
        this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230813));
    }

    public /* synthetic */ void lambda$statusTypeDialog$0$OrderStatusDialog(View view) {
        this.alertDialog.dismiss();
    }

    public /* synthetic */ void lambda$statusTypeDialog$1$OrderStatusDialog(OrderStatusDialogType orderStatusDialogType, View view) {
        this.iOrderStatusItemClickListener.positiveStatus(orderStatusDialogType);
        this.alertDialog.dismiss();
    }

    public void setListener(IOrderStatusItemClickListener iOrderStatusItemClickListener) {
        this.iOrderStatusItemClickListener = iOrderStatusItemClickListener;
    }

    public void statusTypeDialog(OrderStatusDialogType orderStatusDialogType) {
        this.binding.tvClose.setText((CharSequence)this.getContext().getString(2131951679));
        this.setCanceledOnTouchOutside(true);
        this.binding.tvClose.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderStatusDialog$gHR6hLJvRB6oTPvgsGZn1nYaQnA(this));
        this.binding.tvYes.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderStatusDialog$zuWVygNfsfVWOi-nETJtRMBbMSI(this, orderStatusDialogType));
        if (orderStatusDialogType == null) {
            return;
        }
        this.setStatus(orderStatusDialogType);
    }

}

