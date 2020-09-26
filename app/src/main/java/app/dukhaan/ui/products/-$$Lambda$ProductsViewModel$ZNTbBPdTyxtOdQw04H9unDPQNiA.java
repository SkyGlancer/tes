/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.products;

import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.ui.products.ProductsViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$ProductsViewModel$ZNTbBPdTyxtOdQw04H9unDPQNiA
implements Consumer {
    public final /* synthetic */ ProductsViewModel f$0;
    public final /* synthetic */ EditProductRequest f$1;

    public /* synthetic */ -$$Lambda$ProductsViewModel$ZNTbBPdTyxtOdQw04H9unDPQNiA(ProductsViewModel productsViewModel, EditProductRequest editProductRequest) {
        this.f$0 = productsViewModel;
        this.f$1 = editProductRequest;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateProduct$14$ProductsViewModel(this.f$1, (EditProductResponse)object);
    }
}

