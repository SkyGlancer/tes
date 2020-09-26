/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.Menu
 *  android.view.MenuInflater
 *  androidx.databinding.ViewDataBinding
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  app.dukhaan.base.BaseFragment
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.ui.orders_list.OrdersListViewModel
 *  java.lang.Class
 *  java.lang.String
 */
package app.dukhaan.ui.orders;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import app.dukhaan.base.BaseFragment;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.databinding.FragmentOrdersBinding;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import app.dukhaan.ui.orders_list.OrdersListViewModel;

public class OrdersFragment
extends BaseFragment<FragmentOrdersBinding, OrdersListViewModel> {
    private FragmentOrdersBinding binding;
    private OrdersListFragment ordersListFragment;
    private OrdersListViewModel ordersViewModel;

    private void loadOrders() {
        this.ordersListFragment = OrdersListFragment.newInstance(true, null, false);
        FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(2131362091, (Fragment)this.ordersListFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static OrdersFragment newInstance() {
        OrdersFragment ordersFragment = new OrdersFragment();
        ordersFragment.setArguments(new Bundle());
        return ordersFragment;
    }

    public int getLayoutId() {
        return 2131558500;
    }

    protected Class<OrdersListViewModel> getViewModel() {
        return OrdersListViewModel.class;
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menuInflater.inflate(2131623941, menu2);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    protected void onCreateView(Bundle bundle, OrdersListViewModel ordersListViewModel, FragmentOrdersBinding fragmentOrdersBinding, Context context) {
        this.binding = fragmentOrdersBinding;
        this.setHasOptionsMenu(true);
        this.loadOrders();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void sort(String string2) {
        this.ordersListFragment.sort(string2);
    }
}

