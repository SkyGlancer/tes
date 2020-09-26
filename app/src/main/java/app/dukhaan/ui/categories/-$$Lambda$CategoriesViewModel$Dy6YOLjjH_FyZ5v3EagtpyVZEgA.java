/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.categories.CategoriesViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.categories;

import app.dukhaan.network.model.DeleteCategoryResonse;
import app.dukhaan.ui.categories.CategoriesViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$CategoriesViewModel$Dy6YOLjjH_FyZ5v3EagtpyVZEgA
implements Consumer {
    public final /* synthetic */ CategoriesViewModel f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ -$$Lambda$CategoriesViewModel$Dy6YOLjjH_FyZ5v3EagtpyVZEgA(CategoriesViewModel categoriesViewModel, int n) {
        this.f$0 = categoriesViewModel;
        this.f$1 = n;
    }

    public final void accept(Object object) {
        this.f$0.lambda$deleteCategory$6$CategoriesViewModel(this.f$1, (DeleteCategoryResonse)object);
    }
}

