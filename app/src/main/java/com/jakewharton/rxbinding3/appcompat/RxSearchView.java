/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  io.reactivex.functions.Consumer
 *  java.lang.CharSequence
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewQueryTextChangeEventsObservableKt;
import com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewQueryTextChangesObservableKt;
import com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewSetQueryConsumerKt;
import com.jakewharton.rxbinding3.appcompat.SearchViewQueryTextEvent;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/appcompat/RxSearchView__SearchViewQueryTextChangeEventsObservableKt", "com/jakewharton/rxbinding3/appcompat/RxSearchView__SearchViewQueryTextChangesObservableKt", "com/jakewharton/rxbinding3/appcompat/RxSearchView__SearchViewSetQueryConsumerKt"}, k=4, mv={1, 1, 15})
public final class RxSearchView {
    public static final Consumer<? super CharSequence> query(SearchView searchView, boolean bl) {
        return RxSearchView__SearchViewSetQueryConsumerKt.query(searchView, bl);
    }

    public static final InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangeEventsObservableKt.queryTextChangeEvents(searchView);
    }

    public static final InitialValueObservable<CharSequence> queryTextChanges(SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangesObservableKt.queryTextChanges(searchView);
    }
}

