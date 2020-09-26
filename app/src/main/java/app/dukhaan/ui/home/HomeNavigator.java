/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Order
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.home;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;
import java.util.List;

public interface HomeNavigator
extends BaseNavigator {
    public void onOrderStatusUpdated(Order var1);

    public void onOrdersListFetched(List<Order> var1, String var2, boolean var3);
}

