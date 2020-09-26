/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lcom/jakewharton/rxbinding3/view/MenuItemClickObservable;", "Lio/reactivex/Observable;", "", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class MenuItemClickObservable
extends Observable<Unit> {
    private final Function1<MenuItem, Boolean> handled;
    private final MenuItem menuItem;

    public MenuItemClickObservable(MenuItem menuItem, Function1<? super MenuItem, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        this.menuItem = menuItem;
        this.handled = function1;
    }

    protected void subscribeActual(Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.menuItem, this.handled, observer);
        observer.onSubscribe((Disposable)listener);
        this.menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcom/jakewharton/rxbinding3/view/MenuItemClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/MenuItem$OnMenuItemClickListener;", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "observer", "Lio/reactivex/Observer;", "", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;Lio/reactivex/Observer;)V", "onDispose", "onMenuItemClick", "item", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements MenuItem.OnMenuItemClickListener {
        private final Function1<MenuItem, Boolean> handled;
        private final MenuItem menuItem;
        private final Observer<? super Unit> observer;

        public Listener(MenuItem menuItem, Function1<? super MenuItem, Boolean> function1, Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
            Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.menuItem = menuItem;
            this.handled = function1;
            this.observer = observer;
        }

        protected void onDispose() {
            this.menuItem.setOnMenuItemClickListener(null);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"item");
            if (!this.isDisposed()) {
                try {
                    if (((Boolean)this.handled.invoke((Object)this.menuItem)).booleanValue()) {
                        this.observer.onNext((Object)Unit.INSTANCE);
                        return true;
                    }
                }
                catch (Exception exception) {
                    this.observer.onError((Throwable)exception);
                    this.dispose();
                }
            }
            return false;
        }
    }

}

