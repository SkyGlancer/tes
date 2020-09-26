/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 *  io.branch.referral.Branch
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.validators;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import io.branch.referral.Branch;
import io.branch.referral.BranchUtil;
import io.branch.referral.ServerRequest;
import io.branch.referral.validators.BranchIntegrationModel;
import io.branch.referral.validators.ServerRequestGetAppConfig;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class IntegrationValidator
implements ServerRequestGetAppConfig.IGetAppConfigEvents {
    private static IntegrationValidator instance;
    private final String TAG = "BranchSDK_Doctor";
    private final BranchIntegrationModel integrationModel;

    private IntegrationValidator(Context context) {
        this.integrationModel = new BranchIntegrationModel(context);
    }

    private boolean checkIfIntentAddedForLinkDomain(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2) && this.integrationModel.applinkScheme != null) {
            Iterator iterator = this.integrationModel.applinkScheme.iterator();
            while (iterator.hasNext()) {
                if (!string2.equals((Object)((String)iterator.next()))) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkIfIntentAddedForURIScheme(String string2) {
        Uri uri = Uri.parse((String)string2);
        String string3 = uri.getScheme();
        String string4 = uri.getHost();
        if (TextUtils.isEmpty((CharSequence)string4)) {
            string4 = "open";
        }
        JSONObject jSONObject = this.integrationModel.deeplinkUriScheme;
        boolean bl = false;
        if (jSONObject != null) {
            Iterator iterator = this.integrationModel.deeplinkUriScheme.keys();
            boolean bl2 = false;
            block0 : while (iterator.hasNext()) {
                String string5 = (String)iterator.next();
                if (string3 == null || !string3.equals((Object)string5)) continue;
                JSONArray jSONArray = this.integrationModel.deeplinkUriScheme.optJSONArray(string5);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); ++i) {
                        if (string4 == null || !string4.equals((Object)jSONArray.optString(i))) continue;
                        bl2 = true;
                        continue block0;
                    }
                    continue;
                }
                return true;
            }
            bl = bl2;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void doValidateWithAppConfig(JSONObject jSONObject) {
        this.logValidationProgress("3. Verifying application package name");
        if (!this.integrationModel.packageName.equals((Object)jSONObject.optString("android_package_name"))) {
            this.logIntegrationError("Incorrect package name in Branch dashboard. Please correct your package name in dashboard -> link Settings page.", "https://docs.branch.io/pages/dashboard/integrate/#android");
            return;
        }
        this.logValidationPassed();
        this.logValidationProgress("4. Checking Android Manifest for URI based deep link config");
        if (this.integrationModel.deeplinkUriScheme != null && this.integrationModel.deeplinkUriScheme.length() != 0) {
            this.logValidationPassed();
        } else {
            if (this.integrationModel.appSettingsAvailable) {
                Object[] arrobject = new Object[]{jSONObject.optString("android_uri_scheme")};
                this.logIntegrationError(String.format((String)"No intent found for opening the app through uri Scheme '%s'.Please add the intent with URI scheme to your Android manifest.", (Object[])arrobject), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            this.logValidationProgress("- Skipping. Unable to verify the deep link config. Failed to read the Android Manifest");
        }
        this.logValidationProgress("5. Verifying URI based deep link config with Branch dash board.");
        String string2 = jSONObject.optString("android_uri_scheme");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.logIntegrationError("Uri Scheme to open your app is not specified in Branch dashboard. Please add URI scheme in Branch dashboard.", "https://docs.branch.io/pages/dashboard/integrate/#android");
            return;
        }
        this.logValidationPassed();
        this.logValidationProgress("6. Verifying intent for receiving URI scheme.");
        if (!this.checkIfIntentAddedForURIScheme(string2)) {
            if (this.integrationModel.appSettingsAvailable) {
                this.logIntegrationError(String.format((String)"Uri scheme '%s' specified in Branch dashboard doesn't match with the deep link intent in manifest file", (Object[])new Object[]{string2}), "https://docs.branch.io/pages/dashboard/integrate/#android");
                return;
            }
            this.logValidationProgress("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
        } else {
            this.logValidationPassed();
        }
        this.logValidationProgress("7. Checking AndroidManifest for AppLink config.");
        if (this.integrationModel.applinkScheme.isEmpty()) {
            if (this.integrationModel.appSettingsAvailable) {
                this.logIntegrationError("Could not find any App Link hosts to support Android AppLinks. Please add intent filter for handling AppLinks in your Android Manifest file", "https://docs.branch.io/pages/deep-linking/android-app-links/#add-intent-filter-to-manifest");
                return;
            }
            this.logValidationProgress("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
        } else {
            this.logValidationPassed();
        }
        this.logValidationProgress("8. Verifying any supported custom link domains.");
        String string3 = jSONObject.optString("short_url_domain");
        if (!TextUtils.isEmpty((CharSequence)string3) && !this.checkIfIntentAddedForLinkDomain(string3)) {
            if (this.integrationModel.appSettingsAvailable) {
                this.logIntegrationError(String.format((String)"Could not find intent filter to support custom link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", (Object[])new Object[]{string3}), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            this.logValidationProgress("- Skipping. Unable to verify supported custom link domains. Failed to read the Android Manifest");
        } else {
            this.logValidationPassed();
        }
        this.logValidationProgress("9. Verifying default link domains integrations.");
        String string4 = jSONObject.optString("default_short_url_domain");
        if (!TextUtils.isEmpty((CharSequence)string4) && !this.checkIfIntentAddedForLinkDomain(string4)) {
            if (this.integrationModel.appSettingsAvailable) {
                this.logIntegrationError(String.format((String)"Could not find intent filter to support Branch default link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", (Object[])new Object[]{string4}), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            this.logValidationProgress("- Skipping. Unable to verify default link domains. Failed to read the Android Manifest");
        } else {
            this.logValidationPassed();
        }
        this.logValidationProgress("10. Verifying alternate link domains integrations.");
        String string5 = jSONObject.optString("alternate_short_url_domain");
        if (!TextUtils.isEmpty((CharSequence)string5) && !this.checkIfIntentAddedForLinkDomain(string5)) {
            if (this.integrationModel.appSettingsAvailable) {
                this.logIntegrationError(String.format((String)"Could not find intent filter to support alternate link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", (Object[])new Object[]{string5}), "https://docs.branch.io/pages/apps/android/#configure-app");
                return;
            }
            this.logValidationProgress("- Skipping.Unable to verify alternate link domains. Failed to read the Android Manifest");
        } else {
            this.logValidationPassed();
        }
        this.logValidationPassed();
        Log.d((String)"BranchSDK_Doctor", (String)"--------------------------------------------\nSuccessfully completed Branch integration validation. Everything looks good!");
        Log.d((String)"BranchSDK_Doctor", (String)"\n         Great! Comment out the 'validateSDKIntegration' line in your app. Next check your deep link routing.\n         Append '?bnc_validate=true' to any of your app's Branch links and click it on your mobile device (not the Simulator!) to start the test.\n         For instance, to validate a link like:\n         https://<yourapp>.app.link/NdJ6nFzRbK\n         click on:\n         https://<yourapp>.app.link/NdJ6nFzRbK?bnc_validate=true");
    }

    private void logIntegrationError(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("** ERROR ** : ");
        stringBuilder.append(string2);
        stringBuilder.append("\nPlease follow the link for more info ");
        stringBuilder.append(string3);
        Log.d((String)"BranchSDK_Doctor", (String)stringBuilder.toString());
    }

    private void logValidationPassed() {
        Log.d((String)"BranchSDK_Doctor", (String)"Passed");
    }

    private void logValidationProgress(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" ... ");
        Log.d((String)"BranchSDK_Doctor", (String)stringBuilder.toString());
    }

    public static void validate(Context context) {
        if (instance == null) {
            instance = new IntegrationValidator(context);
        }
        instance.validateSDKIntegration(context);
    }

    private void validateSDKIntegration(Context context) {
        this.logValidationProgress("\n\n------------------- Initiating Branch integration verification ---------------------------");
        this.logValidationProgress("1. Verifying Branch instance creation");
        if (Branch.getInstance() == null) {
            this.logIntegrationError("Branch is not initialised from your Application class. Please add `Branch.getAutoInstance(this);` to your Application#onCreate() method.", "https://docs.branch.io/pages/apps/android/#load-branch");
            return;
        }
        this.logValidationPassed();
        this.logValidationProgress("2. Checking Branch keys");
        if (TextUtils.isEmpty((CharSequence)BranchUtil.readBranchKey(context))) {
            this.logIntegrationError("Unable to read Branch keys from your application. Did you forget to add Branch keys in your application?.", "https://docs.branch.io/pages/apps/android/#configure-app");
            return;
        }
        this.logValidationPassed();
        Branch.getInstance().handleNewRequest((ServerRequest)new ServerRequestGetAppConfig(context, this));
    }

    @Override
    public void onAppConfigAvailable(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.doValidateWithAppConfig(jSONObject);
            return;
        }
        this.logIntegrationError("Unable to read Dashboard config. Please confirm that your Branch key is properly added to the manifest. Please fix your Dashboard settings.", "https://branch.app.link/link-settings-page");
    }
}

