/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.URLUtil
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PrefHelper {
    static final String BRANCH_BASE_URL_V1 = "https://api.branch.io/";
    static final String BRANCH_BASE_URL_V2 = "https://api2.branch.io/";
    static final String BRANCH_CDN_BASE_URL = "https://cdn.branch.io/";
    private static String Branch_Key;
    private static final int INTERVAL_RETRY = 1000;
    private static final String KEY_ACTIONS = "bnc_actions";
    static final String KEY_AD_NETWORK_CALLOUTS_DISABLED = "bnc_ad_network_callouts_disabled";
    private static final String KEY_APP_LINK = "bnc_app_link";
    private static final String KEY_APP_VERSION = "bnc_app_version";
    private static final String KEY_BRANCH_KEY = "bnc_branch_key";
    private static final String KEY_BRANCH_VIEW_NUM_OF_USE = "bnc_branch_view_use";
    private static final String KEY_BUCKETS = "bnc_buckets";
    private static final String KEY_CREDIT_BASE = "bnc_credit_base_";
    private static final String KEY_DEVICE_FINGERPRINT_ID = "bnc_device_fingerprint_id";
    private static final String KEY_EXTERNAL_INTENT_EXTRA = "bnc_external_intent_extra";
    private static final String KEY_EXTERNAL_INTENT_URI = "bnc_external_intent_uri";
    private static final String KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA = "bnc_google_play_install_referrer_extras";
    private static final String KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER = "bnc_google_search_install_identifier";
    private static final String KEY_IDENTITY = "bnc_identity";
    private static final String KEY_IDENTITY_ID = "bnc_identity_id";
    static final String KEY_INSTALL_BEGIN_TS = "bnc_install_begin_ts";
    private static final String KEY_INSTALL_PARAMS = "bnc_install_params";
    private static final String KEY_INSTALL_REFERRER = "bnc_install_referrer";
    private static final String KEY_IS_FULL_APP_CONVERSION = "bnc_is_full_app_conversion";
    private static final String KEY_IS_REFERRABLE = "bnc_is_referrable";
    private static final String KEY_IS_TRIGGERED_BY_FB_APP_LINK = "bnc_triggered_by_fb_app_link";
    static final String KEY_LAST_KNOWN_UPDATE_TIME = "bnc_last_known_update_time";
    private static final String KEY_LAST_READ_SYSTEM = "bnc_system_read_date";
    private static final String KEY_LAST_STRONG_MATCH_TIME = "bnc_branch_strong_match_time";
    private static final String KEY_LATD_ATTRIBUTION_WINDOW = "bnc_latd_attributon_window";
    private static final String KEY_LIMIT_FACEBOOK_TRACKING = "bnc_limit_facebook_tracking";
    private static final String KEY_LINK_CLICK_ID = "bnc_link_click_id";
    private static final String KEY_LINK_CLICK_IDENTIFIER = "bnc_link_click_identifier";
    static final String KEY_ORIGINAL_INSTALL_TIME = "bnc_original_install_time";
    static final String KEY_PREVIOUS_UPDATE_TIME = "bnc_previous_update_time";
    private static final String KEY_PUSH_IDENTIFIER = "bnc_push_identifier";
    static final String KEY_REFERRER_CLICK_TS = "bnc_referrer_click_ts";
    private static final String KEY_RETRY_COUNT = "bnc_retry_count";
    private static final String KEY_RETRY_INTERVAL = "bnc_retry_interval";
    private static final String KEY_SESSION_ID = "bnc_session_id";
    private static final String KEY_SESSION_PARAMS = "bnc_session_params";
    private static final String KEY_TIMEOUT = "bnc_timeout";
    private static final String KEY_TOTAL_BASE = "bnc_total_base_";
    static final String KEY_TRACKING_STATE = "bnc_tracking_state";
    private static final String KEY_UNIQUE_BASE = "bnc_balance_base_";
    private static final String KEY_USER_URL = "bnc_user_url";
    private static final int MAX_RETRIES = 3;
    public static final String NO_STRING_VALUE = "bnc_no_value";
    private static final String SHARED_PREF_FILE = "branch_referral_shared_pref";
    private static final String TAG = "BranchSDK";
    private static final int TIMEOUT = 5500;
    private static String customCDNBaseURL_;
    private static String customServerURL_;
    private static boolean enableLogging_;
    private static PrefHelper prefHelper_;
    private static JSONObject savedAnalyticsData_;
    private SharedPreferences appSharedPrefs_;
    private final JSONObject installMetadata;
    private SharedPreferences.Editor prefsEditor_;
    private final JSONObject requestMetadata;
    private final JSONObject secondaryRequestMetadata;

    private PrefHelper(Context context) {
        SharedPreferences sharedPreferences;
        this.appSharedPrefs_ = sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, 0);
        this.prefsEditor_ = sharedPreferences.edit();
        this.requestMetadata = new JSONObject();
        this.installMetadata = new JSONObject();
        this.secondaryRequestMetadata = new JSONObject();
    }

    public static void Debug(String string2) {
        if (enableLogging_ && !TextUtils.isEmpty((CharSequence)string2)) {
            Log.i((String)TAG, (String)string2);
        }
    }

    public static void LogAlways(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            Log.i((String)TAG, (String)string2);
        }
    }

    public static void LogException(String string2, Throwable throwable) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            Log.e((String)TAG, (String)string2, (Throwable)throwable);
        }
    }

    private void clearPrefOnBranchKeyChange() {
        String string2 = this.getLinkClickID();
        String string3 = this.getLinkClickIdentifier();
        String string4 = this.getAppLink();
        String string5 = this.getPushIdentifier();
        this.prefsEditor_.clear();
        this.setLinkClickID(string2);
        this.setLinkClickIdentifier(string3);
        this.setAppLink(string4);
        this.setPushIdentifier(string5);
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    private ArrayList<String> deserializeString(String string2) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll((Collection)arrayList, (Object[])string2.split(","));
        return arrayList;
    }

    static void enableLogging(boolean bl) {
        enableLogging_ = bl;
    }

    private ArrayList<String> getActions() {
        String string2 = this.getString(KEY_ACTIONS);
        if (string2.equals((Object)NO_STRING_VALUE)) {
            return new ArrayList();
        }
        return this.deserializeString(string2);
    }

    private ArrayList<String> getBuckets() {
        String string2 = this.getString(KEY_BUCKETS);
        if (string2.equals((Object)NO_STRING_VALUE)) {
            return new ArrayList();
        }
        return this.deserializeString(string2);
    }

    static String getCDNBaseUrl() {
        if (!TextUtils.isEmpty((CharSequence)customCDNBaseURL_)) {
            return customCDNBaseURL_;
        }
        return BRANCH_CDN_BASE_URL;
    }

    public static PrefHelper getInstance(Context context) {
        if (prefHelper_ == null) {
            prefHelper_ = new PrefHelper(context);
        }
        return prefHelper_;
    }

    private String serializeArrayList(ArrayList<String> arrayList) {
        Iterator iterator = arrayList.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            stringBuilder.append(",");
            string2 = stringBuilder.toString();
        }
        return string2.substring(0, -1 + string2.length());
    }

    static void setAPIUrl(String string2) {
        customServerURL_ = string2;
    }

    private void setActions(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            this.setString(KEY_ACTIONS, NO_STRING_VALUE);
            return;
        }
        this.setString(KEY_ACTIONS, this.serializeArrayList(arrayList));
    }

    private void setBuckets(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            this.setString(KEY_BUCKETS, NO_STRING_VALUE);
            return;
        }
        this.setString(KEY_BUCKETS, this.serializeArrayList(arrayList));
    }

    static void setCDNBaseUrl(String string2) {
        customCDNBaseURL_ = string2;
    }

    static void shutDown() {
        PrefHelper prefHelper = prefHelper_;
        if (prefHelper != null) {
            prefHelper.prefsEditor_ = null;
        }
        enableLogging_ = false;
        Branch_Key = null;
        savedAnalyticsData_ = null;
        prefHelper_ = null;
        customServerURL_ = null;
        customCDNBaseURL_ = null;
    }

    void addInstallMetadata(String string2, String string3) {
        if (string2 == null) {
            return;
        }
        try {
            this.installMetadata.putOpt(string2, (Object)string3);
        }
        catch (JSONException jSONException) {}
    }

    void addSecondaryRequestMetadata(String string2, String string3) {
        if (string2 == null) {
            return;
        }
        try {
            this.secondaryRequestMetadata.putOpt(string2, (Object)string3);
        }
        catch (JSONException jSONException) {}
    }

    public void clearIsReferrable() {
        this.setInteger(KEY_IS_REFERRABLE, 0);
    }

    public void clearSystemReadStatus() {
        this.setLong(KEY_LAST_READ_SYSTEM, Calendar.getInstance().getTimeInMillis() / 1000L);
    }

    public void clearUserValues() {
        Iterator iterator = this.getBuckets().iterator();
        while (iterator.hasNext()) {
            this.setCreditCount((String)iterator.next(), 0);
        }
        this.setBuckets((ArrayList<String>)new ArrayList());
        for (String string2 : this.getActions()) {
            this.setActionTotalCount(string2, 0);
            this.setActionUniqueCount(string2, 0);
        }
        this.setActions((ArrayList<String>)new ArrayList());
    }

    public String getAPIBaseUrl() {
        if (URLUtil.isHttpsUrl((String)customServerURL_)) {
            return customServerURL_;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            return BRANCH_BASE_URL_V2;
        }
        return BRANCH_BASE_URL_V1;
    }

    public int getActionTotalCount(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_TOTAL_BASE);
        stringBuilder.append(string2);
        return this.getInteger(stringBuilder.toString());
    }

    public int getActionUniqueCount(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_UNIQUE_BASE);
        stringBuilder.append(string2);
        return this.getInteger(stringBuilder.toString());
    }

    public boolean getAdNetworkCalloutsDisabled() {
        return this.getBool(KEY_AD_NETWORK_CALLOUTS_DISABLED);
    }

    public String getAppLink() {
        return this.getString(KEY_APP_LINK);
    }

    public String getAppVersion() {
        return this.getString(KEY_APP_VERSION);
    }

    public boolean getBool(String string2) {
        return PrefHelper.prefHelper_.appSharedPrefs_.getBoolean(string2, false);
    }

    public String getBranchKey() {
        if (Branch_Key == null) {
            Branch_Key = this.getString(KEY_BRANCH_KEY);
        }
        return Branch_Key;
    }

    public int getBranchViewUsageCount(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bnc_branch_view_use_");
        stringBuilder.append(string2);
        return this.getInteger(stringBuilder.toString(), 0);
    }

    public int getCreditCount() {
        return this.getCreditCount(Defines.Jsonkey.DefaultBucket.getKey());
    }

    public int getCreditCount(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_CREDIT_BASE);
        stringBuilder.append(string2);
        return this.getInteger(stringBuilder.toString());
    }

    public String getDeviceFingerPrintID() {
        return this.getString(KEY_DEVICE_FINGERPRINT_ID);
    }

    public String getExternalIntentExtra() {
        return this.getString(KEY_EXTERNAL_INTENT_EXTRA);
    }

    public String getExternalIntentUri() {
        return this.getString(KEY_EXTERNAL_INTENT_URI);
    }

    public float getFloat(String string2) {
        return PrefHelper.prefHelper_.appSharedPrefs_.getFloat(string2, 0.0f);
    }

    public String getGooglePlayReferrer() {
        return this.getString(KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA);
    }

    public String getGoogleSearchInstallIdentifier() {
        return this.getString(KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER);
    }

    public String getIdentity() {
        return this.getString(KEY_IDENTITY);
    }

    public String getIdentityID() {
        return this.getString(KEY_IDENTITY_ID);
    }

    String getInstallMetaData(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            String string3 = this.installMetadata.get(string2).toString();
            return string3;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public JSONObject getInstallMetadata() {
        return this.installMetadata;
    }

    public String getInstallParams() {
        return this.getString(KEY_INSTALL_PARAMS);
    }

    public String getInstallReferrerParams() {
        return this.getString(KEY_INSTALL_REFERRER);
    }

    public int getInteger(String string2) {
        return this.getInteger(string2, 0);
    }

    public int getInteger(String string2, int n) {
        return PrefHelper.prefHelper_.appSharedPrefs_.getInt(string2, n);
    }

    public boolean getIsAppLinkTriggeredInit() {
        return this.getBool(KEY_IS_TRIGGERED_BY_FB_APP_LINK);
    }

    public int getIsReferrable() {
        return this.getInteger(KEY_IS_REFERRABLE);
    }

    public int getLATDAttributionWindow() {
        return this.getInteger(KEY_LATD_ATTRIBUTION_WINDOW, -1);
    }

    public long getLastStrongMatchTime() {
        return this.getLong(KEY_LAST_STRONG_MATCH_TIME);
    }

    public String getLinkClickID() {
        return this.getString(KEY_LINK_CLICK_ID);
    }

    public String getLinkClickIdentifier() {
        return this.getString(KEY_LINK_CLICK_IDENTIFIER);
    }

    public long getLong(String string2) {
        return PrefHelper.prefHelper_.appSharedPrefs_.getLong(string2, 0L);
    }

    public String getPushIdentifier() {
        return this.getString(KEY_PUSH_IDENTIFIER);
    }

    public JSONObject getRequestMetadata() {
        return this.requestMetadata;
    }

    public int getRetryCount() {
        return this.getInteger(KEY_RETRY_COUNT, 3);
    }

    public int getRetryInterval() {
        return this.getInteger(KEY_RETRY_INTERVAL, 1000);
    }

    String getSecondaryRequestMetaData(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            String string3 = this.secondaryRequestMetadata.get(string2).toString();
            return string3;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public String getSessionID() {
        return this.getString(KEY_SESSION_ID);
    }

    public String getSessionParams() {
        return this.getString(KEY_SESSION_PARAMS);
    }

    public String getString(String string2) {
        return PrefHelper.prefHelper_.appSharedPrefs_.getString(string2, NO_STRING_VALUE);
    }

    public int getTimeout() {
        return this.getInteger(KEY_TIMEOUT, 5500);
    }

    public String getUserURL() {
        return this.getString(KEY_USER_URL);
    }

    public boolean hasPrefValue(String string2) {
        return PrefHelper.prefHelper_.appSharedPrefs_.contains(string2);
    }

    boolean hasValidBranchKey() {
        return this.isValidBranchKey(this.getBranchKey());
    }

    boolean isAppTrackingLimited() {
        return this.getBool(KEY_LIMIT_FACEBOOK_TRACKING);
    }

    public boolean isFullAppConversion() {
        return this.getBool(KEY_IS_FULL_APP_CONVERSION);
    }

    boolean isValidBranchKey(String string2) {
        String string3;
        return string2 != null && string2.startsWith(string3 = BranchUtil.isTestModeEnabled() ? "key_test_" : "key_");
    }

    public void removePrefValue(String string2) {
        PrefHelper.prefHelper_.prefsEditor_.remove(string2).apply();
    }

    public void saveLastStrongMatchTime(long l) {
        this.setLong(KEY_LAST_STRONG_MATCH_TIME, l);
    }

    public void setActionTotalCount(String string2, int n) {
        ArrayList<String> arrayList = this.getActions();
        if (!arrayList.contains((Object)string2)) {
            arrayList.add((Object)string2);
            this.setActions(arrayList);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_TOTAL_BASE);
        stringBuilder.append(string2);
        this.setInteger(stringBuilder.toString(), n);
    }

    public void setActionUniqueCount(String string2, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_UNIQUE_BASE);
        stringBuilder.append(string2);
        this.setInteger(stringBuilder.toString(), n);
    }

    public void setAdNetworkCalloutsDisabled(boolean bl) {
        this.setBool(KEY_AD_NETWORK_CALLOUTS_DISABLED, bl);
    }

    public void setAppLink(String string2) {
        this.setString(KEY_APP_LINK, string2);
    }

    public void setAppVersion(String string2) {
        this.setString(KEY_APP_VERSION, string2);
    }

    public void setBool(String string2, Boolean bl) {
        PrefHelper.prefHelper_.prefsEditor_.putBoolean(string2, bl.booleanValue());
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    public boolean setBranchKey(String string2) {
        Branch_Key = string2;
        if (!this.getString(KEY_BRANCH_KEY).equals((Object)string2)) {
            this.clearPrefOnBranchKeyChange();
            this.setString(KEY_BRANCH_KEY, string2);
            return true;
        }
        return false;
    }

    public void setCreditCount(int n) {
        this.setCreditCount(Defines.Jsonkey.DefaultBucket.getKey(), n);
    }

    public void setCreditCount(String string2, int n) {
        ArrayList<String> arrayList = this.getBuckets();
        if (!arrayList.contains((Object)string2)) {
            arrayList.add((Object)string2);
            this.setBuckets(arrayList);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(KEY_CREDIT_BASE);
        stringBuilder.append(string2);
        this.setInteger(stringBuilder.toString(), n);
    }

    public void setDeviceFingerPrintID(String string2) {
        this.setString(KEY_DEVICE_FINGERPRINT_ID, string2);
    }

    public void setExternalIntentExtra(String string2) {
        this.setString(KEY_EXTERNAL_INTENT_EXTRA, string2);
    }

    public void setExternalIntentUri(String string2) {
        this.setString(KEY_EXTERNAL_INTENT_URI, string2);
    }

    public void setFloat(String string2, float f) {
        PrefHelper.prefHelper_.prefsEditor_.putFloat(string2, f);
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    public void setGooglePlayReferrer(String string2) {
        this.setString(KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA, string2);
    }

    public void setGoogleSearchInstallIdentifier(String string2) {
        this.setString(KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER, string2);
    }

    public void setIdentity(String string2) {
        this.setString(KEY_IDENTITY, string2);
    }

    public void setIdentityID(String string2) {
        this.setString(KEY_IDENTITY_ID, string2);
    }

    public void setInstallParams(String string2) {
        this.setString(KEY_INSTALL_PARAMS, string2);
    }

    public void setInstallReferrerParams(String string2) {
        this.setString(KEY_INSTALL_REFERRER, string2);
    }

    public void setInteger(String string2, int n) {
        PrefHelper.prefHelper_.prefsEditor_.putInt(string2, n);
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    public void setIsAppLinkTriggeredInit(Boolean bl) {
        this.setBool(KEY_IS_TRIGGERED_BY_FB_APP_LINK, bl);
    }

    public void setIsFullAppConversion(boolean bl) {
        this.setBool(KEY_IS_FULL_APP_CONVERSION, bl);
    }

    public void setIsReferrable() {
        this.setInteger(KEY_IS_REFERRABLE, 1);
    }

    public void setLATDAttributionWindow(int n) {
        this.setInteger(KEY_LATD_ATTRIBUTION_WINDOW, n);
    }

    void setLimitFacebookTracking(boolean bl) {
        this.setBool(KEY_LIMIT_FACEBOOK_TRACKING, bl);
    }

    public void setLinkClickID(String string2) {
        this.setString(KEY_LINK_CLICK_ID, string2);
    }

    public void setLinkClickIdentifier(String string2) {
        this.setString(KEY_LINK_CLICK_IDENTIFIER, string2);
    }

    public void setLong(String string2, long l) {
        PrefHelper.prefHelper_.prefsEditor_.putLong(string2, l);
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    public void setPushIdentifier(String string2) {
        this.setString(KEY_PUSH_IDENTIFIER, string2);
    }

    public void setRequestMetadata(String string2, String string3) {
        if (string2 == null) {
            return;
        }
        if (this.requestMetadata.has(string2) && string3 == null) {
            this.requestMetadata.remove(string2);
        }
        try {
            this.requestMetadata.put(string2, (Object)string3);
        }
        catch (JSONException jSONException) {}
    }

    public void setRetryCount(int n) {
        this.setInteger(KEY_RETRY_COUNT, n);
    }

    public void setRetryInterval(int n) {
        this.setInteger(KEY_RETRY_INTERVAL, n);
    }

    public void setSessionID(String string2) {
        this.setString(KEY_SESSION_ID, string2);
    }

    public void setSessionParams(String string2) {
        this.setString(KEY_SESSION_PARAMS, string2);
    }

    public void setString(String string2, String string3) {
        PrefHelper.prefHelper_.prefsEditor_.putString(string2, string3);
        PrefHelper.prefHelper_.prefsEditor_.apply();
    }

    public void setTimeout(int n) {
        this.setInteger(KEY_TIMEOUT, n);
    }

    public void setUserURL(String string2) {
        this.setString(KEY_USER_URL, string2);
    }

    /*
     * Exception decompiling
     */
    boolean shouldAddModules() {
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

    public void updateBranchViewUsageCount(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bnc_branch_view_use_");
        stringBuilder.append(string2);
        this.setInteger(stringBuilder.toString(), 1 + this.getBranchViewUsageCount(string2));
    }
}

