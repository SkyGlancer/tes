/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.selectcountry.SelectCountryActivity
 *  java.lang.Object
 *  java.util.Comparator
 */
package app.dukhaan.ui.selectcountry;

import app.dukhaan.data.model.Country;
import app.dukhaan.ui.selectcountry.SelectCountryActivity;
import java.util.Comparator;

public final class -$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g
implements Comparator {
    public static final /* synthetic */ -$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g();
    }

    private /* synthetic */ -$$Lambda$SelectCountryActivity$DLGU-cjlwRApTKQJpO7eu4tee6g() {
    }

    public final int compare(Object object, Object object2) {
        return SelectCountryActivity.lambda$sortCountries$1((Country)((Country)object), (Country)((Country)object2));
    }
}

