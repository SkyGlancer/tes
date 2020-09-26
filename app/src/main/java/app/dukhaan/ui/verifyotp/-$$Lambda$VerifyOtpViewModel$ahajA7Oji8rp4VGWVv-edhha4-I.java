/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.verifyotp;

import app.dukhaan.network.model.LoginRequest;
import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.ui.verifyotp.VerifyOtpViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$VerifyOtpViewModel$ahajA7Oji8rp4VGWVv-edhha4-I
implements Consumer {
    public final /* synthetic */ VerifyOtpViewModel f$0;
    public final /* synthetic */ LoginRequest f$1;

    public /* synthetic */ -$$Lambda$VerifyOtpViewModel$ahajA7Oji8rp4VGWVv-edhha4-I(VerifyOtpViewModel verifyOtpViewModel, LoginRequest loginRequest) {
        this.f$0 = verifyOtpViewModel;
        this.f$1 = loginRequest;
    }

    public final void accept(Object object) {
        this.f$0.lambda$login$1$VerifyOtpViewModel(this.f$1, (LoginResponse)object);
    }
}

