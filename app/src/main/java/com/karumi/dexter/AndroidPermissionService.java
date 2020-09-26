/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.PermissionChecker
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

class AndroidPermissionService {
    AndroidPermissionService() {
    }

    int checkSelfPermission(Context context, String string2) {
        return PermissionChecker.checkSelfPermission((Context)context, (String)string2);
    }

    boolean isPermissionPermanentlyDenied(Activity activity, String string2) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return true ^ this.shouldShowRequestPermissionRationale(activity, string2);
    }

    void requestPermissions(Activity activity, String[] arrstring, int n) {
        if (activity == null) {
            return;
        }
        ActivityCompat.requestPermissions((Activity)activity, (String[])arrstring, (int)n);
    }

    boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
        if (activity == null) {
            return false;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity)activity, (String)string2);
    }
}

