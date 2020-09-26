/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RatingBar
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  java.lang.Float
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RatingBarChangeEvent;
import com.jakewharton.rxbinding3.widget.RxRatingBar__RatingBarRatingChangeEventObservableKt;
import com.jakewharton.rxbinding3.widget.RxRatingBar__RatingBarRatingChangeObservableKt;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxRatingBar__RatingBarRatingChangeEventObservableKt", "com/jakewharton/rxbinding3/widget/RxRatingBar__RatingBarRatingChangeObservableKt"}, k=4, mv={1, 1, 15})
public final class RxRatingBar {
    public static final InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(RatingBar ratingBar) {
        return RxRatingBar__RatingBarRatingChangeEventObservableKt.ratingChangeEvents(ratingBar);
    }

    public static final InitialValueObservable<Float> ratingChanges(RatingBar ratingBar) {
        return RxRatingBar__RatingBarRatingChangeObservableKt.ratingChanges(ratingBar);
    }
}

