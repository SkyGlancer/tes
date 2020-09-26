package app.dukhaan.ui.ui.views.orders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutOrderFilterChipGroupBinding;

public class OrderFilterChipGroup extends FrameLayout implements OnClickListener {
   private LayoutOrderFilterChipGroupBinding binding;
   private app.dukhaan.ui.views.orders.OrderFilterChipGroup.OrderFilterChipGroupListener listener;

   public OrderFilterChipGroup(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public OrderFilterChipGroup(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public OrderFilterChipGroup(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      LayoutOrderFilterChipGroupBinding var4 = LayoutOrderFilterChipGroupBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
      this.binding = var4;
      var4.filterAll.setData(this.getResources().getString(R.string.filter_all));
      this.binding.filterAll.setEnabled(true);
      this.binding.filterAccepted.setData(this.getResources().getString(R.string.filter_accepted));
      this.binding.filterPending.setData(this.getResources().getString(R.string.filter_pending));
      this.binding.filterAll.setOnClickListener(this);
      this.binding.filterPending.setOnClickListener(this);
      this.binding.filterAccepted.setOnClickListener(this);
   }

   public void onClick(View var1) {
      if (this.listener != null) {
         switch(var1.getId()) {
         case filter_accepted:
            this.listener.onOrderFilterSelected("ACCEPTED");
            this.binding.filterAll.setEnabled(false);
            this.binding.filterPending.setEnabled(false);
            this.binding.filterAccepted.setEnabled(true);
            break;
         case filter_all:
            this.listener.onOrderFilterSelected((String)null);
            this.binding.filterAll.setEnabled(true);
            this.binding.filterPending.setEnabled(false);
            this.binding.filterAccepted.setEnabled(false);
            break;
         case filter_pending:
            this.listener.onOrderFilterSelected("PENDING");
            this.binding.filterAll.setEnabled(false);
            this.binding.filterPending.setEnabled(true);
            this.binding.filterAccepted.setEnabled(false);
         }
      }

   }

   public void setListener(app.dukhaan.ui.views.orders.OrderFilterChipGroup.OrderFilterChipGroupListener var1) {
      this.listener = var1;
   }
}
