/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.text.format.DateFormat
 *  android.view.View
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.net.URLEncoder
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Semaphore
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Base64;
import io.branch.referral.Branch;
import io.branch.referral.BranchActivityLifecycleObserver;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.BranchError;
import io.branch.referral.BranchLinkData;
import io.branch.referral.BranchPreinstall;
import io.branch.referral.BranchShareSheetBuilder;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.BranchStrongMatchHelper;
import io.branch.referral.BranchUniversalReferralInitWrapper;
import io.branch.referral.BranchUtil;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.DeferredAppLinkDataHandler;
import io.branch.referral.Defines;
import io.branch.referral.DeviceInfo;
import io.branch.referral.GooglePlayStoreAttribution;
import io.branch.referral.InstantAppUtil;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerRequestActionCompleted;
import io.branch.referral.ServerRequestCreateUrl;
import io.branch.referral.ServerRequestGetCPID;
import io.branch.referral.ServerRequestGetLATD;
import io.branch.referral.ServerRequestGetRewardHistory;
import io.branch.referral.ServerRequestGetRewards;
import io.branch.referral.ServerRequestIdentifyUserRequest;
import io.branch.referral.ServerRequestInitSession;
import io.branch.referral.ServerRequestLogout;
import io.branch.referral.ServerRequestPing;
import io.branch.referral.ServerRequestQueue;
import io.branch.referral.ServerRequestRedeemRewards;
import io.branch.referral.ServerRequestRegisterClose;
import io.branch.referral.ServerRequestRegisterInstall;
import io.branch.referral.ServerRequestRegisterOpen;
import io.branch.referral.ServerResponse;
import io.branch.referral.ShareLinkManager;
import io.branch.referral.SharingHelper;
import io.branch.referral.SystemObserver;
import io.branch.referral.TrackingController;
import io.branch.referral.UniversalResourceAnalyser;
import io.branch.referral.network.BranchRemoteInterface;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchEvent;
import io.branch.referral.util.CommerceEvent;
import io.branch.referral.util.LinkProperties;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Branch
implements BranchViewHandler.IBranchViewEvents,
SystemObserver.AdsParamsFetchEvents,
GooglePlayStoreAttribution.IInstallReferrerEvents {
    public static final String ALWAYS_DEEPLINK = "$always_deeplink";
    private static final String AUTO_DEEP_LINKED = "io.branch.sdk.auto_linked";
    private static final String AUTO_DEEP_LINK_DISABLE = "io.branch.sdk.auto_link_disable";
    private static final String AUTO_DEEP_LINK_KEY = "io.branch.sdk.auto_link_keys";
    private static final String AUTO_DEEP_LINK_PATH = "io.branch.sdk.auto_link_path";
    private static final String AUTO_DEEP_LINK_REQ_CODE = "io.branch.sdk.auto_link_request_code";
    private static final String BRANCH_LIBRARY_VERSION = "io.branch.sdk.android:library:5.0.2";
    public static final String DEEPLINK_PATH = "$deeplink_path";
    private static final int DEF_AUTO_DEEP_LINK_REQ_CODE = 1501;
    private static final String[] EXTERNAL_INTENT_EXTRA_KEY_WHITE_LIST = new String[]{"extra_launch_uri", "branch_intent"};
    public static final String FEATURE_TAG_DEAL = "deal";
    public static final String FEATURE_TAG_GIFT = "gift";
    public static final String FEATURE_TAG_INVITE = "invite";
    public static final String FEATURE_TAG_REFERRAL = "referral";
    public static final String FEATURE_TAG_SHARE = "share";
    private static final String GOOGLE_VERSION_TAG = "!SDK-VERSION-STRING!:io.branch.sdk.android:library:5.0.2";
    private static int LATCH_WAIT_UNTIL = 2500;
    public static final int LINK_TYPE_ONE_TIME_USE = 1;
    public static final int LINK_TYPE_UNLIMITED_USE = 0;
    public static final long NO_PLAY_STORE_REFERRER_WAIT = 0L;
    public static final String OG_APP_ID = "$og_app_id";
    public static final String OG_DESC = "$og_description";
    public static final String OG_IMAGE_URL = "$og_image_url";
    public static final String OG_TITLE = "$og_title";
    public static final String OG_URL = "$og_url";
    public static final String OG_VIDEO = "$og_video";
    public static final String REDEEM_CODE = "$redeem_code";
    public static final String REDIRECT_ANDROID_URL = "$android_url";
    public static final String REDIRECT_BLACKBERRY_URL = "$blackberry_url";
    public static final String REDIRECT_DESKTOP_URL = "$desktop_url";
    public static final String REDIRECT_FIRE_URL = "$fire_url";
    public static final String REDIRECT_IOS_URL = "$ios_url";
    public static final String REDIRECT_IPAD_URL = "$ipad_url";
    public static final String REDIRECT_WINDOWS_PHONE_URL = "$windows_phone_url";
    public static final String REFERRAL_BUCKET_DEFAULT = "default";
    public static final String REFERRAL_CODE = "referral_code";
    public static final int REFERRAL_CODE_AWARD_UNIQUE = 0;
    public static final int REFERRAL_CODE_AWARD_UNLIMITED = 1;
    public static final int REFERRAL_CODE_LOCATION_BOTH = 3;
    public static final int REFERRAL_CODE_LOCATION_REFERREE = 0;
    public static final int REFERRAL_CODE_LOCATION_REFERRING_USER = 2;
    public static final String REFERRAL_CODE_TYPE = "credit";
    public static final int REFERRAL_CREATION_SOURCE_SDK = 2;
    private static Branch branchReferral_;
    private static boolean bypassCurrentActivityIntentState_ = false;
    static boolean bypassWaitingForIntent_ = false;
    static boolean checkInstallReferrer_ = true;
    private static String cookieBasedMatchDomain_ = "app.link";
    static boolean disableAutoSessionInitialization = false;
    private static boolean disableDeviceIDFetch_ = false;
    private static boolean enableInstantDeepLinking = false;
    private static boolean isActivityLifeCycleCallbackRegistered_ = false;
    private static boolean isAutoSessionMode_ = false;
    private static boolean isSimulatingInstalls_ = false;
    private static long playStoreReferrerWaitTime = 1500L;
    private static String pluginName;
    private static String pluginVersion;
    private BranchActivityLifecycleObserver activityLifeCycleObserver;
    private BranchRemoteInterface branchRemoteInterface_;
    private Context context_;
    WeakReference<Activity> currentActivityReference_;
    private JSONObject deeplinkDebugParams_;
    private final DeviceInfo deviceInfo_;
    private boolean enableFacebookAppLinkCheck_ = false;
    private CountDownLatch getFirstReferringParamsLatch = null;
    private CountDownLatch getLatestReferringParamsLatch = null;
    private boolean hasNetwork_;
    private SESSION_STATE initState_ = SESSION_STATE.UNINITIALISED;
    private final ConcurrentHashMap<String, String> instrumentationExtraData_;
    private INTENT_STATE intentState_ = INTENT_STATE.PENDING;
    private boolean isGAParamsFetchInProgress_ = false;
    private boolean isInstantDeepLinkPossible = false;
    private Map<BranchLinkData, String> linkCache_;
    final Object lock;
    private int networkCount_;
    private boolean performCookieBasedStrongMatchingOnGAIDAvailable = false;
    private PrefHelper prefHelper_;
    private final ServerRequestQueue requestQueue_;
    private Semaphore serverSema_;
    private ShareLinkManager shareLinkManager_;
    private final TrackingController trackingController;

    static {
        enableInstantDeepLinking = false;
        pluginVersion = null;
        pluginName = null;
    }

    private Branch(Context context) {
        this.prefHelper_ = PrefHelper.getInstance(context);
        this.trackingController = new TrackingController(context);
        this.branchRemoteInterface_ = BranchRemoteInterface.getDefaultBranchRemoteInterface(context);
        this.deviceInfo_ = DeviceInfo.initialize(context);
        this.requestQueue_ = ServerRequestQueue.getInstance(context);
        this.serverSema_ = new Semaphore(1);
        this.lock = new Object();
        this.networkCount_ = 0;
        this.hasNetwork_ = true;
        this.linkCache_ = new HashMap();
        this.instrumentationExtraData_ = new ConcurrentHashMap();
        if (!this.trackingController.isTrackingDisabled()) {
            this.isGAParamsFetchInProgress_ = this.deviceInfo_.getSystemObserver().prefetchAdsParams(context, this);
        }
    }

    static /* synthetic */ void access$1000(Branch branch) {
        branch.updateAllRequestsInQueue();
    }

    static /* synthetic */ Branch access$1100() {
        return branchReferral_;
    }

    static /* synthetic */ CountDownLatch access$1300(Branch branch) {
        return branch.getLatestReferringParamsLatch;
    }

    static /* synthetic */ CountDownLatch access$1400(Branch branch) {
        return branch.getFirstReferringParamsLatch;
    }

    static /* synthetic */ SESSION_STATE access$1500(Branch branch) {
        return branch.initState_;
    }

    static /* synthetic */ ServerRequestQueue access$200(Branch branch) {
        return branch.requestQueue_;
    }

    static /* synthetic */ void access$300(Branch branch) {
        branch.processNextQueueItem();
    }

    static /* synthetic */ boolean access$600(Branch branch) {
        return branch.hasNetwork_;
    }

    static /* synthetic */ boolean access$602(Branch branch, boolean bl) {
        branch.hasNetwork_ = bl;
        return bl;
    }

    static /* synthetic */ void access$700(Branch branch, int n, int n2) {
        branch.handleFailure(n, n2);
    }

    static /* synthetic */ int access$802(Branch branch, int n) {
        branch.networkCount_ = n;
        return n;
    }

    static /* synthetic */ Map access$900(Branch branch) {
        return branch.linkCache_;
    }

    /*
     * Exception decompiling
     */
    private JSONObject appendDebugParams(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl32.1 : ALOAD_1 : trying to set 1 previously set to 0
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

    public static boolean bypassCurrentActivityIntentState() {
        return bypassCurrentActivityIntentState_;
    }

    public static void bypassWaitingForIntent(boolean bl) {
        bypassWaitingForIntent_ = bl;
    }

    /*
     * Exception decompiling
     */
    private void checkForAutoDeepLinkConfiguration() {
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

    private boolean checkForAutoDeepLinkKeys(JSONObject jSONObject, ActivityInfo activityInfo) {
        if (activityInfo.metaData.getString(AUTO_DEEP_LINK_KEY) != null) {
            String[] arrstring = activityInfo.metaData.getString(AUTO_DEEP_LINK_KEY).split(",");
            int n = arrstring.length;
            for (int i = 0; i < n; ++i) {
                if (!jSONObject.has(arrstring[i])) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private boolean checkForAutoDeepLinkPath(JSONObject var1, ActivityInfo var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29.1 : ALOAD_2 : trying to set 1 previously set to 0
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

    private boolean checkIntentForSessionRestart(Intent intent) {
        boolean bl = false;
        if (intent != null) {
            bl = intent.getBooleanExtra(Defines.IntentKeys.ForceNewBranchSession.getKey(), false);
        }
        return bl;
    }

    private boolean checkIntentForUnusedBranchLink(Intent intent) {
        boolean bl = false;
        if (intent != null) {
            boolean bl2 = intent.getStringExtra(Defines.IntentKeys.BranchURI.getKey()) != null;
            boolean bl3 = true ^ intent.getBooleanExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), false);
            bl = false;
            if (bl2) {
                bl = false;
                if (bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private String convertDate(Date date) {
        return DateFormat.format((CharSequence)"yyyy-MM-dd", (Date)date).toString();
    }

    private JSONObject convertParamsStringToDictionary(String string2) {
        if (string2.equals((Object)"bnc_no_value")) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            byte[] arrby = Base64.decode(string2.getBytes(), 2);
            try {
                JSONObject jSONObject = new JSONObject(new String(arrby));
                return jSONObject;
            }
            catch (JSONException jSONException2) {
                jSONException2.printStackTrace();
                return new JSONObject();
            }
        }
    }

    public static void disableDebugMode() {
    }

    public static void disableDeviceIDFetch(Boolean bl) {
        disableDeviceIDFetch_ = bl;
    }

    @Deprecated
    public static void disableForcedSession() {
        Branch.bypassWaitingForIntent(false);
    }

    public static void disableInstantDeepLinking(boolean bl) {
        enableInstantDeepLinking = bl ^ true;
    }

    public static void disableLogging() {
        PrefHelper.enableLogging(false);
    }

    public static void disableSimulateInstalls() {
    }

    public static void disableTestMode() {
        BranchUtil.setTestMode(false);
    }

    public static void enableBypassCurrentActivityIntentState() {
        bypassCurrentActivityIntentState_ = true;
    }

    public static void enableCookieBasedMatching(String string2) {
        cookieBasedMatchDomain_ = string2;
    }

    public static void enableCookieBasedMatching(String string2, int n) {
        cookieBasedMatchDomain_ = string2;
        BranchStrongMatchHelper.getInstance().setStrongMatchUrlHitDelay(n);
    }

    public static void enableDebugMode() {
        PrefHelper.LogAlways("enableDebugMode is deprecated and all functionality has been disabled. If you wish to enable logging, please invoke enableLogging. If you wish to simulate installs, please see add a Test Device (https://help.branch.io/using-branch/docs/adding-test-devices) then reset your test device's data (https://help.branch.io/using-branch/docs/adding-test-devices#section-resetting-your-test-device-data). If you wish to use the test key rather than the live key, please invoke enableTestMode.");
    }

    @Deprecated
    public static void enableForcedSession() {
        Branch.bypassWaitingForIntent(true);
    }

    public static void enableLogging() {
        PrefHelper.LogAlways(GOOGLE_VERSION_TAG);
        PrefHelper.enableLogging(true);
    }

    public static void enablePlayStoreReferrer(long l) {
        Branch.setPlayStoreReferrerCheckTimeout(l);
    }

    public static void enableSimulateInstalls() {
        PrefHelper.LogAlways("enableSimulateInstalls is deprecated and all functionality has been disabled. If you wish to simulate installs, please see add a Test Device (https://help.branch.io/using-branch/docs/adding-test-devices) then reset your test device's data (https://help.branch.io/using-branch/docs/adding-test-devices#section-resetting-your-test-device-data).");
    }

    public static void enableTestMode() {
        BranchUtil.setTestMode(true);
        PrefHelper.LogAlways("enableTestMode has been changed. It now uses the test key but will not log or randomize the device IDs. If you wish to enable logging, please invoke enableLogging. If you wish to simulate installs, please see add a Test Device (https://help.branch.io/using-branch/docs/adding-test-devices) then reset your test device's data (https://help.branch.io/using-branch/docs/adding-test-devices#section-resetting-your-test-device-data).");
    }

    private void executeClose() {
        if (this.initState_ != SESSION_STATE.UNINITIALISED) {
            if (!this.hasNetwork_) {
                ServerRequest serverRequest = this.requestQueue_.peek();
                if (serverRequest instanceof ServerRequestRegisterInstall || serverRequest instanceof ServerRequestRegisterOpen) {
                    this.requestQueue_.dequeue();
                }
            } else if (!this.requestQueue_.containsClose()) {
                this.handleNewRequest(new ServerRequestRegisterClose(this.context_));
            }
            this.setInitState(SESSION_STATE.UNINITIALISED);
        }
    }

    public static void expectDelayedSessionInitialization(boolean bl) {
        disableAutoSessionInitialization = bl;
    }

    private void extractAppLink(Uri uri, Activity activity) {
        if (uri != null) {
            if (activity == null) {
                return;
            }
            String string2 = uri.getScheme();
            Intent intent = activity.getIntent();
            if (string2 != null && intent != null && (string2.equalsIgnoreCase("http") || string2.equalsIgnoreCase("https")) && !TextUtils.isEmpty((CharSequence)uri.getHost()) && !this.isIntentParamsAlreadyConsumed(activity)) {
                String string3 = UniversalResourceAnalyser.getInstance(this.context_).getStrippedURL(uri.toString());
                if (uri.toString().equalsIgnoreCase(string3)) {
                    this.prefHelper_.setAppLink(uri.toString());
                }
                intent.putExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), true);
                activity.setIntent(intent);
            }
        }
    }

    /*
     * Exception decompiling
     */
    private boolean extractBranchLinkFromIntentExtra(Activity var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl60.1 : ICONST_0 : trying to set 1 previously set to 0
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

    /*
     * Exception decompiling
     */
    private boolean extractClickID(Uri var1, Activity var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl124.1 : ICONST_0 : trying to set 0 previously set to 1
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

    /*
     * Exception decompiling
     */
    private void extractExternalUriAndIntentExtras(Uri var1, Activity var2) {
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

    /*
     * Exception decompiling
     */
    private void extractSessionParamsForIDL(Uri var1, Activity var2) {
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

    private void generateShortLinkAsync(ServerRequest serverRequest) {
        this.handleNewRequest(serverRequest);
    }

    /*
     * Exception decompiling
     */
    private String generateShortLinkSync(ServerRequestCreateUrl var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39 : ALOAD_1 : trying to set 1 previously set to 0
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

    public static Branch getAutoInstance(Context context) {
        isAutoSessionMode_ = true;
        Branch.getBranchInstance(context, true ^ BranchUtil.checkTestMode(context), null);
        BranchPreinstall.getPreinstallSystemData(branchReferral_, context);
        return branchReferral_;
    }

    public static Branch getAutoInstance(Context context, String string2) {
        isAutoSessionMode_ = true;
        Branch.getBranchInstance(context, true ^ BranchUtil.checkTestMode(context), string2);
        if (Branch.branchReferral_.prefHelper_.isValidBranchKey(string2)) {
            if (Branch.branchReferral_.prefHelper_.setBranchKey(string2)) {
                Branch.branchReferral_.linkCache_.clear();
                Branch.branchReferral_.requestQueue_.clear();
            }
        } else {
            PrefHelper.Debug("Branch Key is invalid. Please check your BranchKey");
        }
        BranchPreinstall.getPreinstallSystemData(branchReferral_, context);
        return branchReferral_;
    }

    public static Branch getAutoInstance(Context context, boolean bl) {
        isAutoSessionMode_ = true;
        Branch.getBranchInstance(context, true ^ BranchUtil.checkTestMode(context), null);
        BranchPreinstall.getPreinstallSystemData(branchReferral_, context);
        branchReferral_.setIsReferrable(bl);
        return branchReferral_;
    }

    public static Branch getAutoTestInstance(Context context) {
        isAutoSessionMode_ = true;
        Branch.getBranchInstance(context, false, null);
        BranchPreinstall.getPreinstallSystemData(branchReferral_, context);
        return branchReferral_;
    }

    public static Branch getAutoTestInstance(Context context, boolean bl) {
        isAutoSessionMode_ = true;
        Branch.getBranchInstance(context, false, null);
        BranchPreinstall.getPreinstallSystemData(branchReferral_, context);
        branchReferral_.setIsReferrable(bl);
        return branchReferral_;
    }

    private static Branch getBranchInstance(Context context, boolean bl, String string2) {
        if (branchReferral_ == null) {
            boolean bl2;
            branchReferral_ = Branch.initInstance(context);
            boolean bl3 = BranchUtil.checkTestMode(context);
            if (bl) {
                bl3 = false;
            }
            BranchUtil.setTestMode(bl3);
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = BranchUtil.readBranchKey(context);
            }
            if (TextUtils.isEmpty((CharSequence)string2)) {
                PrefHelper.Debug("Warning: Please enter your branch_key in your project's Manifest file!");
                bl2 = Branch.branchReferral_.prefHelper_.setBranchKey("bnc_no_value");
            } else {
                bl2 = Branch.branchReferral_.prefHelper_.setBranchKey(string2);
            }
            if (bl2) {
                Branch.branchReferral_.linkCache_.clear();
                Branch.branchReferral_.requestQueue_.clear();
            }
            Branch.branchReferral_.context_ = context.getApplicationContext();
            if (context instanceof Application) {
                isAutoSessionMode_ = true;
                branchReferral_.setActivityLifeCycleObserver((Application)context);
            }
        }
        return branchReferral_;
    }

    public static Branch getInstance() {
        if (branchReferral_ == null) {
            PrefHelper.Debug("Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (isAutoSessionMode_ && !isActivityLifeCycleCallbackRegistered_) {
            PrefHelper.Debug("Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return branchReferral_;
    }

    public static Branch getInstance(Context context) {
        return Branch.getBranchInstance(context, true, null);
    }

    public static Branch getInstance(Context context, String string2) {
        if (branchReferral_ == null) {
            branchReferral_ = Branch.initInstance(context);
        }
        Branch.branchReferral_.context_ = context.getApplicationContext();
        if (Branch.branchReferral_.prefHelper_.isValidBranchKey(string2)) {
            if (Branch.branchReferral_.prefHelper_.setBranchKey(string2)) {
                Branch.branchReferral_.linkCache_.clear();
                Branch.branchReferral_.requestQueue_.clear();
            }
        } else {
            PrefHelper.Debug("Branch Key is invalid. Please check your BranchKey");
        }
        return branchReferral_;
    }

    static String getPluginName() {
        return pluginName;
    }

    public static String getPluginVersion() {
        return pluginVersion;
    }

    public static String getSdkVersionNumber() {
        return "5.0.2";
    }

    public static Branch getTestInstance(Context context) {
        return Branch.getBranchInstance(context, false, null);
    }

    private void handleFailure(int n, int n2) {
        ServerRequest serverRequest;
        if (n >= this.requestQueue_.getSize()) {
            ServerRequestQueue serverRequestQueue = this.requestQueue_;
            serverRequest = serverRequestQueue.peekAt(-1 + serverRequestQueue.getSize());
        } else {
            serverRequest = this.requestQueue_.peekAt(n);
        }
        this.handleFailure(serverRequest, n2);
    }

    private void handleFailure(ServerRequest serverRequest, int n) {
        if (serverRequest == null) {
            return;
        }
        serverRequest.handleFailure(n, "");
    }

    private boolean hasDeviceFingerPrint() {
        return true ^ this.prefHelper_.getDeviceFingerPrintID().equals((Object)"bnc_no_value");
    }

    private boolean hasSession() {
        return true ^ this.prefHelper_.getSessionID().equals((Object)"bnc_no_value");
    }

    private boolean hasUser() {
        return true ^ this.prefHelper_.getIdentityID().equals((Object)"bnc_no_value");
    }

    private static Branch initInstance(Context context) {
        return new Branch(context.getApplicationContext());
    }

    private void initializeSession(BranchReferralInitListener branchReferralInitListener) {
        this.initializeSession(branchReferralInitListener, 0);
    }

    private void initializeSession(BranchReferralInitListener branchReferralInitListener, int n) {
        if (this.prefHelper_.getBranchKey() != null && !this.prefHelper_.getBranchKey().equalsIgnoreCase("bnc_no_value")) {
            if (BranchUtil.isTestModeEnabled()) {
                PrefHelper.Debug("Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
            }
            ServerRequestInitSession serverRequestInitSession = this.getInstallOrOpenRequest(branchReferralInitListener);
            if (this.initState_ == SESSION_STATE.UNINITIALISED && this.getSessionReferredLink() == null && this.enableFacebookAppLinkCheck_ && DeferredAppLinkDataHandler.fetchDeferredAppLinkData(this.context_, new DeferredAppLinkDataHandler.AppLinkFetchEvents(this){
                final /* synthetic */ Branch this$0;
                {
                    this.this$0 = branch;
                }

                public void onAppLinkFetchFinished(String string2) {
                    String string3;
                    Branch.access$100(this.this$0).setIsAppLinkTriggeredInit(true);
                    if (string2 != null && !TextUtils.isEmpty((CharSequence)(string3 = Uri.parse((String)string2).getQueryParameter(Defines.Jsonkey.LinkClickID.getKey())))) {
                        Branch.access$100(this.this$0).setLinkClickIdentifier(string3);
                    }
                    Branch.access$200(this.this$0).unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
                    Branch.access$300(this.this$0);
                }
            }).booleanValue()) {
                serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
            }
            if (n > 0) {
                serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.USER_SET_WAIT_LOCK);
                new Handler().postDelayed(new Runnable(this){
                    final /* synthetic */ Branch this$0;
                    {
                        this.this$0 = branch;
                    }

                    public void run() {
                        this.this$0.removeSessionInitializationDelay();
                    }
                }, (long)n);
            }
            Intent intent = this.getCurrentActivity() != null ? this.getCurrentActivity().getIntent() : null;
            boolean bl = this.isRestartSessionRequested(intent);
            if (this.getInitState() != SESSION_STATE.UNINITIALISED && !bl) {
                if (branchReferralInitListener != null) {
                    branchReferralInitListener.onInitFinished(null, new BranchError("Warning.", -118));
                    return;
                }
            } else {
                if (bl && intent != null) {
                    intent.removeExtra(Defines.IntentKeys.ForceNewBranchSession.getKey());
                }
                this.registerAppInit(serverRequestInitSession, false);
            }
            return;
        }
        this.setInitState(SESSION_STATE.UNINITIALISED);
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -114));
        }
        PrefHelper.Debug("Warning: Please enter your branch_key in your project's manifest");
    }

    private void insertRequestAtFront(ServerRequest serverRequest) {
        if (this.networkCount_ == 0) {
            this.requestQueue_.insert(serverRequest, 0);
            return;
        }
        this.requestQueue_.insert(serverRequest, 1);
    }

    private boolean isActivityLaunchedFromHistory(Activity activity) {
        return activity != null && activity.getIntent() != null && (1048576 & activity.getIntent().getFlags()) != 0;
    }

    public static boolean isAutoDeepLinkLaunch(Activity activity) {
        return activity.getIntent().getStringExtra(AUTO_DEEP_LINKED) != null;
    }

    public static boolean isDeviceIDFetchDisabled() {
        return disableDeviceIDFetch_;
    }

    @Deprecated
    public static boolean isForceSessionEnabled() {
        return Branch.isWaitingForIntent();
    }

    public static boolean isInstantApp(Context context) {
        return InstantAppUtil.isInstantApp(context);
    }

    private boolean isIntentParamsAlreadyConsumed(Activity activity) {
        boolean bl = false;
        if (activity != null) {
            Intent intent = activity.getIntent();
            bl = false;
            if (intent != null) {
                boolean bl2 = activity.getIntent().getBooleanExtra(Defines.IntentKeys.BranchLinkUsed.getKey(), false);
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private boolean isSessionAvailableForRequest() {
        return this.hasSession() && this.hasDeviceFingerPrint();
    }

    public static boolean isWaitingForIntent() {
        return true ^ bypassWaitingForIntent_;
    }

    private boolean pathMatch(String string2, String string3) {
        String[] arrstring;
        String[] arrstring2 = string2.split("\\?")[0].split("/");
        if (arrstring2.length != (arrstring = string3.split("\\?")[0].split("/")).length) {
            return false;
        }
        for (int i = 0; i < arrstring2.length && i < arrstring.length; ++i) {
            String string4 = arrstring2[i];
            if (string4.equals((Object)arrstring[i]) || string4.contains((CharSequence)"*")) continue;
            return false;
        }
        return true;
    }

    private void performCookieBasedStrongMatch() {
        if (!this.trackingController.isTrackingDisabled() && this.context_ != null) {
            this.requestQueue_.setStrongMatchWaitLock();
            BranchStrongMatchHelper.getInstance().checkForStrongMatch(this.context_, cookieBasedMatchDomain_, this.deviceInfo_, this.prefHelper_, new BranchStrongMatchHelper.StrongMatchCheckEvents(this){
                final /* synthetic */ Branch this$0;
                {
                    this.this$0 = branch;
                }

                public void onStrongMatchCheckFinished() {
                    Branch.access$200(this.this$0).unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.STRONG_MATCH_PENDING_WAIT_LOCK);
                    Branch.access$300(this.this$0);
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processNextQueueItem() {
        try {
            this.serverSema_.acquire();
            if (this.networkCount_ == 0 && this.requestQueue_.getSize() > 0) {
                this.networkCount_ = 1;
                ServerRequest serverRequest = this.requestQueue_.peek();
                this.serverSema_.release();
                if (serverRequest == null) {
                    this.requestQueue_.remove(null);
                    return;
                }
                if (serverRequest.isWaitingOnProcessToFinish()) {
                    this.networkCount_ = 0;
                    return;
                }
                if (!(serverRequest instanceof ServerRequestRegisterInstall) && !this.hasUser()) {
                    PrefHelper.Debug("Branch Error: User session has not been initialized!");
                    this.networkCount_ = 0;
                    this.handleFailure(this.requestQueue_.getSize() - 1, -101);
                    return;
                }
                if (this.requestNeedsSession(serverRequest) && !this.isSessionAvailableForRequest()) {
                    this.networkCount_ = 0;
                    this.handleFailure(this.requestQueue_.getSize() - 1, -101);
                    return;
                }
                new BranchAsyncTask<Void, Void, ServerResponse>(serverRequest){
                    ServerRequest thisReq_;
                    {
                        this.thisReq_ = serverRequest;
                    }

                    protected /* varargs */ ServerResponse doInBackground(Void ... arrvoid) {
                        Branch branch = Branch.this;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.thisReq_.getRequestPath());
                        stringBuilder.append("-");
                        stringBuilder.append(Defines.Jsonkey.Queue_Wait_Time.getKey());
                        branch.addExtraInstrumentationData(stringBuilder.toString(), String.valueOf((long)this.thisReq_.getQueueWaitTime()));
                        this.thisReq_.doFinalUpdateOnBackgroundThread();
                        if (Branch.this.isTrackingDisabled() && !this.thisReq_.prepareExecuteWithoutTracking()) {
                            return new ServerResponse(this.thisReq_.getRequestPath(), -117);
                        }
                        if (this.thisReq_.isGetRequest()) {
                            return Branch.this.branchRemoteInterface_.make_restful_get(this.thisReq_.getRequestUrl(), this.thisReq_.getGetParams(), this.thisReq_.getRequestPath(), Branch.this.prefHelper_.getBranchKey());
                        }
                        return Branch.this.branchRemoteInterface_.make_restful_post(this.thisReq_.getPostWithInstrumentationValues((ConcurrentHashMap<String, String>)Branch.this.instrumentationExtraData_), this.thisReq_.getRequestUrl(), this.thisReq_.getRequestPath(), Branch.this.prefHelper_.getBranchKey());
                    }

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    protected void onPostExecute(ServerResponse var1_1) {
                        super.onPostExecute((Object)var1_1);
                        if (var1_1 == null) return;
                        try {
                            block32 : {
                                block33 : {
                                    block30 : {
                                        block29 : {
                                            block25 : {
                                                block31 : {
                                                    block27 : {
                                                        block28 : {
                                                            block26 : {
                                                                block24 : {
                                                                    var3_2 = var1_1.getStatusCode();
                                                                    var4_3 = Branch.this;
                                                                    var5_4 = true;
                                                                    Branch.access$602(var4_3, var5_4);
                                                                    if (var1_1.getStatusCode() != -117) break block24;
                                                                    this.thisReq_.reportTrackingDisabledError();
                                                                    Branch.access$200(Branch.this).remove(this.thisReq_);
                                                                    break block25;
                                                                }
                                                                if (var3_2 == 200) break block26;
                                                                if (this.thisReq_ instanceof ServerRequestInitSession) {
                                                                    Branch.this.setInitState(SESSION_STATE.UNINITIALISED);
                                                                }
                                                                break block27;
                                                            }
                                                            Branch.access$602(Branch.this, var5_4);
                                                            if (this.thisReq_ instanceof ServerRequestCreateUrl) {
                                                                if (var1_1.getObject() != null) {
                                                                    var24_11 = var1_1.getObject().getString("url");
                                                                    Branch.access$900(Branch.this).put((Object)((ServerRequestCreateUrl)this.thisReq_).getLinkPost(), (Object)var24_11);
                                                                }
                                                            } else if (this.thisReq_ instanceof ServerRequestLogout) {
                                                                Branch.access$900(Branch.this).clear();
                                                                Branch.access$200(Branch.this).clear();
                                                            }
                                                            Branch.access$200(Branch.this).dequeue();
                                                            if (this.thisReq_ instanceof ServerRequestInitSession || this.thisReq_ instanceof ServerRequestIdentifyUserRequest) break block28;
                                                            this.thisReq_.onRequestSucceeded(var1_1, Branch.access$1100());
                                                            break block25;
                                                        }
                                                        var21_12 = var1_1.getObject();
                                                        if (var21_12 == null) break block25;
                                                        if (Branch.this.isTrackingDisabled()) break block29;
                                                        if (var21_12.has(Defines.Jsonkey.SessionID.getKey())) {
                                                            Branch.access$100(Branch.this).setSessionID(var21_12.getString(Defines.Jsonkey.SessionID.getKey()));
                                                            var22_13 = true;
                                                        } else {
                                                            var22_13 = false;
                                                        }
                                                        if (var21_12.has(Defines.Jsonkey.IdentityID.getKey())) {
                                                            var23_14 = var21_12.getString(Defines.Jsonkey.IdentityID.getKey());
                                                            if (!Branch.access$100(Branch.this).getIdentityID().equals((Object)var23_14)) {
                                                                Branch.access$900(Branch.this).clear();
                                                                Branch.access$100(Branch.this).setIdentityID(var21_12.getString(Defines.Jsonkey.IdentityID.getKey()));
                                                                var22_13 = true;
                                                            }
                                                        }
                                                        if (var21_12.has(Defines.Jsonkey.DeviceFingerprintID.getKey())) {
                                                            Branch.access$100(Branch.this).setDeviceFingerPrintID(var21_12.getString(Defines.Jsonkey.DeviceFingerprintID.getKey()));
                                                        } else {
                                                            var5_4 = var22_13;
                                                        }
                                                        break block30;
                                                    }
                                                    if (var3_2 == 400 || var3_2 == 409) break block31;
                                                    Branch.access$602(Branch.this, false);
                                                    var10_5 = new ArrayList();
                                                    break block32;
                                                }
                                                Branch.access$200(Branch.this).remove(this.thisReq_);
                                                if (this.thisReq_ instanceof ServerRequestCreateUrl) {
                                                    ((ServerRequestCreateUrl)this.thisReq_).handleDuplicateURLError();
                                                } else {
                                                    PrefHelper.LogAlways("Branch API Error: Conflicting resource error code from API");
                                                    Branch.access$700(Branch.this, 0, var3_2);
                                                }
                                            }
lbl64: // 4 sources:
                                            do {
                                                Branch.access$802(Branch.this, 0);
                                                if (Branch.access$600(Branch.this) == false) return;
                                                if (Branch.access$1500(Branch.this) == SESSION_STATE.UNINITIALISED) return;
                                                Branch.access$300(Branch.this);
                                                return;
                                                break;
                                            } while (true);
                                        }
                                        var5_4 = false;
                                    }
                                    if (var5_4) {
                                        Branch.access$1000(Branch.this);
                                    }
                                    if (!(this.thisReq_ instanceof ServerRequestInitSession)) break block33;
                                    Branch.this.setInitState(SESSION_STATE.INITIALISED);
                                    this.thisReq_.onRequestSucceeded(var1_1, Branch.access$1100());
                                    if (!((ServerRequestInitSession)this.thisReq_).handleBranchViewIfAvailable(var1_1)) {
                                        Branch.access$1200(Branch.this);
                                    }
                                    if (Branch.access$1300(Branch.this) != null) {
                                        Branch.access$1300(Branch.this).countDown();
                                    }
                                    if (Branch.access$1400(Branch.this) != null) {
                                        Branch.access$1400(Branch.this).countDown();
                                    }
                                    ** GOTO lbl64
                                }
                                this.thisReq_.onRequestSucceeded(var1_1, Branch.access$1100());
                                ** GOTO lbl64
                            }
                            for (var11_6 = 0; var11_6 < Branch.access$200(Branch.this).getSize(); ++var11_6) {
                                var10_5.add((Object)Branch.access$200(Branch.this).peekAt(var11_6));
                            }
                            for (ServerRequest var16_8 : var10_5) {
                                if (var16_8 != null && var16_8.shouldRetryOnFail()) continue;
                                Branch.access$200(Branch.this).remove(var16_8);
                            }
                            Branch.access$802(Branch.this, 0);
                            var14_9 = var10_5.iterator();
                            do {
                                if (var14_9.hasNext()) ** break;
                                ** continue;
                                var15_10 = (ServerRequest)var14_9.next();
                                if (var15_10 == null) continue;
                                var15_10.handleFailure(var3_2, var1_1.getFailReason());
                                if (!var15_10.shouldRetryOnFail()) continue;
                                var15_10.clearCallbacks();
                            } while (true);
                        }
                        catch (JSONException var2_15) {
                            var2_15.printStackTrace();
                        }
                    }

                    protected void onPreExecute() {
                        super.onPreExecute();
                        this.thisReq_.onPreExecute();
                        this.thisReq_.doFinalUpdateOnMainThread();
                    }
                }.executeTask((Params[])new Void[0]);
                return;
            }
            this.serverSema_.release();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void readAndStripParam(Uri uri, Activity activity) {
        if (enableInstantDeepLinking) {
            boolean bl = this.intentState_ == INTENT_STATE.READY || !this.activityLifeCycleObserver.isCurrentActivityLaunchedFromStack();
            Intent intent = activity != null ? activity.getIntent() : null;
            boolean bl2 = true ^ this.isRestartSessionRequested(intent);
            if (bl && bl2) {
                this.extractSessionParamsForIDL(uri, activity);
            }
        }
        if (bypassCurrentActivityIntentState_) {
            this.intentState_ = INTENT_STATE.READY;
        }
        if (this.intentState_ == INTENT_STATE.READY) {
            this.extractExternalUriAndIntentExtras(uri, activity);
            if (this.extractBranchLinkFromIntentExtra(activity)) {
                return;
            }
            if (!this.isActivityLaunchedFromHistory(activity)) {
                if (this.extractClickID(uri, activity)) {
                    return;
                }
                this.extractAppLink(uri, activity);
            }
        }
    }

    public static void registerPlugin(String string2, String string3) {
        pluginName = string2;
        pluginVersion = string3;
    }

    private boolean requestNeedsSession(ServerRequest serverRequest) {
        if (serverRequest instanceof ServerRequestInitSession) {
            return false;
        }
        return !(serverRequest instanceof ServerRequestCreateUrl);
    }

    public static InitSessionBuilder sessionBuilder(Activity activity) {
        return new Object(activity){
            private BranchReferralInitListener callback;
            private int delay;
            private Boolean ignoreIntent;
            private boolean isReInitializing;
            private Boolean isReferrable;
            private Uri uri;
            {
                Branch branch = Branch.getInstance();
                if (!(activity == null || branch.getCurrentActivity() != null && branch.getCurrentActivity().getLocalClassName().equals((Object)activity.getLocalClassName()))) {
                    branch.currentActivityReference_ = new WeakReference((Object)activity);
                }
            }

            public InitSessionBuilder ignoreIntent(boolean bl) {
                this.ignoreIntent = bl;
                return this;
            }

            public void init() {
                Boolean bl;
                Activity activity;
                Branch branch = Branch.getInstance();
                if (branch == null) {
                    PrefHelper.LogAlways("Branch is not setup properly, make sure to call getAutoInstance in your application class or declare BranchApp in your manifest.");
                    return;
                }
                Boolean bl2 = this.isReferrable;
                if (bl2 != null) {
                    branch.setIsReferrable(bl2);
                }
                if ((bl = this.ignoreIntent) != null) {
                    Branch.bypassWaitingForIntent(bl);
                }
                Intent intent = (activity = branch.getCurrentActivity()) != null ? activity.getIntent() : null;
                Uri uri = this.uri;
                if (uri != null) {
                    branch.readAndStripParam(uri, activity);
                } else if (this.isReInitializing && branch.isRestartSessionRequested(intent)) {
                    Uri uri2 = intent != null ? intent.getData() : null;
                    branch.readAndStripParam(uri2, activity);
                } else if (this.isReInitializing) {
                    return;
                }
                if (branch.isInstantDeepLinkPossible) {
                    branch.isInstantDeepLinkPossible = false;
                    this.callback.onInitFinished(branch.getLatestReferringParams(), null);
                    branch.addExtraInstrumentationData(Defines.Jsonkey.InstantDeepLinkSession.getKey(), "true");
                    branch.checkForAutoDeepLinkConfiguration();
                    this.callback = null;
                }
                if (this.delay > 0) {
                    Branch.expectDelayedSessionInitialization(true);
                }
                branch.initializeSession(this.callback, this.delay);
            }

            public InitSessionBuilder isReferrable(boolean bl) {
                this.isReferrable = bl;
                return this;
            }

            public void reInit() {
                this.isReInitializing = true;
                this.init();
            }

            public InitSessionBuilder withCallback(BranchReferralInitListener branchReferralInitListener) {
                this.callback = branchReferralInitListener;
                return this;
            }

            public InitSessionBuilder withCallback(BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
                this.callback = new BranchUniversalReferralInitWrapper(branchUniversalReferralInitListener);
                return this;
            }

            public InitSessionBuilder withData(Uri uri) {
                this.uri = uri;
                return this;
            }

            public InitSessionBuilder withDelay(int n) {
                this.delay = n;
                return this;
            }
        };
    }

    public static void setAPIUrl(String string2) {
        PrefHelper.setAPIUrl(string2);
    }

    private void setActivityLifeCycleObserver(Application application) {
        try {
            BranchActivityLifecycleObserver branchActivityLifecycleObserver;
            this.activityLifeCycleObserver = branchActivityLifecycleObserver = new BranchActivityLifecycleObserver();
            application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)branchActivityLifecycleObserver);
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.activityLifeCycleObserver);
            isActivityLifeCycleCallbackRegistered_ = true;
            return;
        }
        catch (NoClassDefFoundError | NoSuchMethodError throwable) {
            isActivityLifeCycleCallbackRegistered_ = false;
            isAutoSessionMode_ = false;
            PrefHelper.Debug(new BranchError("", -108).getMessage());
            return;
        }
    }

    public static void setCDNBaseUrl(String string2) {
        PrefHelper.setCDNBaseUrl(string2);
    }

    public static void setPlayStoreReferrerCheckTimeout(long l) {
        boolean bl = l > 0L;
        checkInstallReferrer_ = bl;
        playStoreReferrerWaitTime = l;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean showInstallPrompt(Activity activity, int n) {
        String string2;
        String string4;
        block6 : {
            void var9_12;
            block7 : {
                Branch branch = Branch.getInstance();
                string2 = "";
                if (branch == null) return InstantAppUtil.doShowInstallPrompt(activity, n, string2);
                JSONObject jSONObject = Branch.getInstance().getLatestReferringParams();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.Jsonkey.ReferringLink.getKey());
                String string3 = stringBuilder.toString();
                if (jSONObject == null) return InstantAppUtil.doShowInstallPrompt(activity, n, string2);
                if (!jSONObject.has(string3)) return InstantAppUtil.doShowInstallPrompt(activity, n, string2);
                string4 = jSONObject.getString(string3);
                try {
                    string4 = URLEncoder.encode((String)string4, (String)"UTF-8");
                    break block6;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    break block7;
                }
                catch (JSONException jSONException) {
                    break block7;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                }
                catch (JSONException jSONException) {
                    // empty catch block
                }
                string4 = string2;
            }
            var9_12.printStackTrace();
        }
        if (TextUtils.isEmpty((CharSequence)string4)) return InstantAppUtil.doShowInstallPrompt(activity, n, string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Defines.Jsonkey.IsFullAppConv.getKey());
        stringBuilder2.append("=true&");
        stringBuilder2.append(Defines.Jsonkey.ReferringLink.getKey());
        stringBuilder2.append("=");
        stringBuilder2.append(string4);
        string2 = stringBuilder2.toString();
        return InstantAppUtil.doShowInstallPrompt(activity, n, string2);
    }

    public static boolean showInstallPrompt(Activity activity, int n, BranchUniversalObject branchUniversalObject) {
        String string2 = branchUniversalObject.getShortUrl((Context)activity, new LinkProperties());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Defines.Jsonkey.ReferringLink.getKey());
        stringBuilder.append("=");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            return Branch.showInstallPrompt(activity, n, string3);
        }
        return Branch.showInstallPrompt(activity, n, "");
    }

    public static boolean showInstallPrompt(Activity activity, int n, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Defines.Jsonkey.IsFullAppConv.getKey());
        stringBuilder.append("=true&");
        stringBuilder.append(string2);
        return InstantAppUtil.doShowInstallPrompt(activity, n, stringBuilder.toString());
    }

    static void shutDown() {
        ServerRequestQueue.shutDown();
        PrefHelper.shutDown();
        BranchUtil.shutDown();
        DeviceInfo.shutDown();
        Branch branch = branchReferral_;
        if (branch != null) {
            branch.context_ = null;
            branch.currentActivityReference_ = null;
        }
        branchReferral_ = null;
        bypassCurrentActivityIntentState_ = false;
        enableInstantDeepLinking = false;
        isActivityLifeCycleCallbackRegistered_ = false;
        isAutoSessionMode_ = false;
        bypassWaitingForIntent_ = false;
        isSimulatingInstalls_ = false;
        checkInstallReferrer_ = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateAllRequestsInQueue() {
        try {
            for (int n = 0; n < this.requestQueue_.getSize(); ++n) {
                JSONObject jSONObject;
                ServerRequest serverRequest = this.requestQueue_.peekAt(n);
                if (serverRequest == null || (jSONObject = serverRequest.getPost()) == null) continue;
                if (jSONObject.has(Defines.Jsonkey.SessionID.getKey())) {
                    serverRequest.getPost().put(Defines.Jsonkey.SessionID.getKey(), (Object)this.prefHelper_.getSessionID());
                }
                if (jSONObject.has(Defines.Jsonkey.IdentityID.getKey())) {
                    serverRequest.getPost().put(Defines.Jsonkey.IdentityID.getKey(), (Object)this.prefHelper_.getIdentityID());
                }
                if (!jSONObject.has(Defines.Jsonkey.DeviceFingerprintID.getKey())) continue;
                serverRequest.getPost().put(Defines.Jsonkey.DeviceFingerprintID.getKey(), (Object)this.prefHelper_.getDeviceFingerPrintID());
            }
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    public void addExtraInstrumentationData(String string2, String string3) {
        this.instrumentationExtraData_.put((Object)string2, (Object)string3);
    }

    public void addExtraInstrumentationData(HashMap<String, String> hashMap) {
        this.instrumentationExtraData_.putAll(hashMap);
    }

    public Branch addInstallMetadata(String string2, String string3) {
        this.prefHelper_.addInstallMetadata(string2, string3);
        return this;
    }

    /*
     * Exception decompiling
     */
    public void addModule(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl6 : ALOAD_2 : trying to set 1 previously set to 0
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

    public Branch addUriHostsToSkip(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            UniversalResourceAnalyser.getInstance(this.context_).addToSkipURLFormats(string2);
        }
        return this;
    }

    public Branch addWhiteListedScheme(String string2) {
        if (string2 != null) {
            UniversalResourceAnalyser.getInstance(this.context_).addToAcceptURLFormats(string2);
        }
        return this;
    }

    public void cancelShareLinkDialog(boolean bl) {
        ShareLinkManager shareLinkManager = this.shareLinkManager_;
        if (shareLinkManager != null) {
            shareLinkManager.cancelShareLinkDialog(bl);
        }
    }

    void clearPendingRequests() {
        this.requestQueue_.clear();
    }

    void closeSessionInternal() {
        this.executeClose();
        this.prefHelper_.setExternalIntentUri(null);
        this.trackingController.updateTrackingState(this.context_);
    }

    public void disableAdNetworkCallouts(boolean bl) {
        PrefHelper.getInstance(this.context_).setAdNetworkCalloutsDisabled(bl);
    }

    public void disableAppList() {
    }

    public void disableTracking(boolean bl) {
        this.trackingController.disableTracking(this.context_, bl);
    }

    public void enableFacebookAppLinkCheck() {
        this.enableFacebookAppLinkCheck_ = true;
    }

    String generateShortLinkInternal(ServerRequestCreateUrl serverRequestCreateUrl) {
        if (!serverRequestCreateUrl.constructError_ && !serverRequestCreateUrl.handleErrors(this.context_)) {
            if (this.linkCache_.containsKey((Object)serverRequestCreateUrl.getLinkPost())) {
                String string2 = (String)this.linkCache_.get((Object)serverRequestCreateUrl.getLinkPost());
                serverRequestCreateUrl.onUrlAvailable(string2);
                return string2;
            }
            if (serverRequestCreateUrl.isAsync()) {
                this.generateShortLinkAsync(serverRequestCreateUrl);
            } else {
                return this.generateShortLinkSync(serverRequestCreateUrl);
            }
        }
        return null;
    }

    public Context getApplicationContext() {
        return this.context_;
    }

    public void getCreditHistory(BranchListResponseListener branchListResponseListener) {
        this.getCreditHistory(null, null, 100, CreditHistoryOrder.kMostRecentFirst, branchListResponseListener);
    }

    public void getCreditHistory(String string2, int n, CreditHistoryOrder creditHistoryOrder, BranchListResponseListener branchListResponseListener) {
        this.getCreditHistory(null, string2, n, creditHistoryOrder, branchListResponseListener);
    }

    public void getCreditHistory(String string2, BranchListResponseListener branchListResponseListener) {
        this.getCreditHistory(string2, null, 100, CreditHistoryOrder.kMostRecentFirst, branchListResponseListener);
    }

    public void getCreditHistory(String string2, String string3, int n, CreditHistoryOrder creditHistoryOrder, BranchListResponseListener branchListResponseListener) {
        ServerRequestGetRewardHistory serverRequestGetRewardHistory = new ServerRequestGetRewardHistory(this.context_, string2, string3, n, creditHistoryOrder, branchListResponseListener);
        if (!serverRequestGetRewardHistory.constructError_ && !((ServerRequest)serverRequestGetRewardHistory).handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestGetRewardHistory);
        }
    }

    public int getCredits() {
        return this.prefHelper_.getCreditCount();
    }

    public int getCreditsForBucket(String string2) {
        return this.prefHelper_.getCreditCount(string2);
    }

    public void getCrossPlatformIds(ServerRequestGetCPID.BranchCrossPlatformIdListener branchCrossPlatformIdListener) {
        Context context = this.context_;
        if (context != null) {
            this.handleNewRequest(new ServerRequestGetCPID(context, Defines.RequestPath.GetCPID.getPath(), branchCrossPlatformIdListener));
        }
    }

    Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivityReference_;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public JSONObject getDeeplinkDebugParams() {
        JSONObject jSONObject = this.deeplinkDebugParams_;
        if (jSONObject != null && jSONObject.length() > 0) {
            PrefHelper.Debug("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
        }
        return this.deeplinkDebugParams_;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo_;
    }

    public JSONObject getFirstReferringParams() {
        return this.appendDebugParams(this.convertParamsStringToDictionary(this.prefHelper_.getInstallParams()));
    }

    /*
     * Exception decompiling
     */
    public JSONObject getFirstReferringParamsSync() {
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

    SESSION_STATE getInitState() {
        return this.initState_;
    }

    ServerRequestInitSession getInstallOrOpenRequest(BranchReferralInitListener branchReferralInitListener) {
        if (this.hasUser()) {
            return new ServerRequestRegisterOpen(this.context_, branchReferralInitListener);
        }
        return new ServerRequestRegisterInstall(this.context_, branchReferralInitListener);
    }

    public void getLastAttributedTouchData(ServerRequestGetLATD.BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener) {
        Context context = this.context_;
        if (context != null) {
            this.handleNewRequest(new ServerRequestGetLATD(context, Defines.RequestPath.GetLATD.getPath(), branchLastAttributedTouchDataListener));
        }
    }

    public void getLastAttributedTouchData(ServerRequestGetLATD.BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener, int n) {
        Context context = this.context_;
        if (context != null) {
            this.handleNewRequest(new ServerRequestGetLATD(context, Defines.RequestPath.GetLATD.getPath(), branchLastAttributedTouchDataListener, n));
        }
    }

    public JSONObject getLatestReferringParams() {
        return this.appendDebugParams(this.convertParamsStringToDictionary(this.prefHelper_.getSessionParams()));
    }

    /*
     * Exception decompiling
     */
    public JSONObject getLatestReferringParamsSync() {
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

    PrefHelper getPrefHelper() {
        return this.prefHelper_;
    }

    String getSessionReferredLink() {
        String string2 = this.prefHelper_.getExternalIntentUri();
        if (string2.equals((Object)"bnc_no_value")) {
            string2 = null;
        }
        return string2;
    }

    ShareLinkManager getShareLinkManager() {
        return this.shareLinkManager_;
    }

    public TrackingController getTrackingController() {
        return this.trackingController;
    }

    public void handleNewRequest(ServerRequest serverRequest) {
        if (this.trackingController.isTrackingDisabled() && !serverRequest.prepareExecuteWithoutTracking()) {
            serverRequest.reportTrackingDisabledError();
            return;
        }
        if (this.initState_ != SESSION_STATE.INITIALISED && !(serverRequest instanceof ServerRequestInitSession)) {
            if (serverRequest instanceof ServerRequestLogout) {
                serverRequest.handleFailure(-101, "");
                PrefHelper.Debug("Branch is not initialized, cannot logout");
                return;
            }
            if (serverRequest instanceof ServerRequestRegisterClose) {
                PrefHelper.Debug("Branch is not initialized, cannot close session");
                return;
            }
            if (this.requestNeedsSession(serverRequest)) {
                serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.SDK_INIT_WAIT_LOCK);
            }
        }
        if (!(serverRequest instanceof ServerRequestPing)) {
            this.requestQueue_.enqueue(serverRequest);
            serverRequest.onRequestQueued();
        }
        this.processNextQueueItem();
    }

    public boolean initSession() {
        Branch.sessionBuilder(null).init();
        return true;
    }

    public boolean initSession(Activity activity) {
        Branch.sessionBuilder(activity).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener) {
        Branch.sessionBuilder(null).withCallback(branchReferralInitListener).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchReferralInitListener).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, Uri uri) {
        Branch.sessionBuilder(null).withCallback(branchReferralInitListener).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, Uri uri, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchReferralInitListener).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, boolean bl) {
        Branch.sessionBuilder(null).withCallback(branchReferralInitListener).isReferrable(bl).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, boolean bl, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchReferralInitListener).isReferrable(bl).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, boolean bl, Uri uri) {
        Branch.sessionBuilder(null).withCallback(branchReferralInitListener).isReferrable(bl).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchReferralInitListener branchReferralInitListener, boolean bl, Uri uri, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchReferralInitListener).isReferrable(bl).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
        Branch.sessionBuilder(null).withCallback(branchUniversalReferralInitListener).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchUniversalReferralInitListener).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, Uri uri) {
        Branch.sessionBuilder(null).withCallback(branchUniversalReferralInitListener).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, Uri uri, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchUniversalReferralInitListener).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, boolean bl) {
        Branch.sessionBuilder(null).withCallback(branchUniversalReferralInitListener).isReferrable(bl).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, boolean bl, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchUniversalReferralInitListener).isReferrable(bl).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, boolean bl, Uri uri) {
        Branch.sessionBuilder(null).withCallback(branchUniversalReferralInitListener).isReferrable(bl).withData(uri).init();
        return true;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchUniversalReferralInitListener, boolean bl, Uri uri, Activity activity) {
        Branch.sessionBuilder(activity).withCallback(branchUniversalReferralInitListener).isReferrable(bl).withData(uri).init();
        return true;
    }

    public boolean initSession(boolean bl) {
        Branch.sessionBuilder(null).isReferrable(bl).init();
        return true;
    }

    public boolean initSession(boolean bl, Activity activity) {
        Branch.sessionBuilder(activity).isReferrable(bl).init();
        return true;
    }

    public boolean initSessionForced(BranchReferralInitListener branchReferralInitListener) {
        Branch.sessionBuilder(null).ignoreIntent(true).withCallback(branchReferralInitListener).init();
        return true;
    }

    public boolean initSessionWithData(Uri uri) {
        Branch.sessionBuilder(null).withData(uri).init();
        return true;
    }

    public boolean initSessionWithData(Uri uri, Activity activity) {
        Branch.sessionBuilder(activity).withData(uri).init();
        return true;
    }

    boolean isGAParamsFetchInProgress() {
        return this.isGAParamsFetchInProgress_;
    }

    boolean isIDLSession() {
        return Boolean.parseBoolean((String)((String)this.instrumentationExtraData_.get((Object)Defines.Jsonkey.InstantDeepLinkSession.getKey())));
    }

    public boolean isInstantDeepLinkPossible() {
        return this.isInstantDeepLinkPossible;
    }

    boolean isReferrable() {
        return this.prefHelper_.getIsReferrable() == 1;
    }

    boolean isRestartSessionRequested(Intent intent) {
        return this.checkIntentForSessionRestart(intent) || this.checkIntentForUnusedBranchLink(intent);
        {
        }
    }

    public boolean isTrackingDisabled() {
        return this.trackingController.isTrackingDisabled();
    }

    public boolean isUserIdentified() {
        return true ^ this.prefHelper_.getIdentity().equals((Object)"bnc_no_value");
    }

    public void loadRewards() {
        this.loadRewards(null);
    }

    public void loadRewards(BranchReferralStateChangedListener branchReferralStateChangedListener) {
        ServerRequestGetRewards serverRequestGetRewards = new ServerRequestGetRewards(this.context_, branchReferralStateChangedListener);
        if (!serverRequestGetRewards.constructError_ && !((ServerRequest)serverRequestGetRewards).handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestGetRewards);
        }
    }

    public void logout() {
        this.logout(null);
    }

    public void logout(LogoutStatusListener logoutStatusListener) {
        ServerRequestLogout serverRequestLogout = new ServerRequestLogout(this.context_, logoutStatusListener);
        if (!serverRequestLogout.constructError_ && !((ServerRequest)serverRequestLogout).handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestLogout);
        }
    }

    public void notifyNetworkAvailable() {
        this.handleNewRequest(new ServerRequestPing(this.context_));
    }

    @Override
    public void onAdsParamsFetchFinished() {
        this.isGAParamsFetchInProgress_ = false;
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
        if (this.performCookieBasedStrongMatchingOnGAIDAvailable) {
            this.performCookieBasedStrongMatch();
            this.performCookieBasedStrongMatchingOnGAIDAvailable = false;
            return;
        }
        this.processNextQueueItem();
    }

    @Override
    public void onBranchViewAccepted(String string2, String string3) {
        if (ServerRequestInitSession.isInitSessionAction(string2)) {
            this.checkForAutoDeepLinkConfiguration();
        }
    }

    @Override
    public void onBranchViewCancelled(String string2, String string3) {
        if (ServerRequestInitSession.isInitSessionAction(string2)) {
            this.checkForAutoDeepLinkConfiguration();
        }
    }

    @Override
    public void onBranchViewError(int n, String string2, String string3) {
        if (ServerRequestInitSession.isInitSessionAction(string3)) {
            this.checkForAutoDeepLinkConfiguration();
        }
    }

    @Override
    public void onBranchViewVisible(String string2, String string3) {
    }

    @Override
    public void onInstallReferrerEventsFinished() {
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        this.processNextQueueItem();
    }

    void onIntentReady(Activity activity) {
        this.setIntentState(INTENT_STATE.READY);
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
        boolean bl = activity.getIntent() != null && this.getInitState() != SESSION_STATE.INITIALISED;
        if (bl) {
            this.readAndStripParam(activity.getIntent().getData(), activity);
            if (!this.isTrackingDisabled() && cookieBasedMatchDomain_ != null && this.prefHelper_.getBranchKey() != null && !this.prefHelper_.getBranchKey().equalsIgnoreCase("bnc_no_value")) {
                if (this.isGAParamsFetchInProgress_) {
                    this.performCookieBasedStrongMatchingOnGAIDAvailable = true;
                } else {
                    this.performCookieBasedStrongMatch();
                }
            }
        }
        this.processNextQueueItem();
    }

    public boolean reInitSession(Activity activity, BranchReferralInitListener branchReferralInitListener) {
        Branch.sessionBuilder(activity).withCallback(branchReferralInitListener).reInit();
        return activity == null || activity.getIntent() == null;
        {
        }
    }

    public boolean reInitSession(Activity activity, BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
        Branch.sessionBuilder(activity).withCallback(branchUniversalReferralInitListener).reInit();
        return activity == null || activity.getIntent() == null;
        {
        }
    }

    public void redeemRewards(int n) {
        this.redeemRewards(Defines.Jsonkey.DefaultBucket.getKey(), n, null);
    }

    public void redeemRewards(int n, BranchReferralStateChangedListener branchReferralStateChangedListener) {
        this.redeemRewards(Defines.Jsonkey.DefaultBucket.getKey(), n, branchReferralStateChangedListener);
    }

    public void redeemRewards(String string2, int n) {
        this.redeemRewards(string2, n, null);
    }

    public void redeemRewards(String string2, int n, BranchReferralStateChangedListener branchReferralStateChangedListener) {
        ServerRequestRedeemRewards serverRequestRedeemRewards = new ServerRequestRedeemRewards(this.context_, string2, n, branchReferralStateChangedListener);
        if (!serverRequestRedeemRewards.constructError_ && !serverRequestRedeemRewards.handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestRedeemRewards);
        }
    }

    void registerAppInit(ServerRequestInitSession serverRequestInitSession, boolean bl) {
        this.setInitState(SESSION_STATE.INITIALISING);
        if (!bl) {
            if (this.intentState_ != INTENT_STATE.READY && Branch.isWaitingForIntent()) {
                serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
            }
            if (checkInstallReferrer_ && serverRequestInitSession instanceof ServerRequestRegisterInstall && !GooglePlayStoreAttribution.hasBeenUsed) {
                serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
                new GooglePlayStoreAttribution().captureInstallReferrer(this.context_, playStoreReferrerWaitTime, this);
                if (GooglePlayStoreAttribution.erroredOut) {
                    serverRequestInitSession.removeProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
                }
            }
        }
        if (this.isGAParamsFetchInProgress_) {
            serverRequestInitSession.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
        }
        if (!this.requestQueue_.containsInitRequest()) {
            this.insertRequestAtFront(serverRequestInitSession);
            this.processNextQueueItem();
            return;
        }
        PrefHelper.Debug("Warning! Attempted to queue multiple init session requests");
    }

    public void registerView(BranchUniversalObject branchUniversalObject, BranchUniversalObject.RegisterViewStatusListener registerViewStatusListener) {
        if (this.context_ != null) {
            new BranchEvent(BRANCH_STANDARD_EVENT.VIEW_ITEM).addContentItems(branchUniversalObject).logEvent(this.context_);
        }
    }

    public void removeSessionInitializationDelay() {
        this.requestQueue_.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.USER_SET_WAIT_LOCK);
        this.processNextQueueItem();
    }

    public void resetUserSession() {
        this.setInitState(SESSION_STATE.UNINITIALISED);
    }

    public void sendCommerceEvent(CommerceEvent commerceEvent) {
        this.sendCommerceEvent(commerceEvent, null, null);
    }

    public void sendCommerceEvent(CommerceEvent commerceEvent, JSONObject jSONObject, BranchViewHandler.IBranchViewEvents iBranchViewEvents) {
        ServerRequestActionCompleted serverRequestActionCompleted = new ServerRequestActionCompleted(this.context_, BRANCH_STANDARD_EVENT.PURCHASE.getName(), commerceEvent, jSONObject, iBranchViewEvents);
        if (!serverRequestActionCompleted.constructError_ && !((ServerRequest)serverRequestActionCompleted).handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestActionCompleted);
        }
    }

    public void setBranchRemoteInterface(BranchRemoteInterface branchRemoteInterface) {
        this.branchRemoteInterface_ = branchRemoteInterface;
    }

    public void setDebug() {
        PrefHelper.LogAlways("setDebug is deprecated and all functionality has been disabled. If you wish to enable logging, please invoke enableLogging. If you wish to simulate installs, please see add a Test Device (https://help.branch.io/using-branch/docs/adding-test-devices) then reset your test device's data (https://help.branch.io/using-branch/docs/adding-test-devices#section-resetting-your-test-device-data). If you wish to use the test key rather than the live key, please invoke enableTestMode.");
    }

    public void setDeepLinkDebugMode(JSONObject jSONObject) {
        this.deeplinkDebugParams_ = jSONObject;
    }

    void setGAParamsFetchInProgress(boolean bl) {
        this.isGAParamsFetchInProgress_ = bl;
    }

    public void setIdentity(String string2) {
        this.setIdentity(string2, null);
    }

    public void setIdentity(String string2, BranchReferralInitListener branchReferralInitListener) {
        ServerRequestIdentifyUserRequest serverRequestIdentifyUserRequest = new ServerRequestIdentifyUserRequest(this.context_, branchReferralInitListener, string2);
        if (!serverRequestIdentifyUserRequest.constructError_ && !serverRequestIdentifyUserRequest.handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestIdentifyUserRequest);
            return;
        }
        if (serverRequestIdentifyUserRequest.isExistingID()) {
            serverRequestIdentifyUserRequest.handleUserExist(branchReferral_);
        }
    }

    void setInitState(SESSION_STATE sESSION_STATE) {
        this.initState_ = sESSION_STATE;
    }

    public void setInstantDeepLinkPossible(boolean bl) {
        this.isInstantDeepLinkPossible = bl;
    }

    void setIntentState(INTENT_STATE iNTENT_STATE) {
        this.intentState_ = iNTENT_STATE;
    }

    void setIsReferrable(boolean bl) {
        if (bl) {
            this.prefHelper_.setIsReferrable();
            return;
        }
        this.prefHelper_.clearIsReferrable();
    }

    public void setLimitFacebookTracking(boolean bl) {
        this.prefHelper_.setLimitFacebookTracking(bl);
    }

    public void setNetworkTimeout(int n) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper != null && n > 0) {
            prefHelper.setTimeout(n);
        }
    }

    public Branch setPreinstallCampaign(String string2) {
        this.addInstallMetadata(Defines.PreinstallKey.campaign.getKey(), string2);
        return this;
    }

    public Branch setPreinstallPartner(String string2) {
        this.addInstallMetadata(Defines.PreinstallKey.partner.getKey(), string2);
        return this;
    }

    public void setRequestMetadata(String string2, String string3) {
        this.prefHelper_.setRequestMetadata(string2, string3);
    }

    public void setRetryCount(int n) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper != null && n >= 0) {
            prefHelper.setRetryCount(n);
        }
    }

    public void setRetryInterval(int n) {
        PrefHelper prefHelper = this.prefHelper_;
        if (prefHelper != null && n > 0) {
            prefHelper.setRetryInterval(n);
        }
    }

    public Branch setWhiteListedSchemes(List<String> list) {
        if (list != null) {
            UniversalResourceAnalyser.getInstance(this.context_).addToAcceptURLFormats(list);
        }
        return this;
    }

    void shareLink(BranchShareSheetBuilder branchShareSheetBuilder) {
        ShareLinkManager shareLinkManager;
        ShareLinkManager shareLinkManager2 = this.shareLinkManager_;
        if (shareLinkManager2 != null) {
            shareLinkManager2.cancelShareLinkDialog(true);
        }
        this.shareLinkManager_ = shareLinkManager = new ShareLinkManager();
        shareLinkManager.shareLink(branchShareSheetBuilder);
    }

    void unlockSDKInitWaitLock() {
        ServerRequestQueue serverRequestQueue = this.requestQueue_;
        if (serverRequestQueue == null) {
            return;
        }
        serverRequestQueue.unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK.SDK_INIT_WAIT_LOCK);
        this.processNextQueueItem();
    }

    void updateSkipURLFormats() {
        UniversalResourceAnalyser.getInstance(this.context_).checkAndUpdateSkipURLFormats(this.context_);
    }

    public void userCompletedAction(String string2) {
        this.userCompletedAction(string2, null, null);
    }

    public void userCompletedAction(String string2, BranchViewHandler.IBranchViewEvents iBranchViewEvents) {
        this.userCompletedAction(string2, null, iBranchViewEvents);
    }

    public void userCompletedAction(String string2, JSONObject jSONObject) {
        this.userCompletedAction(string2, jSONObject, null);
    }

    public void userCompletedAction(String string2, JSONObject jSONObject, BranchViewHandler.IBranchViewEvents iBranchViewEvents) {
        ServerRequestActionCompleted serverRequestActionCompleted = new ServerRequestActionCompleted(this.context_, string2, null, jSONObject, iBranchViewEvents);
        if (!serverRequestActionCompleted.constructError_ && !((ServerRequest)serverRequestActionCompleted).handleErrors(this.context_)) {
            this.handleNewRequest(serverRequestActionCompleted);
        }
    }

}

