package com.lia.Design;

import java.util.*;

/**
 * Implement a memcache which support the following features:

 get(curtTime, key). Get the key's value, return 2147483647 if key does not exist.
 set(curtTime, key, value, ttl). Set the key-value pair in memcache with a time to live (ttl). The key will be valid from curtTime to curtTime + ttl - 1 and it will be expired after ttl seconds. if ttl is 0, the key lives forever until out of memory.
 delete(curtTime, key). Delete the key.
 incr(curtTime, key, delta). Increase the key's value by delta return the new value. Return 2147483647 if key does not exist.
 decr(curtTime, key, delta). Decrease the key's value by delta return the new value. Return 2147483647 if key does not exist.
 It's guaranteed that the input is given with increasingcurtTime.

 * Created by liqu on 10/26/16.
 */
public class Memcache {
    private Map<Integer, Node> memcache;

    class Node {
        int curtTime;
        int value;
        int ttl;
        public Node(int curtTime, int value, int ttl) {
            this.curtTime = curtTime;
            this.value = value;
            this.ttl = ttl;
        }
    }

    public Memcache() {
        this.memcache = new HashMap<>();
    }

    private boolean validateKey(int curtTime, int key) {
        if (!memcache.containsKey(key)) return false;
        Node node = memcache.get(key);
        if (node.ttl != 0 && curtTime >= node.curtTime + node.ttl) {
            delete(curtTime, key);
            return false;
        }
        return true;
    }

    public int get(int curtTime, int key) {
        if (!validateKey(curtTime, key)) return Integer.MAX_VALUE;

        return memcache.get(key).value;
    }

    public void set(int curtTime, int key, int value, int ttl) {
        memcache.put(key, new Node(curtTime, value, ttl));
    }

    public void delete(int curtTime, int key) {
        if (memcache.containsKey(key)) memcache.remove(key);
    }

    public int incr(int curtTime, int key, int delta) {
        if (!validateKey(curtTime, key)) return Integer.MAX_VALUE;

        memcache.get(key).value += delta;
        return memcache.get(key).value;
    }

    public int decr(int curtTime, int key, int delta) {
        if (!validateKey(curtTime, key)) {
            return Integer.MAX_VALUE;
        }

        memcache.get(key).value -= delta;
        return memcache.get(key).value;

    }
}
