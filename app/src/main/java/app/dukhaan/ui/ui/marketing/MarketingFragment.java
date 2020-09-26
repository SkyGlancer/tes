package app.dukhaan.ui.ui.marketing;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.FragmentMarketingBinding;
import app.dukhaan.network.ErrorResponse;
import com.razorpay.Checkout;
import org.json.JSONObject;

import app.dukhaan.ui.marketing.MarketingNavigator;
import app.dukhaan.ui.marketing.MarketingViewModel;
import timber.log.Timber;

public class MarketingFragment extends BaseFragment<FragmentMarketingBinding, MarketingViewModel> implements MarketingNavigator {
   private FragmentMarketingBinding binding;
   private Fragment fragment;
   private FragmentManager fragmentManager;
   private FragmentTransaction fragmentTransaction;
   private MarketingViewModel mViewModel;

   public MarketingFragment() {
   }

   private void initiateRazorpay() {
      Business var1 = this.mViewModel.getDataManager().getBusiness();
      Checkout var2 = new Checkout();
      var2.setKeyID("rzp_test_8l6ZJgi4h2jKPj");
      var2.setImage(flag_ug);
      FragmentActivity var3 = this.getActivity();
      StringBuilder var4 = new StringBuilder();
      var4.append("RAZORPAY: ");
      var4.append(var1.realmGet$name());
      Timber.d(var4.toString(), new Object[0]);
      var4 = new StringBuilder();
      var4.append("RAZORPAY: ");
      var4.append(AppPref.getInstance().getMobile());
      Timber.d(var4.toString(), new Object[0]);

      try {
         JSONObject var6 = new JSONObject();
         var6.put("name", "Dukaan");
         var6.put("description", "Dukaan Gold Subscription");
         var6.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
         var6.put("theme.color", this.getResources().getColor(R.color.colorCategoryQTY));
         var6.put("currency", "INR");
         var6.put("amount", "49900");
         var6.put("prefill.name", var1.realmGet$name());
         var6.put("prefill.contact", AppPref.getInstance().getMobile());
         var2.open(var3, var6);
      } catch (Exception var5) {
         Timber.e("Error in starting Razorpay Checkout", new Object[0]);
         Timber.e(var5);
      }

   }

   public static MarketingFragment newInstance() {
      MarketingFragment var0 = new MarketingFragment();
      var0.setArguments(new Bundle());
      return var0;
   }

   private void showFullscreenDialog(Integer var1, String var2) {
      Bundle var5 = new Bundle();
      var5.putString("text", "From Activity");
      var5.putInt("type", var1);
      FragmentTransaction var3 = this.getFragmentManager().beginTransaction();
      app.dukhaan.ui.marketing.MarketingFragment.GoldFullscreenFragment var4 = new app.dukhaan.ui.marketing.MarketingFragment.GoldFullscreenFragment();
      var4.setArguments(var5);
      var4.show(var3, "gold_tag");
   }

   public int getLayoutId() {
      return design_menu_item_action_area;
   }

   protected Class<MarketingViewModel> getViewModel() {
      return MarketingViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreateView(Bundle var1, MarketingViewModel var2, FragmentMarketingBinding var3, Context var4) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      var3.marketingTile1.setOnClickListener(new _$$Lambda$MarketingFragment$w6l7gQflTbL1wr_DCX0670Jn7zs(this));
      var3.marketingTile2.setOnClickListener(new _$$Lambda$MarketingFragment$7bMsSNBgyUZH_cqVVckU00QnmZs(this));
      var3.marketingTile3.setOnClickListener(new _$$Lambda$MarketingFragment$ItGTxFSrwGmXYo2P95BAXPXx_Tg(this));
      var3.marketingTile4.setOnClickListener(new _$$Lambda$MarketingFragment$WrXr_6mMO_TmOPUB_0RI3jMLDzg(this));
      var3.payBtn.setOnClickListener(new _$$Lambda$MarketingFragment$mu3fKzYpIxE_fEUvrlw_S5G4IKM(this));
      var3.goldDescription.setText(Html.fromHtml("Upgrade by paying <strike>₹999</strike> <b>₹499/year</b> and start growing your business faster."));
   }
}
