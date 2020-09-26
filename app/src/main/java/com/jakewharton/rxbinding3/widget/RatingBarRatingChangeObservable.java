/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RatingBar
 *  android.widget.RatingBar$OnRatingBarChangeListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/RatingBarRatingChangeObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "view", "Landroid/widget/RatingBar;", "(Landroid/widget/RatingBar;)V", "initialValue", "getInitialValue", "()Ljava/lang/Float;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class RatingBarRatingChangeObservable
extends InitialValueObservable<Float> {
    private final RatingBar view;

    public RatingBarRatingChangeObservable(RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"view");
        this.view = ratingBar;
    }

    @Override
    protected Float getInitialValue() {
        return Float.valueOf((float)this.view.getRating());
    }

    @Override
    protected void subscribeListener(Observer<? super Float> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        this.view.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J \u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lcom/jakewharton/rxbinding3/widget/RatingBarRatingChangeObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/RatingBar$OnRatingBarChangeListener;", "view", "Landroid/widget/RatingBar;", "observer", "Lio/reactivex/Observer;", "", "(Landroid/widget/RatingBar;Lio/reactivex/Observer;)V", "onDispose", "", "onRatingChanged", "ratingBar", "rating", "fromUser", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements RatingBar.OnRatingBarChangeListener {
        private final Observer<? super Float> observer;
        private final RatingBar view;

        public Listener(RatingBar ratingBar, Observer<? super Float> observer) {
            Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = ratingBar;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnRatingBarChangeListener((RatingBar.OnRatingBarChangeListener)null);
        }

        public void onRatingChanged(RatingBar ratingBar, float f, boolean bl) {
            Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"ratingBar");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)Float.valueOf((float)f));
            }
        }
    }

}

