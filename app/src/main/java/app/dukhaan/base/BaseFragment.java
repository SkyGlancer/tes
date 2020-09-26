/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  androidx.databinding.DataBindingUtil
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelProviders
 *  dagger.android.support.AndroidSupportInjection
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Inject
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.events.AppEvent;
import app.dukhaan.util.FullscreenProgressDialog;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel>
extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected BaseActivity mActivity;
    private Context mContext;
    private View mRootView;
    private T mViewDataBinding;
    private V mViewModel;
    private FullscreenProgressDialog progressDialog;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private void performDependencyInjection() {
        AndroidSupportInjection.inject((Fragment)this);
    }

    public BaseActivity getBaseActivity() {
        return this.mActivity;
    }

    public abstract int getLayoutId();

    public T getViewDataBinding() {
        return this.mViewDataBinding;
    }

    protected abstract Class<V> getViewModel();

    public void hideFullscreenProgress() {
        FullscreenProgressDialog fullscreenProgressDialog = this.progressDialog;
        if (fullscreenProgressDialog != null && fullscreenProgressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity)context;
        }
    }

    public void onCreate(Bundle bundle) {
        this.performDependencyInjection();
        super.onCreate(bundle);
        this.getActivity().getWindow().setSoftInputMode(32);
        this.mViewModel = (BaseViewModel)ViewModelProviders.of((Fragment)this, (ViewModelProvider.Factory)this.viewModelFactory).get(this.getViewModel());
        this.progressDialog = new FullscreenProgressDialog(this.mContext);
        this.setHasOptionsMenu(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate((LayoutInflater)layoutInflater, (int)this.getLayoutId(), (ViewGroup)viewGroup, (boolean)false);
        this.mViewDataBinding = viewDataBinding;
        this.mRootView = viewDataBinding.getRoot();
        this.onCreateView(bundle, this.mViewModel, this.mViewDataBinding, this.mContext);
        return this.mRootView;
    }

    protected abstract void onCreateView(Bundle var1, V var2, T var3, Context var4);

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered((Object)((Object)this))) {
            EventBus.getDefault().unregister((Object)((Object)this));
        }
    }

    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered((Object)((Object)this))) {
            EventBus.getDefault().register((Object)((Object)this));
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void showFullscreenProgress() {
        FullscreenProgressDialog fullscreenProgressDialog = this.progressDialog;
        if (fullscreenProgressDialog != null && !fullscreenProgressDialog.isShowing()) {
            this.progressDialog.show();
        }
    }

}

