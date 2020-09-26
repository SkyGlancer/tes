/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.core.widget.NestedScrollView
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 *  java.lang.Object
 */
package app.dukhaan.ui.home;

import androidx.core.widget.NestedScrollView;
import app.dukhaan.ui.home.HomeFragment;

public final class -$$Lambda$HomeFragment$J8rvUqsEBJWnpTq9fU-RiW8z-SI
implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ HomeFragment f$0;

    public /* synthetic */ -$$Lambda$HomeFragment$J8rvUqsEBJWnpTq9fU-RiW8z-SI(HomeFragment homeFragment) {
        this.f$0 = homeFragment;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int n, int n2, int n3, int n4) {
        this.f$0.lambda$initLoadMore$4$HomeFragment(nestedScrollView, n, n2, n3, n4);
    }
}

