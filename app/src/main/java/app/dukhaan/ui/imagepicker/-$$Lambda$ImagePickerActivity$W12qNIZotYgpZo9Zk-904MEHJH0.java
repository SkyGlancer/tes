/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  app.dukhaan.ui.imagepicker.ImagePickerActivity
 *  java.lang.Object
 */
package app.dukhaan.ui.imagepicker;

import android.content.DialogInterface;
import app.dukhaan.ui.imagepicker.ImagePickerActivity;

public final class -$$Lambda$ImagePickerActivity$W12qNIZotYgpZo9Zk-904MEHJH0
implements DialogInterface.OnClickListener {
    public final /* synthetic */ ImagePickerActivity.PickerOptionListener f$0;

    public /* synthetic */ -$$Lambda$ImagePickerActivity$W12qNIZotYgpZo9Zk-904MEHJH0(ImagePickerActivity.PickerOptionListener pickerOptionListener) {
        this.f$0 = pickerOptionListener;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        ImagePickerActivity.lambda$showImagePickerOptions$0((ImagePickerActivity.PickerOptionListener)this.f$0, (DialogInterface)dialogInterface, (int)n);
    }
}

