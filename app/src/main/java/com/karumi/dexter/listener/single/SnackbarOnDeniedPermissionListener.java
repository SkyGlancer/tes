/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
 *  com.google.android.material.snackbar.Snackbar
 *  com.google.android.material.snackbar.Snackbar$Callback
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.karumi.dexter.listener.single;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.single.BasePermissionListener;
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener;

public class SnackbarOnDeniedPermissionListener
extends BasePermissionListener {
    private final String buttonText;
    private final int duration;
    private final View.OnClickListener onButtonClickListener;
    private final Snackbar.Callback snackbarCallback;
    private final String text;
    private final View view;

    private SnackbarOnDeniedPermissionListener(View view, String string2, String string3, View.OnClickListener onClickListener, Snackbar.Callback callback, int n) {
        this.view = view;
        this.text = string2;
        this.buttonText = string3;
        this.onButtonClickListener = onClickListener;
        this.snackbarCallback = callback;
        this.duration = n;
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
        Snackbar.Callback callback;
        View.OnClickListener onClickListener;
        super.onPermissionDenied(permissionDeniedResponse);
        Snackbar snackbar = Snackbar.make((View)this.view, (CharSequence)this.text, (int)this.duration);
        String string2 = this.buttonText;
        if (string2 != null && (onClickListener = this.onButtonClickListener) != null) {
            snackbar.setAction((CharSequence)string2, onClickListener);
        }
        if ((callback = this.snackbarCallback) != null) {
            snackbar.addCallback((BaseTransientBottomBar.BaseCallback)callback);
        }
        snackbar.show();
    }

}

