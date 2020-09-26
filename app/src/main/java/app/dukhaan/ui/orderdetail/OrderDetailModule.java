/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.orderdetail.OrderDetailViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.orderdetail;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class OrderDetailModule {
    @Provides
    ViewModelProvider.Factory ordersDetailViewModelProvider(OrderDetailViewModel orderDetailViewModel) {
        return new ViewModelProviderFactory((Object)orderDetailViewModel);
    }

    @Provides
    OrderDetailViewModel provideOrderDetailViewModel(DataRepository dataRepository, ApiService apiService) {
        return new OrderDetailViewModel(dataRepository, apiService);
    }
}

