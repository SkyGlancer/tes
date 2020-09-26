/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.view.ViewAttachEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewAttachDetachedEvent;", "Lcom/jakewharton/rxbinding3/view/ViewAttachEvent;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class ViewAttachDetachedEvent
extends ViewAttachEvent {
    private final View view;

    public ViewAttachDetachedEvent(View view) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        super(null);
        this.view = view;
    }

    public static /* synthetic */ ViewAttachDetachedEvent copy$default(ViewAttachDetachedEvent viewAttachDetachedEvent, View view, int n, Object object) {
        if ((n & 1) != 0) {
            view = viewAttachDetachedEvent.getView();
        }
        return viewAttachDetachedEvent.copy(view);
    }

    public final View component1() {
        return this.getView();
    }

    public final ViewAttachDetachedEvent copy(View view) {
        Intrinsics.checkParameterIsNotNull((Object)view, (String)"view");
        return new ViewAttachDetachedEvent(view);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof ViewAttachDetachedEvent)) break block3;
                ViewAttachDetachedEvent viewAttachDetachedEvent = (ViewAttachDetachedEvent)object;
                if (Intrinsics.areEqual((Object)this.getView(), (Object)viewAttachDetachedEvent.getView())) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public View getView() {
        return this.view;
    }

    public int hashCode() {
        View view = this.getView();
        if (view != null) {
            return view.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewAttachDetachedEvent(view=");
        stringBuilder.append((Object)this.getView());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

