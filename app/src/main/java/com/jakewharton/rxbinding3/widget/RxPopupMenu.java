/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.Unit
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.jakewharton.rxbinding3.widget.RxPopupMenu__PopupMenuDismissObservableKt;
import com.jakewharton.rxbinding3.widget.RxPopupMenu__PopupMenuItemClickObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxPopupMenu__PopupMenuDismissObservableKt", "com/jakewharton/rxbinding3/widget/RxPopupMenu__PopupMenuItemClickObservableKt"}, k=4, mv={1, 1, 15})
public final class RxPopupMenu {
    public static final Observable<Unit> dismisses(PopupMenu popupMenu) {
        return RxPopupMenu__PopupMenuDismissObservableKt.dismisses(popupMenu);
    }

    public static final Observable<MenuItem> itemClicks(PopupMenu popupMenu) {
        return RxPopupMenu__PopupMenuItemClickObservableKt.itemClicks(popupMenu);
    }
}

