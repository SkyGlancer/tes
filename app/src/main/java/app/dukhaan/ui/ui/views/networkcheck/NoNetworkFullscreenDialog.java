package app.dukhaan.ui.ui.views.networkcheck;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.dukhaan.databinding.InternetConnectonLayoutBinding;
import app.dukhaan.ui.views.networkcheck.ConnectivityReceiver;
import app.dukhaan.ui.views.networkcheck.ConnectivityReceiver.ConnectivityReceiverListener;
import java.util.Iterator;

public class NoNetworkFullscreenDialog extends DialogFragment implements ConnectivityReceiverListener {
   public static final String TAG = NoNetworkFullscreenDialog.class.getSimpleName();
   private InternetConnectonLayoutBinding binding;
   public app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog.TryAgainClick iTryAgainClick;
   private app.dukhaan.ui.views.networkcheck.ConnectivityReceiver service;

   public NoNetworkFullscreenDialog() {
   }

   public static void dismissAllDialogs(FragmentManager var0) {
      Iterator var1 = var0.getFragments().iterator();

      while(var1.hasNext()) {
         Fragment var2 = (Fragment)var1.next();
         if (var2 != null) {
            if (var2 instanceof DialogFragment) {
               ((DialogFragment)var2).dismissAllowingStateLoss();
            }

            dismissAllDialogs(var2.getChildFragmentManager());
         }
      }

   }

   private boolean isNetworkAvailable() {
      boolean var1 = true;

      boolean var10001;
      NetworkInfo var2;
      try {
         var2 = ((ConnectivityManager)this.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
      } catch (Exception var5) {
         var10001 = false;
         return var1;
      }

      if (var2 != null) {
         boolean var3;
         try {
            var3 = var2.isConnectedOrConnecting();
         } catch (Exception var4) {
            var10001 = false;
            return var1;
         }

         if (var3) {
            return var1;
         }
      }

      var1 = false;
      return var1;
   }

   public static NoNetworkFullscreenDialog newInstance() {
      return new NoNetworkFullscreenDialog();
   }

   public void changeStatusBarColor(int var1) {
      Window var2 = this.getDialog().getWindow();
      if (VERSION.SDK_INT >= 21) {
         var2.addFlags(-2147483648);
      }

      if (VERSION.SDK_INT >= 23) {
         var2.getDecorView().setSystemUiVisibility(8192);
         var2.setStatusBarColor(var1);
      }

   }

   public void display(FragmentManager var1) {
      if (!this.isAdded()) {
         this.show(var1, TAG);
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, AppTheme_FullScreenDialog);
      this.service = new ConnectivityReceiver(this);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      super.onCreateView(var1, var2, var3);
      this.binding = InternetConnectonLayoutBinding.inflate(var1);
      this.setCancelable(false);
      return this.binding.getRoot();
   }

   public void onNetworkConnectionChanged(boolean var1) {
      if (this.iTryAgainClick != null && var1 && this.getDialog() != null) {
         dismissAllDialogs(this.getParentFragmentManager());
         this.iTryAgainClick.tryAgain();
      }

   }

   public void onResume() {
      super.onResume();
      this.service.setConnectivityReceiverListener(this);
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         var1.getWindow().setLayout(-1, -1);
         this.changeStatusBarColor(-1);
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.binding.cancel.setOnClickListener(new _$$Lambda$NoNetworkFullscreenDialog$Hlfois2y_5iH_Ux6gXmz8XyRDB4(this));
   }

   public void setTryAgainListener(app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog.TryAgainClick var1) {
      this.iTryAgainClick = var1;
   }
}
