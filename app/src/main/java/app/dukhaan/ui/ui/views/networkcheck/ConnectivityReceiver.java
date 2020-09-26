package app.dukhaan.ui.ui.views.networkcheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityReceiver extends BroadcastReceiver {
   public static app.dukhaan.ui.views.networkcheck.ConnectivityReceiver.ConnectivityReceiverListener connectivityReceiverListener;

   public ConnectivityReceiver(app.dukhaan.ui.views.networkcheck.ConnectivityReceiver.ConnectivityReceiverListener var1) {
      connectivityReceiverListener = var1;
   }

   public static boolean isConnected(Context var0) {
      NetworkInfo var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var1;
      if (var2 != null && var2.isConnectedOrConnecting()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void onReceive(Context var1, Intent var2) {
      connectivityReceiverListener.onNetworkConnectionChanged(isConnected(var1));
   }

   public void setConnectivityReceiverListener(app.dukhaan.ui.views.networkcheck.ConnectivityReceiver.ConnectivityReceiverListener var1) {
      connectivityReceiverListener = var1;
   }
}
