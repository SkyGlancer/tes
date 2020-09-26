/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.orders;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.orders.OrdersModule;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrdersModule_OrdersListViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final OrdersModule module;
    private final Provider<OrdersListViewModel> viewModelProvider;

    public OrdersModule_OrdersListViewModelProviderFactory(OrdersModule ordersModule, Provider<OrdersListViewModel> provider) {
        this.module = ordersModule;
        this.viewModelProvider = provider;
    }

    public static OrdersModule_OrdersListViewModelProviderFactory create(OrdersModule ordersModule, Provider<OrdersListViewModel> provider) {
        return new OrdersModule_OrdersListViewModelProviderFactory(ordersModule, provider);
    }

    public static ViewModelProvider.Factory ordersListViewModelProvider(OrdersModule ordersModule, OrdersListViewModel ordersListViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)ordersModule.ordersListViewModelProvider(ordersListViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return OrdersModule_OrdersListViewModelProviderFactory.ordersListViewModelProvider(this.module, (OrdersListViewModel)((Object)this.viewModelProvider.get()));
    }
}

