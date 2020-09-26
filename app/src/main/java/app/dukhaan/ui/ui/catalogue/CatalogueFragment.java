package app.dukhaan.ui.ui.catalogue;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.databinding.FragmentCatalogueBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.catalogue.CatalogueFragment.1;
import app.dukhaan.ui.catalogue.CatalogueNavigator;
import app.dukhaan.ui.catalogue.CatalogueViewModel;
import app.dukhaan.ui.products.ProductsFragment;
import com.google.android.material.tabs.TabLayout;

public class CatalogueFragment extends BaseFragment<FragmentCatalogueBinding, CatalogueViewModel> implements CatalogueNavigator {
   private FragmentCatalogueBinding binding;
   private Fragment fragment;
   private FragmentManager fragmentManager;
   private FragmentTransaction fragmentTransaction;
   private CatalogueViewModel mViewModel;

   public CatalogueFragment() {
   }

   private void inflateFragment(Fragment var1) {
      FragmentManager var2 = this.getParentFragmentManager();
      this.fragmentManager = var2;
      FragmentTransaction var3 = var2.beginTransaction();
      this.fragmentTransaction = var3;
      var3.replace(this.binding.frameLayout.getId(), var1);
      this.fragmentTransaction.setTransition(4097);
      this.fragmentTransaction.commit();
   }

   public static CatalogueFragment newInstance() {
      CatalogueFragment var0 = new CatalogueFragment();
      var0.setArguments(new Bundle());
      return var0;
   }

   public int getLayoutId() {
      return design_layout_snackbar;
   }

   protected Class<CatalogueViewModel> getViewModel() {
      return CatalogueViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreateView(Bundle var1, CatalogueViewModel var2, FragmentCatalogueBinding var3, Context var4) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      TabLayout var5 = var3.tabLayout;
      FrameLayout var6 = var3.frameLayout;
      ProductsFragment var7 = new ProductsFragment();
      this.fragment = var7;
      this.inflateFragment(var7);
      var5.setOnTabSelectedListener(new 1(this));
   }
}
