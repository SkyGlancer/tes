/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.view.View
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.fragment.app.FragmentManager
 *  app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog
 *  app.dukhaan.util.ModalDialogs$1
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package app.dukhaan.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import app.dukhaan.ui.views.customdialog.CustomDialog;
import app.dukhaan.ui.views.customdialog.IdialogItemClickListner;
import app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog;
import app.dukhaan.ui.views.orderstatusdialog.IOrderStatusItemClickListener;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialog;
import app.dukhaan.ui.views.orderstatusdialog.OrderStatusDialogType;
import app.dukhaan.util.-$$Lambda$ModalDialogs$M21mEGOYxQNRzpY0q7mcJ05qJUw;
import app.dukhaan.util.-$$Lambda$ModalDialogs$MeGXpcs0NTpcYXVaeIjO7DtuGwI;
import app.dukhaan.util.DialogType;
import app.dukhaan.util.ModalDialogs;

public final class ModalDialogs {
    static /* synthetic */ void lambda$showOkButtonDialog$0(DialogInterface dialogInterface, int n) {
        dialogInterface.dismiss();
    }

    static /* synthetic */ void lambda$showUnauthorizedError$1(Activity activity, ButtonClickListener buttonClickListener, String string2, String string3) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, 2132017154).setPositiveButton(17039370, (DialogInterface.OnClickListener)buttonClickListener).setCancelable(false).setMessage((CharSequence)string2);
        if (string3 != null) {
            builder.setTitle((CharSequence)string3);
        }
        builder.create().show();
    }

    public static Dialog showAppUpdateDialog(Activity activity, int n, int n2, int n3, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setMessage(n2).setPositiveButton(n3, (DialogInterface.OnClickListener)buttonClickListener).setCancelable(false).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showChoiceDialog(Activity activity, int n, CharSequence[] arrcharSequence, DialogInterface.OnClickListener onClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setNegativeButton(17039360, null).setItems(arrcharSequence, onClickListener).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showConfirmationDialog(Activity activity, int n, int n2, int n3, int n4, ButtonClickListener buttonClickListener) {
        return ModalDialogs.showDialog(activity, n, n2, n3, n4, true, buttonClickListener);
    }

    public static Dialog showConfirmationDialog(Activity activity, int n, String string2, int n2, int n3, ButtonClickListener buttonClickListener) {
        return ModalDialogs.showDialog(activity, n, string2, n2, n3, true, buttonClickListener);
    }

    public static CustomDialog showCustomDialog(Context context, DialogType dialogType, IdialogItemClickListner idialogItemClickListner) {
        CustomDialog customDialog = new CustomDialog(context);
        customDialog.deleteDialog(dialogType);
        customDialog.setListener(idialogItemClickListner);
        return customDialog;
    }

    public static Dialog showDialog(Activity activity, int n, int n2) {
        String string2 = n != -1 ? activity.getString(n) : null;
        return ModalDialogs.showOkButtonDialog(activity, string2, activity.getString(n2), -1);
    }

    public static Dialog showDialog(Activity activity, int n, int n2, int n3, int n4, boolean bl, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setMessage(n2).setCancelable(bl).setPositiveButton(n4, (DialogInterface.OnClickListener)buttonClickListener).setNegativeButton(n3, (DialogInterface.OnClickListener)buttonClickListener).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showDialog(Activity activity, int n, String string2, int n2, int n3, boolean bl, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setMessage((CharSequence)string2).setCancelable(bl).setPositiveButton(n3, (DialogInterface.OnClickListener)buttonClickListener).setNegativeButton(n2, (DialogInterface.OnClickListener)buttonClickListener).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showDialog(Activity activity, String string2, String string3, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity).setPositiveButton(17039370, (DialogInterface.OnClickListener)buttonClickListener).setMessage((CharSequence)string3);
        if (string2 != null) {
            builder.setTitle((CharSequence)string2);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showDialog(Activity activity, String string2, String string3, ButtonClickListener buttonClickListener, int n) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, 2132017154).setPositiveButton(17039370, (DialogInterface.OnClickListener)buttonClickListener).setMessage((CharSequence)string3);
        if (-1 != n) {
            builder.setView(n);
        }
        if (string2 != null) {
            builder.setTitle((CharSequence)string2);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showDialogNonCancellable(Activity activity, int n, int n2) {
        String string2 = n != -1 ? activity.getString(n) : null;
        return ModalDialogs.showDialogNonCancellable(activity, string2, activity.getString(n2), null);
    }

    public static Dialog showDialogNonCancellable(Activity activity, String string2, String string3, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, 2132017154).setPositiveButton(17039370, (DialogInterface.OnClickListener)buttonClickListener).setCancelable(false).setMessage((CharSequence)string3);
        if (string2 != null) {
            builder.setTitle((CharSequence)string2);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static void showDialogWithView(Activity activity, int n, int n2, View view, ButtonClickListener buttonClickListener) {
        if (activity != null) {
            if (activity.isFinishing()) {
                return;
            }
            new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setPositiveButton(n2, (DialogInterface.OnClickListener)buttonClickListener).setNegativeButton(17039360, null).setMessage(null).setView(view).create().show();
        }
    }

    public static NoNetworkFullscreenDialog showNoInternetDialog(FragmentManager fragmentManager, NoNetworkFullscreenDialog.TryAgainClick tryAgainClick) {
        NoNetworkFullscreenDialog noNetworkFullscreenDialog = NoNetworkFullscreenDialog.newInstance();
        noNetworkFullscreenDialog.setTryAgainListener(tryAgainClick);
        noNetworkFullscreenDialog.display(fragmentManager);
        return noNetworkFullscreenDialog;
    }

    public static Dialog showNoNetworkDialog(Activity activity) {
        return ModalDialogs.showNoNetworkDialog(activity, null);
    }

    public static Dialog showNoNetworkDialog(Activity activity, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        if (buttonClickListener == null) {
            buttonClickListener = new 1(activity);
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setCancelable(false).setTitle(2131951994).setNegativeButton(17039360, (DialogInterface.OnClickListener)buttonClickListener).setPositiveButton(2131951774, (DialogInterface.OnClickListener)buttonClickListener).setMessage(2131951773).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showOkButtonDialog(Activity activity, String string2, String string3, int n) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity).setPositiveButton(17039370, (DialogInterface.OnClickListener)-$$Lambda$ModalDialogs$M21mEGOYxQNRzpY0q7mcJ05qJUw.INSTANCE).setMessage((CharSequence)string3);
        if (-1 != n) {
            builder.setView(n);
        }
        if (string2 != null) {
            builder.setTitle((CharSequence)string2);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static OrderStatusDialog showOrderStatusDialog(Context context, OrderStatusDialogType orderStatusDialogType,
                                                          IOrderStatusItemClickListener iOrderStatusItemClickListener) {
        OrderStatusDialog orderStatusDialog = new OrderStatusDialog(context);
        orderStatusDialog.statusTypeDialog(orderStatusDialogType);
        orderStatusDialog.setListener(iOrderStatusItemClickListener);
        return orderStatusDialog;
    }

    public static Dialog showSimpleErrorDialog(Activity activity, int n) {
        return ModalDialogs.showSimpleErrorDialog(activity, activity.getResources().getString(n));
    }

    public static Dialog showSimpleErrorDialog(Activity activity, String string2) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(2131951742).setNeutralButton(17039370, null).setMessage((CharSequence)string2).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showSingleButtonDialog(Activity activity, int n, int n2, int n3, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog alertDialog = new AlertDialog.Builder((Context)activity, 2132017154).setTitle(n).setMessage(n2).setPositiveButton(n3, (DialogInterface.OnClickListener)buttonClickListener).create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog showSingleMessageDialog(Activity activity, int n) {
        return ModalDialogs.showDialog(activity, -1, n);
    }

    public static void showUnauthorizedError(Activity activity, String string2, String string3, ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread((Runnable)new -$$Lambda$ModalDialogs$MeGXpcs0NTpcYXVaeIjO7DtuGwI(activity, buttonClickListener, string3, string2));
    }

    public static Dialog showUnknownError(Activity activity) {
        return ModalDialogs.showDialog(activity, 2131951767, 2131952011);
    }

    public static class ButtonClickListener
    implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int n) {
            if (n != -2) {
                if (n != -1) {
                    return;
                }
                this.onPositiveClick();
                return;
            }
            this.onNegativeClick();
        }

        public void onNegativeClick() {
        }

        public void onPositiveClick() {
        }
    }

}

