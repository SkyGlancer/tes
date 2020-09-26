/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.PopupWindow
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.FragmentActivity
 *  androidx.transition.AutoTransition
 *  androidx.transition.Transition
 *  androidx.transition.TransitionManager
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityAddVariantBinding
 *  app.dukhaan.ui.addvariant.AddVariantNavigator
 *  app.dukhaan.ui.addvariant.AddVariantViewModel
 *  app.dukhaan.ui.selectcountry.CountriesAdapter
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.jaredrummler.android.colorpicker.ColorPickerDialog
 *  com.jaredrummler.android.colorpicker.ColorPickerDialogListener
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  timber.log.Timber
 */
package app.dukhaan.ui.addvariant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.model.Country;
import app.dukhaan.databinding.ActivityAddVariantBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$-4iUToOtAUfJ5mg9jkiRtzlRY-4;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$9zuHU9sSPkPoDRdPhlj-4bUKL4M;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$GEVJe3t0mZrvjiZOfDvO69b5FWg;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$HmCUtkeRS6qFrOYul7S-aniE7mY;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$MCGGw5HUuf5mAZBnZQWMsJ7lTzE;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$Yi85XzQrQsnlpFgqD0N5eTR3kzc;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$bXFWzIeur2GKnhlcYknomk7es24;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$nEkqegSrvXuS0shLcQT4pmfTDho;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$s7OUBUbz6M4edT_rzBuhq_BKSso;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$t-K6e6RWseQCp1rK4N6NJk2tZCU;
import app.dukhaan.ui.addvariant.-$$Lambda$AddVariantActivity$xp0Nm_BmFWrAf0vCb9a9yctGHAc;
import app.dukhaan.ui.addvariant.AddVariantNavigator;
import app.dukhaan.ui.addvariant.AddVariantViewModel;
import app.dukhaan.ui.selectcountry.CountriesAdapter;
import app.dukhaan.ui.views.PrimaryButtonShadowed;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
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

public class AddVariantActivity
extends BaseActivity<ActivityAddVariantBinding, AddVariantViewModel>
implements TextWatcher,
ColorPickerDialogListener,
AddVariantNavigator {
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

    private void addColorInput() {
        this.COUNT_COLOR = 1 + this.COUNT_COLOR;
        ColorPickerDialog.newBuilder().show((FragmentActivity)this);
    }

    private void addSizeInput() {
        this.COUNT_SIZE = 1 + this.COUNT_SIZE;
        View view = LayoutInflater.from((Context)this).inflate(2131558654, null);
        ((TextView)view.findViewById(2131361919)).setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$s7OUBUbz6M4edT_rzBuhq_BKSso(this, view));
        view.findViewById(2131362043).requestFocus();
        this.binding.sizeInputContainer.addView(view);
    }

    private void createColorInput(String string2) {
        View view = LayoutInflater.from((Context)this).inflate(2131558653, null);
        EditText editText = (EditText)view.findViewById(2131362043);
        TextView textView = (TextView)view.findViewById(2131361919);
        TextView textView2 = (TextView)view.findViewById(2131361959);
        textView.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$9zuHU9sSPkPoDRdPhlj-4bUKL4M(this, view));
        textView2.setBackgroundColor(Color.parseColor((String)string2));
        editText.setText((CharSequence)string2);
        this.binding.colorInputContainer.addView(view);
    }

    private void createSizeInput(String string2) {
        this.COUNT_SIZE = 1 + this.COUNT_SIZE;
        View view = LayoutInflater.from((Context)this).inflate(2131558654, null);
        ((TextView)view.findViewById(2131361919)).setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$t-K6e6RWseQCp1rK4N6NJk2tZCU(this, view));
        ((EditText)view.findViewById(2131362043)).setText((CharSequence)string2);
        this.binding.sizeInputContainer.addView(view);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View((Context)activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initVariants() {
        JSONArray jSONArray;
        String string2 = this.getIntent().getStringExtra("variants");
        if (string2 == null) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VARIANTS OLD:");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        Timber.d((String)string3, (Object[])new Object[0]);
        try {
            jSONArray = new JSONArray(string2);
        }
        catch (Exception exception) {
            Timber.e((Throwable)exception);
            return;
        }
        for (int i = 0; i < jSONArray.length(); ++i) {
            boolean bl = jSONArray.getJSONObject(i).getString("type").equals((Object)"1");
            if (bl) {
                this.createSizeInput(jSONArray.getJSONObject(i).getString("value"));
                continue;
            }
            if (!jSONArray.getJSONObject(i).getString("type").equals((Object)"2")) continue;
            this.createColorInput(jSONArray.getJSONObject(i).getString("value"));
        }
    }

    private void saveAndContinue() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = this.binding.sizeInputContainer.getFocusables(2);
        ArrayList arrayList2 = this.binding.colorInputContainer.getFocusables(2);
        int n = 0;
        for (int i = 0; i < arrayList.size(); ++i) {
            if (!(arrayList.get(i) instanceof EditText)) continue;
            String string2 = ((EditText)arrayList.get(i)).getText().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VARIANTS S : in for - ");
            stringBuilder.append(string2);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object)"1");
            jSONObject.put("value", (Object)string2);
            jSONArray.put((Object)jSONObject);
            ++n;
        }
        for (int i = 0; i < arrayList2.size(); ++i) {
            if (!(arrayList2.get(i) instanceof EditText)) continue;
            String string3 = ((EditText)arrayList2.get(i)).getText().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VARIANTS C : in for - ");
            stringBuilder.append(string3);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            if (TextUtils.isEmpty((CharSequence)string3)) continue;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object)"2");
            jSONObject.put("value", (Object)string3);
            jSONArray.put((Object)jSONObject);
            ++n;
        }
        Intent intent = new Intent();
        intent.putExtra("local_variant", true);
        intent.putExtra("variants", jSONArray.toString());
        intent.putExtra("variant_size", n);
        this.setResult(-1, intent);
        this.finish();
    }

    private void toggleColorHeader() {
        if (this.binding.colorExpandedView.getVisibility() == 8) {
            TransitionManager.beginDelayedTransition((ViewGroup)this.binding.colorExpandedView, (Transition)new AutoTransition());
            this.binding.colorExpandedView.setVisibility(0);
            this.binding.colorIcon.setScaleY(-1.0f);
            return;
        }
        TransitionManager.beginDelayedTransition((ViewGroup)this.binding.colorExpandedView, (Transition)new AutoTransition());
        this.binding.colorExpandedView.setVisibility(8);
        this.binding.colorIcon.setScaleY(1.0f);
    }

    private void toggleSizeHeader() {
        if (this.binding.sizeExpandedView.getVisibility() == 8) {
            TransitionManager.beginDelayedTransition((ViewGroup)this.binding.sizeExpandedView, (Transition)new AutoTransition());
            this.binding.sizeExpandedView.setVisibility(0);
            this.binding.sizeIcon.setScaleY(-1.0f);
            if (this.COUNT_SIZE == 0) {
                this.addSizeInput();
                return;
            }
        } else {
            TransitionManager.beginDelayedTransition((ViewGroup)this.binding.sizeExpandedView, (Transition)new AutoTransition());
            this.binding.sizeExpandedView.setVisibility(8);
            this.binding.sizeIcon.setScaleY(1.0f);
        }
    }

    private void validateForm() {
        this.binding.idBtnFinish.setEnabled(true);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    @Override
    public int getLayoutId() {
        return 2131558429;
    }

    @Override
    public Class<AddVariantViewModel> getViewModel() {
        return AddVariantViewModel.class;
    }

    public /* synthetic */ void lambda$addSizeInput$7$AddVariantActivity(View view, View view2) { (view) ->  {
        this.binding.sizeInputContainer.removeView(view);
        this.COUNT_SIZE = -1 + this.COUNT_SIZE;
    }

    public /* synthetic */ void lambda$createColorInput$9$AddVariantActivity(View view, View view2) { (view) ->  {
        this.binding.colorInputContainer.removeView(view);
        this.COUNT_SIZE = -1 + this.COUNT_SIZE;
    }

    public /* synthetic */ void lambda$createSizeInput$8$AddVariantActivity(View view, View view2) { (view) ->  {
        this.binding.sizeInputContainer.removeView(view);
        this.COUNT_SIZE = -1 + this.COUNT_SIZE;
    }

    public /* synthetic */ void lambda$onColorSelected$10$AddVariantActivity(View view, View view2) { (view) ->  {
        this.binding.colorInputContainer.removeView(view);
        this.COUNT_COLOR = -1 + this.COUNT_COLOR;
    }

    public /* synthetic */ void lambda$onCreate$0$AddVariantActivity(View view) { (view) ->  {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$AddVariantActivity(View view) { (view) ->  {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$2$AddVariantActivity(View view) { (view) ->  {
        try {
            this.saveAndContinue();
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
        }
    }

    public /* synthetic */ void lambda$onCreate$3$AddVariantActivity(View view) { (view) ->  {
        this.toggleSizeHeader();
    }

    public /* synthetic */ void lambda$onCreate$4$AddVariantActivity(View view) { (view) ->  {
        this.addSizeInput();
    }

    public /* synthetic */ void lambda$onCreate$5$AddVariantActivity(View view) { (view) ->  {
        this.toggleColorHeader();
    }

    public /* synthetic */ void lambda$onCreate$6$AddVariantActivity(View view) { (view) ->  {
        this.addColorInput();
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
    }

    public void onApiError(ErrorResponse errorResponse) {
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
    }

    public void onColorSelected(int n, int n2) {
        View view = LayoutInflater.from((Context)this).inflate(2131558653, null);
        EditText editText = (EditText)view.findViewById(2131362043);
        TextView textView = (TextView)view.findViewById(2131361919);
        TextView textView2 = (TextView)view.findViewById(2131361959);
        textView.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$GEVJe3t0mZrvjiZOfDvO69b5FWg(this, view));
        textView2.setBackgroundColor(n2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(Integer.toHexString((int)n2));
        editText.setText((CharSequence)stringBuilder.toString());
        this.binding.colorInputContainer.addView(view);
    }

    @Override
    protected void onCreate(Bundle bundle, AddVariantViewModel addVariantViewModel, ActivityAddVariantBinding activityAddVariantBinding) {
        this.binding = activityAddVariantBinding;
        this.mViewModel = addVariantViewModel;
        addVariantViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityAddVariantBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityAddVariantBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$MCGGw5HUuf5mAZBnZQWMsJ7lTzE(this));
        this.initVariants();
        activityAddVariantBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$xp0Nm_BmFWrAf0vCb9a9yctGHAc(this));
        activityAddVariantBinding.idBtnFinish.setOnClickListener(new -$$Lambda$AddVariantActivity$Yi85XzQrQsnlpFgqD0N5eTR3kzc(this));
        activityAddVariantBinding.sizeHeader.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$HmCUtkeRS6qFrOYul7S-aniE7mY(this));
        activityAddVariantBinding.btnAddSize.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$nEkqegSrvXuS0shLcQT4pmfTDho(this));
        activityAddVariantBinding.colorHeader.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$bXFWzIeur2GKnhlcYknomk7es24(this));
        activityAddVariantBinding.btnAddColor.setOnClickListener((View.OnClickListener)new -$$Lambda$AddVariantActivity$-4iUToOtAUfJ5mg9jkiRtzlRY-4(this));
    }

    public void onDialogDismissed(int n) {
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        this.validateForm();
    }
}

