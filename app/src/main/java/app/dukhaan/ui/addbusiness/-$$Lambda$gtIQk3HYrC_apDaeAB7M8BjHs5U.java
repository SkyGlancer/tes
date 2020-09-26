/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  java.lang.Object
 */
package app.dukhaan.ui.addbusiness;

import app.dukhaan.data.model.Country;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.selectcountry.CountriesAdapter;

public final class -$$Lambda$gtIQk3HYrC_apDaeAB7M8BjHs5U
implements CountriesAdapter.OnCountrySelectedListener {
    public final /* synthetic */ AddBusinessActivity f$0;

    public /* synthetic */ -$$Lambda$gtIQk3HYrC_apDaeAB7M8BjHs5U(AddBusinessActivity addBusinessActivity) {
        this.f$0 = addBusinessActivity;
    }

    @Override
    public final void onCountrySelected(Country country) {
        this.f$0.onCountrySelected(country);
    }
}

