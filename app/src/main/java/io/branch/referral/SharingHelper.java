/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral;

public class SharingHelper {

    public static final class SHARE_WITH
    extends Enum<SHARE_WITH> {
        private static final /* synthetic */ SHARE_WITH[] $VALUES;
        public static final /* enum */ SHARE_WITH EMAIL;
        public static final /* enum */ SHARE_WITH FACEBOOK;
        public static final /* enum */ SHARE_WITH FACEBOOK_MESSENGER;
        public static final /* enum */ SHARE_WITH FLICKR;
        public static final /* enum */ SHARE_WITH GMAIL;
        public static final /* enum */ SHARE_WITH GOOGLE_DOC;
        public static final /* enum */ SHARE_WITH HANGOUT;
        public static final /* enum */ SHARE_WITH INSTAGRAM;
        public static final /* enum */ SHARE_WITH MESSAGE;
        public static final /* enum */ SHARE_WITH PINTEREST;
        public static final /* enum */ SHARE_WITH SNAPCHAT;
        public static final /* enum */ SHARE_WITH TWITTER;
        public static final /* enum */ SHARE_WITH WECHAT;
        public static final /* enum */ SHARE_WITH WHATS_APP;
        private String name = "";

        static {
            SHARE_WITH sHARE_WITH;
            FACEBOOK = new SHARE_WITH("com.facebook.katana");
            FACEBOOK_MESSENGER = new SHARE_WITH("com.facebook.orca");
            TWITTER = new SHARE_WITH("com.twitter.android");
            MESSAGE = new SHARE_WITH(".mms");
            EMAIL = new SHARE_WITH("com.google.android.email");
            FLICKR = new SHARE_WITH("com.yahoo.mobile.client.android.flickr");
            GOOGLE_DOC = new SHARE_WITH("com.google.android.apps.docs");
            WHATS_APP = new SHARE_WITH("com.whatsapp");
            PINTEREST = new SHARE_WITH("com.pinterest");
            HANGOUT = new SHARE_WITH("com.google.android.talk");
            INSTAGRAM = new SHARE_WITH("com.instagram.android");
            WECHAT = new SHARE_WITH("jom.tencent.mm");
            SNAPCHAT = new SHARE_WITH("com.snapchat.android");
            GMAIL = sHARE_WITH = new SHARE_WITH("com.google.android.gm");
            SHARE_WITH[] arrsHARE_WITH = new SHARE_WITH[]{FACEBOOK, FACEBOOK_MESSENGER, TWITTER, MESSAGE, EMAIL, FLICKR, GOOGLE_DOC, WHATS_APP, PINTEREST, HANGOUT, INSTAGRAM, WECHAT, SNAPCHAT, sHARE_WITH};
            $VALUES = arrsHARE_WITH;
        }

        private SHARE_WITH(String string3) {
            this.name = string3;
        }

        public static SHARE_WITH valueOf(String string2) {
            return (SHARE_WITH)Enum.valueOf(SHARE_WITH.class, (String)string2);
        }

        public static SHARE_WITH[] values() {
            return (SHARE_WITH[])$VALUES.clone();
        }

        public String getAppName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

}

