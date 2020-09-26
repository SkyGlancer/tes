/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  androidx.appcompat.widget.SearchView$OnQueryTextListener
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\rH\u0014R\u001c\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcom/jakewharton/rxbinding3/appcompat/SearchViewQueryTextChangesObservable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "view", "Landroidx/appcompat/widget/SearchView;", "(Landroidx/appcompat/widget/SearchView;)V", "initialValue", "kotlin.jvm.PlatformType", "getInitialValue", "()Ljava/lang/CharSequence;", "subscribeListener", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding-appcompat_release"}, k=1, mv={1, 1, 15})
final class SearchViewQueryTextChangesObservable
extends InitialValueObservable<CharSequence> {
    private final SearchView view;

    public SearchViewQueryTextChangesObservable(SearchView searchView) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"view");
        this.view = searchView;
    }

    @Override
    protected CharSequence getInitialValue() {
        return this.view.getQuery();
    }

    @Override
    protected void subscribeListener(Observer<? super CharSequence> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.view, observer);
        observer.onSubscribe((Disposable)listener);
        this.view.setOnQueryTextListener((SearchView.OnQueryTextListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/appcompat/SearchViewQueryTextChangesObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "searchView", "Landroidx/appcompat/widget/SearchView;", "observer", "Lio/reactivex/Observer;", "", "(Landroidx/appcompat/widget/SearchView;Lio/reactivex/Observer;)V", "onDispose", "", "onQueryTextChange", "", "s", "", "onQueryTextSubmit", "query", "rxbinding-appcompat_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements SearchView.OnQueryTextListener {
        private final Observer<? super CharSequence> observer;
        private final SearchView searchView;

        public Listener(SearchView searchView, Observer<? super CharSequence> observer) {
            Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"searchView");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.searchView = searchView;
            this.observer = observer;
        }

        protected void onDispose() {
            this.searchView.setOnQueryTextListener(null);
        }

        public boolean onQueryTextChange(String string2) {
            Intrinsics.checkParameterIsNotNull((Object)string2, (String)"s");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)string2);
                return true;
            }
            return false;
        }

        public boolean onQueryTextSubmit(String string2) {
            Intrinsics.checkParameterIsNotNull((Object)string2, (String)"query");
            return false;
        }
    }

}

