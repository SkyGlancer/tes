/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  app.dukhaan.ui.imagepicker.MultiImagePickerActivity
 *  java.lang.Object
 */
package app.dukhaan.ui.imagepicker;

import android.content.DialogInterface;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity;

public final class -$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo-bAWoKuy6JPg
implements DialogInterface.OnClickListener {
    public final /* synthetic */ MultiImagePickerActivity.PickerOptionListener f$0;

    public /* synthetic */ -$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo-bAWoKuy6JPg(MultiImagePickerActivity.PickerOptionListener pickerOptionListener) {
        this.f$0 = pickerOptionListener;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        MultiImagePickerActivity.lambda$showImagePickerOptions$0((MultiImagePickerActivity.PickerOptionListener)this.f$0, (DialogInterface)dialogInterface, (int)n);
    }
}

