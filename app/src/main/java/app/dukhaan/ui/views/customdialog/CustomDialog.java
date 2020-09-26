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
 *  app.dukhaan.databinding.LayoutCustomDialogBinding
 *  com.google.android.material.card.MaterialCardView
 *  java.lang.CharSequence
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package app.dukhaan.ui.views.customdialog;

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
import app.dukhaan.databinding.LayoutCustomDialogBinding;
import app.dukhaan.ui.views.customdialog.-$$Lambda$CustomDialog$_q_4IqIl676ubf1Axw3CB8pGwqU;
import app.dukhaan.ui.views.customdialog.-$$Lambda$CustomDialog$gylGmdZTq_uXo6lCKPe0SzeNtqk;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.util.DialogType;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;

public class CustomDialog
extends Dialog {
    AlertDialog alertDialog;
    private LayoutCustomDialogBinding binding;
    private IdialogItemClickListner idialogItemClickListner;

    public CustomDialog(Context context) {
        super(context);
        this.initUI(context);
    }

    private void initUI(Context context) {
        AlertDialog alertDialog;
        this.binding = LayoutCustomDialogBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView((View)this.binding.getRoot());
        this.alertDialog = alertDialog = builder.create();
        ((Window)Objects.requireNonNull((Object)alertDialog.getWindow())).setBackgroundDrawableResource(17170445);
        this.alertDialog.show();
    }

    private void setStatus(DialogType dialogType) {
        int n = 1.$SwitchMap$app$dukhaan$util$DialogType[dialogType.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        return;
                    }
                    this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230935));
                    this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951757));
                    this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952027));
                    return;
                }
                this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230939));
                this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951890));
                this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952025));
                return;
            }
            this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131231314));
            this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951759));
            this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952029));
            return;
        }
        this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable((Context)this.getContext(), (int)2131230935));
        this.binding.tvContent.setText((CharSequence)this.getContext().getString(2131951758));
        this.binding.tvYes.setText((CharSequence)this.getContext().getString(2131952027));
    }

    public void deleteDialog(DialogType dialogType) {
        this.binding.tvClose.setText((CharSequence)this.getContext().getString(2131951679));
        this.setCanceledOnTouchOutside(true);
        this.binding.tvClose.setOnClickListener((View.OnClickListener)new -$$Lambda$CustomDialog$gylGmdZTq_uXo6lCKPe0SzeNtqk(this));
        this.binding.tvYes.setOnClickListener((View.OnClickListener)new -$$Lambda$CustomDialog$_q_4IqIl676ubf1Axw3CB8pGwqU(this));
        if (dialogType == null) {
            return;
        }
        this.setStatus(dialogType);
    }

    public /* synthetic */ void lambda$deleteDialog$0$CustomDialog(View view) {
        this.alertDialog.dismiss();
    }

    public /* synthetic */ void lambda$deleteDialog$1$CustomDialog(View view) {
        this.idialogItemClickListner.yesMakeIt();
        this.alertDialog.dismiss();
    }

    public void setListener(IdialogItemClickListner idialogItemClickListner) {
        this.idialogItemClickListner = idialogItemClickListner;
    }

}

