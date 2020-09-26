/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  com.jakewharton.rxbinding3.internal.AlwaysTrue
 *  com.jakewharton.rxbinding3.view.ViewKeyObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.KeyEvent;
import android.view.View;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewKeyObservable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u00a8\u0006\u0007"}, d2={"keys", "Lio/reactivex/Observable;", "Landroid/view/KeyEvent;", "Landroid/view/View;", "handled", "Lkotlin/Function1;", "", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/view/RxView")
final class RxView__ViewKeyObservableKt {
    public static final Observable<KeyEvent> keys(View view) {
        return RxView.keys$default(view, null, 1, null);
    }

    public static final Observable<KeyEvent> keys(View view, Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"$this$keys");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        return (Observable)new ViewKeyObservable(view, function1);
    }

    public static /* synthetic */ Observable keys$default(View view, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = (Function1)AlwaysTrue.INSTANCE;
        }
        return RxView.keys(view, (Function1<? super KeyEvent, Boolean>)function1);
    }
}

