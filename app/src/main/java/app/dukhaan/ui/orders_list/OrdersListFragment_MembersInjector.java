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
package app.dukhaan.ui.orders_list;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseFragment_MembersInjector;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrdersListFragment_MembersInjector
implements MembersInjector<OrdersListFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OrdersListFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<OrdersListFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new OrdersListFragment_MembersInjector(provider);
    }

    public void injectMembers(OrdersListFragment ordersListFragment) {
        BaseFragment_MembersInjector.injectViewModelFactory(ordersListFragment, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

