/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding3.widget.SeekBarChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lcom/jakewharton/rxbinding3/widget/SeekBarProgressChangeEvent;", "Lcom/jakewharton/rxbinding3/widget/SeekBarChangeEvent;", "view", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "(Landroid/widget/SeekBar;IZ)V", "getFromUser", "()Z", "getProgress", "()I", "getView", "()Landroid/widget/SeekBar;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class SeekBarProgressChangeEvent
extends SeekBarChangeEvent {
    private final boolean fromUser;
    private final int progress;
    private final SeekBar view;

    public SeekBarProgressChangeEvent(SeekBar seekBar, int n, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"view");
        super(null);
        this.view = seekBar;
        this.progress = n;
        this.fromUser = bl;
    }

    public static /* synthetic */ SeekBarProgressChangeEvent copy$default(SeekBarProgressChangeEvent seekBarProgressChangeEvent, SeekBar seekBar, int n, boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            seekBar = seekBarProgressChangeEvent.getView();
        }
        if ((n2 & 2) != 0) {
            n = seekBarProgressChangeEvent.progress;
        }
        if ((n2 & 4) != 0) {
            bl = seekBarProgressChangeEvent.fromUser;
        }
        return seekBarProgressChangeEvent.copy(seekBar, n, bl);
    }

    public final SeekBar component1() {
        return this.getView();
    }

    public final int component2() {
        return this.progress;
    }

    public final boolean component3() {
        return this.fromUser;
    }

    public final SeekBarProgressChangeEvent copy(SeekBar seekBar, int n, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)seekBar, (String)"view");
        return new SeekBarProgressChangeEvent(seekBar, n, bl);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof SeekBarProgressChangeEvent) {
                boolean bl;
                boolean bl2;
                SeekBarProgressChangeEvent seekBarProgressChangeEvent = (SeekBarProgressChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.getView(), (Object)seekBarProgressChangeEvent.getView()) && (bl = this.progress == seekBarProgressChangeEvent.progress) && (bl2 = this.fromUser == seekBarProgressChangeEvent.fromUser)) {
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

    public final int getProgress() {
        return this.progress;
    }

    @Override
    public SeekBar getView() {
        return this.view;
    }

    public int hashCode() {
        SeekBar seekBar = this.getView();
        int n = seekBar != null ? seekBar.hashCode() : 0;
        int n2 = 31 * (n * 31 + this.progress);
        int n3 = this.fromUser ? 1 : 0;
        if (n3 != 0) {
            n3 = 1;
        }
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SeekBarProgressChangeEvent(view=");
        stringBuilder.append((Object)this.getView());
        stringBuilder.append(", progress=");
        stringBuilder.append(this.progress);
        stringBuilder.append(", fromUser=");
        stringBuilder.append(this.fromUser);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

