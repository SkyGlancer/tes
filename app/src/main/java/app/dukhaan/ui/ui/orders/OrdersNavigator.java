package app.dukhaan.ui.ui.orders;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;
import java.util.List;

public interface OrdersNavigator extends BaseNavigator {
   void onOrdersListFetched(List<Order> var1, boolean var2);
}
