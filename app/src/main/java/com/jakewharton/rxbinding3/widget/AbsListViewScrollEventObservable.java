/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AbsListViewScrollEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "view", "Landroid/widget/AbsListView;", "(Landroid/widget/AbsListView;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class AbsListViewScrollEventObservable
extends Observable<AbsListViewScrollEvent> {
    private final AbsListView view;

    public AbsListViewScrollEventObservable(AbsListView absListView) {
        Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"view");
        this.view = absListView;
    }

    protected void subscribeActual(Observer<? super AbsListViewScrollEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnScrollListener((AbsListView.OnScrollListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J(\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AbsListView$OnScrollListener;", "view", "Landroid/widget/AbsListView;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "(Landroid/widget/AbsListView;Lio/reactivex/Observer;)V", "currentScrollState", "", "onDispose", "", "onScroll", "absListView", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements AbsListView.OnScrollListener {
        private int currentScrollState;
        private final Observer<? super AbsListViewScrollEvent> observer;
        private final AbsListView view;

        public Listener(AbsListView absListView, Observer<? super AbsListViewScrollEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = absListView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnScrollListener(null);
        }

        public void onScroll(AbsListView absListView, int n, int n2, int n3) {
            Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"absListView");
            if (!this.isDisposed()) {
                AbsListViewScrollEvent absListViewScrollEvent = new AbsListViewScrollEvent(this.view, this.currentScrollState, n, n2, n3);
                this.observer.onNext((Object)absListViewScrollEvent);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int n) {
            Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"absListView");
            this.currentScrollState = n;
            if (!this.isDisposed()) {
                AbsListView absListView2 = this.view;
                AbsListViewScrollEvent absListViewScrollEvent = new AbsListViewScrollEvent(absListView2, n, absListView2.getFirstVisiblePosition(), this.view.getChildCount(), this.view.getCount());
                this.observer.onNext((Object)absListViewScrollEvent);
            }
        }
    }

}

