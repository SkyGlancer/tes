/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u000b\f\u00a8\u0006\r"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "", "()V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewAddEvent;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "rxbinding_release"}, k=1, mv={1, 1, 15})
public abstract class ViewGroupHierarchyChangeEvent {
    private ViewGroupHierarchyChangeEvent() {
    }

    public /* synthetic */ ViewGroupHierarchyChangeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract View getChild();

    public abstract ViewGroup getView();
}

