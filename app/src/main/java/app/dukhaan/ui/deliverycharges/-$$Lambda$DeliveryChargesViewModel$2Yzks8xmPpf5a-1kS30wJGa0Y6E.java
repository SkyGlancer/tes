/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.deliverycharges;

import app.dukhaan.network.model.EditDeliveryChargeResponse;
import app.dukhaan.ui.deliverycharges.DeliveryChargesViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$DeliveryChargesViewModel$2Yzks8xmPpf5a-1kS30wJGa0Y6E
implements Consumer {
    public final /* synthetic */ DeliveryChargesViewModel f$0;

    public /* synthetic */ -$$Lambda$DeliveryChargesViewModel$2Yzks8xmPpf5a-1kS30wJGa0Y6E(DeliveryChargesViewModel deliveryChargesViewModel) {
        this.f$0 = deliveryChargesViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateDeliveryChargeDetails$1$DeliveryChargesViewModel((EditDeliveryChargeResponse)object);
    }
}

