package app.dukhaan.ui.ui.views.categories;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import app.dukhaan.databinding.LayoutCategoryBinding;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.views.categories.CategoryListItemCard.2;
import app.dukhaan.ui.views.categories.CategoryListItemCard.3;
import app.dukhaan.ui.views.categories.CategoryListItemCard.4;

public class CategoryListItemCard extends FrameLayout {
   Category category;
   LayoutCategoryBinding listItemBinding;
   app.dukhaan.ui.views.categories.CategoryListItemCard.MenuItemClickedListener listener;

   public CategoryListItemCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public CategoryListItemCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public CategoryListItemCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      if (this.category != null) {
         this.listItemBinding.idBtnMenu.setOnClickListener(new _$$Lambda$CategoryListItemCard$_Y3DJe8fen9PsLQQuCHT8BT0h0M(this));
      }
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.listItemBinding = LayoutCategoryBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void showCategoryMenu(View var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      int var3 = var2.heightPixels;
      var3 = var2.widthPixels;
      View var4 = LayoutInflater.from(this.getContext()).inflate(popup_category_menu, (ViewGroup)null, false);
      new LayoutParams(var3 - 5, -2);
      PopupWindow var7 = new PopupWindow(var4, var3, -2, false);
      var7.setTouchable(true);
      var7.setFocusable(true);
      var7.setOutsideTouchable(true);
      var3 = VERSION.SDK_INT;
      var7.showAsDropDown(var1);
      TextView var6 = (TextView)var4.findViewById(btnEditCategory);
      TextView var5 = (TextView)var4.findViewById(btnShareCategory);
      TextView var8 = (TextView)var4.findViewById(idBtnDeleteCategory);
      var6.setOnClickListener(new 2(this, var7));
      var5.setOnClickListener(new 3(this, var7));
      var8.setOnClickListener(new 4(this, var7));
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.applyStyle();
   }

   public void setData(Category var1) {
      try {
         this.category = var1;
         this.listItemBinding.idLblCategoryTitle.setText(var1.realmGet$name());
         this.listItemBinding.idLblQty.setText(this.getResources().getString(R.string.lbl_procuts_listed_count, new Object[]{var1.realmGet$productCount()}));
         this.applyStyle();
      } catch (Exception var2) {
      }

   }

   public void setMenuClickListener(app.dukhaan.ui.views.categories.CategoryListItemCard.MenuItemClickedListener var1) {
      this.listener = var1;
   }
}
