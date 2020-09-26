package app.dukhaan.ui.ui.views.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.content.ContextCompat;
import app.dukhaan.databinding.LayoutCustomDialogBinding;
import app.dukhaan.ui.views.customdialog.CustomDialog.1;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.util.DialogType;
import java.util.Objects;

public class CustomDialog extends Dialog {
   AlertDialog alertDialog;
   private LayoutCustomDialogBinding binding;
   private IdialogItemClickListner idialogItemClickListner;

   public CustomDialog(Context var1) {
      super(var1);
      this.initUI(var1);
   }

   private void initUI(Context var1) {
      this.binding = LayoutCustomDialogBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"));
      Builder var2 = new Builder(var1);
      var2.setView(this.binding.getRoot());
      AlertDialog var3 = var2.create();
      this.alertDialog = var3;
      ((Window)Objects.requireNonNull(var3.getWindow())).setBackgroundDrawableResource(17170445);
      this.alertDialog.show();
   }

   private void setStatus(DialogType var1) {
      int var2 = 1.$SwitchMap$app$dukhaan$util$DialogType[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 == 4) {
                  this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delete));
                  this.binding.tvContent.setText(this.getContext().getString(R.string.do_you_really_want_to_delete_this_category_as_not_delivered));
                  this.binding.tvYes.setText(this.getContext().getString(R.string.yes_delete_it));
               }
            } else {
               this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delline));
               this.binding.tvContent.setText(this.getContext().getString(R.string.once_you_decline_order));
               this.binding.tvYes.setText(this.getContext().getString(R.string.yes_declane_it));
            }
         } else {
            this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable(this.getContext(), notdelivered));
            this.binding.tvContent.setText(this.getContext().getString(R.string.do_you_really_want_to_mark_this_order_as_not_delivered));
            this.binding.tvYes.setText(this.getContext().getString(R.string.yes_make_it));
         }
      } else {
         this.binding.ivNotDelivered.setImageDrawable(ContextCompat.getDrawable(this.getContext(), delete));
         this.binding.tvContent.setText(this.getContext().getString(R.string.do_you_really_want_to_delete_this_order_as_not_delivered));
         this.binding.tvYes.setText(this.getContext().getString(R.string.yes_delete_it));
      }

   }

   public void deleteDialog(DialogType var1) {
      this.binding.tvClose.setText(this.getContext().getString(R.string.close_dialog));
      this.setCanceledOnTouchOutside(true);
      this.binding.tvClose.setOnClickListener(new _$$Lambda$CustomDialog$gylGmdZTq_uXo6lCKPe0SzeNtqk(this));
      this.binding.tvYes.setOnClickListener(new _$$Lambda$CustomDialog$_q_4IqIl676ubf1Axw3CB8pGwqU(this));
      if (var1 != null) {
         this.setStatus(var1);
      }
   }

   public void setListener(IdialogItemClickListner var1) {
      this.idialogItemClickListner = var1;
   }
}
