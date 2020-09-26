package app.dukhaan.ui.ui.views.units;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.databinding.ItemProductUnitListItemBinding;
import java.util.List;

public class ProductUnitAdapter extends Adapter<app.dukhaan.ui.views.units.ProductUnitAdapter.ViewHolder> {
   private app.dukhaan.ui.views.units.ProductUnitAdapter.UnitItemClickListener listener;
   private List<String> units;

   public ProductUnitAdapter(List<String> var1, app.dukhaan.ui.views.units.ProductUnitAdapter.UnitItemClickListener var2) {
      this.units = var1;
      this.listener = var2;
   }

   public int getItemCount() {
      return this.units.size();
   }

   public void onBindViewHolder(app.dukhaan.ui.views.units.ProductUnitAdapter.ViewHolder var1, int var2) {
      var1.bind(var2);
      var1.itemView.setOnClickListener(new _$$Lambda$ProductUnitAdapter$2CvekFy7ARqr2q9LvwFbFx9lf0w(this, var2));
   }

   public app.dukhaan.ui.views.units.ProductUnitAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.units.ProductUnitAdapter.ViewHolder(this, (ItemProductUnitListItemBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), item_product_unit_list_item, var1, false));
   }
}
