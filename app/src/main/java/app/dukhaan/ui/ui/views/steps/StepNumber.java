package app.dukhaan.ui.ui.views.steps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutStepNumberBinding;

public class StepNumber extends FrameLayout {
   private LayoutStepNumberBinding binding;
   private boolean isCompleted;
   private boolean isDisabled;
   private int stepNumber;

   public StepNumber(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public StepNumber(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public StepNumber(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      this.binding.number.setText(String.valueOf(this.stepNumber));
      if (this.isCompleted) {
         this.binding.container.setBackground(this.getResources().getDrawable(bg_step_number_filled));
         this.binding.number.setVisibility(8);
         this.binding.check.setVisibility(0);
      } else {
         this.binding.container.setBackground(this.getResources().getDrawable(bg_step_number_outline));
         this.binding.number.setVisibility(0);
         this.binding.check.setVisibility(8);
         if (this.isDisabled) {
            this.binding.container.setBackground(this.getResources().getDrawable(bg_step_number_disabled));
            this.binding.number.setTextColor(this.getResources().getColor(R.color.grey));
         }
      }

   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutStepNumberBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   public void setData(int var1, boolean var2, boolean var3) {
      this.stepNumber = var1;
      this.isCompleted = var2;
      this.isDisabled = var3;
      this.applyStyle();
   }
}
