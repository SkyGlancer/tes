package app.dukhaan.ui.ui.products;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.Product;
import app.dukhaan.databinding.FragmentProductsBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.network.model.SwipeRefreshHideEvent;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.products.ProductsFragment.1;
import app.dukhaan.ui.products.ProductsFragment.2;
import app.dukhaan.ui.products.ProductsFragment.3;
import app.dukhaan.ui.products.ProductsNavigator;
import app.dukhaan.ui.products.ProductsViewModel;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.products.ProductListAdapter;
import app.dukhaan.ui.views.products.ProductListAdapter.ProductItemClick;
import app.dukhaan.ui.views.products.ProductListAdapter.ProductMenuItemClickListener;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProductsFragment extends BaseFragment<FragmentProductsBinding, ProductsViewModel> implements ProductsNavigator, ProductMenuItemClickListener, ProductItemClick, IdialogItemClickListner {
   private static final String ORG_CATEGORY_ID = "";
   private static final String ORG_FULL_DETAILS = "";
   public static int PAGE_NUMBER;
   private Business business;
   private int businessId = 1;
   private Category category;
   private CompositeDisposable disposable = new CompositeDisposable();
   private boolean fromCategory = true;
   private boolean isCategoryProducts = true;
   private boolean loading = true;
   private LinearLayoutManager mLayoutManager;
   private int pastVisibleItems;
   int position = 0;
   private List<Product> productArrayList = new ArrayList();
   ProductListAdapter productListAdapter;
   FragmentProductsBinding productsBinding;
   private ProductsViewModel productsViewModel;
   private int totalItemCount;
   private int visibleItemCount;

   public ProductsFragment() {
   }

   private void getProducts(int var1, int var2, boolean var3) {
      this.productsViewModel.fetchProducts(var1, var2, var3);
   }

   public static ProductsFragment newInstance(boolean var0, int var1, Category var2) {
      PAGE_NUMBER = 1;
      ProductsFragment var3 = new ProductsFragment();
      Bundle var4 = new Bundle();
      var4.putParcelable("Category", var2);
      var4.putBoolean("", var0);
      var4.putInt("", var1);
      var3.setArguments(var4);
      return var3;
   }

   private void performSearch(String var1) {
      this.productsViewModel.searchProduct(this.business.realmGet$id(), var1);
   }

   private DisposableObserver<TextViewTextChangeEvent> searchQuery() {
      return new 3(this);
   }

   public int getLayoutId() {
      return fragment_products;
   }

   protected Class<ProductsViewModel> getViewModel() {
      return ProductsViewModel.class;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 111 && var2 == -1) {
         boolean var4 = var3.getBooleanExtra("refresh", false);
         if (var3.getBooleanExtra("productAdded", false)) {
            this.showToast(this.getString(R.string.new_product_added));
         }

         if (var4) {
            this.refreshProductList();
         }
      }

   }

   public void onApiError(ErrorResponse var1) {
      SwipeRefreshHideEvent var2 = new SwipeRefreshHideEvent();
      EventBus.getDefault().post(var2);
      this.productsBinding.progressBar.setVisibility(8);
      FragmentActivity var3 = this.getActivity();
      if (var3 instanceof MainActivity) {
         ModalDialogs.showUnknownError(var3);
      } else if (var3 instanceof CategoryDetailActivity) {
         ModalDialogs.showUnknownError(var3);
      }

   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      if (var1.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
         PAGE_NUMBER = 1;
         this.productsViewModel.fetchProducts(this.businessId, 1, this.isCategoryProducts);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      PAGE_NUMBER = 1;
      if (this.getArguments() != null) {
         this.fromCategory = this.getArguments().getBoolean("");
         this.businessId = this.getArguments().getInt("");
         this.isCategoryProducts = this.fromCategory;
         this.category = (Category)this.getArguments().getParcelable("Category");
      }

   }

   protected void onCreateView(Bundle var1, ProductsViewModel var2, FragmentProductsBinding var3, Context var4) {
      this.productsBinding = var3;
      this.productsViewModel = var2;
      this.mActivity.onFragmentAttached(this);
      this.productsViewModel.setNavigator(this);
      this.setHasOptionsMenu(true);
      this.productListAdapter = new ProductListAdapter(this, this.productArrayList, new _$$Lambda$vFdgz803SKE1ozQEtdkqSYjnbl8(this));
      this.mLayoutManager = new LinearLayoutManager(this.getActivity(), 1, false);
      var3.recyclerview.setLayoutManager(this.mLayoutManager);
      this.productsBinding.recyclerview.setAdapter(this.productListAdapter);
      Business var5 = var2.getDataManager().getBusiness();
      this.business = var5;
      if (this.fromCategory) {
         this.businessId = var5.realmGet$id();
      }

      this.productsBinding.startListing.setOnClickListener(new _$$Lambda$ProductsFragment$N2BRs4aRrMG0LQkn1CW6jtzUi18(this));
      this.productsBinding.startListingFixed.setOnClickListener(new _$$Lambda$ProductsFragment$hYR4QXupOturlq9F72PSWgAX17g(this));
      this.showFullscreenProgress();
      var2.fetchProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
      var3.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(R.color.colorPrimary));
      var3.swipeRefresh.setColorSchemeResources(new int[]{colorWhite, colorWhite, colorWhite});
      this.productsBinding.closeButton.setOnClickListener(new _$$Lambda$ProductsFragment$Bi_9FwoD4F0VBLM_uWbJq3ZDp1I(this));
      this.disposable.add((Disposable)RxTextView.textChangeEvents(this.productsBinding.search).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(this.searchQuery()));
      this.productsBinding.recyclerview.addOnScrollListener(new 1(this, var3, var2));
      this.productsBinding.swipeRefresh.setOnRefreshListener(new 2(this));
   }

   public void onDeleteProductClicked(int var1) {
      this.position = var1;
      ModalDialogs.showCustomDialog(this.getActivity(), DialogType.DELETE, new _$$Lambda$w2WqVRaY4XJjLtkrtPJDZR0cmN0(this));
   }

   public void onDestroyView() {
      super.onDestroyView();
      this.productsBinding = null;
      CompositeDisposable var1 = this.disposable;
      if (var1 != null) {
         var1.dispose();
      }

   }

   public void onEditProductClicked(int var1) {
      Product var2 = (Product)this.productArrayList.get(var1);
      this.startActivityForResult((new Intent(this.getActivity(), EditProductActivity.class)).putExtra("PRODUCT", var2).putExtra("Add", true).putExtra("Category", this.category).putExtra("position", var1), 111);
   }

   public void onItemClickListener(int var1) {
      Product var2 = (Product)this.productArrayList.get(var1);
      this.startActivityForResult((new Intent(this.getActivity(), EditProductActivity.class)).putExtra("PRODUCT", var2).putExtra("Add", true).putExtra("Category", this.category).putExtra("position", var1), 111);
   }

   public void onProductDelete(DeleteProductResponse var1, int var2) {
      if (var1 != null) {
         this.productsBinding.progressBar.setVisibility(8);
         this.productArrayList.remove(var2);
         this.productListAdapter.notifyDataSetChanged();
         int var3 = this.productArrayList.size();
         var2 = 0;
         if (var3 > 0) {
            this.productsBinding.recyclerview.setVisibility(0);
            this.showEmptyData(false);
         } else {
            this.productsBinding.recyclerview.setVisibility(8);
            this.showEmptyData(true);
         }

         FragmentActivity var5 = this.getActivity();
         if (var5 instanceof CategoryDetailActivity) {
            List var4 = this.productArrayList;
            if (var4 != null) {
               var2 = var4.size();
            }

            CategoryDetailActivity.PRODUCT_COUNT = var2;
            ((CategoryDetailActivity)var5).refreshProductCount();
         }
      }

   }

   public void onProductUpdateResponse(EditProductResponse var1, boolean var2) {
      Context var4 = this.getContext();
      int var3;
      if (var2) {
         var3 = product_hidden;
      } else {
         var3 = product_un_hidden;
      }

      Toast.makeText(var4, var3, 1).show();
      PAGE_NUMBER = 1;
      this.getProducts(this.businessId, 1, this.isCategoryProducts);
   }

   public void onResume() {
      super.onResume();
   }

   public void onShareProductClicked(int var1) {
      Business var2 = this.productsViewModel.getDataManager().getBusiness();
      Product var3 = (Product)this.productArrayList.get(var1);
      if (var2 != null && var3 != null) {
         AppUtils.shareProduct(this.getContext(), var2.realmGet$id(), var3.getName(), var3.getId(), var3.getBaseCost(), AppUtils.getProductLink(var2.realmGet$link(), var3.getCategoryId(), var3.getId()), AppPref.getInstance().getMobile(), var3.getImage());
      }

   }

   public void onStop() {
      super.onStop();
   }

   public void onSwitchIconClicked(int var1) {
      this.updateProductApi((Product)this.productArrayList.get(var1));
   }

   public void refreshProductList() {
      this.productsViewModel.fetchProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
   }

   public void searchProducts(List<Product> var1) {
      SwipeRefreshHideEvent var2 = new SwipeRefreshHideEvent();
      EventBus.getDefault().post(var2);
      if (var1.size() > 0) {
         this.productArrayList.clear();
         this.productArrayList.addAll(var1);
      } else {
         this.productArrayList.clear();
      }

      if (this.productArrayList.size() > 0) {
         this.productListAdapter.notifyDataSetChanged();
         this.productsBinding.emptyData.setVisibility(8);
         this.productsBinding.recyclerview.setVisibility(0);
      } else {
         this.productsBinding.recyclerview.setVisibility(8);
         this.productsBinding.emptyData.setData(this.getString(R.string.no_products_found));
         this.productsBinding.emptyData.setVisibility(0);
      }

      this.productsBinding.startListingFixed.setVisibility(8);
   }

   public void showDataFromDB() {
      PAGE_NUMBER = 1;
      this.productListAdapter.notifyDataSetChanged();
      this.getProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
   }

   public void showEmptyData(boolean var1) {
      this.productsBinding.emptyData.setData(this.getString(R.string.no_products));
      EmptyDataCard var2 = this.productsBinding.emptyData;
      byte var3 = 0;
      byte var4;
      if (var1) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var2.setVisibility(var4);
      PrimaryButton var5 = this.productsBinding.startListing;
      if (var1) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var5.setVisibility(var4);
      PrimaryButtonShadowed var6 = this.productsBinding.startListingFixed;
      var4 = var3;
      if (var1) {
         var4 = 8;
      }

      var6.setVisibility(var4);
   }

   public void showProducts(List<Product> var1, boolean var2) {
      this.productsBinding.progressBar.setVisibility(8);
      SwipeRefreshLayout var3 = this.productsBinding.swipeRefresh;
      int var4 = 0;
      var3.setRefreshing(false);
      this.hideFullscreenProgress();
      if (var1 != null && var1.size() > 0) {
         if (PAGE_NUMBER == 1) {
            this.productArrayList.clear();
         }

         if (var2) {
            this.loading = false;
         } else {
            ++PAGE_NUMBER;
            this.loading = true;
         }

         this.productArrayList.addAll(var1);
      } else {
         this.productArrayList.clear();
      }

      if (this.productArrayList.size() > 0) {
         this.productListAdapter.notifyDataSetChanged();
         this.showEmptyData(false);
         this.productsBinding.recyclerview.setVisibility(0);
         if (this.productArrayList.size() == 10) {
            CleverTapUtils.track10ProductsAdded(this.getActivity(), this.businessId);
         }
      } else {
         this.productsBinding.recyclerview.setVisibility(8);
         this.showEmptyData(true);
      }

      FragmentActivity var5 = this.getActivity();
      if (var5 instanceof CategoryDetailActivity) {
         List var6 = this.productArrayList;
         if (var6 != null) {
            var4 = var6.size();
         }

         CategoryDetailActivity.PRODUCT_COUNT = var4;
         ((CategoryDetailActivity)var5).refreshProductCount();
      }

   }

   public void showToast(String var1) {
      Toast.makeText(this.getActivity(), var1, 1).show();
   }

   public void updateProductApi(Product var1) {
      EditProductRequest var2 = new EditProductRequest();
      var2.setName(var1.getName());
      var2.setBaseQty(var1.getBaseQty());
      var2.setDescription(var1.getDescription());
      var2.setImage(var1.getImage());
      var2.setBaseCost(var1.getBaseCost());
      var2.setHidden(var1.isHidden() ^ true);
      var2.setCategory(var1.getCategoryId());
      var2.setOriginalCost(var1.getOriginalCost());
      this.productsViewModel.updateProduct(var2, var1.getId());
   }

   public void yesMakeIt() {
      Product var1 = (Product)this.productArrayList.get(this.position);
      this.productsViewModel.deleteProduct(var1.getId(), this.position);
   }
}
