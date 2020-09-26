/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.Object
 */
package app.dukhaan.util;

import android.app.Activity;
import android.content.DialogInterface;
import app.dukhaan.util.AppUtils;

public final class -$$Lambda$AppUtils$utJ1JBN9nKaQ47N7q9GqzXIquPM
implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ -$$Lambda$AppUtils$utJ1JBN9nKaQ47N7q9GqzXIquPM(Activity activity) {
        this.f$0 = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        AppUtils.lambda$showSettingsDialog$4(this.f$0, dialogInterface, n);
    }
}

