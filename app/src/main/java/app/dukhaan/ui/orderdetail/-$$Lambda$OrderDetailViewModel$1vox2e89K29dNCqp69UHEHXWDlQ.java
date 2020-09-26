/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.orderdetail;

import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$OrderDetailViewModel$1vox2e89K29dNCqp69UHEHXWDlQ
implements Consumer {
    public final /* synthetic */ OrderDetailViewModel f$0;

    public /* synthetic */ -$$Lambda$OrderDetailViewModel$1vox2e89K29dNCqp69UHEHXWDlQ(OrderDetailViewModel orderDetailViewModel) {
        this.f$0 = orderDetailViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateOrderStatus$4$OrderDetailViewModel((Disposable)object);
    }
}

