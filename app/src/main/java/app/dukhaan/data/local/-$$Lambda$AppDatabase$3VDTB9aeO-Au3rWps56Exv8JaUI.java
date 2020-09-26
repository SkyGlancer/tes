/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.model.Business;
import io.realm.Realm;

public final class -$$Lambda$AppDatabase$3VDTB9aeO-Au3rWps56Exv8JaUI
implements Realm.Transaction {
    public final /* synthetic */ Business f$0;

    public /* synthetic */ -$$Lambda$AppDatabase$3VDTB9aeO-Au3rWps56Exv8JaUI(Business business) {
        this.f$0 = business;
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$saveBusiness$1(this.f$0, realm);
    }
}

