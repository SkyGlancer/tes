package app.dukhaan.ui.ui.views.orderstatusdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.content.ContextCompat;
import app.dukhaan.databinding.LayoutOrderStatusDialogBinding;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialog
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;.1;
import java.util.Objects;

public class OrderStatusDialog extends Dialog {
   AlertDialog alertDialog;
   private LayoutOrderStatusDialogBinding binding;
   private IOrderStatusItemClickListener iOrderStatusItemClickListener;

   public OrderStatusDialog(Context var1) {
      super(var1);
      this.initUI(var1);
   }

   private void initUI(Context var1) {
      this.binding = LayoutOrderStatusDialogBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"));
      Builder var2 = new Builder(var1);
      var2.setView(this.binding.getRoot());
      AlertDialog var3 = var2.create();
      this.alertDialog = var3;
      ((Window)Objects.requireNonNull(var3.getWindow())).setBackgroundDrawableResource(17170445);
      this.alertDialog.show();
   }

   private void setStatus(OrderStatusDialogType var1) {
      int var2 = 1.$SwitchMap$app$dukhaan$ui$views$orderstatusdialog$OrderStatusDialogType[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 != 4) {
                  if (var2 == 5) {
                     this.binding.tvContent.setText(this.getContext().getString(R.string.cancel_the_order));
                     this.binding.tvYes.setText(this.getContext().getString(R.string.yes_cancel));
                     this.binding.tvYes.setBackground(ContextCompat.getDrawable(this.getContext(), dialog_bg_decline));
                     this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delline));
                  }
               } else {
                  this.binding.tvContent.setText(this.getContext().getString(R.string.order_delivered));
                  this.binding.tvYes.setText(this.getContext().getString(R.string.yes_delivered));
                  this.binding.tvYes.setBackground(ContextCompat.getDrawable(this.getContext(), dialog_bg_deliver));
                  this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delivered_order));
               }
            } else {
               this.binding.tvContent.setText(this.getContext().getString(R.string.ship_the_order));
               this.binding.tvYes.setText(this.getContext().getString(R.string.yes_ship));
               this.binding.tvYes.setBackground(ContextCompat.getDrawable(this.getContext(), dialog_bg_ship));
               this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable(this.getContext(), ship_order));
            }
         } else {
            this.binding.tvContent.setText(this.getContext().getString(R.string.once_you_decline_order));
            this.binding.tvYes.setText(this.getContext().getString(R.string.yes_decline));
            this.binding.tvYes.setBackground(ContextCompat.getDrawable(this.getContext(), dialog_bg_decline));
            this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delline));
         }
      } else {
         this.binding.tvContent.setText(this.getContext().getString(R.string.accept_the_order));
         this.binding.tvYes.setText(this.getContext().getString(R.string.yes_accept));
         this.binding.tvYes.setBackground(ContextCompat.getDrawable(this.getContext(), dialog_bg_accept));
         this.binding.thumbStatus.setImageDrawable(ContextCompat.getDrawable(this.getContext(), accept_order));
      }

   }

   public void setListener(IOrderStatusItemClickListener var1) {
      this.iOrderStatusItemClickListener = var1;
   }

   public void statusTypeDialog(OrderStatusDialogType var1) {
      this.binding.tvClose.setText(this.getContext().getString(R.string.close_dialog));
      this.setCanceledOnTouchOutside(true);
      this.binding.tvClose.setOnClickListener(new _$$Lambda$OrderStatusDialog$gHR6hLJvRB6oTPvgsGZn1nYaQnA(this));
      this.binding.tvYes.setOnClickListener(new _$$Lambda$OrderStatusDialog$zuWVygNfsfVWOi_nETJtRMBbMSI(this, var1));
      if (var1 != null) {
         this.setStatus(var1);
      }
   }
}
