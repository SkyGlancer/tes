/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewSetQueryConsumerKt$query
 *  com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewSetQueryConsumerKt$query$1
 *  io.reactivex.functions.Consumer
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.appcompat;

import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding3.appcompat.RxSearchView__SearchViewSetQueryConsumerKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"query", "Lio/reactivex/functions/Consumer;", "", "Landroidx/appcompat/widget/SearchView;", "submit", "", "rxbinding-appcompat_release"}, k=5, mv={1, 1, 15}, xs="com/jakewharton/rxbinding3/appcompat/RxSearchView")
final class RxSearchView__SearchViewSetQueryConsumerKt {
    public static final Consumer<? super CharSequence> query(SearchView searchView, boolean bl) {
        Intrinsics.checkParameterIsNotNull((Object)searchView, (String)"$this$query");
        return (Consumer)new query.1(searchView, bl);
    }
}

