/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000fH\u0014R\u0014\u0010\b\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "view", "Landroid/widget/SeekBar;", "shouldBeFromUser", "", "(Landroid/widget/SeekBar;Ljava/lang/Boolean;)V", "initialValue", "getInitialValue", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class SeekBarChangeObservable
extends InitialValueObservable<Integer> {
    private final Boolean shouldBeFromUser;
    private final SeekBar view;

    public SeekBarChangeObservable(SeekBar seekBar, Boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"view");
        this.view = seekBar;
        this.shouldBeFromUser = bl;
    }

    @Override
    protected Integer getInitialValue() {
        return this.view.getProgress();
    }

    @Override
    protected void subscribeListener(Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, this.shouldBeFromUser, observer);
        this.view.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lcom/jakewharton/rxbinding3/widget/SeekBarChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "view", "Landroid/widget/SeekBar;", "shouldBeFromUser", "", "observer", "Lio/reactivex/Observer;", "", "(Landroid/widget/SeekBar;Ljava/lang/Boolean;Lio/reactivex/Observer;)V", "Ljava/lang/Boolean;", "onDispose", "", "onProgressChanged", "seekBar", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements SeekBar.OnSeekBarChangeListener {
        private final Observer<? super Integer> observer;
        private final Boolean shouldBeFromUser;
        private final SeekBar view;

        public Listener(SeekBar seekBar, Boolean bl, Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = seekBar;
            this.shouldBeFromUser = bl;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnSeekBarChangeListener(null);
        }

        public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
            Boolean bl2;
            Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"seekBar");
            if (!this.isDisposed() && ((bl2 = this.shouldBeFromUser) == null || Intrinsics.areEqual((Object)bl2, (Object)bl))) {
                this.observer.onNext((Object)n);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"seekBar");
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"seekBar");
        }
    }

}

