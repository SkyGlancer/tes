/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewAttachEvent;", "", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/jakewharton/rxbinding3/view/ViewAttachAttachedEvent;", "Lcom/jakewharton/rxbinding3/view/ViewAttachDetachedEvent;", "rxbinding_release"}, k=1, mv={1, 1, 15})
public abstract class ViewAttachEvent {
    private ViewAttachEvent() {
    }

    public /* synthetic */ ViewAttachEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract View getView();
}

