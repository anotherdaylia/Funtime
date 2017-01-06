package com.lia.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqu on 10/25/16.
 */
public class LRUCacheDL {

    private int size;
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCacheDL(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);
            size++;

            if (size > capacity) {
                Node tail = popTail();

                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        if (next != null) next.prev = prev;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        if (head.next != null) head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }


    private Node popTail(){
        Node prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}
