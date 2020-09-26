/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.maps.GoogleMap
 *  com.google.android.gms.maps.GoogleMap$OnCameraIdleListener
 *  java.lang.Object
 */
package app.dukhaan.ui.addresspicker;

import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import com.google.android.gms.maps.GoogleMap;

public final class -$$Lambda$AddressSelectActivity$UoObnEq6Ct9ZzLoTBD2DPPECeRg
implements GoogleMap.OnCameraIdleListener {
    public final /* synthetic */ AddressSelectActivity f$0;

    public /* synthetic */ -$$Lambda$AddressSelectActivity$UoObnEq6Ct9ZzLoTBD2DPPECeRg(AddressSelectActivity addressSelectActivity) {
        this.f$0 = addressSelectActivity;
    }

    public final void onCameraIdle() {
        this.f$0.lambda$setLocationOnMap$3$AddressSelectActivity();
    }
}

