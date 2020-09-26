/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 */
package app.dukhaan.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener
extends RecyclerView.OnScrollListener {
    private LinearLayoutManager layoutManager;

    protected PaginationScrollListener(LinearLayoutManager linearLayoutManager) {
        this.layoutManager = linearLayoutManager;
    }

    public abstract boolean isLastPage();

    public abstract boolean isLoading();

    protected abstract void loadMoreItems();

    public void onScrolled(RecyclerView recyclerView, int n, int n2) {
        super.onScrolled(recyclerView, n, n2);
        int n3 = this.layoutManager.getChildCount();
        int n4 = this.layoutManager.getItemCount();
        int n5 = this.layoutManager.findFirstVisibleItemPosition();
        if (!this.isLoading() && !this.isLastPage() && n3 + n5 >= n4 && n5 >= 0) {
            this.loadMoreItems();
        }
    }
}

