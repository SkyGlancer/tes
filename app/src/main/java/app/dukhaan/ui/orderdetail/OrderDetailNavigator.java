/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.orderdetail;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;

public interface OrderDetailNavigator
extends BaseNavigator {
    public void onOrderDetailsReceived(Order var1);

    public void onOrderStatusUpdated();
}

