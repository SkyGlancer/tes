/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SearchView
 *  com.jakewharton.rxbinding3.InitialValueObservable
 *  io.reactivex.functions.Consumer
 *  java.lang.CharSequence
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxSearchView__SearchViewQueryConsumerKt;
import com.jakewharton.rxbinding3.widget.RxSearchView__SearchViewQueryTextChangeEventsObservableKt;
import com.jakewharton.rxbinding3.widget.RxSearchView__SearchViewQueryTextChangesObservableKt;
import com.jakewharton.rxbinding3.widget.SearchViewQueryTextEvent;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryConsumerKt", "com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryTextChangeEventsObservableKt", "com/jakewharton/rxbinding3/widget/RxSearchView__SearchViewQueryTextChangesObservableKt"}, k=4, mv={1, 1, 15})
public final class RxSearchView {
    public static final Consumer<? super CharSequence> query(SearchView searchView, boolean bl) {
        return RxSearchView__SearchViewQueryConsumerKt.query(searchView, bl);
    }

    public static final InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangeEventsObservableKt.queryTextChangeEvents(searchView);
    }

    public static final InitialValueObservable<CharSequence> queryTextChanges(SearchView searchView) {
        return RxSearchView__SearchViewQueryTextChangesObservableKt.queryTextChanges(searchView);
    }
}

