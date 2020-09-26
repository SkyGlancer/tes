/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.location.LocationSettingsResult
 *  java.lang.Object
 */
package app.dukhaan.ui.addresspicker;

import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationSettingsResult;

public final class -$$Lambda$AddressSelectActivity$z7jpCucnIaLfYJs3VfucmiwRUos
implements ResultCallback {
    public final /* synthetic */ AddressSelectActivity f$0;

    public /* synthetic */ -$$Lambda$AddressSelectActivity$z7jpCucnIaLfYJs3VfucmiwRUos(AddressSelectActivity addressSelectActivity) {
        this.f$0 = addressSelectActivity;
    }

    public final void onResult(Result result) {
        this.f$0.lambda$initGPS$2$AddressSelectActivity((LocationSettingsResult)result);
    }
}

