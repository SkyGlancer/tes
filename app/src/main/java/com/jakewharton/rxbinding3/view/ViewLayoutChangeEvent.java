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

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001J\t\u0010'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006)"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewLayoutChangeEvent;", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "(Landroid/view/View;IIIIIIII)V", "getBottom", "()I", "getLeft", "getOldBottom", "getOldLeft", "getOldRight", "getOldTop", "getRight", "getTop", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class ViewLayoutChangeEvent {
    private final int bottom;
    private final int left;
    private final int oldBottom;
    private final int oldLeft;
    private final int oldRight;
    private final int oldTop;
    private final int right;
    private final int top;
    private final View view;

    public ViewLayoutChangeEvent(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        this.view = view;
        this.left = n;
        this.top = n2;
        this.right = n3;
        this.bottom = n4;
        this.oldLeft = n5;
        this.oldTop = n6;
        this.oldRight = n7;
        this.oldBottom = n8;
    }

    public static /* synthetic */ ViewLayoutChangeEvent copy$default(ViewLayoutChangeEvent viewLayoutChangeEvent, View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Object object) {
        View view2 = (n9 & 1) != 0 ? viewLayoutChangeEvent.view : view;
        int n10 = (n9 & 2) != 0 ? viewLayoutChangeEvent.left : n;
        int n11 = (n9 & 4) != 0 ? viewLayoutChangeEvent.top : n2;
        int n12 = (n9 & 8) != 0 ? viewLayoutChangeEvent.right : n3;
        int n13 = (n9 & 16) != 0 ? viewLayoutChangeEvent.bottom : n4;
        int n14 = (n9 & 32) != 0 ? viewLayoutChangeEvent.oldLeft : n5;
        int n15 = (n9 & 64) != 0 ? viewLayoutChangeEvent.oldTop : n6;
        int n16 = (n9 & 128) != 0 ? viewLayoutChangeEvent.oldRight : n7;
        int n17 = (n9 & 256) != 0 ? viewLayoutChangeEvent.oldBottom : n8;
        return viewLayoutChangeEvent.copy(view2, n10, n11, n12, n13, n14, n15, n16, n17);
    }

    public final View component1() {
        return this.view;
    }

    public final int component2() {
        return this.left;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.oldLeft;
    }

    public final int component7() {
        return this.oldTop;
    }

    public final int component8() {
        return this.oldRight;
    }

    public final int component9() {
        return this.oldBottom;
    }

    public final ViewLayoutChangeEvent copy(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        ViewLayoutChangeEvent viewLayoutChangeEvent = new ViewLayoutChangeEvent(view, n, n2, n3, n4, n5, n6, n7, n8);
        return viewLayoutChangeEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof ViewLayoutChangeEvent) {
                boolean bl;
                boolean bl2;
                boolean bl3;
                boolean bl4;
                boolean bl5;
                boolean bl6;
                boolean bl7;
                boolean bl8;
                ViewLayoutChangeEvent viewLayoutChangeEvent = (ViewLayoutChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)viewLayoutChangeEvent.view) && (bl3 = this.left == viewLayoutChangeEvent.left) && (bl8 = this.top == viewLayoutChangeEvent.top) && (bl2 = this.right == viewLayoutChangeEvent.right) && (bl = this.bottom == viewLayoutChangeEvent.bottom) && (bl6 = this.oldLeft == viewLayoutChangeEvent.oldLeft) && (bl4 = this.oldTop == viewLayoutChangeEvent.oldTop) && (bl5 = this.oldRight == viewLayoutChangeEvent.oldRight) && (bl7 = this.oldBottom == viewLayoutChangeEvent.oldBottom)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getOldBottom() {
        return this.oldBottom;
    }

    public final int getOldLeft() {
        return this.oldLeft;
    }

    public final int getOldRight() {
        return this.oldRight;
    }

    public final int getOldTop() {
        return this.oldTop;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        View view = this.view;
        int n = view != null ? view.hashCode() : 0;
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (n * 31 + this.left) + this.top) + this.right) + this.bottom) + this.oldLeft) + this.oldTop) + this.oldRight) + this.oldBottom;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewLayoutChangeEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", left=");
        stringBuilder.append(this.left);
        stringBuilder.append(", top=");
        stringBuilder.append(this.top);
        stringBuilder.append(", right=");
        stringBuilder.append(this.right);
        stringBuilder.append(", bottom=");
        stringBuilder.append(this.bottom);
        stringBuilder.append(", oldLeft=");
        stringBuilder.append(this.oldLeft);
        stringBuilder.append(", oldTop=");
        stringBuilder.append(this.oldTop);
        stringBuilder.append(", oldRight=");
        stringBuilder.append(this.oldRight);
        stringBuilder.append(", oldBottom=");
        stringBuilder.append(this.oldBottom);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

