/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.Window
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.GridView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.annotation.Annotation
 *  java.util.Arrays
 *  java.util.Locale
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.jaredrummler.android.colorpicker.ColorPaletteAdapter;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import com.jaredrummler.android.colorpicker.R;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Locale;

public class ColorPickerDialog
extends DialogFragment
implements ColorPickerView.OnColorChangedListener,
TextWatcher {
    static final int ALPHA_THRESHOLD = 165;
    private static final String ARG_ALLOW_CUSTOM = "allowCustom";
    private static final String ARG_ALLOW_PRESETS = "allowPresets";
    private static final String ARG_ALPHA = "alpha";
    private static final String ARG_COLOR = "color";
    private static final String ARG_COLOR_SHAPE = "colorShape";
    private static final String ARG_CUSTOM_BUTTON_TEXT = "customButtonText";
    private static final String ARG_DIALOG_TITLE = "dialogTitle";
    private static final String ARG_ID = "id";
    private static final String ARG_PRESETS = "presets";
    private static final String ARG_PRESETS_BUTTON_TEXT = "presetsButtonText";
    private static final String ARG_SELECTED_BUTTON_TEXT = "selectedButtonText";
    private static final String ARG_SHOW_COLOR_SHADES = "showColorShades";
    private static final String ARG_TYPE = "dialogType";
    public static final int[] MATERIAL_COLORS = new int[]{-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};
    private static final String TAG = "ColorPickerDialog";
    public static final int TYPE_CUSTOM = 0;
    public static final int TYPE_PRESETS = 1;
    ColorPaletteAdapter adapter;
    int color;
    ColorPickerView colorPicker;
    ColorPickerDialogListener colorPickerDialogListener;
    int colorShape;
    private int customButtonStringRes;
    int dialogId;
    int dialogType;
    private boolean fromEditText;
    EditText hexEditText;
    ColorPanelView newColorPanel;
    private final View.OnTouchListener onPickerTouchListener = new View.OnTouchListener(this){
        final /* synthetic */ ColorPickerDialog this$0;
        {
            this.this$0 = colorPickerDialog;
        }

        public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
            if (view != this.this$0.hexEditText && this.this$0.hexEditText.hasFocus()) {
                this.this$0.hexEditText.clearFocus();
                ((InputMethodManager)this.this$0.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.this$0.hexEditText.getWindowToken(), 0);
                this.this$0.hexEditText.clearFocus();
                return true;
            }
            return false;
        }
    };
    int[] presets;
    private int presetsButtonStringRes;
    FrameLayout rootView;
    LinearLayout shadesLayout;
    boolean showAlphaSlider;
    boolean showColorShades;
    TextView transparencyPercText;
    SeekBar transparencySeekBar;

    static /* synthetic */ int access$100(ColorPickerDialog colorPickerDialog) {
        return colorPickerDialog.customButtonStringRes;
    }

    static /* synthetic */ int access$200(ColorPickerDialog colorPickerDialog) {
        return colorPickerDialog.presetsButtonStringRes;
    }

    private int[] getColorShades(int n) {
        int[] arrn = new int[]{this.shadeColor(n, 0.9), this.shadeColor(n, 0.7), this.shadeColor(n, 0.5), this.shadeColor(n, 0.333), this.shadeColor(n, 0.166), this.shadeColor(n, -0.125), this.shadeColor(n, -0.25), this.shadeColor(n, -0.375), this.shadeColor(n, -0.5), this.shadeColor(n, -0.675), this.shadeColor(n, -0.7), this.shadeColor(n, -0.775)};
        return arrn;
    }

    private int getSelectedItemPosition() {
        int[] arrn;
        for (int i = 0; i < (arrn = this.presets).length; ++i) {
            if (arrn[i] != this.color) continue;
            return i;
        }
        return -1;
    }

    private void loadPresets() {
        int[] arrn;
        int n = Color.alpha((int)this.color);
        int[] arrn2 = this.getArguments().getIntArray(ARG_PRESETS);
        this.presets = arrn2;
        if (arrn2 == null) {
            this.presets = MATERIAL_COLORS;
        }
        boolean bl = this.presets == MATERIAL_COLORS;
        int[] arrn3 = this.presets;
        this.presets = Arrays.copyOf((int[])arrn3, (int)arrn3.length);
        if (n != 255) {
            int[] arrn4;
            for (int i = 0; i < (arrn4 = this.presets).length; ++i) {
                int n2 = arrn4[i];
                int n3 = Color.red((int)n2);
                int n4 = Color.green((int)n2);
                int n5 = Color.blue((int)n2);
                this.presets[i] = Color.argb((int)n, (int)n3, (int)n4, (int)n5);
            }
        }
        this.presets = this.unshiftIfNotExists(this.presets, this.color);
        int n6 = this.getArguments().getInt(ARG_COLOR);
        if (n6 != this.color) {
            this.presets = this.unshiftIfNotExists(this.presets, n6);
        }
        if (bl && (arrn = this.presets).length == 19) {
            this.presets = this.pushIfNotExists(arrn, Color.argb((int)n, (int)0, (int)0, (int)0));
        }
    }

    public static Builder newBuilder() {
        return new Object(){
            boolean allowCustom = true;
            boolean allowPresets = true;
            int color = -16777216;
            ColorPickerDialogListener colorPickerDialogListener;
            int colorShape = 1;
            int customButtonText = R.string.cpv_custom;
            int dialogId = 0;
            int dialogTitle = R.string.cpv_default_title;
            int dialogType = 1;
            int[] presets = ColorPickerDialog.MATERIAL_COLORS;
            int presetsButtonText = R.string.cpv_presets;
            int selectedButtonText = R.string.cpv_select;
            boolean showAlphaSlider = false;
            boolean showColorShades = true;

            public ColorPickerDialog create() {
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
                Bundle bundle = new Bundle();
                bundle.putInt(ColorPickerDialog.ARG_ID, this.dialogId);
                bundle.putInt(ColorPickerDialog.ARG_TYPE, this.dialogType);
                bundle.putInt(ColorPickerDialog.ARG_COLOR, this.color);
                bundle.putIntArray(ColorPickerDialog.ARG_PRESETS, this.presets);
                bundle.putBoolean(ColorPickerDialog.ARG_ALPHA, this.showAlphaSlider);
                bundle.putBoolean(ColorPickerDialog.ARG_ALLOW_CUSTOM, this.allowCustom);
                bundle.putBoolean(ColorPickerDialog.ARG_ALLOW_PRESETS, this.allowPresets);
                bundle.putInt(ColorPickerDialog.ARG_DIALOG_TITLE, this.dialogTitle);
                bundle.putBoolean(ColorPickerDialog.ARG_SHOW_COLOR_SHADES, this.showColorShades);
                bundle.putInt(ColorPickerDialog.ARG_COLOR_SHAPE, this.colorShape);
                bundle.putInt(ColorPickerDialog.ARG_PRESETS_BUTTON_TEXT, this.presetsButtonText);
                bundle.putInt(ColorPickerDialog.ARG_CUSTOM_BUTTON_TEXT, this.customButtonText);
                bundle.putInt(ColorPickerDialog.ARG_SELECTED_BUTTON_TEXT, this.selectedButtonText);
                colorPickerDialog.setArguments(bundle);
                return colorPickerDialog;
            }

            public Builder setAllowCustom(boolean bl) {
                this.allowCustom = bl;
                return this;
            }

            public Builder setAllowPresets(boolean bl) {
                this.allowPresets = bl;
                return this;
            }

            public Builder setColor(int n) {
                this.color = n;
                return this;
            }

            public Builder setColorShape(int n) {
                this.colorShape = n;
                return this;
            }

            public Builder setCustomButtonText(int n) {
                this.customButtonText = n;
                return this;
            }

            public Builder setDialogId(int n) {
                this.dialogId = n;
                return this;
            }

            public Builder setDialogTitle(int n) {
                this.dialogTitle = n;
                return this;
            }

            public Builder setDialogType(int n) {
                this.dialogType = n;
                return this;
            }

            public Builder setPresets(int[] arrn) {
                this.presets = arrn;
                return this;
            }

            public Builder setPresetsButtonText(int n) {
                this.presetsButtonText = n;
                return this;
            }

            public Builder setSelectedButtonText(int n) {
                this.selectedButtonText = n;
                return this;
            }

            public Builder setShowAlphaSlider(boolean bl) {
                this.showAlphaSlider = bl;
                return this;
            }

            public Builder setShowColorShades(boolean bl) {
                this.showColorShades = bl;
                return this;
            }

            public void show(FragmentActivity fragmentActivity) {
                this.create().show(fragmentActivity.getSupportFragmentManager(), "color-picker-dialog");
            }
        };
    }

    private void onColorSelected(int n) {
        if (this.colorPickerDialogListener != null) {
            Log.w((String)TAG, (String)"Using deprecated listener which may be remove in future releases");
            this.colorPickerDialogListener.onColorSelected(this.dialogId, n);
            return;
        }
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof ColorPickerDialogListener) {
            ((ColorPickerDialogListener)fragmentActivity).onColorSelected(this.dialogId, n);
            return;
        }
        throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
    }

    private void onDialogDismissed() {
        if (this.colorPickerDialogListener != null) {
            Log.w((String)TAG, (String)"Using deprecated listener which may be remove in future releases");
            this.colorPickerDialogListener.onDialogDismissed(this.dialogId);
            return;
        }
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof ColorPickerDialogListener) {
            ((ColorPickerDialogListener)fragmentActivity).onDialogDismissed(this.dialogId);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private int parseColorString(String string2) throws NumberFormatException {
        int n;
        int n2;
        int n3;
        int n4;
        block14 : {
            block9 : {
                int n5;
                block11 : {
                    block13 : {
                        block12 : {
                            block10 : {
                                block8 : {
                                    block7 : {
                                        block6 : {
                                            if (string2.startsWith("#")) {
                                                string2 = string2.substring(1);
                                            }
                                            int n6 = string2.length();
                                            n4 = -1;
                                            n2 = 0;
                                            if (n6 != 0) break block6;
                                            n = 0;
                                            break block7;
                                        }
                                        if (string2.length() > 2) break block8;
                                        n = Integer.parseInt((String)string2, (int)16);
                                    }
                                    n3 = 0;
                                    break block9;
                                }
                                if (string2.length() != 3) break block10;
                                n5 = Integer.parseInt((String)string2.substring(0, 1), (int)16);
                                n3 = Integer.parseInt((String)string2.substring(1, 2), (int)16);
                                n = Integer.parseInt((String)string2.substring(2, 3), (int)16);
                                break block11;
                            }
                            if (string2.length() != 4) break block12;
                            int n7 = Integer.parseInt((String)string2.substring(0, 2), (int)16);
                            n = Integer.parseInt((String)string2.substring(2, 4), (int)16);
                            n3 = n7;
                            n2 = 0;
                            break block9;
                        }
                        if (string2.length() != 5) break block13;
                        n5 = Integer.parseInt((String)string2.substring(0, 1), (int)16);
                        n3 = Integer.parseInt((String)string2.substring(1, 3), (int)16);
                        n = Integer.parseInt((String)string2.substring(3, 5), (int)16);
                        break block11;
                    }
                    if (string2.length() != 6) break block14;
                    n5 = Integer.parseInt((String)string2.substring(0, 2), (int)16);
                    n3 = Integer.parseInt((String)string2.substring(2, 4), (int)16);
                    n = Integer.parseInt((String)string2.substring(4, 6), (int)16);
                }
                n2 = n5;
            }
            n4 = 255;
            return Color.argb((int)n4, (int)n2, (int)n3, (int)n);
        }
        if (string2.length() == 7) {
            n4 = Integer.parseInt((String)string2.substring(0, 1), (int)16);
            int n8 = Integer.parseInt((String)string2.substring(1, 3), (int)16);
            int n9 = Integer.parseInt((String)string2.substring(3, 5), (int)16);
            n = Integer.parseInt((String)string2.substring(5, 7), (int)16);
            n2 = n8;
            n3 = n9;
            return Color.argb((int)n4, (int)n2, (int)n3, (int)n);
        }
        if (string2.length() == 8) {
            n4 = Integer.parseInt((String)string2.substring(0, 2), (int)16);
            int n10 = Integer.parseInt((String)string2.substring(2, 4), (int)16);
            int n11 = Integer.parseInt((String)string2.substring(4, 6), (int)16);
            n = Integer.parseInt((String)string2.substring(6, 8), (int)16);
            n2 = n10;
            n3 = n11;
            return Color.argb((int)n4, (int)n2, (int)n3, (int)n);
        }
        n = -1;
        n3 = -1;
        n2 = -1;
        return Color.argb((int)n4, (int)n2, (int)n3, (int)n);
    }

    private int[] pushIfNotExists(int[] arrn, int n) {
        boolean bl;
        block2 : {
            int n2 = arrn.length;
            for (int i = 0; i < n2; ++i) {
                if (arrn[i] != n) continue;
                bl = true;
                break block2;
            }
            bl = false;
        }
        if (!bl) {
            int n3 = 1 + arrn.length;
            int[] arrn2 = new int[n3];
            int n4 = n3 - 1;
            arrn2[n4] = n;
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)n4);
            return arrn2;
        }
        return arrn;
    }

    private void setHex(int n) {
        if (this.showAlphaSlider) {
            EditText editText = this.hexEditText;
            Object[] arrobject = new Object[]{n};
            editText.setText((CharSequence)String.format((String)"%08X", (Object[])arrobject));
            return;
        }
        EditText editText = this.hexEditText;
        Object[] arrobject = new Object[]{n & 16777215};
        editText.setText((CharSequence)String.format((String)"%06X", (Object[])arrobject));
    }

    private void setupTransparency() {
        int n = 255 - Color.alpha((int)this.color);
        this.transparencySeekBar.setMax(255);
        this.transparencySeekBar.setProgress(n);
        double d = n;
        Double.isNaN((double)d);
        int n2 = (int)(d * 100.0 / 255.0);
        TextView textView = this.transparencyPercText;
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{n2};
        textView.setText((CharSequence)String.format((Locale)locale, (String)"%d%%", (Object[])arrobject));
        this.transparencySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this){
            final /* synthetic */ ColorPickerDialog this$0;
            {
                this.this$0 = colorPickerDialog;
            }

            public void onProgressChanged(SeekBar seekBar, int n, boolean bl) {
                double d = n;
                Double.isNaN((double)d);
                int n2 = (int)(d * 100.0 / 255.0);
                TextView textView = this.this$0.transparencyPercText;
                Locale locale = Locale.ENGLISH;
                Object[] arrobject = new Object[1];
                Integer n3 = n2;
                int n4 = 0;
                arrobject[0] = n3;
                textView.setText((CharSequence)String.format((Locale)locale, (String)"%d%%", (Object[])arrobject));
                int n5 = 255 - n;
                for (int i = 0; i < this.this$0.adapter.colors.length; ++i) {
                    int n6 = this.this$0.adapter.colors[i];
                    int n7 = Color.red((int)n6);
                    int n8 = Color.green((int)n6);
                    int n9 = Color.blue((int)n6);
                    this.this$0.adapter.colors[i] = Color.argb((int)n5, (int)n7, (int)n8, (int)n9);
                }
                this.this$0.adapter.notifyDataSetChanged();
                while (n4 < this.this$0.shadesLayout.getChildCount()) {
                    FrameLayout frameLayout = (FrameLayout)this.this$0.shadesLayout.getChildAt(n4);
                    ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(R.id.cpv_color_panel_view);
                    ImageView imageView = (ImageView)frameLayout.findViewById(R.id.cpv_color_image_view);
                    if (frameLayout.getTag() == null) {
                        frameLayout.setTag((Object)colorPanelView.getBorderColor());
                    }
                    int n10 = colorPanelView.getColor();
                    int n11 = Color.argb((int)n5, (int)Color.red((int)n10), (int)Color.green((int)n10), (int)Color.blue((int)n10));
                    if (n5 <= 165) {
                        colorPanelView.setBorderColor(n11 | -16777216);
                    } else {
                        colorPanelView.setBorderColor((Integer)frameLayout.getTag());
                    }
                    if (colorPanelView.getTag() != null && ((Boolean)colorPanelView.getTag()).booleanValue()) {
                        if (n5 <= 165) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else if (androidx.core.graphics.ColorUtils.calculateLuminance((int)n11) >= 0.65) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else {
                            imageView.setColorFilter(-1, android.graphics.PorterDuff$Mode.SRC_IN);
                        }
                    }
                    colorPanelView.setColor(n11);
                    ++n4;
                }
                int n12 = Color.red((int)this.this$0.color);
                int n13 = Color.green((int)this.this$0.color);
                int n14 = Color.blue((int)this.this$0.color);
                this.this$0.color = Color.argb((int)n5, (int)n12, (int)n13, (int)n14);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private int shadeColor(int n, double d) {
        Object[] arrobject = new Object[]{16777215 & n};
        long l = Long.parseLong((String)String.format((String)"#%06X", (Object[])arrobject).substring(1), (int)16);
        double d2 = d < 0.0 ? 0.0 : 255.0;
        if (d < 0.0) {
            d *= -1.0;
        }
        long l2 = l >> 16;
        long l3 = 255L & l >> 8;
        long l4 = l & 255L;
        int n2 = Color.alpha((int)n);
        double d3 = l2;
        Double.isNaN((double)d3);
        int n3 = (int)(l2 + Math.round((double)(d * (d2 - d3))));
        double d4 = l3;
        Double.isNaN((double)d4);
        int n4 = (int)(l3 + Math.round((double)(d * (d2 - d4))));
        double d5 = l4;
        Double.isNaN((double)d5);
        return Color.argb((int)n2, (int)n3, (int)n4, (int)((int)(l4 + Math.round((double)(d * (d2 - d5))))));
    }

    private int[] unshiftIfNotExists(int[] arrn, int n) {
        boolean bl;
        block2 : {
            int n2 = arrn.length;
            for (int i = 0; i < n2; ++i) {
                if (arrn[i] != n) continue;
                bl = true;
                break block2;
            }
            bl = false;
        }
        if (!bl) {
            int n3 = 1 + arrn.length;
            int[] arrn2 = new int[n3];
            arrn2[0] = n;
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)1, (int)(n3 - 1));
            return arrn2;
        }
        return arrn;
    }

    public void afterTextChanged(Editable editable) {
        int n;
        if (this.hexEditText.isFocused() && (n = this.parseColorString(editable.toString())) != this.colorPicker.getColor()) {
            this.fromEditText = true;
            this.colorPicker.setColor(n, true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    void createColorShades(int n) {
        int[] arrn = this.getColorShades(n);
        int n2 = this.shadesLayout.getChildCount();
        if (n2 != 0) {
            for (int i = 0; i < this.shadesLayout.getChildCount(); ++i) {
                FrameLayout frameLayout = (FrameLayout)this.shadesLayout.getChildAt(i);
                ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(R.id.cpv_color_panel_view);
                ImageView imageView = (ImageView)frameLayout.findViewById(R.id.cpv_color_image_view);
                colorPanelView.setColor(arrn[i]);
                colorPanelView.setTag((Object)false);
                imageView.setImageDrawable(null);
            }
            return;
        }
        int n3 = this.getResources().getDimensionPixelSize(R.dimen.cpv_item_horizontal_padding);
        for (int n4 : arrn) {
            int n5 = this.colorShape == 0 ? R.layout.cpv_color_item_square : R.layout.cpv_color_item_circle;
            View view = View.inflate((Context)this.getActivity(), (int)n5, null);
            ColorPanelView colorPanelView = (ColorPanelView)view.findViewById(R.id.cpv_color_panel_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)colorPanelView.getLayoutParams();
            marginLayoutParams.rightMargin = n3;
            marginLayoutParams.leftMargin = n3;
            colorPanelView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            colorPanelView.setColor(n4);
            this.shadesLayout.addView(view);
            colorPanelView.post(new Runnable(this, colorPanelView, n4){
                final /* synthetic */ ColorPickerDialog this$0;
                final /* synthetic */ ColorPanelView val$colorPanelView;
                final /* synthetic */ int val$colorShade;
                {
                    this.this$0 = colorPickerDialog;
                    this.val$colorPanelView = colorPanelView;
                    this.val$colorShade = n;
                }

                public void run() {
                    this.val$colorPanelView.setColor(this.val$colorShade);
                }
            });
            colorPanelView.setOnClickListener(new View.OnClickListener(this, colorPanelView){
                final /* synthetic */ ColorPickerDialog this$0;
                final /* synthetic */ ColorPanelView val$colorPanelView;
                {
                    this.this$0 = colorPickerDialog;
                    this.val$colorPanelView = colorPanelView;
                }

                public void onClick(View view) {
                    if (view.getTag() instanceof Boolean && ((Boolean)view.getTag()).booleanValue()) {
                        ColorPickerDialog colorPickerDialog = this.this$0;
                        ColorPickerDialog.access$000(colorPickerDialog, colorPickerDialog.color);
                        this.this$0.dismiss();
                        return;
                    }
                    this.this$0.color = this.val$colorPanelView.getColor();
                    this.this$0.adapter.selectNone();
                    for (int i = 0; i < this.this$0.shadesLayout.getChildCount(); ++i) {
                        FrameLayout frameLayout = (FrameLayout)this.this$0.shadesLayout.getChildAt(i);
                        ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(R.id.cpv_color_panel_view);
                        ImageView imageView = (ImageView)frameLayout.findViewById(R.id.cpv_color_image_view);
                        int n = colorPanelView == view ? com.jaredrummler.android.colorpicker.R$drawable.cpv_preset_checked : 0;
                        imageView.setImageResource(n);
                        if (colorPanelView == view && androidx.core.graphics.ColorUtils.calculateLuminance((int)colorPanelView.getColor()) >= 0.65 || Color.alpha((int)colorPanelView.getColor()) <= 165) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else {
                            imageView.setColorFilter(null);
                        }
                        boolean bl = colorPanelView == view;
                        colorPanelView.setTag((Object)bl);
                    }
                }
            });
            colorPanelView.setOnLongClickListener(new View.OnLongClickListener(this, colorPanelView){
                final /* synthetic */ ColorPickerDialog this$0;
                final /* synthetic */ ColorPanelView val$colorPanelView;
                {
                    this.this$0 = colorPickerDialog;
                    this.val$colorPanelView = colorPanelView;
                }

                public boolean onLongClick(View view) {
                    this.val$colorPanelView.showHint();
                    return true;
                }
            });
        }
    }

    /*
     * Exception decompiling
     */
    View createPickerView() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl62.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    View createPresetsView() {
        ColorPaletteAdapter colorPaletteAdapter;
        View view = View.inflate((Context)this.getActivity(), (int)R.layout.cpv_dialog_presets, null);
        this.shadesLayout = (LinearLayout)view.findViewById(R.id.shades_layout);
        this.transparencySeekBar = (SeekBar)view.findViewById(R.id.transparency_seekbar);
        this.transparencyPercText = (TextView)view.findViewById(R.id.transparency_text);
        GridView gridView = (GridView)view.findViewById(R.id.gridView);
        this.loadPresets();
        if (this.showColorShades) {
            this.createColorShades(this.color);
        } else {
            this.shadesLayout.setVisibility(8);
            view.findViewById(R.id.shades_divider).setVisibility(8);
        }
        this.adapter = colorPaletteAdapter = new ColorPaletteAdapter(new ColorPaletteAdapter.OnColorSelectedListener(){

            @Override
            public void onColorSelected(int n) {
                if (ColorPickerDialog.this.color == n) {
                    ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                    colorPickerDialog.onColorSelected(colorPickerDialog.color);
                    ColorPickerDialog.this.dismiss();
                    return;
                }
                ColorPickerDialog.this.color = n;
                if (ColorPickerDialog.this.showColorShades) {
                    ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                    colorPickerDialog.createColorShades(colorPickerDialog.color);
                }
            }
        }, this.presets, this.getSelectedItemPosition(), this.colorShape);
        gridView.setAdapter((ListAdapter)colorPaletteAdapter);
        if (this.showAlphaSlider) {
            this.setupTransparency();
            return view;
        }
        view.findViewById(R.id.transparency_layout).setVisibility(8);
        view.findViewById(R.id.transparency_title).setVisibility(8);
        return view;
    }

    @Override
    public void onColorChanged(int n) {
        this.color = n;
        ColorPanelView colorPanelView = this.newColorPanel;
        if (colorPanelView != null) {
            colorPanelView.setColor(n);
        }
        if (!this.fromEditText && this.hexEditText != null) {
            this.setHex(n);
            if (this.hexEditText.hasFocus()) {
                ((InputMethodManager)this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.hexEditText.getWindowToken(), 0);
                this.hexEditText.clearFocus();
            }
        }
        this.fromEditText = false;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int n;
        FrameLayout frameLayout;
        this.dialogId = this.getArguments().getInt(ARG_ID);
        this.showAlphaSlider = this.getArguments().getBoolean(ARG_ALPHA);
        this.showColorShades = this.getArguments().getBoolean(ARG_SHOW_COLOR_SHADES);
        this.colorShape = this.getArguments().getInt(ARG_COLOR_SHAPE);
        if (bundle == null) {
            this.color = this.getArguments().getInt(ARG_COLOR);
            this.dialogType = this.getArguments().getInt(ARG_TYPE);
        } else {
            this.color = bundle.getInt(ARG_COLOR);
            this.dialogType = bundle.getInt(ARG_TYPE);
        }
        this.rootView = frameLayout = new FrameLayout((Context)this.requireActivity());
        int n2 = this.dialogType;
        if (n2 == 0) {
            frameLayout.addView(this.createPickerView());
        } else if (n2 == 1) {
            frameLayout.addView(this.createPresetsView());
        }
        int n3 = this.getArguments().getInt(ARG_SELECTED_BUTTON_TEXT);
        if (n3 == 0) {
            n3 = R.string.cpv_select;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.requireActivity()).setView((View)this.rootView).setPositiveButton(n3, new DialogInterface.OnClickListener(this){
            final /* synthetic */ ColorPickerDialog this$0;
            {
                this.this$0 = colorPickerDialog;
            }

            public void onClick(DialogInterface dialogInterface, int n) {
                ColorPickerDialog colorPickerDialog = this.this$0;
                ColorPickerDialog.access$000(colorPickerDialog, colorPickerDialog.color);
            }
        });
        int n4 = this.getArguments().getInt(ARG_DIALOG_TITLE);
        if (n4 != 0) {
            builder.setTitle(n4);
        }
        this.presetsButtonStringRes = this.getArguments().getInt(ARG_PRESETS_BUTTON_TEXT);
        this.customButtonStringRes = this.getArguments().getInt(ARG_CUSTOM_BUTTON_TEXT);
        if (this.dialogType == 0 && this.getArguments().getBoolean(ARG_ALLOW_PRESETS)) {
            n = this.presetsButtonStringRes;
            if (n == 0) {
                n = R.string.cpv_presets;
            }
        } else if (this.dialogType == 1 && this.getArguments().getBoolean(ARG_ALLOW_CUSTOM)) {
            n = this.customButtonStringRes;
            if (n == 0) {
                n = R.string.cpv_custom;
            }
        } else {
            n = 0;
        }
        if (n != 0) {
            builder.setNeutralButton(n, null);
        }
        return builder.create();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.onDialogDismissed();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(ARG_COLOR, this.color);
        bundle.putInt(ARG_TYPE, this.dialogType);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog)this.getDialog();
        alertDialog.getWindow().clearFlags(131080);
        alertDialog.getWindow().setSoftInputMode(4);
        Button button = alertDialog.getButton(-3);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ ColorPickerDialog this$0;
                {
                    this.this$0 = colorPickerDialog;
                }

                public void onClick(View view) {
                    this.this$0.rootView.removeAllViews();
                    int n = this.this$0.dialogType;
                    if (n != 0) {
                        if (n != 1) {
                            return;
                        }
                        this.this$0.dialogType = 0;
                        Button button = (Button)view;
                        int n2 = ColorPickerDialog.access$200(this.this$0) != 0 ? ColorPickerDialog.access$200(this.this$0) : R.string.cpv_presets;
                        button.setText(n2);
                        this.this$0.rootView.addView(this.this$0.createPickerView());
                        return;
                    }
                    this.this$0.dialogType = 1;
                    Button button = (Button)view;
                    int n3 = ColorPickerDialog.access$100(this.this$0) != 0 ? ColorPickerDialog.access$100(this.this$0) : R.string.cpv_custom;
                    button.setText(n3);
                    this.this$0.rootView.addView(this.this$0.createPresetsView());
                }
            });
        }
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    public void setColorPickerDialogListener(ColorPickerDialogListener colorPickerDialogListener) {
        this.colorPickerDialogListener = colorPickerDialogListener;
    }

}

