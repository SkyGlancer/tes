/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.selectcountry;

import app.dukhaan.data.model.Country;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.selectcountry.SelectCountryActivity;

public final class -$$Lambda$g6QjV-gey3rwE-4adRdSIEQasE4
implements CountriesAdapter.OnCountrySelectedListener {
    public final /* synthetic */ SelectCountryActivity f$0;

    public /* synthetic */ -$$Lambda$g6QjV-gey3rwE-4adRdSIEQasE4(SelectCountryActivity selectCountryActivity) {
        this.f$0 = selectCountryActivity;
    }

    @Override
    public final void onCountrySelected(Country country) {
        this.f$0.onCountrySelected(country);
    }
}

