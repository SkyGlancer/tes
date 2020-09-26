package app.dukhaan.ui.ui.editproduct;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.AddProductRequest;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.ui.editproduct.EditProductNavigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody.Part;

public class EditProductViewModel extends BaseViewModel<EditProductNavigator> {
   private MutableLiveData<UploadImage> uploadImageMutableLiveData;

   public EditProductViewModel(DataRepository var1, ApiService var2) {
      super(var1, var2);
   }

   public void addProduct(int var1, AddProductRequest var2) {
      this.getCompositeDisposable().add(this.getApiService().addProduct(var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$Clqrtbo_7OwunCfnuscsvbZPEOE(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditProductViewModel$VdInaOoDzDu39Po1V_JVDQ8XuPY(this)).subscribe(new _$$Lambda$EditProductViewModel$SiDAzW_ebJVsBeD4DJs94aZBbV0(this), new _$$Lambda$EditProductViewModel$qj03JZw6A7UCfwtDGoksDf5mkvI(this)));
   }

   public void deleteProduct(int var1) {
      this.getCompositeDisposable().add(this.getApiService().deleteProduct(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$QGtxwp1n0c0pJdy2_cJ_Dr5ldn0(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditProductViewModel$hZq2BvLquxRWX_tklatMqmONS8c(this)).subscribe(new _$$Lambda$EditProductViewModel$DVOFONTTc5Bcpzwejh9P9gcCayE(this), new _$$Lambda$EditProductViewModel$ws9Kqpn0pXYHm2AnTcEWoWiFMS4(this)));
   }

   public void getCategoryList(int var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().getCategories(var1, var2).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$bTun5_C3KopkL_kHxhmfL1FVFYI(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditProductViewModel$LdYU1t_a2wGe9NuBjWR_c96i3L8(this)).subscribe(new _$$Lambda$EditProductViewModel$GMiU85gjIQ2vWZY2ZDF2bs7r7QM(this), new _$$Lambda$EditProductViewModel$sKfK1zaEmvBya8mNiwTUk9KVsUY(this)));
   }

   public MutableLiveData<UploadImage> getImageData() {
      return this.uploadImageMutableLiveData;
   }

   public void getVariants(int var1) {
      this.getCompositeDisposable().add(this.getApiService().getVariants(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$xlHPmyVJNRUwd4m6XVKwIn0H70o(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditProductViewModel$7TGkBwuaDCA_Ww8ayvmW0541GwM(this)).subscribe(new _$$Lambda$EditProductViewModel$18_JHhfWGzVbb2nBvNtsvSWt6_M(this), new _$$Lambda$EditProductViewModel$yRLN7emghYi3HtwtyXx_hqtWatA(this)));
   }

   public void updateProduct(EditProductRequest var1, int var2) {
      this.getCompositeDisposable().add(this.getApiService().editProduct(var2, var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$2Q3nj1fP29eKx81pz_qq__Abub4(this)).observeOn(AndroidSchedulers.mainThread()).doFinally(new _$$Lambda$EditProductViewModel$kixlmu4byGjNHkoAkcOuccZHlxA(this)).subscribe(new _$$Lambda$EditProductViewModel$9__pF_7eX8tEtmZCHUoQAMLwTVU(this), new _$$Lambda$EditProductViewModel$rJ8rrazqM5sL1XvxhOTlFoTA7to(this)));
   }

   public void uploadImage(Part var1, String var2, int var3, int var4) {
      this.getCompositeDisposable().add(this.getApiService().uploadImage(var1).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$EditProductViewModel$8MDOdoTwc2_22mjXHO3AsjmQ_60(this)).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(_$$Lambda$EditProductViewModel$09TQVjruGTPh4hSu95K9HHf5N_s.INSTANCE).doFinally(new _$$Lambda$EditProductViewModel$FVrnbClEPzFtrA_LnaYCb7V0dUw(this)).subscribe(new _$$Lambda$EditProductViewModel$I0iGBLG0sfl59e6hTOSaba5KvPQ(this, var2, var3, var4), new _$$Lambda$EditProductViewModel$rq7USNi_9YXkzvymsbOo83rOKYk(this)));
   }
}
