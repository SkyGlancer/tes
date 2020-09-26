/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.internal;

import android.os.Looper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0007\u00a8\u0006\u0004"}, d2={"checkMainThread", "", "observer", "Lio/reactivex/Observer;", "rxbinding_release"}, k=2, mv={1, 1, 15})
public final class Preconditions {
    public static final boolean checkMainThread(Observer<?> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (true ^ Intrinsics.areEqual((Object)Looper.myLooper(), (Object)Looper.getMainLooper())) {
            observer.onSubscribe(Disposables.empty());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected to be called on the main thread but was ");
            Thread thread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull((Object)thread, (String)"Thread.currentThread()");
            stringBuilder.append(thread.getName());
            observer.onError((Throwable)new IllegalStateException(stringBuilder.toString()));
            return false;
        }
        return true;
    }
}

