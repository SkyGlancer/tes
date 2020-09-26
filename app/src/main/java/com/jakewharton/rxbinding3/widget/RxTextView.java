/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.TextView
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  io.reactivex.Observable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.TextView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewAfterTextChangeEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewBeforeTextChangeEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewEditorActionEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewEditorActionObservableKt;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewTextChangeEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxTextView__TextViewTextChangesObservableKt;
import com.jakewharton.rxbinding3.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxbinding3.widget.TextViewBeforeTextChangeEvent;
import com.jakewharton.rxbinding3.widget.TextViewEditorActionEvent;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxTextView__TextViewAfterTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewBeforeTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewEditorActionEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewEditorActionObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewTextChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxTextView__TextViewTextChangesObservableKt"}, k=4, mv={1, 1, 15})
public final class RxTextView {
    public static final InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(TextView textView) {
        return RxTextView__TextViewAfterTextChangeEventObservableKt.afterTextChangeEvents(textView);
    }

    public static final InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(TextView textView) {
        return RxTextView__TextViewBeforeTextChangeEventObservableKt.beforeTextChangeEvents(textView);
    }

    public static final Observable<TextViewEditorActionEvent> editorActionEvents(TextView textView) {
        return RxTextView.editorActionEvents$default(textView, null, 1, null);
    }

    public static final Observable<TextViewEditorActionEvent> editorActionEvents(TextView textView, Function1<? super TextViewEditorActionEvent, Boolean> function1) {
        return RxTextView__TextViewEditorActionEventObservableKt.editorActionEvents(textView, function1);
    }

    public static /* synthetic */ Observable editorActionEvents$default(TextView textView, Function1 function1, int n, Object object) {
        return RxTextView__TextViewEditorActionEventObservableKt.editorActionEvents$default(textView, function1, n, object);
    }

    public static final Observable<Integer> editorActions(TextView textView) {
        return RxTextView.editorActions$default(textView, null, 1, null);
    }

    public static final Observable<Integer> editorActions(TextView textView, Function1<? super Integer, Boolean> function1) {
        return RxTextView__TextViewEditorActionObservableKt.editorActions(textView, function1);
    }

    public static /* synthetic */ Observable editorActions$default(TextView textView, Function1 function1, int n, Object object) {
        return RxTextView__TextViewEditorActionObservableKt.editorActions$default(textView, function1, n, object);
    }

    public static final InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(TextView textView) {
        return RxTextView__TextViewTextChangeEventObservableKt.textChangeEvents(textView);
    }

    public static final InitialValueObservable<CharSequence> textChanges(TextView textView) {
        return RxTextView__TextViewTextChangesObservableKt.textChanges(textView);
    }
}

