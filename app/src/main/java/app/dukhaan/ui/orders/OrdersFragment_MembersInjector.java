/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.MembersInjector
 *  java.lang.Object
 *  javax.inject.Provider
 */
package app.dukhaan.ui.orders;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.orders.OrdersFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrdersFragment_MembersInjector
implements MembersInjector<OrdersFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OrdersFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<OrdersFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new OrdersFragment_MembersInjector(provider);
    }

    public void injectMembers(OrdersFragment ordersFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(ordersFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

