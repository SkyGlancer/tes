/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickEvent;", "", "view", "Landroid/widget/AdapterView;", "clickedView", "Landroid/view/View;", "position", "", "id", "", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "getClickedView", "()Landroid/view/View;", "getId", "()J", "getPosition", "()I", "getView", "()Landroid/widget/AdapterView;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class AdapterViewItemLongClickEvent {
    private final View clickedView;
    private final long id;
    private final int position;
    private final AdapterView<?> view;

    public AdapterViewItemLongClickEvent(AdapterView<?> adapterView, View view, int n, long l) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        this.view = adapterView;
        this.clickedView = view;
        this.position = n;
        this.id = l;
    }

    public static /* synthetic */ AdapterViewItemLongClickEvent copy$default(AdapterViewItemLongClickEvent adapterViewItemLongClickEvent, AdapterView adapterView, View view, int n, long l, int n2, Object object) {
        if ((n2 & 1) != 0) {
            adapterView = adapterViewItemLongClickEvent.view;
        }
        if ((n2 & 2) != 0) {
            view = adapterViewItemLongClickEvent.clickedView;
        }
        View view2 = view;
        if ((n2 & 4) != 0) {
            n = adapterViewItemLongClickEvent.position;
        }
        int n3 = n;
        if ((n2 & 8) != 0) {
            l = adapterViewItemLongClickEvent.id;
        }
        long l2 = l;
        return adapterViewItemLongClickEvent.copy(adapterView, view2, n3, l2);
    }

    public final AdapterView<?> component1() {
        return this.view;
    }

    public final View component2() {
        return this.clickedView;
    }

    public final int component3() {
        return this.position;
    }

    public final long component4() {
        return this.id;
    }

    public final AdapterViewItemLongClickEvent copy(AdapterView<?> adapterView, View view, int n, long l) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        AdapterViewItemLongClickEvent adapterViewItemLongClickEvent = new AdapterViewItemLongClickEvent(adapterView, view, n, l);
        return adapterViewItemLongClickEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof AdapterViewItemLongClickEvent) {
                boolean bl;
                boolean bl2;
                AdapterViewItemLongClickEvent adapterViewItemLongClickEvent = (AdapterViewItemLongClickEvent)object;
                if (Intrinsics.areEqual(this.view, adapterViewItemLongClickEvent.view) && Intrinsics.areEqual((Object)this.clickedView, (Object)adapterViewItemLongClickEvent.clickedView) && (bl = this.position == adapterViewItemLongClickEvent.position) && (bl2 = this.id == adapterViewItemLongClickEvent.id)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final View getClickedView() {
        return this.clickedView;
    }

    public final long getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final AdapterView<?> getView() {
        return this.view;
    }

    public int hashCode() {
        AdapterView<?> adapterView = this.view;
        int n = adapterView != null ? adapterView.hashCode() : 0;
        int n2 = n * 31;
        View view = this.clickedView;
        int n3 = 0;
        if (view != null) {
            n3 = view.hashCode();
        }
        int n4 = 31 * (31 * (n2 + n3) + this.position);
        long l = this.id;
        return n4 + (int)(l ^ l >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdapterViewItemLongClickEvent(view=");
        stringBuilder.append(this.view);
        stringBuilder.append(", clickedView=");
        stringBuilder.append((Object)this.clickedView);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

