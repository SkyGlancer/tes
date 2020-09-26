/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editcategory.EditCategoriesViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.editcategory;

import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditCategoriesViewModel$3Igv2Ibd4h2g8t-H3NCrWpou-Rs
implements Consumer {
    public final /* synthetic */ EditCategoriesViewModel f$0;

    public /* synthetic */ -$$Lambda$EditCategoriesViewModel$3Igv2Ibd4h2g8t-H3NCrWpou-Rs(EditCategoriesViewModel editCategoriesViewModel) {
        this.f$0 = editCategoriesViewModel;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateCategory$2$EditCategoriesViewModel((CreateCategoryResonse)object);
    }
}

