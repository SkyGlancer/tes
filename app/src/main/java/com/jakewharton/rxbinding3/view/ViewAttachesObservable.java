/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewAttachesObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/view/View;", "callOnAttach", "", "(Landroid/view/View;Z)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class ViewAttachesObservable
extends Observable<Unit> {
    private final boolean callOnAttach;
    private final View view;

    public ViewAttachesObservable(View view, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        this.view = view;
        this.callOnAttach = bl;
    }

    protected void subscribeActual(Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, this.callOnAttach, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewAttachesObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "callOnAttach", "", "observer", "Lio/reactivex/Observer;", "", "(Landroid/view/View;ZLio/reactivex/Observer;)V", "onDispose", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements View.OnAttachStateChangeListener {
        private final boolean callOnAttach;
        private final Observer<? super Unit> observer;
        private final View view;

        public Listener(View view, boolean bl, Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = view;
            this.callOnAttach = bl;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }

        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"v");
            if (this.callOnAttach && !this.isDisposed()) {
                this.observer.onNext((Object)Unit.INSTANCE);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"v");
            if (!this.callOnAttach && !this.isDisposed()) {
                this.observer.onNext((Object)Unit.INSTANCE);
            }
        }
    }

}

