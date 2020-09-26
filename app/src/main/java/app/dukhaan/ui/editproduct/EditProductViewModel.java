/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.MutableLiveData
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.schedulers.Schedulers
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  java.util.List
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 */
package app.dukhaan.ui.editproduct;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.data.model.Variant;
import app.dukhaan.data.model.VariantResponse;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.AddProductRequest;
import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$09TQVjruGTPh4hSu95K9HHf5N_s;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$18_JHhfWGzVbb2nBvNtsvSWt6-M;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$2Q3nj1fP29eKx81pz_qq_-Abub4;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$7TGkBwuaDCA-Ww8ayvmW0541GwM;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$8MDOdoTwc2_22mjXHO3AsjmQ-60;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$9__pF_7eX8tEtmZCHUoQAMLwTVU;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$Clqrtbo_7OwunCfnuscsvbZPEOE;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$DVOFONTTc5Bcpzwejh9P9gcCayE;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$FVrnbClEPzFtrA-LnaYCb7V0dUw;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$GMiU85gjIQ2vWZY2ZDF2bs7r7QM;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$I0iGBLG0sfl59e6hTOSaba5KvPQ;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$LdYU1t_a2wGe9NuBjWR_c96i3L8;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$QGtxwp1n0c0pJdy2_cJ_Dr5ldn0;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$SiDAzW_ebJVsBeD4DJs94aZBbV0;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$VdInaOoDzDu39Po1V-JVDQ8XuPY;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$bTun5_C3KopkL-kHxhmfL1FVFYI;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$hZq2BvLquxRWX-tklatMqmONS8c;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$kixlmu4byGjNHkoAkcOuccZHlxA;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$qj03JZw6A7UCfwtDGoksDf5mkvI;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$rJ8rrazqM5sL1XvxhOTlFoTA7to;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$rq7USNi_9YXkzvymsbOo83rOKYk;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$sKfK1zaEmvBya8mNiwTUk9KVsUY;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$ws9Kqpn0pXYHm2AnTcEWoWiFMS4;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$xlHPmyVJNRUwd4m6XVKwIn0H70o;
import app.dukhaan.ui.editproduct.-$$Lambda$EditProductViewModel$yRLN7emghYi3HtwtyXx_hqtWatA;
import app.dukhaan.ui.editproduct.EditProductNavigator;
import app.dukhaan.util.RetrofitUtils;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.MultipartBody;
import timber.log.Timber;

public class EditProductViewModel
extends BaseViewModel<EditProductNavigator> {
    private MutableLiveData<UploadImage> uploadImageMutableLiveData;

    public EditProductViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    static /* synthetic */ void lambda$uploadImage$9(UploadImage uploadImage) throws Exception {
        Timber.e("onResponse: %s", uploadImage);
    }

    public void addProduct(int n, AddProductRequest addProductRequest) {
        this.getCompositeDisposable().add(this.getApiService().addProduct(addProductRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$Clqrtbo_7OwunCfnuscsvbZPEOE(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditProductViewModel$VdInaOoDzDu39Po1V-JVDQ8XuPY(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$SiDAzW_ebJVsBeD4DJs94aZBbV0(this), (Consumer)new -$$Lambda$EditProductViewModel$qj03JZw6A7UCfwtDGoksDf5mkvI(this)));
    }

    public void deleteProduct(int n) {
        this.getCompositeDisposable().add(this.getApiService().deleteProduct(n).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$QGtxwp1n0c0pJdy2_cJ_Dr5ldn0(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditProductViewModel$hZq2BvLquxRWX-tklatMqmONS8c(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$DVOFONTTc5Bcpzwejh9P9gcCayE(this), (Consumer)new -$$Lambda$EditProductViewModel$ws9Kqpn0pXYHm2AnTcEWoWiFMS4(this)));
    }

    public void getCategoryList(int n, int n2) {
        this.getCompositeDisposable().add(this.getApiService().getCategories(n, n2).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$bTun5_C3KopkL-kHxhmfL1FVFYI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditProductViewModel$LdYU1t_a2wGe9NuBjWR_c96i3L8(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$GMiU85gjIQ2vWZY2ZDF2bs7r7QM(this), (Consumer)new -$$Lambda$EditProductViewModel$sKfK1zaEmvBya8mNiwTUk9KVsUY(this)));
    }

    public MutableLiveData<UploadImage> getImageData() {
        return this.uploadImageMutableLiveData;
    }

    public void getVariants(int n) {
        this.getCompositeDisposable().add(this.getApiService().getVariants(n).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$xlHPmyVJNRUwd4m6XVKwIn0H70o(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditProductViewModel$7TGkBwuaDCA-Ww8ayvmW0541GwM(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$18_JHhfWGzVbb2nBvNtsvSWt6-M(this), (Consumer)new -$$Lambda$EditProductViewModel$yRLN7emghYi3HtwtyXx_hqtWatA(this)));
    }

    public /* synthetic */ void lambda$addProduct$0$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$addProduct$1$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$addProduct$2$EditProductViewModel(AddProductResponse addProductResponse) throws Exception {
        AppPref.getInstance().setProductsAdded(true);
        ((EditProductNavigator)this.getNavigator()).productAdded(addProductResponse);
    }

    public /* synthetic */ void lambda$addProduct$3$EditProductViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$deleteProduct$21$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$deleteProduct$22$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$deleteProduct$23$EditProductViewModel(DeleteProductResponse deleteProductResponse) throws Exception {
        ((EditProductNavigator)this.getNavigator()).onProductDelete(deleteProductResponse);
    }

    public /* synthetic */ void lambda$deleteProduct$24$EditProductViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$getCategoryList$13$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getCategoryList$14$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getCategoryList$15$EditProductViewModel(CategoryListResponse categoryListResponse) throws Exception {
        ((EditProductNavigator)this.getNavigator()).onCategoryListFetched(categoryListResponse);
    }

    public /* synthetic */ void lambda$getCategoryList$16$EditProductViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$getVariants$4$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$getVariants$5$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$getVariants$6$EditProductViewModel(VariantResponse variantResponse) throws Exception {
        ((EditProductNavigator)this.getNavigator()).variantsFound(variantResponse.getVariants());
    }

    public /* synthetic */ void lambda$getVariants$7$EditProductViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) { in
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$updateProduct$17$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public /* synthetic */ void lambda$updateProduct$18$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$updateProduct$19$EditProductViewModel(EditProductResponse editProductResponse) throws Exception {
        ((EditProductNavigator)this.getNavigator()).onProductUpdateResponse(editProductResponse);
    }

    public /* synthetic */ void lambda$updateProduct$20$EditProductViewModel(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$uploadImage$10$EditProductViewModel() throws Exception {
        this.setIsLoading(false);
    }

    public /* synthetic */ void lambda$uploadImage$11$EditProductViewModel(String string2, int n, int n2, UploadImage uploadImage) throws Exception {
        ((EditProductNavigator)this.getNavigator()).onProductImageUploadedToCloud(uploadImage, string2, n, n2);
    }

    public /* synthetic */ void lambda$uploadImage$12$EditProductViewModel(Throwable throwable) throws Exception {
        Timber.e(throwable, "error!", new Object[0]);
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            ((EditProductNavigator)this.getNavigator()).onApiError(RetrofitUtils.getApiError(throwable));
        }
    }

    public /* synthetic */ void lambda$uploadImage$8$EditProductViewModel(Disposable disposable) throws Exception {
        this.setIsLoading(true);
    }

    public void updateProduct(EditProductRequest editProductRequest, int n) {
        this.getCompositeDisposable().add(this.getApiService().editProduct(n, editProductRequest).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$2Q3nj1fP29eKx81pz_qq_-Abub4(this)).observeOn(AndroidSchedulers.mainThread()).doFinally((Action)new -$$Lambda$EditProductViewModel$kixlmu4byGjNHkoAkcOuccZHlxA(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$9__pF_7eX8tEtmZCHUoQAMLwTVU(this), (Consumer)new -$$Lambda$EditProductViewModel$rJ8rrazqM5sL1XvxhOTlFoTA7to(this)));
    }

    public void uploadImage(MultipartBody.Part part, String string2, int n, int n2) {
        this.getCompositeDisposable().add(this.getApiService().uploadImage(part).subscribeOn(Schedulers.io()).doOnSubscribe((Consumer)new -$$Lambda$EditProductViewModel$8MDOdoTwc2_22mjXHO3AsjmQ-60(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess((Consumer)-$$Lambda$EditProductViewModel$09TQVjruGTPh4hSu95K9HHf5N_s.INSTANCE).doFinally((Action)new -$$Lambda$EditProductViewModel$FVrnbClEPzFtrA-LnaYCb7V0dUw(this)).subscribe((Consumer)new -$$Lambda$EditProductViewModel$I0iGBLG0sfl59e6hTOSaba5KvPQ(this, string2, n, n2), (Consumer)new -$$Lambda$EditProductViewModel$rq7USNi_9YXkzvymsbOo83rOKYk(this)));
    }
}

