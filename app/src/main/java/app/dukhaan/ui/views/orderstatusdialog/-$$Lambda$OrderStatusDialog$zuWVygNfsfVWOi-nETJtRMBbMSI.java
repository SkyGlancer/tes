/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 */
package app.dukhaan.ui.views.orderstatusdialog;

import android.view.View;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialog;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;

public final class -$$Lambda$OrderStatusDialog$zuWVygNfsfVWOi-nETJtRMBbMSI
implements View.OnClickListener {
    public final /* synthetic */ OrderStatusDialog f$0;
    public final /* synthetic */ OrderStatusDialogType f$1;

    public /* synthetic */ -$$Lambda$OrderStatusDialog$zuWVygNfsfVWOi-nETJtRMBbMSI(OrderStatusDialog orderStatusDialog, OrderStatusDialogType orderStatusDialogType) {
        this.f$0 = orderStatusDialog;
        this.f$1 = orderStatusDialogType;
    }

    public final void onClick(View view) {
        this.f$0.lambda$statusTypeDialog$1$OrderStatusDialog(this.f$1, view);
    }
}

