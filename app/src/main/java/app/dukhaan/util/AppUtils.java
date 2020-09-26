/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.os.LocaleList
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.Patterns
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Toast
 *  androidx.appcompat.widget.PopupMenu
 *  androidx.appcompat.widget.PopupMenu$OnDismissListener
 *  androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
 *  androidx.core.content.ContextCompat
 *  app.dukhaan.util.-$
 *  app.dukhaan.util.-$$Lambda
 *  app.dukhaan.util.-$$Lambda$AppUtils
 *  app.dukhaan.util.-$$Lambda$AppUtils$CFzeCBW7XkVXz9JxbTGeVTGY1Uo
 *  app.dukhaan.util.-$$Lambda$AppUtils$IDw2SHKInydrqjmvhG7TUyZbKbk
 *  app.dukhaan.util.-$$Lambda$AppUtils$IWbb2lUWPplR_3CXeb-pCrKx9zU
 *  app.dukhaan.util.-$$Lambda$AppUtils$bwdKnl0JEghTkZJ6C1NOntStw8I
 *  app.dukhaan.util.AppUtils$1
 *  app.dukhaan.util.AppUtils$2
 *  app.dukhaan.util.AppUtils$3
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.request.BaseRequestOptions
 *  com.bumptech.glide.request.FutureTarget
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfig
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
 *  com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder
 *  com.google.i18n.phonenumbers.NumberParseException
 *  com.google.i18n.phonenumbers.PhoneNumberUtil
 *  com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat
 *  com.google.i18n.phonenumbers.Phonenumber
 *  com.google.i18n.phonenumbers.Phonenumber$PhoneNumber
 *  com.yalantis.ucrop.util.FileUtils
 *  io.branch.referral.util.BranchEvent
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Comparator
 *  java.util.Currency
 *  java.util.Date
 *  java.util.Locale
 *  java.util.SortedMap
 *  java.util.TimeZone
 *  java.util.TreeMap
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  timber.log.Timber
 */
package app.dukhaan.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import app.dukhaan.util.-$;
import app.dukhaan.util.-$$Lambda$AppUtils$593woWvMz8f2IwZ4Hxn-uxeR3QQ;
import app.dukhaan.util.-$$Lambda$AppUtils$utJ1JBN9nKaQ47N7q9GqzXIquPM;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.CleverTapUtils;
import app.dukhaan.util.DialogDismissListener;
import app.dukhaan.util.IpopUpMenuItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.yalantis.ucrop.util.FileUtils;
import io.branch.referral.util.BranchEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import timber.log.Timber;

public final class AppUtils {
    public static SortedMap<Currency, Locale> currencyLocaleMap = new TreeMap((Comparator)new Comparator<Currency>(){

        public int compare(Currency currency, Currency currency2) {
            return currency.getCurrencyCode().compareTo(currency2.getCurrencyCode());
        }
    });

    static {
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance((Locale)locale);
                currencyLocaleMap.put((Object)currency, (Object)locale);
            }
            catch (Exception exception) {}
        }
    }

    static /* synthetic */ String access$000(Context context) {
        return AppUtils.getWhatsAppPackageName(context);
    }

    public static void clearCache(Context context) {
        File file = new File(context.getExternalCacheDir(), "camera");
        if (file.exists() && file.isDirectory()) {
            File[] arrfile = file.listFiles();
            int n = arrfile.length;
            for (int i = 0; i < n; ++i) {
                arrfile[i].delete();
            }
        }
    }

    public static void copyToClipboard(Context context, String string2) {
        ((ClipboardManager)context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)string2, (CharSequence)string2));
    }

    public static void dialNumber(Context context, String string2) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse((String)String.format((String)"tel:%s", (Object[])new Object[]{string2})));
        context.startActivity(intent);
    }

    public static int dpToPx(int n) {
        return (int)((float)n * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String formatDate(String string2) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ").parse(string2);
            String string3 = new SimpleDateFormat("MMM d, yyyy").format(date);
            return string3;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return "";
        }
    }

    public static String formatPhoneNumber(String string2) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            string2 = phoneNumberUtil.format(phoneNumberUtil.parse(string2, "US"), PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        }
        catch (NumberParseException numberParseException) {}
        return string2;
    }

    public static String getCategoryLink(String string2, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppUtils.getStoreLink(string2));
        stringBuilder.append("/products/?cat=");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public static String getCurrencySymbol(String string2) {
        return Currency.getInstance((String)string2).getSymbol();
    }

    public static String getDeviceLocale(Context context) {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
        return locale.getLanguage();
    }

    public static File getFile(Context context, Uri uri) {
        String string2;
        if (uri != null && AppUtils.isLocal(string2 = FileUtils.getPath((Context)context, (Uri)uri))) {
            return new File(string2);
        }
        return null;
    }

    public static Drawable getOrderStatusDrawable(Context context, String string2) {
        int n;
        block17 : {
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 2066319421: {
                    if (!string2.equals((Object)"FAILED")) break;
                    n = 4;
                    break block17;
                }
                case 1350822958: {
                    if (!string2.equals((Object)"DECLINED")) break;
                    n = 5;
                    break block17;
                }
                case 174130302: {
                    if (!string2.equals((Object)"REJECTED")) break;
                    n = 2;
                    break block17;
                }
                case 35394935: {
                    if (!string2.equals((Object)"PENDING")) break;
                    n = 0;
                    break block17;
                }
                case -1031784143: {
                    if (!string2.equals((Object)"CANCELLED")) break;
                    n = 3;
                    break block17;
                }
                case -1363898457: {
                    if (!string2.equals((Object)"ACCEPTED")) break;
                    n = 1;
                    break block17;
                }
                case -1515427533: {
                    if (!string2.equals((Object)"SHIPPED")) break;
                    n = 6;
                    break block17;
                }
                case -1750699932: {
                    if (!string2.equals((Object)"DELIVERED")) break;
                    n = 7;
                    break block17;
                }
            }
            n = -1;
        }
        int n2 = 2131230848;
        switch (n) {
            default: {
                break;
            }
            case 7: {
                n2 = 2131230850;
                break;
            }
            case 6: {
                n2 = 2131230853;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                n2 = 2131230852;
                break;
            }
            case 0: {
                n2 = 2131230851;
            }
            case 1: 
        }
        return ContextCompat.getDrawable((Context)context, (int)n2);
    }

    public static String getProductLink(String string2, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppUtils.getStoreLink(string2));
        stringBuilder.append("/product/details/?id=");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static String getStoreLink(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://mydukaan.io/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static Drawable getSymbol(Context context, String string2, float f, int n) {
        Paint paint = new Paint(1);
        paint.setTextSize(f);
        paint.setColor(n);
        paint.setTextAlign(Paint.Align.LEFT);
        float f2 = -paint.ascent();
        Bitmap bitmap = Bitmap.createBitmap((int)((int)(0.5f + paint.measureText(string2))), (int)((int)(0.5f + (f2 + paint.descent()))), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        new Canvas(bitmap).drawText(string2, 0.0f, f2, paint);
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    private static String getWhatsAppPackageName(Context context) {
        if (AppUtils.isAppInstalled(context, "com.whatsapp.w4b")) {
            return "com.whatsapp.w4b";
        }
        return "com.whatsapp";
    }

    public static void hideKeyboard(Activity activity) {
        ((InputMethodManager)activity.getSystemService("input_method")).toggleSoftInput(1, 0);
        if (activity.getCurrentFocus() != null) {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Context context) {
        ((InputMethodManager)context.getSystemService("input_method")).toggleSoftInput(1, 0);
    }

    public static void initDefaultShare(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FIREBASE: ");
        stringBuilder.append(string2);
        Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Share with your Customers"));
    }

    public static boolean isAppInstalled(Context context, String string2) {
        try {
            context.getPackageManager().getApplicationInfo(string2, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    public static boolean isEmailValid(String string2) {
        return Patterns.EMAIL_ADDRESS.matcher((CharSequence)string2).matches();
    }

    /*
     * Exception decompiling
     */
    public static boolean isInstallFromUpdate(Context var0) {
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

    public static boolean isLocal(String string2) {
        return string2 != null && !string2.startsWith("http://") && !string2.startsWith("https://");
    }

    private static boolean isWhatsAppInstalled(Context context) {
        if (AppUtils.isAppInstalled(context, "com.whatsapp.w4b")) {
            return true;
        }
        return AppUtils.isAppInstalled(context, "com.whatsapp");
    }

    static /* synthetic */ boolean lambda$popUpMenu$2(IpopUpMenuItem ipopUpMenuItem, MenuItem menuItem) {
        if (ipopUpMenuItem != null) {
            ipopUpMenuItem.menuItem(menuItem);
        }
        return true;
    }

    static /* synthetic */ boolean lambda$popUpMenuUnit$3(IpopUpMenuItem ipopUpMenuItem, MenuItem menuItem) {
        if (ipopUpMenuItem != null) {
            ipopUpMenuItem.menuItem(menuItem);
        }
        return true;
    }

    static /* synthetic */ void lambda$shareOnWhatsApp$0(FirebaseRemoteConfig firebaseRemoteConfig, String string2, String string3, String string4, Context context, Task task) {
        if (task.isSuccessful()) {
            String string5 = firebaseRemoteConfig.getString("washare_store_msg");
            Timber.d((String)"FIREBASE: Found Remote", (Object[])new Object[0]);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FIREBASE: ");
            stringBuilder.append(string5);
            Timber.d((String)stringBuilder.toString(), (Object[])new Object[0]);
            if (!TextUtils.isEmpty((CharSequence)string5)) {
                String string6 = String.format((String)string5, (Object[])new Object[]{string2, string3, string4});
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("FIREBASE: ");
                stringBuilder2.append(string5);
                Timber.d((String)stringBuilder2.toString(), (Object[])new Object[0]);
                AppUtils.initDefaultShare(context, string6);
                return;
            }
            AppUtils.initDefaultShare(context, context.getString(2131951935, new Object[]{string2, string3, string4}));
        }
    }

    static /* synthetic */ void lambda$shareOnWhatsApp$1(Context context, String string2, String string3, String string4, Exception exception) {
        AppUtils.initDefaultShare(context, context.getString(2131951935, new Object[]{string2, string3, string4}));
    }

    static /* synthetic */ void lambda$showSettingsDialog$4(Activity activity, DialogInterface dialogInterface, int n) {
        dialogInterface.cancel();
        AppUtils.openSettings(activity);
    }

    static /* synthetic */ void lambda$showSettingsDialog$5(DialogInterface dialogInterface, int n) {
        dialogInterface.cancel();
    }

    public static void openBrowser(Context context, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string2)));
    }

    private static void openSettings(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts((String)"package", (String)activity.getPackageName(), null));
        activity.startActivityForResult(intent, 101);
    }

    public static void popUpMenu(Context context, View view, int n, IpopUpMenuItem ipopUpMenuItem, DialogDismissListener dialogDismissListener) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.setGravity(8388613);
        popupMenu.getMenuInflater().inflate(n, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new -$.Lambda.AppUtils.bwdKnl0JEghTkZJ6C1NOntStw8I(ipopUpMenuItem));
        popupMenu.setOnDismissListener((PopupMenu.OnDismissListener)new 2(dialogDismissListener));
        popupMenu.show();
    }

    public static void popUpMenuUnit(Context context, View view, int n, IpopUpMenuItem ipopUpMenuItem, DialogDismissListener dialogDismissListener) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.setGravity(8388613);
        popupMenu.getMenuInflater().inflate(n, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new -$.Lambda.AppUtils.IWbb2lUWPplR_3CXeb-pCrKx9zU(ipopUpMenuItem));
        popupMenu.setOnDismissListener((PopupMenu.OnDismissListener)new 3(dialogDismissListener));
        popupMenu.show();
    }

    public static int pxToDp(int n) {
        return (int)((float)n / Resources.getSystem().getDisplayMetrics().density);
    }

    public static void shareApp(Context context, String string2) {
        try {
            String string3 = context.getString(2131951938, new Object[]{string2});
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", string3);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Share with your Customers"));
        }
        catch (Exception exception) {}
    }

    public static void shareCategory(Context context, int n, int n2, String string2, String string3, String string4) {
        if (!AppUtils.isWhatsAppInstalled(context)) {
            return;
        }
        try {
            CleverTapUtils.trackShareCategory(context, n, n2, string2);
            String string5 = context.getString(2131951933, new Object[]{string2, string2, string3, string4});
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", string5);
            intent.setType("text/plain");
            context.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Share with your Customers"));
            return;
        }
        catch (Exception exception) {
            Timber.e((String)"WhatsApp not installed", (Object[])new Object[0]);
            return;
        }
    }

    public static void shareOnWhatsApp(Context context, int n, String string2, String string3, String string4) {
        CleverTapUtils.trackShareStoreLink(context, n, string3);
        new BranchEvent("WAShare Store Link").addCustomDataProperty("link", string3).setCustomerEventAlias("washare_store_link").logEvent(context);
        try {
            FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            firebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(5L).build());
            Timber.d((String)"FIREBASE: Remote set", (Object[])new Object[0]);
            Task task = firebaseRemoteConfig.fetchAndActivate();
            Activity activity = (Activity)context;
            -$.Lambda.AppUtils.IDw2SHKInydrqjmvhG7TUyZbKbk iDw2SHKInydrqjmvhG7TUyZbKbk = new -$.Lambda.AppUtils.IDw2SHKInydrqjmvhG7TUyZbKbk(firebaseRemoteConfig, string2, string3, string4, context);
            task.addOnCompleteListener(activity, (OnCompleteListener)iDw2SHKInydrqjmvhG7TUyZbKbk).addOnFailureListener((OnFailureListener)new -$.Lambda.AppUtils.CFzeCBW7XkVXz9JxbTGeVTGY1Uo(context, string2, string3, string4));
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FIREBASE: ");
            stringBuilder.append((Object)exception);
            Timber.e((String)stringBuilder.toString(), (Object[])new Object[0]);
            AppUtils.initDefaultShare(context, context.getString(2131951935, new Object[]{string2, string3, string4}));
            return;
        }
    }

    public static void shareProduct(Context context, int n, String string2, int n2, double d, String string3, String string4, String string5) {
        if (!AppUtils.isWhatsAppInstalled(context)) {
            return;
        }
        try {
            CleverTapUtils.trackShareProduct(context, n, n2, string2);
            Toast.makeText((Context)context, (CharSequence)context.getString(2131951834), (int)1).show();
            RequestBuilder requestBuilder = Glide.with((Context)context).asBitmap().load(string5).apply(new RequestOptions().override(800));
            1 var11_9 = new 1(context, string2, d, string3, string4);
            requestBuilder.listener((RequestListener)var11_9).submit();
        }
        catch (Exception exception) {}
    }

    public static void showKeyboard(Context context) {
        ((InputMethodManager)context.getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void showSettingsDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setTitle((CharSequence)activity.getString(2131951756));
        builder.setMessage((CharSequence)activity.getString(2131951755));
        builder.setPositiveButton((CharSequence)activity.getString(2131951792), (DialogInterface.OnClickListener)new -$$Lambda$AppUtils$utJ1JBN9nKaQ47N7q9GqzXIquPM(activity));
        builder.setNegativeButton((CharSequence)activity.getString(17039360), (DialogInterface.OnClickListener)-$$Lambda$AppUtils$593woWvMz8f2IwZ4Hxn-uxeR3QQ.INSTANCE);
        builder.show();
    }

    public static Date stringToDate(String string2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
            Date date = simpleDateFormat.parse(string2);
            return date;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return null;
        }
    }

    public static String toAppDateFormat(String string2) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string2);
            String string3 = new SimpleDateFormat("MM-dd-yyyy").format(date);
            return string3;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return string2;
        }
    }

    public static String toOrderDate(Date date) {
        return new SimpleDateFormat("MM-dd-yyyy").format(date);
    }

    public static String toOrderStatus(Context context, String string2) {
        int n;
        block18 : {
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 2066319421: {
                    if (!string2.equals((Object)"FAILED")) break;
                    n = 7;
                    break block18;
                }
                case 1350822958: {
                    if (!string2.equals((Object)"DECLINED")) break;
                    n = 5;
                    break block18;
                }
                case 174130302: {
                    if (!string2.equals((Object)"REJECTED")) break;
                    n = 4;
                    break block18;
                }
                case 35394935: {
                    if (!string2.equals((Object)"PENDING")) break;
                    n = 0;
                    break block18;
                }
                case -1031784143: {
                    if (!string2.equals((Object)"CANCELLED")) break;
                    n = 6;
                    break block18;
                }
                case -1363898457: {
                    if (!string2.equals((Object)"ACCEPTED")) break;
                    n = 1;
                    break block18;
                }
                case -1515427533: {
                    if (!string2.equals((Object)"SHIPPED")) break;
                    n = 2;
                    break block18;
                }
                case -1750699932: {
                    if (!string2.equals((Object)"DELIVERED")) break;
                    n = 3;
                    break block18;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return "";
            }
            case 6: 
            case 7: {
                return context.getString(2131951668);
            }
            case 4: 
            case 5: {
                return context.getString(2131951919);
            }
            case 3: {
                return context.getString(2131951748);
            }
            case 2: {
                return context.getString(2131951941);
            }
            case 1: {
                return context.getString(2131951647);
            }
            case 0: 
        }
        return context.getString(2131951903);
    }

    public static String toProductStatus(Context context, boolean bl) {
        int n = bl ? 2131951883 : 2131951826;
        return context.getString(n);
    }

}

