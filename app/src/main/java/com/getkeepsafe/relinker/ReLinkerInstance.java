/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.getkeepsafe.relinker.ApkLibraryInstaller
 *  com.getkeepsafe.relinker.SystemLibraryLoader
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.UnsatisfiedLinkError
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 */
package app.dukhaan.src.java.com.getkeepsafe.relinker;

import android.content.Context;
import com.getkeepsafe.relinker.ApkLibraryInstaller;
import com.getkeepsafe.relinker.MissingLibraryException;
import com.getkeepsafe.relinker.ReLinker;
import com.getkeepsafe.relinker.SystemLibraryLoader;
import com.getkeepsafe.relinker.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance {
    private static final String LIB_DIR = "lib";
    protected boolean force;
    protected final ReLinker.LibraryInstaller libraryInstaller;
    protected final ReLinker.LibraryLoader libraryLoader;
    protected final Set<String> loadedLibraries = new HashSet();
    protected ReLinker.Logger logger;
    protected boolean recursive;

    protected ReLinkerInstance() {
        this((ReLinker.LibraryLoader)new SystemLibraryLoader(), (ReLinker.LibraryInstaller)new ApkLibraryInstaller());
    }

    protected ReLinkerInstance(ReLinker.LibraryLoader libraryLoader, ReLinker.LibraryInstaller libraryInstaller) {
        if (libraryLoader != null) {
            if (libraryInstaller != null) {
                this.libraryLoader = libraryLoader;
                this.libraryInstaller = libraryInstaller;
                return;
            }
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        throw new IllegalArgumentException("Cannot pass null library loader");
    }

    /*
     * Exception decompiling
     */
    private void loadLibraryInternal(Context var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl151.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    protected void cleanupOldLibFiles(Context context, String string2, String string3) {
        File file = this.getWorkaroundLibDir(context);
        File file2 = this.getWorkaroundLibFile(context, string2, string3);
        File[] arrfile = file.listFiles(new FilenameFilter(this.libraryLoader.mapLibraryName(string2)){
            final /* synthetic */ String val$mappedLibraryName;
            {
                this.val$mappedLibraryName = string2;
            }

            public boolean accept(File file, String string2) {
                return string2.startsWith(this.val$mappedLibraryName);
            }
        });
        if (arrfile == null) {
            return;
        }
        for (File file3 : arrfile) {
            if (!this.force && file3.getAbsolutePath().equals((Object)file2.getAbsolutePath())) continue;
            file3.delete();
        }
    }

    public ReLinkerInstance force() {
        this.force = true;
        return this;
    }

    protected File getWorkaroundLibDir(Context context) {
        return context.getDir(LIB_DIR, 0);
    }

    protected File getWorkaroundLibFile(Context context, String string2, String string3) {
        String string4 = this.libraryLoader.mapLibraryName(string2);
        if (TextUtils.isEmpty(string3)) {
            return new File(this.getWorkaroundLibDir(context), string4);
        }
        File file = this.getWorkaroundLibDir(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        return new File(file, stringBuilder.toString());
    }

    public void loadLibrary(Context context, String string2) {
        this.loadLibrary(context, string2, null, null);
    }

    public void loadLibrary(Context context, String string2, ReLinker.LoadListener loadListener) {
        this.loadLibrary(context, string2, null, loadListener);
    }

    public void loadLibrary(Context context, String string2, String string3) {
        this.loadLibrary(context, string2, string3, null);
    }

    public void loadLibrary(final Context context, final String string2, final String string3, final ReLinker.LoadListener loadListener) {
        if (context != null) {
            if (!TextUtils.isEmpty(string2)) {
                this.log("Beginning load of %s...", string2);
                if (loadListener == null) {
                    this.loadLibraryInternal(context, string2, string3);
                    return;
                }
                Runnable runnable = new Runnable(){

                    public void run() {
                        try {
                            ReLinkerInstance.this.loadLibraryInternal(context, string2, string3);
                            loadListener.success();
                            return;
                        }
                        catch (MissingLibraryException missingLibraryException) {
                            loadListener.failure((Throwable)missingLibraryException);
                            return;
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                            loadListener.failure(unsatisfiedLinkError);
                            return;
                        }
                    }
                };
                new Thread(runnable).start();
                return;
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public ReLinkerInstance log(ReLinker.Logger logger) {
        this.logger = logger;
        return this;
    }

    public void log(String string2) {
        ReLinker.Logger logger = this.logger;
        if (logger != null) {
            logger.log(string2);
        }
    }

    public /* varargs */ void log(String string2, Object ... arrobject) {
        this.log(String.format((Locale)Locale.US, (String)string2, (Object[])arrobject));
    }

    public ReLinkerInstance recursively() {
        this.recursive = true;
        return this;
    }

}

