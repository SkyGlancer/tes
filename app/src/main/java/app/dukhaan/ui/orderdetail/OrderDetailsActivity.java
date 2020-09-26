/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.ViewDataBinding
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityOrderDetailsBinding
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.orderdetail.-$
 *  app.dukhaan.ui.orderdetail.-$$Lambda
 *  app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity
 *  app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$f0PZkgAJ_MdX5hGv-e_hzHppPIo
 *  app.dukhaan.ui.orderdetail.OrderDetailNavigator
 *  app.dukhaan.ui.orderdetail.OrderDetailViewModel
 *  app.dukhaan.ui.views.orders.OrderDetailListAdapter
 *  com.google.android.material.appbar.MaterialToolbar
 *  io.realm.RealmList
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  timber.log.Timber
 */
package app.dukhaan.ui.orderdetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityOrderDetailsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.orderdetail.-$;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$1r0O06bn8UBEY6e_qO3RXVe8gYY;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$6uIopaFvZUgVHl2zPGezToX1rok;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$82uwR0sUQ0NgogICLzJaapXDMH8;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$EYzdDZEmZtGUgkijTwppQxAAN5I;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$VT37B70u_qQXymthAm118NjwVc0;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$YYtZhpCPrkIY1bqlA3hHLwKKSfc;
import app.dukhaan.ui.orderdetail.-$$Lambda$OrderDetailsActivity$ct69BVixnIccfn3WLTYFNM-guj4;
import app.dukhaan.ui.orderdetail.OrderDetailNavigator;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.orders.OrderDetailListAdapter;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DateTimeUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import io.realm.RealmList;
import java.util.List;
import timber.log.Timber;

public class OrderDetailsActivity
extends BaseActivity<ActivityOrderDetailsBinding, OrderDetailViewModel>
implements OrderDetailNavigator,
IdialogItemClickListner,
IOrderStatusItemClickListener {
    ActivityOrderDetailsBinding binding;
    private OrderDetailListAdapter mAdapter;
    OrderDetailViewModel mViewModel;
    private Order order;

    private void initUI() {
        this.mAdapter = new OrderDetailListAdapter();
        this.binding.recyclerview.setAdapter((RecyclerView.Adapter)this.mAdapter);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ORDERS ACT:");
        stringBuilder.append(this.order.toString());
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        Order order = this.order;
        if (order != null) {
            this.mAdapter.setData((List)order.realmGet$products());
        }
        TextView textView = this.binding.tvOrderid;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.getResources().getString(2131951892));
        stringBuilder2.append(this.order.realmGet$id());
        textView.setText((CharSequence)stringBuilder2.toString());
        this.binding.statusDot.setBackground(AppUtils.getOrderStatusDrawable((Context)this, this.order.realmGet$status()));
        this.binding.tvStatus.setText((CharSequence)this.order.realmGet$status());
        this.binding.tvDate.setText((CharSequence)DateTimeUtils.getTimestamp((Context)this, AppUtils.stringToDate(this.order.realmGet$createdAt())));
        this.binding.tvStatus.setText((CharSequence)AppUtils.toOrderStatus((Context)this, this.order.realmGet$status()));
        if (this.order.realmGet$products() != null) {
            String string2;
            TextView textView2 = this.binding.tvNoOfItems;
            if (this.order.realmGet$products().size() > 1) {
                Object[] arrobject = new Object[]{this.order.realmGet$products().size()};
                string2 = this.getString(2131951808, arrobject);
            } else {
                Object[] arrobject = new Object[]{this.order.realmGet$products().size()};
                string2 = this.getString(2131951805, arrobject);
            }
            textView2.setText((CharSequence)string2);
        }
        TextView textView3 = this.binding.tvItemTotalValue;
        Object[] arrobject = new Object[]{Float.valueOf((float)this.order.getProductTotal())};
        textView3.setText((CharSequence)this.getString(2131951909, arrobject));
        TextView textView4 = this.binding.tvGrandTotalValue;
        Object[] arrobject2 = new Object[]{Float.valueOf((float)this.order.getGrandTotal())};
        textView4.setText((CharSequence)this.getString(2131951909, arrobject2));
        TextView textView5 = this.binding.tvDeliveryValue;
        Object[] arrobject3 = new Object[]{Float.valueOf((float)this.order.realmGet$deliveryCost())};
        textView5.setText((CharSequence)this.getString(2131951909, arrobject3));
        this.binding.tvNameValue.setText((CharSequence)this.order.realmGet$customerName());
        this.binding.tvContactNumberValue.setText((CharSequence)this.order.realmGet$customerMobile());
        this.binding.tvAddressValue.setText((CharSequence)this.order.realmGet$customerAddress());
        this.binding.tvPincodeValue.setText((CharSequence)this.order.realmGet$customerPin());
        this.binding.tvPaymentType.setText((CharSequence)this.getResources().getString(2131951680));
        if (this.order.realmGet$status().equals((Object)"PENDING")) {
            this.binding.btnAccept.setVisibility(0);
            this.binding.btnDecline.setVisibility(0);
            this.binding.idFooterView.setVisibility(0);
        } else if (this.order.realmGet$status().equals((Object)"ACCEPTED")) {
            this.binding.btnCancelOrder.setVisibility(0);
            this.binding.btnShipOrder.setVisibility(0);
            this.binding.idFooterView.setVisibility(0);
        } else if (this.order.realmGet$status().equals((Object)"SHIPPED")) {
            this.binding.btnDeliverd.setVisibility(0);
            this.binding.btnNotDelivered.setVisibility(0);
            this.binding.idFooterView.setVisibility(0);
        }
        this.binding.tvCall.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$1r0O06bn8UBEY6e_qO3RXVe8gYY(this));
        this.binding.btnDecline.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$ct69BVixnIccfn3WLTYFNM-guj4(this));
        this.binding.btnAccept.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ OrderDetailsActivity this$0;
            {
                this.this$0 = orderDetailsActivity;
            }

            public void onClick(View view) {
                ModalDialogs.showOrderStatusDialog((Context)this.this$0, OrderStatusDialogType.ACCEPT, this.this$0);
            }
        });
        this.binding.btnShipOrder.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$6uIopaFvZUgVHl2zPGezToX1rok(this));
        this.binding.btnCancelOrder.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$VT37B70u_qQXymthAm118NjwVc0(this));
        this.binding.btnNotDelivered.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$82uwR0sUQ0NgogICLzJaapXDMH8(this));
        this.binding.btnDeliverd.setOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$YYtZhpCPrkIY1bqlA3hHLwKKSfc(this));
        this.hideFullscreenLoader();
    }

    private void trackAcceptEvent() {
        CleverTapUtils.trackNewOrder((Context)this, this.mViewModel.getDataManager().getBusiness(), this.order);
    }

    @Override
    public int getLayoutId() {
        return 2131558444;
    }

    @Override
    public Class<OrderDetailViewModel> getViewModel() {
        return OrderDetailViewModel.class;
    }

    public /* synthetic */ void lambda$initUI$2$OrderDetailsActivity(View view) {
        AppUtils.dialNumber((Context)this, this.order.realmGet$customerMobile());
    }

    public /* synthetic */ void lambda$initUI$3$OrderDetailsActivity(View view) {
        ModalDialogs.showOrderStatusDialog((Context)this, OrderStatusDialogType.DECLINE, this);
    }

    public /* synthetic */ void lambda$initUI$4$OrderDetailsActivity(View view) {
        ModalDialogs.showOrderStatusDialog((Context)this, OrderStatusDialogType.SHIP, this);
    }

    public /* synthetic */ void lambda$initUI$5$OrderDetailsActivity(View view) {
        ModalDialogs.showOrderStatusDialog((Context)this, OrderStatusDialogType.CANCEL_ORDER, this);
    }

    public /* synthetic */ void lambda$initUI$6$OrderDetailsActivity(View view) {
        ModalDialogs.showCustomDialog((Context)this, DialogType.MARKED, this);
    }

    public /* synthetic */ void lambda$initUI$7$OrderDetailsActivity(View view) {
        ModalDialogs.showOrderStatusDialog((Context)this, OrderStatusDialogType.DELIVERED, this);
    }

    public /* synthetic */ void lambda$onCreate$0$OrderDetailsActivity(View view) {
        this.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$OrderDetailsActivity(Boolean bl) {
        if (bl.booleanValue()) {
            this.showFullscreenLoader();
            return;
        }
        this.hideFullscreenLoader();
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.hideFullscreenLoader();
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle, OrderDetailViewModel orderDetailViewModel, ActivityOrderDetailsBinding activityOrderDetailsBinding) {
        Order order;
        this.mViewModel = orderDetailViewModel;
        this.binding = activityOrderDetailsBinding;
        orderDetailViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityOrderDetailsBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityOrderDetailsBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$OrderDetailsActivity$EYzdDZEmZtGUgkijTwppQxAAN5I(this));
        this.order = order = (Order)this.getIntent().getParcelableExtra("data");
        if (order == null) {
            String string2 = this.getIntent().getStringExtra("orderId");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ORDERS INTENT: ");
            stringBuilder.append(string2);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            this.mViewModel.getOrderDetails(string2);
        } else {
            this.initUI();
        }
        this.mViewModel.getLoading().observe((LifecycleOwner)this, (Observer)new -$.Lambda.OrderDetailsActivity.f0PZkgAJ_MdX5hGv-e_hzHppPIo(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    public void onOrderDetailsReceived(Order order) {
        this.order = order;
        this.initUI();
    }

    public void onOrderStatusUpdated() {
        this.hideFullscreenLoader();
        this.setResult(-1);
        Intent intent = new Intent();
        intent.putExtra("refresh", true);
        this.setResult(-1, intent);
        this.finish();
    }

    @Override
    public void positiveStatus(OrderStatusDialogType orderStatusDialogType) {
        int n = 2.$SwitchMap$app$dukhaan$ui$views$orderstatusdialog$OrderStatusDialogType[orderStatusDialogType.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return;
                        }
                        this.showFullscreenLoader();
                        UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
                        updateOrderStatusRequest.orderStatus = "CANCELLED";
                        this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
                        return;
                    }
                    this.showFullscreenLoader();
                    UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
                    updateOrderStatusRequest.orderStatus = "DELIVERED";
                    this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
                    return;
                }
                this.showFullscreenLoader();
                UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
                updateOrderStatusRequest.orderStatus = "DECLINED";
                this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
                return;
            }
            this.showFullscreenLoader();
            UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
            updateOrderStatusRequest.orderStatus = "ACCEPTED";
            this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
            this.trackAcceptEvent();
            return;
        }
        this.showFullscreenLoader();
        UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
        updateOrderStatusRequest.orderStatus = "SHIPPED";
        this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
    }

    @Override
    public void yesMakeIt() {
        this.showFullscreenLoader();
        UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
        updateOrderStatusRequest.orderStatus = this.order.realmGet$status().equals((Object)"SHIPPED") ? "FAILED" : "DECLINED";
        this.mViewModel.updateOrderStatus(this.order.realmGet$id(), updateOrderStatusRequest);
    }
}

