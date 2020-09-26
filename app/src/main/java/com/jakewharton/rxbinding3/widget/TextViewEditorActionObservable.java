/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/TextView;", "handled", "Lkotlin/Function1;", "", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class TextViewEditorActionObservable
extends Observable<Integer> {
    private final Function1<Integer, Boolean> handled;
    private final TextView view;

    public TextViewEditorActionObservable(TextView textView, Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
        this.view = textView;
        this.handled = function1;
    }

    protected void subscribeActual(Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer, this.handled);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnEditorActionListener((TextView.OnEditorActionListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/TextView$OnEditorActionListener;", "view", "Landroid/widget/TextView;", "observer", "Lio/reactivex/Observer;", "", "handled", "Lkotlin/Function1;", "", "(Landroid/widget/TextView;Lio/reactivex/Observer;Lkotlin/jvm/functions/Function1;)V", "onDispose", "", "onEditorAction", "textView", "actionId", "keyEvent", "Landroid/view/KeyEvent;", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements TextView.OnEditorActionListener {
        private final Function1<Integer, Boolean> handled;
        private final Observer<? super Integer> observer;
        private final TextView view;

        public Listener(TextView textView, Observer<? super Integer> observer, Function1<? super Integer, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            Intrinsics.checkParameterIsNotNull(function1, (String)"handled");
            this.view = textView;
            this.observer = observer;
            this.handled = function1;
        }

        protected void onDispose() {
            this.view.setOnEditorActionListener(null);
        }

        public boolean onEditorAction(TextView textView, int n, KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull((Object)textView, (String)"textView");
            try {
                if (!this.isDisposed() && ((Boolean)this.handled.invoke((Object)n)).booleanValue()) {
                    this.observer.onNext((Object)n);
                    return true;
                }
            }
            catch (Exception exception) {
                this.observer.onError((Throwable)exception);
                this.dispose();
            }
            return false;
        }
    }

}

