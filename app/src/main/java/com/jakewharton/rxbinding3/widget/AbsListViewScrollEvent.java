/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.AbsListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001d"}, d2={"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "", "view", "Landroid/widget/AbsListView;", "scrollState", "", "firstVisibleItem", "visibleItemCount", "totalItemCount", "(Landroid/widget/AbsListView;IIII)V", "getFirstVisibleItem", "()I", "getScrollState", "getTotalItemCount", "getView", "()Landroid/widget/AbsListView;", "getVisibleItemCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class AbsListViewScrollEvent {
    private final int firstVisibleItem;
    private final int scrollState;
    private final int totalItemCount;
    private final AbsListView view;
    private final int visibleItemCount;

    public AbsListViewScrollEvent(AbsListView absListView, int n, int n2, int n3, int n4) {
        Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"view");
        this.view = absListView;
        this.scrollState = n;
        this.firstVisibleItem = n2;
        this.visibleItemCount = n3;
        this.totalItemCount = n4;
    }

    public static /* synthetic */ AbsListViewScrollEvent copy$default(AbsListViewScrollEvent absListViewScrollEvent, AbsListView absListView, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            absListView = absListViewScrollEvent.view;
        }
        if ((n5 & 2) != 0) {
            n = absListViewScrollEvent.scrollState;
        }
        int n6 = n;
        if ((n5 & 4) != 0) {
            n2 = absListViewScrollEvent.firstVisibleItem;
        }
        int n7 = n2;
        if ((n5 & 8) != 0) {
            n3 = absListViewScrollEvent.visibleItemCount;
        }
        int n8 = n3;
        if ((n5 & 16) != 0) {
            n4 = absListViewScrollEvent.totalItemCount;
        }
        int n9 = n4;
        return absListViewScrollEvent.copy(absListView, n6, n7, n8, n9);
    }

    public final AbsListView component1() {
        return this.view;
    }

    public final int component2() {
        return this.scrollState;
    }

    public final int component3() {
        return this.firstVisibleItem;
    }

    public final int component4() {
        return this.visibleItemCount;
    }

    public final int component5() {
        return this.totalItemCount;
    }

    public final AbsListViewScrollEvent copy(AbsListView absListView, int n, int n2, int n3, int n4) {
        Intrinsics.checkParameterIsNotNull((Object)absListView, (String)"view");
        AbsListViewScrollEvent absListViewScrollEvent = new AbsListViewScrollEvent(absListView, n, n2, n3, n4);
        return absListViewScrollEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof AbsListViewScrollEvent) {
                boolean bl;
                boolean bl2;
                boolean bl3;
                boolean bl4;
                AbsListViewScrollEvent absListViewScrollEvent = (AbsListViewScrollEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)absListViewScrollEvent.view) && (bl3 = this.scrollState == absListViewScrollEvent.scrollState) && (bl4 = this.firstVisibleItem == absListViewScrollEvent.firstVisibleItem) && (bl2 = this.visibleItemCount == absListViewScrollEvent.visibleItemCount) && (bl = this.totalItemCount == absListViewScrollEvent.totalItemCount)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getScrollState() {
        return this.scrollState;
    }

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    public final AbsListView getView() {
        return this.view;
    }

    public final int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public int hashCode() {
        AbsListView absListView = this.view;
        int n = absListView != null ? absListView.hashCode() : 0;
        return 31 * (31 * (31 * (n * 31 + this.scrollState) + this.firstVisibleItem) + this.visibleItemCount) + this.totalItemCount;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AbsListViewScrollEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", scrollState=");
        stringBuilder.append(this.scrollState);
        stringBuilder.append(", firstVisibleItem=");
        stringBuilder.append(this.firstVisibleItem);
        stringBuilder.append(", visibleItemCount=");
        stringBuilder.append(this.visibleItemCount);
        stringBuilder.append(", totalItemCount=");
        stringBuilder.append(this.totalItemCount);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

