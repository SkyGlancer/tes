/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import app.dukhaan.app.MyApplication;
import app.dukhaan.data.local.AppPrefHelper;

public class AppPref
implements AppPrefHelper {
    private static final String APP_LOCALE = "app_locale";
    private static final String CURRENCY = "currency";
    private static final String IS_CONTACTS_SYNCED = "is_contacts_synced";
    private static final String IS_PRODUCTS_ADDED = "is_products_added";
    private static final String KEY_AUTH_TOKEN = "auth_token";
    private static final String KEY_FCM_TOKEN = "fcm_token";
    private static final String PREF_NAME = "dukhaan_app_prefs";
    private static final int PRIVATE_MODE = 0;
    private static final String REFERRED_BY = "referred_by";
    private static final String SHARED_ON_WHATSAPP = "is_shared_on_whatsapp";
    private static final String USER_MOBILE = "mobile";
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;
    private static AppPref singleTonInstance;

    public AppPref(Context context) {
        SharedPreferences sharedPreferences;
        AppPref.sharedPreferences = sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public static AppPref getInstance() {
        if (singleTonInstance == null) {
            singleTonInstance = new AppPref(MyApplication.getInstance().getApplicationContext());
        }
        return singleTonInstance;
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    @Override
    public String getAuthToken() {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null);
    }

    public String getCurrency() {
        return sharedPreferences.getString(CURRENCY, null);
    }

    public String getFcmToken() {
        return sharedPreferences.getString(KEY_FCM_TOKEN, null);
    }

    public String getLocale() {
        return sharedPreferences.getString(APP_LOCALE, null);
    }

    public String getMobile() {
        return sharedPreferences.getString(USER_MOBILE, null);
    }

    public String getReferredBy() {
        return sharedPreferences.getString(REFERRED_BY, null);
    }

    public boolean isContactsSynced() {
        return sharedPreferences.getBoolean(IS_CONTACTS_SYNCED, false);
    }

    public boolean isProductsAdded() {
        return sharedPreferences.getBoolean(IS_PRODUCTS_ADDED, false);
    }

    public boolean isSharedOnWhatsapp() {
        return sharedPreferences.getBoolean(SHARED_ON_WHATSAPP, false);
    }

    @Override
    public void saveAuthToken(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        editor.putString(KEY_AUTH_TOKEN, string2);
        editor.commit();
    }

    public void saveFcmToken(String string2) {
        editor.putString(KEY_FCM_TOKEN, string2);
        editor.commit();
    }

    public void saveMobile(String string2) {
        editor.putString(USER_MOBILE, string2);
        editor.commit();
    }

    public void setContactsSynced(boolean bl) {
        editor.putBoolean(IS_CONTACTS_SYNCED, bl);
        editor.commit();
    }

    public void setCurrency(String string2) {
        editor.putString(CURRENCY, string2);
        editor.commit();
    }

    public void setLocale(String string2) {
        editor.putString(APP_LOCALE, string2);
        editor.commit();
    }

    public void setProductsAdded(boolean bl) {
        editor.putBoolean(IS_PRODUCTS_ADDED, bl);
        editor.commit();
    }

    public void setReferredBy(String string2) {
        editor.putString(REFERRED_BY, string2);
        editor.commit();
    }

    public void setSharedOnWhatsapp(boolean bl) {
        editor.putBoolean(SHARED_ON_WHATSAPP, bl);
        editor.commit();
    }
}

