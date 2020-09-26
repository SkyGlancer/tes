/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editproduct.EditProductViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.editproduct;

import app.dukhaan.data.model.UploadImage;
import app.dukhaan.ui.editproduct.EditProductViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditProductViewModel$I0iGBLG0sfl59e6hTOSaba5KvPQ
implements Consumer {
    public final /* synthetic */ EditProductViewModel f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ -$$Lambda$EditProductViewModel$I0iGBLG0sfl59e6hTOSaba5KvPQ(EditProductViewModel editProductViewModel, String string2, int n, int n2) {
        this.f$0 = editProductViewModel;
        this.f$1 = string2;
        this.f$2 = n;
        this.f$3 = n2;
    }

    public final void accept(Object object) {
        this.f$0.lambda$uploadImage$11$EditProductViewModel(this.f$1, this.f$2, this.f$3, (UploadImage)object);
    }
}

