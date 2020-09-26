/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.PopupMenu
 *  com.jakewharton.rxbinding3.appcompat.PopupMenuDismissObservable
 *  io.reactivex.Observable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.PopupMenu;
import com.jakewharton.rxbinding3.appcompat.PopupMenuDismissObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"dismisses", "Lio/reactivex/Observable;", "", "Landroidx/appcompat/widget/PopupMenu;", "rxbinding-appcompat_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/appcompat/RxPopupMenu")
final class RxPopupMenu__PopupMenuDismissObservableKt {
    public static final Observable<Unit> dismisses(PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull((Object)popupMenu, (String)"$this$dismisses");
        return (Observable)new PopupMenuDismissObservable(popupMenu);
    }
}

