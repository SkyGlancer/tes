/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lcom/jakewharton/rxbinding3/internal/AlwaysTrue;", "Lkotlin/Function0;", "", "Lkotlin/Function1;", "", "()V", "invoke", "()Ljava/lang/Boolean;", "ignored", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class AlwaysTrue
implements Function0<Boolean>,
Function1<Object, Boolean> {
    public static final AlwaysTrue INSTANCE = new AlwaysTrue();

    private AlwaysTrue() {
    }

    public Boolean invoke() {
        return true;
    }

    public Boolean invoke(Object object) {
        Intrinsics.checkParameterIsNotNull((Object)object, (String)"ignored");
        return true;
    }
}

