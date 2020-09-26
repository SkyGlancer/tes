/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.products;

import app.dukhaan.network.model.SearchProductsResponse;
import app.dukhaan.ui.products.ProductsViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$ProductsViewModel$1vXlRAtAkV4IoD9BCVgKaVZ1wm8
implements Consumer {
    public final /* synthetic */ ProductsViewModel f$0;

    public /* synthetic */ -$$Lambda$ProductsViewModel$1vXlRAtAkV4IoD9BCVgKaVZ1wm8(ProductsViewModel productsViewModel) {
        this.f$0 = productsViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$searchProduct$10$ProductsViewModel((SearchProductsResponse)object);
    }
}

