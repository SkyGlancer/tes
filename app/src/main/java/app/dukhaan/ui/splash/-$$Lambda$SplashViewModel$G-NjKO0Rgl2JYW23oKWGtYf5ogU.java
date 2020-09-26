/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.network.model.BusinessListResponse;
import app.dukhaan.ui.splash.SplashViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$SplashViewModel$G-NjKO0Rgl2JYW23oKWGtYf5ogU
implements Consumer {
    public final /* synthetic */ SplashViewModel f$0;

    public /* synthetic */ -$$Lambda$SplashViewModel$G-NjKO0Rgl2JYW23oKWGtYf5ogU(SplashViewModel splashViewModel) {
        this.f$0 = splashViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchBusiness$10$SplashViewModel((BusinessListResponse)object);
    }
}

