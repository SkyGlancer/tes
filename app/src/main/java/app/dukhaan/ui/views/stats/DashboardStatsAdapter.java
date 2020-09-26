/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.views.stats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.ui.views.model.StatsCardData;
import app.dukhaan.ui.views.stats.StatsCard;
import java.util.List;

public class DashboardStatsAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private List<StatsCardData> stats;

    public int getItemCount() {
        List<StatsCardData> list = this.stats;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        StatsCardData statsCardData = (StatsCardData)this.stats.get(n);
        viewHolder.card.setData(statsCardData);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558479, viewGroup, false));
    }

    public void setData(List<StatsCardData> list) {
        this.stats = list;
        this.notifyDataSetChanged();
    }

    class ViewHolder
    extends RecyclerView.ViewHolder {
        StatsCard card;

        ViewHolder(View view) {
            super(view);
            this.card = (StatsCard)view.findViewById(2131361928);
        }
    }

}

