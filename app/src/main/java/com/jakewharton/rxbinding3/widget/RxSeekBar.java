/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  java.lang.Integer
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxSeekBar__SeekBarChangeEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxSeekBar__SeekBarChangeObservableKt;
import com.jakewharton.rxbinding3.widget.SeekBarChangeEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxSeekBar__SeekBarChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxSeekBar__SeekBarChangeObservableKt"}, k=4, mv={1, 1, 15})
public final class RxSeekBar {
    public static final InitialValueObservable<SeekBarChangeEvent> changeEvents(SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeEventObservableKt.changeEvents(seekBar);
    }

    public static final InitialValueObservable<Integer> changes(SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.changes(seekBar);
    }

    public static final InitialValueObservable<Integer> systemChanges(SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.systemChanges(seekBar);
    }

    public static final InitialValueObservable<Integer> userChanges(SeekBar seekBar) {
        return RxSeekBar__SeekBarChangeObservableKt.userChanges(seekBar);
    }
}

