/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.graphics.Bitmap
 *  android.graphics.Paint
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  io.branch.referral.Branch
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import io.branch.referral.Branch;
import io.branch.referral.PrefHelper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class BranchViewHandler {
    public static final int BRANCH_VIEW_ERR_ALREADY_SHOWING = -200;
    public static final int BRANCH_VIEW_ERR_INVALID_VIEW = -201;
    public static final int BRANCH_VIEW_ERR_REACHED_LIMIT = -203;
    public static final int BRANCH_VIEW_ERR_TEMP_UNAVAILABLE = -202;
    private static final String BRANCH_VIEW_REDIRECT_ACTION_ACCEPT = "accept";
    private static final String BRANCH_VIEW_REDIRECT_ACTION_CANCEL = "cancel";
    private static final String BRANCH_VIEW_REDIRECT_SCHEME = "branch-cta";
    private static BranchViewHandler thisInstance_;
    private Dialog branchViewDialog_;
    private boolean isBranchViewAccepted_;
    private boolean isBranchViewDialogShowing_;
    private boolean loadingHtmlInBackGround_ = false;
    private BranchView openOrInstallPendingBranchView_ = null;
    private String parentActivityClassName_;
    private boolean webViewLoadError_;

    private BranchViewHandler() {
    }

    private void createAndShowBranchView(final BranchView branchView, Context context, final IBranchViewEvents iBranchViewEvents) {
        if (context != null && branchView != null) {
            final WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, null);
            }
            this.webViewLoadError_ = false;
            if (!TextUtils.isEmpty((CharSequence)branchView.webViewHtml_)) {
                webView.loadDataWithBaseURL(null, branchView.webViewHtml_, "text/html", "utf-8", null);
                webView.setWebViewClient(new WebViewClient(){

                    public void onPageFinished(WebView webView2, String string2) {
                        super.onPageFinished(webView2, string2);
                        BranchViewHandler.this.openBranchViewDialog(branchView, iBranchViewEvents, webView);
                    }

                    public void onPageStarted(WebView webView2, String string2, Bitmap bitmap) {
                        super.onPageStarted(webView2, string2, bitmap);
                    }

                    public void onReceivedError(WebView webView2, int n, String string2, String string3) {
                        super.onReceivedError(webView2, n, string2, string3);
                        BranchViewHandler.this.webViewLoadError_ = true;
                    }

                    public boolean shouldOverrideUrlLoading(WebView webView2, String string2) {
                        boolean bl = BranchViewHandler.this.handleUserActionRedirect(string2);
                        if (!bl) {
                            webView2.loadUrl(string2);
                            return bl;
                        }
                        if (BranchViewHandler.this.branchViewDialog_ != null) {
                            BranchViewHandler.this.branchViewDialog_.dismiss();
                        }
                        return bl;
                    }
                });
            }
        }
    }

    public static BranchViewHandler getInstance() {
        if (thisInstance_ == null) {
            thisInstance_ = new BranchViewHandler();
        }
        return thisInstance_;
    }

    /*
     * Exception decompiling
     */
    private boolean handleUserActionRedirect(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29.1 : ICONST_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void hideViewWithAlphaAnimation(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setStartOffset(10L);
        alphaAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(8);
        view.startAnimation((Animation)alphaAnimation);
    }

    private void openBranchViewDialog(final BranchView branchView, final IBranchViewEvents iBranchViewEvents, WebView webView) {
        if (!this.webViewLoadError_ && Branch.getInstance() != null && Branch.getInstance().currentActivityReference_ != null) {
            Activity activity = (Activity)Branch.getInstance().currentActivityReference_.get();
            if (activity != null) {
                Dialog dialog;
                branchView.updateUsageCount(activity.getApplicationContext(), branchView.branchViewID_);
                this.parentActivityClassName_ = activity.getClass().getName();
                RelativeLayout relativeLayout = new RelativeLayout((Context)activity);
                relativeLayout.setVisibility(8);
                relativeLayout.addView((View)webView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.setBackgroundColor(0);
                Dialog dialog2 = this.branchViewDialog_;
                if (dialog2 != null && dialog2.isShowing()) {
                    if (iBranchViewEvents != null) {
                        iBranchViewEvents.onBranchViewError(-200, "Unable to create a Branch view. A Branch view is already showing", branchView.branchViewAction_);
                    }
                    return;
                }
                this.branchViewDialog_ = dialog = new Dialog((Context)activity, 16973834);
                dialog.setContentView((View)relativeLayout);
                relativeLayout.setVisibility(0);
                webView.setVisibility(0);
                this.branchViewDialog_.show();
                this.showViewWithAlphaAnimation((View)relativeLayout);
                this.showViewWithAlphaAnimation((View)webView);
                this.isBranchViewDialogShowing_ = true;
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.onBranchViewVisible(branchView.branchViewAction_, branchView.branchViewID_);
                }
                this.branchViewDialog_.setOnDismissListener(new DialogInterface.OnDismissListener(){

                    public void onDismiss(DialogInterface dialogInterface) {
                        BranchViewHandler.this.isBranchViewDialogShowing_ = false;
                        BranchViewHandler.this.branchViewDialog_ = null;
                        if (iBranchViewEvents != null) {
                            if (BranchViewHandler.this.isBranchViewAccepted_) {
                                iBranchViewEvents.onBranchViewAccepted(branchView.branchViewAction_, branchView.branchViewID_);
                                return;
                            }
                            iBranchViewEvents.onBranchViewCancelled(branchView.branchViewAction_, branchView.branchViewID_);
                        }
                    }
                });
                return;
            }
        } else {
            this.isBranchViewDialogShowing_ = false;
            if (iBranchViewEvents != null) {
                iBranchViewEvents.onBranchViewError(-202, "Unable to create a Branch view due to a temporary network error", branchView.branchViewAction_);
            }
        }
    }

    private boolean showBranchView(BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
        if (!this.isBranchViewDialogShowing_ && !this.loadingHtmlInBackGround_) {
            this.isBranchViewDialogShowing_ = false;
            this.isBranchViewAccepted_ = false;
            if (context != null && branchView != null) {
                if (branchView.isAvailable(context)) {
                    if (!TextUtils.isEmpty((CharSequence)branchView.webViewHtml_)) {
                        this.createAndShowBranchView(branchView, context, iBranchViewEvents);
                        return true;
                    }
                    this.loadingHtmlInBackGround_ = true;
                    new loadBranchViewTask(branchView, context, iBranchViewEvents).execute((Object[])new Void[0]);
                    return true;
                }
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.onBranchViewError(-203, "Unable to create this Branch view. Reached maximum usage limit ", branchView.branchViewAction_);
                }
            }
            return false;
        }
        if (iBranchViewEvents != null) {
            iBranchViewEvents.onBranchViewError(-200, "Unable to create a Branch view. A Branch view is already showing", branchView.branchViewAction_);
        }
        return false;
    }

    private void showViewWithAlphaAnimation(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setStartOffset(10L);
        alphaAnimation.setInterpolator((Interpolator)new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation((Animation)alphaAnimation);
    }

    public boolean isInstallOrOpenBranchViewPending(Context context) {
        BranchView branchView = this.openOrInstallPendingBranchView_;
        return branchView != null && branchView.isAvailable(context);
    }

    public boolean markInstallOrOpenBranchViewPending(JSONObject jSONObject, String string2) {
        Activity activity;
        BranchView branchView = new BranchView(this, jSONObject, string2);
        if (Branch.getInstance().currentActivityReference_ != null && (activity = (Activity)Branch.getInstance().currentActivityReference_.get()) != null && branchView.isAvailable((Context)activity)) {
            this.openOrInstallPendingBranchView_ = new BranchView(this, jSONObject, string2);
            return true;
        }
        return false;
    }

    public void onCurrentActivityDestroyed(Activity activity) {
        String string2 = this.parentActivityClassName_;
        if (string2 != null && string2.equalsIgnoreCase(activity.getClass().getName())) {
            this.isBranchViewDialogShowing_ = false;
        }
    }

    public boolean showBranchView(JSONObject jSONObject, String string2, Context context, IBranchViewEvents iBranchViewEvents) {
        return this.showBranchView(new BranchView(this, jSONObject, string2), context, iBranchViewEvents);
    }

    public boolean showPendingBranchView(Context context) {
        boolean bl = this.showBranchView(this.openOrInstallPendingBranchView_, context, null);
        if (bl) {
            this.openOrInstallPendingBranchView_ = null;
        }
        return bl;
    }

    private class BranchView {
        private static final int USAGE_UNLIMITED = -1;
        private String branchViewAction_;
        private String branchViewID_;
        private int num_of_use_;
        final /* synthetic */ BranchViewHandler this$0;
        private String webViewHtml_;
        private String webViewUrl_;

        /*
         * Exception decompiling
         */
        private BranchView(BranchViewHandler var1, JSONObject var2, String var3) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
            // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
            // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
            // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:919)
            throw new IllegalStateException("Decompilation failed");
        }

        static /* synthetic */ String access$1100(BranchView branchView) {
            return branchView.webViewUrl_;
        }

        static /* synthetic */ String access$302(BranchView branchView, String string2) {
            branchView.webViewHtml_ = string2;
            return string2;
        }

        private boolean isAvailable(Context context) {
            int n = this.num_of_use_;
            int n2 = PrefHelper.getInstance(context).getBranchViewUsageCount(this.branchViewID_);
            return n > n2 || n == -1;
            {
            }
        }

        public void updateUsageCount(Context context, String string2) {
            PrefHelper.getInstance(context).updateBranchViewUsageCount(string2);
        }
    }

    private class loadBranchViewTask
    extends AsyncTask<Void, Void, Boolean> {
        private final BranchView branchView;
        private final IBranchViewEvents callback;
        private final Context context;
        private String htmlString;

        public loadBranchViewTask(BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
            this.branchView = branchView;
            this.context = context;
            this.callback = iBranchViewEvents;
        }

        /*
         * Exception decompiling
         */
        protected /* varargs */ Boolean doInBackground(Void ... var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64 : ICONST_0 : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:919)
            throw new IllegalStateException("Decompilation failed");
        }

        protected void onPostExecute(Boolean bl) {
            super.onPostExecute((Object)bl);
            if (bl.booleanValue()) {
                BranchViewHandler.this.createAndShowBranchView(this.branchView, this.context, this.callback);
            } else {
                IBranchViewEvents iBranchViewEvents = this.callback;
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.onBranchViewError(-202, "Unable to create a Branch view due to a temporary network error", this.branchView.branchViewAction_);
                }
            }
            BranchViewHandler.this.loadingHtmlInBackGround_ = false;
        }
    }

}

