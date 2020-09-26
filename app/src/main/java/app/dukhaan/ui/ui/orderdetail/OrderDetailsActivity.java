package app.dukhaan.ui.ui.orderdetail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivityOrderDetailsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Order;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.ui.orderdetail.OrderDetailNavigator;
import app.dukhaan.ui.orderdetail.OrderDetailViewModel;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity.1;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity.2;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.orders.OrderDetailListAdapter;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DateTimeUtils;
import app.dukhaan.util.ModalDialogs;
import timber.log.Timber;

public class OrderDetailsActivity extends BaseActivity<ActivityOrderDetailsBinding, OrderDetailViewModel> implements OrderDetailNavigator, IdialogItemClickListner, IOrderStatusItemClickListener {
   ActivityOrderDetailsBinding binding;
   private OrderDetailListAdapter mAdapter;
   OrderDetailViewModel mViewModel;
   private Order order;

   public OrderDetailsActivity() {
   }

   private void initUI() {
      this.mAdapter = new OrderDetailListAdapter();
      this.binding.recyclerview.setAdapter(this.mAdapter);
      StringBuilder var1 = new StringBuilder();
      var1.append("ORDERS ACT:");
      var1.append(this.order.toString());
      Timber.d(var1.toString(), new Object[0]);
      Order var3 = this.order;
      if (var3 != null) {
         this.mAdapter.setData(var3.realmGet$products());
      }

      TextView var4 = this.binding.tvOrderid;
      StringBuilder var2 = new StringBuilder();
      var2.append(this.getResources().getString(R.string.order_id));
      var2.append(this.order.realmGet$id());
      var4.setText(var2.toString());
      this.binding.statusDot.setBackground(AppUtils.getOrderStatusDrawable(this, this.order.realmGet$status()));
      this.binding.tvStatus.setText(this.order.realmGet$status());
      this.binding.tvDate.setText(DateTimeUtils.getTimestamp(this, AppUtils.stringToDate(this.order.realmGet$createdAt())));
      this.binding.tvStatus.setText(AppUtils.toOrderStatus(this, this.order.realmGet$status()));
      if (this.order.realmGet$products() != null) {
         TextView var6 = this.binding.tvNoOfItems;
         String var5;
         if (this.order.realmGet$products().size() > 1) {
            var5 = this.getString(R.string.items, new Object[]{this.order.realmGet$products().size()});
         } else {
            var5 = this.getString(R.string.item, new Object[]{this.order.realmGet$products().size()});
         }

         var6.setText(var5);
      }

      this.binding.tvItemTotalValue.setText(this.getString(R.string.price_format, new Object[]{this.order.getProductTotal()}));
      this.binding.tvGrandTotalValue.setText(this.getString(R.string.price_format, new Object[]{this.order.getGrandTotal()}));
      this.binding.tvDeliveryValue.setText(this.getString(R.string.price_format, new Object[]{this.order.realmGet$deliveryCost()}));
      this.binding.tvNameValue.setText(this.order.realmGet$customerName());
      this.binding.tvContactNumberValue.setText(this.order.realmGet$customerMobile());
      this.binding.tvAddressValue.setText(this.order.realmGet$customerAddress());
      this.binding.tvPincodeValue.setText(this.order.realmGet$customerPin());
      this.binding.tvPaymentType.setText(this.getResources().getString(R.string.cod));
      if (this.order.realmGet$status().equals("PENDING")) {
         this.binding.btnAccept.setVisibility(0);
         this.binding.btnDecline.setVisibility(0);
         this.binding.idFooterView.setVisibility(0);
      } else if (this.order.realmGet$status().equals("ACCEPTED")) {
         this.binding.btnCancelOrder.setVisibility(0);
         this.binding.btnShipOrder.setVisibility(0);
         this.binding.idFooterView.setVisibility(0);
      } else if (this.order.realmGet$status().equals("SHIPPED")) {
         this.binding.btnDeliverd.setVisibility(0);
         this.binding.btnNotDelivered.setVisibility(0);
         this.binding.idFooterView.setVisibility(0);
      }

      this.binding.tvCall.setOnClickListener(new _$$Lambda$OrderDetailsActivity$1r0O06bn8UBEY6e_qO3RXVe8gYY(this));
      this.binding.btnDecline.setOnClickListener(new _$$Lambda$OrderDetailsActivity$ct69BVixnIccfn3WLTYFNM_guj4(this));
      this.binding.btnAccept.setOnClickListener(new 1(this));
      this.binding.btnShipOrder.setOnClickListener(new _$$Lambda$OrderDetailsActivity$6uIopaFvZUgVHl2zPGezToX1rok(this));
      this.binding.btnCancelOrder.setOnClickListener(new _$$Lambda$OrderDetailsActivity$VT37B70u_qQXymthAm118NjwVc0(this));
      this.binding.btnNotDelivered.setOnClickListener(new _$$Lambda$OrderDetailsActivity$82uwR0sUQ0NgogICLzJaapXDMH8(this));
      this.binding.btnDeliverd.setOnClickListener(new _$$Lambda$OrderDetailsActivity$YYtZhpCPrkIY1bqlA3hHLwKKSfc(this));
      this.hideFullscreenLoader();
   }

   private void trackAcceptEvent() {
      CleverTapUtils.trackNewOrder(this, this.mViewModel.getDataManager().getBusiness(), this.order);
   }

   public int getLayoutId() {
      return activity_order_details;
   }

   public Class<OrderDetailViewModel> getViewModel() {
      return OrderDetailViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
      this.hideFullscreenLoader();
      ModalDialogs.showUnknownError(this);
   }

   protected void onCreate(Bundle var1, OrderDetailViewModel var2, ActivityOrderDetailsBinding var3) {
      this.mViewModel = var2;
      this.binding = var3;
      var2.setNavigator(this);
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$OrderDetailsActivity$EYzdDZEmZtGUgkijTwppQxAAN5I(this));
      Order var4 = (Order)this.getIntent().getParcelableExtra("data");
      this.order = var4;
      if (var4 == null) {
         String var6 = this.getIntent().getStringExtra("orderId");
         StringBuilder var5 = new StringBuilder();
         var5.append("ORDERS INTENT: ");
         var5.append(var6);
         Timber.d(var5.toString(), new Object[0]);
         this.mViewModel.getOrderDetails(var6);
      } else {
         this.initUI();
      }

      this.mViewModel.getLoading().observe(this, new _$$Lambda$OrderDetailsActivity$f0PZkgAJ_MdX5hGv_e_hzHppPIo(this));
   }

   protected void onDestroy() {
      super.onDestroy();
      this.binding = null;
   }

   public void onOrderDetailsReceived(Order var1) {
      this.order = var1;
      this.initUI();
   }

   public void onOrderStatusUpdated() {
      this.hideFullscreenLoader();
      this.setResult(-1);
      Intent var1 = new Intent();
      var1.putExtra("refresh", true);
      this.setResult(-1, var1);
      this.finish();
   }

   public void positiveStatus(OrderStatusDialogType var1) {
      int var2 = 2.$SwitchMap$app$dukhaan$ui$views$orderstatusdialog$OrderStatusDialogType[var1.ordinal()];
      UpdateOrderStatusRequest var3;
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 != 4) {
                  if (var2 == 5) {
                     this.showFullscreenLoader();
                     var3 = new UpdateOrderStatusRequest();
                     var3.orderStatus = "CANCELLED";
                     this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var3);
                  }
               } else {
                  this.showFullscreenLoader();
                  var3 = new UpdateOrderStatusRequest();
                  var3.orderStatus = "DELIVERED";
                  this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var3);
               }
            } else {
               this.showFullscreenLoader();
               var3 = new UpdateOrderStatusRequest();
               var3.orderStatus = "DECLINED";
               this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var3);
            }
         } else {
            this.showFullscreenLoader();
            var3 = new UpdateOrderStatusRequest();
            var3.orderStatus = "ACCEPTED";
            this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var3);
            this.trackAcceptEvent();
         }
      } else {
         this.showFullscreenLoader();
         var3 = new UpdateOrderStatusRequest();
         var3.orderStatus = "SHIPPED";
         this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var3);
      }

   }

   public void yesMakeIt() {
      this.showFullscreenLoader();
      UpdateOrderStatusRequest var1 = new UpdateOrderStatusRequest();
      if (this.order.realmGet$status().equals("SHIPPED")) {
         var1.orderStatus = "FAILED";
      } else {
         var1.orderStatus = "DECLINED";
      }

      this.mViewModel.updateOrderStatus(this.order.realmGet$id(), var1);
   }
}
