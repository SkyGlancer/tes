/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSession
 */
package app.dukhaan.di.module;

import app.dukhaan.di.module.AppModule;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class -$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y
implements HostnameVerifier {
    public static final /* synthetic */ -$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y();
    }

    private /* synthetic */ -$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y() {
    }

    public final boolean verify(String string2, SSLSession sSLSession) {
        return AppModule.lambda$providesOkHttpClient$0(string2, sSLSession);
    }
}

