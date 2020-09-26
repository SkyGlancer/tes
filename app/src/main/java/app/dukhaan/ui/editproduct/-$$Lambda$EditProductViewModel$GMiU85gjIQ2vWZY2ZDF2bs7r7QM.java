/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.editproduct;

import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditProductViewModel$GMiU85gjIQ2vWZY2ZDF2bs7r7QM
implements Consumer {
    public final /* synthetic */ EditProductViewModel f$0;

    public /* synthetic */ -$$Lambda$EditProductViewModel$GMiU85gjIQ2vWZY2ZDF2bs7r7QM(EditProductViewModel editProductViewModel) {
        this.f$0 = editProductViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getCategoryList$15$EditProductViewModel((CategoryListResponse)object);
    }
}

