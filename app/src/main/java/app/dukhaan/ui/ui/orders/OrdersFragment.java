package app.dukhaan.ui.ui.orders;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.databinding.FragmentOrdersBinding;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import app.dukhaan.ui.orders_list.OrdersListViewModel;

public class OrdersFragment extends BaseFragment<FragmentOrdersBinding, OrdersListViewModel> {
   private FragmentOrdersBinding binding;
   private OrdersListFragment ordersListFragment;
   private OrdersListViewModel ordersViewModel;

   public OrdersFragment() {
   }

   private void loadOrders() {
      this.ordersListFragment = OrdersListFragment.newInstance(true, (String)null, false);
      FragmentTransaction var1 = this.getActivity().getSupportFragmentManager().beginTransaction();
      var1.replace(frame, this.ordersListFragment);
      var1.addToBackStack((String)null);
      var1.commit();
   }

   public static OrdersFragment newInstance() {
      OrdersFragment var0 = new OrdersFragment();
      var0.setArguments(new Bundle());
      return var0;
   }

   public int getLayoutId() {
      return fragment_orders;
   }

   protected Class<OrdersListViewModel> getViewModel() {
      return OrdersListViewModel.class;
   }

   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(menu_orders, var1);
      super.onCreateOptionsMenu(var1, var2);
   }

   protected void onCreateView(Bundle var1, OrdersListViewModel var2, FragmentOrdersBinding var3, Context var4) {
      this.binding = var3;
      this.setHasOptionsMenu(true);
      this.loadOrders();
   }

   public void onDestroyView() {
      super.onDestroyView();
      this.binding = null;
   }

   public void sort(String var1) {
      this.ordersListFragment.sort(var1);
   }
}
