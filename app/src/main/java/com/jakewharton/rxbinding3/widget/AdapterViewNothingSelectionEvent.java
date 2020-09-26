/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AdapterView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.AdapterView;
import com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0003J\u0017\u0010\b\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/widget/AdapterViewNothingSelectionEvent;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "view", "Landroid/widget/AdapterView;", "(Landroid/widget/AdapterView;)V", "getView", "()Landroid/widget/AdapterView;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class AdapterViewNothingSelectionEvent
extends AdapterViewSelectionEvent {
    private final AdapterView<?> view;

    public AdapterViewNothingSelectionEvent(AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        super(null);
        this.view = adapterView;
    }

    public static /* synthetic */ AdapterViewNothingSelectionEvent copy$default(AdapterViewNothingSelectionEvent adapterViewNothingSelectionEvent, AdapterView adapterView, int n, Object object) {
        if ((n & 1) != 0) {
            adapterView = adapterViewNothingSelectionEvent.getView();
        }
        return adapterViewNothingSelectionEvent.copy(adapterView);
    }

    public final AdapterView<?> component1() {
        return this.getView();
    }

    public final AdapterViewNothingSelectionEvent copy(AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, (String)"view");
        return new AdapterViewNothingSelectionEvent(adapterView);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof AdapterViewNothingSelectionEvent)) break block3;
                AdapterViewNothingSelectionEvent adapterViewNothingSelectionEvent = (AdapterViewNothingSelectionEvent)object;
                if (Intrinsics.areEqual(this.getView(), adapterViewNothingSelectionEvent.getView())) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public AdapterView<?> getView() {
        return this.view;
    }

    public int hashCode() {
        AdapterView<?> adapterView = this.getView();
        if (adapterView != null) {
            return adapterView.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdapterViewNothingSelectionEvent(view=");
        stringBuilder.append(this.getView());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

