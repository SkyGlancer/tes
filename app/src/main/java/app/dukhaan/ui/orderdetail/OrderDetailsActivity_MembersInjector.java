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
package app.dukhaan.ui.orderdetail;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.base.BaseActivity_MembersInjector;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OrderDetailsActivity_MembersInjector
implements MembersInjector<OrderDetailsActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OrderDetailsActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<OrderDetailsActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new OrderDetailsActivity_MembersInjector(provider);
    }

    public void injectMembers(OrderDetailsActivity orderDetailsActivity) {
        BaseActivity_MembersInjector.injectViewModelFactory(orderDetailsActivity, (ViewModelProvider.Factory)this.viewModelFactoryProvider.get());
    }
}

