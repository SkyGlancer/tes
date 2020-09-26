/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.PopupMenu
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.Unit
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.jakewharton.rxbinding3.appcompat.RxPopupMenu__PopupMenuDismissObservableKt;
import com.jakewharton.rxbinding3.appcompat.RxPopupMenu__PopupMenuItemClickObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/appcompat/RxPopupMenu__PopupMenuDismissObservableKt", "com/jakewharton/rxbinding3/appcompat/RxPopupMenu__PopupMenuItemClickObservableKt"}, k=4, mv={1, 1, 15})
public final class RxPopupMenu {
    public static final Observable<Unit> dismisses(PopupMenu popupMenu) {
        return RxPopupMenu__PopupMenuDismissObservableKt.dismisses(popupMenu);
    }

    public static final Observable<MenuItem> itemClicks(PopupMenu popupMenu) {
        return RxPopupMenu__PopupMenuItemClickObservableKt.itemClicks(popupMenu);
    }
}

