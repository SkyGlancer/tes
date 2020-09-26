/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2={"Lcom/jakewharton/rxbinding3/widget/TextViewBeforeTextChangeEvent;", "", "view", "Landroid/widget/TextView;", "text", "", "start", "", "count", "after", "(Landroid/widget/TextView;Ljava/lang/CharSequence;III)V", "getAfter", "()I", "getCount", "getStart", "getText", "()Ljava/lang/CharSequence;", "getView", "()Landroid/widget/TextView;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class TextViewBeforeTextChangeEvent {
    private final int after;
    private final int count;
    private final int start;
    private final CharSequence text;
    private final TextView view;

    public TextViewBeforeTextChangeEvent(TextView textView, CharSequence charSequence, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"text");
        this.view = textView;
        this.text = charSequence;
        this.start = n;
        this.count = n2;
        this.after = n3;
    }

    public static /* synthetic */ TextViewBeforeTextChangeEvent copy$default(TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent, TextView textView, CharSequence charSequence, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            textView = textViewBeforeTextChangeEvent.view;
        }
        if ((n4 & 2) != 0) {
            charSequence = textViewBeforeTextChangeEvent.text;
        }
        CharSequence charSequence2 = charSequence;
        if ((n4 & 4) != 0) {
            n = textViewBeforeTextChangeEvent.start;
        }
        int n5 = n;
        if ((n4 & 8) != 0) {
            n2 = textViewBeforeTextChangeEvent.count;
        }
        int n6 = n2;
        if ((n4 & 16) != 0) {
            n3 = textViewBeforeTextChangeEvent.after;
        }
        int n7 = n3;
        return textViewBeforeTextChangeEvent.copy(textView, charSequence2, n5, n6, n7);
    }

    public final TextView component1() {
        return this.view;
    }

    public final CharSequence component2() {
        return this.text;
    }

    public final int component3() {
        return this.start;
    }

    public final int component4() {
        return this.count;
    }

    public final int component5() {
        return this.after;
    }

    public final TextViewBeforeTextChangeEvent copy(TextView textView, CharSequence charSequence, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull((Object)textView, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"text");
        TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent = new TextViewBeforeTextChangeEvent(textView, charSequence, n, n2, n3);
        return textViewBeforeTextChangeEvent;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof TextViewBeforeTextChangeEvent) {
                boolean bl;
                boolean bl2;
                boolean bl3;
                TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent = (TextViewBeforeTextChangeEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)textViewBeforeTextChangeEvent.view) && Intrinsics.areEqual((Object)this.text, (Object)textViewBeforeTextChangeEvent.text) && (bl2 = this.start == textViewBeforeTextChangeEvent.start) && (bl3 = this.count == textViewBeforeTextChangeEvent.count) && (bl = this.after == textViewBeforeTextChangeEvent.after)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int getAfter() {
        return this.after;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getStart() {
        return this.start;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final TextView getView() {
        return this.view;
    }

    public int hashCode() {
        TextView textView = this.view;
        int n = textView != null ? textView.hashCode() : 0;
        int n2 = n * 31;
        CharSequence charSequence = this.text;
        int n3 = 0;
        if (charSequence != null) {
            n3 = charSequence.hashCode();
        }
        return 31 * (31 * (31 * (n2 + n3) + this.start) + this.count) + this.after;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextViewBeforeTextChangeEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", start=");
        stringBuilder.append(this.start);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", after=");
        stringBuilder.append(this.after);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

