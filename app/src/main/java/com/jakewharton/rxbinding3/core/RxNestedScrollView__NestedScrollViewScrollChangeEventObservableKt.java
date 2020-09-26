/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.core.widget.NestedScrollView
 *  com.jakewharton.rxbinding3.core.NestedScrollViewScrollChangeEventObservable
 *  io.reactivex.Observable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.core;

import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding3.core.NestedScrollViewScrollChangeEventObservable;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"scrollChangeEvents", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/ViewScrollChangeEvent;", "Landroidx/core/widget/NestedScrollView;", "rxbinding-core_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/core/RxNestedScrollView")
final class RxNestedScrollView__NestedScrollViewScrollChangeEventObservableKt {
    public static final Observable<ViewScrollChangeEvent> scrollChangeEvents(NestedScrollView nestedScrollView) {
        Intrinsics.checkParameterIsNotNull((Object)nestedScrollView, (String)"$this$scrollChangeEvents");
        return (Observable)new NestedScrollViewScrollChangeEventObservable(nestedScrollView);
    }
}

