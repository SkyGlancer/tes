/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  io.reactivex.functions.Consumer
 *  java.lang.Integer
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxRadioGroup__RadioGroupCheckedChangeObservableKt;
import com.jakewharton.rxbinding3.widget.RxRadioGroup__RadioGroupToggleCheckedConsumerKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxRadioGroup__RadioGroupCheckedChangeObservableKt", "com/jakewharton/rxbinding3/widget/RxRadioGroup__RadioGroupToggleCheckedConsumerKt"}, k=4, mv={1, 1, 15})
public final class RxRadioGroup {
    public static final Consumer<? super Integer> checked(RadioGroup radioGroup) {
        return RxRadioGroup__RadioGroupToggleCheckedConsumerKt.checked(radioGroup);
    }

    public static final InitialValueObservable<Integer> checkedChanges(RadioGroup radioGroup) {
        return RxRadioGroup__RadioGroupCheckedChangeObservableKt.checkedChanges(radioGroup);
    }
}

