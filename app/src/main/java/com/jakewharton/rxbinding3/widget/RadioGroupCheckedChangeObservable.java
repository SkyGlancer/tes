/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/RadioGroupCheckedChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "view", "Landroid/widget/RadioGroup;", "(Landroid/widget/RadioGroup;)V", "initialValue", "getInitialValue", "()Ljava/lang/Integer;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class RadioGroupCheckedChangeObservable
extends InitialValueObservable<Integer> {
    private final RadioGroup view;

    public RadioGroupCheckedChangeObservable(RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull((Object)radioGroup, (String)"view");
        this.view = radioGroup;
    }

    @Override
    protected Integer getInitialValue() {
        return this.view.getCheckedRadioButtonId();
    }

    @Override
    protected void subscribeListener(Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        this.view.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcom/jakewharton/rxbinding3/widget/RadioGroupCheckedChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "view", "Landroid/widget/RadioGroup;", "observer", "Lio/reactivex/Observer;", "", "(Landroid/widget/RadioGroup;Lio/reactivex/Observer;)V", "lastChecked", "onCheckedChanged", "", "radioGroup", "checkedId", "onDispose", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements RadioGroup.OnCheckedChangeListener {
        private int lastChecked;
        private final Observer<? super Integer> observer;
        private final RadioGroup view;

        public Listener(RadioGroup radioGroup, Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull((Object)radioGroup, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = radioGroup;
            this.observer = observer;
            this.lastChecked = -1;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int n) {
            Intrinsics.checkParameterIsNotNull((Object)radioGroup, (String)"radioGroup");
            if (!this.isDisposed() && n != this.lastChecked) {
                this.lastChecked = n;
                this.observer.onNext((Object)n);
            }
        }

        protected void onDispose() {
            this.view.setOnCheckedChangeListener(null);
        }
    }

}

