package app.dukhaan.ui.ui.views.stats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutStatCardBinding;
import app.dukhaan.ui.views.model.StatsCardData;

public class StatsCard extends FrameLayout {
   private LayoutStatCardBinding binding;

   public StatsCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public StatsCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public StatsCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutStatCardBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   public void setData(StatsCardData var1) {
      this.binding.label.setText(var1.label);
      this.binding.value.setText(var1.value);
   }
}
