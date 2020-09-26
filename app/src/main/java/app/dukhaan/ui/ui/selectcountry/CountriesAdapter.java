package app.dukhaan.ui.ui.selectcountry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ItemCountryBinding;
import java.util.List;

public class CountriesAdapter extends Adapter<app.dukhaan.ui.selectcountry.CountriesAdapter.ViewHolder> {
   private Context context;
   private List<Country> countries;
   private app.dukhaan.ui.selectcountry.CountriesAdapter.OnCountrySelectedListener countrySelectedListener;

   public CountriesAdapter(Context var1, List<Country> var2, app.dukhaan.ui.selectcountry.CountriesAdapter.OnCountrySelectedListener var3) {
      this.context = var1;
      this.countries = var2;
      this.countrySelectedListener = var3;
   }

   public int getItemCount() {
      return this.countries.size();
   }

   public void onBindViewHolder(app.dukhaan.ui.selectcountry.CountriesAdapter.ViewHolder var1, int var2) {
      var1.bind(var2);
   }

   public app.dukhaan.ui.selectcountry.CountriesAdapter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.selectcountry.CountriesAdapter.ViewHolder(this, (ItemCountryBinding)DataBindingUtil.inflate(LayoutInflater.from(var1.getContext()), item_country, var1, false));
   }
}
