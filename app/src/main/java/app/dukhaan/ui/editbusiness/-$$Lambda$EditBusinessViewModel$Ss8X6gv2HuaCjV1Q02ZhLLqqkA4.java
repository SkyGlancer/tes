/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.editbusiness.EditBusinessViewModel
 *  io.reactivex.functions.Consumer
 *  java.lang.Object
 */
package app.dukhaan.ui.editbusiness;

import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import io.reactivex.functions.Consumer;

public final class -$$Lambda$EditBusinessViewModel$Ss8X6gv2HuaCjV1Q02ZhLLqqkA4
implements Consumer {
    public final /* synthetic */ EditBusinessViewModel f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ -$$Lambda$EditBusinessViewModel$Ss8X6gv2HuaCjV1Q02ZhLLqqkA4(EditBusinessViewModel editBusinessViewModel, boolean bl) {
        this.f$0 = editBusinessViewModel;
        this.f$1 = bl;
    }

    public final void accept(Object object) {
        this.f$0.lambda$updateBusinessDetails$5$EditBusinessViewModel(this.f$1, (AddBusinessResponse)object);
    }
}

