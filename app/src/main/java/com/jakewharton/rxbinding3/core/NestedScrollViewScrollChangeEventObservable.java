/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.widget.NestedScrollView
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.core;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lcom/jakewharton/rxbinding3/core/NestedScrollViewScrollChangeEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/ViewScrollChangeEvent;", "view", "Landroidx/core/widget/NestedScrollView;", "(Landroidx/core/widget/NestedScrollView;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding-core_release"}, k=1, mv={1, 1, 15})
final class NestedScrollViewScrollChangeEventObservable
extends Observable<ViewScrollChangeEvent> {
    private final NestedScrollView view;

    public NestedScrollViewScrollChangeEventObservable(NestedScrollView nestedScrollView) {
        Intrinsics.checkParameterIsNotNull((Object)nestedScrollView, (String)"view");
        this.view = nestedScrollView;
    }

    protected void subscribeActual(Observer<? super ViewScrollChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lcom/jakewharton/rxbinding3/core/NestedScrollViewScrollChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "view", "Landroidx/core/widget/NestedScrollView;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/view/ViewScrollChangeEvent;", "(Landroidx/core/widget/NestedScrollView;Lio/reactivex/Observer;)V", "onDispose", "", "onScrollChange", "v", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "rxbinding-core_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements NestedScrollView.OnScrollChangeListener {
        private final Observer<? super ViewScrollChangeEvent> observer;
        private final NestedScrollView view;

        public Listener(NestedScrollView nestedScrollView, Observer<? super ViewScrollChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)nestedScrollView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = nestedScrollView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)null);
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int n, int n2, int n3, int n4) {
            Intrinsics.checkParameterIsNotNull((Object)nestedScrollView, (String)"v");
            if (!this.isDisposed()) {
                Observer<? super ViewScrollChangeEvent> observer = this.observer;
                ViewScrollChangeEvent viewScrollChangeEvent = new ViewScrollChangeEvent((View)this.view, n, n2, n3, n4);
                observer.onNext((Object)viewScrollChangeEvent);
            }
        }
    }

}

