/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.SearchView
 *  android.widget.SearchView$OnQueryTextListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.SearchViewQueryTextEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangeEventsObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "view", "Landroid/widget/SearchView;", "(Landroid/widget/SearchView;)V", "initialValue", "getInitialValue", "()Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class SearchViewQueryTextChangeEventsObservable
extends InitialValueObservable<SearchViewQueryTextEvent> {
    private final SearchView view;

    public SearchViewQueryTextChangeEventsObservable(SearchView searchView) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"view");
        this.view = searchView;
    }

    @Override
    protected SearchViewQueryTextEvent getInitialValue() {
        SearchView searchView = this.view;
        CharSequence charSequence = searchView.getQuery();
        Intrinsics.checkExpressionValueIsNotNull((Object)charSequence, (String)"view.query");
        return new SearchViewQueryTextEvent(searchView, charSequence, false);
    }

    @Override
    protected void subscribeListener(Observer<? super SearchViewQueryTextEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        this.view.setOnQueryTextListener((SearchView.OnQueryTextListener)listener);
        observer.onSubscribe((Disposable)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextChangeEventsObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/widget/SearchView$OnQueryTextListener;", "view", "Landroid/widget/SearchView;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/widget/SearchViewQueryTextEvent;", "(Landroid/widget/SearchView;Lio/reactivex/Observer;)V", "onDispose", "", "onQueryTextChange", "", "s", "", "onQueryTextSubmit", "query", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements SearchView.OnQueryTextListener {
        private final Observer<? super SearchViewQueryTextEvent> observer;
        private final SearchView view;

        public Listener(SearchView searchView, Observer<? super SearchViewQueryTextEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"view");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.view = searchView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.view.setOnQueryTextListener(null);
        }

        public boolean onQueryTextChange(String string2) {
            Intrinsics.checkParameterIsNotNull((Object)string2, (String)"s");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)new SearchViewQueryTextEvent(this.view, string2, false));
                return true;
            }
            return false;
        }

        public boolean onQueryTextSubmit(String string2) {
            Intrinsics.checkParameterIsNotNull((Object)string2, (String)"query");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)new SearchViewQueryTextEvent(this.view, string2, true));
                return true;
            }
            return false;
        }
    }

}

