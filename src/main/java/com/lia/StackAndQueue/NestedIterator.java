package com.lia.StackAndQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqu on 5/15/16.
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        flat(nestedList, queue);
    }

    @Override
    public Integer next() {
        return queue.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void flat(List<NestedInteger> nestedList, LinkedList<Integer> queue) {
//        for (int i = 0; i < nestedList.size(); i++) {
//            if (nestedList.get(i).isInteger()){
//                queue.add(nestedList.get(i).getInteger());
//            } else {
//                flat(nestedList.get(i).getList(), queue);
//            }
//        }
        for (NestedInteger nestedInt : nestedList) {
            if (nestedInt.isInteger()) {
                queue.add(nestedInt.getInteger());
            } else {
                flat(nestedInt.getList(), queue);
            }
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}