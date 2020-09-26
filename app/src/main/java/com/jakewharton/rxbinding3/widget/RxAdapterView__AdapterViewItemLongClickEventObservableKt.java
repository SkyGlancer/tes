/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  com.jakewharton.rxbinding3.internal.AlwaysTrue
 *  com.jakewharton.rxbinding3.widget.AdapterViewItemLongClickEventObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import com.jakewharton.rxbinding3.widget.AdapterViewItemLongClickEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewItemLongClickEventObservable;
import com.jakewharton.rxbinding3.widget.RxAdapterView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a8\u0006\t"}, d2={"itemLongClickEvents", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickEvent;", "T", "Landroid/widget/Adapter;", "Landroid/widget/AdapterView;", "handled", "Lkotlin/Function1;", "", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/widget/RxAdapterView")
final class RxAdapterView__AdapterViewItemLongClickEventObservableKt {
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> adapterView) {
        return RxAdapterView.itemLongClickEvents$default(adapterView, null, 1, null);
    }

    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(AdapterView<T> adapterView, Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"$this$itemLongClickEvents");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        return (Observable)new AdapterViewItemLongClickEventObservable(adapterView, function1);
    }

    public static /* synthetic */ Observable itemLongClickEvents$default(AdapterView adapterView, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = (Function1)AlwaysTrue.INSTANCE;
        }
        return RxAdapterView.itemLongClickEvents(adapterView, (Function1<? super AdapterViewItemLongClickEvent, Boolean>)function1);
    }
}

