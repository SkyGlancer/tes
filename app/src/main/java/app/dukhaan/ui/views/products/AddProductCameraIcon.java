/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  app.dukhaan.databinding.AddProductCameraIconBinding
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.products;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import app.dukhaan.databinding.AddProductCameraIconBinding;

public class AddProductCameraIcon
extends FrameLayout {
    private AddProductCameraIconBinding binding;

    public AddProductCameraIcon(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public AddProductCameraIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public AddProductCameraIcon(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = AddProductCameraIconBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }
}

