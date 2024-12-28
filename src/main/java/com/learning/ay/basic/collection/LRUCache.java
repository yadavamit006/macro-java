package com.learning.ay.basic.collection;

import java.util.*;

public class LRUCache {

    private final int initialCapacity;

    LinkedList<Integer> order = new LinkedList<>();
    HashMap<Integer, String> data = new HashMap<>();

    LRUCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }


    private void put(Integer key, String value) {
        if (order.size() >= initialCapacity) {
            int removedKey = order.removeLast();
            data.remove(removedKey);
        }
        order.addFirst(key);
        data.put(key, value);
    }

    private String get(Integer key) {
        String value = data.get(key);
        if (Objects.nonNull(value)) {
            order.remove(key);
            order.addFirst(key);
        } else {
            value = null;
        }
        return value;
    }

    public void display() {
        for (int i = 0; i < order.size(); i++) {
            int key = order.get(i);
            System.out.println("Key " + key + ", Value : " + data.get(key));
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.get(3);
        cache.get(2);
        cache.put(5, "Five");
        cache.put(1, "One");
        cache.display();
    }
}
