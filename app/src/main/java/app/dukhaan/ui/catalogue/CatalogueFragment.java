/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.widget.FrameLayout
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.ui.catalogue.CatalogueFragment$1
 *  app.dukhaan.ui.catalogue.CatalogueNavigator
 *  app.dukhaan.ui.catalogue.CatalogueViewModel
 *  com.google.android.material.tabs.TabLayout
 *  com.google.android.material.tabs.TabLayout$OnTabSelectedListener
 *  java.lang.Class
 *  java.lang.Object
 */
package app.dukhaan.ui.catalogue;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.FragmentCatalogueBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.catalogue.CatalogueFragment;
import app.dukhaan.ui.catalogue.CatalogueNavigator;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import app.dukhaan.ui.products.ProductsFragment;
import com.google.android.material.tabs.TabLayout;

public class CatalogueFragment
extends BaseFragment<FragmentCatalogueBinding, CatalogueViewModel>
implements CatalogueNavigator {
    private FragmentCatalogueBinding binding;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private CatalogueViewModel mViewModel;

    static /* synthetic */ Fragment access$000(CatalogueFragment catalogueFragment) {
        return catalogueFragment.fragment;
    }

    static /* synthetic */ Fragment access$002(CatalogueFragment catalogueFragment, Fragment fragment) {
        catalogueFragment.fragment = fragment;
        return fragment;
    }

    static /* synthetic */ void access$100(CatalogueFragment catalogueFragment, Fragment fragment) {
        catalogueFragment.inflateFragment(fragment);
    }

    private void inflateFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction;
        FragmentManager fragmentManager;
        this.fragmentManager = fragmentManager = this.getParentFragmentManager();
        this.fragmentTransaction = fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(this.binding.frameLayout.getId(), fragment);
        this.fragmentTransaction.setTransition(4097);
        this.fragmentTransaction.commit();
    }

    public static CatalogueFragment newInstance() {
        CatalogueFragment catalogueFragment = new CatalogueFragment();
        catalogueFragment.setArguments(new Bundle());
        return catalogueFragment;
    }

    public int getLayoutId() {
        return 2131558482;
    }

    protected Class<CatalogueViewModel> getViewModel() {
        return CatalogueViewModel.class;
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    protected void onCreateView(Bundle bundle, CatalogueViewModel catalogueViewModel, FragmentCatalogueBinding fragmentCatalogueBinding, Context context) {
        this.binding = fragmentCatalogueBinding;
        this.mViewModel = catalogueViewModel;
        catalogueViewModel.setNavigator((Object)this);
        TabLayout tabLayout = fragmentCatalogueBinding.tabLayout;
        ProductsFragment productsFragment = new ProductsFragment();
        this.fragment = productsFragment;
        this.inflateFragment((Fragment)productsFragment);
        tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener)new 1(this));
    }
}

