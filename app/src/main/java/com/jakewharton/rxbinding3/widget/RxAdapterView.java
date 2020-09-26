/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.AdapterViewItemClickEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewItemLongClickEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewItemClickEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewItemClickObservableKt;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewItemLongClickEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewItemLongClickObservableKt;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewItemSelectionObservableKt;
import com.jakewharton.rxbinding3.widget.RxAdapterView__AdapterViewSelectionObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemClickEventObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemClickObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemLongClickEventObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemLongClickObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewItemSelectionObservableKt", "com/jakewharton/rxbinding3/widget/RxAdapterView__AdapterViewSelectionObservableKt"}, k=4, mv={1, 1, 15})
public final class RxAdapterView {
    public static final <T extends Adapter> Observable<AdapterViewItemClickEvent> itemClickEvents(AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemClickEventObservableKt.itemClickEvents(adapterView);
    }

    public static final <T extends Adapter> Observable<Integer> itemClicks(AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemClickObservableKt.itemClicks(adapterView);
    }

    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> adapterView) {
        return RxAdapterView.itemLongClickEvents$default(adapterView, null, 1, null);
    }

    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> adapterView, Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        return RxAdapterView__AdapterViewItemLongClickEventObservableKt.itemLongClickEvents(adapterView, function1);
    }

    public static /* synthetic */ Observable itemLongClickEvents$default(AdapterView adapterView, Function1 function1, int n, Object object) {
        return RxAdapterView__AdapterViewItemLongClickEventObservableKt.itemLongClickEvents$default(adapterView, function1, n, object);
    }

    public static final <T extends Adapter> Observable<Integer> itemLongClicks(AdapterView<T> adapterView) {
        return RxAdapterView.itemLongClicks$default(adapterView, null, 1, null);
    }

    public static final <T extends Adapter> Observable<Integer> itemLongClicks(AdapterView<T> adapterView, Function0<Boolean> function0) {
        return RxAdapterView__AdapterViewItemLongClickObservableKt.itemLongClicks(adapterView, function0);
    }

    public static /* synthetic */ Observable itemLongClicks$default(AdapterView adapterView, Function0 function0, int n, Object object) {
        return RxAdapterView__AdapterViewItemLongClickObservableKt.itemLongClicks$default(adapterView, function0, n, object);
    }

    public static final <T extends Adapter> InitialValueObservable<Integer> itemSelections(AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewItemSelectionObservableKt.itemSelections(adapterView);
    }

    public static final <T extends Adapter> InitialValueObservable<AdapterViewSelectionEvent> selectionEvents(AdapterView<T> adapterView) {
        return RxAdapterView__AdapterViewSelectionObservableKt.selectionEvents(adapterView);
    }
}

