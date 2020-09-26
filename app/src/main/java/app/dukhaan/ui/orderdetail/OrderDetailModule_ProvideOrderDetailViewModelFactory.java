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
package app.dukhaan.ui.orderdetail;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orderdetail.OrderDetailModule;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OrderDetailModule_ProvideOrderDetailViewModelFactory
implements Factory<OrderDetailViewModel> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<DataRepository> dataRepositoryProvider;
    private final OrderDetailModule module;

    public OrderDetailModule_ProvideOrderDetailViewModelFactory(OrderDetailModule orderDetailModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        this.module = orderDetailModule;
        this.dataRepositoryProvider = provider;
        this.apiServiceProvider = provider2;
    }

    public static OrderDetailModule_ProvideOrderDetailViewModelFactory create(OrderDetailModule orderDetailModule, Provider<DataRepository> provider, Provider<ApiService> provider2) {
        return new OrderDetailModule_ProvideOrderDetailViewModelFactory(orderDetailModule, provider, provider2);
    }

    public static OrderDetailViewModel provideOrderDetailViewModel(OrderDetailModule orderDetailModule, DataRepository dataRepository, ApiService apiService) {
        return (OrderDetailViewModel)((Object)Preconditions.checkNotNull((Object)((Object)orderDetailModule.provideOrderDetailViewModel(dataRepository, apiService)), (String)"Cannot return null from a non-@Nullable @Provides method"));
    }

    public OrderDetailViewModel get() {
        return OrderDetailModule_ProvideOrderDetailViewModelFactory.provideOrderDetailViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
    }
}

