/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.android.installreferrer.api.InstallReferrerClient
 *  com.android.installreferrer.api.InstallReferrerStateListener
 *  com.android.installreferrer.api.ReferrerDetails
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URLDecoder
 *  java.util.HashMap
 *  java.util.Timer
 *  java.util.TimerTask
 */
package app.dukhaan.src.java.io.branch.referral;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.branch.referral.BranchPreinstall;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

class GooglePlayStoreAttribution {
    private static IInstallReferrerEvents callback_;
    static boolean erroredOut = false;
    static boolean hasBeenUsed = false;
    private static String installID_ = "bnc_no_value";

    GooglePlayStoreAttribution() {
    }

    public static String getInstallationID() {
        return installID_;
    }

    private static void onReferrerClientError() {
        PrefHelper.Debug("onReferrerClientError()");
        erroredOut = true;
        GooglePlayStoreAttribution.reportInstallReferrer();
    }

    private static void onReferrerClientFinished(Context context, String string2, long l, long l2) {
        PrefHelper.Debug("onReferrerClientFinished()");
        GooglePlayStoreAttribution.processReferrerInfo(context, string2, l, l2);
        GooglePlayStoreAttribution.reportInstallReferrer();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void processReferrerInfo(Context context, String string2, long l, long l2) {
        int n;
        String[] arrstring;
        String string3;
        int n2;
        PrefHelper prefHelper;
        HashMap hashMap;
        block11 : {
            UnsupportedEncodingException unsupportedEncodingException2;
            block12 : {
                prefHelper = PrefHelper.getInstance(context);
                if (l > 0L) {
                    prefHelper.setLong("bnc_referrer_click_ts", l);
                }
                if (l2 > 0L) {
                    prefHelper.setLong("bnc_install_begin_ts", l2);
                }
                if (string2 == null) return;
                try {
                    string3 = URLDecoder.decode((String)string2, (String)"UTF-8");
                    hashMap = new HashMap();
                    arrstring = string3.split("&");
                    n = arrstring.length;
                    n2 = 0;
                    break block11;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (UnsupportedEncodingException unsupportedEncodingException2) {
                    break block12;
                }
                illegalArgumentException.printStackTrace();
                PrefHelper.Debug("Illegal characters in url encoded string");
                return;
            }
            unsupportedEncodingException2.printStackTrace();
            return;
        }
        do {
            block14 : {
                String string4;
                String[] arrstring2;
                String string5;
                block16 : {
                    block15 : {
                        block13 : {
                            if (n2 >= n) break block13;
                            string4 = arrstring[n2];
                            if (TextUtils.isEmpty((CharSequence)string4)) break block14;
                            boolean bl = string4.contains((CharSequence)"=");
                            string5 = "-";
                            if (bl || !string4.contains((CharSequence)string5)) break block15;
                            break block16;
                        }
                        if (hashMap.containsKey((Object)Defines.Jsonkey.LinkClickID.getKey())) {
                            String string6;
                            installID_ = string6 = (String)hashMap.get((Object)Defines.Jsonkey.LinkClickID.getKey());
                            prefHelper.setLinkClickIdentifier(string6);
                        }
                        if (hashMap.containsKey((Object)Defines.Jsonkey.IsFullAppConv.getKey()) && hashMap.containsKey((Object)Defines.Jsonkey.ReferringLink.getKey())) {
                            prefHelper.setIsFullAppConversion(Boolean.parseBoolean((String)((String)hashMap.get((Object)Defines.Jsonkey.IsFullAppConv.getKey()))));
                            prefHelper.setAppLink((String)hashMap.get((Object)Defines.Jsonkey.ReferringLink.getKey()));
                        }
                        if (hashMap.containsKey((Object)Defines.Jsonkey.GoogleSearchInstallReferrer.getKey())) {
                            prefHelper.setGoogleSearchInstallIdentifier((String)hashMap.get((Object)Defines.Jsonkey.GoogleSearchInstallReferrer.getKey()));
                            prefHelper.setGooglePlayReferrer(string3);
                        }
                        if (!hashMap.containsValue((Object)Defines.Jsonkey.PlayAutoInstalls.getKey())) return;
                        {
                            prefHelper.setGooglePlayReferrer(string3);
                            BranchPreinstall.setBranchPreInstallGoogleReferrer(context, (HashMap<String, String>)hashMap);
                            return;
                        }
                    }
                    string5 = "=";
                }
                if ((arrstring2 = string4.split(string5)).length > 1) {
                    hashMap.put((Object)URLDecoder.decode((String)arrstring2[0], (String)"UTF-8"), (Object)URLDecoder.decode((String)arrstring2[1], (String)"UTF-8"));
                }
            }
            ++n2;
        } while (true);
    }

    private static void reportInstallReferrer() {
        IInstallReferrerEvents iInstallReferrerEvents = callback_;
        if (iInstallReferrerEvents != null) {
            iInstallReferrerEvents.onInstallReferrerEventsFinished();
            callback_ = null;
        }
    }

    void captureInstallReferrer(final Context context, long l, IInstallReferrerEvents iInstallReferrerEvents) {
        hasBeenUsed = true;
        callback_ = iInstallReferrerEvents;
        try {
            final InstallReferrerClient installReferrerClient = InstallReferrerClient.newBuilder((Context)context).build();
            installReferrerClient.startConnection(new InstallReferrerStateListener(){

                public void onInstallReferrerServiceDisconnected() {
                    PrefHelper.Debug("onInstallReferrerServiceDisconnected()");
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void onInstallReferrerSetupFinished(int n) {
                    long l;
                    long l2;
                    String string2;
                    block7 : {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("onInstallReferrerSetupFinished, responseCode = ");
                        stringBuilder.append(n);
                        PrefHelper.Debug(stringBuilder.toString());
                        if (n != -1) {
                            if (n != 0) {
                                if (n != 1 && n != 2 && n != 3) {
                                    return;
                                }
                            } else {
                                try {
                                    ReferrerDetails referrerDetails = installReferrerClient.getInstallReferrer();
                                    if (referrerDetails != null) {
                                        String string3 = referrerDetails.getInstallReferrer();
                                        long l3 = referrerDetails.getReferrerClickTimestampSeconds();
                                        l2 = referrerDetails.getInstallBeginTimestampSeconds();
                                        l = l3;
                                        string2 = string3;
                                    }
                                    break block7;
                                }
                                catch (RemoteException remoteException) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("onInstallReferrerSetupFinished() Exception: ");
                                    stringBuilder2.append(remoteException.getMessage());
                                    PrefHelper.Debug(stringBuilder2.toString());
                                    GooglePlayStoreAttribution.onReferrerClientError();
                                    return;
                                }
                            }
                        }
                        GooglePlayStoreAttribution.onReferrerClientError();
                        return;
                    }
                    l = l2 = 0L;
                    string2 = null;
                    GooglePlayStoreAttribution.onReferrerClientFinished(context, string2, l, l2);
                }
            });
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReferrerClientWrapper Exception: ");
            stringBuilder.append(throwable.getMessage());
            PrefHelper.Debug(stringBuilder.toString());
        }
        new Timer().schedule(new TimerTask(){

            public void run() {
                GooglePlayStoreAttribution.reportInstallReferrer();
            }
        }, l);
    }

}

