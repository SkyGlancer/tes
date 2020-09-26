/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.account.AccountViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 *  java.lang.Throwable
 */
package app.dukhaan.ui.account;

import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.ui.account.AccountViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$AccountViewModel$MztDlvPP58m_bjDWkU2inTMUO74
implements Consumer {
    public final /* synthetic */ AccountViewModel f$0;
    public final /* synthetic */ EditBusinessRequest f$1;

    public /* synthetic */ -$$Lambda$AccountViewModel$MztDlvPP58m_bjDWkU2inTMUO74(AccountViewModel accountViewModel, EditBusinessRequest editBusinessRequest) {
        this.f$0 = accountViewModel;
        this.f$1 = editBusinessRequest;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateBusinessDetails$4$AccountViewModel(this.f$1, (Throwable)object);
    }
}

