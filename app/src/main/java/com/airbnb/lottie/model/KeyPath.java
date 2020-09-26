/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List<String> keys;
    private KeyPathElement resolvedElement;

    private KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }

    public /* varargs */ KeyPath(String ... arrstring) {
        this.keys = Arrays.asList((Object[])arrstring);
    }

    private boolean endsWithGlobstar() {
        List<String> list = this.keys;
        return ((String)list.get(-1 + list.size())).equals((Object)"**");
    }

    private boolean isContainer(String string2) {
        return "__container".equals((Object)string2);
    }

    public KeyPath addKey(String string2) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add((Object)string2);
        return keyPath;
    }

    public boolean fullyResolvesTo(String string2, int n) {
        boolean bl;
        block13 : {
            boolean bl2;
            block15 : {
                block14 : {
                    block10 : {
                        boolean bl3;
                        block12 : {
                            boolean bl4;
                            block11 : {
                                if (n >= this.keys.size()) {
                                    return false;
                                }
                                bl = n == this.keys.size() - 1;
                                String string3 = (String)this.keys.get(n);
                                if (string3.equals((Object)"**")) break block10;
                                bl4 = string3.equals((Object)string2) || string3.equals((Object)"*");
                                if (bl) break block11;
                                int n2 = -2 + this.keys.size();
                                bl3 = false;
                                if (n != n2) break block12;
                                boolean bl5 = this.endsWithGlobstar();
                                bl3 = false;
                                if (!bl5) break block12;
                            }
                            bl3 = false;
                            if (bl4) {
                                bl3 = true;
                            }
                        }
                        return bl3;
                    }
                    boolean bl6 = !bl && ((String)this.keys.get(n + 1)).equals((Object)string2);
                    if (!bl6) break block13;
                    if (n == -2 + this.keys.size()) break block14;
                    int n3 = -3 + this.keys.size();
                    bl2 = false;
                    if (n != n3) break block15;
                    boolean bl7 = this.endsWithGlobstar();
                    bl2 = false;
                    if (!bl7) break block15;
                }
                bl2 = true;
            }
            return bl2;
        }
        if (bl) {
            return true;
        }
        int n4 = n + 1;
        if (n4 < this.keys.size() - 1) {
            return false;
        }
        return ((String)this.keys.get(n4)).equals((Object)string2);
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int incrementDepthBy(String string2, int n) {
        if (this.isContainer(string2)) {
            return 0;
        }
        if (!((String)this.keys.get(n)).equals((Object)"**")) {
            return 1;
        }
        if (n == this.keys.size() - 1) {
            return 0;
        }
        if (((String)this.keys.get(n + 1)).equals((Object)string2)) {
            return 2;
        }
        return 0;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public boolean matches(String string2, int n) {
        if (this.isContainer(string2)) {
            return true;
        }
        if (n >= this.keys.size()) {
            return false;
        }
        if (!((String)this.keys.get(n)).equals((Object)string2) && !((String)this.keys.get(n)).equals((Object)"**")) {
            return ((String)this.keys.get(n)).equals((Object)"*");
        }
        return true;
    }

    public boolean propagateToChildren(String string2, int n) {
        boolean bl = "__container".equals((Object)string2);
        boolean bl2 = true;
        if (bl) {
            return bl2;
        }
        if (n >= this.keys.size() - bl2) {
            if (((String)this.keys.get(n)).equals((Object)"**")) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        stringBuilder.append(this.keys);
        stringBuilder.append(",resolved=");
        boolean bl = this.resolvedElement != null;
        stringBuilder.append(bl);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

