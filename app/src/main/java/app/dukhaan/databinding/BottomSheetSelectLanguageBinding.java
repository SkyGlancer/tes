/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BottomSheetSelectLanguageBinding
extends ViewDataBinding {
    public final Guideline guideline;
    public final TextView idBtnEnglish;
    public final TextView idBtnHindi;
    public final TextView idBtnMarathi;
    public final TextView idTitle;

    protected BottomSheetSelectLanguageBinding(Object object, View view, int n, Guideline guideline, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n);
        this.guideline = guideline;
        this.idBtnEnglish = textView;
        this.idBtnHindi = textView2;
        this.idBtnMarathi = textView3;
        this.idTitle = textView4;
    }

    public static BottomSheetSelectLanguageBinding bind(View view) {
        return BottomSheetSelectLanguageBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetSelectLanguageBinding bind(View view, Object object) {
        return (BottomSheetSelectLanguageBinding)BottomSheetSelectLanguageBinding.bind((Object)object, (View)view, (int)2131558457);
    }

    public static BottomSheetSelectLanguageBinding inflate(LayoutInflater layoutInflater) {
        return BottomSheetSelectLanguageBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BottomSheetSelectLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BottomSheetSelectLanguageBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetSelectLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BottomSheetSelectLanguageBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558457, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BottomSheetSelectLanguageBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BottomSheetSelectLanguageBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558457, null, (boolean)false, (Object)object);
    }
}

