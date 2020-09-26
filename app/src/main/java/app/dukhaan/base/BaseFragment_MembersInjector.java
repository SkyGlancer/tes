/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.databinding.ViewDataBinding
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.base.BaseFragment
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BaseFragment_MembersInjector<T extends ViewDataBinding, V extends BaseViewModel>
implements MembersInjector<BaseFragment<T, V>> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BaseFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static <T extends ViewDataBinding, V extends BaseViewModel> MembersInjector<BaseFragment<T, V>> create(Provider<ViewModelProvider.Factory> provider) {
        return new BaseFragment_MembersInjector<T, V>(provider);
    }

    public static <T extends ViewDataBinding, V extends BaseViewModel> void injectViewModelFactory(BaseFragment<T, V> baseFragment, ViewModelProvider.Factory factory) {
        baseFragment.viewModelFactory = factory;
    }

    public void injectMembers(BaseFragment<T, V> baseFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(baseFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

