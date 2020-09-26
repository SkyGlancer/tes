/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  java.lang.Object
 */
package app.dukhaan.ui.sync_contacts;

import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import io.reactivex.functions.Predicate;
import ir.mirrajabi.rxcontacts.Contact;

public final class -$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ
implements Predicate {
    public static final /* synthetic */ -$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ();
    }

    private /* synthetic */ -$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ() {
    }

    public final boolean test(Object object) {
        return SyncContactsActivity.lambda$fetchContactsObservable$7((Contact)object);
    }
}

