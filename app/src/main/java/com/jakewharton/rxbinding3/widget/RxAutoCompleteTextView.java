/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AutoCompleteTextView
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.AutoCompleteTextView;
import com.jakewharton.rxbinding3.widget.AdapterViewItemClickEvent;
import com.jakewharton.rxbinding3.widget.RxAutoCompleteTextView__AutoCompleteTextViewItemClickEventObservableKt;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxAutoCompleteTextView__AutoCompleteTextViewItemClickEventObservableKt"}, k=4, mv={1, 1, 15})
public final class RxAutoCompleteTextView {
    public static final Observable<AdapterViewItemClickEvent> itemClickEvents(AutoCompleteTextView autoCompleteTextView) {
        return RxAutoCompleteTextView__AutoCompleteTextViewItemClickEventObservableKt.itemClickEvents(autoCompleteTextView);
    }
}

