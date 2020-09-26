/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.text.InputFilter$LengthFilter
 *  android.text.Spanned
 *  android.text.TextWatcher
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  app.dukhaan.otpview.OTPChildEditText
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.otpview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import app.dukhaan.R;
import app.dukhaan.otpview.ItemView;
import app.dukhaan.otpview.OTPChildEditText;
import app.dukhaan.otpview.OTPListener;
import app.dukhaan.otpview.OtpUtils;
import app.dukhaan.util.AppUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtpTextView
extends FrameLayout {
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_LENGTH = 4;
    private static final int DEFAULT_SPACE = -1;
    private static final int DEFAULT_SPACE_BOTTOM = 4;
    private static final int DEFAULT_SPACE_LEFT = 4;
    private static final int DEFAULT_SPACE_RIGHT = 4;
    private static final int DEFAULT_SPACE_TOP = 4;
    private static final int DEFAULT_WIDTH = 48;
    private static final String PATTERN = "[1234567890]*";
    private Context context;
    private List<ItemView> itemViews;
    private int length;
    public OTPChildEditText otpChildEditText;
    private OTPListener otpListener;
    private int viewWidth;

    public OtpTextView(Context context) {
        super(context);
        this.context = context;
        this.init(null);
    }

    public OtpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.init(attributeSet);
    }

    public OtpTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.context = context;
        this.init(attributeSet);
    }

    private void generateViews(TypedArray typedArray, AttributeSet attributeSet) {
        IllegalStateException illegalStateException;
        this.itemViews = new ArrayList();
        if (this.length > 0) {
            OTPChildEditText oTPChildEditText;
            String string2 = typedArray.getString(21);
            int n = (int)typedArray.getDimension(29, (float)OtpUtils.getPixels(this.context, 48));
            int n2 = (int)typedArray.getDimension(17, (float)OtpUtils.getPixels(this.context, 48));
            int n3 = (int)typedArray.getDimension(12, (float)OtpUtils.getPixels(this.context, -1));
            typedArray.getDimension(14, (float)OtpUtils.getPixels(this.context, 4));
            typedArray.getDimension(15, (float)OtpUtils.getPixels(this.context, 4));
            typedArray.getDimension(16, (float)OtpUtils.getPixels(this.context, 4));
            typedArray.getDimension(13, (float)OtpUtils.getPixels(this.context, 4));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            this.otpChildEditText = oTPChildEditText = new OTPChildEditText(this.context);
            InputFilter[] arrinputFilter = new InputFilter[]{this.getFilter(), new InputFilter.LengthFilter(this.length)};
            oTPChildEditText.setFilters(arrinputFilter);
            this.setTextWatcher(this.otpChildEditText);
            this.addView((View)this.otpChildEditText, (ViewGroup.LayoutParams)layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout = new LinearLayout(this.context);
            this.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
            int n4 = this.getSpaceWidth(n);
            for (int i = 0; i < this.length; ++i) {
                ItemView itemView = new ItemView(this.context, attributeSet);
                itemView.setViewState(0);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(n, n2);
                if (i < this.length) {
                    layoutParams3.setMargins(0, n3, n4, n3);
                } else {
                    layoutParams3.setMargins(0, n3, 0, n3);
                }
                linearLayout.addView((View)itemView, i, (ViewGroup.LayoutParams)layoutParams3);
                this.itemViews.add((Object)itemView);
            }
            if (string2 != null) {
                this.setOTP(string2);
                return;
            }
            this.setOTP("");
            return;
        }
        illegalStateException = new IllegalStateException("Please specify the length of the otp view");
        throw illegalStateException;
    }

    private InputFilter getFilter() {
        return new InputFilter(){

            public CharSequence filter(CharSequence charSequence, int n, int n2, Spanned spanned, int n3, int n4) {
                while (n < n2) {
                    if (!Pattern.compile((String)OtpTextView.PATTERN).matcher((CharSequence)String.valueOf((char)charSequence.charAt(n))).matches()) {
                        return "";
                    }
                    ++n;
                }
                return null;
            }
        };
    }

    private int getSpaceWidth(int n) {
        return (this.getResources().getDisplayMetrics().widthPixels - AppUtils.dpToPx(32) - n * 6) / 5;
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.OtpTextView);
        this.styleEditTexts(typedArray, attributeSet);
        typedArray.recycle();
    }

    private void setFocus(int n) {
        for (int i = 0; i < this.itemViews.size(); ++i) {
            if (i == n) {
                ((ItemView)((Object)this.itemViews.get(i))).setViewState(1);
                continue;
            }
            ((ItemView)((Object)this.itemViews.get(i))).setViewState(0);
        }
        if (n == this.itemViews.size()) {
            List<ItemView> list = this.itemViews;
            ((ItemView)((Object)list.get(list.size() - 1))).setViewState(1);
        }
    }

    private void setTextWatcher(OTPChildEditText oTPChildEditText) {
        oTPChildEditText.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                OtpTextView.this.setOTP(charSequence);
                OtpTextView.this.setFocus(charSequence.length());
                if (OtpTextView.this.otpListener != null) {
                    OtpTextView.this.otpListener.onInteractionListener();
                    if (charSequence.length() == OtpTextView.this.length) {
                        OtpTextView.this.otpListener.onOTPComplete(charSequence.toString());
                    }
                }
            }
        });
    }

    private void styleEditTexts(TypedArray typedArray, AttributeSet attributeSet) {
        this.length = typedArray.getInt(20, 4);
        this.generateViews(typedArray, attributeSet);
    }

    public String getOTP() {
        OTPChildEditText oTPChildEditText = this.otpChildEditText;
        if (oTPChildEditText != null && oTPChildEditText.getText() != null) {
            return this.otpChildEditText.getText().toString();
        }
        return null;
    }

    public OTPListener getOtpListener() {
        return this.otpListener;
    }

    public void requestFocusOTP() {
        OTPChildEditText oTPChildEditText = this.otpChildEditText;
        if (oTPChildEditText != null) {
            oTPChildEditText.requestFocus();
        }
    }

    public void resetState() {
        this.setFocus(this.getOTP().length());
    }

    public void setOTP(CharSequence charSequence) {
        for (int i = 0; i < this.itemViews.size(); ++i) {
            if (i < charSequence.length()) {
                ((ItemView)((Object)this.itemViews.get(i))).setText(String.valueOf((char)charSequence.charAt(i)));
                continue;
            }
            ((ItemView)((Object)this.itemViews.get(i))).setText("");
        }
    }

    public void setOTP(String string2) {
        this.otpChildEditText.setText((CharSequence)string2);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.otpChildEditText.setOnTouchListener(onTouchListener);
    }

    public void setOtpListener(OTPListener oTPListener) {
        this.otpListener = oTPListener;
    }

    public void showError() {
        List<ItemView> list = this.itemViews;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((ItemView)((Object)iterator.next())).setViewState(-1);
            }
        }
    }

    public void showSuccess() {
        List<ItemView> list = this.itemViews;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((ItemView)((Object)iterator.next())).setViewState(2);
            }
        }
    }

}

