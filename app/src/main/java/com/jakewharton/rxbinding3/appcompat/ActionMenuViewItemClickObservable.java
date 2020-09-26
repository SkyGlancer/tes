/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lcom/jakewharton/rxbinding3/appcompat/ActionMenuViewItemClickObservable;", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "view", "Landroidx/appcompat/widget/ActionMenuView;", "(Landroidx/appcompat/widget/ActionMenuView;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding-appcompat_release"}, k=1, mv={1, 1, 15})
final class ActionMenuViewItemClickObservable
extends Observable<MenuItem> {
    private final ActionMenuView view;

    public ActionMenuViewItemClickObservable(ActionMenuView actionMenuView) {
        Intrinsics.checkParameterIsNotNull((Object)actionMenuView, (String)"view");
        this.view = actionMenuView;
    }

    protected void subscribeActual(Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnMenuItemClickListener((ActionMenuView.OnMenuItemClickListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/appcompat/ActionMenuViewItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroidx/appcompat/widget/ActionMenuView$OnMenuItemClickListener;", "actionMenuView", "Landroidx/appcompat/widget/ActionMenuView;", "observer", "Lio/reactivex/Observer;", "Landroid/view/MenuItem;", "(Landroidx/appcompat/widget/ActionMenuView;Lio/reactivex/Observer;)V", "onDispose", "", "onMenuItemClick", "", "item", "rxbinding-appcompat_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements ActionMenuView.OnMenuItemClickListener {
        private final ActionMenuView actionMenuView;
        private final Observer<? super MenuItem> observer;

        public Listener(ActionMenuView actionMenuView, Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull((Object)actionMenuView, (String)"actionMenuView");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.actionMenuView = actionMenuView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.actionMenuView.setOnMenuItemClickListener(null);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"item");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)menuItem);
            }
            return true;
        }
    }

}

