/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.orders;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;
import java.util.List;

public interface OrdersNavigator
extends BaseNavigator {
    public void onOrdersListFetched(List<Order> var1, boolean var2);
}

