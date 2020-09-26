/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.editproduct;

import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditProductViewModel$9__pF_7eX8tEtmZCHUoQAMLwTVU
implements Consumer {
    public final /* synthetic */ EditProductViewModel f$0;

    public /* synthetic */ -$$Lambda$EditProductViewModel$9__pF_7eX8tEtmZCHUoQAMLwTVU(EditProductViewModel editProductViewModel) {
        this.f$0 = editProductViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateProduct$19$EditProductViewModel((EditProductResponse)object);
    }
}

