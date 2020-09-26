/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  com.jakewharton.rxbinding3.internal.AlwaysTrue
 *  com.jakewharton.rxbinding3.view.MenuItemClickObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import com.jakewharton.rxbinding3.view.MenuItemClickObservable;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u00a8\u0006\u0007"}, d2={"clicks", "Lio/reactivex/Observable;", "", "Landroid/view/MenuItem;", "handled", "Lkotlin/Function1;", "", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/view/RxMenuItem")
final class RxMenuItem__MenuItemClickObservableKt {
    public static final Observable<Unit> clicks(MenuItem menuItem) {
        return RxMenuItem.clicks$default(menuItem, null, 1, null);
    }

    public static final Observable<Unit> clicks(MenuItem menuItem, Function1<? super MenuItem, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"$this$clicks");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        return (Observable)new MenuItemClickObservable(menuItem, function1);
    }

    public static /* synthetic */ Observable clicks$default(MenuItem menuItem, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = (Function1)AlwaysTrue.INSTANCE;
        }
        return RxMenuItem.clicks(menuItem, (Function1<? super MenuItem, Boolean>)function1);
    }
}

