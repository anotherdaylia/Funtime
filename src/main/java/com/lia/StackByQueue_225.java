package com.lia;
import java.util.LinkedList;
/**
 * Created by liqu on 2/18/16.
 */
public class StackByQueue_225 {
    LinkedList<Integer> list = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        list.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        list.removeLast();
    }

    // Get the top element.
    public int top() {
        return list.getLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list.isEmpty();
    }
}
