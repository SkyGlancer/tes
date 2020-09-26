/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.core.widget.NestedScrollView
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.core;

import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding3.core.RxNestedScrollView__NestedScrollViewScrollChangeEventObservableKt;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/core/RxNestedScrollView__NestedScrollViewScrollChangeEventObservableKt"}, k=4, mv={1, 1, 15})
public final class RxNestedScrollView {
    public static final Observable<ViewScrollChangeEvent> scrollChangeEvents(NestedScrollView nestedScrollView) {
        return RxNestedScrollView__NestedScrollViewScrollChangeEventObservableKt.scrollChangeEvents(nestedScrollView);
    }
}

