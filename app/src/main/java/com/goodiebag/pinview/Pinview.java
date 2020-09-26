/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.text.InputFilter$LengthFilter
 *  android.text.TextWatcher
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.src.java.com.goodiebag.pinview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.goodiebag.pinview.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pinview
extends LinearLayout
implements TextWatcher,
View.OnFocusChangeListener,
View.OnKeyListener {
    private final float DENSITY;
    View currentFocus;
    private List<EditText> editTextList;
    InputFilter[] filters;
    private boolean finalNumberPin;
    private boolean fromSetValue;
    private InputType inputType;
    OnClickListener mClickListener;
    private boolean mCursorVisible;
    private boolean mDelPressed;
    private boolean mForceKeyboard;
    private String mHint;
    private PinViewEventListener mListener;
    private boolean mPassword;
    private int mPinBackground;
    private int mPinHeight;
    private int mPinLength;
    private int mPinWidth;
    private int mSplitWidth;
    LayoutParams params;

    public Pinview(Context context) {
        this(context, null);
    }

    public Pinview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Pinview(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.DENSITY = this.getContext().getResources().getDisplayMetrics().density;
        this.mPinLength = 4;
        this.editTextList = new ArrayList();
        this.mPinWidth = 50;
        this.mPinHeight = 50;
        this.mSplitWidth = 20;
        this.mCursorVisible = false;
        this.mDelPressed = false;
        this.mPinBackground = R.drawable.sample_background;
        this.mPassword = false;
        this.mHint = "";
        this.inputType = InputType.TEXT;
        this.finalNumberPin = false;
        this.fromSetValue = false;
        this.mForceKeyboard = true;
        this.currentFocus = null;
        this.filters = new InputFilter[1];
        this.setGravity(17);
        this.init(context, attributeSet, n);
    }

    private void createEditTexts() {
        this.removeAllViews();
        this.editTextList.clear();
        for (int i = 0; i < this.mPinLength; ++i) {
            EditText editText = new EditText(this.getContext());
            this.editTextList.add(i, (Object)editText);
            this.addView((View)editText);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i);
            this.generateOneEditText(editText, stringBuilder.toString());
        }
        this.setTransformation();
    }

    private void generateOneEditText(EditText editText, String string2) {
        LayoutParams layoutParams = this.params;
        int n = this.mSplitWidth;
        int n2 = n / 2;
        int n3 = n / 2;
        int n4 = n / 2;
        int n5 = 2;
        layoutParams.setMargins(n2, n3, n4, n / n5);
        this.filters[0] = new InputFilter.LengthFilter(1);
        editText.setFilters(this.filters);
        editText.setLayoutParams((ViewGroup.LayoutParams)this.params);
        editText.setGravity(17);
        editText.setCursorVisible(this.mCursorVisible);
        if (!this.mCursorVisible) {
            editText.setClickable(false);
            editText.setHint((CharSequence)this.mHint);
            editText.setOnTouchListener(new OnTouchListener(){

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Pinview.this.mDelPressed = false;
                    return false;
                }
            });
        }
        editText.setBackgroundResource(this.mPinBackground);
        editText.setPadding(0, 0, 0, 0);
        editText.setTag((Object)string2);
        if (5.$SwitchMap$com$goodiebag$pinview$Pinview$InputType[this.inputType.ordinal()] != 1) {
            n5 = 1;
        }
        editText.setInputType(n5);
        editText.addTextChangedListener((TextWatcher)this);
        editText.setOnFocusChangeListener((OnFocusChangeListener)this);
        editText.setOnKeyListener((OnKeyListener)this);
    }

    private int getIndexOfCurrentFocus() {
        return this.editTextList.indexOf((Object)this.currentFocus);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.removeAllViews();
        float f = this.mPinHeight;
        float f2 = this.DENSITY;
        this.mPinHeight = (int)(f * f2);
        this.mPinWidth = (int)(f2 * (float)this.mPinWidth);
        this.mSplitWidth = (int)(f2 * (float)this.mSplitWidth);
        this.setWillNotDraw(false);
        this.initAttributes(context, attributeSet, n);
        this.params = new LayoutParams(this.mPinWidth, this.mPinHeight);
        this.setOrientation(0);
        this.createEditTexts();
        super.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {
                boolean bl;
                block4 : {
                    for (EditText editText : Pinview.this.editTextList) {
                        if (editText.length() != 0) continue;
                        editText.requestFocus();
                        if (Pinview.this.mForceKeyboard) {
                            ((InputMethodManager)Pinview.this.getContext().getSystemService("input_method")).toggleSoftInput(2, 1);
                        }
                        bl = true;
                        break block4;
                    }
                    bl = false;
                }
                if (!bl && Pinview.this.editTextList.size() > 0) {
                    ((EditText)Pinview.this.editTextList.get(Pinview.this.editTextList.size() - 1)).requestFocus();
                }
                if (Pinview.this.mClickListener != null) {
                    Pinview.this.mClickListener.onClick((View)Pinview.this);
                }
            }
        });
        if (this.editTextList.get(0) != null && this.mForceKeyboard) {
            ((EditText)this.editTextList.get(0)).postDelayed(new Runnable(){

                public void run() {
                    ((InputMethodManager)Pinview.this.getContext().getSystemService("input_method")).toggleSoftInput(2, 1);
                }
            }, 200L);
        }
    }

    private void initAttributes(Context context, AttributeSet attributeSet, int n) {
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Pinview, n, 0);
            this.mPinBackground = typedArray.getResourceId(R.styleable.Pinview_pinBackground, this.mPinBackground);
            this.mPinLength = typedArray.getInt(R.styleable.Pinview_pinLength, this.mPinLength);
            this.mPinHeight = (int)typedArray.getDimension(R.styleable.Pinview_pinHeight, (float)this.mPinHeight);
            this.mPinWidth = (int)typedArray.getDimension(R.styleable.Pinview_pinWidth, (float)this.mPinWidth);
            this.mSplitWidth = (int)typedArray.getDimension(R.styleable.Pinview_splitWidth, (float)this.mSplitWidth);
            this.mCursorVisible = typedArray.getBoolean(R.styleable.Pinview_cursorVisible, this.mCursorVisible);
            this.mPassword = typedArray.getBoolean(R.styleable.Pinview_password, this.mPassword);
            this.mForceKeyboard = typedArray.getBoolean(R.styleable.Pinview_forceKeyboard, this.mForceKeyboard);
            this.mHint = typedArray.getString(R.styleable.Pinview_hint);
            this.inputType = InputType.values()[typedArray.getInt(R.styleable.Pinview_inputType, 0)];
            typedArray.recycle();
        }
    }

    private void setTransformation() {
        if (this.mPassword) {
            for (EditText editText : this.editTextList) {
                editText.removeTextChangedListener((TextWatcher)this);
                editText.setTransformationMethod((TransformationMethod)new PinTransformationMethod());
                editText.addTextChangedListener((TextWatcher)this);
            }
        } else {
            for (EditText editText : this.editTextList) {
                editText.removeTextChangedListener((TextWatcher)this);
                editText.setTransformationMethod(null);
                editText.addTextChangedListener((TextWatcher)this);
            }
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    public String getHint() {
        return this.mHint;
    }

    public InputType getInputType() {
        return this.inputType;
    }

    public int getPinBackground() {
        return this.mPinBackground;
    }

    public int getPinHeight() {
        return this.mPinHeight;
    }

    public int getPinLength() {
        return this.mPinLength;
    }

    public int getPinWidth() {
        return this.mPinWidth;
    }

    public int getSplitWidth() {
        return this.mSplitWidth;
    }

    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((EditText)iterator.next()).getText().toString());
        }
        return stringBuilder.toString();
    }

    public boolean isPassword() {
        return this.mPassword;
    }

    public void onFocusChange(View view, boolean bl) {
        if (bl && !this.mCursorVisible) {
            if (this.mDelPressed) {
                this.currentFocus = view;
                this.mDelPressed = false;
                return;
            }
            for (EditText editText : this.editTextList) {
                if (editText.length() != 0) continue;
                if (editText != view) {
                    editText.requestFocus();
                    return;
                }
                this.currentFocus = view;
                return;
            }
            List<EditText> list = this.editTextList;
            if (list.get(-1 + list.size()) != view) {
                List<EditText> list2 = this.editTextList;
                ((EditText)list2.get(-1 + list2.size())).requestFocus();
                return;
            }
            this.currentFocus = view;
            return;
        }
        if (bl && this.mCursorVisible) {
            this.currentFocus = view;
            return;
        }
        view.clearFocus();
    }

    public boolean onKey(View view, int n, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 67) {
            int n2 = this.getIndexOfCurrentFocus();
            if (this.inputType == InputType.NUMBER && n2 == this.mPinLength - 1 && this.finalNumberPin || this.mPassword && n2 == this.mPinLength - 1 && this.finalNumberPin) {
                if (((EditText)this.editTextList.get(n2)).length() > 0) {
                    ((EditText)this.editTextList.get(n2)).setText((CharSequence)"");
                }
                this.finalNumberPin = false;
                return true;
            }
            if (n2 > 0) {
                this.mDelPressed = true;
                if (((EditText)this.editTextList.get(n2)).length() == 0) {
                    ((EditText)this.editTextList.get(n2 - 1)).requestFocus();
                    ((EditText)this.editTextList.get(n2)).setText((CharSequence)"");
                    return true;
                }
                ((EditText)this.editTextList.get(n2)).setText((CharSequence)"");
                return true;
            }
            if (((EditText)this.editTextList.get(n2)).getText().length() > 0) {
                ((EditText)this.editTextList.get(n2)).setText((CharSequence)"");
            }
            return true;
        }
        return false;
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        if (charSequence.length() == 1 && this.currentFocus != null) {
            final int n4 = this.getIndexOfCurrentFocus();
            if (n4 < this.mPinLength - 1) {
                long l = 1L;
                if (this.mPassword) {
                    l = 25L;
                }
                this.postDelayed(new Runnable(){

                    public void run() {
                        ((EditText)Pinview.this.editTextList.get(1 + n4)).requestFocus();
                    }
                }, l);
            }
            if (n4 == this.mPinLength - 1 && this.inputType == InputType.NUMBER || n4 == this.mPinLength - 1 && this.mPassword) {
                this.finalNumberPin = true;
            }
        } else if (charSequence.length() == 0) {
            int n5 = this.getIndexOfCurrentFocus();
            this.mDelPressed = true;
            if (((EditText)this.editTextList.get(n5)).getText().length() > 0) {
                ((EditText)this.editTextList.get(n5)).setText((CharSequence)"");
            }
        }
        for (int i = 0; i < this.mPinLength; ++i) {
            PinViewEventListener pinViewEventListener;
            if (((EditText)this.editTextList.get(i)).getText().length() < 1) {
                return;
            }
            if (this.fromSetValue || i + 1 != this.mPinLength || (pinViewEventListener = this.mListener) == null) continue;
            pinViewEventListener.onDataEntered(this, true);
        }
    }

    public void setHint(String string2) {
        this.mHint = string2;
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            ((EditText)iterator.next()).setHint((CharSequence)string2);
        }
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
        for (EditText editText : this.editTextList) {
            int n = 5.$SwitchMap$com$goodiebag$pinview$Pinview$InputType[inputType.ordinal()];
            int n2 = 2;
            if (n != 1) {
                n2 = 1;
            }
            if (this.mPassword) {
                if (inputType == InputType.NUMBER) {
                    n2 = 18;
                } else if (inputType == InputType.TEXT) {
                    n2 = 129;
                }
            }
            editText.setInputType(n2);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setPassword(boolean bl) {
        this.mPassword = bl;
        this.setTransformation();
    }

    public void setPinBackgroundRes(int n) {
        this.mPinBackground = n;
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            ((EditText)iterator.next()).setBackgroundResource(n);
        }
    }

    public void setPinHeight(int n) {
        this.mPinHeight = n;
        this.params.height = n;
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            ((EditText)iterator.next()).setLayoutParams((ViewGroup.LayoutParams)this.params);
        }
    }

    public void setPinLength(int n) {
        this.mPinLength = n;
        this.createEditTexts();
    }

    public void setPinViewEventListener(PinViewEventListener pinViewEventListener) {
        this.mListener = pinViewEventListener;
    }

    public void setPinWidth(int n) {
        this.mPinWidth = n;
        this.params.width = n;
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            ((EditText)iterator.next()).setLayoutParams((ViewGroup.LayoutParams)this.params);
        }
    }

    public void setSplitWidth(int n) {
        this.mSplitWidth = n;
        int n2 = n / 2;
        this.params.setMargins(n2, n2, n2, n2);
        Iterator iterator = this.editTextList.iterator();
        while (iterator.hasNext()) {
            ((EditText)iterator.next()).setLayoutParams((ViewGroup.LayoutParams)this.params);
        }
    }

    public void setValue(String string2) {
        this.fromSetValue = true;
        if (this.inputType == InputType.NUMBER && !string2.matches("[0-9]+")) {
            return;
        }
        int n = -1;
        for (int i = 0; i < this.editTextList.size(); ++i) {
            if (string2.length() > i) {
                ((EditText)this.editTextList.get(i)).setText((CharSequence)Character.valueOf((char)string2.charAt(i)).toString());
                n = i;
                continue;
            }
            ((EditText)this.editTextList.get(i)).setText((CharSequence)"");
        }
        int n2 = this.mPinLength;
        if (n2 > 0) {
            if (n < n2 - 1) {
                this.currentFocus = (View)this.editTextList.get(n + 1);
            } else {
                PinViewEventListener pinViewEventListener;
                this.currentFocus = (View)this.editTextList.get(n2 - 1);
                if (this.inputType == InputType.NUMBER || this.mPassword) {
                    this.finalNumberPin = true;
                }
                if ((pinViewEventListener = this.mListener) != null) {
                    pinViewEventListener.onDataEntered(this, false);
                }
            }
            this.currentFocus.requestFocus();
        }
        this.fromSetValue = false;
    }

    public static final class InputType
    extends Enum<InputType> {
        private static final /* synthetic */ InputType[] $VALUES;
        public static final /* enum */ InputType NUMBER;
        public static final /* enum */ InputType TEXT;

        static {
            InputType inputType;
            TEXT = new InputType();
            NUMBER = inputType = new InputType();
            InputType[] arrinputType = new InputType[]{TEXT, inputType};
            $VALUES = arrinputType;
        }

        public static InputType valueOf(String string2) {
            return (InputType)Enum.valueOf(InputType.class, (String)string2);
        }

        public static InputType[] values() {
            return (InputType[])$VALUES.clone();
        }
    }

    private class PinTransformationMethod
    implements TransformationMethod {
        private char BULLET = (char)8226;

        private PinTransformationMethod() {
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            return new PasswordCharSequence(charSequence);
        }

        public void onFocusChanged(View view, CharSequence charSequence, boolean bl, int n, Rect rect) {
        }

        private class PasswordCharSequence
        implements CharSequence {
            private final CharSequence source;

            public PasswordCharSequence(CharSequence charSequence) {
                this.source = charSequence;
            }

            public char charAt(int n) {
                return PinTransformationMethod.this.BULLET;
            }

            public int length() {
                return this.source.length();
            }

            public CharSequence subSequence(int n, int n2) {
                return new PasswordCharSequence(this.source.subSequence(n, n2));
            }
        }

    }

    public static interface PinViewEventListener {
        public void onDataEntered(Pinview var1, boolean var2);
    }

}

