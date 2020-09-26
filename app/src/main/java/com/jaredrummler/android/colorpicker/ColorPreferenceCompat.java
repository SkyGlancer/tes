/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.preference.Preference
 *  androidx.preference.PreferenceViewHolder
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.R;

public class ColorPreferenceCompat
extends Preference
implements ColorPickerDialogListener {
    private static final int SIZE_LARGE = 1;
    private static final int SIZE_NORMAL;
    private boolean allowCustom;
    private boolean allowPresets;
    private int color = -16777216;
    private int colorShape;
    private int dialogTitle;
    private int dialogType;
    private OnShowDialogListener onShowDialogListener;
    private int[] presets;
    private int previewSize;
    private boolean showAlphaSlider;
    private boolean showColorShades;
    private boolean showDialog;

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
    }

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.setPersistent(true);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPreference);
        this.showDialog = typedArray.getBoolean(R.styleable.ColorPreference_cpv_showDialog, true);
        this.dialogType = typedArray.getInt(R.styleable.ColorPreference_cpv_dialogType, 1);
        this.colorShape = typedArray.getInt(R.styleable.ColorPreference_cpv_colorShape, 1);
        this.allowPresets = typedArray.getBoolean(R.styleable.ColorPreference_cpv_allowPresets, true);
        this.allowCustom = typedArray.getBoolean(R.styleable.ColorPreference_cpv_allowCustom, true);
        this.showAlphaSlider = typedArray.getBoolean(R.styleable.ColorPreference_cpv_showAlphaSlider, false);
        this.showColorShades = typedArray.getBoolean(R.styleable.ColorPreference_cpv_showColorShades, true);
        this.previewSize = typedArray.getInt(R.styleable.ColorPreference_cpv_previewSize, 0);
        int n = typedArray.getResourceId(R.styleable.ColorPreference_cpv_colorPresets, 0);
        this.dialogTitle = typedArray.getResourceId(R.styleable.ColorPreference_cpv_dialogTitle, R.string.cpv_default_title);
        this.presets = n != 0 ? this.getContext().getResources().getIntArray(n) : ColorPickerDialog.MATERIAL_COLORS;
        if (this.colorShape == 1) {
            int n2 = this.previewSize == 1 ? R.layout.cpv_preference_circle_large : R.layout.cpv_preference_circle;
            this.setWidgetLayoutResource(n2);
        } else {
            int n3 = this.previewSize == 1 ? R.layout.cpv_preference_square_large : R.layout.cpv_preference_square;
            this.setWidgetLayoutResource(n3);
        }
        typedArray.recycle();
    }

    public FragmentActivity getActivity() {
        Context context;
        Context context2 = this.getContext();
        if (context2 instanceof FragmentActivity) {
            return (FragmentActivity)context2;
        }
        if (context2 instanceof ContextWrapper && (context = ((ContextWrapper)context2).getBaseContext()) instanceof FragmentActivity) {
            return (FragmentActivity)context;
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    public String getFragmentTag() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("color_");
        stringBuilder.append(this.getKey());
        return stringBuilder.toString();
    }

    public int[] getPresets() {
        return this.presets;
    }

    public void onAttached() {
        ColorPickerDialog colorPickerDialog;
        super.onAttached();
        if (this.showDialog && (colorPickerDialog = (ColorPickerDialog)this.getActivity().getSupportFragmentManager().findFragmentByTag(this.getFragmentTag())) != null) {
            colorPickerDialog.setColorPickerDialogListener(this);
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ColorPanelView colorPanelView = (ColorPanelView)preferenceViewHolder.itemView.findViewById(R.id.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.color);
        }
    }

    protected void onClick() {
        super.onClick();
        OnShowDialogListener onShowDialogListener = this.onShowDialogListener;
        if (onShowDialogListener != null) {
            onShowDialogListener.onShowColorPickerDialog((String)this.getTitle(), this.color);
            return;
        }
        if (this.showDialog) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.newBuilder().setDialogType(this.dialogType).setDialogTitle(this.dialogTitle).setColorShape(this.colorShape).setPresets(this.presets).setAllowPresets(this.allowPresets).setAllowCustom(this.allowCustom).setShowAlphaSlider(this.showAlphaSlider).setShowColorShades(this.showColorShades).setColor(this.color).create();
            colorPickerDialog.setColorPickerDialogListener(this);
            this.getActivity().getSupportFragmentManager().beginTransaction().add((Fragment)colorPickerDialog, this.getFragmentTag()).commitAllowingStateLoss();
        }
    }

    @Override
    public void onColorSelected(int n, int n2) {
        this.saveValue(n2);
    }

    @Override
    public void onDialogDismissed(int n) {
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int n) {
        return typedArray.getInteger(n, -16777216);
    }

    protected void onSetInitialValue(Object object) {
        super.onSetInitialValue(object);
        if (object instanceof Integer) {
            int n;
            this.color = n = ((Integer)object).intValue();
            this.persistInt(n);
            return;
        }
        this.color = this.getPersistedInt(-16777216);
    }

    public void saveValue(int n) {
        this.color = n;
        this.persistInt(n);
        this.notifyChanged();
        this.callChangeListener((Object)n);
    }

    public void setOnShowDialogListener(OnShowDialogListener onShowDialogListener) {
        this.onShowDialogListener = onShowDialogListener;
    }

    public void setPresets(int[] arrn) {
        this.presets = arrn;
    }

}

