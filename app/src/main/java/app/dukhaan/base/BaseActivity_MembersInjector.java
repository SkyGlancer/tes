/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.databinding.ViewDataBinding
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BaseActivity_MembersInjector<T extends ViewDataBinding, V extends BaseViewModel>
implements MembersInjector<BaseActivity<T, V>> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BaseActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static <T extends ViewDataBinding, V extends BaseViewModel> MembersInjector<BaseActivity<T, V>> create(Provider<ViewModelProvider.Factory> provider) {
        return new BaseActivity_MembersInjector<T, V>(provider);
    }

    public static <T extends ViewDataBinding, V extends BaseViewModel> void injectViewModelFactory(BaseActivity<T, V> baseActivity, ViewModelProvider.Factory factory) {
        baseActivity.viewModelFactory = factory;
    }

    public void injectMembers(BaseActivity<T, V> baseActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(baseActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

