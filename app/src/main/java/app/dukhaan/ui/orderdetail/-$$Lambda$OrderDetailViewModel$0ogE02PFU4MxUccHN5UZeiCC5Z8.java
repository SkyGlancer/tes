/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.orderdetail;

import app.dukhaan.network.model.TrackOrderResponse;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$OrderDetailViewModel$0ogE02PFU4MxUccHN5UZeiCC5Z8
implements Consumer {
    public final /* synthetic */ OrderDetailViewModel f$0;

    public /* synthetic */ -$$Lambda$OrderDetailViewModel$0ogE02PFU4MxUccHN5UZeiCC5Z8(OrderDetailViewModel orderDetailViewModel) {
        this.f$0 = orderDetailViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getOrderDetails$2$OrderDetailViewModel((TrackOrderResponse)object);
    }
}

