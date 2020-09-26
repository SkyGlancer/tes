/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewbinding.ViewBinding
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import app.dukhaan.ui.views.stats.StatsCard;

public final class DashboardStatCardItemBinding
implements ViewBinding {
    public final StatsCard card;
    private final StatsCard rootView;

    private DashboardStatCardItemBinding(StatsCard statsCard, StatsCard statsCard2) {
        this.rootView = statsCard;
        this.card = statsCard2;
    }

    public static DashboardStatCardItemBinding bind(View view) {
        if (view != null) {
            StatsCard statsCard = (StatsCard)view;
            return new DashboardStatCardItemBinding(statsCard, statsCard);
        }
        throw new NullPointerException("rootView");
    }

    public static DashboardStatCardItemBinding inflate(LayoutInflater layoutInflater) {
        return DashboardStatCardItemBinding.inflate(layoutInflater, null, false);
    }

    public static DashboardStatCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558479, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return DashboardStatCardItemBinding.bind(view);
    }

    public StatsCard getRoot() {
        return this.rootView;
    }
}

