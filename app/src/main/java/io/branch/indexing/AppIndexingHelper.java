/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.google.android.gms.tasks.Task
 *  com.google.firebase.appindexing.Action
 *  com.google.firebase.appindexing.Action$Builder
 *  com.google.firebase.appindexing.Action$Metadata
 *  com.google.firebase.appindexing.Action$Metadata$Builder
 *  com.google.firebase.appindexing.FirebaseAppIndex
 *  com.google.firebase.appindexing.FirebaseUserActions
 *  com.google.firebase.appindexing.Indexable
 *  com.google.firebase.appindexing.builders.Indexables
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package app.dukhaan.src.java.io.branch.indexing;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseUserActions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.PrefHelper;
import io.branch.referral.util.LinkProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class AppIndexingHelper {
    private static final LinkProperties DEF_LINK_PROPERTIES = new LinkProperties().setChannel("google_search");
    private static FirebaseUserActions firebaseUserActionsInstance;

    AppIndexingHelper() {
    }

    static /* synthetic */ FirebaseUserActions access$000() {
        return firebaseUserActionsInstance;
    }

    static /* synthetic */ FirebaseUserActions access$002(FirebaseUserActions firebaseUserActions) {
        firebaseUserActionsInstance = firebaseUserActions;
        return firebaseUserActions;
    }

    static /* synthetic */ void access$200(String string2, BranchUniversalObject branchUniversalObject) {
        AppIndexingHelper.addToAppIndexUsingFirebase(string2, branchUniversalObject);
    }

    static /* synthetic */ void access$300(String string2, Context context, BranchUniversalObject branchUniversalObject) throws Exception {
        AppIndexingHelper.listOnGoogleSearch(string2, context, branchUniversalObject);
    }

    static void addToAppIndex(final Context context, final BranchUniversalObject branchUniversalObject, final LinkProperties linkProperties) {
        new Thread(new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64 : RETURN : trying to set 0 previously set to 1
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
        }).start();
    }

    private static void addToAppIndexUsingFirebase(String string2, BranchUniversalObject branchUniversalObject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(branchUniversalObject.getTitle());
        stringBuilder.append("\n");
        stringBuilder.append(branchUniversalObject.getDescription());
        String string3 = stringBuilder.toString();
        if (branchUniversalObject.isLocallyIndexable()) {
            Indexable indexable = Indexables.newSimple((String)string3, (String)string2);
            FirebaseAppIndex.getInstance().update(new Indexable[]{indexable});
        }
        Action action = new Action.Builder("ViewAction").setObject(string3, string2).setMetadata(new Action.Metadata.Builder().setUpload(branchUniversalObject.isPublicallyIndexable())).build();
        firebaseUserActionsInstance.end(action);
    }

    private static void listOnGoogleSearch(String string2, Context context, BranchUniversalObject branchUniversalObject) throws Exception {
        Class class_ = Class.forName((String)"com.google.android.gms.appindexing.Thing");
        Class class_2 = Class.forName((String)"com.google.android.gms.appindexing.Thing$Builder");
        Object object = class_2.getConstructor(new Class[0]).newInstance(new Object[0]);
        Method method = class_2.getMethod("setName", new Class[]{String.class});
        Method method2 = class_2.getMethod("setDescription", new Class[]{String.class});
        Method method3 = class_2.getMethod("setUrl", new Class[]{Uri.class});
        Method method4 = class_2.getMethod("build", new Class[0]);
        Object[] arrobject = new Object[]{branchUniversalObject.getTitle()};
        method.invoke(object, arrobject);
        Object[] arrobject2 = new Object[]{branchUniversalObject.getDescription()};
        method2.invoke(object, arrobject2);
        Object[] arrobject3 = new Object[]{Uri.parse((String)string2)};
        method3.invoke(object, arrobject3);
        Object object2 = method4.invoke(object, new Object[0]);
        Class class_3 = Class.forName((String)"com.google.android.gms.appindexing.Action");
        Class class_4 = Class.forName((String)"com.google.android.gms.appindexing.Action$Builder");
        Constructor constructor = class_4.getConstructor(new Class[]{String.class});
        Object[] arrobject4 = new Object[]{(String)class_3.getDeclaredField("TYPE_VIEW").get(null)};
        Object object3 = constructor.newInstance(arrobject4);
        Method method5 = class_4.getMethod("setObject", new Class[]{class_});
        Method method6 = class_4.getMethod("setActionStatus", new Class[]{String.class});
        Method method7 = class_4.getMethod("build", new Class[0]);
        method5.invoke(object3, new Object[]{object2});
        Object[] arrobject5 = new Object[]{(String)class_3.getDeclaredField("STATUS_TYPE_COMPLETED").get(null)};
        method6.invoke(object3, arrobject5);
        Object object4 = method7.invoke(object3, new Object[0]);
        Class class_5 = Class.forName((String)"com.google.android.gms.appindexing.AppIndex");
        Class class_6 = Class.forName((String)"com.google.android.gms.common.api.Api");
        Class class_7 = Class.forName((String)"com.google.android.gms.common.api.GoogleApiClient");
        Class class_8 = Class.forName((String)"com.google.android.gms.common.api.GoogleApiClient$Builder");
        Object object5 = class_8.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        Method method8 = class_8.getMethod("addApi", new Class[]{class_6});
        Method method9 = class_8.getMethod("build", new Class[0]);
        Method method10 = class_7.getMethod("connect", new Class[0]);
        Method method11 = class_7.getMethod("disconnect", new Class[0]);
        Object[] arrobject6 = new Object[]{class_6.cast(class_5.getDeclaredField("API").get(null))};
        method8.invoke(object5, arrobject6);
        Object object6 = method9.invoke(object5, new Object[0]);
        method10.invoke(object6, new Object[0]);
        Class class_9 = Class.forName((String)"com.google.android.gms.appindexing.AppIndexApi");
        Object object7 = class_5.getDeclaredField("AppIndexApi").get(null);
        class_9.getMethod("start", new Class[]{class_7, class_3}).invoke(object7, new Object[]{object6, object4});
        method11.invoke(object6, new Object[0]);
    }

    static void removeFromFirebaseLocalIndex(final Context context, final BranchUniversalObject branchUniversalObject, final LinkProperties linkProperties) {
        new Thread(new Runnable(){

            public void run() {
                try {
                    String string2 = linkProperties == null ? branchUniversalObject.getShortUrl(context, DEF_LINK_PROPERTIES) : branchUniversalObject.getShortUrl(context, linkProperties);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Removing indexed BranchUniversalObject with link ");
                    stringBuilder.append(string2);
                    PrefHelper.Debug(stringBuilder.toString());
                    FirebaseAppIndex.getInstance().remove(new String[]{string2});
                    return;
                }
                catch (Throwable throwable) {
                    PrefHelper.Debug("Failed to index your contents using Firebase. Please make sure Firebase is enabled and initialised in your app");
                    return;
                }
                catch (NoClassDefFoundError noClassDefFoundError) {
                    PrefHelper.Debug("Failed to remove the BranchUniversalObject from Firebase local indexing. Please make sure Firebase is enabled and initialised in your app");
                    return;
                }
            }
        }).run();
    }

}

