/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.editproduct;

import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditProductViewModel$SiDAzW_ebJVsBeD4DJs94aZBbV0
implements Consumer {
    public final /* synthetic */ EditProductViewModel f$0;

    public /* synthetic */ -$$Lambda$EditProductViewModel$SiDAzW_ebJVsBeD4DJs94aZBbV0(EditProductViewModel editProductViewModel) {
        this.f$0 = editProductViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$addProduct$2$EditProductViewModel((AddProductResponse)object);
    }
}

