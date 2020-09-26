/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.MutableLiveData
 *  java.util.List
 */
package app.dukhaan.ui.orders;

import androidx.lifecycle.MutableLiveData;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.orders.OrdersNavigator;
import java.util.List;

public class OrdersViewModel
extends BaseViewModel<OrdersNavigator> {
    private MutableLiveData<List<Order>> mOrders = new MutableLiveData();

    public OrdersViewModel(DataRepository dataRepository, ApiService apiService) {
        super(dataRepository, apiService);
    }

    public MutableLiveData<List<Order>> getOrders() {
        return this.mOrders;
    }
}

