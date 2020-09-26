/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.Html
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.ui.marketing.MarketingNavigator
 *  app.dukhaan.ui.marketing.MarketingViewModel
 *  com.razorpay.Checkout
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONObject
 *  timber.log.Timber
 */
package app.dukhaan.ui.marketing;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentMarketingBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$7bMsSNBgyUZH-cqVVckU00QnmZs;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$GoldFullscreenFragment$7pBizhcPbgb5KRoWi5min8-88CM;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$GoldFullscreenFragment$OKANFz2nUosgOXXOQ4ekw3Sof7A;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$ItGTxFSrwGmXYo2P95BAXPXx-Tg;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$WrXr_6mMO_TmOPUB_0RI3jMLDzg;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$mu3fKzYpIxE_fEUvrlw_S5G4IKM;
import app.dukhaan.ui.marketing.-$$Lambda$MarketingFragment$w6l7gQflTbL1wr-DCX0670Jn7zs;
import app.dukhaan.ui.marketing.MarketingNavigator;
import app.dukhaan.ui.marketing.MarketingViewModel;
import app.dukhaan.ui.views.FullButtonShadowed;
import com.razorpay.Checkout;
import org.json.JSONObject;
import timber.log.Timber;

public class MarketingFragment
extends BaseFragment<FragmentMarketingBinding, MarketingViewModel>
implements MarketingNavigator {
    private FragmentMarketingBinding binding;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MarketingViewModel mViewModel;

    private void initiateRazorpay() {
        Business business = this.mViewModel.getDataManager().getBusiness();
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_8l6ZJgi4h2jKPj");
        checkout.setImage(2131231192);
        FragmentActivity fragmentActivity = this.getActivity();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RAZORPAY: ");
        stringBuilder.append(business.realmGet$name());
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("RAZORPAY: ");
        stringBuilder2.append(AppPref.getInstance().getMobile());
        Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", (Object)"Dukaan");
            jSONObject.put("description", (Object)"Dukaan Gold Subscription");
            jSONObject.put("image", (Object)"https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            jSONObject.put("theme.color", this.getResources().getColor(2131099715));
            jSONObject.put("currency", (Object)"INR");
            jSONObject.put("amount", (Object)"49900");
            jSONObject.put("prefill.name", (Object)business.realmGet$name());
            jSONObject.put("prefill.contact", (Object)AppPref.getInstance().getMobile());
            checkout.open((Activity)fragmentActivity, jSONObject);
            return;
        }
        catch (Exception exception) {
            Timber.e((String)"Error in starting Razorpay Checkout", (Object[])new Object[0]);
            Timber.e((Throwable)exception);
            return;
        }
    }

    public static MarketingFragment newInstance() {
        MarketingFragment marketingFragment = new MarketingFragment();
        marketingFragment.setArguments(new Bundle());
        return marketingFragment;
    }

    private void showFullscreenDialog(Integer n, String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("text", "From Activity");
        bundle.putInt("type", n.intValue());
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        GoldFullscreenFragment goldFullscreenFragment = new GoldFullscreenFragment();
        goldFullscreenFragment.setArguments(bundle);
        goldFullscreenFragment.show(fragmentTransaction, "gold_tag");
    }

    public int getLayoutId() {
        return 2131558486;
    }

    protected Class<MarketingViewModel> getViewModel() {
        return MarketingViewModel.class;
    }

    public /* synthetic */ void lambda$onCreateView$0$MarketingFragment(View view) {
        this.showFullscreenDialog(1, "text");
    }

    public /* synthetic */ void lambda$onCreateView$1$MarketingFragment(View view) {
        this.showFullscreenDialog(2, "text");
    }

    public /* synthetic */ void lambda$onCreateView$2$MarketingFragment(View view) {
        this.showFullscreenDialog(3, "text");
    }

    public /* synthetic */ void lambda$onCreateView$3$MarketingFragment(View view) {
        this.showFullscreenDialog(4, "text");
    }

    public /* synthetic */ void lambda$onCreateView$4$MarketingFragment(View view) {
        this.initiateRazorpay();
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    protected void onCreateView(Bundle bundle, MarketingViewModel marketingViewModel, FragmentMarketingBinding fragmentMarketingBinding, Context context) {
        this.binding = fragmentMarketingBinding;
        this.mViewModel = marketingViewModel;
        marketingViewModel.setNavigator((Object)this);
        fragmentMarketingBinding.marketingTile1.setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$w6l7gQflTbL1wr-DCX0670Jn7zs(this));
        fragmentMarketingBinding.marketingTile2.setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$7bMsSNBgyUZH-cqVVckU00QnmZs(this));
        fragmentMarketingBinding.marketingTile3.setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$ItGTxFSrwGmXYo2P95BAXPXx-Tg(this));
        fragmentMarketingBinding.marketingTile4.setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$WrXr_6mMO_TmOPUB_0RI3jMLDzg(this));
        fragmentMarketingBinding.payBtn.setOnClickListener(new -$$Lambda$MarketingFragment$mu3fKzYpIxE_fEUvrlw_S5G4IKM(this));
        fragmentMarketingBinding.goldDescription.setText((CharSequence)Html.fromHtml((String)"Upgrade by paying <strike>\u20b9999</strike> <b>\u20b9499/year</b> and start growing your business faster."));
    }

    public static class GoldFullscreenFragment
    extends DialogFragment {
        public /* synthetic */ void lambda$onCreateView$0$MarketingFragment$GoldFullscreenFragment(View view) {
            this.dismiss();
        }

        public /* synthetic */ void lambda$onCreateView$1$MarketingFragment$GoldFullscreenFragment(View view) {
            this.dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.setStyle(0, 2132017396);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = layoutInflater.inflate(2131558484, viewGroup, false);
            LinearLayout linearLayout = (LinearLayout)view.findViewById(2131362230);
            TextView textView = (TextView)linearLayout.findViewById(2131362471);
            ImageView imageView = (ImageView)linearLayout.findViewById(2131362470);
            TextView textView2 = (TextView)view.findViewById(2131362476);
            TextView textView3 = (TextView)view.findViewById(2131362432);
            ImageView imageView2 = (ImageView)view.findViewById(2131361936);
            ((TextView)view.findViewById(2131362312)).setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$GoldFullscreenFragment$OKANFz2nUosgOXXOQ4ekw3Sof7A(this));
            imageView2.setOnClickListener((View.OnClickListener)new -$$Lambda$MarketingFragment$GoldFullscreenFragment$7pBizhcPbgb5KRoWi5min8-88CM(this));
            int n = this.getArguments().getInt("type");
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                linearLayout.setBackgroundTintList(this.getResources().getColorStateList(2131099725));
                            }
                            imageView.setImageDrawable(this.getResources().getDrawable(2131231182));
                            textView.setText((CharSequence)"Business Cards");
                            textView2.setText((CharSequence)"Create your Business Card");
                            textView3.setText((CharSequence)"Your business card is one of your most important marketing tools. Create it now and share with your customers in 1 tap.");
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 21) {
                            linearLayout.setBackgroundTintList(this.getResources().getColorStateList(2131099724));
                        }
                        imageView.setImageDrawable(this.getResources().getDrawable(2131231246));
                        textView.setText((CharSequence)"WhatsApp Stories");
                        textView2.setText((CharSequence)"Unlock WhatsApp Stories");
                        textView3.setText((CharSequence)"Choose and create WhatsApp stories with your contacts from our different ready-made templates.");
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        linearLayout.setBackgroundTintList(this.getResources().getColorStateList(2131099723));
                    }
                    imageView.setImageDrawable(this.getResources().getDrawable(2131231238));
                    textView.setText((CharSequence)"Store Banners");
                    textView2.setText((CharSequence)"Create Store Banners");
                    textView3.setText((CharSequence)"Do you want to run offers on your store? Create banners from our beautifully crafted templates.");
                }
            } else {
                if (Build.VERSION.SDK_INT >= 21) {
                    linearLayout.setBackgroundTintList(this.getResources().getColorStateList(2131099722));
                }
                imageView.setImageDrawable(this.getResources().getDrawable(2131231239));
                textView.setText((CharSequence)"Store Verification");
                textView2.setText((CharSequence)"Verify Store");
                textView3.setText((CharSequence)"Create more trust and authenticity between your customers by verifying your store with us. ");
            }
            this.getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
            return view;
        }

        public void onStart() {
            super.onStart();
            Dialog dialog = this.getDialog();
            if (dialog != null) {
                dialog.getWindow().setLayout(-1, -1);
            }
        }
    }

}

