/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RatingBar
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  com.jakewharton.rxbinding3.widget.RatingBarRatingChangeObservable
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RatingBarRatingChangeObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"ratingChanges", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Landroid/widget/RatingBar;", "rxbinding_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/widget/RxRatingBar")
final class RxRatingBar__RatingBarRatingChangeObservableKt {
    public static final InitialValueObservable<Float> ratingChanges(RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"$this$ratingChanges");
        return (InitialValueObservable)new RatingBarRatingChangeObservable(ratingBar);
    }
}

