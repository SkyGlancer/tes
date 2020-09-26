/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Observer
 *  java.lang.Object
 */
package app.dukhaan.ui.addresspicker;

import androidx.lifecycle.Observer;
import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch;

public final class -$$Lambda$BottomSheetPlacesSearch$TDZ8ETT7ZbIv8RV8QRzDE7KLp18
implements Observer {
    public final /* synthetic */ BottomSheetPlacesSearch f$0;

    public /* synthetic */ -$$Lambda$BottomSheetPlacesSearch$TDZ8ETT7ZbIv8RV8QRzDE7KLp18(BottomSheetPlacesSearch bottomSheetPlacesSearch) {
        this.f$0 = bottomSheetPlacesSearch;
    }

    public final void onChanged(Object object) {
        this.f$0.lambda$onCreateView$0$BottomSheetPlacesSearch((GooglePlacesResponse)object);
    }
}

