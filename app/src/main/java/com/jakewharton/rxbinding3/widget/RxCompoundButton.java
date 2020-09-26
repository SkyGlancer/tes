/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  java.lang.Boolean
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.CompoundButton;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxCompoundButton__CompoundButtonCheckedChangeObservableKt;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxCompoundButton__CompoundButtonCheckedChangeObservableKt"}, k=4, mv={1, 1, 15})
public final class RxCompoundButton {
    public static final InitialValueObservable<Boolean> checkedChanges(CompoundButton compoundButton) {
        return RxCompoundButton__CompoundButtonCheckedChangeObservableKt.checkedChanges(compoundButton);
    }
}

