/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.SearchView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2={"Lcom/jakewharton/rxbinding3/appcompat/SearchViewQueryTextEvent;", "", "view", "Landroidx/appcompat/widget/SearchView;", "queryText", "", "isSubmitted", "", "(Landroidx/appcompat/widget/SearchView;Ljava/lang/CharSequence;Z)V", "()Z", "getQueryText", "()Ljava/lang/CharSequence;", "getView", "()Landroidx/appcompat/widget/SearchView;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "rxbinding-appcompat_release"}, k=1, mv={1, 1, 15})
public final class SearchViewQueryTextEvent {
    private final boolean isSubmitted;
    private final CharSequence queryText;
    private final SearchView view;

    public SearchViewQueryTextEvent(SearchView searchView, CharSequence charSequence, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"queryText");
        this.view = searchView;
        this.queryText = charSequence;
        this.isSubmitted = bl;
    }

    public static /* synthetic */ SearchViewQueryTextEvent copy$default(SearchViewQueryTextEvent searchViewQueryTextEvent, SearchView searchView, CharSequence charSequence, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            searchView = searchViewQueryTextEvent.view;
        }
        if ((n & 2) != 0) {
            charSequence = searchViewQueryTextEvent.queryText;
        }
        if ((n & 4) != 0) {
            bl = searchViewQueryTextEvent.isSubmitted;
        }
        return searchViewQueryTextEvent.copy(searchView, charSequence, bl);
    }

    public final SearchView component1() {
        return this.view;
    }

    public final CharSequence component2() {
        return this.queryText;
    }

    public final boolean component3() {
        return this.isSubmitted;
    }

    public final SearchViewQueryTextEvent copy(SearchView searchView, CharSequence charSequence, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"view");
        Intrinsics.checkParameterIsNotNull((Object)charSequence, (String)"queryText");
        return new SearchViewQueryTextEvent(searchView, charSequence, bl);
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof SearchViewQueryTextEvent) {
                boolean bl;
                SearchViewQueryTextEvent searchViewQueryTextEvent = (SearchViewQueryTextEvent)object;
                if (Intrinsics.areEqual((Object)this.view, (Object)searchViewQueryTextEvent.view) && Intrinsics.areEqual((Object)this.queryText, (Object)searchViewQueryTextEvent.queryText) && (bl = this.isSubmitted == searchViewQueryTextEvent.isSubmitted)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final CharSequence getQueryText() {
        return this.queryText;
    }

    public final SearchView getView() {
        return this.view;
    }

    public int hashCode() {
        SearchView searchView = this.view;
        int n = searchView != null ? searchView.hashCode() : 0;
        int n2 = n * 31;
        CharSequence charSequence = this.queryText;
        int n3 = 0;
        if (charSequence != null) {
            n3 = charSequence.hashCode();
        }
        int n4 = 31 * (n2 + n3);
        int n5 = this.isSubmitted ? 1 : 0;
        if (n5 != 0) {
            n5 = 1;
        }
        return n4 + n5;
    }

    public final boolean isSubmitted() {
        return this.isSubmitted;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SearchViewQueryTextEvent(view=");
        stringBuilder.append((Object)this.view);
        stringBuilder.append(", queryText=");
        stringBuilder.append(this.queryText);
        stringBuilder.append(", isSubmitted=");
        stringBuilder.append(this.isSubmitted);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

