/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.products;

import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.ui.products.ProductsViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$ProductsViewModel$ESca5-2koqQ0_zLrHDas0qNTzX8
implements Consumer {
    public final /* synthetic */ ProductsViewModel f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ -$$Lambda$ProductsViewModel$ESca5-2koqQ0_zLrHDas0qNTzX8(ProductsViewModel productsViewModel, int n) {
        this.f$0 = productsViewModel;
        this.f$1 = n;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchProducts$2$ProductsViewModel(this.f$1, (ProductResponse)object);
    }
}

