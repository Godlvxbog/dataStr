//package collectionImple.map;
//
////
/////**
//// *
//// * 在详细介绍HashMap的代码之前，我们需要了解：HashMap就是一个散列表
//// * ，它是通过“拉链法”解决哈希冲突的。
//// 还需要再补充说明的一点是影响HashMap性能的有两个参数：初始容量(initialCapacity)
//// 和加载因子(loadFactor)。
//// 容量 是哈希表中桶的数量，初始容量只是哈希表在创建时的容量。
//// 加载因子 是哈希表在其容量自动增加之前可以达到多满的一种尺度。
//// 当哈希表中的条目数超出了加载因子与当前容量的乘积时，
//// 则要对该哈希表进行 rehash 操作（
////
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Set;
//
//public class HashMapImpl implements Map<K,V> ,Serializable{
//
//    static class Entry<K,V> implements Map.Entry<K,V> {
//        final K key;
//        V value;
//        Entry<K, V> next;
//        int hash;
//
//        /**
//         * Creates new entry.
//         */
//        Entry(int h, K k, V v, Entry<K, V> n) {
//            value = v;
//            next = n;
//            key = k;
//            hash = h;
//        }
//
//
//        public final boolean equals(Object o) {
//            if (!(o instanceof Map.Entry))
//                return false;
//            Map.Entry e = (Map.Entry)o;
//            Object k1 = getKey();
//            Object k2 = e.getKey();
//            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
//                Object v1 = getValue();
//                Object v2 = e.getValue();
//                if (v1 == v2 || (v1 != null && v1.equals(v2)))
//                    return true;
//            }
//            return false;
//        }
//
//
//        @Override
//        public K getKey() {
//            return null;
//        }
//
//        @Override
//        public V getValue() {
//            return null;
//        }
//
//        @Override
//        public V setValue(V value) {
//            return null;
//        }
//    }
//
//    static final int DEFAULT_INITIAL_CPACITY =16;
//    static final int MAXIMUM_CAPACITY  =1 << 30;
//    static final float DEFAULT_LOAD_FACTOR  =0.75f;
//    static Map.Entry[] table;//一个键值对的数组
//    int size = 0;
//    int threshold;//threshold = 容量 * 加载因子
//    float loadFactor;
//
//    int hashSeed = 0;
//
//
//    /**
//     * 1新建一个比初始化（2的n次方的最小）大capacity的Entry容器,
//     * 2并更新出其threshold，
//     * 3,新家一个Entry[] 数组
//     * @param initialCapa
//     * @param laodFactor
//     */
//    public HashMapImpl(int initialCapa, float laodFactor){
//        if (initialCapa < 0){
//            throw new IllegalArgumentException();
//        }
//
//        if (initialCapa >MAXIMUM_CAPACITY){
//            initialCapa = MAXIMUM_CAPACITY;//不能再扩大了
//        }
//
//        int capacity =1;
//        //找出大于初始化capa的最小的溟
//        while (capacity < initialCapa){
//            capacity <<= 1;
//        }
//        //设置加载因子
//        this.loadFactor = laodFactor;
//        threshold = (int) (capacity * loadFactor);
//        table = new Map.Entry[capacity];
//
//    }
//
//    /**
//     * 指定大小的构造函数
//     * @param initCapa
//     */
//    public HashMapImpl(int initCapa){
//        this(initCapa,DEFAULT_LOAD_FACTOR);
//    }
//
//    public int  size(){
//        return size();
//    }
//
//    final int hash(Object k) {
//        int h = hashSeed;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }
//
//        h ^= k.hashCode();
//
//        // This function ensures that hashCodes that differ only by
//        // constant multiples at each bit position have a bounded
//        // number of collisions (approximately 8 at default load factor).
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    static int indexFor(int h, int length) {
//        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
//        return h & (length-1);
//    }
//
//
//     final Entry<K, V> getEntry(Object key){
//        //获取HashCode
//        int hash = (key == null) ?0:hash(key.hashCode());
//         //遍历所有的连上key等于这个的值
//         //在该Hash值对应的链表上找到键值等于key的值
//        for (Entry<K,V> e =table[indexFor(hash,table.length)];
//                e!= null ; e = e.next) {
//            Object k = null;
//            if (e.hash == hash && (key.equals(k))) {
//                return e;
//            }
//        }
//         return null;
//     }
//
//    V put2(K key, V value){
//        int hash = hash(key.hashCode());
//        int i = indexFor(hash,table.length);
//        for (Entry<K,V> e = table[i] ; e!= null; e = e.next){
//            Object k;
//            //如果该Key有对应的键值对，就用新的键值对取代旧的键值对
//            if (e.hash == hash && key.equals(k)){
//                V oldValue = e.value;
//                e.value = value;//更新
//                return oldValue;
//            }
//
//        }
//
//        AddEntry(hash,key,value,i);
//        return V;
//    }
//
//
//    void resize(int newCapacity) {
//        Entry<K,V>[] oldTable = table;
//        int oldCapacity = oldTable.length;
//        if (oldCapacity == MAXIMUM_CAPACITY) {
//            threshold = Integer.MAX_VALUE;
//            return;
//        }
//
//        Entry[] newTable = new Entry[newCapacity];
//
//        table = newTable;
//        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
//    }
//
//
//    void AddEntry(int hash , K key, V value , int bucketIndex){
//        Map.Entry<K,V> e =table[bucketIndex];//保存起来
//        table[bucketIndex ] = new Entry<K,V>(hash,key,value);
//
//        if (size++ >0){
//            resize(2* table.length);//扩容
//        }
//
//    }
//
//
//
//
//
//
//
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean containsKey(Object key) {
//        return false;
//    }
//
//    @Override
//    public boolean containsValue(Object value) {
//        return false;
//    }
//
//    @Override
//    public V get(Object key) {
//        return null;
//    }
//
//    @Override
//    public V put(K key, V value) {
//        return null;
//    }
//
//    @Override
//    public V remove(Object key) {
//        return null;
//    }
//
//    @Override
//    public void putAll(Map<? extends K, ? extends V> m) {
//
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public Set<K> keySet() {
//        return null;
//    }
//
//    @Override
//    public Collection<V> values() {
//        return null;
//    }
//
//    @Override
//    public Set<Entry<K, V>> entrySet() {
//        return null;
//    }
//
//    public V get
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//
//    }
//}
//
