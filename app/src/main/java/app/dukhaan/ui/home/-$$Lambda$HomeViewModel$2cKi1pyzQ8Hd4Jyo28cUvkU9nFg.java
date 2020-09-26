/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  app.dukhaan.ui.home.HomeViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.home;

import android.content.Context;
import app.dukhaan.network.model.BusinessStatsResponse;
import app.dukhaan.ui.home.HomeViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$HomeViewModel$2cKi1pyzQ8Hd4Jyo28cUvkU9nFg
implements Consumer {
    public final /* synthetic */ HomeViewModel f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ -$$Lambda$HomeViewModel$2cKi1pyzQ8Hd4Jyo28cUvkU9nFg(HomeViewModel homeViewModel, Context context, String string2) {
        this.f$0 = homeViewModel;
        this.f$1 = context;
        this.f$2 = string2;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getBusinessStats$2$HomeViewModel(this.f$1, this.f$2, (BusinessStatsResponse)object);
    }
}

