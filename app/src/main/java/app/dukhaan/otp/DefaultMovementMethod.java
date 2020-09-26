/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.method.MovementMethod
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.widget.TextView
 *  java.lang.Object
 */
package app.dukhaan.otp;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class DefaultMovementMethod
implements MovementMethod {
    private static DefaultMovementMethod sInstance;

    private DefaultMovementMethod() {
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new DefaultMovementMethod();
        }
        return sInstance;
    }

    public boolean canSelectArbitrarily() {
        return false;
    }

    public void initialize(TextView textView, Spannable spannable) {
        Selection.setSelection((Spannable)spannable, (int)0);
    }

    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public boolean onKeyDown(TextView textView, Spannable spannable, int n, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(TextView textView, Spannable spannable, int n, KeyEvent keyEvent) {
        return false;
    }

    public void onTakeFocus(TextView textView, Spannable spannable, int n) {
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }
}

