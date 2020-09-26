/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.splash;

import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.ui.splash.SplashViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$SplashViewModel$HJ3mq-FbjSAn1ANy2aJve5lVLgA
implements Consumer {
    public final /* synthetic */ SplashViewModel f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ -$$Lambda$SplashViewModel$HJ3mq-FbjSAn1ANy2aJve5lVLgA(SplashViewModel splashViewModel, int n) {
        this.f$0 = splashViewModel;
        this.f$1 = n;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getAllProducts$14$SplashViewModel(this.f$1, (ProductResponse)object);
    }
}

