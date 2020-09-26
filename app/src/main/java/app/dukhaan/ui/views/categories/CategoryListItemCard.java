/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  androidx.appcompat.widget.PopupMenu
 *  androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  app.dukhaan.databinding.LayoutCategoryBinding
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.ui.views.categories.CategoryListItemCard$1
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.categories;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.dukhaan.databinding.LayoutCategoryBinding;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.views.categories.-$$Lambda$CategoryListItemCard$-Y3DJe8fen9PsLQQuCHT8BT0h0M;
import app.dukhaan.ui.views.categories.CategoryListItemCard;

public class CategoryListItemCard
extends FrameLayout {
    Category category;
    LayoutCategoryBinding listItemBinding;
    MenuItemClickedListener listener;

    public CategoryListItemCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public CategoryListItemCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public CategoryListItemCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        if (this.category == null) {
            return;
        }
        this.listItemBinding.idBtnMenu.setOnClickListener((OnClickListener)new -$$Lambda$CategoryListItemCard$-Y3DJe8fen9PsLQQuCHT8BT0h0M(this));
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.listItemBinding = LayoutCategoryBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void showCategoryMenu(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int n = displayMetrics.widthPixels;
        View view2 = LayoutInflater.from((Context)this.getContext()).inflate(2131558600, null, false);
        new ConstraintLayout.LayoutParams(n - 5, -2);
        final PopupWindow popupWindow = new PopupWindow(view2, n, -2, false);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(view);
        TextView textView = (TextView)view2.findViewById(2131361909);
        TextView textView2 = (TextView)view2.findViewById(2131361912);
        TextView textView3 = (TextView)view2.findViewById(2131362140);
        textView.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {
                CategoryListItemCard.this.listener.onEditCategoryNameClicked();
                popupWindow.dismiss();
            }
        });
        textView2.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {
                CategoryListItemCard.this.listener.onShareCategoryClicked();
                popupWindow.dismiss();
            }
        });
        textView3.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {
                CategoryListItemCard.this.listener.onDeleteCategoryClicked();
                popupWindow.dismiss();
            }
        });
    }

    public /* synthetic */ void lambda$applyStyle$0$CategoryListItemCard(View view) {
        PopupMenu popupMenu = new PopupMenu(this.getContext(), (View)this.listItemBinding.idBtnMenu);
        popupMenu.setGravity(8388613);
        popupMenu.getMenuInflater().inflate(2131623937, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new 1(this));
        popupMenu.show();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.applyStyle();
    }

    public void setData(Category category) {
        try {
            this.category = category;
            this.listItemBinding.idLblCategoryTitle.setText((CharSequence)category.realmGet$name());
            TextView textView = this.listItemBinding.idLblQty;
            Resources resources = this.getResources();
            Object[] arrobject = new Object[]{category.realmGet$productCount()};
            textView.setText((CharSequence)resources.getString(2131951819, arrobject));
            this.applyStyle();
        }
        catch (Exception exception) {}
    }

    public void setMenuClickListener(MenuItemClickedListener menuItemClickedListener) {
        this.listener = menuItemClickedListener;
    }

    public static interface MenuItemClickedListener {
        public void onDeleteCategoryClicked();

        public void onEditCategoryNameClicked();

        public void onShareCategoryClicked();
    }

}

