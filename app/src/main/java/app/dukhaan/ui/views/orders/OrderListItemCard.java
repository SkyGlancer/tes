/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.res.ResourcesCompat
 *  app.dukhaan.app.GlideRequest
 *  app.dukhaan.databinding.LayoutOrderListItemBinding
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.ui.views.orders.-$
 *  app.dukhaan.ui.views.orders.-$$Lambda
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$3tJgHUZ8rNcVxTgnSIIoRfhhDp4
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$KYDgPHeqmCZWufXdMrFuBOmFmNU
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$Mm63rqmC3ioeN4u6SGchm0URoU8
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$WlmOKa5cv5WCbrizd2_J0yq_AZM
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$Z7r33vu5CStv24dhBsCrvOYaBms
 *  app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$_3t_LV_A-vo91JcmP7XHr1RmlwE
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.google.android.material.card.MaterialCardView
 *  com.google.android.material.imageview.ShapeableImageView
 *  com.google.android.material.shape.ShapeAppearanceModel
 *  com.google.android.material.shape.ShapeAppearanceModel$Builder
 *  io.realm.RealmList
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.views.orders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import app.dukhaan.app.GlideApp;
import app.dukhaan.app.GlideRequest;
import app.dukhaan.databinding.LayoutOrderListItemBinding;
import app.dukhaan.network.model.Order;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.orders.-$;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$92zSmjU0UQMX0fgVLQ586CZCLdo;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$T4LgAo74QT0OJP5an4PofLX8_Gk;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$Txlc4b9FDABl_MYYH6q9ZUnx2JM;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$W28wBUn_Gs9XTCTnx_1QFYw6E1Y;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$aA8Do5uS637_A89bOGsHe1Hi7s4;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$h8st0V3Eb9-1H9K-iF1khMr_3nM;
import app.dukhaan.ui.views.orders.-$$Lambda$OrderListItemCard$lw41oCOKpbNJd01YFEG_stcoy0Q;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.DateTimeUtils;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.realm.RealmList;

public class OrderListItemCard
extends FrameLayout {
    private OrderListItemCardActionListener actionListener;
    private LayoutOrderListItemBinding binding;
    private boolean enableFullDetails = true;
    private OrderListItemCardListener listener;
    private Order order;
    private boolean showActionButtons;

    public OrderListItemCard(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public OrderListItemCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public OrderListItemCard(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void applyStyle() {
        if (this.order == null) {
            return;
        }
        if (this.enableFullDetails) {
            this.binding.thumbnail.setVisibility(8);
            this.binding.footer.setVisibility(0);
            this.binding.divider.setVisibility(0);
            Typeface typeface = ResourcesCompat.getFont((Context)this.getContext(), (int)2131296259);
            this.binding.orderNumber.setTypeface(typeface);
        } else {
            this.binding.thumbnail.setVisibility(0);
            this.binding.footer.setVisibility(8);
            this.binding.divider.setVisibility(8);
            Typeface typeface = ResourcesCompat.getFont((Context)this.getContext(), (int)2131296260);
            this.binding.orderNumber.setTypeface(typeface);
        }
        this.binding.statusDot.setBackground(AppUtils.getOrderStatusDrawable(this.getContext(), this.order.realmGet$status()));
        this.binding.price.setTextColor(this.getPriceColor());
        this.binding.details.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$T4LgAo74QT0OJP5an4PofLX8_Gk(this));
        this.toggleActionButtons();
        this.loadThumbnail();
    }

    private int getPriceColor() {
        Context context = this.getContext();
        int n = this.enableFullDetails ? 2131099923 : 2131099728;
        return ContextCompat.getColor((Context)context, (int)n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.binding = LayoutOrderListItemBinding.inflate((LayoutInflater)((LayoutInflater)context.getSystemService("layout_inflater")), (ViewGroup)this, (boolean)true);
    }

    private void loadThumbnail() {
        float f = this.getResources().getDimension(2131165688);
        this.binding.thumbnail.setShapeAppearanceModel(this.binding.thumbnail.getShapeAppearanceModel().toBuilder().setAllCorners(0, f).build());
        if (!TextUtils.isEmpty((CharSequence)this.order.getThumbnail())) {
            GlideApp.with((View)this).load(this.order.getThumbnail()).into((ImageView)this.binding.thumbnail);
        }
    }

    public void enableActionButtons(boolean bl) {
        this.showActionButtons = bl;
        this.applyStyle();
    }

    public void enableMinVersion(boolean bl) {
        this.enableFullDetails = bl ^ true;
        this.applyStyle();
    }

    public /* synthetic */ void lambda$applyStyle$0$OrderListItemCard(View view) {
        OrderListItemCardListener orderListItemCardListener = this.listener;
        if (orderListItemCardListener != null) {
            orderListItemCardListener.onDetailsClicked(this.order);
        }
    }

    public /* synthetic */ void lambda$null$1$OrderListItemCard(OrderStatusDialogType orderStatusDialogType) {
        if (orderStatusDialogType.equals((Object)OrderStatusDialogType.ACCEPT)) {
            this.actionListener.onUpdateOrderStatus(this.order, "ACCEPTED");
        }
    }

    public /* synthetic */ void lambda$null$11$OrderListItemCard(OrderStatusDialogType orderStatusDialogType) {
        if (orderStatusDialogType.equals((Object)OrderStatusDialogType.DELIVERED)) {
            this.actionListener.onUpdateOrderStatus(this.order, "DELIVERED");
        }
    }

    public /* synthetic */ void lambda$null$3$OrderListItemCard(OrderStatusDialogType orderStatusDialogType) {
        if (orderStatusDialogType.equals((Object)OrderStatusDialogType.DECLINE)) {
            this.actionListener.onUpdateOrderStatus(this.order, "DECLINED");
        }
    }

    public /* synthetic */ void lambda$null$5$OrderListItemCard(OrderStatusDialogType orderStatusDialogType) {
        if (orderStatusDialogType.equals((Object)OrderStatusDialogType.SHIP)) {
            this.actionListener.onUpdateOrderStatus(this.order, "SHIPPED");
        }
    }

    public /* synthetic */ void lambda$null$7$OrderListItemCard(OrderStatusDialogType orderStatusDialogType) {
        if (orderStatusDialogType.equals((Object)OrderStatusDialogType.CANCEL_ORDER)) {
            this.actionListener.onUpdateOrderStatus(this.order, "CANCELLED");
        }
    }

    public /* synthetic */ void lambda$null$9$OrderListItemCard() {
        this.actionListener.onUpdateOrderStatus(this.order, "FAILED");
    }

    public /* synthetic */ void lambda$toggleActionButtons$10$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showCustomDialog(this.getContext(), DialogType.MARKED, (IdialogItemClickListner)new -$.Lambda.OrderListItemCard.WlmOKa5cv5WCbrizd2_J0yq_AZM(this));
        }
    }

    public /* synthetic */ void lambda$toggleActionButtons$12$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showOrderStatusDialog(this.getContext(), OrderStatusDialogType.DELIVERED, (IOrderStatusItemClickListener)new -$.Lambda.OrderListItemCard.3tJgHUZ8rNcVxTgnSIIoRfhhDp4(this));
        }
    }

    public /* synthetic */ void lambda$toggleActionButtons$2$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showOrderStatusDialog(this.getContext(), OrderStatusDialogType.ACCEPT, (IOrderStatusItemClickListener)new -$.Lambda.OrderListItemCard.KYDgPHeqmCZWufXdMrFuBOmFmNU(this));
        }
    }

    public /* synthetic */ void lambda$toggleActionButtons$4$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showOrderStatusDialog(this.getContext(), OrderStatusDialogType.DECLINE, (IOrderStatusItemClickListener)new -$.Lambda.OrderListItemCard.Mm63rqmC3ioeN4u6SGchm0URoU8(this));
        }
    }

    public /* synthetic */ void lambda$toggleActionButtons$6$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showOrderStatusDialog(this.getContext(), OrderStatusDialogType.SHIP, (IOrderStatusItemClickListener)new -$.Lambda.OrderListItemCard.Z7r33vu5CStv24dhBsCrvOYaBms(this));
        }
    }

    public /* synthetic */ void lambda$toggleActionButtons$8$OrderListItemCard(View view) {
        if (this.actionListener != null) {
            ModalDialogs.showOrderStatusDialog(this.getContext(), OrderStatusDialogType.CANCEL_ORDER, (IOrderStatusItemClickListener)new -$.Lambda.OrderListItemCard._3t_LV_A-vo91JcmP7XHr1RmlwE(this));
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.applyStyle();
    }

    public void setActionListener(OrderListItemCardActionListener orderListItemCardActionListener) {
        this.actionListener = orderListItemCardActionListener;
    }

    public void setListener(OrderListItemCardListener orderListItemCardListener) {
        this.listener = orderListItemCardListener;
    }

    public void setOrder(Order order) {
        this.order = order;
        TextView textView = this.binding.orderNumber;
        Context context = this.getContext();
        Object[] arrobject = new Object[]{String.valueOf((int)order.realmGet$id())};
        textView.setText((CharSequence)context.getString(2131951893, arrobject));
        TextView textView2 = this.binding.price;
        Context context2 = this.getContext();
        Object[] arrobject2 = new Object[]{Float.valueOf((float)order.getGrandTotal())};
        textView2.setText((CharSequence)context2.getString(2131951909, arrobject2));
        if (order.realmGet$products() != null) {
            String string2;
            TextView textView3 = this.binding.itemCount;
            if (order.realmGet$products().size() > 1) {
                Context context3 = this.getContext();
                Object[] arrobject3 = new Object[]{order.realmGet$products().size()};
                string2 = context3.getString(2131951808, arrobject3);
            } else {
                Context context4 = this.getContext();
                Object[] arrobject4 = new Object[]{order.realmGet$products().size()};
                string2 = context4.getString(2131951805, arrobject4);
            }
            textView3.setText((CharSequence)string2);
            this.binding.itemCount.setVisibility(0);
        } else {
            this.binding.itemCount.setVisibility(4);
        }
        this.binding.timestamp.setText((CharSequence)DateTimeUtils.getTimestamp(this.getContext(), AppUtils.stringToDate(order.realmGet$createdAt())));
        this.binding.status.setText((CharSequence)AppUtils.toOrderStatus(this.getContext(), order.realmGet$status()));
        this.applyStyle();
    }

    public void toggleActionButtons() {
        if (this.showActionButtons) {
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
        if (!this.showActionButtons) {
            return;
        }
        TextView textView = this.binding.btnAccept;
        int n = this.order.realmGet$status().equals((Object)"PENDING") ? 0 : 8;
        textView.setVisibility(n);
        TextView textView2 = this.binding.btnDecline;
        int n2 = this.order.realmGet$status().equals((Object)"PENDING") ? 0 : 8;
        textView2.setVisibility(n2);
        TextView textView3 = this.binding.btnCancelOrder;
        int n3 = this.order.realmGet$status().equals((Object)"ACCEPTED") ? 0 : 8;
        textView3.setVisibility(n3);
        TextView textView4 = this.binding.btnShipOrder;
        int n4 = this.order.realmGet$status().equals((Object)"ACCEPTED") ? 0 : 8;
        textView4.setVisibility(n4);
        TextView textView5 = this.binding.btnDeliverd;
        int n5 = this.order.realmGet$status().equals((Object)"SHIPPED") ? 0 : 8;
        textView5.setVisibility(n5);
        TextView textView6 = this.binding.btnNotDelivered;
        int n6 = this.order.realmGet$status().equals((Object)"SHIPPED") ? 0 : 8;
        textView6.setVisibility(n6);
        this.binding.btnAccept.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$h8st0V3Eb9-1H9K-iF1khMr_3nM(this));
        this.binding.btnDecline.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$aA8Do5uS637_A89bOGsHe1Hi7s4(this));
        this.binding.btnShipOrder.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$lw41oCOKpbNJd01YFEG_stcoy0Q(this));
        this.binding.btnCancelOrder.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$92zSmjU0UQMX0fgVLQ586CZCLdo(this));
        this.binding.btnNotDelivered.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$Txlc4b9FDABl_MYYH6q9ZUnx2JM(this));
        this.binding.btnDeliverd.setOnClickListener((OnClickListener)new -$$Lambda$OrderListItemCard$W28wBUn_Gs9XTCTnx_1QFYw6E1Y(this));
    }

    public static interface OrderListItemCardActionListener {
        public void onUpdateOrderStatus(Order var1, String var2);
    }

    public static interface OrderListItemCardListener {
        public void onDetailsClicked(Order var1);
    }

}

