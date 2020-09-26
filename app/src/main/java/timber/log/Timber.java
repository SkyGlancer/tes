/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.timber.log;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Timber {
    private static final List<Tree> FOREST;
    private static final Tree[] TREE_ARRAY_EMPTY;
    private static final Tree TREE_OF_SOULS;
    static volatile Tree[] forestAsArray;

    static {
        TREE_ARRAY_EMPTY = new Tree[0];
        FOREST = new ArrayList();
        forestAsArray = TREE_ARRAY_EMPTY;
        TREE_OF_SOULS = new Tree(){

            @Override
            public /* varargs */ void d(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].d(string2, arrobject);
                }
            }

            @Override
            public void d(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].d(throwable);
                }
            }

            @Override
            public /* varargs */ void d(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].d(throwable, string2, arrobject);
                }
            }

            @Override
            public /* varargs */ void e(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].e(string2, arrobject);
                }
            }

            @Override
            public void e(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].e(throwable);
                }
            }

            @Override
            public /* varargs */ void e(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].e(throwable, string2, arrobject);
                }
            }

            @Override
            public /* varargs */ void i(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].i(string2, arrobject);
                }
            }

            @Override
            public void i(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].i(throwable);
                }
            }

            @Override
            public /* varargs */ void i(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].i(throwable, string2, arrobject);
                }
            }

            @Override
            protected void log(int n, String string2, String string3, Throwable throwable) {
                throw new AssertionError((Object)"Missing override for log method.");
            }

            @Override
            public /* varargs */ void log(int n, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n2 = arrtree.length;
                for (int i = 0; i < n2; ++i) {
                    arrtree[i].log(n, string2, arrobject);
                }
            }

            @Override
            public void log(int n, Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n2 = arrtree.length;
                for (int i = 0; i < n2; ++i) {
                    arrtree[i].log(n, throwable);
                }
            }

            @Override
            public /* varargs */ void log(int n, Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n2 = arrtree.length;
                for (int i = 0; i < n2; ++i) {
                    arrtree[i].log(n, throwable, string2, arrobject);
                }
            }

            @Override
            public /* varargs */ void v(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].v(string2, arrobject);
                }
            }

            @Override
            public void v(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].v(throwable);
                }
            }

            @Override
            public /* varargs */ void v(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].v(throwable, string2, arrobject);
                }
            }

            @Override
            public /* varargs */ void w(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].w(string2, arrobject);
                }
            }

            @Override
            public void w(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].w(throwable);
                }
            }

            @Override
            public /* varargs */ void w(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].w(throwable, string2, arrobject);
                }
            }

            @Override
            public /* varargs */ void wtf(String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].wtf(string2, arrobject);
                }
            }

            @Override
            public void wtf(Throwable throwable) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].wtf(throwable);
                }
            }

            @Override
            public /* varargs */ void wtf(Throwable throwable, String string2, Object ... arrobject) {
                Tree[] arrtree = Timber.forestAsArray;
                int n = arrtree.length;
                for (int i = 0; i < n; ++i) {
                    arrtree[i].wtf(throwable, string2, arrobject);
                }
            }
        };
    }

    private Timber() {
        throw new AssertionError((Object)"No instances.");
    }

    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static /* varargs */ void d(String string2, Object ... arrobject) {
        TREE_OF_SOULS.d(string2, arrobject);
    }

    public static void d(Throwable throwable) {
        TREE_OF_SOULS.d(throwable);
    }

    public static /* varargs */ void d(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.d(throwable, string2, arrobject);
    }

    public static /* varargs */ void e(String string2, Object ... arrobject) {
        TREE_OF_SOULS.e(string2, arrobject);
    }

    public static void e(Throwable throwable) {
        TREE_OF_SOULS.e(throwable);
    }

    public static /* varargs */ void e(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.e(throwable, string2, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<Tree> forest() {
        List<Tree> list;
        List<Tree> list2 = list = FOREST;
        synchronized (list2) {
            return Collections.unmodifiableList((List)new ArrayList(FOREST));
        }
    }

    public static /* varargs */ void i(String string2, Object ... arrobject) {
        TREE_OF_SOULS.i(string2, arrobject);
    }

    public static void i(Throwable throwable) {
        TREE_OF_SOULS.i(throwable);
    }

    public static /* varargs */ void i(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.i(throwable, string2, arrobject);
    }

    public static /* varargs */ void log(int n, String string2, Object ... arrobject) {
        TREE_OF_SOULS.log(n, string2, arrobject);
    }

    public static void log(int n, Throwable throwable) {
        TREE_OF_SOULS.log(n, throwable);
    }

    public static /* varargs */ void log(int n, Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.log(n, throwable, string2, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void plant(Tree tree) {
        if (tree == null) {
            throw new NullPointerException("tree == null");
        }
        if (tree != TREE_OF_SOULS) {
            List<Tree> list;
            List<Tree> list2 = list = FOREST;
            synchronized (list2) {
                FOREST.add((Object)tree);
                forestAsArray = (Tree[])FOREST.toArray((Object[])new Tree[FOREST.size()]);
                return;
            }
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* varargs */ void plant(Tree ... arrtree) {
        if (arrtree == null) {
            NullPointerException nullPointerException = new NullPointerException("trees == null");
            throw nullPointerException;
        }
        int n = arrtree.length;
        int n2 = 0;
        do {
            if (n2 >= n) {
                List<Tree> list;
                List<Tree> list2 = list = FOREST;
                synchronized (list2) {
                    Collections.addAll(FOREST, (Object[])arrtree);
                    forestAsArray = (Tree[])FOREST.toArray((Object[])new Tree[FOREST.size()]);
                    return;
                }
            }
            Tree tree = arrtree[n2];
            if (tree == null) throw new NullPointerException("trees contains null");
            if (tree == TREE_OF_SOULS) throw new IllegalArgumentException("Cannot plant Timber into itself.");
            ++n2;
        } while (true);
    }

    public static Tree tag(String string2) {
        Tree[] arrtree = forestAsArray;
        int n = arrtree.length;
        for (int i = 0; i < n; ++i) {
            arrtree[i].explicitTag.set((Object)string2);
        }
        return TREE_OF_SOULS;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int treeCount() {
        List<Tree> list;
        List<Tree> list2 = list = FOREST;
        synchronized (list2) {
            return FOREST.size();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void uproot(Tree tree) {
        List<Tree> list;
        List<Tree> list2 = list = FOREST;
        synchronized (list2) {
            if (FOREST.remove((Object)tree)) {
                forestAsArray = (Tree[])FOREST.toArray((Object[])new Tree[FOREST.size()]);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot uproot tree which is not planted: ");
            stringBuilder.append((Object)tree);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void uprootAll() {
        List<Tree> list;
        List<Tree> list2 = list = FOREST;
        synchronized (list2) {
            FOREST.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
            return;
        }
    }

    public static /* varargs */ void v(String string2, Object ... arrobject) {
        TREE_OF_SOULS.v(string2, arrobject);
    }

    public static void v(Throwable throwable) {
        TREE_OF_SOULS.v(throwable);
    }

    public static /* varargs */ void v(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.v(throwable, string2, arrobject);
    }

    public static /* varargs */ void w(String string2, Object ... arrobject) {
        TREE_OF_SOULS.w(string2, arrobject);
    }

    public static void w(Throwable throwable) {
        TREE_OF_SOULS.w(throwable);
    }

    public static /* varargs */ void w(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.w(throwable, string2, arrobject);
    }

    public static /* varargs */ void wtf(String string2, Object ... arrobject) {
        TREE_OF_SOULS.wtf(string2, arrobject);
    }

    public static void wtf(Throwable throwable) {
        TREE_OF_SOULS.wtf(throwable);
    }

    public static /* varargs */ void wtf(Throwable throwable, String string2, Object ... arrobject) {
        TREE_OF_SOULS.wtf(throwable, string2, arrobject);
    }

    public static class DebugTree
    extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile((String)"(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        protected String createStackElementTag(StackTraceElement stackTraceElement) {
            String string2;
            String string3 = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher((CharSequence)string3);
            if (matcher.find()) {
                string3 = matcher.replaceAll("");
            }
            if ((string2 = string3.substring(1 + string3.lastIndexOf(46))).length() > 23) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return string2;
                }
                string2 = string2.substring(0, 23);
            }
            return string2;
        }

        @Override
        final String getTag() {
            String string2 = super.getTag();
            if (string2 != null) {
                return string2;
            }
            StackTraceElement[] arrstackTraceElement = new Throwable().getStackTrace();
            if (arrstackTraceElement.length > 5) {
                return this.createStackElementTag(arrstackTraceElement[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        @Override
        protected void log(int n, String string2, String string3, Throwable throwable) {
            if (string3.length() < 4000) {
                if (n == 7) {
                    Log.wtf((String)string2, (String)string3);
                    return;
                }
                Log.println((int)n, (String)string2, (String)string3);
                return;
            }
            int n2 = 0;
            int n3 = string3.length();
            block0 : while (n2 < n3) {
                int n4 = string3.indexOf(10, n2);
                if (n4 == -1) {
                    n4 = n3;
                }
                do {
                    int n5 = Math.min((int)n4, (int)(n2 + 4000));
                    String string4 = string3.substring(n2, n5);
                    if (n == 7) {
                        Log.wtf((String)string2, (String)string4);
                    } else {
                        Log.println((int)n, (String)string2, (String)string4);
                    }
                    if (n5 >= n4) {
                        n2 = n5 + 1;
                        continue block0;
                    }
                    n2 = n5;
                } while (true);
            }
        }
    }

    public static abstract class Tree {
        final ThreadLocal<String> explicitTag = new ThreadLocal();

        private String getStackTraceString(Throwable throwable) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer)stringWriter, false);
            throwable.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private /* varargs */ void prepareLog(int n, Throwable throwable, String string2, Object ... arrobject) {
            String string3 = this.getTag();
            if (!this.isLoggable(string3, n)) {
                return;
            }
            if (string2 != null && string2.length() == 0) {
                string2 = null;
            }
            if (string2 == null) {
                if (throwable == null) {
                    return;
                }
                string2 = this.getStackTraceString(throwable);
            } else {
                if (arrobject != null && arrobject.length > 0) {
                    string2 = this.formatMessage(string2, arrobject);
                }
                if (throwable != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append("\n");
                    stringBuilder.append(this.getStackTraceString(throwable));
                    string2 = stringBuilder.toString();
                }
            }
            this.log(n, string3, string2, throwable);
        }

        public /* varargs */ void d(String string2, Object ... arrobject) {
            this.prepareLog(3, null, string2, arrobject);
        }

        public void d(Throwable throwable) {
            this.prepareLog(3, throwable, null, new Object[0]);
        }

        public /* varargs */ void d(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(3, throwable, string2, arrobject);
        }

        public /* varargs */ void e(String string2, Object ... arrobject) {
            this.prepareLog(6, null, string2, arrobject);
        }

        public void e(Throwable throwable) {
            this.prepareLog(6, throwable, null, new Object[0]);
        }

        public /* varargs */ void e(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(6, throwable, string2, arrobject);
        }

        protected String formatMessage(String string2, Object[] arrobject) {
            return String.format((String)string2, (Object[])arrobject);
        }

        String getTag() {
            String string2 = (String)this.explicitTag.get();
            if (string2 != null) {
                this.explicitTag.remove();
            }
            return string2;
        }

        public /* varargs */ void i(String string2, Object ... arrobject) {
            this.prepareLog(4, null, string2, arrobject);
        }

        public void i(Throwable throwable) {
            this.prepareLog(4, throwable, null, new Object[0]);
        }

        public /* varargs */ void i(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(4, throwable, string2, arrobject);
        }

        @Deprecated
        protected boolean isLoggable(int n) {
            return true;
        }

        protected boolean isLoggable(String string2, int n) {
            return this.isLoggable(n);
        }

        protected abstract void log(int var1, String var2, String var3, Throwable var4);

        public /* varargs */ void log(int n, String string2, Object ... arrobject) {
            this.prepareLog(n, null, string2, arrobject);
        }

        public void log(int n, Throwable throwable) {
            this.prepareLog(n, throwable, null, new Object[0]);
        }

        public /* varargs */ void log(int n, Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(n, throwable, string2, arrobject);
        }

        public /* varargs */ void v(String string2, Object ... arrobject) {
            this.prepareLog(2, null, string2, arrobject);
        }

        public void v(Throwable throwable) {
            this.prepareLog(2, throwable, null, new Object[0]);
        }

        public /* varargs */ void v(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(2, throwable, string2, arrobject);
        }

        public /* varargs */ void w(String string2, Object ... arrobject) {
            this.prepareLog(5, null, string2, arrobject);
        }

        public void w(Throwable throwable) {
            this.prepareLog(5, throwable, null, new Object[0]);
        }

        public /* varargs */ void w(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(5, throwable, string2, arrobject);
        }

        public /* varargs */ void wtf(String string2, Object ... arrobject) {
            this.prepareLog(7, null, string2, arrobject);
        }

        public void wtf(Throwable throwable) {
            this.prepareLog(7, throwable, null, new Object[0]);
        }

        public /* varargs */ void wtf(Throwable throwable, String string2, Object ... arrobject) {
            this.prepareLog(7, throwable, string2, arrobject);
        }
    }

}

