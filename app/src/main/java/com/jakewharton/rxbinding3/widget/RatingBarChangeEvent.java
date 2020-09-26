/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.RatingBar
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.RatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lcom/jakewharton/rxbinding3/widget/RatingBarChangeEvent;", "", "view", "Landroid/widget/RatingBar;", "rating", "", "fromUser", "", "(Landroid/widget/RatingBar;FZ)V", "getFromUser", "()Z", "getRating", "()F", "getView", "()Landroid/widget/RatingBar;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class RatingBarChangeEvent {
    private final boolean fromUser;
    private final float rating;
    private final RatingBar view;

    public RatingBarChangeEvent(RatingBar ratingBar, float f, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"view");
        this.view = ratingBar;
        this.rating = f;
        this.fromUser = bl;
    }

    public static /* synthetic */ RatingBarChangeEvent copy$default(RatingBarChangeEvent ratingBarChangeEvent, RatingBar ratingBar, float f, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            ratingBar = ratingBarChangeEvent.view;
        }
        if ((n & 2) != 0) {
            f = ratingBarChangeEvent.rating;
        }
        if ((n & 4) != 0) {
            bl = ratingBarChangeEvent.fromUser;
        }
        return ratingBarChangeEvent.copy(ratingBar, f, bl);
    }

    public final RatingBar component1() {
        return this.view;
    }

    public final float component2() {
        return this.rating;
    }

    public final boolean component3() {
        return this.fromUser;
    }

    public final RatingBarChangeEvent copy(RatingBar ratingBar, float f, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)ratingBar, (String)"view");
        return new RatingBarChangeEvent(ratingBar, f, bl);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof RatingBarChangeEvent) {
                boolean bl;
                RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)ratingBarChangeEvent.view) && Float.compare((float)this.rating, (float)ratingBarChangeEvent.rating) == 0 && (bl = this.fromUser == ratingBarChangeEvent.fromUser)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean getFromUser() {
        return this.fromUser;
    }

    public final float getRating() {
        return this.rating;
    }

    public final RatingBar getView() {
        return this.view;
    }

    public int hashCode() {
        RatingBar ratingBar = this.view;
        int n = ratingBar != null ? ratingBar.hashCode() : 0;
        int n2 = 31 * (n * 31 + Float.floatToIntBits((float)this.rating));
        int n3 = this.fromUser ? 1 : 0;
        if (n3 != 0) {
            n3 = 1;
        }
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RatingBarChangeEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", rating=");
        stringBuilder.append(this.rating);
        stringBuilder.append(", fromUser=");
        stringBuilder.append(this.fromUser);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

