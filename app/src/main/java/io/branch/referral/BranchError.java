/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.io.branch.referral;

public class BranchError {
    public static final int ERR_API_LVL_14_NEEDED = -108;
    public static final int ERR_BRANCH_ALREADY_INITIALIZED = -118;
    public static final int ERR_BRANCH_DUPLICATE_REFERRAL_CODE = -106;
    public static final int ERR_BRANCH_DUPLICATE_URL = -105;
    public static final int ERR_BRANCH_INIT_FAILED = -104;
    public static final int ERR_BRANCH_INVALID_REQUEST = -116;
    public static final int ERR_BRANCH_KEY_INVALID = -114;
    public static final int ERR_BRANCH_NOT_INSTANTIATED = -109;
    public static final int ERR_BRANCH_NO_CONNECTIVITY = -113;
    public static final int ERR_BRANCH_NO_SHARE_OPTION = -110;
    public static final int ERR_BRANCH_REDEEM_REWARD = -107;
    public static final int ERR_BRANCH_REQ_TIMED_OUT = -111;
    public static final int ERR_BRANCH_RESOURCE_CONFLICT = -115;
    public static final int ERR_BRANCH_TRACKING_DISABLED = -117;
    public static final int ERR_BRANCH_UNABLE_TO_REACH_SERVERS = -112;
    public static final int ERR_INVALID_REFERRAL_CODE = -103;
    public static final int ERR_NO_INTERNET_PERMISSION = -102;
    public static final int ERR_NO_SESSION = -101;
    int errorCode_ = -113;
    String errorMessage_ = "";

    public BranchError(String string2, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.initErrorCodeAndGetLocalisedMessage(n));
        this.errorMessage_ = stringBuilder.toString();
    }

    private String initErrorCodeAndGetLocalisedMessage(int n) {
        if (n == -113) {
            this.errorCode_ = -113;
            return " Branch API Error: poor network connectivity. Please try again later.";
        }
        if (n == -114) {
            this.errorCode_ = -114;
            return " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        }
        if (n == -104) {
            this.errorCode_ = -104;
            return " Did you forget to call init? Make sure you init the session before making Branch calls.";
        }
        if (n == -101) {
            this.errorCode_ = -101;
            return " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        }
        if (n == -102) {
            this.errorCode_ = -102;
            return " Please add 'android.permission.INTERNET' in your applications manifest file.";
        }
        if (n == -105) {
            this.errorCode_ = -105;
            return " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        }
        if (n == -106) {
            this.errorCode_ = -106;
            return " That Branch referral code is already in use.";
        }
        if (n == -107) {
            this.errorCode_ = -107;
            return " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        }
        if (n == -108) {
            this.errorCode_ = -108;
            return "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        }
        if (n == -109) {
            this.errorCode_ = -109;
            return "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        }
        if (n == -110) {
            this.errorCode_ = -110;
            return " Unable create share options. Couldn't find applications on device to share the link.";
        }
        if (n == -111) {
            this.errorCode_ = -111;
            return " Request to Branch server timed out. Please check your internet connectivity";
        }
        if (n == -117) {
            this.errorCode_ = -117;
            return " Tracking is disabled. Requested operation cannot be completed when tracking is disabled";
        }
        if (n == -118) {
            this.errorCode_ = -118;
            return " Session initialization already happened. To force a new session, set intent extra, \"branch_force_new_session\", to true.";
        }
        if (n < 500 && n != -112) {
            if (n != 409 && n != -115) {
                if (n < 400 && n != -116) {
                    this.errorCode_ = -113;
                    return " Check network connectivity and that you properly initialized.";
                }
                this.errorCode_ = -116;
                return " The request was invalid.";
            }
            this.errorCode_ = -115;
            return " A resource with this identifier already exists.";
        }
        this.errorCode_ = -112;
        return " Unable to reach the Branch servers, please try again shortly.";
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public String getMessage() {
        return this.errorMessage_;
    }

    public String toString() {
        return this.getMessage();
    }
}

