/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.databinding.ActivitySelectCountryBinding
 *  app.dukhaan.ui.selectcountry.-$
 *  app.dukhaan.ui.selectcountry.-$$Lambda
 *  app.dukhaan.ui.selectcountry.-$$Lambda$g6QjV-gey3rwE-4adRdSIEQasE4
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Locale
 */
package app.dukhaan.ui.selectcountry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivitySelectCountryBinding;
import app.dukhaan.ui.selectcountry.-$;
import app.dukhaan.ui.selectcountry.-$$Lambda$SelectCountryActivity$7UyRzFDcK5dxjF3bYYrfPz3p9w4;
import app.dukhaan.ui.selectcountry.-$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.selectcountry.SelectCountryActivity;
import app.dukhaan.util.CountData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SelectCountryActivity
extends AppCompatActivity
implements CountriesAdapter.OnCountrySelectedListener {
    private ActivitySelectCountryBinding binding;
    private List<Country> countries;
    private CountriesAdapter countriesAdapter;
    private List<Country> searchResults;

    static /* synthetic */ void access$000(SelectCountryActivity selectCountryActivity, String string2) {
        selectCountryActivity.search(string2);
    }

    static /* synthetic */ ActivitySelectCountryBinding access$100(SelectCountryActivity selectCountryActivity) {
        return selectCountryActivity.binding;
    }

    static /* synthetic */ int lambda$sortCountries$1(Country country, Country country2) {
        return country.getName().trim().compareToIgnoreCase(country2.getName().trim());
    }

    private void search(String string2) {
        this.searchResults.clear();
        for (Country country : this.countries) {
            if (!country.getName().toLowerCase(Locale.ENGLISH).contains((CharSequence)string2.toLowerCase())) continue;
            this.searchResults.add((Object)country);
        }
        this.sortCountries(this.searchResults);
        this.countriesAdapter.notifyDataSetChanged();
    }

    private void sortCountries(List<Country> list) {
        Collections.sort(list, (Comparator)-$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g.INSTANCE);
    }

    public void changeStatusBarColor() {
        this.changeStatusBarColor(-1);
    }

    public void changeStatusBarColor(int n) {
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(n);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$SelectCountryActivity(View view) {
        this.onBackPressed();
    }

    @Override
    public void onCountrySelected(Country country) {
        Intent intent = new Intent();
        intent.putExtra("dialCode", country.getDialCode());
        intent.putExtra("countryCode", country.getCode());
        intent.putExtra("flag", country.getFlag());
        intent.putExtra("currency", country.getCurrency());
        this.setResult(-1, intent);
        this.finish();
    }

    protected void onCreate(Bundle bundle) {
        ArrayList arrayList;
        ActivitySelectCountryBinding activitySelectCountryBinding;
        Country country;
        super.onCreate(bundle);
        this.binding = activitySelectCountryBinding = (ActivitySelectCountryBinding)DataBindingUtil.setContentView((Activity)this, (int)2131558447);
        this.setSupportActionBar(activitySelectCountryBinding.toolbar);
        this.changeStatusBarColor();
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setTitle((CharSequence)"");
            this.getSupportActionBar().setHomeAsUpIndicator(2131231220);
        }
        this.binding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$SelectCountryActivity$7UyRzFDcK5dxjF3bYYrfPz3p9w4(this));
        this.countries = new ArrayList((Collection)Arrays.asList((Object[])CountData.COUNTRIES));
        this.searchResults = arrayList = new ArrayList();
        arrayList.addAll(this.countries);
        this.countriesAdapter = new CountriesAdapter((Context)this, this.searchResults, (CountriesAdapter.OnCountrySelectedListener)new -$.Lambda.g6QjV-gey3rwE-4adRdSIEQasE4(this));
        this.binding.countriesRecyclerView.setAdapter((RecyclerView.Adapter)this.countriesAdapter);
        this.binding.countryCodePickerSearch.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ SelectCountryActivity this$0;
            {
                this.this$0 = selectCountryActivity;
            }

            public void afterTextChanged(android.text.Editable editable) {
                SelectCountryActivity.access$000(this.this$0, editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        this.binding.countryCodePickerSearch.setOnEditorActionListener(new TextView.OnEditorActionListener(this){
            final /* synthetic */ SelectCountryActivity this$0;
            {
                this.this$0 = selectCountryActivity;
            }

            public boolean onEditorAction(TextView textView, int n, android.view.KeyEvent keyEvent) {
                android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager)SelectCountryActivity.access$100((SelectCountryActivity)this.this$0).countryCodePickerSearch.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(SelectCountryActivity.access$100((SelectCountryActivity)this.this$0).countryCodePickerSearch.getWindowToken(), 0);
                }
                return true;
            }
        });
        if (this.getIntent() != null && (country = (Country)this.getIntent().getParcelableExtra("country")) != null) {
            this.binding.idSelectedCountry.setText((CharSequence)country.getName());
            this.binding.idSelectedCountry.setCompoundDrawablesWithIntrinsicBounds(this.getResources().getDrawable(country.getFlag()), null, this.getResources().getDrawable(2131231223), null);
        }
    }
}

