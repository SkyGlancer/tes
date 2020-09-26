/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.widget.TextView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEvent;", "", "view", "Landroid/widget/TextView;", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)V", "getActionId", "()I", "getKeyEvent", "()Landroid/view/KeyEvent;", "getView", "()Landroid/widget/TextView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class TextViewEditorActionEvent {
    private final int actionId;
    private final KeyEvent keyEvent;
    private final TextView view;

    public TextViewEditorActionEvent(TextView textView, int n, KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        this.view = textView;
        this.actionId = n;
        this.keyEvent = keyEvent;
    }

    public static /* synthetic */ TextViewEditorActionEvent copy$default(TextViewEditorActionEvent textViewEditorActionEvent, TextView textView, int n, KeyEvent keyEvent, int n2, Object object) {
        if ((n2 & 1) != 0) {
            textView = textViewEditorActionEvent.view;
        }
        if ((n2 & 2) != 0) {
            n = textViewEditorActionEvent.actionId;
        }
        if ((n2 & 4) != 0) {
            keyEvent = textViewEditorActionEvent.keyEvent;
        }
        return textViewEditorActionEvent.copy(textView, n, keyEvent);
    }

    public final TextView component1() {
        return this.view;
    }

    public final int component2() {
        return this.actionId;
    }

    public final KeyEvent component3() {
        return this.keyEvent;
    }

    public final TextViewEditorActionEvent copy(TextView textView, int n, KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        return new TextViewEditorActionEvent(textView, n, keyEvent);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof TextViewEditorActionEvent) {
                boolean bl;
                TextViewEditorActionEvent textViewEditorActionEvent = (TextViewEditorActionEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)textViewEditorActionEvent.view) && (bl = this.actionId == textViewEditorActionEvent.actionId) && Intrinsics.areEqual((Object)this.keyEvent, (Object)textViewEditorActionEvent.keyEvent)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final KeyEvent getKeyEvent() {
        return this.keyEvent;
    }

    public final TextView getView() {
        return this.view;
    }

    public int hashCode() {
        TextView textView = this.view;
        int n = textView != null ? textView.hashCode() : 0;
        int n2 = 31 * (n * 31 + this.actionId);
        KeyEvent keyEvent = this.keyEvent;
        int n3 = 0;
        if (keyEvent != null) {
            n3 = keyEvent.hashCode();
        }
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextViewEditorActionEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", actionId=");
        stringBuilder.append(this.actionId);
        stringBuilder.append(", keyEvent=");
        stringBuilder.append((Object)this.keyEvent);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

