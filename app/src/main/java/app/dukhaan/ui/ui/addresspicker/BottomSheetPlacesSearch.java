package app.dukhaan.ui.ui.addresspicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.databinding.BottomSheetPlacesSearchBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch.1;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch.2;
import app.dukhaan.ui.addresspicker.PlacesSearchAdapter;
import app.dukhaan.ui.addresspicker.PlacesSearchAdapter.PlacesAdapterItemClick;
import app.dukhaan.util.AppUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BottomSheetPlacesSearch extends BottomSheetDialogFragment implements PlacesAdapterItemClick {
   private app.dukhaan.ui.addresspicker.PlacesSearchAdapter adapter;
   private BottomSheetPlacesSearchBinding binding;
   private Context context;
   private CompositeDisposable disposable = new CompositeDisposable();
   private Location location;
   private String map_access_token = null;
   private String map_token_type = null;
   private app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch.OnPlacesClickListener onPlacesClickListener;
   private ArrayList<Prediction> predictionArrayList;
   private app.dukhaan.ui.addresspicker.AddressViewModel viewModel;

   public BottomSheetPlacesSearch() {
   }

   private int getWindowHeight() {
      DisplayMetrics var1 = new DisplayMetrics();
      ((Activity)this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(var1);
      return var1.heightPixels;
   }

   private DisposableObserver<TextViewTextChangeEvent> searchQuery() {
      return new 2(this);
   }

   private void setupFullHeight(BottomSheetDialog var1) {
      FrameLayout var2 = (FrameLayout)var1.findViewById(design_bottom_sheet);
      BottomSheetBehavior var3 = BottomSheetBehavior.from(var2);
      LayoutParams var4 = var2.getLayoutParams();
      int var5 = this.getWindowHeight();
      if (var4 != null) {
         var4.height = var5 - AppUtils.dpToPx(56);
      }

      var2.setLayoutParams(var4);
      var3.setPeekHeight(var4.height);
      var3.setState(3);
      if (var1.getWindow() != null) {
         var1.getWindow().setDimAmount(0.0F);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, CustomBottomSheetDialogTheme);
   }

   public Dialog onCreateDialog(Bundle var1) {
      Dialog var2 = super.onCreateDialog(var1);
      var2.setOnShowListener(new 1(this));
      return var2;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.binding = (BottomSheetPlacesSearchBinding)DataBindingUtil.inflate(var1, bottom_sheet_places_search, var2, false);
      ArrayList var4 = new ArrayList();
      this.predictionArrayList = var4;
      this.adapter = new PlacesSearchAdapter(var4, this);
      this.binding.recyclerview.setAdapter(this.adapter);
      this.disposable.add((Disposable)RxTextView.textChangeEvents(this.binding.inputSearch).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(this.searchQuery()));
      this.viewModel.getGooglePlacesResponseMutableLiveData().observe(this.getViewLifecycleOwner(), new _$$Lambda$BottomSheetPlacesSearch$TDZ8ETT7ZbIv8RV8QRzDE7KLp18(this));
      this.binding.idClose.setOnClickListener(new _$$Lambda$BottomSheetPlacesSearch$CSdiz9GKfhbjJfuO_Hk8C_MQ5ZY(this));
      this.binding.idCancel.setOnClickListener(new _$$Lambda$BottomSheetPlacesSearch$NZPmtq5Rs8vHJe61dEnxpM96UMs(this));
      return this.binding.getRoot();
   }

   public void onPlacesAdapterItemClick(Prediction var1) {
      this.onPlacesClickListener.onPlaceCLicked(var1);
      this.dismiss();
   }

   public void onResume() {
      super.onResume();
      this.predictionArrayList.clear();
      this.adapter.notifyDataSetChanged();
   }

   public void setData(AddressViewModel var1, Location var2, app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch.OnPlacesClickListener var3) {
      this.viewModel = var1;
      this.location = var2;
      this.onPlacesClickListener = var3;
   }
}
