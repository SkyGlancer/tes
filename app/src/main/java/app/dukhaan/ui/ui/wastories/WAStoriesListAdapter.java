package app.dukhaan.ui.ui.wastories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WAStoriesListAdapter extends PagerAdapter {
   private Context context;
   private Integer[] images = new Integer[]{ic_mtrl_chip_checked_black, ic_location_pin, ic_map_blue_dot};
   private LayoutInflater layoutInflater;

   public WAStoriesListAdapter(Context var1) {
      this.context = var1;
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      ((ViewPager)var1).removeView((View)var3);
   }

   public int getCount() {
      return this.images.length;
   }

   public Object instantiateItem(ViewGroup var1, int var2) {
      LayoutInflater var3 = (LayoutInflater)this.context.getSystemService("layout_inflater");
      this.layoutInflater = var3;
      View var4 = var3.inflate(preference_widget_switch_compat, (ViewGroup)null);
      ((ImageView)var4.findViewById(idBtnMarathi)).setImageResource(this.images[var2]);
      ((ViewPager)var1).addView(var4, 0);
      return var4;
   }

   public boolean isViewFromObject(View var1, Object var2) {
      boolean var3;
      if (var1 == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
