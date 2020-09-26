package app.dukhaan.ui.ui.selectcountry;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivitySelectCountryBinding;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.selectcountry.CountriesAdapter.OnCountrySelectedListener;
import app.dukhaan.ui.selectcountry.SelectCountryActivity.1;
import app.dukhaan.ui.selectcountry.SelectCountryActivity.2;
import app.dukhaan.util.CountData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SelectCountryActivity extends AppCompatActivity implements OnCountrySelectedListener {
   private ActivitySelectCountryBinding binding;
   private List<Country> countries;
   private app.dukhaan.ui.selectcountry.CountriesAdapter countriesAdapter;
   private List<Country> searchResults;

   public SelectCountryActivity() {
   }

   private void search(String var1) {
      this.searchResults.clear();
      Iterator var2 = this.countries.iterator();

      while(var2.hasNext()) {
         Country var3 = (Country)var2.next();
         if (var3.getName().toLowerCase(Locale.ENGLISH).contains(var1.toLowerCase())) {
            this.searchResults.add(var3);
         }
      }

      this.sortCountries(this.searchResults);
      this.countriesAdapter.notifyDataSetChanged();
   }

   private void sortCountries(List<Country> var1) {
      Collections.sort(var1, _$$Lambda$SelectCountryActivity$DLGU_cjlwRApTKQJpO7eu4tee6g.INSTANCE);
   }

   public void changeStatusBarColor() {
      this.changeStatusBarColor(-1);
   }

   public void changeStatusBarColor(int var1) {
      Window var2 = this.getWindow();
      if (VERSION.SDK_INT >= 21) {
         var2.addFlags(-2147483648);
      }

      if (VERSION.SDK_INT >= 23) {
         var2.getDecorView().setSystemUiVisibility(8192);
         var2.setStatusBarColor(var1);
      }

   }

   public void onCountrySelected(Country var1) {
      Intent var2 = new Intent();
      var2.putExtra("dialCode", var1.getDialCode());
      var2.putExtra("countryCode", var1.getCode());
      var2.putExtra("flag", var1.getFlag());
      var2.putExtra("currency", var1.getCurrency());
      this.setResult(-1, var2);
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivitySelectCountryBinding var2 = (ActivitySelectCountryBinding)DataBindingUtil.setContentView(this, activity_select_country);
      this.binding = var2;
      this.setSupportActionBar(var2.toolbar);
      this.changeStatusBarColor();
      if (this.getSupportActionBar() != null) {
         this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         this.getSupportActionBar().setTitle("");
         this.getSupportActionBar().setHomeAsUpIndicator(ic_back_arrow_black);
      }

      this.binding.toolbar.setNavigationOnClickListener(new _$$Lambda$SelectCountryActivity$7UyRzFDcK5dxjF3bYYrfPz3p9w4(this));
      this.countries = new ArrayList(Arrays.asList(CountData.COUNTRIES));
      ArrayList var3 = new ArrayList();
      this.searchResults = var3;
      var3.addAll(this.countries);
      this.countriesAdapter = new CountriesAdapter(this, this.searchResults, new _$$Lambda$g6QjV_gey3rwE_4adRdSIEQasE4(this));
      this.binding.countriesRecyclerView.setAdapter(this.countriesAdapter);
      this.binding.countryCodePickerSearch.addTextChangedListener(new 1(this));
      this.binding.countryCodePickerSearch.setOnEditorActionListener(new 2(this));
      if (this.getIntent() != null) {
         Country var4 = (Country)this.getIntent().getParcelableExtra("country");
         if (var4 != null) {
            this.binding.idSelectedCountry.setText(var4.getName());
            this.binding.idSelectedCountry.setCompoundDrawablesWithIntrinsicBounds(this.getResources().getDrawable(var4.getFlag()), (Drawable)null, this.getResources().getDrawable(ic_checked), (Drawable)null);
         }
      }

   }
}
