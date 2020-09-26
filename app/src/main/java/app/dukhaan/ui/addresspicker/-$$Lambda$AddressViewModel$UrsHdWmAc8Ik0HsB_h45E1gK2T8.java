/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.addresspicker.AddressViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.addresspicker;

import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$AddressViewModel$UrsHdWmAc8Ik0HsB_h45E1gK2T8
implements Consumer {
    public final /* synthetic */ AddressViewModel f$0;

    public /* synthetic */ -$$Lambda$AddressViewModel$UrsHdWmAc8Ik0HsB_h45E1gK2T8(AddressViewModel addressViewModel) {
        this.f$0 = addressViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$newGooglePlacesResponse$1$AddressViewModel((GooglePlacesResponse)object);
    }
}

