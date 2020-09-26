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
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemSelectionEvent;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "view", "Landroid/widget/AdapterView;", "selectedView", "Landroid/view/View;", "position", "", "id", "", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "getId", "()J", "getPosition", "()I", "getSelectedView", "()Landroid/view/View;", "getView", "()Landroid/widget/AdapterView;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class AdapterViewItemSelectionEvent
extends AdapterViewSelectionEvent {
    private final long id;
    private final int position;
    private final View selectedView;
    private final AdapterView<?> view;

    public AdapterViewItemSelectionEvent(AdapterView<?> adapterView, View view, int n, long l) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        super(null);
        this.view = adapterView;
        this.selectedView = view;
        this.position = n;
        this.id = l;
    }

    public static /* synthetic */ AdapterViewItemSelectionEvent copy$default(AdapterViewItemSelectionEvent adapterViewItemSelectionEvent, AdapterView adapterView, View view, int n, long l, int n2, Object object) {
        if ((n2 & 1) != 0) {
            adapterView = adapterViewItemSelectionEvent.getView();
        }
        if ((n2 & 2) != 0) {
            view = adapterViewItemSelectionEvent.selectedView;
        }
        View view2 = view;
        if ((n2 & 4) != 0) {
            n = adapterViewItemSelectionEvent.position;
        }
        int n3 = n;
        if ((n2 & 8) != 0) {
            l = adapterViewItemSelectionEvent.id;
        }
        long l2 = l;
        return adapterViewItemSelectionEvent.copy(adapterView, view2, n3, l2);
    }

    public final AdapterView<?> component1() {
        return this.getView();
    }

    public final View component2() {
        return this.selectedView;
    }

    public final int component3() {
        return this.position;
    }

    public final long component4() {
        return this.id;
    }

    public final AdapterViewItemSelectionEvent copy(AdapterView<?> adapterView, View view, int n, long l) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = new AdapterViewItemSelectionEvent(adapterView, view, n, l);
        return adapterViewItemSelectionEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof AdapterViewItemSelectionEvent) {
                boolean bl;
                boolean bl2;
                AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = (AdapterViewItemSelectionEvent)object;
                if (Intrinsics.areEqual(this.getView(), adapterViewItemSelectionEvent.getView()) && Intrinsics.areEqual((Object)this.selectedView, (Object)adapterViewItemSelectionEvent.selectedView) && (bl = this.position == adapterViewItemSelectionEvent.position) && (bl2 = this.id == adapterViewItemSelectionEvent.id)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final long getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final View getSelectedView() {
        return this.selectedView;
    }

    @Override
    public AdapterView<?> getView() {
        return this.view;
    }

    public int hashCode() {
        AdapterView<?> adapterView = this.getView();
        int n = adapterView != null ? adapterView.hashCode() : 0;
        int n2 = n * 31;
        View view = this.selectedView;
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
        stringBuilder.append("AdapterViewItemSelectionEvent(view=");
        stringBuilder.append(this.getView());
        stringBuilder.append(", selectedView=");
        stringBuilder.append((Object)this.selectedView);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

