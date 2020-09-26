/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  app.dukhaan.databinding.LayoutStoreInfoCardBinding
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import app.dukhaan.databinding.LayoutStoreInfoCardBinding;
import app.dukhaan.ui.views.-$$Lambda$StoreInfoCard$A0CvHHXu0gDfvjbFdn1cnP-nBxI;
import app.dukhaan.ui.views.-$$Lambda$StoreInfoCard$AVYx1SB6fBwf4gJBGh4ZTZtvaGA;
import app.dukhaan.util.AppUtils;

public class StoreInfoCard
extends FrameLayout {
    private LayoutStoreInfoCardBinding binding;
    private StoreInfoCardListener listener;
    private String storeUrl;

    public StoreInfoCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public StoreInfoCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public StoreInfoCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutStoreInfoCardBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    public /* synthetic */ void lambda$onFinishInflate$0$StoreInfoCard(View view) {
        AppUtils.openBrowser(this.getContext(), this.storeUrl);
    }

    public /* synthetic */ void lambda$onFinishInflate$1$StoreInfoCard(View view) {
        StoreInfoCardListener storeInfoCardListener = this.listener;
        if (storeInfoCardListener != null) {
            storeInfoCardListener.onShareClicked();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.binding.link.setOnClickListener((OnClickListener)new -$$Lambda$StoreInfoCard$A0CvHHXu0gDfvjbFdn1cnP-nBxI(this));
        this.binding.copy.setOnClickListener((OnClickListener)new -$$Lambda$StoreInfoCard$AVYx1SB6fBwf4gJBGh4ZTZtvaGA(this));
    }

    public void setData(String string2) {
        this.storeUrl = string2;
        this.binding.link.setText((CharSequence)string2.replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)", ""));
    }

    public void setListener(StoreInfoCardListener storeInfoCardListener) {
        this.listener = storeInfoCardListener;
    }

    public static interface StoreInfoCardListener {
        public void onShareClicked();
    }

}

