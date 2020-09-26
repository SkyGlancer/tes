/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  com.jakewharton.rxbinding3.appcompat.SearchViewQueryTextChangesObservable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.appcompat.SearchViewQueryTextChangesObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"queryTextChanges", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "Landroidx/appcompat/widget/SearchView;", "rxbinding-appcompat_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/appcompat/RxSearchView")
final class RxSearchView__SearchViewQueryTextChangesObservableKt {
    public static final InitialValueObservable<CharSequence> queryTextChanges(SearchView searchView) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"$this$queryTextChanges");
        return (InitialValueObservable)new SearchViewQueryTextChangesObservable(searchView);
    }
}

