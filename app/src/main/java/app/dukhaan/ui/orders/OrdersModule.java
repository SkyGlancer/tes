/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.orders_list.OrdersListViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.orders;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orders_list.OrdersListViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OrdersModule {
    @Provides
    ViewModelProvider.Factory ordersListViewModelProvider(OrdersListViewModel ordersListViewModel) {
        return new ViewModelProviderFactory((Object)ordersListViewModel);
    }

    @Provides
    OrdersListViewModel provideOrdersListViewModel(DataRepository dataRepository, ApiService apiService) {
        return new OrdersListViewModel(dataRepository, apiService);
    }
}

