package com.learning.ay.basic.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestClass {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterate = list.iterator();
        while (iterate.hasNext()) {
            int nextNumber = iterate.next();
            if (nextNumber == 2) {
                list.add(3);
            }
            System.out.print(nextNumber);
        }
        System.out.println("Total Size : " + list.size());

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", 1);
        concurrentHashMap.put("b", 2);
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key == "b") concurrentHashMap.put("c", concurrentHashMap.get(key));
            System.out.println("Key " + key);
        }
        System.out.println("ConcurrentHashMap Size : " + concurrentHashMap.size());

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("abc", 123);
    }
}
