/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnFocusChangeListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewFocusChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "initialValue", "getInitialValue", "()Ljava/lang/Boolean;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class ViewFocusChangeObservable
extends InitialValueObservable<Boolean> {
    private final View view;

    public ViewFocusChangeObservable(View view) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        this.view = view;
    }

    @Override
    protected Boolean getInitialValue() {
        return this.view.hasFocus();
    }

    @Override
    protected void subscribeListener(Observer<? super Boolean> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnFocusChangeListener((View.OnFocusChangeListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewFocusChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/View$OnFocusChangeListener;", "view", "Landroid/view/View;", "observer", "Lio/reactivex/Observer;", "", "(Landroid/view/View;Lio/reactivex/Observer;)V", "onDispose", "", "onFocusChange", "v", "hasFocus", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements View.OnFocusChangeListener {
        private final Observer<? super Boolean> observer;
        private final View view;

        public Listener(View view, Observer<? super Boolean> observer) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = view;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnFocusChangeListener((View.OnFocusChangeListener)null);
        }

        public void onFocusChange(View view, boolean bl) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"v");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)bl);
            }
        }
    }

}

