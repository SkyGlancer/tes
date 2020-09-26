/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.jakewharton.rxbinding3.internal.AlwaysTrue
 *  com.jakewharton.rxbinding3.view.ViewLongClickObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewLongClickObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u00a8\u0006\u0007"}, d2={"longClicks", "Lio/reactivex/Observable;", "", "Landroid/view/View;", "handled", "Lkotlin/Function0;", "", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/view/RxView")
final class RxView__ViewLongClickObservableKt {
    public static final Observable<Unit> longClicks(View view) {
        return RxView.longClicks$default(view, null, 1, null);
    }

    public static final Observable<Unit> longClicks(View view, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"$this$longClicks");
        Intrinsics.checkParameterIsNotNull(function0, (String)"handled");
        return (Observable)new ViewLongClickObservable(view, function0);
    }

    public static /* synthetic */ Observable longClicks$default(View view, Function0 function0, int n, Object object) {
        if ((n & 1) != 0) {
            function0 = (Function0)AlwaysTrue.INSTANCE;
        }
        return RxView.longClicks(view, (Function0<Boolean>)function0);
    }
}

