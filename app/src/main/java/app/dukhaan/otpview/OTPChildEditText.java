/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.Editable
 *  android.util.AttributeSet
 *  androidx.appcompat.widget.AppCompatEditText
 */
package app.dukhaan.otpview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class OTPChildEditText
extends AppCompatEditText {
    public OTPChildEditText(Context context) {
        super(context);
        this.init(context);
    }

    public OTPChildEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public OTPChildEditText(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context);
    }

    private void init(Context context) {
        this.setCursorVisible(false);
        this.setTextColor(context.getResources().getColor(2131099955));
        this.setBackgroundDrawable(null);
        this.setInputType(2);
        this.setSelectAllOnFocus(false);
        this.setTextIsSelectable(false);
    }

    public void onSelectionChanged(int n, int n2) {
        Editable editable = this.getText();
        if (editable != null && n != editable.length() || n2 != editable.length()) {
            this.setSelection(editable.length(), editable.length());
            return;
        }
        super.onSelectionChanged(n, n2);
    }
}

