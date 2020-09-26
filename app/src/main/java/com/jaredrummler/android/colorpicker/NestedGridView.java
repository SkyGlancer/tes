/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.GridView
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class NestedGridView
extends GridView {
    public NestedGridView(Context context) {
        super(context);
    }

    public NestedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NestedGridView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public void onMeasure(int n, int n2) {
        super.onMeasure(n, MeasureSpec.makeMeasureSpec((int)536870911, (int)Integer.MIN_VALUE));
    }
}

