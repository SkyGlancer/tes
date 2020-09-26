/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import io.realm.Realm;

public final class -$$Lambda$AppDatabase$w7xp3t54QGsx_iFjBkuCIooJJgo
implements Realm.Transaction {
    public static final /* synthetic */ -$$Lambda$AppDatabase$w7xp3t54QGsx_iFjBkuCIooJJgo INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$AppDatabase$w7xp3t54QGsx_iFjBkuCIooJJgo();
    }

    private /* synthetic */ -$$Lambda$AppDatabase$w7xp3t54QGsx_iFjBkuCIooJJgo() {
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$clearSessionData$0(realm);
    }
}

