/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.android.MainThreadDisposable
 *  io.reactivex.disposables.Disposable
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.ViewGroupHierarchyChangeEvent;
import com.jakewharton.rxbinding3.view.ViewGroupHierarchyChildViewAddEvent;
import com.jakewharton.rxbinding3.view.ViewGroupHierarchyChildViewRemoveEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k=1, mv={1, 1, 15})
final class ViewGroupHierarchyChangeEventObservable
extends Observable<ViewGroupHierarchyChangeEvent> {
    private final ViewGroup viewGroup;

    public ViewGroupHierarchyChangeEventObservable(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull((Object)viewGroup, (String)"viewGroup");
        this.viewGroup = viewGroup;
    }

    protected void subscribeActual(Observer<? super ViewGroupHierarchyChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        Listener listener = new Listener(this.viewGroup, observer);
        observer.onSubscribe((Disposable)listener);
        this.viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)listener);
    }

    @Metadata(bv={1, 0, 3}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0014R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "viewGroup", "Landroid/view/ViewGroup;", "observer", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "(Landroid/view/ViewGroup;Lio/reactivex/Observer;)V", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "onDispose", "rxbinding_release"}, k=1, mv={1, 1, 15})
    private static final class Listener
    extends MainThreadDisposable
    implements ViewGroup.OnHierarchyChangeListener {
        private final Observer<? super ViewGroupHierarchyChangeEvent> observer;
        private final ViewGroup viewGroup;

        public Listener(ViewGroup viewGroup, Observer<? super ViewGroupHierarchyChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull((Object)viewGroup, (String)"viewGroup");
            Intrinsics.checkParameterIsNotNull(observer, (String)"observer");
            this.viewGroup = viewGroup;
            this.observer = observer;
        }

        public void onChildViewAdded(View view, View view2) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"parent");
            Intrinsics.checkParameterIsNotNull((Object)view2, (String)"child");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)new ViewGroupHierarchyChildViewAddEvent(this.viewGroup, view2));
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            Intrinsics.checkParameterIsNotNull((Object)view, (String)"parent");
            Intrinsics.checkParameterIsNotNull((Object)view2, (String)"child");
            if (!this.isDisposed()) {
                this.observer.onNext((Object)new ViewGroupHierarchyChildViewRemoveEvent(this.viewGroup, view2));
            }
        }

        protected void onDispose() {
            this.viewGroup.setOnHierarchyChangeListener(null);
        }
    }

}

