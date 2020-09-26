package app.dukhaan.ui.ui.views.orders;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import app.dukhaan.databinding.LayoutOrderFilterChipBinding;

public class OrderFilterChip extends FrameLayout {
   private LayoutOrderFilterChipBinding binding;
   private boolean isSelected;
   private String label;
   private OnClickListener listener;

   public OrderFilterChip(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public OrderFilterChip(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public OrderFilterChip(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      Typeface var1;
      if (this.isSelected) {
         var1 = ResourcesCompat.getFont(this.getContext(), font_family_galano_medium);
         this.binding.label.setTextColor(ContextCompat.getColor(R.color.this.getContext(), colorPrimary));
         this.binding.label.setBackgroundResource(bg_chip_order_filter_enabled);
      } else {
         var1 = ResourcesCompat.getFont(this.getContext(), font_family_galano_regular);
         this.binding.label.setTextColor(ContextCompat.getColor(R.color.this.getContext(), order_filter_chip_label_disabled));
         this.binding.label.setBackgroundResource(bg_chip_order_filter_disabled);
      }

      this.binding.label.setTypeface(var1);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutOrderFilterChipBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void renderLabel() {
      this.binding.label.setText(this.label);
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      if (var1.getAction() == 1 && (var1.getKeyCode() == 23 || var1.getKeyCode() == 66)) {
         OnClickListener var2 = this.listener;
         if (var2 != null) {
            var2.onClick(this);
         }
      }

      return super.dispatchKeyEvent(var1);
   }

   public boolean dispatchTouchEvent(MotionEvent var1) {
      if (var1.getAction() == 1) {
         OnClickListener var2 = this.listener;
         if (var2 != null) {
            var2.onClick(this);
         }
      }

      return super.dispatchTouchEvent(var1);
   }

   public void setData(String var1) {
      this.label = var1;
      this.renderLabel();
      this.applyStyle();
   }

   public void setEnabled(boolean var1) {
      this.isSelected = var1;
      this.applyStyle();
   }

   public void setOnClickListener(OnClickListener var1) {
      this.listener = var1;
   }
}
