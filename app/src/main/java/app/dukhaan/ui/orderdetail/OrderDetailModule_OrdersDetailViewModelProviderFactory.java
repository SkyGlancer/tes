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
package app.dukhaan.ui.orderdetail;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.ui.orderdetail.OrderDetailModule;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrderDetailModule_OrdersDetailViewModelProviderFactory
implements Factory<ViewModelProvider.Factory> {
    private final OrderDetailModule module;
    private final Provider<OrderDetailViewModel> viewModelProvider;

    public OrderDetailModule_OrdersDetailViewModelProviderFactory(OrderDetailModule orderDetailModule, Provider<OrderDetailViewModel> provider) {
        this.module = orderDetailModule;
        this.viewModelProvider = provider;
    }

    public static OrderDetailModule_OrdersDetailViewModelProviderFactory create(OrderDetailModule orderDetailModule, Provider<OrderDetailViewModel> provider) {
        return new OrderDetailModule_OrdersDetailViewModelProviderFactory(orderDetailModule, provider);
    }

    public static ViewModelProvider.Factory ordersDetailViewModelProvider(OrderDetailModule orderDetailModule, OrderDetailViewModel orderDetailViewModel) {
        return (ViewModelProvider.Factory)Preconditions.checkNotNull((Object)orderDetailModule.ordersDetailViewModelProvider(orderDetailViewModel), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public ViewModelProvider.Factory get() {
        return OrderDetailModule_OrdersDetailViewModelProviderFactory.ordersDetailViewModelProvider(this.module, (OrderDetailViewModel)((Object)this.viewModelProvider.get()));
    }
}

