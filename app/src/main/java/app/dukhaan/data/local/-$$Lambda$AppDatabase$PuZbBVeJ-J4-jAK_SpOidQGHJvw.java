/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import io.realm.Realm;
import java.util.List;

public final class -$$Lambda$AppDatabase$PuZbBVeJ-J4-jAK_SpOidQGHJvw
implements Realm.Transaction {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ -$$Lambda$AppDatabase$PuZbBVeJ-J4-jAK_SpOidQGHJvw(boolean bl, List list) {
        this.f$0 = bl;
        this.f$1 = list;
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$saveCategories$5(this.f$0, this.f$1, realm);
    }
}

