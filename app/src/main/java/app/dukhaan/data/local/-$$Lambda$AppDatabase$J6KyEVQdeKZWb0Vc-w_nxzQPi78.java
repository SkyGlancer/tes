/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Category
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.network.model.Category;
import io.realm.Realm;

public final class -$$Lambda$AppDatabase$J6KyEVQdeKZWb0Vc-w_nxzQPi78
implements Realm.Transaction {
    public final /* synthetic */ Category f$0;

    public /* synthetic */ -$$Lambda$AppDatabase$J6KyEVQdeKZWb0Vc-w_nxzQPi78(Category category) {
        this.f$0 = category;
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$saveCategory$6(this.f$0, realm);
    }
}

