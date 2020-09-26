/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.multi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;

public class DialogOnAnyDeniedMultiplePermissionsListener
extends BaseMultiplePermissionsListener {
    private final Context context;
    private final Drawable icon;
    private final String message;
    private final String positiveButtonText;
    private final String title;

    private DialogOnAnyDeniedMultiplePermissionsListener(Context context, String string2, String string3, String string4, Drawable drawable2) {
        this.context = context;
        this.title = string2;
        this.message = string3;
        this.positiveButtonText = string4;
        this.icon = drawable2;
    }

    private void showDialog() {
        new AlertDialog.Builder(this.context).setTitle((CharSequence)this.title).setMessage((CharSequence)this.message).setPositiveButton((CharSequence)this.positiveButtonText, new DialogInterface.OnClickListener(this){
            final /* synthetic */ DialogOnAnyDeniedMultiplePermissionsListener this$0;
            {
                this.this$0 = dialogOnAnyDeniedMultiplePermissionsListener;
            }

            public void onClick(DialogInterface dialogInterface, int n) {
                dialogInterface.dismiss();
            }
        }).setIcon(this.icon).show();
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
        super.onPermissionsChecked(multiplePermissionsReport);
        if (!multiplePermissionsReport.areAllPermissionsGranted()) {
            this.showDialog();
        }
    }

}

