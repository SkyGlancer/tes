/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnDismissListener
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
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.PopupMenu;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lcom/jakewharton/rxbinding3/widget/PopupMenuDismissObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/PopupMenu;", "(Landroid/widget/PopupMenu;)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class PopupMenuDismissObservable
extends Observable<Unit> {
    private final PopupMenu view;

    public PopupMenuDismissObservable(PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull((Object)popupMenu, (String)"view");
        this.view = popupMenu;
    }

    protected void subscribeActual(Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        this.view.setOnDismissListener((PopupMenu.OnDismissListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0014R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lcom/jakewharton/rxbinding3/widget/PopupMenuDismissObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/PopupMenu$OnDismissListener;", "view", "Landroid/widget/PopupMenu;", "observer", "Lio/reactivex/Observer;", "", "(Landroid/widget/PopupMenu;Lio/reactivex/Observer;)V", "onDismiss", "popupMenu", "onDispose", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements PopupMenu.OnDismissListener {
        private final Observer<? super Unit> observer;
        private final PopupMenu view;

        public Listener(PopupMenu popupMenu, Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull((Object)popupMenu, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = popupMenu;
            this.observer = observer;
        }

        public void onDismiss(PopupMenu popupMenu) {
            Intrinsics.checkParameterIsNotNull((Object)popupMenu, (String)"popupMenu");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)Unit.INSTANCE);
            }
        }

        protected void onDispose() {
            this.view.setOnDismissListener(null);
        }
    }

}

