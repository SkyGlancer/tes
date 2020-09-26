/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.ActionMenuView
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import com.jakewharton.rxbinding3.appcompat.RxActionMenuView__ActionMenuViewItemClickObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/appcompat/RxActionMenuView__ActionMenuViewItemClickObservableKt"}, k=4, mv={1, 1, 15})
public final class RxActionMenuView {
    public static final Observable<MenuItem> itemClicks(ActionMenuView actionMenuView) {
        return RxActionMenuView__ActionMenuViewItemClickObservableKt.itemClicks(actionMenuView);
    }
}

