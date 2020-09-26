/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  app.dukhaan.databinding.InternetConnectonLayoutBinding
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.views.networkcheck;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import app.dukhaan.databinding.InternetConnectonLayoutBinding;
import app.dukhaan.ui.views.networkcheck.-$$Lambda$NoNetworkFullscreenDialog$Hlfois2y_5iH_Ux6gXmz8XyRDB4;
import app.dukhaan.ui.views.networkcheck.ConnectivityReceiver;
import java.util.List;

public class NoNetworkFullscreenDialog
extends DialogFragment
implements ConnectivityReceiver.ConnectivityReceiverListener {
    public static final String TAG = NoNetworkFullscreenDialog.class.getSimpleName();
    private InternetConnectonLayoutBinding binding;
    public TryAgainClick iTryAgainClick;
    private ConnectivityReceiver service;

    public static void dismissAllDialogs(FragmentManager fragmentManager) {
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment == null) continue;
            if (fragment instanceof DialogFragment) {
                ((DialogFragment)fragment).dismissAllowingStateLoss();
            }
            NoNetworkFullscreenDialog.dismissAllDialogs(fragment.getChildFragmentManager());
        }
    }

    private boolean isNetworkAvailable() {
        boolean bl;
        block3 : {
            NetworkInfo networkInfo;
            bl = true;
            try {
                networkInfo = ((ConnectivityManager)this.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
                if (networkInfo == null) break block3;
            }
            catch (Exception exception) {}
            boolean bl2 = networkInfo.isConnectedOrConnecting();
            if (!bl2) break block3;
            return bl;
        }
        bl = false;
        return bl;
    }

    public static NoNetworkFullscreenDialog newInstance() {
        return new NoNetworkFullscreenDialog();
    }

    public void changeStatusBarColor(int n) {
        Window window = this.getDialog().getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(n);
        }
    }

    public void display(FragmentManager fragmentManager) {
        if (this.isAdded()) {
            return;
        }
        this.show(fragmentManager, TAG);
    }

    public /* synthetic */ void lambda$onViewCreated$0$NoNetworkFullscreenDialog(View view) {
        if (this.iTryAgainClick != null && this.isNetworkAvailable() && this.getDialog() != null) {
            this.dismiss();
            this.iTryAgainClick.tryAgain();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setStyle(0, 2132017162);
        this.service = new ConnectivityReceiver(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.binding = InternetConnectonLayoutBinding.inflate((LayoutInflater)layoutInflater);
        this.setCancelable(false);
        return this.binding.getRoot();
    }

    @Override
    public void onNetworkConnectionChanged(boolean bl) {
        if (this.iTryAgainClick != null && bl && this.getDialog() != null) {
            NoNetworkFullscreenDialog.dismissAllDialogs(this.getParentFragmentManager());
            this.iTryAgainClick.tryAgain();
        }
    }

    public void onResume() {
        super.onResume();
        this.service.setConnectivityReceiverListener(this);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
            this.changeStatusBarColor(-1);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.binding.cancel.setOnClickListener((View.OnClickListener)new -$$Lambda$NoNetworkFullscreenDialog$Hlfois2y_5iH_Ux6gXmz8XyRDB4(this));
    }

    public void setTryAgainListener(TryAgainClick tryAgainClick) {
        this.iTryAgainClick = tryAgainClick;
    }

}

