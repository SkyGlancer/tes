/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.jakewharton.rxbinding3.view.RxView__ViewVisibilityConsumerKt$visibility
 *  com.jakewharton.rxbinding3.view.RxView__ViewVisibilityConsumerKt$visibility$3
 *  dalvik.annotation.SourceDebugExtension
 *  io.reactivex.functions.Consumer
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.RxView__ViewVisibilityConsumerKt;
import dalvik.annotation.SourceDebugExtension;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nViewVisibilityConsumer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewVisibilityConsumer.kt\ncom/jakewharton/rxbinding3/view/RxView__ViewVisibilityConsumerKt\n*L\n1#1,30:1\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"visibility", "Lio/reactivex/functions/Consumer;", "", "Landroid/view/View;", "visibilityWhenFalse", "", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/view/RxView")
final class RxView__ViewVisibilityConsumerKt {
    public static final Consumer<? super Boolean> visibility(View view) {
        return RxView.visibility$default(view, 0, 1, null);
    }

    public static final Consumer<? super Boolean> visibility(View view, int n) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"$this$visibility");
        boolean bl = true;
        boolean bl2 = n != 0;
        if (bl2) {
            if (n != 4 && n != 8) {
                bl = false;
            }
            if (bl) {
                return (Consumer)new visibility.3(view, n);
            }
            throw (Throwable)new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.".toString());
        }
        throw (Throwable)new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.".toString());
    }

    public static /* synthetic */ Consumer visibility$default(View view, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 8;
        }
        return RxView.visibility(view, n);
    }
}

