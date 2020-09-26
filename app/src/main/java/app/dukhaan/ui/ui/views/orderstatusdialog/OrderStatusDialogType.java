package app.dukhaan.ui.ui.views.orderstatusdialog;

public enum OrderStatusDialogType {
   ACCEPT,
   CANCEL_ORDER,
   DECLINE,
   DELIVERED,
   SHIP;

   static {
      OrderStatusDialogType var0 = new OrderStatusDialogType("CANCEL_ORDER", 4);
      CANCEL_ORDER = var0;
   }

   private OrderStatusDialogType() {
   }
}
