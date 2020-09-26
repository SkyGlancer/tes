/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  java.lang.Object
 */
package app.dukhaan.ui.editbusiness;

import app.dukhaan.data.model.Country;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import app.dukhaan.ui.selectcountry.CountriesAdapter;

public final class -$$Lambda$b4ZKQkHElZ-f1UkpcnmvBqDbNXg
implements CountriesAdapter.OnCountrySelectedListener {
    public final /* synthetic */ EditBusinessActivity f$0;

    public /* synthetic */ -$$Lambda$b4ZKQkHElZ-f1UkpcnmvBqDbNXg(EditBusinessActivity editBusinessActivity) {
        this.f$0 = editBusinessActivity;
    }

    @Override
    public final void onCountrySelected(Country country) {
        this.f$0.onCountrySelected(country);
    }
}

