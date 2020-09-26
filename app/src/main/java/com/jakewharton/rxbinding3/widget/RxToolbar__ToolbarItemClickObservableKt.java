/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.Toolbar
 *  com.jakewharton.rxbinding3.widget.ToolbarItemClickObservable
 *  io.reactivex.Observable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import com.jakewharton.rxbinding3.widget.ToolbarItemClickObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"itemClicks", "Lio/reactivex/Observable;", "Landroid/view/MenuItem;", "Landroid/widget/Toolbar;", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/widget/RxToolbar")
final class RxToolbar__ToolbarItemClickObservableKt {
    public static final Observable<MenuItem> itemClicks(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull((Object)toolbar, (String)"$this$itemClicks");
        return (Observable)new ToolbarItemClickObservable(toolbar);
    }
}

