/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  android.widget.Adapter
 *  com.jakewharton.rxbinding3.widget.AdapterDataChangeObservable$ObserverDisposable$dataSetObserver
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AdapterDataChangeObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0014R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00028\u00008TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterDataChangeObservable;", "T", "Landroid/widget/Adapter;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "adapter", "(Landroid/widget/Adapter;)V", "Landroid/widget/Adapter;", "initialValue", "getInitialValue", "()Landroid/widget/Adapter;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "ObserverDisposable", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class AdapterDataChangeObservable<T extends Adapter>
extends InitialValueObservable<T> {
    private final T adapter;

    public AdapterDataChangeObservable(T t) {
        Intrinsics.checkParameterIsNotNull(t, (String)"adapter");
        this.adapter = t;
    }

    @Override
    protected T getInitialValue() {
        return this.adapter;
    }

    @Override
    protected void subscribeListener(Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        ObserverDisposable<? super T> observerDisposable = new ObserverDisposable<T>((T)this.getInitialValue(), observer);
        this.getInitialValue().registerDataSetObserver(observerDisposable.dataSetObserver);
        observer.onSubscribe((Disposable)observerDisposable);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0014R\u0010\u0010\u0004\u001a\u00028\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterDataChangeObservable$ObserverDisposable;", "T", "Landroid/widget/Adapter;", "Lio/reactivex/android/MainThreadDisposable;", "adapter", "observer", "Lio/reactivex/Observer;", "(Landroid/widget/Adapter;Lio/reactivex/Observer;)V", "Landroid/widget/Adapter;", "dataSetObserver", "Landroid/database/DataSetObserver;", "onDispose", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class ObserverDisposable<T extends Adapter>
    extends MainThreadDisposable {
        private final T adapter;
        public final DataSetObserver dataSetObserver;

        public ObserverDisposable(T t, Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(t, (String)"adapter");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.adapter = t;
            this.dataSetObserver = new DataSetObserver(this, observer){
                final /* synthetic */ Observer $observer;
                final /* synthetic */ ObserverDisposable this$0;
                {
                    this.this$0 = observerDisposable;
                    this.$observer = observer;
                }

                public void onChanged() {
                    if (!this.this$0.isDisposed()) {
                        this.$observer.onNext((Object)ObserverDisposable.access$getAdapter$p(this.this$0));
                    }
                }
            };
        }

        public static final /* synthetic */ Adapter access$getAdapter$p(ObserverDisposable observerDisposable) {
            return observerDisposable.adapter;
        }

        protected void onDispose() {
            this.adapter.unregisterDataSetObserver(this.dataSetObserver);
        }
    }

}

