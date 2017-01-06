package com.lia.Design;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Created by liqu on 10/8/16.
 */
public class LRUCache {
    private int size;
    private int capacity;
    private Map<Integer, Integer> map; // <key, value> pair for data
    private PriorityQueue<Data> pq; // least recently used data
    private Comparator<Data> dateTimeComparator = new Comparator<Data>() {
        @Override
        public int compare(Data d1, Data d2) {
            return d1.lastTime.compareTo(d2.lastTime);
        }
    };

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>(capacity, dateTimeComparator);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            /* Update Data(key)'s time */
            pq.remove(new Data(key));
            pq.add(new Data(key));
        }
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            /* Update Data(key)'s time */
            pq.remove(new Data(key));
            pq.add(new Data(key));
        } else {
            /* Remove LRU */
            while (size >= capacity) {
                map.remove(pq.poll().key);
                size--;
            }
            map.put(key, value);
            pq.add(new Data(key));
            size++;
        }
    }

    class Data{
        int key;
        LocalDateTime lastTime; // last time used
        public Data(int key) {
            this.key = key;
            this.lastTime = LocalDateTime.now();
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof  Data)) return false;
            Data data = (Data) o;
            return this.key == data.key;
        }
    }

    public static void main(String[] args) throws java.lang.InterruptedException{
        LRUCache lru = new LRUCache(10);

        lru.set(10,13);
        lru.set(3,17);
        lru.set(6,11);
        lru.set(10,5);
        lru.set(9,10);
        System.out.println("get: " + lru.get(13));
        lru.set(2,19);
        System.out.println("get: " + lru.get(2));
        System.out.println("get: " + lru.get(3));
        lru.set(5,25);
        System.out.println("get: " + lru.get(8));
        lru.set(9,22);
        lru.set(5,5);
        lru.set(1,30);
        System.out.println("get: " + lru.get(11));
        lru.set(9,12);
        System.out.println("get: " + lru.get(7));
        System.out.println("get: " + lru.get(5));
        System.out.println("get: " + lru.get(8));
        System.out.println("get: " + lru.get(9));
        lru.set(4,30);
        lru.set(9,3);
        System.out.println("get: " + lru.get(9));
        System.out.println("get: " + lru.get(10));
        System.out.println("get: " + lru.get(10));
        lru.set(6,14);
        lru.set(3,1);
        System.out.println("get: " + lru.get(3));
        lru.set(10,11);
        System.out.println("get: " + lru.get(8));
        lru.set(2,14);
        System.out.println("get: " + lru.get(1));
        System.out.println("get: " + lru.get(5));
        System.out.println("get: " + lru.get(4));
        lru.set(11,4);
        lru.set(12,24);
        lru.set(5,18);
        System.out.println("get: " + lru.get(13));
        lru.set(7,23);
        System.out.println("get: " + lru.get(8));
        System.out.println("get: " + lru.get(12));
        lru.set(3,27);
        lru.set(2,12);
        System.out.println("get: " + lru.get(5));
        lru.set(2,9);
        lru.set(13,4);
        lru.set(8,18);
        lru.set(1,7);
        System.out.println("get: " + lru.get(6));
        lru.set(9,29);
        lru.set(8,21);
        System.out.println("get: " + lru.get(5));
        lru.set(6,30);
        lru.set(1,12);
        System.out.println("get: " + lru.get(10));
        lru.set(4,15);
        lru.set(7,22);
        lru.set(11,26);
        lru.set(8,17);
        lru.set(9,29);
        System.out.println("get: " + lru.get(5));
        lru.set(3,4);
        lru.set(11,30);
        System.out.println("get: " + lru.get(12));
        lru.set(4,29);
        System.out.println("get: " + lru.get(3));
        System.out.println("get: " + lru.get(9));
        System.out.println("get: " + lru.get(6));
        lru.set(3,4);
        System.out.println("get: " + lru.get(1));
        System.out.println("get: " + lru.get(10));
        lru.set(3,29);
        lru.set(10,28);
        lru.set(1,20);
        lru.set(11,13);
        System.out.println("get: " + lru.get(3));
        lru.set(3,12);
        lru.set(3,8);
        lru.set(10,9);
        lru.set(3,26);
        System.out.println("get: " + lru.get(8));
        System.out.println("get: " + lru.get(7));
        System.out.println("get: " + lru.get(5));
        lru.set(13,17);
        lru.set(2,27);
        lru.set(11,15);
        System.out.println("get: " + lru.get(12));
        lru.set(9,19);
        lru.set(2,15);
        lru.set(3,16);
        System.out.println("get: " + lru.get(1));
        lru.set(12,17);
        lru.set(9,1);
        lru.set(6,19);
        System.out.println("get: " + lru.get(4));
        System.out.println("get: " + lru.get(5));
        System.out.println("get: " + lru.get(5));
        lru.set(8,1);
        lru.set(11,7);
        lru.set(5,2);
        lru.set(9,28);
        System.out.println("get: " + lru.get(1));
        lru.set(2,2);
        lru.set(7,4);
        lru.set(4,22);
        lru.set(7,24);
        lru.set(9,26);
        lru.set(13,28);
        lru.set(11,26);
        //set(4,15),set(7,22),set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)]
        //Thread.sleep(500);

        //System.out.println("get: " + lru.get(2));


        //System.out.println("size: " + lru.size  + ", pq size: " + lru.pq.size() + ", map size: " + lru.map.size());
//        for (Data d : lru.pq) {
//            System.out.println("key: " + d.key + ", value: " + d.value + ", time: " + d.lastTime);
//        }


    }
}
