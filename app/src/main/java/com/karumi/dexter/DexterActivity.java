/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 *  androidx.core.app.ActivityCompat
 *  androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.LinkedList
 */
package app.dukhaan.src.java.com.karumi.dexter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import com.karumi.dexter.Dexter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class DexterActivity
extends Activity
implements ActivityCompat.OnRequestPermissionsResultCallback {
    /*
     * Exception decompiling
     */
    private boolean isTargetSdkUnderAndroidM() {
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dexter.onActivityReady(this);
        this.getWindow().addFlags(16);
    }

    protected void onDestroy() {
        super.onDestroy();
        Dexter.onActivityDestroyed();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Dexter.onActivityReady(this);
    }

    public void onRequestPermissionsResult(int n, String[] arrstring, int[] arrn) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (this.isTargetSdkUnderAndroidM()) {
            linkedList2.addAll((Collection)Arrays.asList((Object[])arrstring));
        } else {
            for (int i = 0; i < arrstring.length; ++i) {
                String string2 = arrstring[i];
                int n2 = arrn[i];
                if (n2 != -2 && n2 != -1) {
                    if (n2 != 0) continue;
                    linkedList.add((Object)string2);
                    continue;
                }
                linkedList2.add((Object)string2);
            }
        }
        Dexter.onPermissionsRequested((Collection<String>)linkedList, (Collection<String>)linkedList2);
    }
}

