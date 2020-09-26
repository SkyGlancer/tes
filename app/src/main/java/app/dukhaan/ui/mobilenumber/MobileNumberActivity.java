/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.databinding.ViewDataBinding
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.databinding.ActivityMobileNumberBinding
 *  app.dukhaan.ui.mobilenumber.MobileNumberNavigator
 *  app.dukhaan.ui.mobilenumber.MobileNumberViewModel
 *  java.lang.Class
 *  java.lang.Object
 *  javax.inject.Inject
 */
package app.dukhaan.ui.mobilenumber;

import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.ActivityMobileNumberBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.ui.mobilenumber.MobileNumberNavigator;
import app.dukhaan.ui.mobilenumber.MobileNumberViewModel;
import javax.inject.Inject;

public class MobileNumberActivity
extends BaseActivity<ActivityMobileNumberBinding, MobileNumberViewModel>
implements MobileNumberNavigator {
    MobileNumberViewModel mViewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    public int getLayoutId() {
        return 2131558442;
    }

    @Override
    public Class<MobileNumberViewModel> getViewModel() {
        return MobileNumberViewModel.class;
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558442);
        this.mViewModel.setNavigator((Object)this);
    }

    @Override
    protected void onCreate(Bundle bundle, MobileNumberViewModel mobileNumberViewModel, ActivityMobileNumberBinding activityMobileNumberBinding) {
    }
}

