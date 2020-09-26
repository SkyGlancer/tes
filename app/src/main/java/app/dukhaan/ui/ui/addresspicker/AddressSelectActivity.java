package app.dukhaan.ui.ui.addresspicker;

import android.content.res.Resources.NotFoundException;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.core.app.ActivityCompat;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityAddressSelectBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;
import app.dukhaan.ui.addresspicker.AddressSelectActivity.1;
import app.dukhaan.ui.addresspicker.AddressSelectActivity.2;
import app.dukhaan.ui.addresspicker.AddressSelectActivity.3;
import app.dukhaan.ui.addresspicker.AddressSelectActivity.4;
import app.dukhaan.ui.addresspicker.AddressSelectActivity.6;
import app.dukhaan.ui.addresspicker.AddressViewModel;
import app.dukhaan.ui.addresspicker.BottomSheetPlacesSearch.OnPlacesClickListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.Dexter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import timber.log.Timber;

public class AddressSelectActivity extends BaseActivity<ActivityAddressSelectBinding, app.dukhaan.ui.addresspicker.AddressViewModel> implements OnMapReadyCallback, ConnectionCallbacks, OnConnectionFailedListener, OnPlacesClickListener {
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
   private app.dukhaan.ui.addresspicker.AddressViewModel viewModel;

   public AddressSelectActivity() {
   }

   private void addCustomMarker(LatLng var1) {
      GoogleMap var2 = this.mMap;
      if (var2 != null) {
         var2.clear();
         MarkerOptions var3 = new MarkerOptions();
         var3.position(var1);
         var3.anchor(0.5F, 0.45F);
         var3.icon(BitmapDescriptorFactory.fromResource(ic_map_pin_dot));
         this.mMap.addMarker(var3);
      }

   }

   private void initGPS(LocationRequest var1, GoogleApiClient var2) {
      Builder var3 = (new Builder()).addLocationRequest(var1);
      var3.setAlwaysShow(true);
      LocationServices.SettingsApi.checkLocationSettings(var2, var3.build()).setResultCallback(new _$$Lambda$AddressSelectActivity$z7jpCucnIaLfYJs3VfucmiwRUos(this));
   }

   private void requestLocationUpdates() {
      try {
         this.mFusedLocationClient.requestLocationUpdates(this.mLocationRequest, this.mLocationCallback, Looper.myLooper());
      } catch (Exception var4) {
         String var2 = TAG;
         StringBuilder var3 = new StringBuilder();
         var3.append("Lost location permission. Could not request updates. ");
         var3.append(var4);
         Log.d(var2, var3.toString());
      }

   }

   private void requestPermissions() {
      ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
   }

   private void setCurrentLocation() {
      if (this.mMap != null) {
         View var1 = this.locationButton;
         if (var1 != null) {
            var1.callOnClick();
            Location var2 = new Location("");
            var2.setLatitude(this.userLat);
            var2.setLongitude(this.userLong);
            this.location = var2;
            this.addCustomMarker(new LatLng(this.userLat, this.userLong));
            this.zoomToCurrentPos(var2);
         }
      }

   }

   private void setLocationAddress(Location var1) {
      if (var1 != null && var1.getLatitude() != 0.0D) {
         Geocoder var2 = new Geocoder(this, Locale.getDefault());

         Exception var10000;
         label79: {
            List var11;
            boolean var10001;
            try {
               var11 = var2.getFromLocation(var1.getLatitude(), var1.getLongitude(), 1);
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label79;
            }

            if (var11 == null) {
               return;
            }

            try {
               if (var11.size() <= 0) {
                  return;
               }
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label79;
            }

            int var3 = 0;

            StringBuilder var12;
            Address var14;
            label80: {
               try {
                  var14 = (Address)var11.get(0);
                  var12 = new StringBuilder("");
                  if (!TextUtils.isEmpty(var14.getSubLocality())) {
                     this.binding.idAddressArea.setText(var14.getSubLocality());
                     break label80;
                  }
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
                  break label79;
               }

               try {
                  if (!TextUtils.isEmpty(var14.getSubLocality())) {
                     this.binding.idAddressArea.setText(var14.getSubLocality());
                  }
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label79;
               }
            }

            try {
               this.binding.idAddressArea.setVisibility(0);
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
               break label79;
            }

            while(true) {
               try {
                  if (var3 > var14.getMaxAddressLineIndex()) {
                     break;
                  }

                  var12.append(var14.getAddressLine(var3));
                  var12.append("\n");
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label79;
               }

               ++var3;
            }

            try {
               String var15 = var12.toString();
               this.binding.idAddress.setText(var15);
               return;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
            }
         }

         Exception var13 = var10000;
         var13.printStackTrace();
      }

   }

   private void setLocationOnMap() {
      GoogleMap var1 = this.mMap;
      if (var1 != null) {
         var1.setOnCameraMoveListener(new 6(this));
         this.mMap.setOnCameraIdleListener(new _$$Lambda$AddressSelectActivity$UoObnEq6Ct9ZzLoTBD2DPPECeRg(this));
      }

   }

   private void setUpMapFragment() {
      SupportMapFragment var1 = (SupportMapFragment)this.getSupportFragmentManager().findFragmentById(mapFrag);
      this.mapFragment = var1;
      var1.getMapAsync(this);
   }

   private void setupGoogleClientUpdates() {
      this.buildGoogleApiClient();
      this.setUpMapFragment();
      this.initGPS(this.mLocationRequest, this.mGoogleApiClient);
   }

   private void zoomToCurrentPos(Location var1) {
      if (var1 != null) {
         CameraPosition var3 = (new CameraPosition.Builder()).target(new LatLng(var1.getLatitude(), var1.getLongitude())).zoom(17.0F).bearing(90.0F).tilt(0.0F).build();
         GoogleMap var2 = this.mMap;
         if (var2 != null) {
            var2.moveCamera(CameraUpdateFactory.newCameraPosition(var3));
         }
      }

   }

   protected void buildGoogleApiClient() {
      if (this.mGoogleApiClient == null) {
         this.mGoogleApiClient = (new GoogleApiClient.Builder(this)).addConnectionCallbacks(this).enableAutoManage(this, this).addApi(LocationServices.API).build();
         this.createLocationRequest();
      }
   }

   public void changeStatusBarColor() {
      this.changeStatusBarColor(-1);
   }

   public void changeStatusBarColor(int var1) {
      Window var2 = this.getWindow();
      if (VERSION.SDK_INT >= 21) {
         var2.addFlags(-2147483648);
      }

      if (VERSION.SDK_INT >= 23) {
         var2.getDecorView().setSystemUiVisibility(8192);
         var2.setStatusBarColor(var1);
      }

   }

   public void createLocationRequest() {
      LocationRequest var1 = new LocationRequest();
      this.mLocationRequest = var1;
      var1.setInterval(10000L);
      this.mLocationRequest.setFastestInterval(5000L);
      this.mLocationRequest.setPriority(100);
      this.mLocationRequest.setMaxWaitTime(10000L);
   }

   public int getLayoutId() {
      return activity_address_select;
   }

   public void getLocationFromAddress(String var1) {
      Geocoder var2 = new Geocoder(this);

      IOException var10000;
      label40: {
         boolean var10001;
         List var6;
         try {
            var6 = var2.getFromLocationName(var1, 5);
         } catch (IOException var5) {
            var10000 = var5;
            var10001 = false;
            break label40;
         }

         if (var6 == null) {
            return;
         }

         Address var7;
         try {
            if (var6.size() <= 0) {
               return;
            }

            var7 = (Address)var6.get(0);
         } catch (IOException var4) {
            var10000 = var4;
            var10001 = false;
            break label40;
         }

         if (var7 == null) {
            return;
         }

         try {
            this.location.setLatitude(var7.getLatitude());
            this.location.setLongitude(var7.getLongitude());
            this.zoomToCurrentPos(this.location);
            return;
         } catch (IOException var3) {
            var10000 = var3;
            var10001 = false;
         }
      }

      IOException var8 = var10000;
      var8.printStackTrace();
   }

   public Class<app.dukhaan.ui.addresspicker.AddressViewModel> getViewModel() {
      return app.dukhaan.ui.addresspicker.AddressViewModel.class;
   }

   public void makeFullScreen() {
      if (VERSION.SDK_INT >= 21) {
         this.getWindow().getDecorView().setSystemUiVisibility(1280);
      }

   }

   public void onConnected(Bundle var1) {
   }

   public void onConnectionFailed(ConnectionResult var1) {
   }

   public void onConnectionSuspended(int var1) {
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.changeStatusBarColor();
   }

   protected void onCreate(Bundle var1, AddressViewModel var2, ActivityAddressSelectBinding var3) {
      this.binding = var3;
      this.viewModel = var2;
      Window var5 = this.getWindow();
      LayoutParams var4 = var5.getAttributes();
      var4.flags &= -67108865;
      var5.setAttributes(var4);
      if (VERSION.SDK_INT >= 23) {
         var5.getDecorView().setSystemUiVisibility(9472);
      }

      Dexter.withContext(this).withPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}).withListener(new 1(this)).check();
      this.binding.idInputBlockNumber.addTextChangedListener(new 2(this));
      this.binding.idBtnSaveAddress.setOnClickListener(new 3(this));
      this.binding.idBtnBack.setOnClickListener(new 4(this));
      this.binding.idImgCurrentAddress.setOnClickListener(new _$$Lambda$AddressSelectActivity$GQFizLxYvaV27gIPQnxM_6Kx1xc(this));
      this.binding.btnChange.setOnClickListener(new _$$Lambda$AddressSelectActivity$ZwQKgGv6n22u2BuaN_1vht04hvo(this, var2));
   }

   public void onMapReady(GoogleMap var1) {
      this.mMap = var1;
      if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
         this.requestPermissions();
      } else {
         this.mMap.setMyLocationEnabled(false);
         this.mMap.getUiSettings().setCompassEnabled(false);
         this.locationButton = this.mapFragment.getView().findViewById(Integer.parseInt("2"));

         try {
            if (!var1.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, style_json))) {
               Timber.tag(TAG).e("Style parsing failed.", new Object[0]);
            }
         } catch (NotFoundException var2) {
            Timber.tag(TAG).e(var2, "Can't find style. Error: ", new Object[0]);
         }

         this.setLocationOnMap();
         View var3 = this.locationButton;
         if (var3 != null) {
            var3.setVisibility(8);
         }

      }
   }

   public void onPlaceCLicked(Prediction var1) {
      try {
         this.binding.idAddressArea.setText(var1.getStructuredFormatting().getMainText());
         this.binding.idAddress.setText(var1.getDescription());
         this.binding.idAddressArea.setVisibility(0);
         this.getLocationFromAddress(var1.getDescription());
      } catch (Exception var3) {
         this.binding.idAddress.setText(var1.getDescription());
         var3.printStackTrace();
      }

   }
}
