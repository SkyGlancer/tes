/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.location.Address
 *  android.location.Geocoder
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.core.app.ActivityCompat
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityAddressSelectBinding
 *  app.dukhaan.ui.addresspicker.-$
 *  app.dukhaan.ui.addresspicker.-$$Lambda
 *  app.dukhaan.ui.addresspicker.-$$Lambda$AddressSelectActivity
 *  app.dukhaan.ui.addresspicker.-$$Lambda$AddressSelectActivity$UoObnEq6Ct9ZzLoTBD2DPPECeRg
 *  app.dukhaan.ui.addresspicker.-$$Lambda$AddressSelectActivity$z7jpCucnIaLfYJs3VfucmiwRUos
 *  app.dukhaan.ui.addresspicker.AddressSelectActivity$1
 *  app.dukhaan.ui.addresspicker.AddressSelectActivity$5
 *  app.dukhaan.ui.addresspicker.AddressSelectActivity$6
 *  app.dukhaan.ui.addresspicker.AddressViewModel
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$Builder
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.location.FusedLocationProviderClient
 *  com.google.android.gms.location.LocationCallback
 *  com.google.android.gms.location.LocationRequest
 *  com.google.android.gms.location.LocationServices
 *  com.google.android.gms.location.LocationSettingsRequest
 *  com.google.android.gms.location.LocationSettingsRequest$Builder
 *  com.google.android.gms.location.LocationSettingsResult
 *  com.google.android.gms.location.SettingsApi
 *  com.google.android.gms.maps.CameraUpdate
 *  com.google.android.gms.maps.CameraUpdateFactory
 *  com.google.android.gms.maps.GoogleMap
 *  com.google.android.gms.maps.GoogleMap$OnCameraIdleListener
 *  com.google.android.gms.maps.GoogleMap$OnCameraMoveListener
 *  com.google.android.gms.maps.OnMapReadyCallback
 *  com.google.android.gms.maps.SupportMapFragment
 *  com.google.android.gms.maps.UiSettings
 *  com.google.android.gms.maps.model.BitmapDescriptor
 *  com.google.android.gms.maps.model.BitmapDescriptorFactory
 *  com.google.android.gms.maps.model.CameraPosition
 *  com.google.android.gms.maps.model.CameraPosition$Builder
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.MapStyleOptions
 *  com.google.android.gms.maps.model.Marker
 *  com.google.android.gms.maps.model.MarkerOptions
 *  com.google.android.gms.tasks.Task
 *  com.karumi.dexter.Dexter
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Locale
 *  timber.log.Timber
 */
package app.dukhaan.ui.addresspicker;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityAddressSelectBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;
import app.dukhaan.network.model.placesResponseData.StructuredFormatting;
import app.dukhaan.ui.addresspicker.-$;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressSelectActivity$GQFizLxYvaV27gIPQnxM_6Kx1xc;
import app.dukhaan.ui.addresspicker.-$$Lambda$AddressSelectActivity$ZwQKgGv6n22u2BuaN_1vht04hvo;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import timber.log.Timber;

public class AddressSelectActivity
extends BaseActivity<ActivityAddressSelectBinding, AddressViewModel>
implements OnMapReadyCallback,
GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener,
BottomSheetPlacesSearch.OnPlacesClickListener {
    private static final long FASTEST_UPDATE_INTERVAL = 5000L;
    private static final long MAX_WAIT_TIME = 10000L;
    protected static final int REQUEST_CHECK_SETTINGS = 102;
    private static final String TAG = AddressSelectActivity.class.getSimpleName();
    private static final long UPDATE_INTERVAL = 10000L;
    private ActivityAddressSelectBinding binding;
    private boolean isLocationFetched = false;
    private boolean isLocationFromPlaces = false;
    private Location location;
    private View locationButton;
    protected FusedLocationProviderClient mFusedLocationClient;
    protected GoogleApiClient mGoogleApiClient;
    protected LocationCallback mLocationCallback;
    protected LocationRequest mLocationRequest;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private double userLat;
    private double userLong;
    private AddressViewModel viewModel;

    static /* synthetic */ ActivityAddressSelectBinding access$000(AddressSelectActivity addressSelectActivity) {
        return addressSelectActivity.binding;
    }

    static /* synthetic */ void access$100(AddressSelectActivity addressSelectActivity) {
        addressSelectActivity.setupGoogleClientUpdates();
    }

    static /* synthetic */ Location access$200(AddressSelectActivity addressSelectActivity) {
        return addressSelectActivity.location;
    }

    static /* synthetic */ Location access$202(AddressSelectActivity addressSelectActivity, Location location) {
        addressSelectActivity.location = location;
        return location;
    }

    static /* synthetic */ boolean access$300(AddressSelectActivity addressSelectActivity) {
        return addressSelectActivity.isLocationFetched;
    }

    static /* synthetic */ boolean access$302(AddressSelectActivity addressSelectActivity, boolean bl) {
        addressSelectActivity.isLocationFetched = bl;
        return bl;
    }

    static /* synthetic */ void access$400(AddressSelectActivity addressSelectActivity, Location location) {
        addressSelectActivity.zoomToCurrentPos(location);
    }

    static /* synthetic */ double access$500(AddressSelectActivity addressSelectActivity) {
        return addressSelectActivity.userLat;
    }

    static /* synthetic */ double access$502(AddressSelectActivity addressSelectActivity, double d) {
        addressSelectActivity.userLat = d;
        return d;
    }

    static /* synthetic */ double access$600(AddressSelectActivity addressSelectActivity) {
        return addressSelectActivity.userLong;
    }

    static /* synthetic */ double access$602(AddressSelectActivity addressSelectActivity, double d) {
        addressSelectActivity.userLong = d;
        return d;
    }

    static /* synthetic */ void access$700(AddressSelectActivity addressSelectActivity, LatLng latLng) {
        addressSelectActivity.addCustomMarker(latLng);
    }

    private void addCustomMarker(LatLng latLng) {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.clear();
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.anchor(0.5f, 0.45f);
            markerOptions.icon(BitmapDescriptorFactory.fromResource((int)2131231240));
            this.mMap.addMarker(markerOptions);
        }
    }

    private void initGPS(LocationRequest locationRequest, GoogleApiClient googleApiClient) {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build()).setResultCallback((ResultCallback)new -$.Lambda.AddressSelectActivity.z7jpCucnIaLfYJs3VfucmiwRUos(this));
    }

    private void requestLocationUpdates() {
        try {
            this.mFusedLocationClient.requestLocationUpdates(this.mLocationRequest, this.mLocationCallback, Looper.myLooper());
            return;
        }
        catch (Exception exception) {
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Lost location permission. Could not request updates. ");
            stringBuilder.append((Object)exception);
            Log.d((String)string2, (String)stringBuilder.toString());
            return;
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.ACCESS_FINE_LOCATION"}, (int)1);
    }

    private void setCurrentLocation() {
        View view;
        if (this.mMap != null && (view = this.locationButton) != null) {
            view.callOnClick();
            Location location = new Location("");
            location.setLatitude(this.userLat);
            location.setLongitude(this.userLong);
            this.location = location;
            this.addCustomMarker(new LatLng(this.userLat, this.userLong));
            this.zoomToCurrentPos(location);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setLocationAddress(Location location) {
        if (location == null || location.getLatitude() == 0.0) return;
        {
            Geocoder geocoder = new Geocoder((Context)this, Locale.getDefault());
            try {
                List list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (list == null || list.size() <= 0) return;
                {
                    int n = 0;
                    Address address = (Address)list.get(0);
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (!TextUtils.isEmpty((CharSequence)address.getSubLocality())) {
                        this.binding.idAddressArea.setText((CharSequence)address.getSubLocality());
                    } else if (!TextUtils.isEmpty((CharSequence)address.getSubLocality())) {
                        this.binding.idAddressArea.setText((CharSequence)address.getSubLocality());
                    }
                    this.binding.idAddressArea.setVisibility(0);
                    while (n <= address.getMaxAddressLineIndex()) {
                        stringBuilder.append(address.getAddressLine(n));
                        stringBuilder.append("\n");
                        ++n;
                    }
                    String string2 = stringBuilder.toString();
                    this.binding.idAddress.setText((CharSequence)string2);
                    return;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void setLocationOnMap() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setOnCameraMoveListener((GoogleMap.OnCameraMoveListener)new 6(this));
            this.mMap.setOnCameraIdleListener((GoogleMap.OnCameraIdleListener)new -$.Lambda.AddressSelectActivity.UoObnEq6Ct9ZzLoTBD2DPPECeRg(this));
        }
    }

    private void setUpMapFragment() {
        SupportMapFragment supportMapFragment;
        this.mapFragment = supportMapFragment = (SupportMapFragment)this.getSupportFragmentManager().findFragmentById(2131362299);
        supportMapFragment.getMapAsync((OnMapReadyCallback)this);
    }

    private void setupGoogleClientUpdates() {
        this.buildGoogleApiClient();
        this.setUpMapFragment();
        this.initGPS(this.mLocationRequest, this.mGoogleApiClient);
    }

    private void zoomToCurrentPos(Location location) {
        if (location != null) {
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(17.0f).bearing(90.0f).tilt(0.0f).build();
            GoogleMap googleMap = this.mMap;
            if (googleMap != null) {
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)cameraPosition));
            }
        }
    }

    protected void buildGoogleApiClient() {
        if (this.mGoogleApiClient != null) {
            return;
        }
        this.mGoogleApiClient = new GoogleApiClient.Builder((Context)this).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)this).enableAutoManage((FragmentActivity)this, (GoogleApiClient.OnConnectionFailedListener)this).addApi(LocationServices.API).build();
        this.createLocationRequest();
    }

    @Override
    public void changeStatusBarColor() {
        this.changeStatusBarColor(-1);
    }

    @Override
    public void changeStatusBarColor(int n) {
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(n);
        }
    }

    public void createLocationRequest() {
        LocationRequest locationRequest;
        this.mLocationRequest = locationRequest = new LocationRequest();
        locationRequest.setInterval(10000L);
        this.mLocationRequest.setFastestInterval(5000L);
        this.mLocationRequest.setPriority(100);
        this.mLocationRequest.setMaxWaitTime(10000L);
    }

    @Override
    public int getLayoutId() {
        return 2131558430;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void getLocationFromAddress(String string2) {
        Address address;
        Geocoder geocoder = new Geocoder((Context)this);
        List list = geocoder.getFromLocationName(string2, 5);
        if (list == null) return;
        if (list.size() <= 0 || (address = (Address)list.get(0)) == null) return;
        try {
            this.location.setLatitude(address.getLatitude());
            this.location.setLongitude(address.getLongitude());
            this.zoomToCurrentPos(this.location);
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public Class<AddressViewModel> getViewModel() {
        return AddressViewModel.class;
    }

    public /* synthetic */ void lambda$initGPS$2$AddressSelectActivity(LocationSettingsResult locationSettingsResult) {
        Status status = locationSettingsResult.getStatus();
        int n = status.getStatusCode();
        if (n != 0) {
            if (n != 6) {
                if (n != 8502) {
                    return;
                }
                this.binding.progressBar.setVisibility(8);
                Timber.tag((String)TAG).e("GPS is Unavailable", new Object[0]);
                return;
            }
            this.binding.progressBar.setVisibility(8);
            try {
                status.startResolutionForResult((Activity)this, 102);
                return;
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                Timber.tag((String)TAG).e("failed to show", new Object[0]);
                return;
            }
        }
        this.mFusedLocationClient = LocationServices.getFusedLocationProviderClient((Activity)this);
        this.mLocationCallback = new 5(this);
        this.requestLocationUpdates();
    }

    public /* synthetic */ void lambda$onCreate$0$AddressSelectActivity(View view) {
        this.setCurrentLocation();
    }

    public /* synthetic */ void lambda$onCreate$1$AddressSelectActivity(AddressViewModel addressViewModel, View view) {
        BottomSheetPlacesSearch bottomSheetPlacesSearch = new BottomSheetPlacesSearch();
        bottomSheetPlacesSearch.setData(addressViewModel, this.location, this);
        bottomSheetPlacesSearch.show(this.getSupportFragmentManager(), bottomSheetPlacesSearch.getTag());
    }

    public /* synthetic */ void lambda$setLocationOnMap$3$AddressSelectActivity() {
        if (this.isLocationFetched) {
            this.binding.progressBar.setVisibility(8);
        }
        Location location = new Location("");
        location.setLatitude(this.mMap.getCameraPosition().target.latitude);
        location.setLongitude(this.mMap.getCameraPosition().target.longitude);
        this.location = location;
        if (!this.isLocationFromPlaces) {
            this.setLocationAddress(location);
        }
        this.isLocationFromPlaces = false;
    }

    public void makeFullScreen() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onConnectionSuspended(int n) {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.changeStatusBarColor();
    }

    @Override
    protected void onCreate(Bundle bundle, AddressViewModel addressViewModel, ActivityAddressSelectBinding activityAddressSelectBinding) {
        this.binding = activityAddressSelectBinding;
        this.viewModel = addressViewModel;
        Window window = this.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.flags = -67108865 & layoutParams.flags;
        window.setAttributes(layoutParams);
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(9472);
        }
        Dexter.withContext((Context)this).withPermissions("android.permission.ACCESS_FINE_LOCATION").withListener((MultiplePermissionsListener)new 1(this)).check();
        this.binding.idInputBlockNumber.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ AddressSelectActivity this$0;
            {
                this.this$0 = addressSelectActivity;
            }

            public void afterTextChanged(android.text.Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                if (charSequence.toString().trim().length() > 0 && AddressSelectActivity.access$200(this.this$0) != null) {
                    AddressSelectActivity.access$000((AddressSelectActivity)this.this$0).idBtnSaveAddress.setEnabled(true);
                    return;
                }
                AddressSelectActivity.access$000((AddressSelectActivity)this.this$0).idBtnSaveAddress.setEnabled(false);
            }
        });
        this.binding.idBtnSaveAddress.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ AddressSelectActivity this$0;
            {
                this.this$0 = addressSelectActivity;
            }

            /*
             * Exception decompiling
             */
            public void onClick(}
        java.lang.IllegalStateException: Parameters not created
        
        