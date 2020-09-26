/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.location.Location
 *  android.os.Bundle
 *  android.text.Editable
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.Observer
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.ui.addresspicker.-$
 *  app.dukhaan.ui.addresspicker.-$$Lambda
 *  app.dukhaan.ui.addresspicker.-$$Lambda$BottomSheetPlacesSearch
 *  app.dukhaan.ui.addresspicker.-$$Lambda$BottomSheetPlacesSearch$TDZ8ETT7ZbIv8RV8QRzDE7KLp18
 *  app.dukhaan.ui.addresspicker.AddressViewModel
 *  app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch$2
 *  app.dukhaan.ui.addresspicker.PlacesSearchAdapter
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 *  com.google.android.material.bottomsheet.BottomSheetDialogFragment
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.schedulers.Schedulers
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  timber.log.Timber
 */
package app.dukhaan.ui.addresspicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.BottomSheetPlacesSearchBinding;
import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import app.dukhaan.network.model.placesResponseData.Prediction;
import app.dukhaan.ui.addresspicker.-$;
import app.dukhaan.ui.addresspicker.-$$Lambda$BottomSheetPlacesSearch$CSdiz9GKfhbjJfuO-Hk8C-MQ5ZY;
import app.dukhaan.ui.addresspicker.-$$Lambda$BottomSheetPlacesSearch$NZPmtq5Rs8vHJe61dEnxpM96UMs;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch;
import app.dukhaan.ui.addresspicker.PlacesSearchAdapter;
import app.dukhaan.util.AppUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
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
import java.util.List;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class BottomSheetPlacesSearch
extends BottomSheetDialogFragment
implements PlacesSearchAdapter.PlacesAdapterItemClick {
    private PlacesSearchAdapter adapter;
    private BottomSheetPlacesSearchBinding binding;
    private Context context;
    private CompositeDisposable disposable = new CompositeDisposable();
    private Location location;
    private String map_access_token = null;
    private String map_token_type = null;
    private OnPlacesClickListener onPlacesClickListener;
    private ArrayList<Prediction> predictionArrayList;
    private AddressViewModel viewModel;

    static /* synthetic */ void access$000(BottomSheetPlacesSearch bottomSheetPlacesSearch, BottomSheetDialog bottomSheetDialog) {
        bottomSheetPlacesSearch.setupFullHeight(bottomSheetDialog);
    }

    static /* synthetic */ BottomSheetPlacesSearchBinding access$100(BottomSheetPlacesSearch bottomSheetPlacesSearch) {
        return bottomSheetPlacesSearch.binding;
    }

    static /* synthetic */ Location access$200(BottomSheetPlacesSearch bottomSheetPlacesSearch) {
        return bottomSheetPlacesSearch.location;
    }

    static /* synthetic */ Context access$300(BottomSheetPlacesSearch bottomSheetPlacesSearch) {
        return bottomSheetPlacesSearch.context;
    }

    static /* synthetic */ AddressViewModel access$400(BottomSheetPlacesSearch bottomSheetPlacesSearch) {
        return bottomSheetPlacesSearch.viewModel;
    }

    private int getWindowHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private DisposableObserver<TextViewTextChangeEvent> searchQuery() {
        return new 2(this);
    }

    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout frameLayout = (FrameLayout)bottomSheetDialog.findViewById(2131362026);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View)frameLayout);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        int n = this.getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = n - AppUtils.dpToPx(56);
        }
        frameLayout.setLayoutParams(layoutParams);
        bottomSheetBehavior.setPeekHeight(layoutParams.height);
        bottomSheetBehavior.setState(3);
        if (bottomSheetDialog.getWindow() != null) {
            bottomSheetDialog.getWindow().setDimAmount(0.0f);
        }
    }

    public /* synthetic */ void lambda$onCreateView$0$BottomSheetPlacesSearch(GooglePlacesResponse googlePlacesResponse) {
        if (googlePlacesResponse.getPredictions().size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MAPS : ");
            stringBuilder.append(googlePlacesResponse.getPredictions().toString());
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            this.predictionArrayList.clear();
            for (Prediction prediction : googlePlacesResponse.getPredictions()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("MAPS ITEM : ");
                stringBuilder2.append(prediction.toString());
                Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
                prediction.setSearchKey(this.binding.inputSearch.getText().toString());
                this.predictionArrayList.add((Object)prediction);
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$onCreateView$1$BottomSheetPlacesSearch(View view) {
        this.binding.inputSearch.setText((CharSequence)"");
        this.predictionArrayList.clear();
        this.adapter.notifyDataSetChanged();
        this.binding.inputSearch.requestFocus();
        AppUtils.showKeyboard(this.getContext());
    }

    public /* synthetic */ void lambda$onCreateView$2$BottomSheetPlacesSearch(View view) {
        this.binding.inputSearch.setText((CharSequence)"");
        this.predictionArrayList.clear();
        this.adapter.notifyDataSetChanged();
        this.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setStyle(0, 2132017389);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = super.onCreateDialog(bundle);
        dialog.setOnShowListener(new DialogInterface.OnShowListener(this){
            final /* synthetic */ BottomSheetPlacesSearch this$0;
            {
                this.this$0 = bottomSheetPlacesSearch;
            }

            public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog)dialogInterface;
                BottomSheetPlacesSearch.access$000(this.this$0, bottomSheetDialog);
            }
        });
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList;
        this.binding = (BottomSheetPlacesSearchBinding)DataBindingUtil.inflate((LayoutInflater)layoutInflater, (int)2131558456, (ViewGroup)viewGroup, (boolean)false);
        this.predictionArrayList = arrayList = new ArrayList();
        this.adapter = new PlacesSearchAdapter((List)arrayList, (PlacesSearchAdapter.PlacesAdapterItemClick)this);
        this.binding.recyclerview.setAdapter((RecyclerView.Adapter)this.adapter);
        this.disposable.add((Disposable)RxTextView.textChangeEvents((TextView)this.binding.inputSearch).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(this.searchQuery()));
        this.viewModel.getGooglePlacesResponseMutableLiveData().observe(this.getViewLifecycleOwner(), (androidx.lifecycle.Observer)new -$.Lambda.BottomSheetPlacesSearch.TDZ8ETT7ZbIv8RV8QRzDE7KLp18(this));
        this.binding.idClose.setOnClickListener((View.OnClickListener)new -$$Lambda$BottomSheetPlacesSearch$CSdiz9GKfhbjJfuO-Hk8C-MQ5ZY(this));
        this.binding.idCancel.setOnClickListener((View.OnClickListener)new -$$Lambda$BottomSheetPlacesSearch$NZPmtq5Rs8vHJe61dEnxpM96UMs(this));
        return this.binding.getRoot();
    }

    @Override
    public void onPlacesAdapterItemClick(Prediction prediction) {
        this.onPlacesClickListener.onPlaceCLicked(prediction);
        this.dismiss();
    }

    public void onResume() {
        super.onResume();
        this.predictionArrayList.clear();
        this.adapter.notifyDataSetChanged();
    }

    public void setData(AddressViewModel addressViewModel, Location location, OnPlacesClickListener onPlacesClickListener) {
        this.viewModel = addressViewModel;
        this.location = location;
        this.onPlacesClickListener = onPlacesClickListener;
    }

}

