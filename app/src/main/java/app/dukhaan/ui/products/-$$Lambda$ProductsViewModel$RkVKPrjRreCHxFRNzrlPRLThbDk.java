/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.products;

import app.dukhaan.ui.products.ProductsViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$ProductsViewModel$RkVKPrjRreCHxFRNzrlPRLThbDk
implements Consumer {
    public final /* synthetic */ ProductsViewModel f$0;

    public /* synthetic */ -$$Lambda$ProductsViewModel$RkVKPrjRreCHxFRNzrlPRLThbDk(ProductsViewModel productsViewModel) {
        this.f$0 = productsViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$fetchProducts$0$ProductsViewModel((Disposable)object);
    }
}

