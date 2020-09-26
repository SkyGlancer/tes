package app.dukhaan.ui.ui.views.orders;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import app.dukhaan.app.GlideApp;
import app.dukhaan.databinding.LayoutOrderListItemBinding;
import app.dukhaan.network.model.Order;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.DateTimeUtils;

public class OrderListItemCard extends FrameLayout {
   private app.dukhaan.ui.views.orders.OrderListItemCard.OrderListItemCardActionListener actionListener;
   private LayoutOrderListItemBinding binding;
   private boolean enableFullDetails = true;
   private app.dukhaan.ui.views.orders.OrderListItemCard.OrderListItemCardListener listener;
   private Order order;
   private boolean showActionButtons;

   public OrderListItemCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public OrderListItemCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public OrderListItemCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      if (this.order != null) {
         Typeface var1;
         if (this.enableFullDetails) {
            this.binding.thumbnail.setVisibility(8);
            this.binding.footer.setVisibility(0);
            this.binding.divider.setVisibility(0);
            var1 = ResourcesCompat.getFont(this.getContext(), font_family_galano_medium);
            this.binding.orderNumber.setTypeface(var1);
         } else {
            this.binding.thumbnail.setVisibility(0);
            this.binding.footer.setVisibility(8);
            this.binding.divider.setVisibility(8);
            var1 = ResourcesCompat.getFont(this.getContext(), font_family_galano_regular);
            this.binding.orderNumber.setTypeface(var1);
         }

         this.binding.statusDot.setBackground(AppUtils.getOrderStatusDrawable(this.getContext(), this.order.realmGet$status()));
         this.binding.price.setTextColor(this.getPriceColor());
         this.binding.details.setOnClickListener(new _$$Lambda$OrderListItemCard$T4LgAo74QT0OJP5an4PofLX8_Gk(this));
         this.toggleActionButtons();
         this.loadThumbnail();
      }
   }

   private int getPriceColor() {
      Context var1 = this.getContext();
      int var2;
      if (this.enableFullDetails) {
         var2 = price_black;
      } else {
         var2 = colorPrimary;
      }

      return ContextCompat.getColor(R.color.var1, var2);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutOrderListItemBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   private void loadThumbnail() {
      float var1 = this.getResources().getDimension(thumbnail_min_corner_radius);
      this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, var1).build());
      if (!TextUtils.isEmpty(this.order.getThumbnail())) {
         GlideApp.with(this).load(this.order.getThumbnail()).into(this.binding.thumbnail);
      }

   }

   public void enableActionButtons(boolean var1) {
      this.showActionButtons = var1;
      this.applyStyle();
   }

   public void enableMinVersion(boolean var1) {
      this.enableFullDetails = var1 ^ true;
      this.applyStyle();
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.applyStyle();
   }

   public void setActionListener(app.dukhaan.ui.views.orders.OrderListItemCard.OrderListItemCardActionListener var1) {
      this.actionListener = var1;
   }

   public void setListener(app.dukhaan.ui.views.orders.OrderListItemCard.OrderListItemCardListener var1) {
      this.listener = var1;
   }

   public void setOrder(Order var1) {
      this.order = var1;
      this.binding.orderNumber.setText(this.getContext().getString(R.string.order_number_format, new Object[]{String.valueOf(var1.realmGet$id())}));
      this.binding.price.setText(this.getContext().getString(R.string.price_format, new Object[]{var1.getGrandTotal()}));
      if (var1.realmGet$products() != null) {
         TextView var2 = this.binding.itemCount;
         String var3;
         if (var1.realmGet$products().size() > 1) {
            var3 = this.getContext().getString(R.string.items, new Object[]{var1.realmGet$products().size()});
         } else {
            var3 = this.getContext().getString(R.string.item, new Object[]{var1.realmGet$products().size()});
         }

         var2.setText(var3);
         this.binding.itemCount.setVisibility(0);
      } else {
         this.binding.itemCount.setVisibility(4);
      }

      this.binding.timestamp.setText(DateTimeUtils.getTimestamp(this.getContext(), AppUtils.stringToDate(var1.realmGet$createdAt())));
      this.binding.status.setText(AppUtils.toOrderStatus(this.getContext(), var1.realmGet$status()));
      this.applyStyle();
   }

   public void toggleActionButtons() {
      boolean var1 = this.showActionButtons;
      byte var2 = 0;
      if (var1) {
         this.binding.idFooterView.setVisibility(0);
      } else {
         this.binding.btnAccept.setVisibility(8);
         this.binding.btnDecline.setVisibility(8);
         this.binding.btnCancelOrder.setVisibility(8);
         this.binding.btnShipOrder.setVisibility(8);
         this.binding.btnDeliverd.setVisibility(8);
         this.binding.btnNotDelivered.setVisibility(8);
         this.binding.idFooterView.setVisibility(8);
      }

      if (this.showActionButtons) {
         TextView var3 = this.binding.btnAccept;
         byte var4;
         if (this.order.realmGet$status().equals("PENDING")) {
            var4 = 0;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         var3 = this.binding.btnDecline;
         if (this.order.realmGet$status().equals("PENDING")) {
            var4 = 0;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         var3 = this.binding.btnCancelOrder;
         if (this.order.realmGet$status().equals("ACCEPTED")) {
            var4 = 0;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         var3 = this.binding.btnShipOrder;
         if (this.order.realmGet$status().equals("ACCEPTED")) {
            var4 = 0;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         var3 = this.binding.btnDeliverd;
         if (this.order.realmGet$status().equals("SHIPPED")) {
            var4 = 0;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         var3 = this.binding.btnNotDelivered;
         if (this.order.realmGet$status().equals("SHIPPED")) {
            var4 = var2;
         } else {
            var4 = 8;
         }

         var3.setVisibility(var4);
         this.binding.btnAccept.setOnClickListener(new _$$Lambda$OrderListItemCard$h8st0V3Eb9_1H9K_iF1khMr_3nM(this));
         this.binding.btnDecline.setOnClickListener(new _$$Lambda$OrderListItemCard$aA8Do5uS637_A89bOGsHe1Hi7s4(this));
         this.binding.btnShipOrder.setOnClickListener(new _$$Lambda$OrderListItemCard$lw41oCOKpbNJd01YFEG_stcoy0Q(this));
         this.binding.btnCancelOrder.setOnClickListener(new _$$Lambda$OrderListItemCard$92zSmjU0UQMX0fgVLQ586CZCLdo(this));
         this.binding.btnNotDelivered.setOnClickListener(new _$$Lambda$OrderListItemCard$Txlc4b9FDABl_MYYH6q9ZUnx2JM(this));
         this.binding.btnDeliverd.setOnClickListener(new _$$Lambda$OrderListItemCard$W28wBUn_Gs9XTCTnx_1QFYw6E1Y(this));
      }
   }
}
