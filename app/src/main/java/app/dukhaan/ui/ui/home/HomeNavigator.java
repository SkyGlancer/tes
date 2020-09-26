package app.dukhaan.ui.ui.home;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.Order;
import java.util.List;

public interface HomeNavigator extends BaseNavigator {
   void onOrderStatusUpdated(Order var1);

   void onOrdersListFetched(List<Order> var1, String var2, boolean var3);
}
