/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.network.model.EditProductRequest
 *  app.dukhaan.ui.products.-$
 *  app.dukhaan.ui.products.-$$Lambda
 *  app.dukhaan.ui.products.-$$Lambda$vFdgz803SKE1ozQEtdkqSYjnbl8
 *  app.dukhaan.ui.products.-$$Lambda$w2WqVRaY4XJjLtkrtPJDZR0cmN0
 *  app.dukhaan.ui.products.ProductsFragment$1
 *  app.dukhaan.ui.products.ProductsFragment$2
 *  app.dukhaan.ui.products.ProductsFragment$3
 *  app.dukhaan.ui.products.ProductsNavigator
 *  app.dukhaan.ui.products.ProductsViewModel
 *  app.dukhaan.ui.views.products.ProductListAdapter
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.schedulers.Schedulers
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
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
import app.dukhaan.ui.products.-$;
import app.dukhaan.ui.products.-$$Lambda$ProductsFragment$Bi-9FwoD4F0VBLM_uWbJq3ZDp1I;
import app.dukhaan.ui.products.-$$Lambda$ProductsFragment$N2BRs4aRrMG0LQkn1CW6jtzUi18;
import app.dukhaan.ui.products.-$$Lambda$ProductsFragment$hYR4QXupOturlq9F72PSWgAX17g;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.ui.products.ProductsNavigator;
import app.dukhaan.ui.products.ProductsViewModel;
import app.dukhaan.ui.views.EmptyDataCard;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.products.ProductListAdapter;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProductsFragment
extends BaseFragment<FragmentProductsBinding, ProductsViewModel>
implements ProductsNavigator,
ProductListAdapter.ProductMenuItemClickListener,
ProductListAdapter.ProductItemClick,
IdialogItemClickListner {
    private static final String ORG_CATEGORY_ID = "";
    private static final String ORG_FULL_DETAILS = "";
    public static int PAGE_NUMBER = 1;
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

    static /* synthetic */ int access$000(ProductsFragment productsFragment) {
        return productsFragment.visibleItemCount;
    }

    static /* synthetic */ int access$002(ProductsFragment productsFragment, int n) {
        productsFragment.visibleItemCount = n;
        return n;
    }

    static /* synthetic */ LinearLayoutManager access$100(ProductsFragment productsFragment) {
        return productsFragment.mLayoutManager;
    }

    static /* synthetic */ int access$200(ProductsFragment productsFragment) {
        return productsFragment.totalItemCount;
    }

    static /* synthetic */ int access$202(ProductsFragment productsFragment, int n) {
        productsFragment.totalItemCount = n;
        return n;
    }

    static /* synthetic */ int access$300(ProductsFragment productsFragment) {
        return productsFragment.pastVisibleItems;
    }

    static /* synthetic */ int access$302(ProductsFragment productsFragment, int n) {
        productsFragment.pastVisibleItems = n;
        return n;
    }

    static /* synthetic */ boolean access$400(ProductsFragment productsFragment) {
        return productsFragment.loading;
    }

    static /* synthetic */ boolean access$402(ProductsFragment productsFragment, boolean bl) {
        productsFragment.loading = bl;
        return bl;
    }

    static /* synthetic */ int access$500(ProductsFragment productsFragment) {
        return productsFragment.businessId;
    }

    static /* synthetic */ boolean access$600(ProductsFragment productsFragment) {
        return productsFragment.isCategoryProducts;
    }

    static /* synthetic */ ProductsViewModel access$700(ProductsFragment productsFragment) {
        return productsFragment.productsViewModel;
    }

    static /* synthetic */ void access$800(ProductsFragment productsFragment, String string2) {
        productsFragment.performSearch(string2);
    }

    private void getProducts(int n, int n2, boolean bl) {
        this.productsViewModel.fetchProducts(n, n2, bl);
    }

    public static ProductsFragment newInstance(boolean bl, int n, Category category) {
        PAGE_NUMBER = 1;
        ProductsFragment productsFragment = new ProductsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("Category", (Parcelable)category);
        bundle.putBoolean("", bl);
        bundle.putInt("", n);
        productsFragment.setArguments(bundle);
        return productsFragment;
    }

    private void performSearch(String string2) {
        this.productsViewModel.searchProduct(this.business.realmGet$id(), string2);
    }

    private DisposableObserver<TextViewTextChangeEvent> searchQuery() {
        return new 3(this);
    }

    public int getLayoutId() {
        return 2131558502;
    }

    protected Class<ProductsViewModel> getViewModel() {
        return ProductsViewModel.class;
    }

    public /* synthetic */ void lambda$onCreateView$0$ProductsFragment(View view) {
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditProductActivity.class).putExtra("Category", (Parcelable)this.category), 111);
    }

    public /* synthetic */ void lambda$onCreateView$1$ProductsFragment(View view) {
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditProductActivity.class).putExtra("Category", (Parcelable)this.category), 111);
    }

    public /* synthetic */ void lambda$onCreateView$2$ProductsFragment(View view) {
        this.productsBinding.search.setText(null);
        this.showDataFromDB();
        this.productsBinding.closeButton.setVisibility(4);
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        if (n == 111 && n2 == -1) {
            boolean bl = intent.getBooleanExtra("refresh", false);
            if (intent.getBooleanExtra("productAdded", false)) {
                this.showToast(this.getString(2131951876));
            }
            if (bl) {
                this.refreshProductList();
            }
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
        SwipeRefreshHideEvent swipeRefreshHideEvent = new SwipeRefreshHideEvent();
        EventBus.getDefault().post((Object)swipeRefreshHideEvent);
        this.productsBinding.progressBar.setVisibility(8);
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof MainActivity) {
            ModalDialogs.showUnknownError((Activity)fragmentActivity);
            return;
        }
        if (fragmentActivity instanceof CategoryDetailActivity) {
            ModalDialogs.showUnknownError((Activity)fragmentActivity);
        }
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && this.isVisible()) {
            PAGE_NUMBER = 1;
            this.productsViewModel.fetchProducts(this.businessId, 1, this.isCategoryProducts);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PAGE_NUMBER = 1;
        if (this.getArguments() != null) {
            this.fromCategory = this.getArguments().getBoolean("");
            this.businessId = this.getArguments().getInt("");
            this.isCategoryProducts = this.fromCategory;
            this.category = (Category)this.getArguments().getParcelable("Category");
        }
    }

    protected void onCreateView(Bundle bundle, ProductsViewModel productsViewModel, FragmentProductsBinding fragmentProductsBinding, Context context) {
        Business business;
        this.productsBinding = fragmentProductsBinding;
        this.productsViewModel = productsViewModel;
        this.mActivity.onFragmentAttached(this);
        this.productsViewModel.setNavigator((Object)this);
        this.setHasOptionsMenu(true);
        this.productListAdapter = new ProductListAdapter((ProductListAdapter.ProductMenuItemClickListener)this, this.productArrayList, (ProductListAdapter.ProductItemClick)new -$.Lambda.vFdgz803SKE1ozQEtdkqSYjnbl8(this));
        this.mLayoutManager = new LinearLayoutManager((Context)this.getActivity(), 1, false);
        fragmentProductsBinding.recyclerview.setLayoutManager((RecyclerView.LayoutManager)this.mLayoutManager);
        this.productsBinding.recyclerview.setAdapter((RecyclerView.Adapter)this.productListAdapter);
        this.business = business = productsViewModel.getDataManager().getBusiness();
        if (this.fromCategory) {
            this.businessId = business.realmGet$id();
        }
        this.productsBinding.startListing.setOnClickListener(new -$$Lambda$ProductsFragment$N2BRs4aRrMG0LQkn1CW6jtzUi18(this));
        this.productsBinding.startListingFixed.setOnClickListener(new -$$Lambda$ProductsFragment$hYR4QXupOturlq9F72PSWgAX17g(this));
        this.showFullscreenProgress();
        productsViewModel.fetchProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
        fragmentProductsBinding.swipeRefresh.setProgressBackgroundColorSchemeColor(this.getResources().getColor(2131099728));
        fragmentProductsBinding.swipeRefresh.setColorSchemeResources(new int[]{2131099737, 2131099737, 2131099737});
        this.productsBinding.closeButton.setOnClickListener((View.OnClickListener)new -$$Lambda$ProductsFragment$Bi-9FwoD4F0VBLM_uWbJq3ZDp1I(this));
        this.disposable.add((Disposable)RxTextView.textChangeEvents((TextView)this.productsBinding.search).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(this.searchQuery()));
        this.productsBinding.recyclerview.addOnScrollListener((RecyclerView.OnScrollListener)new 1(this, fragmentProductsBinding, productsViewModel));
        this.productsBinding.swipeRefresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)new 2(this));
    }

    @Override
    public void onDeleteProductClicked(int n) {
        this.position = n;
        ModalDialogs.showCustomDialog((Context)this.getActivity(), DialogType.DELETE, (IdialogItemClickListner)new -$.Lambda.w2WqVRaY4XJjLtkrtPJDZR0cmN0(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.productsBinding = null;
        CompositeDisposable compositeDisposable = this.disposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    @Override
    public void onEditProductClicked(int n) {
        Product product = (Product)this.productArrayList.get(n);
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditProductActivity.class).putExtra("PRODUCT", (Parcelable)product).putExtra("Add", true).putExtra("Category", (Parcelable)this.category).putExtra("position", n), 111);
    }

    @Override
    public void onItemClickListener(int n) {
        Product product = (Product)this.productArrayList.get(n);
        this.startActivityForResult(new Intent((Context)this.getActivity(), EditProductActivity.class).putExtra("PRODUCT", (Parcelable)product).putExtra("Add", true).putExtra("Category", (Parcelable)this.category).putExtra("position", n), 111);
    }

    public void onProductDelete(DeleteProductResponse deleteProductResponse, int n) {
        if (deleteProductResponse != null) {
            this.productsBinding.progressBar.setVisibility(8);
            this.productArrayList.remove(n);
            this.productListAdapter.notifyDataSetChanged();
            if (this.productArrayList.size() > 0) {
                this.productsBinding.recyclerview.setVisibility(0);
                this.showEmptyData(false);
            } else {
                this.productsBinding.recyclerview.setVisibility(8);
                this.showEmptyData(true);
            }
            FragmentActivity fragmentActivity = this.getActivity();
            if (fragmentActivity instanceof CategoryDetailActivity) {
                List<Product> list = this.productArrayList;
                int n2 = list == null ? 0 : list.size();
                CategoryDetailActivity.PRODUCT_COUNT = n2;
                ((CategoryDetailActivity)fragmentActivity).refreshProductCount();
            }
        }
    }

    public void onProductUpdateResponse(EditProductResponse editProductResponse, boolean bl) {
        Context context = this.getContext();
        int n = bl ? 2131951912 : 2131951914;
        Toast.makeText((Context)context, (int)n, (int)1).show();
        PAGE_NUMBER = 1;
        this.getProducts(this.businessId, 1, this.isCategoryProducts);
    }

    public void onResume() {
        super.onResume();
    }

    @Override
    public void onShareProductClicked(int n) {
        Business business = this.productsViewModel.getDataManager().getBusiness();
        Product product = (Product)this.productArrayList.get(n);
        if (business != null && product != null) {
            AppUtils.shareProduct(this.getContext(), business.realmGet$id(), product.getName(), product.getId(), product.getBaseCost(), AppUtils.getProductLink(business.realmGet$link(), product.getCategoryId(), product.getId()), AppPref.getInstance().getMobile(), product.getImage());
        }
    }

    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSwitchIconClicked(int n) {
        this.updateProductApi((Product)this.productArrayList.get(n));
    }

    public void refreshProductList() {
        this.productsViewModel.fetchProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
    }

    public void searchProducts(List<Product> list) {
        SwipeRefreshHideEvent swipeRefreshHideEvent = new SwipeRefreshHideEvent();
        EventBus.getDefault().post((Object)swipeRefreshHideEvent);
        if (list.size() > 0) {
            this.productArrayList.clear();
            this.productArrayList.addAll(list);
        } else {
            this.productArrayList.clear();
        }
        if (this.productArrayList.size() > 0) {
            this.productListAdapter.notifyDataSetChanged();
            this.productsBinding.emptyData.setVisibility(8);
            this.productsBinding.recyclerview.setVisibility(0);
        } else {
            this.productsBinding.recyclerview.setVisibility(8);
            this.productsBinding.emptyData.setData(this.getString(2131951881));
            this.productsBinding.emptyData.setVisibility(0);
        }
        this.productsBinding.startListingFixed.setVisibility(8);
    }

    public void showDataFromDB() {
        PAGE_NUMBER = 1;
        this.productListAdapter.notifyDataSetChanged();
        this.getProducts(this.businessId, PAGE_NUMBER, this.isCategoryProducts);
    }

    public void showEmptyData(boolean bl) {
        this.productsBinding.emptyData.setData(this.getString(2131951880));
        EmptyDataCard emptyDataCard = this.productsBinding.emptyData;
        int n = bl ? 0 : 8;
        emptyDataCard.setVisibility(n);
        PrimaryButton primaryButton = this.productsBinding.startListing;
        int n2 = bl ? 0 : 8;
        primaryButton.setVisibility(n2);
        PrimaryButtonShadowed primaryButtonShadowed = this.productsBinding.startListingFixed;
        int n3 = 0;
        if (bl) {
            n3 = 8;
        }
        primaryButtonShadowed.setVisibility(n3);
    }

    public void showProducts(List<Product> list, boolean bl) {
        FragmentActivity fragmentActivity;
        this.productsBinding.progressBar.setVisibility(8);
        this.productsBinding.swipeRefresh.setRefreshing(false);
        this.hideFullscreenProgress();
        if (list != null && list.size() > 0) {
            if (PAGE_NUMBER == 1) {
                this.productArrayList.clear();
            }
            if (bl) {
                this.loading = false;
            } else {
                PAGE_NUMBER = 1 + PAGE_NUMBER;
                this.loading = true;
            }
            this.productArrayList.addAll(list);
        } else {
            this.productArrayList.clear();
        }
        if (this.productArrayList.size() > 0) {
            this.productListAdapter.notifyDataSetChanged();
            this.showEmptyData(false);
            this.productsBinding.recyclerview.setVisibility(0);
            if (this.productArrayList.size() == 10) {
                CleverTapUtils.track10ProductsAdded((Context)this.getActivity(), this.businessId);
            }
        } else {
            this.productsBinding.recyclerview.setVisibility(8);
            this.showEmptyData(true);
        }
        if ((fragmentActivity = this.getActivity()) instanceof CategoryDetailActivity) {
            List<Product> list2 = this.productArrayList;
            int n = list2 == null ? 0 : list2.size();
            CategoryDetailActivity.PRODUCT_COUNT = n;
            ((CategoryDetailActivity)fragmentActivity).refreshProductCount();
        }
    }

    public void showToast(String string2) {
        Toast.makeText((Context)this.getActivity(), (CharSequence)string2, (int)1).show();
    }

    public void updateProductApi(Product product) {
        EditProductRequest editProductRequest = new EditProductRequest();
        editProductRequest.setName(product.getName());
        editProductRequest.setBaseQty(product.getBaseQty());
        editProductRequest.setDescription(product.getDescription());
        editProductRequest.setImage(product.getImage());
        editProductRequest.setBaseCost(product.getBaseCost());
        editProductRequest.setHidden(true ^ product.isHidden());
        editProductRequest.setCategory(product.getCategoryId());
        editProductRequest.setOriginalCost(product.getOriginalCost());
        this.productsViewModel.updateProduct(editProductRequest, product.getId());
    }

    @Override
    public void yesMakeIt() {
        Product product = (Product)this.productArrayList.get(this.position);
        this.productsViewModel.deleteProduct(product.getId(), this.position);
    }
}

