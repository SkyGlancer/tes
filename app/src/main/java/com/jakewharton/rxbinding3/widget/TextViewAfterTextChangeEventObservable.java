/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.widget.TextView
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.TextViewAfterTextChangeEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEventObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "view", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "initialValue", "getInitialValue", "()Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class TextViewAfterTextChangeEventObservable
extends InitialValueObservable<TextViewAfterTextChangeEvent> {
    private final TextView view;

    public TextViewAfterTextChangeEventObservable(TextView textView) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        this.view = textView;
    }

    @Override
    protected TextViewAfterTextChangeEvent getInitialValue() {
        TextView textView = this.view;
        return new TextViewAfterTextChangeEvent(textView, textView.getEditableText());
    }

    @Override
    protected void subscribeListener(Observer<? super TextViewAfterTextChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.addTextChangedListener((TextWatcher)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0014J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/text/TextWatcher;", "view", "Landroid/widget/TextView;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "(Landroid/widget/TextView;Lio/reactivex/Observer;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "charSequence", "", "start", "", "count", "after", "onDispose", "onTextChanged", "before", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements TextWatcher {
        private final Observer<? super TextViewAfterTextChangeEvent> observer;
        private final TextView view;

        public Listener(TextView textView, Observer<? super TextViewAfterTextChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = textView;
            this.observer = observer;
        }

        public void afterTextChanged(Editable editable) {
            Intrinsics.checkParameterIsNotNull((Object)editable, (String)"s");
            this.observer.onNext((Object)new TextViewAfterTextChangeEvent(this.view, editable));
        }

        public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"charSequence");
        }

        protected void onDispose() {
            this.view.removeTextChangedListener((TextWatcher)this);
        }

        public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"charSequence");
        }
    }

}

