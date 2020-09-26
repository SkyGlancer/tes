/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.PopupMenu
 *  com.jakewharton.rxbinding3.appcompat.PopupMenuItemClickObservable
 *  io.reactivex.Observable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.jakewharton.rxbinding3.appcompat.PopupMenuItemClickObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"itemClicks", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "Landroidx/appcompat/widget/PopupMenu;", "rxbinding-appcompat_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/appcompat/RxPopupMenu")
final class RxPopupMenu__PopupMenuItemClickObservableKt {
    public static final Observable<MenuItem> itemClicks(PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull((Object)popupMenu, (String)"$this$itemClicks");
        return (Observable)new PopupMenuItemClickObservable(popupMenu);
    }
}

