/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.ui.splash.SplashViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$SplashViewModel$lZByKbF5xdzyCW7opSu-wD4TH_I
implements Consumer {
    public final /* synthetic */ SplashViewModel f$0;

    public /* synthetic */ -$$Lambda$SplashViewModel$lZByKbF5xdzyCW7opSu-wD4TH_I(SplashViewModel splashViewModel) {
        this.f$0 = splashViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$verifyAuthToken$1$SplashViewModel((LoginResponse)object);
    }
}

