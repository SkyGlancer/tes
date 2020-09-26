/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  io.reactivex.Observable
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.ViewGroup;
import com.jakewharton.rxbinding3.view.RxViewGroup__ViewGroupHierarchyChangeEventObservableKt;
import com.jakewharton.rxbinding3.view.ViewGroupHierarchyChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"com/jakewharton/rxbinding3/view/RxViewGroup__ViewGroupHierarchyChangeEventObservableKt"}, k=4, mv={1, 1, 15})
public final class RxViewGroup {
    public static final Observable<ViewGroupHierarchyChangeEvent> changeEvents(ViewGroup viewGroup) {
        return RxViewGroup__ViewGroupHierarchyChangeEventObservableKt.changeEvents(viewGroup);
    }
}

