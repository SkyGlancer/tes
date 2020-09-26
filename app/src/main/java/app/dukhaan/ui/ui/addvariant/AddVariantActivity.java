package app.dukhaan.ui.ui.addvariant;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityAddVariantBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.addvariant.AddVariantNavigator;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.util.ModalDialogs;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class AddVariantActivity extends BaseActivity<ActivityAddVariantBinding, AddVariantViewModel> implements TextWatcher, ColorPickerDialogListener, AddVariantNavigator {
   private int COUNT_COLOR = 0;
   private int COUNT_SIZE = 0;
   private int COUNT_TYPE = 0;
   private int COUNT_WHOLESALE = 0;
   private ActivityAddVariantBinding binding;
   private List<Country> countries;
   private CountriesAdapter countriesAdapter;
   private double lat;
   private double lng;
   private AddVariantViewModel mViewModel;
   private PopupWindow popUp;
   private List<Country> searchResults;
   private Country selectedCountry;

   public AddVariantActivity() {
   }

   private void addColorInput() {
      ++this.COUNT_COLOR;
      ColorPickerDialog.newBuilder().show(this);
   }

   private void addSizeInput() {
      ++this.COUNT_SIZE;
      View var1 = LayoutInflater.from(this).inflate(variant_input_size, (ViewGroup)null);
      ((TextView)var1.findViewById(btn_delete)).setOnClickListener(new _$$Lambda$AddVariantActivity$s7OUBUbz6M4edT_rzBuhq_BKSso(this, var1));
      var1.findViewById(edit_text).requestFocus();
      this.binding.sizeInputContainer.addView(var1);
   }

   private void createColorInput(String var1) {
      View var2 = LayoutInflater.from(this).inflate(variant_input_color, (ViewGroup)null);
      EditText var3 = (EditText)var2.findViewById(edit_text);
      TextView var4 = (TextView)var2.findViewById(btn_delete);
      TextView var5 = (TextView)var2.findViewById(color_box);
      var4.setOnClickListener(new _$$Lambda$AddVariantActivity$9zuHU9sSPkPoDRdPhlj_4bUKL4M(this, var2));
      var5.setBackgroundColor(Color.parseColor(var1));
      var3.setText(var1);
      this.binding.colorInputContainer.addView(var2);
   }

   private void createSizeInput(String var1) {
      ++this.COUNT_SIZE;
      View var2 = LayoutInflater.from(this).inflate(variant_input_size, (ViewGroup)null);
      ((TextView)var2.findViewById(btn_delete)).setOnClickListener(new _$$Lambda$AddVariantActivity$t_K6e6RWseQCp1rK4N6NJk2tZCU(this, var2));
      ((EditText)var2.findViewById(edit_text)).setText(var1);
      this.binding.sizeInputContainer.addView(var2);
   }

   public static void hideKeyboard(Activity var0) {
      InputMethodManager var1 = (InputMethodManager)var0.getSystemService("input_method");
      View var2 = var0.getCurrentFocus();
      View var3 = var2;
      if (var2 == null) {
         var3 = new View(var0);
      }

      var1.hideSoftInputFromWindow(var3.getWindowToken(), 0);
   }

   private void initVariants() {
      String var1 = this.getIntent().getStringExtra("variants");
      if (var1 != null) {
         StringBuilder var2 = new StringBuilder();
         var2.append("VARIANTS OLD:");
         var2.append(var1);
         String var10 = var2.toString();
         int var3 = 0;
         Timber.d(var10, new Object[0]);

         Exception var10000;
         label40: {
            JSONArray var11;
            boolean var10001;
            try {
               var11 = new JSONArray(var1);
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break label40;
            }

            while(true) {
               boolean var4;
               try {
                  if (var3 >= var11.length()) {
                     return;
                  }

                  var4 = var11.getJSONObject(var3).getString(R.string."type").equals("1");
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break;
               }

               if (var4) {
                  try {
                     this.createSizeInput(var11.getJSONObject(var3).getString(R.string."value"));
                  } catch (Exception var6) {
                     var10000 = var6;
                     var10001 = false;
                     break;
                  }
               } else {
                  try {
                     if (var11.getJSONObject(var3).getString(R.string."type").equals("2")) {
                        this.createColorInput(var11.getJSONObject(var3).getString(R.string."value"));
                     }
                  } catch (Exception var5) {
                     var10000 = var5;
                     var10001 = false;
                     break;
                  }
               }

               ++var3;
            }
         }

         Exception var9 = var10000;
         Timber.e(var9);
      }

   }

   private void saveAndContinue() throws JSONException {
      JSONArray var1 = new JSONArray();
      ArrayList var2 = this.binding.sizeInputContainer.getFocusables(2);
      ArrayList var3 = this.binding.colorInputContainer.getFocusables(2);
      int var4 = 0;

      int var5;
      int var6;
      String var7;
      for(var5 = 0; var4 < var2.size(); var5 = var6) {
         var6 = var5;
         if (var2.get(var4) instanceof EditText) {
            var7 = ((EditText)var2.get(var4)).getText().toString();
            StringBuilder var8 = new StringBuilder();
            var8.append("VARIANTS S : in for - ");
            var8.append(var7);
            Timber.d(var8.toString(), new Object[0]);
            var6 = var5;
            if (!TextUtils.isEmpty(var7)) {
               JSONObject var13 = new JSONObject();
               var13.put("type", "1");
               var13.put("value", var7);
               var1.put(var13);
               var6 = var5 + 1;
            }
         }

         ++var4;
      }

      byte var12 = 0;
      var4 = var5;

      for(var5 = var12; var5 < var3.size(); var4 = var6) {
         var6 = var4;
         if (var3.get(var5) instanceof EditText) {
            var7 = ((EditText)var3.get(var5)).getText().toString();
            StringBuilder var9 = new StringBuilder();
            var9.append("VARIANTS C : in for - ");
            var9.append(var7);
            Timber.d(var9.toString(), new Object[0]);
            var6 = var4;
            if (!TextUtils.isEmpty(var7)) {
               JSONObject var10 = new JSONObject();
               var10.put("type", "2");
               var10.put("value", var7);
               var1.put(var10);
               var6 = var4 + 1;
            }
         }

         ++var5;
      }

      Intent var11 = new Intent();
      var11.putExtra("local_variant", true);
      var11.putExtra("variants", var1.toString());
      var11.putExtra("variant_size", var4);
      this.setResult(-1, var11);
      this.finish();
   }

   private void toggleColorHeader() {
      if (this.binding.colorExpandedView.getVisibility() == 8) {
         TransitionManager.beginDelayedTransition(this.binding.colorExpandedView, new AutoTransition());
         this.binding.colorExpandedView.setVisibility(0);
         this.binding.colorIcon.setScaleY(-1.0F);
      } else {
         TransitionManager.beginDelayedTransition(this.binding.colorExpandedView, new AutoTransition());
         this.binding.colorExpandedView.setVisibility(8);
         this.binding.colorIcon.setScaleY(1.0F);
      }

   }

   private void toggleSizeHeader() {
      if (this.binding.sizeExpandedView.getVisibility() == 8) {
         TransitionManager.beginDelayedTransition(this.binding.sizeExpandedView, new AutoTransition());
         this.binding.sizeExpandedView.setVisibility(0);
         this.binding.sizeIcon.setScaleY(-1.0F);
         if (this.COUNT_SIZE == 0) {
            this.addSizeInput();
         }
      } else {
         TransitionManager.beginDelayedTransition(this.binding.sizeExpandedView, new AutoTransition());
         this.binding.sizeExpandedView.setVisibility(8);
         this.binding.sizeIcon.setScaleY(1.0F);
      }

   }

   private void validateForm() {
      this.binding.idBtnFinish.setEnabled(true);
   }

   public void afterTextChanged(Editable var1) {
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public int getLayoutId() {
      return activity_add_variant;
   }

   public Class<AddVariantViewModel> getViewModel() {
      return AddVariantViewModel.class;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
   }

   public void onApiError(ErrorResponse var1) {
      ModalDialogs.showUnknownError(this);
   }

   @Subscribe(
      threadMode = ThreadMode.MAIN
   )
   public void onAppEvent(AppEvent var1) {
      int var2 = var1.type;
      var2 = AppEvent.INTERNET_CONNECTION_CHECK;
   }

   public void onColorSelected(int var1, int var2) {
      View var3 = LayoutInflater.from(this).inflate(variant_input_color, (ViewGroup)null);
      EditText var4 = (EditText)var3.findViewById(edit_text);
      TextView var5 = (TextView)var3.findViewById(btn_delete);
      TextView var6 = (TextView)var3.findViewById(color_box);
      var5.setOnClickListener(new _$$Lambda$AddVariantActivity$GEVJe3t0mZrvjiZOfDvO69b5FWg(this, var3));
      var6.setBackgroundColor(var2);
      StringBuilder var7 = new StringBuilder();
      var7.append("#");
      var7.append(Integer.toHexString(var2));
      var4.setText(var7.toString());
      this.binding.colorInputContainer.addView(var3);
   }

   protected void onCreate(Bundle var1, AddVariantViewModel var2, ActivityAddVariantBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$AddVariantActivity$MCGGw5HUuf5mAZBnZQWMsJ7lTzE(this));
      this.initVariants();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$AddVariantActivity$xp0Nm_BmFWrAf0vCb9a9yctGHAc(this));
      var3.idBtnFinish.setOnClickListener(new _$$Lambda$AddVariantActivity$Yi85XzQrQsnlpFgqD0N5eTR3kzc(this));
      var3.sizeHeader.setOnClickListener(new _$$Lambda$AddVariantActivity$HmCUtkeRS6qFrOYul7S_aniE7mY(this));
      var3.btnAddSize.setOnClickListener(new _$$Lambda$AddVariantActivity$nEkqegSrvXuS0shLcQT4pmfTDho(this));
      var3.colorHeader.setOnClickListener(new _$$Lambda$AddVariantActivity$bXFWzIeur2GKnhlcYknomk7es24(this));
      var3.btnAddColor.setOnClickListener(new _$$Lambda$AddVariantActivity$_4iUToOtAUfJ5mg9jkiRtzlRY_4(this));
   }

   public void onDialogDismissed(int var1) {
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      this.validateForm();
   }
}
