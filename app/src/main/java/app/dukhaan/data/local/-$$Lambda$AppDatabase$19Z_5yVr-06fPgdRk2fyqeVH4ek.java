/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.BusinessStats
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.model.BusinessStats;
import io.realm.Realm;

public final class -$$Lambda$AppDatabase$19Z_5yVr-06fPgdRk2fyqeVH4ek
implements Realm.Transaction {
    public final /* synthetic */ BusinessStats f$0;

    public /* synthetic */ -$$Lambda$AppDatabase$19Z_5yVr-06fPgdRk2fyqeVH4ek(BusinessStats businessStats) {
        this.f$0 = businessStats;
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$saveBusinessStats$8(this.f$0, realm);
    }
}

