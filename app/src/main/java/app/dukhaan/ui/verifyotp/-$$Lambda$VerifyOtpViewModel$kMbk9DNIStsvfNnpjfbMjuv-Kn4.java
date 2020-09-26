/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.verifyotp;

import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$VerifyOtpViewModel$kMbk9DNIStsvfNnpjfbMjuv-Kn4
implements Consumer {
    public final /* synthetic */ VerifyOtpViewModel f$0;

    public /* synthetic */ -$$Lambda$VerifyOtpViewModel$kMbk9DNIStsvfNnpjfbMjuv-Kn4(VerifyOtpViewModel verifyOtpViewModel) {
        this.f$0 = verifyOtpViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$login$2$VerifyOtpViewModel((LoginResponse)object);
    }
}

