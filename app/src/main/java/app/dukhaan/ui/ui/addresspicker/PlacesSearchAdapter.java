package app.dukhaan.ui.ui.addresspicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import app.dukhaan.databinding.ItemSearchBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;
import java.util.List;

public class PlacesSearchAdapter extends Adapter<ViewHolder> {
   private app.dukhaan.ui.addresspicker.PlacesSearchAdapter.PlacesAdapterItemClick adapterBtnClickListener;
   private List<Prediction> googlePlacesList;

   public PlacesSearchAdapter(List<Prediction> var1, app.dukhaan.ui.addresspicker.PlacesSearchAdapter.PlacesAdapterItemClick var2) {
      this.googlePlacesList = var1;
      this.adapterBtnClickListener = var2;
   }

   public int getItemCount() {
      return this.googlePlacesList.size();
   }

   public void onBindViewHolder(ViewHolder var1, int var2) {
      Prediction var3 = (Prediction)this.googlePlacesList.get(var2);
      ((app.dukhaan.ui.addresspicker.PlacesSearchAdapter.PlacesViewHolder)var1).bind(var3);
   }

   public ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.addresspicker.PlacesSearchAdapter.PlacesViewHolder(this, (ItemSearchBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), item_search, var1, false));
   }
}
