package app.dukhaan.ui.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutEmptyDataCardBinding;

public class EmptyDataCard extends FrameLayout {
   private LayoutEmptyDataCardBinding binding;
   private String label;

   public EmptyDataCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public EmptyDataCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public EmptyDataCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutEmptyDataCardBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void renderLabel() {
      this.binding.label.setText(this.label);
   }

   public void setData(String var1) {
      this.label = var1;
      this.renderLabel();
   }
}
