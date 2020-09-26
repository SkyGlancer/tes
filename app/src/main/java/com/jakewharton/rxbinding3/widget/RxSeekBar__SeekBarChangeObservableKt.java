/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  com.jakewharton.rxbinding3.widget.SeekBarChangeObservable
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.SeekBarChangeObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0006"}, d2={"changes", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Landroid/widget/SeekBar;", "systemChanges", "userChanges", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/widget/RxSeekBar")
final class RxSeekBar__SeekBarChangeObservableKt {
    public static final InitialValueObservable<Integer> changes(SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"$this$changes");
        return (InitialValueObservable)new SeekBarChangeObservable(seekBar, null);
    }

    public static final InitialValueObservable<Integer> systemChanges(SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"$this$systemChanges");
        return (InitialValueObservable)new SeekBarChangeObservable(seekBar, Boolean.valueOf((boolean)false));
    }

    public static final InitialValueObservable<Integer> userChanges(SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"$this$userChanges");
        return (InitialValueObservable)new SeekBarChangeObservable(seekBar, Boolean.valueOf((boolean)true));
    }
}

