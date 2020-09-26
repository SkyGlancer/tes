/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Adapter
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxAdapter__AdapterDataChangeObservableKt;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxAdapter__AdapterDataChangeObservableKt"}, k=4, mv={1, 1, 15})
public final class RxAdapter {
    public static final <T extends Adapter> InitialValueObservable<T> dataChanges(T t) {
        return RxAdapter__AdapterDataChangeObservableKt.dataChanges(t);
    }
}

