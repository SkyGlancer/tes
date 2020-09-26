/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding3.widget.AbsListViewScrollEvent;
import com.jakewharton.rxbinding3.widget.RxAbsListView__AbsListViewScrollEventObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxAbsListView__AbsListViewScrollEventObservableKt"}, k=4, mv={1, 1, 15})
public final class RxAbsListView {
    public static final Observable<AbsListViewScrollEvent> scrollEvents(AbsListView absListView) {
        return RxAbsListView__AbsListViewScrollEventObservableKt.scrollEvents(absListView);
    }
}

