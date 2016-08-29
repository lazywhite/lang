package com.local.test;

/**
 * Created by white on 16/8/29.
 */
public class Util {
    public static <K, V> boolean compareTo(Pair<K, V> p1, Pair<K, V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}
