/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding3.view.ViewGroupHierarchyChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "view", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "getChild", "()Landroid/view/View;", "getView", "()Landroid/view/ViewGroup;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class ViewGroupHierarchyChildViewRemoveEvent
extends ViewGroupHierarchyChangeEvent {
    private final View child;
    private final ViewGroup view;

    public ViewGroupHierarchyChildViewRemoveEvent(ViewGroup viewGroup, View view) {
        Intrinsics.checkParameterIsNotNull((Object)viewGroup, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"child");
        super(null);
        this.view = viewGroup;
        this.child = view;
    }

    public static /* synthetic */ ViewGroupHierarchyChildViewRemoveEvent copy$default(ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent, ViewGroup viewGroup, View view, int n, Object object) {
        if ((n & 1) != 0) {
            viewGroup = viewGroupHierarchyChildViewRemoveEvent.getView();
        }
        if ((n & 2) != 0) {
            view = viewGroupHierarchyChildViewRemoveEvent.getChild();
        }
        return viewGroupHierarchyChildViewRemoveEvent.copy(viewGroup, view);
    }

    public final ViewGroup component1() {
        return this.getView();
    }

    public final View component2() {
        return this.getChild();
    }

    public final ViewGroupHierarchyChildViewRemoveEvent copy(ViewGroup viewGroup, View view) {
        Intrinsics.checkParameterIsNotNull((Object)viewGroup, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"child");
        return new ViewGroupHierarchyChildViewRemoveEvent(viewGroup, view);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof ViewGroupHierarchyChildViewRemoveEvent)) break block3;
                ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent = (ViewGroupHierarchyChildViewRemoveEvent)object;
                if (Intrinsics.areEqual((Object)this.getView(), (Object)viewGroupHierarchyChildViewRemoveEvent.getView()) && Intrinsics.areEqual((Object)this.getChild(), (Object)viewGroupHierarchyChildViewRemoveEvent.getChild())) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public View getChild() {
        return this.child;
    }

    @Override
    public ViewGroup getView() {
        return this.view;
    }

    public int hashCode() {
        ViewGroup viewGroup = this.getView();
        int n = viewGroup != null ? viewGroup.hashCode() : 0;
        int n2 = n * 31;
        View view = this.getChild();
        int n3 = 0;
        if (view != null) {
            n3 = view.hashCode();
        }
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewGroupHierarchyChildViewRemoveEvent(view=");
        stringBuilder.append((Object)this.getView());
        stringBuilder.append(", child=");
        stringBuilder.append((Object)this.getChild());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

