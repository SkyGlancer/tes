/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AdapterViewItemSelectionEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewNothingSelectionEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "view", "Landroid/widget/AdapterView;", "(Landroid/widget/AdapterView;)V", "initialValue", "getInitialValue", "()Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class AdapterViewSelectionObservable
extends InitialValueObservable<AdapterViewSelectionEvent> {
    private final AdapterView<?> view;

    public AdapterViewSelectionObservable(AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        this.view = adapterView;
    }

    @Override
    protected AdapterViewSelectionEvent getInitialValue() {
        int n = this.view.getSelectedItemPosition();
        if (n == -1) {
            return new AdapterViewNothingSelectionEvent(this.view);
        }
        View view = this.view.getSelectedView();
        long l = this.view.getSelectedItemId();
        AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = new AdapterViewItemSelectionEvent(this.view, view, n, l);
        return adapterViewItemSelectionEvent;
    }

    @Override
    protected void subscribeListener(Observer<? super AdapterViewSelectionEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        this.view.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J.\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "view", "Landroid/widget/AdapterView;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "(Landroid/widget/AdapterView;Lio/reactivex/Observer;)V", "onDispose", "", "onItemSelected", "parent", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements AdapterView.OnItemSelectedListener {
        private final Observer<? super AdapterViewSelectionEvent> observer;
        private final AdapterView<?> view;

        public Listener(AdapterView<?> adapterView, Observer<? super AdapterViewSelectionEvent> observer) {
            Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = adapterView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)null);
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int n, long l) {
            Intrinsics.checkParameterIsNotNull(adapterView, (String)"parent");
            if (!this.isDisposed()) {
                Observer<? super AdapterViewSelectionEvent> observer = this.observer;
                AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = new AdapterViewItemSelectionEvent(adapterView, view, n, l);
                observer.onNext((Object)adapterViewItemSelectionEvent);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            Intrinsics.checkParameterIsNotNull(adapterView, (String)"parent");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)new AdapterViewNothingSelectionEvent(adapterView));
            }
        }
    }

}

