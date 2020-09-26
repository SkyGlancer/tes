package app.dukhaan.ui.ui.views.stats;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.ui.views.model.StatsCardData;
import java.util.List;

public class DashboardStatsAdapter extends Adapter<app.dukhaan.ui.views.stats.DashboardStatsAdapter.ViewHolder> {
   private List<StatsCardData> stats;

   public DashboardStatsAdapter() {
   }

   public int getItemCount() {
      List var1 = this.stats;
      int var2;
      if (var1 != null) {
         var2 = var1.size();
      } else {
         var2 = 0;
      }

      return var2;
   }

   public void onBindViewHolder(app.dukhaan.ui.views.stats.DashboardStatsAdapter.ViewHolder var1, int var2) {
      StatsCardData var3 = (StatsCardData)this.stats.get(var2);
      var1.card.setData(var3);
   }

   public app.dukhaan.ui.views.stats.DashboardStatsAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.views.stats.DashboardStatsAdapter.ViewHolder(this, LayoutInflater.from(var1.getContext()).inflate(dashboard_stat_card_item, var1, false));
   }

   public void setData(List<StatsCardData> var1) {
      this.stats = var1;
      this.notifyDataSetChanged();
   }
}
