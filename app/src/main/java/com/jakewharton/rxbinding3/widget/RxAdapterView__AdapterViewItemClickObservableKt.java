/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  com.jakewharton.rxbinding3.widget.AdapterViewItemClickObservable
 *  io.reactivex.Observable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.widget.AdapterViewItemClickObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0007\u00a8\u0006\u0006"}, d2={"itemClicks", "Lio/reactivex/Observable;", "", "T", "Landroid/widget/Adapter;", "Landroid/widget/AdapterView;", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/widget/RxAdapterView")
final class RxAdapterView__AdapterViewItemClickObservableKt {
    public static final <T extends Adapter> Observable<Integer> itemClicks(AdapterView<T> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"$this$itemClicks");
        return (Observable)new AdapterViewItemClickObservable(adapterView);
    }
}

