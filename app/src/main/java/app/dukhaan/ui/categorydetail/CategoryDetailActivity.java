/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityCategoryDetailBinding
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.ui.categorydetail.CategoryDetailNaivigator
 *  app.dukhaan.ui.categorydetail.CategoryDetailViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.categorydetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityCategoryDetailBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.ui.categorydetail.-$$Lambda$CategoryDetailActivity$mZkJjaEZGBn3qNpi5BT2cD-9fXM;
import app.dukhaan.ui.categorydetail.CategoryDetailNaivigator;
import app.dukhaan.ui.categorydetail.CategoryDetailViewModel;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CategoryDetailActivity
extends BaseActivity<ActivityCategoryDetailBinding, CategoryDetailViewModel>
implements CategoryDetailNaivigator {
    public static int PRODUCT_COUNT;
    static boolean active;
    ActivityCategoryDetailBinding binding;
    int businessId = 0;
    Category category;
    String categoryName = "";
    CategoryDetailViewModel viewModel;

    private void loadProductFragment() {
        Category category = this.category;
        if (category == null) {
            return;
        }
        ProductsFragment productsFragment = ProductsFragment.newInstance(false, this.businessId, category);
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(2131362404, (Fragment)productsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public int getLayoutId() {
        return 2131558433;
    }

    @Override
    public Class<CategoryDetailViewModel> getViewModel() {
        return CategoryDetailViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$CategoryDetailActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
            this.loadProductFragment();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("refresh", true);
        this.setResult(-1, intent);
        this.finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle, CategoryDetailViewModel categoryDetailViewModel, ActivityCategoryDetailBinding activityCategoryDetailBinding) {
        Category category;
        this.binding = activityCategoryDetailBinding;
        this.viewModel = categoryDetailViewModel;
        categoryDetailViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityCategoryDetailBinding.toolbar);
        this.enableToolbarUpNavigation();
        this.category = category = (Category)this.getIntent().getParcelableExtra("category");
        if (category != null) {
            this.businessId = category.realmGet$id();
            this.categoryName = this.category.realmGet$name();
            PRODUCT_COUNT = this.category.realmGet$productCount();
        }
        activityCategoryDetailBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$CategoryDetailActivity$mZkJjaEZGBn3qNpi5BT2cD-9fXM(this));
        this.loadProductFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.refreshProductCount();
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    public void onStop() {
        super.onStop();
        active = false;
    }

    public void refreshProductCount() {
        if (PRODUCT_COUNT > 0) {
            TextView textView = this.binding.toolTitle;
            Object[] arrobject = new Object[]{this.categoryName, String.valueOf((int)PRODUCT_COUNT)};
            textView.setText((CharSequence)this.getString(2131951669, arrobject));
            return;
        }
        this.binding.toolTitle.setText((CharSequence)this.categoryName);
    }
}

