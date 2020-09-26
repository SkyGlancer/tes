package app.dukhaan.ui.ui.orderdetail;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;

public interface OrderDetailNavigator extends BaseNavigator {
   void onOrderDetailsReceived(Order var1);

   void onOrderStatusUpdated();
}
