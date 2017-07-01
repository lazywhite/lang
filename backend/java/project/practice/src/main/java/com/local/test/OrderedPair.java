package com.local.test;

/**
 * Created by white on 16/8/29.
 */
public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value){
        this.key = key;
        this.value = value;

    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
