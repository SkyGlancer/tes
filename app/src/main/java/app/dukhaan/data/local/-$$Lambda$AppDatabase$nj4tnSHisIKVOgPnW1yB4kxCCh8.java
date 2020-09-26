/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.AppDatabase;
import io.realm.Realm;
import java.util.concurrent.atomic.AtomicReference;

public final class -$$Lambda$AppDatabase$nj4tnSHisIKVOgPnW1yB4kxCCh8
implements Realm.Transaction {
    public final /* synthetic */ AtomicReference f$0;

    public /* synthetic */ -$$Lambda$AppDatabase$nj4tnSHisIKVOgPnW1yB4kxCCh8(AtomicReference atomicReference) {
        this.f$0 = atomicReference;
    }

    public final void execute(Realm realm) {
        AppDatabase.lambda$getCategory$7(this.f$0, realm);
    }
}

