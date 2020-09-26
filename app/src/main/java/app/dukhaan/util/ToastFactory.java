/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.util;

import android.content.Context;
import android.widget.Toast;

public class ToastFactory {
    public static Toast createToast(Context context) throws Exception {
        return ToastFactory.createToast(context, 2131952004);
    }

    public static Toast createToast(Context context, int n) throws Exception {
        try {
            Toast toast = ToastFactory.createToast(context, context.getString(n));
            return toast;
        }
        catch (Exception exception) {
            throw new Exception("Android Resource not found exception");
        }
    }

    public static Toast createToast(Context context, String string2) {
        return Toast.makeText((Context)context, (CharSequence)string2, (int)1);
    }
}

