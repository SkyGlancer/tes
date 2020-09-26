/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    private LRUCache<String, Pattern> cache;

    public RegexCache(int n) {
        this.cache = new LRUCache(n);
    }

    boolean containsRegex(String string2) {
        return this.cache.containsKey(string2);
    }

    public Pattern getPatternForRegex(String string2) {
        Pattern pattern = this.cache.get(string2);
        if (pattern == null) {
            pattern = Pattern.compile((String)string2);
            this.cache.put(string2, pattern);
        }
        return pattern;
    }

    private static class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        private int size;

        public LRUCache(int n) {
            this.size = n;
            this.map = new LinkedHashMap<K, V>(1 + n * 4 / 3, 0.75f, true){

                protected boolean removeEldestEntry(Entry<K, V> entry) {
                    return this.size() > LRUCache.this.size;
                }
            };
        }

        public boolean containsKey(K k) {
            LRUCache lRUCache = this;
            synchronized (lRUCache) {
                boolean bl = this.map.containsKey(k);
                return bl;
            }
        }

        public V get(K k) {
            LRUCache lRUCache = this;
            synchronized (lRUCache) {
                Object object = this.map.get(k);
                return (V)object;
            }
        }

        public void put(K k, V v) {
            LRUCache lRUCache = this;
            synchronized (lRUCache) {
                this.map.put(k, v);
                return;
            }
        }

    }

}

