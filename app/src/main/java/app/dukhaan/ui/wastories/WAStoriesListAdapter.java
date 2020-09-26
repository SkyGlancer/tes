/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.wastories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WAStoriesListAdapter
extends PagerAdapter {
    private Context context;
    private Integer[] images;
    private LayoutInflater layoutInflater;

    public WAStoriesListAdapter(Context context) {
        Integer[] arrinteger = new Integer[]{2131231246, 2131231238, 2131231239};
        this.images = arrinteger;
        this.context = context;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        ((ViewPager)viewGroup).removeView((View)object);
    }

    public int getCount() {
        return this.images.length;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        LayoutInflater layoutInflater;
        this.layoutInflater = layoutInflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
        View view = layoutInflater.inflate(2131558620, null);
        ((ImageView)view.findViewById(2131362143)).setImageResource(this.images[n].intValue());
        ((ViewPager)viewGroup).addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

