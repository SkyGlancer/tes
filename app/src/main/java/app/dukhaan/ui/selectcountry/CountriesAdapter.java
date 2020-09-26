/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.selectcountry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ItemCountryBinding;
import app.dukhaan.ui.selectcountry.-$$Lambda$CountriesAdapter$ViewHolder$D4MaU-RfVVWqy0Qyuycl7Cq1AVQ;
import java.util.List;

public class CountriesAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<Country> countries;
    private OnCountrySelectedListener countrySelectedListener;

    public CountriesAdapter(Context context, List<Country> list, OnCountrySelectedListener onCountrySelectedListener) {
        this.context = context;
        this.countries = list;
        this.countrySelectedListener = onCountrySelectedListener;
    }

    public int getItemCount() {
        return this.countries.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        viewHolder.bind(n);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder((ItemCountryBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558523, (ViewGroup)viewGroup, (boolean)false));
    }

    class ViewHolder
    extends RecyclerView.ViewHolder {
        private ItemCountryBinding binding;

        ViewHolder(ItemCountryBinding itemCountryBinding) {
            super(itemCountryBinding.getRoot());
            this.binding = itemCountryBinding;
        }

        void bind(int n) {
            Country country = (Country)CountriesAdapter.this.countries.get(n);
            this.binding.countryTitle.setText((CharSequence)country.getName());
            country.loadFlagByCode(CountriesAdapter.this.context);
            if (country.getFlag() != -1) {
                this.binding.countryFlag.setImageResource(country.getFlag());
            }
            this.binding.rootView.setOnClickListener((View.OnClickListener)new -$$Lambda$CountriesAdapter$ViewHolder$D4MaU-RfVVWqy0Qyuycl7Cq1AVQ(this, country));
        }

        public /* synthetic */ void lambda$bind$0$CountriesAdapter$ViewHolder(Country country, View view) {
            CountriesAdapter.this.countrySelectedListener.onCountrySelected(country);
        }
    }

}

