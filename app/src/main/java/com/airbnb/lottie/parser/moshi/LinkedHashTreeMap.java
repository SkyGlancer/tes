/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$EntrySet$1
 *  com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$KeySet$1
 *  java.io.ObjectStreamException
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

final class LinkedHashTreeMap<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>(){

        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo((Object)comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V> entrySet;
    final Node<K, V> header;
    private LinkedHashTreeMap<K, V> keySet;
    int modCount = 0;
    int size = 0;
    Node<K, V>[] table;
    int threshold;

    LinkedHashTreeMap() {
        this(null);
    }

    LinkedHashTreeMap(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
        this.header = new Node();
        Node[] arrnode = new Node[16];
        this.table = arrnode;
        this.threshold = arrnode.length / 2 + arrnode.length / 4;
    }

    private void doubleCapacity() {
        Node<K, V>[] arrnode = LinkedHashTreeMap.doubleCapacity(this.table);
        this.table = arrnode;
        this.threshold = arrnode.length / 2 + arrnode.length / 4;
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] arrnode) {
        int n = arrnode.length;
        Node[] arrnode2 = new Node[n * 2];
        AvlIterator<K, V> avlIterator = new AvlIterator<K, V>();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i = 0; i < n; ++i) {
            Node node;
            Node node2;
            Node<K, V> node3 = arrnode[i];
            if (node3 == null) continue;
            avlIterator.reset(node3);
            int n2 = 0;
            int n3 = 0;
            while ((node2 = avlIterator.next()) != null) {
                if ((n & node2.hash) == 0) {
                    ++n2;
                    continue;
                }
                ++n3;
            }
            avlBuilder.reset(n2);
            avlBuilder2.reset(n3);
            avlIterator.reset(node3);
            while ((node = avlIterator.next()) != null) {
                if ((n & node.hash) == 0) {
                    avlBuilder.add(node);
                    continue;
                }
                avlBuilder2.add(node);
            }
            Node node4 = n2 > 0 ? avlBuilder.root() : null;
            arrnode2[i] = node4;
            int n4 = i + n;
            Node node5 = null;
            if (n3 > 0) {
                node5 = avlBuilder2.root();
            }
            arrnode2[n4] = node5;
        }
        return arrnode2;
    }

    private boolean equal(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    private void rebalance(Node<K, V> node, boolean bl) {
        while (node != null) {
            Node node2;
            int n;
            Node node3 = node.left;
            int n2 = node3 != null ? node3.height : 0;
            int n3 = n2 - (n = (node2 = node.right) != null ? node2.height : 0);
            if (n3 == -2) {
                int n4;
                Node node4 = node2.left;
                Node node5 = node2.right;
                int n5 = node5 != null ? node5.height : 0;
                int n6 = 0;
                if (node4 != null) {
                    n6 = node4.height;
                }
                if ((n4 = n6 - n5) != -1 && (n4 != 0 || bl)) {
                    this.rotateRight(node2);
                    this.rotateLeft(node);
                } else {
                    this.rotateLeft(node);
                }
                if (bl) {
                    return;
                }
            } else if (n3 == 2) {
                int n7;
                Node node6 = node3.left;
                Node node7 = node3.right;
                int n8 = node7 != null ? node7.height : 0;
                int n9 = 0;
                if (node6 != null) {
                    n9 = node6.height;
                }
                if ((n7 = n9 - n8) != 1 && (n7 != 0 || bl)) {
                    this.rotateLeft(node3);
                    this.rotateRight(node);
                } else {
                    this.rotateRight(node);
                }
                if (bl) {
                    return;
                }
            } else if (n3 == 0) {
                node.height = n2 + 1;
                if (bl) {
                    return;
                }
            } else {
                node.height = 1 + Math.max((int)n2, (int)n);
                if (!bl) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
                return;
            }
            node3.right = node2;
            return;
        }
        int n = node.hash;
        Node<K, V>[] arrnode = this.table;
        arrnode[n & -1 + arrnode.length] = node2;
    }

    private void rotateLeft(Node<K, V> node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        this.replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int n = node2 != null ? node2.height : 0;
        int n2 = node4 != null ? node4.height : 0;
        int n3 = node.height = 1 + Math.max((int)n, (int)n2);
        int n4 = 0;
        if (node5 != null) {
            n4 = node5.height;
        }
        node3.height = 1 + Math.max((int)n3, (int)n4);
    }

    private void rotateRight(Node<K, V> node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        this.replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int n = node3 != null ? node3.height : 0;
        int n2 = node5 != null ? node5.height : 0;
        int n3 = node.height = 1 + Math.max((int)n, (int)n2);
        int n4 = 0;
        if (node4 != null) {
            n4 = node4.height;
        }
        node2.height = 1 + Math.max((int)n3, (int)n4);
    }

    private static int secondaryHash(int n) {
        int n2 = n ^ (n >>> 20 ^ n >>> 12);
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap((Map)this);
    }

    public void clear() {
        Arrays.fill((Object[])this.table, null);
        this.size = 0;
        this.modCount = 1 + this.modCount;
        Node<K, V> node = this.header;
        Node node2 = node.next;
        while (node2 != node) {
            Node node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object object) {
        return this.findByObject(object) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V> linkedHashTreeMap = this.entrySet;
        if (linkedHashTreeMap != null) {
            return linkedHashTreeMap;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    Node<K, V> find(K k, boolean bl) {
        Node<K, V> node;
        Comparator<? super K> comparator;
        int n;
        int n2;
        Node<K, V> node2;
        block11 : {
            comparator = this.comparator;
            Node<K, V>[] arrnode = this.table;
            n = LinkedHashTreeMap.secondaryHash(k.hashCode());
            int n3 = n & arrnode.length - 1;
            Node<K, V> node3 = arrnode[n3];
            if (node3 != null) {
                Comparable comparable = comparator == NATURAL_ORDER ? (Comparable)k : null;
                do {
                    int n4;
                    if ((n4 = comparable != null ? comparable.compareTo(node3.key) : comparator.compare(k, node3.key)) == 0) {
                        return node3;
                    }
                    Node node4 = n4 < 0 ? node3.left : node3.right;
                    if (node4 == null) {
                        node2 = node3;
                        n2 = n4;
                        break block11;
                    }
                    node3 = node4;
                } while (true);
            }
            node2 = node3;
            n2 = 0;
        }
        if (!bl) {
            return null;
        }
        Node<K, V> node5 = this.header;
        if (node2 == null) {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k.getClass().getName());
                stringBuilder.append(" is not Comparable");
                throw new ClassCastException(stringBuilder.toString());
            }
            Node node6 = node5.prev;
            node = new Node<K, V>(node2, k, n, node5, node6);
            arrnode[n3] = node;
        } else {
            Node node7 = node5.prev;
            node = new Node<K, V>(node2, k, n, node5, node7);
            if (n2 < 0) {
                node2.left = node;
            } else {
                node2.right = node;
            }
            this.rebalance(node2, true);
        }
        int n5 = this.size;
        this.size = n5 + 1;
        if (n5 > this.threshold) {
            this.doubleCapacity();
        }
        this.modCount = 1 + this.modCount;
        return node;
    }

    Node<K, V> findByEntry(Entry<?, ?> entry) {
        Node<K, V> node = this.findByObject(entry.getKey());
        boolean bl = node != null && this.equal(node.value, entry.getValue());
        if (bl) {
            return node;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    Node<K, V> findByObject(Object var1) {
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

    public V get(Object object) {
        Node<K, V> node = this.findByObject(object);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V> linkedHashTreeMap = this.keySet;
        if (linkedHashTreeMap != null) {
            return linkedHashTreeMap;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    public V put(K k, V v) {
        if (k != null) {
            Node<K, V> node = this.find(k, true);
            Object v2 = node.value;
            node.value = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object object) {
        Node<K, V> node = this.removeInternalByKey(object);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    void removeInternal(Node<K, V> node, boolean bl) {
        if (bl) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node.parent;
        if (node2 != null && node3 != null) {
            int n;
            Node node5 = node2.height > node3.height ? node2.last() : node3.first();
            this.removeInternal(node5, false);
            Node node6 = node.left;
            if (node6 != null) {
                n = node6.height;
                node5.left = node6;
                node6.parent = node5;
                node.left = null;
            } else {
                n = 0;
            }
            Node node7 = node.right;
            int n2 = 0;
            if (node7 != null) {
                n2 = node7.height;
                node5.right = node7;
                node7.parent = node5;
                node.right = null;
            }
            node5.height = 1 + Math.max((int)n, (int)n2);
            this.replaceInParent(node, node5);
            return;
        }
        if (node2 != null) {
            this.replaceInParent(node, node2);
            node.left = null;
        } else if (node3 != null) {
            this.replaceInParent(node, node3);
            node.right = null;
        } else {
            this.replaceInParent(node, null);
        }
        this.rebalance(node4, false);
        this.size = -1 + this.size;
        this.modCount = 1 + this.modCount;
    }

    Node<K, V> removeInternalByKey(Object object) {
        Node<K, V> node = this.findByObject(object);
        if (node != null) {
            this.removeInternal(node, true);
        }
        return node;
    }

    public int size() {
        return this.size;
    }

    static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        AvlBuilder() {
        }

        void add(Node<K, V> node) {
            int n;
            int n2;
            int n3;
            int n4;
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int n5 = this.leavesToSkip;
            if (n5 > 0 && ((n2 = this.size) & 1) == 0) {
                this.size = n2 + 1;
                this.leavesToSkip = n5 - 1;
                this.leavesSkipped = 1 + this.leavesSkipped;
            }
            node.parent = this.stack;
            this.stack = node;
            this.size = n3 = 1 + this.size;
            int n6 = this.leavesToSkip;
            if (n6 > 0 && (n3 & 1) == 0) {
                this.size = n3 + 1;
                this.leavesToSkip = n6 - 1;
                this.leavesSkipped = 1 + this.leavesSkipped;
            }
            int n7 = 4;
            while (((n = this.size) & (n4 = n7 - 1)) == n4) {
                int n8 = this.leavesSkipped;
                if (n8 == 0) {
                    Node<K, V> node2 = this.stack;
                    Node node3 = node2.parent;
                    Node node4 = node3.parent;
                    node3.parent = node4.parent;
                    this.stack = node3;
                    node3.left = node4;
                    node3.right = node2;
                    node3.height = 1 + node2.height;
                    node4.parent = node3;
                    node2.parent = node3;
                } else if (n8 == 1) {
                    Node<K, V> node5 = this.stack;
                    Node node6 = node5.parent;
                    this.stack = node6;
                    node6.right = node5;
                    node6.height = 1 + node5.height;
                    node5.parent = node6;
                    this.leavesSkipped = 0;
                } else if (n8 == 2) {
                    this.leavesSkipped = 0;
                }
                n7 *= 2;
            }
        }

        void reset(int n) {
            this.leavesToSkip = -1 + 2 * Integer.highestOneBit((int)n) - n;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        Node<K, V> root() {
            Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        AvlIterator() {
        }

        public Node<K, V> next() {
            Node node;
            Node<K, V> node2 = this.stackTop;
            if (node2 == null) {
                return null;
            }
            Node node3 = node2.parent;
            node2.parent = null;
            Node node4 = node2.right;
            do {
                node = node3;
                node3 = node4;
                if (node3 == null) break;
                node3.parent = node;
                node4 = node3.left;
            } while (true);
            this.stackTop = node;
            return node2;
        }

        void reset(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (node != null) {
                node.parent = node2;
                Node node3 = node.left;
                node2 = node;
                node = node3;
            }
            this.stackTop = node2;
        }
    }

    final class EntrySet
    extends AbstractSet<Entry<K, V>> {
        EntrySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object object) {
            return object instanceof Map.Entry && LinkedHashTreeMap.this.findByEntry((Entry)object) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new 1(this);
        }

        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Node node = LinkedHashTreeMap.this.findByEntry((Entry)object);
            if (node == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(node, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    final class KeySet
    extends AbstractSet<K> {
        KeySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object object) {
            return LinkedHashTreeMap.this.containsKey(object);
        }

        public Iterator<K> iterator() {
            return new 1(this);
        }

        public boolean remove(Object object) {
            return LinkedHashTreeMap.this.removeInternalByKey(object) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    abstract class LinkedTreeMapIterator<T>
    implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;

        LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }

        final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            if (node != LinkedHashTreeMap.this.header) {
                if (LinkedHashTreeMap.this.modCount == this.expectedModCount) {
                    this.next = node.next;
                    this.lastReturned = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedHashTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static final class Node<K, V>
    implements Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> node, K k, int n, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.hash = n;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        public boolean equals(Object object) {
            boolean bl;
            block2 : {
                block6 : {
                    Entry entry;
                    V v;
                    block5 : {
                        block4 : {
                            K k;
                            block3 : {
                                boolean bl2 = object instanceof Map.Entry;
                                bl = false;
                                if (!bl2) break block2;
                                entry = (Entry)object;
                                k = this.key;
                                if (k != null) break block3;
                                Object object2 = entry.getKey();
                                bl = false;
                                if (object2 != null) break block2;
                                break block4;
                            }
                            boolean bl3 = k.equals(entry.getKey());
                            bl = false;
                            if (!bl3) break block2;
                        }
                        v = this.value;
                        if (v != null) break block5;
                        Object object3 = entry.getValue();
                        bl = false;
                        if (object3 != null) break block2;
                        break block6;
                    }
                    boolean bl4 = v.equals(entry.getValue());
                    bl = false;
                    if (!bl4) break block2;
                }
                bl = true;
            }
            return bl;
        }

        public Node<K, V> first() {
            Node<K, V> node = this.left;
            Node<K, V> node2 = this;
            while (node != null) {
                Node<K, V> node3 = node.left;
                node2 = node;
                node = node3;
            }
            return node2;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k = this.key;
            int n = k == null ? 0 : k.hashCode();
            V v = this.value;
            int n2 = v == null ? 0 : v.hashCode();
            return n ^ n2;
        }

        public Node<K, V> last() {
            Node<K, V> node = this.right;
            Node<K, V> node2 = this;
            while (node != null) {
                Node<K, V> node3 = node.right;
                node2 = node;
                node = node3;
            }
            return node2;
        }

        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.key);
            stringBuilder.append("=");
            stringBuilder.append(this.value);
            return stringBuilder.toString();
        }
    }

}

