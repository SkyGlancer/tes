/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.Toolbar
 *  android.widget.Toolbar$OnMenuItemClickListener
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

import android.view.MenuItem;
import android.widget.Toolbar;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lcom/jakewharton/rxbinding3/widget/ToolbarItemClickObservable;", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "view", "Landroid/widget/Toolbar;", "(Landroid/widget/Toolbar;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class ToolbarItemClickObservable
extends Observable<MenuItem> {
    private final Toolbar view;

    public ToolbarItemClickObservable(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull((Object)toolbar, (String)"view");
        this.view = toolbar;
    }

    protected void subscribeActual(Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnMenuItemClickListener((Toolbar.OnMenuItemClickListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/ToolbarItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/Toolbar$OnMenuItemClickListener;", "view", "Landroid/widget/Toolbar;", "observer", "Lio/reactivex/Observer;", "Landroid/view/MenuItem;", "(Landroid/widget/Toolbar;Lio/reactivex/Observer;)V", "onDispose", "", "onMenuItemClick", "", "item", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements Toolbar.OnMenuItemClickListener {
        private final Observer<? super MenuItem> observer;
        private final Toolbar view;

        public Listener(Toolbar toolbar, Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull((Object)toolbar, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = toolbar;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnMenuItemClickListener(null);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"item");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)menuItem);
                return true;
            }
            return false;
        }
    }

}

