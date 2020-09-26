/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  app.dukhaan.ui.views.products.ProductImagesListAdapter
 *  java.lang.Object
 */
package app.dukhaan.ui.views.products;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.ui.views.products.ProductImagesListAdapter;

public final class -$$Lambda$ProductImagesListAdapter$B_XkyoIE6hmahHkf6obrwrxDIe4
implements View.OnClickListener {
    public final /* synthetic */ ProductImagesListAdapter f$0;
    public final /* synthetic */ RecyclerView.ViewHolder f$1;

    public /* synthetic */ -$$Lambda$ProductImagesListAdapter$B_XkyoIE6hmahHkf6obrwrxDIe4(ProductImagesListAdapter productImagesListAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f$0 = productImagesListAdapter;
        this.f$1 = viewHolder;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$ProductImagesListAdapter(this.f$1, view);
    }
}

