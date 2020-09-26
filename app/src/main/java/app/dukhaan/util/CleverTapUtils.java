/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.network.model.Order
 *  app.dukhaan.util.-$
 *  app.dukhaan.util.-$$Lambda
 *  app.dukhaan.util.-$$Lambda$CleverTapUtils
 *  app.dukhaan.util.-$$Lambda$CleverTapUtils$a0RsO26B2-lf7ZA0Xs9kcR3ABEI
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.iid.FirebaseInstanceId
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  timber.log.Timber
 */
package app.dukhaan.util;

import android.content.Context;
import android.location.Location;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.model.Business;
import app.dukhaan.network.model.Order;
import app.dukhaan.util.-$;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.DateTimeUtils;
import com.clevertap.android.sdk.CleverTapAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import timber.log.Timber;

public class CleverTapUtils {
    private static String BUSINESS_ID = "Business Id";
    private static String BUSINESS_ID_IDENTITY = "business_%s";
    private static String BUSINESS_NAME = "Business Name";
    private static String CATEGORY = "Category";
    private static String CATEGORY_ID = "Category Id";
    private static String CATEGORY_NAME = "Category Name";
    private static String COUNTRY = "Country";
    private static String EVENT_ADDED_10_PRODUCTS = "Added 10 Products";
    private static String EVENT_ADDED_PRODUCT = "Added Product";
    private static String EVENT_BUSINESS_CREATED = "Business Created";
    private static String EVENT_LOGIN = "Login";
    private static String EVENT_ORDER_VIEWED = "Order Viewed";
    private static String EVENT_SHARE_CATEGORY = "WAShare Category";
    private static String EVENT_SHARE_PRODUCT = "WAShare Product";
    private static String EVENT_SHARE_STORE_LINK = "WAShare Store Link";
    private static String IDENTITY = "Identity";
    private static String LINK = "Link";
    private static String MOBILE = "Mobile";
    private static String NAME = "Name";
    private static String ORDER_ID = "Order Id";
    private static String ORDER_RECEIVED_DATE = "Order Received Date";
    private static String ORDER_VIEWED_AT = "Order Viewed Date";
    private static String PRICE = "Price";
    private static String PRODUCT_ID = "Product Id";
    private static String PRODUCT_NAME = "Product Name";

    /*
     * Exception decompiling
     */
    static /* synthetic */ void lambda$registerFcmToken$0(CleverTapAPI var0, Task var1) {
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
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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

    public static void registerFcmToken(Context context) {
        try {
            CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance((Context)context);
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener((OnCompleteListener)new -$.Lambda.CleverTapUtils.a0RsO26B2-lf7ZA0Xs9kcR3ABEI(cleverTapAPI));
        }
        catch (Exception exception) {}
    }

    public static void track10ProductsAdded(Context context, int n) {
        Timber.e((String)"Added 10 products event!", (Object[])new Object[0]);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)n);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_ADDED_10_PRODUCTS, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackBusinessCreated(Context context, Business business) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)business.realmGet$id());
            hashMap.put((Object)LINK, (Object)business.realmGet$link());
            Location location = new Location("");
            location.setLatitude(business.realmGet$latitude());
            location.setLongitude(business.realmGet$longitude());
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).setLocation(location);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_BUSINESS_CREATED, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackLogin(Context context, String string2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)MOBILE, (Object)string2);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_LOGIN, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackNewOrder(Context context, Business business, Order order) {
        if (order != null) {
            if (business == null) {
                return;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put((Object)LINK, (Object)business.realmGet$link());
                hashMap.put((Object)ORDER_ID, (Object)order.realmGet$id());
                hashMap.put((Object)PRICE, (Object)Float.valueOf((float)order.getGrandTotal()));
                hashMap.put((Object)ORDER_RECEIVED_DATE, (Object)DateTimeUtils.getTimestamp(context, AppUtils.stringToDate(order.realmGet$createdAt())));
                hashMap.put((Object)ORDER_VIEWED_AT, (Object)DateTimeUtils.getTimestamp(context, new Date()));
                ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_ORDER_VIEWED, (Map)hashMap);
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void trackProductAdded(Context context, int n) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)n);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_ADDED_PRODUCT, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackShareCategory(Context context, int n, int n2, String string2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)n);
            hashMap.put((Object)CATEGORY_ID, (Object)n2);
            hashMap.put((Object)CATEGORY_NAME, (Object)string2);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_SHARE_CATEGORY, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackShareProduct(Context context, int n, int n2, String string2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)n);
            hashMap.put((Object)PRODUCT_ID, (Object)n2);
            hashMap.put((Object)PRODUCT_NAME, (Object)string2);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_SHARE_PRODUCT, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackShareStoreLink(Context context, int n, String string2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)BUSINESS_ID, (Object)n);
            hashMap.put((Object)LINK, (Object)string2);
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushEvent(EVENT_SHARE_STORE_LINK, (Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void trackUser(Context context, Business business) {
        if (business == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            String string2 = IDENTITY;
            String string3 = BUSINESS_ID_IDENTITY;
            Object[] arrobject = new Object[]{business.realmGet$id()};
            hashMap.put((Object)string2, (Object)String.format((String)string3, (Object[])arrobject));
            hashMap.put((Object)NAME, (Object)business.realmGet$name());
            hashMap.put((Object)BUSINESS_NAME, (Object)business.realmGet$name());
            hashMap.put((Object)MOBILE, (Object)AppPref.getInstance().getMobile());
            hashMap.put((Object)COUNTRY, (Object)business.realmGet$country());
            hashMap.put((Object)LINK, (Object)business.realmGet$link());
            ((CleverTapAPI)Objects.requireNonNull((Object)CleverTapAPI.getDefaultInstance((Context)context))).pushProfile((Map)hashMap);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

