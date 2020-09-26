/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.widget.TextView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.text.Editable;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "", "view", "Landroid/widget/TextView;", "editable", "Landroid/text/Editable;", "(Landroid/widget/TextView;Landroid/text/Editable;)V", "getEditable", "()Landroid/text/Editable;", "getView", "()Landroid/widget/TextView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class TextViewAfterTextChangeEvent {
    private final Editable editable;
    private final TextView view;

    public TextViewAfterTextChangeEvent(TextView textView, Editable editable) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        this.view = textView;
        this.editable = editable;
    }

    public static /* synthetic */ TextViewAfterTextChangeEvent copy$default(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent, TextView textView, Editable editable, int n, Object object) {
        if ((n & 1) != 0) {
            textView = textViewAfterTextChangeEvent.view;
        }
        if ((n & 2) != 0) {
            editable = textViewAfterTextChangeEvent.editable;
        }
        return textViewAfterTextChangeEvent.copy(textView, editable);
    }

    public final TextView component1() {
        return this.view;
    }

    public final Editable component2() {
        return this.editable;
    }

    public final TextViewAfterTextChangeEvent copy(TextView textView, Editable editable) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        return new TextViewAfterTextChangeEvent(textView, editable);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof TextViewAfterTextChangeEvent)) break block3;
                TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)textViewAfterTextChangeEvent.view) && Intrinsics.areEqual((Object)this.editable, (Object)textViewAfterTextChangeEvent.editable)) break block2;
            }
            return false;
        }
        return true;
    }

    public final Editable getEditable() {
        return this.editable;
    }

    public final TextView getView() {
        return this.view;
    }

    public int hashCode() {
        TextView textView = this.view;
        int n = textView != null ? textView.hashCode() : 0;
        int n2 = n * 31;
        Editable editable = this.editable;
        int n3 = 0;
        if (editable != null) {
            n3 = editable.hashCode();
        }
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextViewAfterTextChangeEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", editable=");
        stringBuilder.append((Object)this.editable);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

