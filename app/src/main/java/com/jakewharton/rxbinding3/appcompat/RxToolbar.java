/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.Toolbar
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.Unit
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding3.appcompat.RxToolbar__ToolbarItemClickObservableKt;
import com.jakewharton.rxbinding3.appcompat.RxToolbar__ToolbarNavigationClickObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/appcompat/RxToolbar__ToolbarItemClickObservableKt", "com/jakewharton/rxbinding3/appcompat/RxToolbar__ToolbarNavigationClickObservableKt"}, k=4, mv={1, 1, 15})
public final class RxToolbar {
    public static final Observable<MenuItem> itemClicks(Toolbar toolbar) {
        return RxToolbar__ToolbarItemClickObservableKt.itemClicks(toolbar);
    }

    public static final Observable<Unit> navigationClicks(Toolbar toolbar) {
        return RxToolbar__ToolbarNavigationClickObservableKt.navigationClicks(toolbar);
    }
}

