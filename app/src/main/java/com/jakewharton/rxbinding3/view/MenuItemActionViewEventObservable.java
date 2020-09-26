/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
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
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.MenuItemActionViewCollapseEvent;
import com.jakewharton.rxbinding3.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding3.view.MenuItemActionViewExpandEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class MenuItemActionViewEventObservable
extends Observable<MenuItemActionViewEvent> {
    private final Function1<MenuItemActionViewEvent, Boolean> handled;
    private final MenuItem menuItem;

    public MenuItemActionViewEventObservable(MenuItem menuItem, Function1<? super MenuItemActionViewEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        this.menuItem = menuItem;
        this.handled = function1;
    }

    protected void subscribeActual(Observer<? super MenuItemActionViewEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.menuItem, this.handled, observer);
        observer.onSubscribe((Disposable)listener);
        this.menuItem.setOnActionExpandListener((MenuItem.OnActionExpandListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/MenuItem$OnActionExpandListener;", "menuItem", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "", "observer", "Lio/reactivex/Observer;", "(Landroid/view/MenuItem;Lkotlin/jvm/functions/Function1;Lio/reactivex/Observer;)V", "onDispose", "", "onEvent", "event", "onMenuItemActionCollapse", "item", "onMenuItemActionExpand", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements MenuItem.OnActionExpandListener {
        private final Function1<MenuItemActionViewEvent, Boolean> handled;
        private final MenuItem menuItem;
        private final Observer<? super MenuItemActionViewEvent> observer;

        public Listener(MenuItem menuItem, Function1<? super MenuItemActionViewEvent, Boolean> function1, Observer<? super MenuItemActionViewEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
            Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.menuItem = menuItem;
            this.handled = function1;
            this.observer = observer;
        }

        private final boolean onEvent(MenuItemActionViewEvent menuItemActionViewEvent) {
            if (!this.isDisposed()) {
                try {
                    if (((Boolean)this.handled.invoke((Object)menuItemActionViewEvent)).booleanValue()) {
                        this.observer.onNext((Object)menuItemActionViewEvent);
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

        protected void onDispose() {
            this.menuItem.setOnActionExpandListener(null);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"item");
            return this.onEvent(new MenuItemActionViewCollapseEvent(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"item");
            return this.onEvent(new MenuItemActionViewExpandEvent(menuItem));
        }
    }

}

