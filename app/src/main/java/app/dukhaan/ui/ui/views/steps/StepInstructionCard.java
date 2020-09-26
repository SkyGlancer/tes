package app.dukhaan.ui.ui.views.steps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutStepInstructionsBinding;
import app.dukhaan.util.AppUtils;

public class StepInstructionCard extends FrameLayout {
   private LayoutStepInstructionsBinding binding;
   private app.dukhaan.ui.views.steps.StepInstructionCard.StepInstructionCardListener listener;
   private int stepNumber;

   public StepInstructionCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public StepInstructionCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public StepInstructionCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutStepInstructionsBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   public void setData(int var1, String var2, String var3, String var4, boolean var5, boolean var6) {
      this.setData(var1, var2, var3, var4, var5, var6, false);
   }

   public void setData(int var1, String var2, String var3, String var4, boolean var5, boolean var6, boolean var7) {
      this.stepNumber = var1;
      this.binding.title.setText(var2);
      this.binding.instruction.setText(var3);
      if (var5) {
         this.binding.button.setText(var4);
         this.binding.button.setVisibility(0);
         this.binding.link.setVisibility(8);
         if (!var6) {
            this.binding.container.setPadding(0, 0, 0, AppUtils.dpToPx(20));
         }
      } else {
         this.binding.link.setText(var4);
         this.binding.link.setVisibility(0);
         this.binding.button.setVisibility(8);
         if (!var6) {
            this.binding.container.setPadding(0, 0, 0, AppUtils.dpToPx(12));
         }
      }

      if (var7) {
         this.binding.title.setTextColor(this.getResources().getColor(R.color.step_title_disabled));
         this.binding.instruction.setVisibility(8);
         this.binding.link.setVisibility(8);
         this.binding.button.setVisibility(8);
         this.binding.title.setPadding(0, AppUtils.dpToPx(9), 0, 0);
      }

      if ((var1 == 1 || var1 == 2) && !var5) {
         this.binding.container.setPadding(this.binding.container.getPaddingLeft(), this.binding.container.getPaddingTop(), this.binding.container.getPaddingRight(), this.binding.container.getPaddingBottom() + AppUtils.dpToPx(3));
      }

   }

   public void setListener(app.dukhaan.ui.views.steps.StepInstructionCard.StepInstructionCardListener var1) {
      this.listener = var1;
      this.binding.button.setOnClickListener(new _$$Lambda$StepInstructionCard$0PVACDBrQwp_MIyUu0B_tiJDgQE(var1));
      this.binding.link.setOnClickListener(new _$$Lambda$StepInstructionCard$ngfapG6LLarXJlHrJJOLlhbS4k0(var1));
   }
}
