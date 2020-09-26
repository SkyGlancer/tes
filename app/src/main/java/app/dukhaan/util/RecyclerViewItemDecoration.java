/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package app.dukhaan.util;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewItemDecoration
extends RecyclerView.ItemDecoration {
    public static final int GRID = 2;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int displayMode;
    private final int spacing;

    public RecyclerViewItemDecoration(int n) {
        this(n, -1);
    }

    public RecyclerViewItemDecoration(int n, int n2) {
        this.spacing = n;
        this.displayMode = n2;
    }

    private int resolveDisplayMode(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return 2;
        }
        return !layoutManager.canScrollHorizontally();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void setSpacingForDirection(Rect rect, RecyclerView.LayoutManager layoutManager, int n, int n2) {
        int n3;
        if (this.displayMode == -1) {
            this.displayMode = this.resolveDisplayMode(layoutManager);
        }
        if ((n3 = this.displayMode) != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    return;
                }
                if (!(layoutManager instanceof GridLayoutManager)) return;
                int n4 = ((GridLayoutManager)layoutManager).getSpanCount();
                int n5 = n2 / n4;
                rect.left = this.spacing;
                int n6 = n % n4 == n4 - 1 ? this.spacing : 0;
                rect.right = n6;
                rect.top = this.spacing;
                int n7 = n / n4;
                int n8 = n5 - 1;
                int n9 = 0;
                if (n7 == n8) {
                    n9 = this.spacing;
                }
                rect.bottom = n9;
                return;
            }
            rect.left = this.spacing;
            rect.right = this.spacing;
            rect.top = this.spacing;
            int n10 = n2 - 1;
            int n11 = 0;
            if (n == n10) {
                n11 = this.spacing;
            }
            rect.bottom = n11;
            return;
        }
        int n12 = n == 0 ? 0 : this.spacing / 2;
        rect.left = n12;
        int n13 = n == n2 - 1 ? 0 : this.spacing / 2;
        rect.right = n13;
        rect.top = 0;
        rect.bottom = 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int n = recyclerView.getChildViewHolder(view).getAdapterPosition();
        int n2 = state.getItemCount();
        this.setSpacingForDirection(rect, recyclerView.getLayoutManager(), n, n2);
    }
}

