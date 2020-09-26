/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemLongClickListener
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
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickObservable;", "Lio/reactivex/Observable;", "", "view", "Landroid/widget/AdapterView;", "handled", "Lkotlin/Function0;", "", "(Landroid/widget/AdapterView;Lkotlin/jvm/functions/Function0;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class AdapterViewItemLongClickObservable
extends Observable<Integer> {
    private final Function0<Boolean> handled;
    private final AdapterView<?> view;

    public AdapterViewItemLongClickObservable(AdapterView<?> adapterView, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        Intrinsics.checkParameterIsNotNull(function0, (String)"handled");
        this.view = adapterView;
        this.handled = function0;
    }

    protected void subscribeActual(Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer, this.handled);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnItemLongClickListener((AdapterView.OnItemLongClickListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J.\u0010\u000e\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/AdapterView$OnItemLongClickListener;", "view", "Landroid/widget/AdapterView;", "observer", "Lio/reactivex/Observer;", "", "handled", "Lkotlin/Function0;", "", "(Landroid/widget/AdapterView;Lio/reactivex/Observer;Lkotlin/jvm/functions/Function0;)V", "onDispose", "", "onItemLongClick", "parent", "Landroid/view/View;", "position", "id", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements AdapterView.OnItemLongClickListener {
        private final Function0<Boolean> handled;
        private final Observer<? super Integer> observer;
        private final AdapterView<?> view;

        public Listener(AdapterView<?> adapterView, Observer<? super Integer> observer, Function0<Boolean> function0) {
            Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            Intrinsics.checkParameterIsNotNull(function0, (String)"handled");
            this.view = adapterView;
            this.observer = observer;
            this.handled = function0;
        }

        protected void onDispose() {
            this.view.setOnItemLongClickListener((AdapterView.OnItemLongClickListener)null);
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int n, long l) {
            Intrinsics.checkParameterIsNotNull(adapterView, (String)"parent");
            if (!this.isDisposed()) {
                try {
                    if (((Boolean)this.handled.invoke()).booleanValue()) {
                        this.observer.onNext((Object)n);
                        return true;
                    }
                }
                catch (Exception exception) {
                    this.observer.onError((Throwable)exception);
                    this.dispose();
                }
            }
            return false;
        }
    }

}

