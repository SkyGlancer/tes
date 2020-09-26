/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  dagger.internal.Factory
 *  dagger.internal.Preconditions
 *  java.lang.Object
 *  java.lang.String
 *  javax.inject.Provider
 */
package app.dukhaan.ui.orders;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orders.OrdersModule;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrdersModule_ProvideOrdersListViewModelFactory
implements Factory<OrdersListViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final OrdersModule module;

    public OrdersModule_ProvideOrdersListViewModelFactory(OrdersModule ordersModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = ordersModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static OrdersModule_ProvideOrdersListViewModelFactory create(OrdersModule ordersModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new OrdersModule_ProvideOrdersListViewModelFactory(ordersModule, provider, provider2);
    }

    public static OrdersListViewModel provideOrdersListViewModel(OrdersModule ordersModule, DataRepository dataRepository, ApiService apiService) {
        return (OrdersListViewModel)((Object)Preconditions.checkNotNull((Object)((Object)ordersModule.provideOrdersListViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public OrdersListViewModel get() {
        return OrdersModule_ProvideOrdersListViewModelFactory.provideOrdersListViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

