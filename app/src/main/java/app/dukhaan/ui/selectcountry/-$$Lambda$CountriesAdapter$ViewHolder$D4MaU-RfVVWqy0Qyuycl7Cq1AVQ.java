/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  app.dukhaan.ui.selectcountry.CountriesAdapter$ViewHolder
 *  java.lang.Object
 */
package app.dukhaan.ui.selectcountry;

import android.view.View;
import app.dukhaan.data.model.Country;
import app.dukhaan.ui.selectcountry.CountriesAdapter;

public final class -$$Lambda$CountriesAdapter$ViewHolder$D4MaU-RfVVWqy0Qyuycl7Cq1AVQ
implements View.OnClickListener {
    public final /* synthetic */ CountriesAdapter.ViewHolder f$0;
    public final /* synthetic */ Country f$1;

    public /* synthetic */ -$$Lambda$CountriesAdapter$ViewHolder$D4MaU-RfVVWqy0Qyuycl7Cq1AVQ(CountriesAdapter.ViewHolder viewHolder, Country country) {
        this.f$0 = viewHolder;
        this.f$1 = country;
    }

    public final void onClick(View view) {
        this.f$0.lambda$bind$0$CountriesAdapter$ViewHolder(this.f$1, view);
    }
}

