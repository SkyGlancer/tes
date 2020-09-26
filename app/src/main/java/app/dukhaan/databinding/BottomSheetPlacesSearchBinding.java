/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.recyclerview.widget.RecyclerView
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package app.dukhaan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BottomSheetPlacesSearchBinding
extends ViewDataBinding {
    public final TextView idCancel;
    public final ImageView idClose;
    public final ConstraintLayout idParent;
    public final EditText inputSearch;
    public final RecyclerView recyclerview;

    protected BottomSheetPlacesSearchBinding(Object object, View view, int n, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, EditText editText, RecyclerView recyclerView) {
        super(object, view, n);
        this.idCancel = textView;
        this.idClose = imageView;
        this.idParent = constraintLayout;
        this.inputSearch = editText;
        this.recyclerview = recyclerView;
    }

    public static BottomSheetPlacesSearchBinding bind(View view) {
        return BottomSheetPlacesSearchBinding.bind(view, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetPlacesSearchBinding bind(View view, Object object) {
        return (BottomSheetPlacesSearchBinding)BottomSheetPlacesSearchBinding.bind((Object)object, (View)view, (int)2131558456);
    }

    public static BottomSheetPlacesSearchBinding inflate(LayoutInflater layoutInflater) {
        return BottomSheetPlacesSearchBinding.inflate(layoutInflater, (Object)DataBindingUtil.getDefaultComponent());
    }

    public static BottomSheetPlacesSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        return BottomSheetPlacesSearchBinding.inflate(layoutInflater, viewGroup, bl, (Object)DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetPlacesSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl, Object object) {
        return (BottomSheetPlacesSearchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558456, (ViewGroup)viewGroup, (boolean)bl, (Object)object);
    }

    @Deprecated
    public static BottomSheetPlacesSearchBinding inflate(LayoutInflater layoutInflater, Object object) {
        return (BottomSheetPlacesSearchBinding)ViewDataBinding.inflateInternal((LayoutInflater)layoutInflater, (int)2131558456, null, (boolean)false, (Object)object);
    }
}

