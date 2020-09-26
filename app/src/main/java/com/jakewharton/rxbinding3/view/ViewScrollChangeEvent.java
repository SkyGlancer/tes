/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewScrollChangeEvent;", "", "view", "Landroid/view/View;", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "(Landroid/view/View;IIII)V", "getOldScrollX", "()I", "getOldScrollY", "getScrollX", "getScrollY", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class ViewScrollChangeEvent {
    private final int oldScrollX;
    private final int oldScrollY;
    private final int scrollX;
    private final int scrollY;
    private final View view;

    public ViewScrollChangeEvent(View view, int n, int n2, int n3, int n4) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        this.view = view;
        this.scrollX = n;
        this.scrollY = n2;
        this.oldScrollX = n3;
        this.oldScrollY = n4;
    }

    public static /* synthetic */ ViewScrollChangeEvent copy$default(ViewScrollChangeEvent viewScrollChangeEvent, View view, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            view = viewScrollChangeEvent.view;
        }
        if ((n5 & 2) != 0) {
            n = viewScrollChangeEvent.scrollX;
        }
        int n6 = n;
        if ((n5 & 4) != 0) {
            n2 = viewScrollChangeEvent.scrollY;
        }
        int n7 = n2;
        if ((n5 & 8) != 0) {
            n3 = viewScrollChangeEvent.oldScrollX;
        }
        int n8 = n3;
        if ((n5 & 16) != 0) {
            n4 = viewScrollChangeEvent.oldScrollY;
        }
        int n9 = n4;
        return viewScrollChangeEvent.copy(view, n6, n7, n8, n9);
    }

    public final View component1() {
        return this.view;
    }

    public final int component2() {
        return this.scrollX;
    }

    public final int component3() {
        return this.scrollY;
    }

    public final int component4() {
        return this.oldScrollX;
    }

    public final int component5() {
        return this.oldScrollY;
    }

    public final ViewScrollChangeEvent copy(View view, int n, int n2, int n3, int n4) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        ViewScrollChangeEvent viewScrollChangeEvent = new ViewScrollChangeEvent(view, n, n2, n3, n4);
        return viewScrollChangeEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof ViewScrollChangeEvent) {
                boolean bl;
                boolean bl2;
                boolean bl3;
                boolean bl4;
                ViewScrollChangeEvent viewScrollChangeEvent = (ViewScrollChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)viewScrollChangeEvent.view) && (bl3 = this.scrollX == viewScrollChangeEvent.scrollX) && (bl4 = this.scrollY == viewScrollChangeEvent.scrollY) && (bl2 = this.oldScrollX == viewScrollChangeEvent.oldScrollX) && (bl = this.oldScrollY == viewScrollChangeEvent.oldScrollY)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getOldScrollX() {
        return this.oldScrollX;
    }

    public final int getOldScrollY() {
        return this.oldScrollY;
    }

    public final int getScrollX() {
        return this.scrollX;
    }

    public final int getScrollY() {
        return this.scrollY;
    }

    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        View view = this.view;
        int n = view != null ? view.hashCode() : 0;
        return 31 * (31 * (31 * (n * 31 + this.scrollX) + this.scrollY) + this.oldScrollX) + this.oldScrollY;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewScrollChangeEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", scrollX=");
        stringBuilder.append(this.scrollX);
        stringBuilder.append(", scrollY=");
        stringBuilder.append(this.scrollY);
        stringBuilder.append(", oldScrollX=");
        stringBuilder.append(this.oldScrollX);
        stringBuilder.append(", oldScrollY=");
        stringBuilder.append(this.oldScrollY);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

