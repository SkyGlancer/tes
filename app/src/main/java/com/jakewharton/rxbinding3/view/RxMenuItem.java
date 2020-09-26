/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding3.view.RxMenuItem__MenuItemActionViewEventObservableKt;
import com.jakewharton.rxbinding3.view.RxMenuItem__MenuItemClickObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/view/RxMenuItem__MenuItemActionViewEventObservableKt", "com/jakewharton/rxbinding3/view/RxMenuItem__MenuItemClickObservableKt"}, k=4, mv={1, 1, 15})
public final class RxMenuItem {
    public static final Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem) {
        return RxMenuItem.actionViewEvents$default(menuItem, null, 1, null);
    }

    public static final Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem, Function1<? super MenuItemActionViewEvent, Boolean> function1) {
        return RxMenuItem__MenuItemActionViewEventObservableKt.actionViewEvents(menuItem, function1);
    }

    public static /* synthetic */ Observable actionViewEvents$default(MenuItem menuItem, Function1 function1, int n, Object object) {
        return RxMenuItem__MenuItemActionViewEventObservableKt.actionViewEvents$default(menuItem, function1, n, object);
    }

    public static final Observable<Unit> clicks(MenuItem menuItem) {
        return RxMenuItem.clicks$default(menuItem, null, 1, null);
    }

    public static final Observable<Unit> clicks(MenuItem menuItem, Function1<? super MenuItem, Boolean> function1) {
        return RxMenuItem__MenuItemClickObservableKt.clicks(menuItem, function1);
    }

    public static /* synthetic */ Observable clicks$default(MenuItem menuItem, Function1 function1, int n, Object object) {
        return RxMenuItem__MenuItemClickObservableKt.clicks$default(menuItem, function1, n, object);
    }
}

